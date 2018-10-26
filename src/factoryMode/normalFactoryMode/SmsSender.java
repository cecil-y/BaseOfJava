package factoryMode.normalFactoryMode;

//第二步：创建实现类
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("This is sms sender!");
    }
}
