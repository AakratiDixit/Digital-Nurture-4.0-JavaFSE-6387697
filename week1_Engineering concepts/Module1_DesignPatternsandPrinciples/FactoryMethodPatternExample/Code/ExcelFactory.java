package Module1_DesignPatternsandPrinciples.FactoryMethodPatternExample.Code;

public class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

