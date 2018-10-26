package factoryMode.staticFactoryMode;

import factoryMode.normalFactoryMode.MailSender;
import factoryMode.normalFactoryMode.Sender;
import factoryMode.normalFactoryMode.SmsSender;

public class SendFactory {
    public static Sender produceMail(){
        return new MailSender();
    }
    public static Sender produceSms(){
        return new SmsSender();
    }
}
