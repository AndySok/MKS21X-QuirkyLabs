/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static boolean check(Stack s1, Stack s2){
    while(!s1.isEmpty()){
      if(s1.pop() != s2.pop()) return false;
    }
    return true;
  }
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    Stack<Integer> cakes1 = new ALStack<Integer>();
    //Stack<Integer> cakes1 = new LLStack<Integer>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    for(int i=0; i<100; i++){
      cakes1.push(i);
    }
    Stack<Integer> cakes2 = new LLStack<Integer>();
    for(int i=0; i<100; i++){
      cakes2.push(i);
    }
    //checks if both cakes have equal values stored
    System.out.println(check(cakes1, cakes2));

    Stack cakes3 = new ALStack();
    cakes3.push("cake");
    cakes3.push('a');
    cakes3.push(10);

    System.out.println();
    //outputs how cakes1 looks after pushing some random values into it
    while(!cakes3.isEmpty()){
      System.out.print(cakes3.pop() + ", ");
    }
    System.out.println();

  }//end main

}//end class
