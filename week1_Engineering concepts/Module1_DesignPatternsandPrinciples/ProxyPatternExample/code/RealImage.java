package Module1_DesignPatternsandPrinciples.ProxyPatternExample.code;

public class RealImage implements image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display(){
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

//When called, it displays and loads from disk.
