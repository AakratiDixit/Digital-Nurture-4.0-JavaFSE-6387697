package Module1_DesignPatternsandPrinciples.DecoratorPatternExample.Code;

public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
        //to call the constructor of the parent class
    }

    @Override
    public void send() {
        super.send(); // first send previous notifications
        System.out.println("Sending SMS Notification");
    }
}
