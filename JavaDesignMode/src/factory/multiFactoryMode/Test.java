package factory.multiFactoryMode;

import factory.normalFactoryMode.Sender;

public class Test {
    public static void main(String[] args){
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();
    }
}
