// Team Alpha Star - Andrey Sokolov + Geese & Kevin Xiao + Mr. Swag
// APCS pd8
// HW68 -- recursively probing for a closed cycle
// 2022-02-28m
// time spent: 1 hrs

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
 * 1. Create a board of (n+moatSize)*(n+moatSize) size, with moatSize depending on the value of n.
 * 2. begin the KnightsTour at a random position on the chessboard.
 * 3. Recursively try to "solve" (find a tour) from each of knight's available moves.
 * 4. If none of the moves work, backtrack to a previously made move to continue the recursion.
 * 5. when a winning tour is found, mark the board as "solved" and end the animation.
 * 6. by the end of the simulation, each of the board squares should be filled with the number of the move they were used on.
 *
 * DISCO
 * not every board is equal. as the boards get bigger, it gets a lot harder to compute a solvable set. 
 * the moat idea is ingenious, but it's hard to grasp without actually learning about it in class
 * 
 *
 * QCC
 * Why does the moat size differ with the different board size? 
 * At what point does using recursion become impractical when trying to solve Knight's Tour?
 * What's happening with rumpus-room records??
 * I wonder how Fred is doing... 
 *
 * Mean execution times for boards of size n*n:
 * n=5   83s    across 2 executions
 * n=6   128s    across 3 execution
 * n=7   computed for more than a minute    across 1 executions
 * n=8   computed for more than 5 minutes    across 1 executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "\u001b[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    //if(n<8) tf.findTour( 4, 4, 1 );
    //else tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    int moat = 2;
    if(n<8) moat+=2;
    int startX = (int)(Math.random()*n)+moat;//YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    int startY = (int)(Math.random()*n)+moat;//YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;
    int _moatSize = 2;
    if(n < 8) _moatSize += 2;
    //init 2D array to represent square board with moat
    _board = new int[_sideLength + _moatSize*2][_sideLength + _moatSize*2];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
     for(int y=0;y<_board.length;y++){
         for(int x=0;x<_board[y].length;x++){
            if((y >= _moatSize && x >= _moatSize) && y< (_board.length - _moatSize) && x< (_board.length - _moatSize)) _board[y][x] = 0;
            else _board[y][x] = -1;
         }
     }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "\u001b[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _board.length; i++ ) {
      for( j=0; j < _board[i].length; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved ) System.exit(0);

    //primary base case: tour completed
    if ( moves >= _sideLength * _sideLength && _board[y][x] == 0) {
      _board[y][x] = moves;
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if ( _board[y][x] != 0 ) {
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {
      //mark current cell with current move number
      _board[y][x] = moves;

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      int[] xOffset = {1, 2, 2, 1, -1, -2, -2, -1};
      int[] yOffset = {-2, -1, 1, 2, 2, 1, -1, -2};
      for(int i=0;i<8;i++){
          findTour(x+xOffset[i], y+yOffset[i], moves+1);
      }

      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
      _board[y][x] = 0;

      System.out.println( this ); //refresh screen
    }
  }//end findTour()

}//end class TourFinder
