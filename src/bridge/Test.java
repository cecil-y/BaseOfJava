package bridge;

public class Test {

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

//        调用第一个对象
        Sourceable sourceable1 = new SourceSub1();
        bridge.setSourceable(sourceable1);
        bridge.method();

//        调用第二个对象
        Sourceable sourceable2 = new SourceSub2();
        bridge.setSourceable(sourceable2);
        bridge.method();
    }
}
