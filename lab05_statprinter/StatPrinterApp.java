// Team Alpha Star - Andrey Sokolov + Geese + & Kevin Xiao + Mr. Swag
// APCS pd8
// L05 -- pulling it together
// 2022-02-03
// time spent: 1.5 hr

/***
 * class StatPrinterApp
 * driver for class StatPrinter
 ***/

import java.util.ArrayList;

public class StatPrinterApp
{
  public static void main( String[] args )
  {
    /*=================
      data:
      [2,5,2,3,4,4,4]

      desired _freq:
      [0,0,2,1,3,1]

      freq initially:
      [0,0,0,0,0,0]
      =================*/

    //declare and initialize an ArrayList typed for Integers
    ArrayList<Integer> al1 = new ArrayList<Integer>();
    al1.add(2);
    al1.add(5);
    al1.add(2);
    al1.add(3);
    al1.add(4);
    al1.add(4);
    al1.add(4);

    StatPrinter sp1 = new StatPrinter( al1 );
      System.out.println( "//---------------------------------------------------------------------------//" );
      System.out.println( "sp1 testing... " );
      System.out.println(sp1.max( al1 ));
      System.out.println(sp1); //[0, 0, 2, 1, 3, 1]
      System.out.println(sp1.getLocalModes());

      sp1.printHistogram( 50 );

    //---------------------------------------------------------------------------//
    //construct data [2,3,2,5,2,3]
    //   _frequency should be [0,0,3,2,0,1]
    ArrayList<Integer> al2 = new ArrayList<Integer>();
    al2.add(2);
    al2.add(3);
    al2.add(2);
    al2.add(5);
    al2.add(2);
    al2.add(3);

    StatPrinter sp2 = new StatPrinter( al2 );
    System.out.println( "//---------------------------------------------------------------------------//" );
    System.out.println( "sp2 testing: " );
    System.out.println( "al2 max: " + sp1.max(al2) );
    System.out.println( "local modes: " );
    for( Integer i : al2 ) {
    System.out.println( i + " is local mode?\t" + sp2.isLocalMode(i) );
    }
    System.out.println( "histogram:" );
    sp2.printHistogram( 50 );
    
    //---------------------------------------------------------------------------//
    ArrayList<Integer> al3 = new ArrayList<Integer>();
    al3.add(0);
    al3.add(1);
    al3.add(1);
    al3.add(2);
    al3.add(3);
    al3.add(3);
    al3.add(3);
    al3.add(3);
    al3.add(3);
    al3.add(4);
    al3.add(4);
    al3.add(4);
    al3.add(4);
    al3.add(4);
    al3.add(5);
    al3.add(5);
    al3.add(5);
    al3.add(5);
    al3.add(5);
    al3.add(5);
    al3.add(5);
    al3.add(5);
    al3.add(6);
    al3.add(6);
    al3.add(7);
    al3.add(7);
    al3.add(7);
    al3.add(7);
    StatPrinter sp3 = new StatPrinter( al3 );

    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
      System.out.println( "//---------------------------------------------------------------------------//" );
      System.out.println( "sp3 testing... " );
      System.out.println(sp3.max( al3 ));
      System.out.println(sp3); //[1,2,1,5,5,8,2,4]
      System.out.println(sp3.getLocalModes());
  }
}//end StatPrinterApp
