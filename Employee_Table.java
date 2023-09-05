import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String empID;
    private String name;
    private int age;
    private double salary;

    public Employee(String empID, String name, int age, double salary) {
        this.empID = empID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeDatabase {
    private List<Employee> employees;

    public EmployeeDatabase() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> searchByAge(int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() == age) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchBySalary(String operator, double salary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if ((operator.equals(">") && employee.getSalary() > salary) ||
                (operator.equals("<") && employee.getSalary() < salary) ||
                (operator.equals(">=") && employee.getSalary() >= salary) ||
                (operator.equals("<=") && employee.getSalary() <= salary)) {
                result.add(employee);
            }
        }
        return result;
    }
}

public class Employee_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name :- Deshmukh Nikhil Dipak \n Enroll No:- E22CSEU1099");
        EmployeeDatabase database = new EmployeeDatabase();

        database.addEmployee(new Employee("161E90", "Raman", 41, 56000));
        database.addEmployee(new Employee("161F91", "Himadri", 38, 67500));
        database.addEmployee(new Employee("161F99", "Jaya", 51, 82100));
        database.addEmployee(new Employee("171E20", "Tejas", 30, 55000));
        database.addEmployee(new Employee("171G30", "Ajay", 45, 44000));

        while (true) {
            System.out.println("\nSearch Options:");
            System.out.println("1. Search by Age");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Salary (>, <, <=, >=)");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1/2/3/4): ");
            String choice = scanner.nextLine();

            List<Employee> result = new ArrayList<>();
            switch (choice) {
                case "1":
                    System.out.print("Enter age to search: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    result = database.searchByAge(age);
                    break;
                case "2":
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    result = database.searchByName(name);
                    break;
                case "3":
                    System.out.print("Enter operator (>, <, <=, >=): ");
                    String operator = scanner.nextLine();
                    System.out.print("Enter salary to search: ");
                    double searchSalary = Double.parseDouble(scanner.nextLine());
                    result = database.searchBySalary(operator, searchSalary);
                    break;
                case "4":
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (result.isEmpty()) {
                System.out.println("No matching records found.");
            } else {
                System.out.println("\nMatching records:");
                for (Employee employee : result) {
                    System.out.println("Employee ID: " + employee.getEmpID() +
                            ", Name: " + employee.getName() +
                            ", Age: " + employee.getAge() +
                            ", Salary: " + employee.getSalary());
                }
            }
        }
    }
}
