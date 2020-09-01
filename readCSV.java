
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
import java.io.FileWriter;

public class readCSV
{
    //String filename; // change to reflect the CSV we are reading
    final int MAXLINES=100; // for ease of writing, we are only going to read at most 100 lines.
    final int VALUESPERLINE=4;  // for ease of writing, we know how many values we get on each line.
    int x; int y;
    Queue lines;
    /**
     * Constructor for objects of class readCSV
     */

    public readCSV(String content)
    {
        File  thefile = new File(content);  // generate the file handle
        String CSVlines[] = new String[MAXLINES];
        String AllLinesAllElements[][]=new String[MAXLINES][VALUESPERLINE];  // where we keep all those lines we read in.
        int linecount=0;  // initially keeps track of lines read, eventually used to remember the number that was read;
        lines = new Queue();
        x=0; y=0;
        Person q; Person p;
        int studentWait = 0; int staffWait = 0;
        //try {
        //    FileWriter writer = new FileWriter(thefile);
        //    writer.write(content);
        //    writer.flush();
        //    writer.close();
        //} catch(IOException e) {};

        try{
            Scanner reader = new Scanner(thefile); // open the file with the Scanner
            while (reader.hasNextLine()  && linecount < MAXLINES){
                String line=reader.nextLine();                   
                CSVlines[linecount]=line;
                linecount++;
            }// Read in the file, stop at file end or if we read too many lines

            for (int i =0; i<linecount; i++){
                String values[] = CSVlines[i].split(",");  // process the line from the Scanner and break it up at each comma.

                for( int a=0; a<Integer.parseInt(values[1]); a++){
                    String name = ("student"+Integer.toString(x++));
                    p = new Person(name, false);
                    lines.addPerson(p, false);
                    p.setEntryTime(Integer.parseInt(values[0]));
                    studentWait = studentWait + p.returnTime(); 
                    System.out.println(name+"has arrived in normal queue at "+p.returnTime());
                }//enqueueing students by lines

                for( int b=0; b<Integer.parseInt(values[2]); b++){
                    String name = ("staff"+Integer.toString(y++));
                    q = new Person(name, true);
                    lines.addPerson(q, true);
                    q.setEntryTime(Integer.parseInt(values[0]));
                    staffWait = staffWait + q.returnTime();
                    System.out.println(name+"has arrived in priority queue at "+q.returnTime());
                }//enqueueing staffs by lines
                System.out.println("***");
                for( int c=0; c<Integer.parseInt(values[3]); c++){
                    p = lines.removePerson();
                    if(p.isStaff==true){
                        System.out.print("student left at "+Integer.parseInt(values[0]));
                        int studentTime = Integer.parseInt(values[0]) - p.returnTime();
                        System.out.println(" - student wait time is "+studentTime);
                    }else{ 
                        System.out.print("staff left at "+Integer.parseInt(values[0]));
                        int staffTime = Integer.parseInt(values[0]) - p.returnTime();
                        System.out.println(" - staff wait time is "+staffTime);
                    }
                }//dequeueing served by lines
                System.out.println("***");
                for (int j=0; j< values.length;j++)
                    AllLinesAllElements[i][j]=values[j];
            }  // process the file we read, line by line.

            System.out.println("***");
            for(int i=0;i<linecount;i++){//print out variables from csv file
                int x = Integer.parseInt(AllLinesAllElements[i][1]);
                int y = Integer.parseInt(AllLinesAllElements[i][2]);
                int z = Integer.parseInt(AllLinesAllElements[i][3]);
                if(((x+y)-z)<0){            
                    System.out.println("At "+AllLinesAllElements[i][0]+", "+AllLinesAllElements[i][1]+" students arrived, "+AllLinesAllElements[i][2]+" staffs arrived, "+AllLinesAllElements[i][3]+" served, 0 not served"); 
                } else {                
                    System.out.println("At "+AllLinesAllElements[i][0]+", "+AllLinesAllElements[i][1]+" students arrived, "+AllLinesAllElements[i][2]+" staffs arrived, "+AllLinesAllElements[i][3]+" served, "+((x+y)-z)+" not served"); 
                }
            }
            System.out.println("Total student wait time: "+studentWait);
            System.out.println("Total staff wait time: "+staffWait);
            lines.printQueue(); //print out queue read from csv file
            System.out.println("were not served.");
            System.out.println("***");
        } catch (IOException e) {System.out.println("File not recognised. Please check for errors");}
    }
}