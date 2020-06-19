import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;
/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue{
    Person Head;
    Person Tail;
    public Queue(){

    }

    public boolean queueEmpty(){
        if (Head == null) return true;
        else  return false;
    }

    public void addPerson(Person name){
        this.queueEmpty();
        if (queueEmpty() == true){
            Tail = name;
            Head = name;
        }else{
            Tail.setFollower(name);
            Tail = name;
        }
    }

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
    }

}