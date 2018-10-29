package factory.multiFactoryMode;

import factory.normalFactoryMode.MailSender;
import factory.normalFactoryMode.Sender;
import factory.normalFactoryMode.SmsSender;

public class SendFactory {
    public Sender produceMail(){
        return new MailSender();
    }
    public Sender produceSms(){
        return new SmsSender();
    }
}
