package Module1_DesignPatternsandPrinciples.FactoryMethodPatternExample.Code;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document.");
    }
}
