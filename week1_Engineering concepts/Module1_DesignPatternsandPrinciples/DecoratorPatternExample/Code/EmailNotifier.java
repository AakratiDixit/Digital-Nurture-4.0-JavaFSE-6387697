package Module1_DesignPatternsandPrinciples.DecoratorPatternExample.Code;

public class EmailNotifier implements Notifier {

    @Override
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
