public class MRKPirateBae {
    public static void main(String[] args){
        //props to THEODORE YOCHUM for writing this lovely main like 3 weeks ago :D

        //test add at first 
        QQKachoo<Integer> test = new QQKachoo<Integer>();
        for (int i = 0; i < 15; i++) {
          test.addLast(i);
        } 
        System.out.println("Should print a deque of numbers 0 to 14 in linear order incrementing by 1");
        System.out.println(test);

        //test add at end
          QQKachoo<Integer> test2 = new QQKachoo<Integer>();
          for (int i = 0; i < 15; i++) {
            test2.addFirst(i);
          }
          System.out.println("Should print a deque of numbers 14 to 0 in reverse linear order deceremnting by 1");
          System.out.println(test2);

        //test remove at first
        test.removeFirst();
        test.removeLast(); 
        System.out.println("Remove first and last elements, which are 0 and 14");
        System.out.println(test);

        
      }//end of main
        
}//end of class 
