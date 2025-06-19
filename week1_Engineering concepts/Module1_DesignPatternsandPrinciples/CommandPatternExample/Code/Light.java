package Module1_DesignPatternsandPrinciples.CommandPatternExample.Code;

public class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// This is the Receiver — the real object that knows how to perform the action.
// It has the actual logic: printing ON/OFF.
// Commands like LightOnCommand and LightOffCommand tell it what to do.

