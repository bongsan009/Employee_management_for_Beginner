import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee
{
    private String name;
    private String jobTitle;
    private double salary;

    //Default Constructor
    Employee(){}

    //Params Constructor
    Employee(String name, String jobTitle, double salary)
    {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    //Encapsulation
    public void setName(String name)
    {
        this.name = name;
    }
    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getName(){return this.name;}
    public String getJobTitle(){return  this.jobTitle;}
    public double getSalary(){return this.salary;}

    @Override
    public String toString() {
        return name + "\t\t\t" + jobTitle + "\t\t\t" + salary;
    }
}

class EmployeeService
{
    List<Employee> empList = new ArrayList<Employee>();

    public List<Employee> getEmpList()
    {
        return empList;
    }

    public void raiseSalaryByPercent(Scanner in)
    {
        System.out.println("Enter employee name to raise their salary :: ");
        String name = in.nextLine();
        Employee empToRaiseSalary = null;
     for (Employee emp : empList)
     {
         if (emp.getName().equals(name))
         {
             empToRaiseSalary = emp;
             break;
         }
     }
     if (empToRaiseSalary != null)
     {
         System.out.println(empToRaiseSalary);
         System.out.print("How many percent(%) do you wanna to increase of their own salary ? :: ");
         double percentage = in.nextDouble();

         double salary = empToRaiseSalary.getSalary();
         salary = salary + salary * percentage / 100;
         empToRaiseSalary.setSalary(salary);
         System.out.println("The employee has been increase his salary successfully.");
     }else {
         System.out.println("Sorry, the employee name not found in the list!");
     }
    }

    public void displayEmployee()
    {
        for (Employee emp : empList)
        {
            System.out.println(emp);
        }
    }

    public void addEmployee(Employee emp)
    {
        empList.add(emp);
    }
}

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        boolean programOn = true;

        do {
            menu();
            System.out.print("Enter the option above :: ");
            int userOpt = in.nextInt(); in.nextLine();

            switch (userOpt)
            {
                case 1:
                {
                    System.out.print("Enter Name   :: "); String name = in.nextLine();
                    System.out.print("Enter Job    :: "); String job = in.nextLine();
                    System.out.print("Enter Salary :: "); double salary = in.nextDouble(); in.nextLine();

                    Employee newEmp = new Employee(name, job, salary);
                    employeeService.addEmployee(newEmp);
                    break;
                }

                case 2:
                {
                    printHeader();
                    employeeService.displayEmployee();
                    break;
                }

                case 3:
                {
                    employeeService.raiseSalaryByPercent(in);
                    break;
                }

                case 4:
                {
                    System.exit(0);
                }
            }
        }while (programOn);

    }
    public static void menu()
    {
        System.out.println("1). Add Employee.");
        System.out.println("2). Display All Employees.");
        System.out.println("3). Raise their salary.");
        System.out.println("4). Exit");
    }
    public static void printHeader()
    {
        System.out.format("%s %15s %15s\n", "Name", "Job", "Salary");
    }
}