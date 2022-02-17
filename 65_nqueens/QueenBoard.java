/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if(col>=this._board.length){
      return true;
    }
    for (int row = 0; row < this._board.length; row++){
      if (addQueen(row, col)) {
        if (solveH(col+1)) {
          return true;
        } 
        else{
          removeQueen(row, col);
        }
      }
    } 
    return false;
    }
  

    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
  public void printSolution()
  {
    String board = "";
    for(int y = 0;y<_board.length;y++){
      for (int x=0;x<_board[y].length;x++){
        if(_board[y][x]!=1) board+= "_ ";
        else board+= "Q ";
      }
    board+="\n";
    }
    System.out.println(board);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * tries adding a Queen onto the board to see if it fits.
   * precondition: row and col are valid coordinates on the board
   * postcondition: the queen is added, attacking the board tiles in the process
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * removes a Queen off the board if need be
   * precondition: row and col are valid coordinates on the board
   * postcondition: the queen is removed, freeing the board tiles it was attacking
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * displays the chess board on the screen, with the represented by a 1, free spaces represented by 0, and spaces attacked represented by numbers <0
   * precondition: there exists a board
   * postcondition: displays the board on the user's screen
   */
  public String toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard ad = new QueenBoard(6);
    ad.solve();
    ad.printSolution();
    System.out.println(ad);

    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */

  }
}//end class
