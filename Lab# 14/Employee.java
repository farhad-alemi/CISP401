import java.util.*;

// abstract class for holding the employee name, employee
// wage, and static variable employee count
abstract class Employee
{
    private String empName;
    private double empWage;
    static int empCount;
    static final double REGULAR_HOURS_LIMIT = 40;

    {
        empCount++;
    }

    // this method increases employee wages by the
    // specific percentage
    void increaseEmpWage(double increasePerc)
    {
        empWage += increasePerc / 100 * empWage;
    }

    // returns employee name
    String getEmpName()
    {
        return empName;
    }

    // returns employee hourly-wage
    double getEmpWage()
    {
        return empWage;
    }

    // sets employee name
    void setEmpName(String empName)
    {
        this.empName = empName;
    }

    // sets employee wage
    void setEmpWage(double empWage)
    {
        this.empWage = empWage;
    }

    // abstract method for computing employee pay
    abstract double computePay(double hoursWorked);

    // overridden method which displays employee name
    void display()
    {
        System.out.print(getEmpName());
    }
}

// subclass which extends employee; it also defines the
// computePay() function besides overriding the display()
// method.
class HourlyEmployee extends Employee
{
    HourlyEmployee(String empName, double empWage)
    {
        setEmpName(empName);
        setEmpWage(empWage);
    }

    // computes both regular-time versus overtime
    double computePay(double hoursWorked)
    {
        double empPay;                      // employee paycheck amount

        if (hoursWorked <= Employee.REGULAR_HOURS_LIMIT)
        {
            empPay = getEmpWage() * hoursWorked;
        }
        else
        {
            empPay = getEmpWage() * Employee.REGULAR_HOURS_LIMIT +
                    (1.5 * getEmpWage() * (hoursWorked - Employee.REGULAR_HOURS_LIMIT));
        }

        return empPay;
    }

    // displays hourly wage
    void display()
    {
        System.out.format("%,.2f", getEmpWage());       // specific format
    }

    // returns the employee name and employee hourly wage in a specific format of type String
    public String toString()
    {
        return (String.format("%-28s",getEmpName()) + "$" + String.format("%,.2f", getEmpWage())) + "/hour";
    }
}

// subclass which extends employee; it also defines the
// computePay() function besides overriding the display()
// method.
class SalariedEmployee extends Employee
{
    double hoursWorked;
    SalariedEmployee(String empName, double annualSalary)
    {
        setEmpName(empName);
        setSalary(annualSalary);
    }

    // returns annual salary
    double getSalary()
    {
        return (getEmpWage() * 52 * Employee.REGULAR_HOURS_LIMIT);
    }

    // sets hourly wage by converting annual salary to hourly wage
    void setSalary(double annualSalary)
    {
        setEmpWage(annualSalary / 52 / Employee.REGULAR_HOURS_LIMIT);         // sets the wage
    }

    // displays salary
    void display()
    {
        if (getEmpWage() == 0)
        {
            setEmpWage(Employee.REGULAR_HOURS_LIMIT);
        }
        System.out.format("%,.2f", getEmpWage() * Employee.REGULAR_HOURS_LIMIT / hoursWorked);
    }

    // computes and returns the employee paycheck amount
    double computePay(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;//setEmpWage(getSalary() / 52 / hoursWorked);
        return (getSalary() / 52);
    }

    // returns the employee name and employee yearly salary in a specific format of type String
    public String toString()
    {
        return (String.format("%-28s",getEmpName()) + "$" + String.format("%,.2f", getSalary())) + "/year";
    }
}

// the driver class in the program
class EmployeeDriver
{
    static Scanner input = new Scanner(System.in);          // necessary for input
    static Employee empArray[] = new Employee[1];           //declare main array

    public static void main(String[] args)
    {
        String userInput;                                   // validated menu choice

        do
        {
            employeeMenu();
            userInput = inputValidation();
            select(userInput);
        }
        while (!userInput.contentEquals("Q"));
    }

    // displays program menu
    public static void employeeMenu()
    {
        System.out.println("N: New employee");
        System.out.println("P: Compute paychecks");
        System.out.println("R: Raise wages");
        System.out.println("L: List all employees");
        System.out.println("Q: Quit");
        System.out.println();
    }

