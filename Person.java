
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
    boolean isStaff;
    public Person(String name, boolean isStaff){
        this.name= name;
        this.isStaff = isStaff;
    }// initate person

    public void setFollower(Person follower){
        this.follower= follower;
    } // add a follower

    public Person returnFollower(){
        return follower;
    } // return a follower

    public String showName(){
        return name;
    }
}//Class
