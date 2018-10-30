import java.util.*;                                 // necessary for Scanner class

class BankAccount
{
    private String accountNumber;                   // the account number of the object
    private double accountBalance;                  // the account balance of the object

    // The default constructor which initializes the
    // private member variables by calling setter methods.
    BankAccount()
    {
        setAccountNumber("");
        setAccountBalance(0);
    }

    // - getter methods -
    //  This method returns the accountNumber.
    public String getAccountNumber()
    {
        return accountNumber;
    }
    // This method returns the accountBalance.
    public double getAccountBalance()
    {
        return accountBalance;
    }

    // - setter methods -
    // This method sets the member accountNumber
    // to the function parameter.
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    // This method sets the member accountBalance
    // to the function parameter.
    public void setAccountBalance(double accountBalance)
    {
        this.accountBalance = accountBalance;
    }
}

class Driver
{
    public static void main(String[] args)
    {
        Scanner     input = new Scanner(System.in);

        BankAccount accountArray[] = new BankAccount[1];            // the main array for storing accounts' objects
        String      accountNumber = "INVALID ACCOUNT NAME!";        // temp variable for storing account name which has
                                                                    // been initialized to a unrealistic value.
        int         currentIndex,                                   // index of the account currently selected
                    counter = 0;                                    // number of elements in the array
        double      accountBalance,                                 // temp variable for storing account balance
                    tempAmount;                                     // any temp amount (ex. deposit or withdraw amount)
                                                                    // prior to being put in the array
        char        menuChoice;                                     // validated user input for the main menu

        // array initialization
        accountArray[0] = new BankAccount();

        do
        {
            // for displaying "NONE" when currentIndex is -1
            currentIndex = isFound(accountArray, accountNumber, counter);

            // getting a validated menu choice for main menu
            menuChoice = displayMenu(accountArray, currentIndex);

            // checking whether the size of the array needs to be doubled
            accountArray = checkIfToDouble(accountArray, counter);

            switch(menuChoice)
            {
                case 'O':
                    System.out.print("Enter new account number: ");
                    accountNumber = input.nextLine();

                    // checks whether accountNumber is duplicate
                    currentIndex = isFound(accountArray, accountNumber,counter);

                    if (currentIndex == -1)
                    {
                        System.out.print("Enter initial balance: ");
                        accountBalance = input.nextDouble();
                        input.nextLine();                           // ignoring the left-over token

                        // writing the data to the array
                        accountArray[counter].setAccountNumber(accountNumber);
                        accountArray[counter].setAccountBalance(accountBalance);
                        counter++;
                    }
                    else
                    {
                        System.out.println("Account Already Exists!\n");
                    }
                    break;

                case 'D':
                    if (currentIndex == -1)
                    {
                        System.out.println("Please select an account\n");
                    }
                    else
                    {
                        System.out.print("Enter amount of deposit: ");
                        tempAmount = input.nextDouble();
                        input.nextLine();                           // ignoring the left-over token

                        // updating the balance to reflect the deposit
                        accountArray[currentIndex].setAccountBalance(accountArray[currentIndex].getAccountBalance() + tempAmount);
                    }
                    break;

                case 'W':
                    if (currentIndex == -1)
                    {
                        System.out.println("Please select an account\n");
                    }
                    else
                    {
                        System.out.print("Enter amount to withdraw: ");
                        tempAmount = input.nextDouble();
                        input.nextLine();                           // ignoring the left-over token
                        if (accountArray[currentIndex].getAccountBalance() - tempAmount < 1)
                        {
                            System.out.println("You are withdrawing too much; try again\n");
                            break;
                        }

                        // updating the balance to reflect the withdraw
                        accountArray[currentIndex].setAccountBalance(accountArray[currentIndex].getAccountBalance() - tempAmount);
                    }
                    break;

                case 'S':
                    System.out.print("Enter account number: ");
                    accountNumber = input.nextLine();
                    if (isFound(accountArray, accountNumber, counter) != -1)
                    {
                        currentIndex = isFound(accountArray, accountNumber,counter);
                    }
                    else
                    {
                        System.out.println("Account number not found\n");
                    }
                    break;

                case 'C':
                    if (counter == 0)
                    {
                        System.out.println("No accounts");
                        break;
                    }
                    else if (currentIndex == -1)
                    {
                        System.out.println("Please select an account\n");
                        break;
                    }
                    else
                    {
                        // making the current element of the array point to the object
                        // currently pointed by the last element of the array
                        accountArray[currentIndex] = accountArray[counter - 1];

                        // de-selecting the current object
                        currentIndex = -1;

                        counter--;
                    }
                    break;

                case 'L':
                    displayContent(accountArray, counter);
                    break;
            }
        }
        while (menuChoice != 'Q');
    }

