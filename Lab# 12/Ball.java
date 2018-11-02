class Ball
{
    public double radius;                           // radius of the ball
    public String color;                            // color of the ball

    // the constructor which assigns the object's
    // member variables to function parameters
    Ball(double radius, String color)
    {
        this.radius = radius;
        this.color = color;
    }

    // instance method for calculating the area of
    // the ball object
    double area()
    {
        return (Math.PI * Math.pow(radius, 2));
    }
}

class Basketball extends Ball
{
    public int noOfStripes;                         // number of stripes in the ball

    // constructor which calls the constructor of the parent-class besides
    // assigning the object member variable to the function parameter
    Basketball(int noOfStripes, int radius, String color)
    {
        super(radius, color);
        this.noOfStripes = noOfStripes;
    }
    // two-argument constructor which calls the three-argument constructor
    Basketball(int radius, String color)
    {
        this(8, radius, color);             // 8 is the default no. of stripes
    }
}

class Driver
{
    public static void main(String args[])
    {
        // creating two objects by hard-coding the data
        Basketball basket1 = new Basketball(10, 1, "White");
        Basketball basket2 = new Basketball(2, "Blue");

        // calls to display method
        System.out.println("First Object:");
        displayContent(basket1);
        System.out.println("Second Object:");
        displayContent(basket2);
    }

    // this method displays the content of the object by calling
    // member functions
    static void displayContent(Basketball obj)
    {
        System.out.println("Area           : " + obj.area());
        System.out.println("Radius         : " + obj.radius);
        System.out.println("Color          : " + obj.color);
        System.out.println("No. of Stripes : " + obj.noOfStripes);
        System.out.println();
    }
}