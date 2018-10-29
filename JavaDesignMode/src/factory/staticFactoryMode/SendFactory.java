package factory.staticFactoryMode;

import factory.normalFactoryMode.MailSender;
import factory.normalFactoryMode.Sender;
import factory.normalFactoryMode.SmsSender;

public class SendFactory {
    public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }
}
