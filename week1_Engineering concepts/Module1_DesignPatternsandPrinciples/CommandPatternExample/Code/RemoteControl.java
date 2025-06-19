package Module1_DesignPatternsandPrinciples.CommandPatternExample.Code;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}

// This is the Invoker — it triggers a command.
// You can plug in any command using setCommand().
// Then, pressButton() will run whatever command is set.
// It doesn’t care if the command turns on lights, fans, TVs — it just calls execute().

