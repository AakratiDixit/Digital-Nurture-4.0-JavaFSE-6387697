package Module1_DesignPatternsandPrinciples.DecoratorPatternExample.Code;


public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send() {
        super.send(); // first send previous notifications
        System.out.println("Sending Slack Notification");
    }
}
