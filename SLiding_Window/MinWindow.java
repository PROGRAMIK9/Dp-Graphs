class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[128];
        int[] track = new int[128];
        int need = 0;
        int have = 0;
        for(char c: t.toCharArray()){
            freq[c]++;
            if(freq[c] == 1) need++;
        }
        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end  = 0;
        int left  = 0;
        for(int right  = 0; right < s.length(); right++){
            char c = s.charAt(right);
            track[c]++;
            if(track[c] == freq[c]) have++;
            while(need == have){
                if((right-left+1)<minWindow){
                    start = left;
                    end = right;
                    minWindow = (right-left+1);
                }
                track[s.charAt(left)]--;
                if(track[s.charAt(left)]<freq[s.charAt(left)]) have--;
                left++;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start,end+1);
    }
}
