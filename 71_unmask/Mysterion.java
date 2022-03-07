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