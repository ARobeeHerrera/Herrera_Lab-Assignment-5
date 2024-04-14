import java.io.FileNotFoundException;

public class DepartmentReport {
    public static void main(String[] args) {
        try {
            new DepartmentDA();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();
        }
    }
}