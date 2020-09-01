import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Write a description of class MenuUpgrade here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI extends JFrame implements ActionListener{
    Queue queue = new Queue();

    /**
     * Constructor for objects of class MenuUpgrade2
     */

    public void actionPerformed(ActionEvent event){
        String cmd=event.getActionCommand();
        String reply; String reply2; String reply3;
        boolean isStaff;
        InD input= new InD("input name here");
        InD input2= new InD("is this person a staff?");
        InD input3= new InD("type in the name of the file (name.csv)");

        switch(cmd){
            case "Read":  
            String string = "The files available are: test, arrivals";
            TextArea area2 = new TextArea(string);
            input3.add(area2);
            input3.setLocationRelativeTo(this);
            input3.setVisible(true);
            input3.setTitle("help");
            reply3= input3.getText();
            if(reply3 != null){
                readCSV csv = new readCSV(reply3);
            }
            break;
            case "Quit": System.exit(0); 
            break;
            case "Add Person":
            input.setLocationRelativeTo(this);
            input.setVisible(true);
            reply= input.getText();
            if(reply != null){
                input2.setLocationRelativeTo(this);
                input2.setVisible(true);
                reply2= input2.getText();
                if(reply2 != null){
                    if(reply2.equals("yes")){
                        isStaff = true;
                    }else{   
                        isStaff = false;
                    }
                    Person name = new Person(reply, isStaff);
                    queue.addPerson(name, isStaff);
                } else {
                    TextArea warning = new TextArea("you haven't define if they are a student or a staff.");
                    warning.setVisible(true);
                }
            } 
            break;
            case "Remove Person":
            queue.removePerson();
            break;
            case "Print":
            if(queue.queueEmpty() == false){
                queue.printQueue();
            } else {
                System.out.println("Queue's empty.");
            }
            break;
            default: 
        }
    }

    public GUI()
    {
        // initialise instance variables
        setTitle("Queue");
        int x = 500;
        int y = 500;
        this.getContentPane().setPreferredSize(new Dimension(x, y));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dialog();

        //Menu bar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // menu
        JMenu menu1 = new JMenu("Menu");
        menuBar.add(menu1);
        JMenu menu2 = new JMenu("Tools");
        menuBar.add(menu2);

        // menu items for menu1
        JMenuItem menuItemA1 = new JMenuItem("Read");
        menuItemA1.addActionListener(this);
        menuItemA1.setAccelerator(KeyStroke.getKeyStroke('r'));
        menu1.add(menuItemA1);

        JMenuItem menuItemA2 = new JMenuItem("Quit");
        menuItemA2.addActionListener(this);
        menuItemA2.setAccelerator(KeyStroke.getKeyStroke('q'));
        menu1.add(menuItemA2);

        // menu items for menu2
        JMenuItem menuItemB1 = new JMenuItem("Add Person");
        menuItemB1.setAccelerator(KeyStroke.getKeyStroke('+'));
        menuItemB1.addActionListener(this);
        menu2.add(menuItemB1);

        JMenuItem menuItemB2 = new JMenuItem("Remove Person");
        menuItemB2.addActionListener(this);
        menuItemB2.setAccelerator(KeyStroke.getKeyStroke('-'));
        menu2.add(menuItemB2);

        JMenuItem menuItemB3 = new JMenuItem("Print");
        menuItemB3.addActionListener(this);
        menuItemB3.setAccelerator(KeyStroke.getKeyStroke('p'));
        menu2.add(menuItemB3);

        this.pack();
        this.toFront();
        this.setVisible(true);
    }

    void Dialog(){
        String string = "This simulation represents a queue of students and\n teacher lining up in a canteen.\n Please use the menu or shortcut\n to enable functions in the queue.\n The tools does not affect the files read.\n It is for experimental \n purpose only.";
        JDialog Box = new JDialog(this);
        TextArea area = new TextArea(string);
        Box.setBounds(50,50,1*string.length(),1*string.length());
        Box.add(area);
        Box.toFront();
        Box.setVisible(true);
        Box.setTitle("Welcome");
    }
}
