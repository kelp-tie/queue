
/**
 * Making a Queue
 *
 * @Anh Hoang
 * @version 1.0
 */
public class Queue{
    Person Head;
    Person pTail; 
    Person Tail;
    public Queue(){
        this.Head=null;
        this.pTail=null;
        this.Tail=null;
    }

    public void printQueue(){
        if (queueEmpty() == false){
            Person nextP = Head;
            System.out.println("");
            System.out.print(nextP.name);

            while(nextP != Tail){
                while(nextP != pTail){
                    nextP = nextP.follower; 
                    System.out.print(", ");
                    System.out.print(nextP.name);
                }
                nextP = nextP.follower; 
                System.out.print(", ");
                System.out.print(nextP.name);
            }
        }
    }// prints out a queue

    public boolean queueEmpty(){
        if (Head == null) return true;
        else  return false;
    } // checking if queue are empty    

    public void addPerson(Person name, boolean isStaff){
        if (queueEmpty() == true){
            Head = name;
            pTail = name;
            Tail= name;
        }
        if(isStaff == true){
            name.setFollower(Head.follower);
            Head = name;
        }else{
            name.setFollower(pTail.follower);
            pTail.setFollower(name);
        }
        pTail=name;   
        if(isStaff == false){
            if (Head == null){
                Tail = name;
                Tail = Head;
            } else{
                Tail = name;
            }
        }
    }// add a person to the queue

    public Person removePerson(){
        Person name2 = Head;
        if (Head != null){
            if (pTail == Head){
                pTail=null;
            }
            else if (Tail == Head) {
                Head=null;
                Tail=null;
            }
            else{
                Head= Head.follower;
                name2.follower = null;
            }
        }
        return name2;
    } // remove and return a person from the queue

}