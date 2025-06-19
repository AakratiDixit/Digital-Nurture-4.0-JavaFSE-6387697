package Module1_DesignPatternsandPrinciples.FactoryMethodPatternExample.Code;

public class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

