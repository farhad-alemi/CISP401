import java.util.*;             // necessary for Scanner class

class MyCar
{
    private String make;        // make of the car
    private String model;       // model of the car
    private double mpg;         // miles-per-gallon of the car

    // setter methods
    void setMake(String make)
    {
        this.make = make;       // modifies the private variable make
    }
    void setModel(String model)
    {
        this.model = model;     // modifies the private variable model
    }
    void setMPG(double mpg)
    {
        this.mpg = mpg;         // modifies the private variable mpg
    }

    //getter methods
    String getMake()
    {
        return make;
    }
    String getModel()
    {
        return model;
    }
    double getMPG()
    {
        return mpg;
    }

    MyCar compareMPG(MyCar obj)     // this method returns the object with the greater value of mpg
    {
        if (mpg > obj.getMPG())
        {
            return (this);
        }
        else if (mpg < obj.getMPG())
        {
            return obj;
        }
        else
        {
            return null;    // if the MPGs for both objects are the same, returns null
        }
    }
}

class Driver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);     // necessary for processing input, object of Scanner class

        MyCar car1 = new MyCar();                   // first object
        MyCar car2 = new MyCar();                   // second object
        MyCar betterMake;                           // the object for storing the car with higher mpg

        System.out.println("Car 1 make: ");
        car1.setMake(input.nextLine());
        System.out.println("Car 1 model: ");
        car1.setModel(input.nextLine());
        System.out.println("Car 1 MPG: ");
        car1.setMPG(input.nextDouble());

        input.nextLine();                           // ignores the extra line in the input

        System.out.println("\nCar 2 make: ");
        car2.setMake(input.nextLine());
        System.out.println("Car 2 model: ");
        car2.setModel(input.nextLine());
        System.out.println("Car 2 MPG: ");
        car2.setMPG(input.nextDouble());

        betterMake = car1.compareMPG(car2);         // call to compareMPG() method which is accessed inside car1
        if (betterMake == null)                     // if null is returned as object, then cars have same mpg
        {
            System.out.println("\nThe cars have same MPG.");
        }
        else
        {
            System.out.println("\nThe car with better gas mileage:");
            System.out.println("Make:  " + betterMake.getMake());
            System.out.println("Model: " + betterMake.getModel());
            System.out.println("MPG:   " + betterMake.getMPG());
        }
    }
}