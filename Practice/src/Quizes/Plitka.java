package Quizes;

public class Plitka{
    public int dp(int w){
        if(w == 1){
            return 1;
        }
        if(w == 2){
            return 2;
        }
        int prev1 = 1;
        int prev2 = 2;
        int current = 0;
        for(int i = 3; i <= w; ++i){
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    public static void main(String[] args){
        int w = 5;
        Plitka solution = new Plitka();
        System.out.println(solution.dp(w));
        
        System.out.println("Modulus: " + 5/2 + " rest: " + 5%2);
        System.out.println("Answ: " + ((w/2)^2 - 1));
    }
}