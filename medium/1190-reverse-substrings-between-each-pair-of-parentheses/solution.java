class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                // Store the index where this nested segment begins inside 'sb'
                stk.push(sb.length());
            } else if (ch == ')') {
                // Get the starting boundary of the matching inner parenthesis
                int start = stk.pop();
                // Reverse only the segment within 'sb' from 'start' to the end
                reverseSegment(sb, start, sb.length());
            } else {
                // Append regular characters directly
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    private void reverseSegment(StringBuilder sb, int start, int end) {
        String sub = sb.substring(start, end);
        String rev = new StringBuilder(sub).reverse().toString();
        sb.replace(start, end, rev);
    }
}
