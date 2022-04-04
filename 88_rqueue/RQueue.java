import java.util.NoSuchElementException;

/**
 * Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 * APCS PD8
 * HW 87: BPC Kiddies Do Not Wait in Line Either
 * 2022-04-04
 * Spent: 0.5 hrs
 * 
 * DISCO
 * - 
 * - 
 * -
 *  
 * QCC
 * - 
 * - 
 * -
 * 
 * 
 **/

public class RQueue<QUASAR> implements Queue<QUASAR>{
    private int size;
    private int nextElement;
    private LLNode<QUASAR> _head;
    private LLNode<QUASAR> _tail;

    public RQueue(){
        _head = _tail = null;
        size = 0;
        nextElement = 0;
    }

    public RQueue(QUASAR cargo){
        this();
        enqueue(cargo);
    }

    //means of removing an element from collection:
    //Dequeues and returns a random element of the queue.
    //algo is the same as remove for LList
    public QUASAR dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        QUASAR original = this.peekFront();
        if (nextElement == 0) _head = _head.getNext(); //check if you only need to get rid of the first one
    	else if( nextElement >= size()-1) { //check if you need to get rid of the end
            LLNode<QUASAR> _temp = _head;
            for(int i=0;i<nextElement-1;i++){
              _temp = _temp.getNext();
            }
            _temp.setNext(null);
        }
        else {
            LLNode<QUASAR> _temp = _head;
	        //walk to node before desired node
	        for( int i=0; i < nextElement-1; i++ )
            _temp = _temp.getNext();

	        //remove target node
	        _temp.setNext( _temp.getNext().getNext() );
        }
        size--;
        this.sample();
        return original;
        
    } //O(n)

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( QUASAR x ){
        LLNode<QUASAR> _oldTail = _tail;
        _tail = new LLNode<QUASAR>(x);
        if(isEmpty()) _head = _tail;
        else _oldTail.setNext(_tail);
        size++;
        this.sample();
    } //O(1)

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
        return _head == null;
    } //O(1)
    
    //Returns the size
    public int size(){
        return size;
    } //O(1)

    //Returns the element of the queue which will dequeue next.
    public QUASAR peekFront(){
        if(isEmpty()) return null;
        LLNode<QUASAR> _temp = _head;
        for(int i=0;i<nextElement;i++){
            _temp = _temp.getNext();
        }
        return _temp.getCargo();
    } //O(1)

    //will “shuffle” the queue and tell you what the new front element is
    //ALGO
    //1. set nextElement equal to a random number in between 0 (inclusive) and size (exclusive) 
    //2. find the nextElement node in the queue and return it

    public QUASAR sample(){
        nextElement = (int)(Math.random()*size());
        return this.peekFront();
    }

    public String toString(){
        String retStr = "FRONT->";
        LLNode<QUASAR> tmp = _head; //init tr
        for( int i=0; i <size();i++) {
            retStr += tmp.getCargo().toString();
            if(i==nextElement){
                retStr+="(NEXT)";
            } 
            retStr += "->";
            tmp = tmp.getNext();
        }
        retStr += "NULL";
        return retStr;        
    }

  //main method for testing
  public static void main( String[] args )
  {

    
    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing..."); 
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()..."); 
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow testing peekFront()..."); 
    System.out.println( PirateQueue.peekFront() ); //for testing toString()...


    System.out.println("\nnow dequeuing..."); 
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}

