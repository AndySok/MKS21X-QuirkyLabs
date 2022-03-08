// Team Alpha Star - Andrey Sokolov + Geese & Kevin Xiao + Mr. Swag
// APCS pd8
// HW 71 - Whut Dis
// 2022-03-07
// time spent: 0.5 hrs

/*** 
 *  DISCO:
 * 
 *  - Its interesting that if you use the wrong values for a, b, and c the algorithm is not going to work.
 *  - Fred seemed pretty excited today! Didn't see a lot of George, though.
 * 
 *  QCC:
 * 
 *  - Is the point of the Mysterion to be an extremely fast sorter?
 *  - At what point does using this algorithm becomes useless?
 * 
 *  q0: What does it do?
 * 
 *  The Mysterion is an algorithm which takes in an array, and then sorts the array based on whether the values in the array are greater than
 *  arr[c], or lower than arr[c].
 * 
 *  q1: What is its Big-Oh runtime?
 * 
 *  The Big O notation of the Mysterion Algorithm is O(n).
 * 
***/

import java.util.Arrays;

public class Mysterion{
    public static void main(String[] args){
        int[] arr = {7, 1, 5, 12, 3};
        int a = 0;
        int b = 4;
        int c = 2;
        mysterion(arr, a, c, b);
        System.out.println(Arrays.toString(arr));
    }

   /**
   * int mysterion(int[],int,int,int)
   * The Mysterion is an algorithm which takes in an array, and then sorts the array based on whether the values in the array are greater than
   *  arr[c], or lower than arr[c].
   * 
   * @param arr the array which is being quicksorted.
   * @param a - the starting position at which sort initiates
   * @param b - the ending position of the sort
   * @param c - the "pivot" point of the sort
   * @return int 
   *
   */
    
    public static int[] mysterion(int[] arr, int a, int c, int b){
        int start = 0; 
        int boundary = arr[c];
        swap(arr, c, b);
        start = a;
        for(int i=a; i<b;i++){
            if(arr[i]<boundary){
                swap(arr, start, i);
                start++;
            }
        }
        swap(arr, b, start);
        return arr;
    }
    public static void swap(int[] arr, int c, int b){
        int temp = arr[c];
        arr[c] = arr[b];
        arr[b] = temp;
    }
}
