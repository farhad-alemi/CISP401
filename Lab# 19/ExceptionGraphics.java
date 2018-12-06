import javax.swing.*;               // required for extending the JFrame class
import java.util.*;                 // required for the Scanner class
import java.awt.*;                  // required for using Container functions

class ExceptionGraphics extends JFrame
{
    static Scanner input = new Scanner(System.in);
    static double userSqrt;         // the square-root of a valid user input

    public static void main(String args[])
    {
        boolean valid;              // temp. variable useful in input validation

        do
        {
            System.out.println("Input String:");

            try
            {
                userSqrt = Math.sqrt((double)Integer.parseInt(input.nextLine()));

                // the lines below are executed if and only if the line above does not throw an exception
                valid = true;

                // creating a JFrame object of type ExceptionGraphics
                ExceptionGraphics obj = new ExceptionGraphics();

                // ends the program when the frame window is closed
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                obj.setSize(500,500);            // frame size
                obj.setVisible(true);

                Container con = obj.getContentPane();        // creating background container
                con.setBackground(Color.blue);               // setting background color
            }
            catch (NumberFormatException e)
            {
                valid = false;
                System.out.println("System Message: " + e);
            }
        }
        while (!valid);
    }

    public void paint(Graphics g)
    {
        super.paint(g);                                      // call to overridden method
        g.setColor(Color.red);                               // font color

        //font name, styles and size
        g.setFont(new Font("SansSerif", Font.ITALIC | Font.BOLD, 18));

        // the following block of code is added to make sure the drawn-text is always centered
        Graphics2D g2D = (Graphics2D) g.create();
        FontMetrics fM = g2D.getFontMetrics();
        // x- and y-coordinates for drawn-text
        int x = ((getWidth() - fM.stringWidth(String.valueOf(userSqrt))) / 2);
        int y = ((getHeight() - fM.getHeight()) / 2) + fM.getAscent();

        // drawing text
        g.drawString(String.valueOf(userSqrt), x, y);
    }
}