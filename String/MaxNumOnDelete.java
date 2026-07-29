// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    private static int findMax(String num, char digit){
        int n = num.length();
        int ind = -1;
        for(int i = 0; i < n; i++){
            // if(num.charAt(i) == digit){
            //     int val = Integer.parseInt(num.substring(0, i) + num.substring(i+1,n));
            //     max = Math.max(max, val);
            // }
            if(num.charAt(i) == digit){
                ind =  i;
                if(i < n-1 && num.charAt(i+1) > digit) break;
            }
        }
        return Integer.parseInt(num.substring(0, ind)+num.substring(ind+1));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number as a string");
        String num = s.nextLine();
        char dig = s.next().charAt(0);
        System.out.println(findMax(num, dig));
    }
}
