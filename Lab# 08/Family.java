import java.util.*;                     // necessary for Random() and nextInt()
import javax.swing.*;                   // necessary for JOptionPane

class Family
{
    double income;                      // variable for storing income
    int    children;                    // variable for storing the no. of children

    static Random u = new Random();     // creating an object of type Random
    static int randNumber;              // static variable for storing the random number

    Family()
    {
        income = randNumber * 1000;
    }
    Family(double income)
    {
        this.income = income;
    }

    // anonymous static block generates a number between 1 and 8
    static
    {
        randNumber = u.nextInt(7) + 1;
    }

    // anonymous instance block assigns the random number to the instance variable children
    {
        children = randNumber;
    }

    public static void main(String[] args)
    {
        if (Family.randNumber < 4)
        {
            Family obj = new Family();      // obj, an abject of type Family, is created by calling the constructor
                                            // with no arguments
            displayInformation(obj);        // call to a static function that displays the object information
        }
        else
        {
            // the statement below retrieves the input from the user in the form of a String and then converts it
            // into Double object using the Double wrapper class, then converts it to the double primitive data-type,
            // and then passes it as argument to the single-argument constructor
            Family obj = new Family(Double.parseDouble(JOptionPane.showInputDialog("Please input income: ")));

            displayInformation(obj);        // call to a static function that displays the object information
        }
    }

    // this function displays the object information
    static void displayInformation(Family obj)
    {
        System.out.println("Family:\n");
        System.out.println("Children:  " + obj.children);
        System.out.println("Income:   $" + obj.income);
    }
}