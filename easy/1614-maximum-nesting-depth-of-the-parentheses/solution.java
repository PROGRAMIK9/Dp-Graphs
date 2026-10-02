class Solution {
    public int maxDepth(String s) {
        Stack<Integer> stk = new Stack<>();
        int max  = 0;
        for(char ch: s.toCharArray()){
            if(ch == '(') stk.push(0);
            else if(ch == ')'){
                int length = stk.size();
                max = Math.max(max, length);
                stk.pop();
            }
        }
        return max;
    }
}