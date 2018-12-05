class GoTooFar
{
    public static void main(String args[])
    {
        int numArray[] = {1, 2, 3, 4, 5};           // int array for storing test-values

        try
        {
            for (int i = 0;; ++i)
            {
                System.out.println(numArray[i]);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Now you've gone too far");
            System.out.println("System Message: " + e);
        }
    }
}