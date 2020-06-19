import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Write a description of class InD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InD extends JDialog
{
    private String name;
    public InD(String question){
        super (new JFrame(question),question);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(question.length()*10,100));
        JTextField reply= new JTextField();
        JButton clickMe= new JButton("enter");
        clickMe.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    name=reply.getText();
                    close();
                }
            });
        this.setLayout(new GridLayout(2,1,5,5));
        this.add(reply);
        this.add(clickMe);
        this.pack();
        setModal(true);
    }

    private void close(){this.dispose();}

    public String getText(){ return name;}
}