    // This function displays the main menu and returns the validated user input.
    // It also displays the current selected object.
    static char displayMenu(BankAccount accountArray[], int accountIndex)
    {
        Scanner input = new Scanner(System.in);
        char menuChoice;                                            // user's menu option
        boolean invalid;                                            // temp variable used in input validation

        do
        {
            invalid = false;
            System.out.println("O: Open account");
            System.out.println("D: Deposit");
            System.out.println("S: Select account");
            System.out.println("C: Close account");
            System.out.println("W: Withdraw");
            System.out.println("L: List all accounts");
            System.out.println("Q: Quit");
            System.out.print("\ncurrent account selected: ");

            if (accountIndex != -1)
            {
                System.out.println(accountArray[accountIndex].getAccountNumber() +
                        "    Balance: $" + accountArray[accountIndex].getAccountBalance());
            }
            else
            {
                System.out.println("NONE");
            }

            System.out.print("\nEnter command: ");

            // converting to upper case for convenience in supporting both letter cases
            menuChoice = Character.toUpperCase(input.next().charAt(0));

            if (menuChoice != 'O' && menuChoice != 'O' && menuChoice != 'D'
                    && menuChoice != 'S' && menuChoice != 'C' && menuChoice != 'W'
                    && menuChoice != 'L' && menuChoice != 'Q')
            {
                System.out.println("Invalid Input!\n");
                invalid = true;
            }
        }
        while (invalid);

        return menuChoice;
    }

    // This method checks if the size of the array needs to be
    // doubled based on the number of elements input by the user.
    static BankAccount[] checkIfToDouble(BankAccount[] currentArray, int counter)
    {
        if (currentArray.length == counter)                 // checks if the next entry will go out of bound
        {
            BankAccount[] newArray = new BankAccount[currentArray.length * 2];  // declaring the new array

            for (int i = 0; i < newArray.length; i++)                           // initializing the new array
            {
                newArray[i] = new BankAccount();
            }

            // copies current contents and then returns the new array
            System.arraycopy(currentArray, 0, newArray, 0, currentArray.length);

            return newArray;
        }
        else
        {
            return currentArray;                           // otherwise returns current array
        }
    }

    // This method checks if the number input by the user is a
    // duplicate entry and returns the appropriate (int) flag.
    static int isFound(BankAccount accountArray[], String accountNumber, int counter)
    {
        if (counter == 0)                                  // if array is empty, return "not found"
        {
            return -1;
        }
        for (int i = 0; i < counter; i++)
        {
            if (accountArray[i].getAccountNumber().contentEquals(accountNumber))
            {
                return i;
            }
        }
        return -1;
    }

    // This function displays the content of the array along with the total sum
    // of all the balances.
    static void displayContent(BankAccount accountArray[], int counter)
    {
        if (counter != 0)
        {
            double totalBankAssets = 0;                     // the total bank assets
            for (int i = 0; i < counter; i++)
            {
                System.out.print((i + 1) + ") Acct#: " + accountArray[i].getAccountNumber());
                System.out.println("    Bal:$ " + accountArray[i].getAccountBalance());
                totalBankAssets += accountArray[i].getAccountBalance();
            }
            System.out.println("\nTotal Bank Assets: $" + totalBankAssets + "\n");
        }
        else
        {
            System.out.println("No accounts\n");
        }
    }
}