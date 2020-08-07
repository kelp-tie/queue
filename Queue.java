/**
 * Making a Queue
 *
 * @Anh Hoang
 * @version 1.0
 */
public class Queue{
    Person Head;
    Person pTail; //last priority person
    Person Tail; 
    public Queue(){
        this.Head=null;
        this.pTail=null;
        this.Tail=null;
    }

    public void printQueue(){
        if (queueEmpty() == false){
            Person nextP = Head;
            while(nextP != null){
                System.out.print(nextP.name);
                nextP = nextP.follower;
                System.out.print(", ");
            }
        }
    }// prints out a queue

    public boolean queueEmpty(){
        if (Head == null) return true;
        else  return false;
    } // checking if queue are empty    

    public void addPerson(Person name, boolean isStaff){
        if(isStaff == true){
            if(queueEmpty() == true){ //empty queue
                Head = name;
                pTail= name;
                Tail = name;
            }
            else { //if not empty then add at the end of queue
                if(pTail == null){ //add to priority queue if empty
                    name.setFollower(Head);
                    Head= name;
                } else { //if not then add at the end of priority queue
                    name.setFollower(pTail.follower);
                    pTail.setFollower(name);
                }
                pTail = name;
            }
        } else { //normal enqueue
            if(Head == null) //empty queue
                Head = name;
            else //if not then add at the end of the queue
                Tail.setFollower(name);
            Tail= name;
        }
    }// add a person to the queue

    public Person removePerson(){
        Person name2 = Head;
        if (Head != null){ //queue not empty
            if (pTail == Head){ // empty priority queue
                pTail=null;
            } 
            if (Tail == Head) { //empty normal queue
                Head=null;
                Tail=null;
            } else{ //dequeue Head
                Head= Head.follower;
                name2.follower = null;
            }
        }
        return name2; //return person
    } // remove and return a person from the queue
}