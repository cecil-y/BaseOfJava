package abstractFactoryMode;

public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("This is mailSender");
    }
}
