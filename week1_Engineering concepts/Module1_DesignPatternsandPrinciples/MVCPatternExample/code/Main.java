package Module1_DesignPatternsandPrinciples.MVCPatternExample.code;

public class Main {
    public static void main(String[] args) {
        // Create model
        Student student = new Student("Alice", "101", "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update model using controller
        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        // Display updated details
        controller.updateView();
    }
}

