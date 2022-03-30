/***
Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
APCS PD8
HW 84: Stack: What Is It Good For?
2022-03-29
Spent: 0.5 hrs
 **/

/**
QCC:

DISCO:

 **/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes original = new Latkes(s.length());
    String output = "";
    String[] letters = s.split("");
    for(int i=0;i<letters.length;i++){
        original.push(letters[i]);
    }
    while(!original.isEmpty()){
        output+=original.pop();
    }
    return output;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    return true;
  }


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(flip("({}[()])"));

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class