class Solution {
    public int maxDepth(String s) {
        int c = 0, max = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                c++;
                max = Math.max(c,max);
            }
            else if(ch == ')')c--;
        }
        return max;
    }
}