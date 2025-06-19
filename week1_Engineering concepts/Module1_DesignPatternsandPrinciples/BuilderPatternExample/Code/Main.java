package Module1_DesignPatternsandPrinciples.BuilderPatternExample.Code;

public class Main {
    public static void main(String[] args) {

        // First Computer Configuration
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 4090")
                .build();

        System.out.println("Gaming PC configuration:\n");
        gamingPC.displayConfiguration();

        // Second Computer Configuration
        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                // GPU not provided (optional)
                .build();

        System.out.println("Office PC configuration:\n");
        officePC.displayConfiguration();
    }
}

// Pehle Builder ka object banta hai: new Computer.Builder()
// Builder object ke saath methods chain karte hain: .setCPU(), .setRAM()
// Jab sab kuch set ho jaata hai, tab final Computer object banta hai: .build()

//Direct Computer ka object ban hi nahi sakta kyunki Computer ka constructor private hai.

//Real life example
// Pizza pizza = new PizzaBuilder()
//                 .setCheese("Mozzarella")
//                 .setToppings("Paneer")
//                 .setSize("Large")
//                 .build();
// Tum directly Pizza nahi bana sakti ho kyunki tumhara Pizza bana hi tab sakta hai jab saare ingredients ready ho.
// Yahi builder pattern ka logic hai.
