package Module1_DesignPatternsandPrinciples.ProxyPatternExample.code;

public class Main {
    public static void main(String[] args) {

        image image1 = new ProxyImage("photo1.jpg");
        image image2 = new ProxyImage("photo2.jpg");

        // First time - image will be loaded
        image1.display();
        System.out.println();

        // Second time - image is already loaded (cached)
        image1.display();
        System.out.println();

        // First time - image will be loaded
        image2.display();
    }
}

// image.display();  // Loads image from disk and displays it
// image.display();  // Displays without loading again
// First display():
//   Proxy checks → no RealImage → creates it → loads it → displays it.
// Second display():
//   Proxy skips loading → directly displays → saves time.






