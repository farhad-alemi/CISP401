import java.util.*;                         // necessary for processing user input

class RatioInfo
{
    private double GPA;                     // GPA for the object
    private double percentage;              // the IQ / GPA ratio
    private int IQ;                         // IQ for the object
    private static double totalRatio;       // the sum of all (IQ / GPA)

    // The constructor assigns the member variables GPA and IQ
    // and calls the calcRatio() function in order to assign other
    // member variables.
    RatioInfo(double GPA, int IQ)
    {
        this.GPA = GPA;
        this.IQ = IQ;
        calcRatio();
    }

    // This function assigns the value of the member variable percentage
    // and updates the totalRatio variable by calling the calcTotalRatio()
    // function
    void calcRatio()
    {
        percentage = IQ / GPA;
        calcTotalRatio(this);
    }

    // This function updates the value of the member variable totalRatio
    static void calcTotalRatio(RatioInfo obj)
    {
        totalRatio += obj.IQ / obj.GPA;
    }

    // This function returns a string phrase depending on the value of the
    // member variable percentage relative to the average ratio of IQs and GPAs.
    String getStatus()
    {
        if (percentage > (totalRatio / Student.getNumberOfStudents()))
        {
            return "Good";
        }
        else if (percentage < (totalRatio / Student.getNumberOfStudents()))
        {
            return "Bad";
        }
        else
        {
            return "Same";
        }
    }

    // returns the variable percentage
    double getPercentage()
    {
        return percentage;
    }
}

class Student
{
    private String fname;                   // student's first name
    private String lname;                   // student's last name
    private RatioInfo ratio;                // object of type RatioInfo containing GPA and IQ
    private static int numberOfStudents;    // total number of students

    // This constructor only increments the numberOfStudents variable
    Student()
    {
        numberOfStudents++;
    }

    // This constructor assigns the value of fname and lname besides incrementing
    // the total count of students by calling other functions.
    Student(String fname, String lname)
    {
        this();
        setFirstName(fname);
        setLastName(lname);
    }

    // This constructor assigns the value of fname and lname besides incrementing
    // the total count of students by calling other functions.
    Student(String fname, String lname, double GPA, int IQ)
    {
        this(fname, lname);
        setRatio(GPA, IQ);
    }

    // This function creates an object of type RatioInfo by passing GPA and IQ into it.
    void setRatio(double GPA, int IQ)
    {
        ratio = new RatioInfo(GPA, IQ);
    }

    // Assigns the variable fname.
    void setFirstName(String fname)
    {
        this.fname = fname;
    }

    // Assigns the variable lname.
    void setLastName(String lname)
    {
        this.lname = lname;
    }

    // returns the variable fname.
    String getFirstName()
    {
        return fname;
    }

    // returns the variable lname.
    String getLastName()
    {
        return lname;
    }

    // returns the variable numberOfStudents.
    static int getNumberOfStudents()
    {
        return numberOfStudents;
    }

    // returns the variable ratio
    RatioInfo getRatio()
    {
        return ratio;
    }
}

class Driver
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String fname, lname;                        // temporary variables for storing first and last names
        double GPA;                                 // temporary variable for storing GPA
        int IQ;                                     // temporary variable for storing IQ

        // creation of object by calling the constructor with no arguments
        Student student1 = new Student();

        // user input for first object
        System.out.println("Enter first name for student " + 1);
        student1.setFirstName(reader.nextLine());
        System.out.println("Enter last name for student " + 1);
        student1.setLastName(reader.nextLine());
        System.out.println("Enter GPA for student " + 1);
        GPA = reader.nextDouble();
        System.out.println("Enter IQ for student " + 1);
        IQ = reader.nextInt();
        System.out.println();
        reader.nextLine();                          // ignoring the extra line in input buffer

        student1.setRatio(GPA, IQ);                 // assigning the variables GPA and IQ

        // user input for second object
        System.out.println("Enter first name for student " + 2);
        fname = reader.nextLine();
        System.out.println("Enter last name for student " + 2);
        lname = reader.nextLine();
        System.out.println("Enter GPA for student " + 2);
        GPA = reader.nextDouble();
        System.out.println("Enter IQ for student " + 2);
        IQ = reader.nextInt();
        System.out.println();
        reader.nextLine();                          // ignoring the extra line in input buffer

        // creation of object by calling the constructor with two arguments
        Student student2 = new Student(fname, lname);
        student2.setRatio(GPA, IQ);                 // assigning the variables GPA and IQ

        // user input for third object
        System.out.println("Enter first name for student " + 3);
        fname = reader.nextLine();
        System.out.println("Enter last name for student " + 3);
        lname = reader.nextLine();
        System.out.println("Enter GPA for student " + 3);
        GPA = reader.nextDouble();
        System.out.println("Enter IQ for student " + 3);
        IQ = reader.nextInt();
        System.out.println();
        reader.nextLine();                          // ignoring the extra line in input buffer

        // creation of object by calling the constructor with four arguments
        Student student3 = new Student(fname, lname, GPA, IQ);

        // output section
        displayContent(student1, 1);
        displayContent(student2, 2);
        displayContent(student3, 3);
        System.out.println("Total Number of Student   :   " + Student.getNumberOfStudents());
    }

    // This function displays the content of the object passed as a parameter.
    static void displayContent(Student obj, int objNumber)
    {
        System.out.println("Student " + objNumber);
        System.out.println("First Name                :   " + obj.getFirstName());
        System.out.println("Last Name                 :   " + obj.getLastName());
        System.out.println("Student Percentage        :   " + obj.getRatio().getPercentage());
        System.out.println("Student Status            :   " + obj.getRatio().getStatus());
        System.out.println();
    }
}