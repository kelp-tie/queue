
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{   
    String name;
    Person follower;
    boolean isStudent;
    public Person(String name, boolean isStudent){
        this.isStudent = isStudent;
        if (isStudent == true){
            this.name=name;
            System.out.println("Student:"+name);
        }
        else{
            this.name=name;
            System.out.println("Staff:"+name);
        }
    }

    public void setName(String name){
        this.name=name;
    }

    public void addFollower(String name, boolean isStudent){
        this.follower= new Person(name, isStudent);
    }

    public void setFollower(Person follower){
        this.follower= follower;
    }

    public Person returnFollower(){
        return follower;
    }
}
