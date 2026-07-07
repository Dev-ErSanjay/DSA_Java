package utils;

public class Employee {

    private String empId;
    private String name;
    private String department;
    private int salary;

    public Employee(String empId, String name, String department, int salary) {

        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return empId + " " + name + " " + department + " " + salary;
    }

}
