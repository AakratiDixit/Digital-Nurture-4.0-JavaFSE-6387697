package Module1_DesignPatternsandPrinciples.CommandPatternExample.Code;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}


// It takes a Light object (receiver).
// When execute() is called, it calls light.turnOn().
// It’s like:
// "When someone tells me to execute, I’ll go turn on the light!

