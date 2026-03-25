import java.util.*;

// Employee Class
class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Dept: " + department + ", Salary: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return this.id == e.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// Manager Class
class EmployeeManager {
    private Map<Integer, Employee> employeeMap = new HashMap<>();

   
    public void addEmployee(Employee emp) {
        if (employeeMap.containsKey(emp.id)) {
            System.out.println(" Employee already exists!");
        } else {
            employeeMap.put(emp.id, emp);
            System.out.println("Employee added.");
        }
    }

    public void updateEmployee(int id, String name, String dept, double salary) {
        Employee emp = employeeMap.get(id);
        if (emp == null) {
            System.out.println(" Employee not found!");
            return;
        }
        emp.name = name;
        emp.department = dept;
        emp.salary = salary;
        System.out.println(" Employee updated.");
    }

    
    public void deleteEmployee(int id) {
        if (employeeMap.remove(id) != null) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println(" Employee not found!");
        }
    }


    public void searchEmployee(int id) {
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println(" Employee not found!");
        }
    }


    public void displayAll() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }
        for (Employee emp : employeeMap.values()) {
            System.out.println(emp);
        }
    }

    public void displaySortedBySalary() {
        List<Employee> list = new ArrayList<>(employeeMap.values());
        list.sort(Comparator.comparingDouble(e -> e.salary));

        System.out.println("Employees sorted by salary:");
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

  
    public void displayUniqueEmployees() {
        Set<Employee> set = new HashSet<>(employeeMap.values());
        System.out.println(" Unique Employees:");
        for (Employee emp : set) {
            System.out.println(emp);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Sort by Salary");
            System.out.println("7. Show Unique Employees");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    manager.addEmployee(new Employee(id, name, dept, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter new Department: ");
                    dept = sc.nextLine();

                    System.out.print("Enter new Salary: ");
                    salary = sc.nextDouble();

                    manager.updateEmployee(id, name, dept, salary);
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextInt();
                    manager.deleteEmployee(id);
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    manager.searchEmployee(id);
                    break;

                case 5:
                    manager.displayAll();
                    break;

                case 6:
                    manager.displaySortedBySalary();
                    break;

                case 7:
                    manager.displayUniqueEmployees();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}