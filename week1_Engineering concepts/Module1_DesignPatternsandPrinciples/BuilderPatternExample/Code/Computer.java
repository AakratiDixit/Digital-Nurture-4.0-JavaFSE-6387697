package Module1_DesignPatternsandPrinciples.BuilderPatternExample.Code;

public class Computer {

    //Attributes of Computer
    private String CPU;
    private String RAM;
    private String Storage;
    private String GPU;

    //Private constructor - accessed via Builder only
    private Computer(Builder builder){
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GPU = builder.GPU;
    }

    //Display method to show configuration
    public void displayConfiguration(){
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + Storage);
        System.out.println("GPU: " + GPU);
        System.out.println("----------------------");
    }

    //Builder Class
    public static class Builder{
        private String CPU;
        private String RAM;
        private String Storage;
        private String GPU;
    

        //Setter methods for each attributes
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
            //Is Builder class ka current object wapas bhejna
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        //Computer class ka object bana rahe hain.
        public Computer build() {
        return new Computer(this);
        }

    }

}
