package cn.evilmoon.consolelab;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

class ClassHelper {

    /**
     * 获取指定包下面所有实现了指定接口的类
     * @param iClass 接口的名称
     * @param packageName 类所在的包名
     * @return 类列表
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    static ArrayList<Class> getAllClassByInterface(Class iClass, String packageName) {
        ArrayList<Class> list = new ArrayList<>();
        // 判断是否是一个接口
        if (iClass.isInterface()) {
            try {
                ArrayList<Class> allClass = getAllClass(packageName);

                // 循环判断路径下的所有类是否实现了指定的接口 并且排除接口类自己
                for (Class cls: allClass) {
                    // isAssignableFrom:判定此 Class 对象所表示的类或接口与指定的 Class
                    // 参数所表示的类或接口是否相同，或是否是其超类或超接口
                    // 判断是不是同一个接口
                    if (iClass.isAssignableFrom(cls) && !iClass.equals(cls))
                        list.add(cls);
                }
            } catch (Exception e) {
                System.out.println("出现异常");
            }
        }
        return list;
    }

    /**
     * 从一个指定路径下查找所有的类
     *
     * @param packagename 要查找类的所在包名
     */
    @SuppressWarnings("rawtypes")
    private static ArrayList<Class> getAllClass(String packagename) {
        ArrayList<Class> list = new ArrayList<>();
        // 返回对当前正在执行的线程对象的引用。
        // 返回该线程的上下文 ClassLoader。
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packagename.replace('.', '/');
        try {
            ArrayList<File> fileList = new ArrayList<>();
            /*
             * 这里面的路径使用的是相对路径 如果大家在测试的时候获取不到，请理清目前工程所在的路径 使用相对路径更加稳定！
             * 另外，路径中切不可包含空格、特殊字符等！
             */
            // getResources:查找所有给定名称的资源
            // 获取jar包中的实现类:Enumeration<URL> enumeration =
            // classLoader.getResources(path);
            Enumeration<URL> enumeration = classLoader.getResources(path);
            while (enumeration.hasMoreElements()) {
                URL url = enumeration.nextElement();
                // 获取此 URL 的文件名
                fileList.add(new File(url.getFile()));
            }
            for (File f : fileList) {
                list.addAll(findClass(f, packagename));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 如果file是文件夹，则递归调用findClass方法，或者文件夹下的类 如果file本身是类文件，则加入list中进行保存，并返回
     *
     * @param file 要扫描的文件或文件夹
     * @param packagename 包名
     * @return 类列表
     */
    @SuppressWarnings("rawtypes")
    private static ArrayList<Class> findClass(File file, String packagename) {
        ArrayList<Class> list = new ArrayList<>();
        if (!file.exists()) {
            return list;
        }
        // 返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
        File[] files = file.listFiles();
        if (files == null || files.length == 0) return list;

        for (File f : files) {

            if (f.isDirectory()) {
                // assert !file2.getName().contains(".");// 添加断言用于判断
                if (!f.getName().contains(".")) {
                    ArrayList<Class> arrayList = findClass(f, packagename + "." + f.getName());
                    list.addAll(arrayList);
                }
            } else if (f.getName().endsWith(".class")) {
                try {
                    // 保存的类文件不需要后缀.class
                    list.add(Class.forName(packagename + '.' + f.getName().substring(0, f.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
