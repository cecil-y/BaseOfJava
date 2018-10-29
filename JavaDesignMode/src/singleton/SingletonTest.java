package singleton;

public class SingletonTest {

    //    也有人这样实现：因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的
    private static SingletonTest instance = null;

    private static synchronized void syncInit(){
        if(instance == null){
            instance = new SingletonTest();
        }
    }

    public static SingletonTest getInstance(){
        if(instance == null){
            syncInit();
        }
        return instance;
    }


}
