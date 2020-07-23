
/**
 * Write a description of class PQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PQueue
{
    Person person;
    Queue q = new Queue();
    Queue p = new Queue();
    public PQueue(){
        //Person nextP = Head;
        //if(nextP.isStaff == true) p.addPerson(nextP);
        //else q.addPerson(nextP);
        //while(nextP != Tail){
        //    nextP = nextP.follower;
        //    if(nextP.isStaff == true) p.addPerson(nextP);
        //    else q.addPerson(nextP);
        //}
    }

    public void PEnqueue(Person name, boolean isStaff){
        if(name.isStaff == true){
            p.addPerson(name, isStaff);
        }
        else q.addPerson(name, isStaff);
    }//priority enqueue 

    public Person PDequeue(){
        if(! p.queueEmpty()){
            return p.removePerson();
        }
        if(! q.queueEmpty()){
            return q.removePerson();
        }
        else return null;
    }// priority dequeue
}

