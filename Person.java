
/**
 * Making a person and followers
 *
 * @Anh Hoang
 * @version 1.0
 */
public class Person
{   
    String name;
    Person follower;
    boolean isStudent;  // for person to be a student or a staff
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
    } // initate person

    public void setFollower(Person follower){
        this.follower= follower;
    } // add a follower

    public Person returnFollower(){
        return follower;
    } // return a follower
}//Class
