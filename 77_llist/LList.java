/*
 Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 APCS PD8
 HW 77
 2022-03-14
 Spent: 
 Quantity of KtS
*/
/*
 * DISCO
 * QCC
 * ALGO ADD
 * ALGO REM
*/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public void add( int index, String newVal ){
    LLNode _new = new LLNode( newVal, null );
    if(_size == 0) add( newVal );
    else if(index == 0){
      LLNode _temp = _head;
      _new.setNext(_temp);
      _head = _new;
    }
    else{
      LLNode _temp = _head;
    	for(int i=0; i<index; i++){
      	_temp = _temp.getNext();
    	}
      _new.setNext(_temp); // the latter half of LList the connected to _new
      LLNode _temp2 = _head;
      for(int i=0; i<index-1;i++){
        _temp2 = _temp2.getNext();
      }
    	_temp2.setNext(_new);
    	_size++;
    }
  }

  public String remove(int index){
    String original = this.get(index);
    
    LLNode _temp = _head;  
    for (int i = 0; i<index; i++) {
      _head.setNext(_temp); 
      _temp = _temp.getNext(); 
    }
    _head = _head.setNext(_temp.getNext().getNext());
    _size--;
    return original; 
  }
    
    
    
  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );

    james.add( 0, "hi" );
    System.out.println( james );
  }

}//end class LList