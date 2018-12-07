import javax.swing.*;               // required for extending the JFrame class
import java.awt.*;                  // required for using Container functions

// class PumpkinImage extends JFrame
class PumpkinImage extends JFrame
{
    public static void main(String args[])
    {
        // creating a JFrame object of type PumpkinImage
        PumpkinImage obj = new PumpkinImage();

        // ends the program when the frame window is closed
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        obj.setSize(500,500);            // frame size
        obj.setVisible(true);

        Container con = obj.getContentPane();         // creating background container
        con.setBackground(Color.black);               // setting background color
    }

    public void paint(Graphics g)
    {
        super.paint(g);                               // call to overridden method

        // the following block of code is added to make sure the drawn-arcs are responsive to
        // frame resize
        int x = (getWidth() / 2 - 100);
        int y = ((getHeight() / 2 - 89));

        // outer arc
        g.setColor(Color.orange);                     // arc color
        g.fillArc(x, y, 200, 200,0, 360);

        // eyes
        g.setColor(Color.pink);
        g.fillArc(x + 50, y + 50, 30, 30, 0, 360);
        g.fillArc(x + 120, y + 50, 30, 30, 0, 360);

        // mouth
        g.setColor(Color.white);
        g.fillArc(x + 20, y + 40, 160, 130, 180, 180);
    }
}