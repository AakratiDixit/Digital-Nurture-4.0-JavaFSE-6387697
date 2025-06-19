package Module1_DesignPatternsandPrinciples.DecoratorPatternExample.Code;

public class Main {
    public static void main(String[] args) {

        // Simple Email Notification
        Notifier notifier = new EmailNotifier();

        // Adding SMS Notification
        notifier = new SMSNotifierDecorator(notifier);

        // Adding Slack Notification
        notifier = new SlackNotifierDecorator(notifier);

        // Send all notifications
        notifier.send();
    }
}

// Pehle tumne sirf Email Notifier ka object banaya.
// Fir tumne SMS Notifier decorator lagaya.
// Fir tumne Slack Notifier decorator lagaya.

// Ab jab notifier.send() call hua:
// Pehle Email bheja.
// Fir SMS bheja.
// Fir Slack bheja.