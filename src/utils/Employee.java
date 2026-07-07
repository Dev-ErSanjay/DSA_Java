package utils;

public class Employee {

    private String empId;
    private String name;
    private String department;
    private Double score;
    private int salary;

    public Employee(String empId, String name, String department, int salary) {

        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String empId, String name, String department, Double score, int salary) {

        this.empId = empId;
        this.name = name;
        this.department = department;
        this.score = score;
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

    public Double getScore() {
        return score;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return empId + " " + name + " " + department + " " + score + " " + salary;
    }

}
