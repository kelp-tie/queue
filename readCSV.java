/**
 * readCSV - a sample bit of code that reads CSV
 * (comma seperated value) text files and keeps the
 * results in an array.
 * 
 * This code can be made a lot more general.  That is an exercise to the reader.
 * It can also be considerably shortened.  Multiple lines are used one after another
 * which could put run together on a single line.  This is to illustrate the steps.
 * 
 *
 * @author Bill Viggers
 * @version 18 - June - 2020
 */

import java.util.Scanner; // needed to read files
import java.io.IOException; // handle errors
import java.io.File;  //  File handles

public class readCSV
{   
    final String filename= "test.csv"; // change to reflect the CSV we are reading
    final int MAXLINES=100; // for ease of writing, we are only going to read at most 100 lines.
    final int VALUESPERLINE=4;  // for ease of writing, we know how many values we get on each line.
    int x; int y;
    Queue lines;
    /**
     * Constructor for objects of class readCSV
     */

    public readCSV()
    {
        File  thefile = new File(filename);  // generate the file handle
        String CSVlines[] = new String[MAXLINES];
        String AllLinesAllElements[][]=new String[MAXLINES][VALUESPERLINE];  // where we keep all those lines we read in.
        int linecount=0;  // initially keeps track of lines read, eventually used to remember the number that was read;
        lines = new Queue();
        x=0; y=0;
        Person q; Person p;
        try{
            Scanner reader = new Scanner(thefile); // open the file with the Scanner
            while (reader.hasNextLine()  && linecount < MAXLINES){
                String line=reader.nextLine();                   
                CSVlines[linecount]=line;
                linecount++;
            }// Read in the file, stop at file end or if we read too many lines

            for (int i =0; i<linecount; i++){
                String values[] = CSVlines[i].split(",");  // process the line from the Scanner and break it up at each comma.

                int students = Integer.parseInt(values[1]); //how many students in each line read
                for( int a=0; a<students; a++){
                    String name = ("student"+Integer.toString(x++));
                    p = new Person(name, false);
                    lines.addPerson(p, false);
                }//enqueueing students by lines

                int staffs = Integer.parseInt(values[2]); //how many staffs in each line read
                for( int b=0; b<staffs; b++){
                    String name = ("staff"+Integer.toString(y++));
                    q = new Person(name, true);
                    lines.addPerson(q, true);
                }//enqueueing staffs by lines

                int served = Integer.parseInt(values[3]); //how many people served in each line read
                for( int c=0; c<served; c++){
                    p = lines.removePerson();
                }//dequeueing served by lines

                for (int j=0; j< values.length;j++)
                    AllLinesAllElements[i][j]=values[j];
            }  // process the file we read, line by line.

        } catch (IOException e) {System.out.println(e);}

        for(int i=0;i<linecount;i++)
            System.out.println("At "+AllLinesAllElements[i][0]+", "+AllLinesAllElements[i][1]+" students arrived, "+AllLinesAllElements[i][2]+" staffs arrived, "+AllLinesAllElements[i][3]+" served");    

        lines.printQueue();
        System.out.println(" were not served.");
        System.out.println("***");
    }
}