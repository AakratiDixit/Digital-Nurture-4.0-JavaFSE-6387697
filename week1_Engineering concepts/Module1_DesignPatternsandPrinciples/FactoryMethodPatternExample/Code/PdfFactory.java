package Module1_DesignPatternsandPrinciples.FactoryMethodPatternExample.Code;

public class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

