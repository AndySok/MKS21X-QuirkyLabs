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
     swap( i, swapPos, d );
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
 
 public static int FastSelect(){
   //Categorize the execution time of your algorithm using Big-Oh notation.
 }
  
 public static void main(String[] args){
   //build test calls
   
   //Describe best- and worst-case scenarios and Big-O classification for each. 
   //Include test calls in your main method illustrating each.
 }
}
