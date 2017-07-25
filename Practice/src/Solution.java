import java.util.Scanner;

public class Solution {
    static int counter = 0;

    public static void main(String[] args) {

//        Solution ss = new Solution();
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
        //ss.counterSosMessage(str);
        System.out.println(counterSosMessage("SOSOOSOSOSOSOSSOSOSOSOSOSOS")); //ss.counter);
    }

    private static int counterSosMessage(String str) {
        System.out.println(str);
        if (str.length() < 3) {
            return counter;
        }

        if (str.length() == 3) {
            if (str.charAt(0) == 'S' && str.charAt(2) == 'S') {
                counter++;
                return counter;
            }
            return counter;
        }

        for (int i = 2; i < str.length(); i++) {

            if (str.charAt(0) == 'S' && str.charAt(i) == 'S') {
                counter++;

                if (str.length() > 3) {
                    counterSosMessage(str.substring(i));
                    break;
                }
            }
        }
        return counter;
    }
}




//input string :SOSOOSOSOSOSOSSOSOSOSOSOSOS