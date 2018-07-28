# Read me

控制台试验项目。

试验方式：
在 *labs* 目录下新建测试类，实现 `Lab` 接口。在 `Program.main()` 中调用测试类的 `run()` 方法。

结构：
* functions : 目标要测试的类
* labs      : 存放`Lab`接口的实现类，调用functions类

试验：
* DemoLab   : 试验示例类
* FlowerLab : 试验在类构造器中通过`this`调用其他构造器
* GarbageLab    : 观察垃圾收集器的回收
* InitializeLab : 观察类成员的初始化次序（先按定义的次序初始化，再调用构造器的初始化）