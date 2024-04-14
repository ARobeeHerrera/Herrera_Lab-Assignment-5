import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
    private HashMap<String, Department> deptMap;
    private EmployeeDA employeeDA;

    public HashMap<String, Department> getDeptMap() {
        return deptMap;
    }

    public void setDeptMap(HashMap<String, Department> deptMap) {
        this.deptMap = deptMap;
    }

    public DepartmentDA() throws FileNotFoundException {
        this.employeeDA = new EmployeeDA();
        deptMap = new HashMap<>();
        try (Scanner departmentFileReader = new Scanner(new FileReader("D:\\OOPRobs\\Lab-Assignment 5\\src\\dep.csv"))) {
            while (departmentFileReader.hasNextLine()) {
                String line = departmentFileReader.nextLine();
                String[] depInfo = line.split(",");
                Department department = new Department();
                department.setDeptCode(depInfo[0].trim());
                department.setDeptName(depInfo[1].trim());

                employeeDepartment(department);
                toPrint(department);

                deptMap.put(department.getDeptCode(), department);
            }
        }
    }

    private void employeeDepartment(Department department) throws FileNotFoundException {
        try (Scanner deptEmpFile = new Scanner(new FileReader("D:\\OOPRobs\\Lab-Assignment 5\\src\\depttemp.csv"))) {
            while (deptEmpFile.hasNextLine()) {
                String line = deptEmpFile.nextLine();
                String[] deptEmpInfo = line.split(",");
                if (deptEmpInfo[0].trim().equals(department.getDeptCode())) {
                    String empNo = deptEmpInfo[1].trim();
                    Employee employee = employeeDA.getEmployees().get(empNo);
                    if (employee != null) {
                        employee.setSalary(Double.parseDouble(deptEmpInfo[2]));
                        department.getEmployees().put(empNo, employee);
                        department.setDeptTotalSalary(department.getDeptTotalSalary() + employee.getSalary());
                    }
                }
            }
        }
    }

    public void toPrint(Department department) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Department Code: " + department.getDeptCode());
        System.out.println("Department Name: " + department.getDeptName());
        System.out.println("Department Total Salary: " + df.format(department.getDeptTotalSalary()));
        System.out.println("---------------------Details--------------------------");
        System.out.printf("%-11s\t %-25s\t %s\n", "EmpNo", "Employee Name", "Salary");
        for (Map.Entry<String, Employee> employeeEntry : department.getEmployees().entrySet()) {
            Employee employee = employeeEntry.getValue();
            System.out.printf("%-11s\t %-25s\t %s\n", employee.getEmpNo(),
                    employee.getLastName() + ", " + employee.getFirstName(), df.format(employee.getSalary()));
        }
        System.out.println();
    }
}
