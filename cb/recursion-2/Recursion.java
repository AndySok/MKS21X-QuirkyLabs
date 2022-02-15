// Team Alpha Star - Andrey Sokolov + Geese & Kevin Xiao + Mr. Swag
// APCS pd8
// HW 64: Revisitation
// 2022-02-14
// time spent: 0.5 hrs
public class Recursion{
  //groupSum
  public boolean groupSum(int start, int[] nums, int target) {
    if (start>=nums.length){
      return (target == 0);
    }
    if (groupSum(start+1,nums,target-nums[start])){
      return true;
    }
    if (groupSum(start+1,nums,target)){
      return true;
    }
    return false;
  }

  //groupSum6
  public boolean groupSum6(int start, int[] nums, int target) {
  if (start>=nums.length){
    return (target == 0);
  }
  if(nums[start] ==6){
    if (groupSum6(start+1,nums,target-nums[start])){
      return true;
    } 
  } else {
    if (groupSum6(start+1,nums,target-nums[start])){
      return true;
    }
    if (groupSum6(start+1,nums,target)){
    return true;
    }
  }
  return false;

}
  //GroupNoAdj
  public boolean groupNoAdj(int start, int[] nums, int target) {
  if (start>=nums.length){
    return (target == 0);
  }
  if (groupNoAdj(start+2,nums,target-nums[start])){
      return true;
  }
  if (groupNoAdj(start+1,nums,target)){
    return true;
  }
  return false;
  }

  //groupSum5
  public boolean groupSum5(int start, int[] nums, int target) {
  if (start>=nums.length){
    return (target == 0);
  }
  if((nums[start] %5 == 0)){
    if(start == nums.length-1){
      if (groupSum5(start+1,nums,target-nums[start])){
        return true;
      }
    } else if(nums[start+1] == 1){
      if (groupSum5(start+2,nums,target-nums[start])){
        return true;
      }
    } else{
      if (groupSum5(start+1,nums,target-nums[start])){
        return true;
      }
    }

  }
  else {
    if (groupSum5(start+1,nums,target-nums[start])){
      return true;
    }
    if (groupSum5(start+1,nums,target)){
    return true;
    }
  }
  return false;
}
  public static void main(String[] args){
    int[] arr = {2,4,8};
    System.out.println(groupSum(0, arr, 10)); //returns true
    int[] arr2 = {9};
    System.out.println(groupSum6(0, arr2, 1)); //returns false
    int[] arr3 = {2, 5, 10, 4, 2};
    System.out.println(groupNoAdj(0, arr3, 7)); //returns true
    int[] arr4 = {3, 5, 1};
    System.out.println(groupSum5(0, arr4, 5)); //returns true
  }
}
