import java.util.HashMap;

public class Department {
    private String deptCode;
    private String deptName;
    private double deptTotalSalary;
    private HashMap<String, Employee> employees;

    public Department() {
        employees = new HashMap<>();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getDeptTotalSalary() {
        return deptTotalSalary;
    }

    public void setDeptTotalSalary(double deptTotalSalary) {
        this.deptTotalSalary = deptTotalSalary;
    }

    public HashMap<String, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(HashMap<String, Employee> employees) {
        this.employees = employees;
    }
}