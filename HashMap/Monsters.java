// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    private static int findMax(int n , int exp, int power[], int bonus[]){
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < n; i++){
        //     map.put(power[i], bonus[i]);
        // }
        // Arrays.sort(power);
        // int monster = 0;
        // for(int i = 0; i < n; i++){
        //     if(power[i] <= exp ) {
        //         monster++;
        //         exp += map.get(power[i]);
        //     }else{
        //         break;
        //     }
        // }
        // return monster;
        int monster = 0;
        int[][] monsters = new int[n][2];
        for(int i = 0; i < n; i++){
            monsters[i][0] = power[i];
            monsters[i][1] = bonus[i];
        }
        Arrays.sort(monsters, (a,b)->Integer.compare(a[0],b[0]));
        for(int i = 0; i < n; i++){
            if(monsters[i][0] <= exp){
                monster++;
                exp += monsters[i][1];
            }else{
                break;
            }
        }
        return monster;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of monsters:");
        int n = s.nextInt();
        System.out.println("Enter the initial exp:");
        int exp = s.nextInt();
        System.out.println("Enter the number of power of n:");
        int[] power = new int[n];
        for(int i = 0; i < n; i++){
            power[i] = s.nextInt();
        }
        System.out.println("Enter the number of bonus of n:");
        int[] bonus = new int[n];
        for(int i = 0; i < n; i++){
            bonus[i] = s.nextInt();
        }
        System.out.println( findMax(n, exp, power, bonus) );
    }
}
