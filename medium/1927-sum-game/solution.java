class Solution {
    public boolean sumGame(String num) {
        // int first = 0;
        // int second = 0;
        // int firstSum = 0, secondSum = 0;
        // for(int i = 0; i < num.length()/2; i++){
        //     if(num.charAt(i) == '?') first++;
        //     else firstSum += num.charAt(i)-'0';
        // }
        // for(int i = num.length()/2; i < num.length(); i++){
        //     if(num.charAt(i) == '?') second++;
        //     else secondSum += num.charAt(i)-'0';
        // }
        // int ques = first+second;
        // System.out.println(firstSum +" "+secondSum);
        // if(ques%2 != 0) return true;
        // else{
        //     if(firstSum-secondSum == 9/2*(second-first)) return false;
        // }
        // if(secondSum == firstSum && first == second) return false;
        // if((first == 0 && second == 2) || (first == 2 && second == 0)){
        //     if(Math.abs(firstSum - secondSum) == 9) return false;
        //     else return true;
        // }
        // return true;
        int n = num.length();
        int[] left = get(num.substring(0, n / 2));
        int[] right = get(num.substring(n / 2, n));

        int n0 = left[0],
            q0 = left[1];
        int n1 = right[0],
            q1 = right[1];

        return (q0 + q1) % 2 == 1 || n0 - n1 != ((q1 - q0) * 9) / 2;
    }
    private int[] get(String s) {
        int nn = 0,
            qq = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                qq++;
            } else {
                nn += ch - '0';
            }
        }
        return new int[] { nn, qq };
    }
}