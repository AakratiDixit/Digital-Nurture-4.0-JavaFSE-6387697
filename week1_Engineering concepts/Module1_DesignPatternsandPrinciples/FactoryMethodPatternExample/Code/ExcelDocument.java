package Module1_DesignPatternsandPrinciples.FactoryMethodPatternExample.Code;

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Document.");
    }
}