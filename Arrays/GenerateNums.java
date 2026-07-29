// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    private static int generate(int num){
        if(num == 0) return 0;
        int[] nums =  new int[num+1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for(int i =2; i<=num; i++){
            if(i%2 == 0) nums[i] = nums[i/2];
            else nums[i] = nums[i/2] + nums [i/2 + 1];
            max = Math.max(nums[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number as a string");
        int num = s.nextInt();
        int nums = generate(num);
        System.out.println(nums);
    }
}
