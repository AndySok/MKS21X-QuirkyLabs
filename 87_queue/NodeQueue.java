import java.util.Queue;

/**
 * Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 * APCS PD8
 * HW 87: April Queues
 * 2022-04-01
 * Spent: 0.5 hrs
 * 
 * DISCO
 * - 
 * - 
 * 
 * QCC
 * - 
 * - 
 * 
 * 
 * 
 **/

public class NodeQueue<QUASAR> implements Queue<QUASAR>{
    private Node<QUASAR> _head;

    public NodeQueue(){
        _head = new Node<QUASAR>();
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public QUASAR dequeue(){

    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( QUASAR x ){

    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){

    }

    //Returns the first element of the queue without dequeuing it.
    public QUASAR peekFront(){

    }
    
    private class Node<QUASAR> {
        //instance vars
        private String cargo;
        private Node cdr;

        // constructor
        public Node( <String> value, Node next )
        {
            this.cargo = value;
            this.cdr = next;

        }

        public Node(String cargo) {
            this.cargo = cargo;
            this.cdr = null;
        }


        //--------------v  ACCESSORS  v--------------
        public String getCargo()
        {
            return this.cargo;
        }

        public Node getNext()
        {
            return this.cdr;
        }
        //--------------^  ACCESSORS  ^--------------


        //--------------v  MUTATORS  v--------------
        public String setCargo( String newCargo )
        {
            String temp = this.cargo;
            this.cargo = newCargo;
            return temp;
        }

        public Node setNext( Node newNext )
        {
            Node temp = this.cdr;
            this.cdr = newNext;
            return temp;
        }
        //--------------^  MUTATORS  ^--------------


        // override inherited toString
        public String toString()
        {
            return cargo;

        }

    }
}