    // returns validated menu choice
    public static String inputValidation()
    {
        boolean valid;                          // temp variable useful in input validation
        String userInput;                       // user menu choice

        do
        {
            valid = true;
            System.out.print("Enter command: ");
            userInput = input.nextLine().toUpperCase();

            //
            if (!(userInput.equals("N") || userInput.equals("P") ||
                    userInput.equals("R") || userInput.equals("L") || userInput.equals("Q")))
            {
                valid = false;
                System.out.println("Invalid Input\n");
            }
        }
        while (!valid);

        return userInput;
    }

    // selecting the corresponding menu option
    public static void select(String user)
    {
        switch (user)
        {
            case "N":
                newEmployee();
                break;
            case "P":
                computePaycheck();
                break;
            case "R":
                raiseWages();
                break;
            case "L":
                listEmployees();
                break;
        }
    }

    // processing new employee
    public static void newEmployee()
    {
        String empName,                     // employee name
               empType;                     // employee type; hourly / salaried
        double empWage;                     // employee wage
        boolean valid;                      // temp variable useful in input validation

        // grab input from user
        System.out.print("Enter name of new employee: ");
        empName = input.nextLine();

        do
        {
            valid = true;
            System.out.print("Hourly (h) or salaried (s): ");
            empType = input.nextLine();

            if (!(empType.contentEquals("h") || empType.contentEquals("s")))
            {
                valid = false;
                System.out.println("Invalid Input\n");
            }
        }
        while (!valid);

        // checks whether employee is hourly-waged or salaried
        if (empType.contentEquals("h"))
        {
            System.out.print("Enter hourly wage: ");
            empWage = input.nextDouble();
            input.nextLine();

            // create employee object
            empArray[Employee.empCount] = new HourlyEmployee(empName, empWage);
        }
        else if (empType.contentEquals("s"))
        {
            System.out.print("Enter annual salary: ");
            empWage = input.nextDouble();
            input.nextLine();

            // create employee object
            empArray[Employee.empCount] = new SalariedEmployee(empName, empWage);
        }

        // expand array as needed
        empArray = checkIfToDouble(empArray);
        System.out.println();
    }

    // computes paychecks
    public static void computePaycheck()
    {
        double hoursWorked;                                     // hours worked by employee

        for (int i = 0; i < Employee.empCount; i++)
        {
            System.out.print("Enter number of hours worked per week by " + empArray[i].getEmpName() + ": ");
            hoursWorked = input.nextDouble();
            input.nextLine();

            // display weekly pay for all employees.
            // For hourly employees first grab hours,
            // for salaried employees set hours to 40
            System.out.println("Pay: $" + String.format("%,.2f", empArray[i].computePay(hoursWorked)));
            /*
            if (empArray[i] instanceof HourlyEmployee)
            {

            }
            else if(empArray[i] instanceof SalariedEmployee) {
                System.out.println("Pay: $" + String.format("%,.2f", empArray[i].
                        computePay(Employee.REGULAR_HOURS_LIMIT)));
                empArray[i].computePay(hoursWorked);
            }*/
            System.out.println();
        }
        System.out.println();
    }

    // raises employee wages by specific percent amount
    public static void raiseWages()
    {
        double percentIncrease;                             // percentage increase in wages

        //grab percentage and raise wages for all employees
        System.out.print("Enter percentage increase: ");
        percentIncrease = input.nextDouble();
        input.nextLine();

        // display section
        System.out.println("Name                        New Wages");
        System.out.println("---------------             -----------------");

        for (int i = 0; i < Employee.empCount; i++)
        {
            empArray[i].increaseEmpWage(percentIncrease);       // increases wage
            System.out.println(empArray[i].toString());         // prints new wages
        }
        System.out.println();
    }

    // display information for all employees
    public static void listEmployees()
    {
        System.out.println("Name                        Hourly Wages");
        System.out.println("---------------             -----------------");

        for (int i = 0; i < Employee.empCount; i++)
        {
            System.out.format("%-28s", empArray[i].getEmpName());
            empArray[i].display();
            System.out.println("/hour");
        }
        System.out.println();
    }

    // This method checks if the size of the array needs to be
    // doubled based on the number of elements input by the user.
    static Employee[] checkIfToDouble(Employee[] currentArray)
    {
        // checks if the next entry will go out of bound
        if (currentArray.length == Employee.empCount)
        {
            // declaring the new array
            Employee[] newArray = new Employee[currentArray.length * 2];

            // copies current contents and then returns the new array
            System.arraycopy(currentArray, 0, newArray, 0, currentArray.length);

            return newArray;
        }
        else
        {
            // otherwise returns current array
            return currentArray;
        }
    }
}