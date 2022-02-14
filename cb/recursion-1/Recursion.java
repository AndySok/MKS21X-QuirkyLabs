public class Recursion{
  //factorial
  public static int factorial(int n){
    if(n==0) return 1;
    else return n * factorial(n-1);
  }
  //bunnyEars
  public static int bunnyEars(int bunnies){
    if(bunnies == 0) return 0;
    else return 2 + bunnyEars(bunnies-1);
  }
  //fibonacci
  public static int fibonacci(int n) {
    if(n==0) return 0;
    else if(n==1) return 1;
    else return fibonacci(n-1) + fibonacci(n-2);
  }
  //bunnyEars
  public static int bunnyEars2(int bunnies){
    if(bunnies == 0) return 0;
    else if(bunnies % 2 == 0) return 3 + bunnyEars2(bunnies-1);
    else return 2 + bunnyEars2(bunnies-1);
  }
  public static void main(String[] args){
    System.out.println(factorial(4)); //returns 24
    System.out.println(factorial(6)); //returns 720
    System.out.println(bunnyEars(2)); //returns 4
    System.out.println(bunnyEars(50)); //returns 100
    System.out.println(fibonacci(0)); //returns 0
    System.out.println(fibonacci(5)); //returns 5
    System.out.println(bunnyEars2(3)); //returns 7
    System.out.println(bunnyEars2(10)); //returns 25
  }
}
