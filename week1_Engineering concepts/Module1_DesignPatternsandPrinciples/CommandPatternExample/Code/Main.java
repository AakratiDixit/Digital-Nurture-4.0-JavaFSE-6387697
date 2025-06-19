package Module1_DesignPatternsandPrinciples.CommandPatternExample.Code;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        System.out.println("Turning the light ON:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\nTurning the light OFF:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

// This is the Client — it sets everything up.

// Steps:
// Creates the Light (receiver).
// Wraps light actions in commands (LightOnCommand, LightOffCommand).
// Gives a command to the RemoteControl (invoker).
// Presses the button — and boom, the command executes!

// Think of a remote control (Invoker) sending signals (commands) to a TV (Receiver). You can plug different commands (like volume up, channel change, power on/off) into the same remote.


// We want to decouple the RemoteControl (Invoker) from the actual device (Light - Receiver).
// Decoupled:
// You have a universal remote — you program it using codes (commands). The remote doesn’t care if it’s a Samsung or LG; it just sends a signal. That signal is the Command.