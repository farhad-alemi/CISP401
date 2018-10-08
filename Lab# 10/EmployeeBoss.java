class Employee
{
    private String   fname,                 // employee first name
                     lname;                 // employee last name
    private Employee boss;                  // employee's boss of type Employee
    private Address  Addr;                  // employee address of type Address

    Employee(String fname, String lname, Employee boss, String city, String state)
    {
        this.fname = fname;
        this.lname = lname;
        this.boss = boss;
        Addr = new Address(city, state);    // creates an object of type address by providing
                                            // city and state as constructor arguments.
    }

    // getter methods
    String getName()
    {
        return fname + " " + lname;
    }
    Address getAddress()
    {
        return Addr;
    }
    Employee getBoss()
    {
        return boss;
    }

    // setter method
    void setBoss(Employee object)
    {
        boss = object;
    }
}

class Address
{
    private String city,                    // city in the address provided
                   state;                   // state in the address provided

    Address(String city, String state)
    {
        this.city = city;
        this.state = state;
    }

    // getter method
    String getAddress()
    {
        return city + " " + state;
    }
}

class Driver
{
    public static void main(String[] args)
    {
        // creating two objects of type Employee
        Employee obj1 = new Employee("John", "Jones", null, "Sacramento", "California");
        Employee obj2 = new Employee("James", "Bond", null, "Davis", "California");
        // In the statement above we can also directly assign obj1 as obj2's boss by providing obj1 instead of null.
        // In that case we do not need the statement below.

        // using the setBoss() method to assign obj1 as obj'2 boss
        obj2.setBoss(obj1);

        // printing to the screen
        System.out.println("1st Employee:");
        displayObjectInfo(obj1);                    // call to displayObjectInfo() function with obj1 as argument
        System.out.println("\n2nd Employee:");
        displayObjectInfo(obj2);                    // call to displayObjectInfo() function with obj2 as argument

    }

    // this function displays all the information for the employees.
    static void displayObjectInfo(Employee obj)
    {
        // the following line uses print() instead of println() in order to allow for the subsequent output to be
        // printed on the same line.
        System.out.print(obj.getName() + " lives in " + obj.getAddress().getAddress());

        if(obj.getBoss() != null)
        {
            System.out.println(" and his boss is " + obj.getBoss().getName() + ".");
        }
        else
        {
            System.out.println(".");
        }
    }
}