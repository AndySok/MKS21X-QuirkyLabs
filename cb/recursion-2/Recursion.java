// Team Alpha Star - Andrey Sokolov + Geese & Kevin Xiao + Mr. Swag
// APCS pd8
// HW 64: Revisitation
// 2022-02-14
// time spent: 0.5 hrs
public class Recursion{
  //Group Sum
  public static boolean groupSum(int start, int[] nums, int target) { //DOESN'T WORK
    if(start>=nums.length) return target == 0;
    else return groupSum(start+1, nums, target-nums[start]);
  }
  public static void main(String[] args){
    int[] arr = {2, 4, 8};
    System.out.println(groupSum(0, arr, 9)); //returns false
  }
}
