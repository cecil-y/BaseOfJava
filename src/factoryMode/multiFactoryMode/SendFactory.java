package factoryMode.multiFactoryMode;

import factoryMode.normalFactoryMode.MailSender;
import factoryMode.normalFactoryMode.Sender;
import factoryMode.normalFactoryMode.SmsSender;

public class SendFactory {
    public Sender produceMail(){
        return new MailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }
}
