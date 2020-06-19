import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;
/**
 * Making a Queue
 *
 * @Anh Hoang
 * @version 1.0
 */
public class Queue{
    Person Head;
    Person Tail;
    public Queue(){

    }

    public boolean queueEmpty(){
        if (Head == null) return true;
        else  return false;
    } // checking if queue are empty    

    public void addPerson(Person name){
        this.queueEmpty();
        if (queueEmpty() == true){
            Tail = name;
            Head = name;
        }else{
            Tail.setFollower(name);
            Tail = name;
        }
    } // add a person to the queue

    public Person removePerson(){
        Person name2;
        name2 = Head;
        if (Head != null){
            Person name= Head.follower;
            Head.follower = null;
            Head = name;
        }
        else System.out.println("Queue's empty.");
        return name2;
    } // remove and return a person from the queue

}