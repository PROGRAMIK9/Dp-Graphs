class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int prev[] = new int[n];
        int next[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && heights[stk.peek()]>= heights[i]) stk.pop();
            if(stk.isEmpty()) prev[i] = -1;
            else prev[i] = stk.peek();
            stk.push(i);
        }

        while(!stk.isEmpty()) stk.pop();
        for(int i = n-1; i >=0 ; i--){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) stk.pop();
            if(stk.isEmpty()) next[i] = n;
            else next[i] = stk.peek();
            stk.push(i);
        }
        for(int i = 0; i < n; i++){
            int width = next[i] - prev[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}