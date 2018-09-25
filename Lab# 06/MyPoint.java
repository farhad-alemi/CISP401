import java.util.*;

class MyPoint
{
    private double x;                       // x-coordinate of a point
    public double y;                        // y-coordinate of a point
    private static int noOfObjects = 0;     // no. of objects created

    MyPoint()
    {
        setNoOfObjects();                   // call to the incrementing function
    }
    MyPoint(double x)
    {
        this.x = x;                         // initializing the instance variable x
        setNoOfObjects();                   // call to the incrementing function
    }
    MyPoint(double x, double y)
    {
        this(x);                            // reusing previous constructor
        this.y = y;                         // initializing the instance variable y
    }

    void setX(double x)
    {
        this.x = x;                         // assigns the parameter value to x
    }
    void setNoOfObjects()
    {
        noOfObjects++;                      // incrementing the no. of objects
    }
    double getX()
    {
        return x;
    }
    static int getNoOfObjects()
    {
        return noOfObjects;
    }
}

class Driver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);     // necessary for processing input

        final double VALUE1 = 10;                   // a value to be assigned to objects' variables
        final double VALUE2 = 20;                   // a value to be assigned to objects' variables
        final double VALUE3 = 30;                   // a value to be assigned to objects' variables
        double x, y;                                // x and y coordinates

        System.out.println("Please input x: ");
        x = input.nextDouble();
        System.out.println("Please input y: ");
        y = input.nextDouble();

        MyPoint obj1 = new MyPoint();
        MyPoint obj2 = new MyPoint(x);
        MyPoint obj3 = new MyPoint(x, y);

        obj1.setX(VALUE1);                          // assigning a value to obj1's x variable
        obj1.y = VALUE2;                            // assigning a value to obj1's y variable
        obj2.y = VALUE3;                            // assigning a value to obj2's y variable

        System.out.println("\nObject 1: ");
        System.out.println("x: " + obj1.getX());
        System.out.println("y: " + obj1.y + "\n");

        System.out.println("Object 2: ");
        System.out.println("x: " + obj2.getX());
        System.out.println("y: " + obj2.y + "\n");

        System.out.println("Object 3: ");
        System.out.println("x: " + obj3.getX());
        System.out.println("y: " + obj3.y + "\n");

        System.out.println("Total Objects: " + MyPoint.getNoOfObjects());
    }
}