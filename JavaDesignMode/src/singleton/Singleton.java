package singleton;

public class Singleton {

    //    持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
    private static Singleton instance = null;

    //    私有构造方法，防止被实例化
    private Singleton() {

    }

    //    静态工程方法，创建实例
//    加上synchroinzed线程锁能够在多线程的环境下不出错
//    但是，synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁，事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了
//    似乎解决了之前提到的问题，将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升。
//    但是，这样的情况，还是有可能有问题的，看下面的情况：在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句是分两步执行的。
//    但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，然后再去初始化这个Singleton实例。
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (instance) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//  采用以下方法优化
//    实际情况是，单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }
//    其实说它完美，也不一定，如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适合自己应用场景的实现方法。

    //    如果该对象被用于序列化，可以保证对象在序列化前后保持一致
    public Object readResolve() {
        return instance;
    }

}
