# Read me

控制台试验项目。

## 试验方式：
在 *labs* 目录下新建测试类，实现 `Lab` 接口。
为 `Lab` 实现类应用 `Execute` 注解，指定一个时间，
`Program.main` 中获取注解时间最大的一个进行运行。

## 项目结构：
* functions     : 目标要测试的类
* labs          : 存放`Lab`接口的实现类，调用functions类

## 试验：
* DemoLab       : 试验示例类
* FlowerLab     : 试验在类构造器中通过`this`调用其他构造器
* GarbageLab    : 观察垃圾收集器的回收
* InitializeLab : 观察类成员的初始化次序（先按定义的次序初始化，再调用构造器的初始化）
* FigureLab     : Java 计算超大数据值
* TypeConvert   : Java 主类型、Date类型和String的转换