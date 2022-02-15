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
  //triangle
  public static int triangle(int rows) {
    if(rows > 1) return rows + triangle(rows-1);
    else return rows;
  }
  //sumDigits
  public static int sumDigits(int n){
    if(n>9) return n%10 + sumDigits(n/10);
    else return n;
  }
  //count7
  public static int count7(int n) {
    if(n%10==7 && n>9) return 1 + count7(n/10);
    else if(n%10==7) return 1;
    else if(n>9) return 0 + count7(n/10);
    else return 0;
  }
  //count8
  public static int count8(int n) {
    if (n == 0){
      return 0;
    } else if (n%100 == 88){
      return 2 + count8(n/10);
    } else if (n%10 == 8){
      return 1 + count8(n/10);
    } else {
      return count8(n/10);
    } 
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
    System.out.println(triangle(1)); //returns 1
    System.out.println(triangle(6)); //returns 21
    System.out.println(sumDigits(126)); //returns 9
    System.out.println(sumDigits(1111)); //returns 4
    System.out.println(count7(7)); //returns 1
    System.out.println(count7(99999)); //returns 0
    System.out.println(count8(8)); //returns 1
    System.out.println(count8(88)); //returns 3
  }
}
