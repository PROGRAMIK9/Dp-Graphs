class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int maxLen = Integer.MAX_VALUE;
        String smallest = "";
      
        for(int left = 0; left < n; left++){
            int ones = 0;
            StringBuilder sb = new StringBuilder();
            for(int right = left; right < n; right ++){
                if(s.charAt(right) == '1') ones++;
                sb.append(s.charAt(right));
                if(ones>k) break;
                if(ones == k){
                    String curr = sb.toString();
                    if(smallest.isEmpty() || curr.length() < smallest.length() || (curr.length() == smallest.length() && curr.compareTo(smallest)<0)){
                        smallest = curr;
                    }
                } 
            }
        }
        return smallest;
    }
}