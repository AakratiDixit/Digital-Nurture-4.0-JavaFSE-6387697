package Module1_DesignPatternsandPrinciples.ProxyPatternExample.code;

public class ProxyImage implements image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // lazy loading
        }
        realImage.display();
    }
}

// First time: it creates RealImage (loads from disk).
// Next time: it skips loading, just shows the image.