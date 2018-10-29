package proxy;

public class Proxy implements Sourceable {

    private Source source;

    //代理模式在方法内new对象，装饰模式通过传参的方式传入需要被装饰的对象
    public Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void after(){
        System.out.println("after proxy!");
    }

    private void before(){
        System.out.println("before proxy!");
    }
}
