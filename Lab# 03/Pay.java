import java.util.*;

public class Pay
{
    public static void main(String[] args)
    {
        FullNamePay.main(null);
        PayFullName.main(null);
        PayFirstLastName.main(null);
    }
}
class FullNamePay
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String  fullName;
        double  hourlyPay,
                hours,
                totalPay;

        //Input
        System.out.println("Please enter FirstName and LastName separated by a space:");
        fullName = reader.nextLine();
        System.out.println("Please enter hourly pay:");
        hourlyPay = reader.nextDouble();
        System.out.println("Please enter number of hours worked:");
        hours = reader.nextDouble();

        // Calculation
        totalPay = hours * hourlyPay;

        // Output
        System.out.println("Name: " + fullName);
        System.out.println("Total Pay: $" + totalPay);
    }
}

class PayFullName
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String  fullName;
        double  hourlyPay,
                hours,
                totalPay;

        //Input
        System.out.println("Please enter hourly pay:");
        hourlyPay = reader.nextDouble();
        System.out.println("Please enter number of hours worked:");
        hours = reader.nextDouble();
        System.out.println("Please enter FirstName and LastName separated by a space:");
        reader.nextLine();
        fullName = reader.nextLine();

        // Calculation
        totalPay = hours * hourlyPay;

        // Output
        System.out.println("Name: " + fullName);
        System.out.println("Total Pay: $" + totalPay);
    }
}

class PayFirstLastName
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String  firstName,
                lastName;
        double  hourlyPay,
                hours,
                totalPay;

        //Input
        System.out.println("Please enter hourly pay:");
        hourlyPay = reader.nextDouble();
        System.out.println("Please enter number of hours worked:");
        hours = reader.nextDouble();
        System.out.println("Please enter FirstName:");
        reader.nextLine();
        firstName = reader.next();
        System.out.println("Please enter LastName:");
        reader.nextLine();
        lastName = reader.next();

        // Calculation
        totalPay = hours * hourlyPay;

        // Output
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Total Pay: $" + totalPay);
    }
}