package factory.staticFactoryMode;

import factory.normalFactoryMode.Sender;

public class Test {
    public static void main(String[] args){
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
