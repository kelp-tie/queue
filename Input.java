import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class InputDialog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Input extends JFrame
{
    public Input(){
        setTitle("Name");
        this.getContentPane().setPreferredSize(new Dimension(400,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        InD test= new InD("input name here");
        test.setLocationRelativeTo(this);
        test.setVisible(true);
        String reply= test.getText();

        System.out.println(reply);
    }
}
