// Team Fred - [FILL OUT LATER]
// APCS pd8
// HW72 - So So Fast
// 2022-03-08
// time spent: 1 hrs

/**
* ALGO
* 
* DISCO
*
* QCC
*
* q0: What does it do?
*
* q1: What is its Big-Oh runtime?
* 
**/
import java.util.Arrays;

public class FastSelect{
 
 //----------------------------HELPERS----------------------------//
 //swap an array
 public static void swap(int[] arr, int c, int b){
     int temp = arr[c];
     arr[c] = arr[b];
     arr[b] = temp;
 } 
 //shuffle an array (from closet's HW71)
 public static void shuffle( int[] d )
 {
   int tmp;
   int swapPos;
   for( int i = 0; i < d.length; i++ ) {
     tmp = d[i];
     swapPos = i + (int)( (d.length - i) * Math.random() );
     swap(d, i, swapPos);
   }
 } 
 
  //return int array of size s, with each element fr range [0,maxVal) (from closet's HW71)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  public static int partition(int[] arr, int low, int high, int pvtOriginal){
      int pvtPos = 0; 
      int pvtVal = arr[pvtOriginal];
      swap(arr, pvtOriginal, high);
      pvtPos = low;
      for(int i=low; i<high;i++){
          if(arr[i]<pvtVal){
              swap(arr, pvtPos, i);
              pvtPos++;
          }
      }
      swap(arr, high, pvtPos);
      return pvtPos;
  } 
 //----------------------------HELPERS END----------------------------//
 
 public static int FastSelect(int y, int[] arr){
  //Categorize the execution time of your algorithm using Big-Oh notation.
  return arr[y];
 }
  
 public static void main(String[] args){
    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};
    // run FastSelect on each array,
    // holding a & b fixed, varying c...
    System.out.println("arr1: ");
    Arrays.toString(arr1);
    System.out.println("Select i-th smallest value of the array");
    for(int i=0;i<arr1.length;i++){
      System.out.println(FastSelect(i, arr1));
    }
    System.out.println("-----------------------");
  
  //build test calls
   
  //Describe best- and worst-case scenarios and Big-O classification for each. 
  //Include test calls in your main method illustrating each.
 }
}
