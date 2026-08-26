class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        // int n = s.length();
        // int maxLen = Integer.MAX_VALUE;
        // String smallest = "";
      
        // for(int left = 0; left < n; left++){
        //     int ones = 0;
        //     StringBuilder sb = new StringBuilder();
        //     for(int right = left; right < n; right ++){
        //         if(s.charAt(right) == '1') ones++;
        //         sb.append(s.charAt(right));
        //         if(ones>k) break;
        //         if(ones == k){
        //             String curr = sb.toString();
        //             if(smallest.isEmpty() || curr.length() < smallest.length() || (curr.length() == smallest.length() && curr.compareTo(smallest)<0)){
        //                 smallest = curr;
        //             }
        //         } 
        //     }
        // }
        // return smallest;
        int n = s.length();

        int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1')
                ones++;

            // Too many ones -> move left
            while (ones > k) {
                if (s.charAt(left) == '1')
                    ones--;

                left++;
            }

            // We have exactly k ones
            if (ones == k) {

                // Remove unnecessary leading zeros
                while (left < right && s.charAt(left) == '0') {
                    left++;
                }

                String cur = s.substring(left, right + 1);

                if (ans.isEmpty() ||
                    cur.length() < ans.length() ||
                    (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {

                    ans = cur;
                }
            }
        }

        return ans;
    }
}