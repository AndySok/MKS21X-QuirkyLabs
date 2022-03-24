/***
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 *  overriding List interface from standard Java library
 **/

public class ListTester
{
  public static void main( String[] args )
  {

    //instantiate... var type List, obj type LList
    List wu = new LList();

    wu.add("RZA");
    System.out.println(wu);

    wu.add("GZA");
    System.out.println(wu);

    wu.add("ODB");
    System.out.println(wu);

    wu.add("Inspectah Deck");
    System.out.println(wu);

    wu.add("Raekwon the Chef");
    System.out.println(wu);

    wu.add("U-God");
    System.out.println(wu);


    System.out.println(wu);
    wu.add("Ghostface");

    System.out.println(wu);
    wu.add("Method Man");

    System.out.println(wu);

    for( int i=0; i<7; i++ ) {
    int n = (int)( wu.size() * Math.random() );
    System.out.println("adding a poser at index " + n + "...");
    wu.add( n, "@" );
    System.out.println("Updated list: " + wu);
    }

    while( wu.size() > 0 ) {
    int n = (int)( wu.size() * Math.random() );
    System.out.println("deleting node "+ n + "...");
    wu.remove(n);
    System.out.println("Updated list: " + wu);
    }

    System.out.println("-------------------------------------------");
    LList<Integer> inte = new LList<Integer>();
    inte.add(5);
    inte.add(20);
    inte.add(13);
    inte.add(2);
    System.out.println(inte);
    for( int i=0; i<7; i++ ) {
      int n = (int)( inte.size() * Math.random() );
      System.out.println("adding a poser at index " + n + "...");
      inte.add( n, n*7 );
      System.out.println("Updated list: " + inte);
      }
    //*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
