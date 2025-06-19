package Module1_DesignPatternsandPrinciples.CommandPatternExample.Code;

public interface Command {
    void execute();
}

// This allows the remote control to run any command without knowing what it does.