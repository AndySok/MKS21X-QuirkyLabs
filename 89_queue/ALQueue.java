import java.util.ArrayList;

public class ALQueue<QUASAR> implements Queue<QUASAR>{
    private ArrayList<QUASAR> _array;

    public ALQueue(){
        _array = new ArrayList<QUASAR>();
    }
    
    public QUASAR dequeue(){
        return _array.remove(0);
    } //O(n)

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( QUASAR x ){
        _array.add(_array.size(), x);
    } //O(1)
  
    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
        return _array.isEmpty();
    }
  
    //Returns the first element of the queue without dequeuing it.
    public QUASAR peekFront(){
        return _array.get(0);
    }
     
}
