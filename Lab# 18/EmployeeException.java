class EmployeeException extends RuntimeException
{
    String empInfo;                 // employee ID no. and hourly wage in a concatenated, string, format

    EmployeeException(String empInfo)
    {
        this.empInfo = empInfo;
    }

    // overriding the getMessage() method
    public String getMessage()
    {
        return (empInfo + "\nHourly Wage must be between $6.00 and $50.00");
    }
}

class Employee
{
    String idNum;                   // employee ID no.
    double hourlyWage;              // employee hourly wage

    Employee(String idNum, double hourlyWage)
    {
        this.idNum = idNum;
        this.hourlyWage = hourlyWage;
    }
}

class Driver
{
    static int empCount = 0;                        // number of employee objects created successfully
    static Employee empArray[] = new Employee[3];   // employee object array

    public static void main(String args[])
    {
        double testWage[] = {5.00, 15.00, 60.00};   // hourly wage test-cases

        for (int i = 0; i < testWage.length; i++)
        {
            System.out.println("Object " + (i + 1) + ":");
            try
            {
                validationMethod("W" + (i + 1000), testWage[i]);
                System.out.println("Object Created Successfully\n");
            }
            catch (EmployeeException err)
            {
                System.out.println("Exception: " + err.getMessage());
                System.out.println("Object Creation Failed\n");
            }
        }
    }

    public static void validationMethod(String idNum, double hourlyWage) throws EmployeeException
    {
        if (hourlyWage < 6.00 || hourlyWage > 50.00)
        {
            throw new EmployeeException("\nEmployee ID: " + idNum + "\nHourly Wage: " + hourlyWage);
        }
        else
        {
            empArray[empCount] = new Employee(idNum, hourlyWage);
            empCount++;
        }
    }
}