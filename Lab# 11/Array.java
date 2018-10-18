import java.util.*;                          // necessary for the Scanner class

class Array
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int userInput;                      // temp variable for storing user input
        int counter = 0;                    // number of elements input by the user
        int originalArray[] = new int [2];  // original array of size 2
        int duplicateIntArray[];            // duplicate int array
        Integer duplicateObjArray[];        // duplicate Integer object array

        do
        {
            System.out.println("Please input number (-1) to exit:");
            userInput = input.nextInt();

            if (userInput != -1)            // if user enters -1, no need to do validation and resizing
            {
                originalArray = checkIfToDouble(originalArray, counter);    // checks if array size needs to be doubled
                if (!isDuplicate(originalArray, userInput))                 // checks for duplicates
                {
                    originalArray[counter] = userInput;
                    counter++;
                }
                else
                {
                    System.out.println("Duplicate entry, try again!\n");
                }
            }
        }
        while (userInput != -1);

        // int duplicate array is initialized
        duplicateIntArray = new int[counter];

        // copy section
        System.arraycopy(originalArray, 0, duplicateIntArray, 0, counter);  // copy to int array
        duplicateObjArray = Arrays.stream(originalArray).boxed().toArray(Integer[]::new); // copy to Integer array

        // -display section-

        // display original int array
        System.out.println("\n\n---Original int Array---");
        displayIntContent(originalArray, counter);

        // display duplicate int array
        System.out.println("\n\n---Duplicate int Array---");
        displayIntContent(duplicateIntArray, counter);

        // display duplicate Integer array
        System.out.println("\n\n---Duplicate Integer Array---");
        displayIntegerContent(duplicateObjArray, counter);
    }

    // This method checks if the number input by the user is a
    // duplicate entry and returns a boolean flag.
    static boolean isDuplicate(int array[], int userInput)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == userInput)
            {
                return true;
            }
        }
        return false;
    }

    // This method checks if the size of the array needs to be
    // doubled based on the number of elements input by the user.
    static int[] checkIfToDouble(int[] currentArray, int counter)
    {
        if (currentArray.length == counter + 1)                 // checks if the next entry will go out of bound
        {
            int[] newArray = new int[currentArray.length * 2];  // declaring and intializing a new array

            // copies current contents and then returns the new array
            System.arraycopy(currentArray, 0, newArray, 0, currentArray.length);
            return newArray;
        }
        else
        {
            return currentArray;                                // otherwise returns current array
        }
    }

    // This method displays the content of the int array parameter
    // in reverse, ascending and descending orders
    static void displayIntContent(int[] array, int counter)
    {
        System.out.println("\nArray in Reverse Order");
        for (int i = counter - 1; i >= 0; i--)
        {
            System.out.println(array[i]);
        }

        // call to sort function
        Arrays.sort(array, 0, counter);

        System.out.println("\nArray in Ascending Order");
        for (int i = 0; i < counter; i++)
        {
            System.out.println(array[i]);
        }
        System.out.println("\nArray in Descending Order");
        for (int i = counter - 1; i >= 0; i--)
        {
            System.out.println(array[i]);
        }
    }

    // This method displays the content of the Integer object array
    // parameter in reverse, ascending and descending orders
    static void displayIntegerContent(Integer[] array, int counter)
    {
        System.out.println("\nArray in Reverse Order");
        for (int i = counter - 1; i >= 0; i--)
        {
            System.out.println(array[i]);
        }

        // call to sort function
        Arrays.sort(array, 0, counter);

        System.out.println("\nArray in Ascending Order");
        for (int i = 0; i < counter; i++)
        {
            System.out.println(array[i]);
        }
        System.out.println("\nArray in Descending Order");
        for (int i = counter - 1; i >= 0; i--)
        {
            System.out.println(array[i]);
        }
    }
}