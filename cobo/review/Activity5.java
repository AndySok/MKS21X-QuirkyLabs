public class Activity5 {

  static char[] vowels = {'a','e','i','o','u'};
  public static String piglatin(String word){
    word = word.toLowerCase();
    boolean temp = false;
    for (int i = 0; i < vowels.length; i++){
      if ((word.charAt(0) == vowels[i]) || (word.charAt(word.length()-1) == 'y')){
        temp = true;
      }
    }
    if (temp == true) {
      word = word.substring(1) + (word.charAt(0)) + "yay";
    } else{
      word = word.substring(1) + (word.charAt(0)) + "ay";
    }
    return word;
  }
  public static void main(String[] args){
    System.out.println(piglatin("Yay"));
    System.out.println(piglatin("bedroom"));
  }

}
