package Module1_DesignPatternsandPrinciples.ProxyPatternExample.code;

public interface image {
    void display();
}
//Every image (real or proxy) should have a display method.






// What is happening?
// You are creating two objects:

// RealImage – the actual heavy object (like loading a big image from disk).actual high-quality image
// ProxyImage – a lightweight representative that controls access to RealImage.album cover

// The idea is:
// 🔹 Don't load the real image immediately.
// 🔹 Load it only when you really need to display it.
