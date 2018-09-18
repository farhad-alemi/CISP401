import java.util.*;

class Grades
{
    static Scanner reader = new Scanner(System.in);
    static int high = 0, low = 100;                         // initializing high to lowest possible and low to highest
                                                            // possible values.

    public static void main(String[] args)
    {
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0, total = 0, input, numGrades = 0;

        System.out.println("Enter the scores (-1 to end input):");
        do
        {
            input = reader.nextInt();
            if(input != -1)
            {
                //update the total
                total += input;

                //call calcHigh to update the high variable
                calcHigh(input);

                //call calcLow to update the low variable
                calcLow(input);

                //update the counts for the grades using if statements
                if(input >= 90)
                {
                    gradeA++;
                }
                else if(input >= 80)
                {
                    gradeB++;
                }
                else if(input >= 70)
                {
                    gradeC++;
                }
                else if(input >= 60)
                {
                    gradeD++;
                }
                else
                {
                    gradeF++;
                }

                //update the total number of grades for average calculation
                numGrades++;
            }
        }
        while(input != -1);

        //Display the various counts, average, highest and lowest scores
        if (numGrades > 0)
        {
            System.out.println("Number of A's:    " + gradeA);
            System.out.println("Number of B's:    " + gradeB);
            System.out.println("Number of C's:    " + gradeC);
            System.out.println("Number of D's:    " + gradeD);
            System.out.println("Number of F's:    " + gradeF);
            System.out.println("Highest score:    " + high);
            System.out.println("Lowest score :    " + low);
            System.out.println("Average score:    " + calcAvg(total, numGrades));
        }
    }

    // calculates and returns the average value
    static int calcAvg(int total, int numGrades)
    {
        return (total / numGrades);
    }

    // calculates and assigns the highest value
    static void calcHigh(int input)
    {
        if (input > high)
        {
            high = input;
        }
    }

    // calculates and assigns the lowest value
    static void calcLow(int input)
    {
        if (input < low)
        {
            low = input;
        }
    }
}