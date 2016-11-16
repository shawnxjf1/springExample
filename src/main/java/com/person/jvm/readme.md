##jvm
jvm是java学习很大一块，这里代码用来获取jvm信息（比如看了周志明的书，自己在这里写代码测试）。

## dynamic class loader
参考自：https://en.wikipedia.org/wiki/Java_Classloader
This makes it possible (for example):

to load or unload classes at runtime (for example to load libraries dynamically at runtime, even from an HTTP resource). This is an important feature for:
implementing scripting languages, such as Jython
using bean builders
allowing user-defined extensibility
allowing multiple namespaces to communicate. This is one of the foundations of CORBA / RMI protocols for example.
to change the way the bytecode is loaded (for example, it is possible to use encrypted Java class bytecode[7]).
to modify the loaded bytecode (for example, for load-time weaving of aspects when using aspect-oriented programming).