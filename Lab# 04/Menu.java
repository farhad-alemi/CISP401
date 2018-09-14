import java.util.*;

public class Menu
{
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        int selection;                  // the menu choice

        do
        {
            selection = menu();         // menu() returns validated input
            switch (selection)
            {
                case 1:
                    hypotenuse();
                    break;
                case 2:
                    gravity();
                    break;
            }
        }
        while (selection != 3);
    }


    // menu method displays menu options and validates the input
    public static int menu()
    {
        int     menuOption;             // user input for menu
        boolean valid;                  // flag indicating whether the input is valid

        do                              // validate user input
        {
            valid = true;
            System.out.println("Menu Options:");
            System.out.println("1) Hypotenuse");
            System.out.println("2) Gravity");
            System.out.println("3) Quit");
            menuOption = reader.nextInt();

            if (menuOption != 1 && menuOption != 2 && menuOption != 3)
            {
                System.out.println("Please enter a valid input.\n");
                valid = false;
            }
        }
        while (!valid);

        return menuOption;
    }


    // calculates triangle hypotenuse after validating user input
    public static void hypotenuse()
    {
        double a, b, c;                 // the sides of the triangle
        boolean valid;                  // flag indicating whether the input is valid

        do                              // validate a
        {
            valid = true;
            System.out.println("Length for the first side [2, 20]");
            a = reader.nextDouble();

            if (a < 2 || a > 20)
            {
                System.out.println("Please enter a valid input.\n");
                valid = false;
            }
        }
        while (!valid);

        do                              // validate b
        {
            valid = true;
            System.out.println("Length for the second side [2, 20]");
            b = reader.nextDouble();

            if (b < 2 || b > 20)
            {
                System.out.println("Please enter a valid input.\n");
                valid = false;
            }
        }
        while (!valid);

        // calculate the hypotenuse
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        System.out.println("Length of the hypotenuse: " + c + "\n");
    }


    // calculates weight on Moon after validating user input
    public static void gravity()
    {
        double weightOnEarth, weightOnMoon;     // weight on earth and weight on moon
        boolean valid;                          // flag indicating whether the input is valid

        do                                      // validate user input
        {
            valid = true;
            System.out.println("Please input the weight [100, 300]");
            weightOnEarth = reader.nextDouble();

            if (weightOnEarth < 100 || weightOnEarth > 300)
            {
                System.out.println("Please input a valid input.\n");
                valid = false;
            }
        }
        while (!valid);

        // calculate weight on Moon
        weightOnMoon = 17 * weightOnEarth / 100;

        System.out.println("Weight on Moon: " + weightOnMoon +"\n");
    }
}