/**
 * Eddie's Fanclub :: Ziying Jian, Andrey Sokolov, Joshua Gao
 * APCS pd08
 * HW95 -- Algorithm as Data Structure
 * 2022-05-09f
 * time spent: 1 hrs
 */

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * 
 * 
   1. a perfect binary tree has _____ nodes
   2. at each level, a perfect binary tree has _____ nodes
   3.height of a complete binary tree w/ n nodes is _____
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  public BST()
  {
    _root = null;
  }

  /**
   * overloaded
   */
  public BST( int newVal )
  {
    _root = new TreeNode(newVal);
  }

  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    if(_root == null){
      _root = new TreeNode( newVal );
    } else{
      insert( _root, new TreeNode(newVal));
    }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if(stRoot.getValue() < newNode.getValue()){ //check the right
      if(stRoot.getRight() == null){
        stRoot.setRight(newNode);
        newNode.setLeft(stRoot);
      } else if (stRoot.getRight().getValue() > newNode.getValue()) {
        TreeNode _temp = stRoot.getRight();
        stRoot.setRight(newNode);
        newNode.setRight(_temp);
        newNode.setLeft(stRoot);
      } else {
        insert( _root.getRight(), newNode);
      }
    } else if(stRoot.getValue() > newNode.getValue()){ //check the left
      if(stRoot.getLeft() == null){ 
        stRoot.setLeft(newNode);
        newNode.setRight(stRoot);
      } else if (stRoot.getLeft().getValue() < newNode.getValue()) {
        TreeNode _temp = stRoot.getLeft();
        stRoot.setLeft(newNode);
        newNode.setLeft(_temp);
        newNode.setRight(stRoot);
      } else {
        insert( _root.getLeft(), newNode);
      }
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    System.out.print(_root.getValue() + " ");
    if(_root.getLeft() != null ){
      preOrderTravLeft( _root.getLeft() );
    }
    if(_root.getRight() != null ){
      preOrderTravRight( _root.getRight() );
    }
  }
  
  public void preOrderTravLeft( TreeNode _currNode ){
    System.out.print(_currNode.getValue() + " ");

    if (_currNode.getLeft() != null){
      preOrderTravLeft(_currNode.getLeft());    
    } else return;
  }

  public void preOrderTravRight( TreeNode _currNode ){
    System.out.print(_currNode.getValue() + " ");
  
    if (_currNode.getRight() != null){
      preOrderTravRight(_currNode.getRight());    
    } else return;
   }

  // //recurse left, process root, recurse right
  // public void inOrderTrav()
  // {
  //   /*** YOUR IMPLEMENTATION HERE ***/
  // }
  // public void inOrderTrav( TreeNode currNode )
  // {
  //   /*** YOUR IMPLEMENTATION HERE ***/
  // }

  // //recurse left, recurse right, process root
  // public void postOrderTrav()
  // {
  //   /*** YOUR IMPLEMENTATION HERE ***/
  // }
  // public void postOrderTrav( TreeNode currNode )
  // {
  //   /*** YOUR IMPLEMENTATION HERE ***/
  // }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  //toString
  public String toString(){
    return "sussy";
  }


  //main method for testing
  public static void main( String[] args )
  {
    
    BST arbol = new BST();
    
      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );
//      arbol.insert( 0 );
      arbol.preOrderTrav();

      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
