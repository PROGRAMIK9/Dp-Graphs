class Solution {
    public String findOrder(String[] words) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[26];
        boolean[] exists = new boolean[26];
        for(String word : words) {
            for(char c : word.toCharArray()) {
                exists[c - 'a'] = true;
            }
        }
        for(int i = 0; i < words.length-1; i++){
            int minLen = Math.min(words[i].length(), words[i+1].length());
            boolean mismatch = false;
            for(int j  = 0; j<minLen; j++){
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    adj.get(words[i].charAt(j) - 'a').add(words[i+1].charAt(j)-'a');
                    indegree[words[i+1].charAt(j) - 'a']++;
                    mismatch = true;
                    break;
                }
            }
            if(!mismatch && words[i].length() > words[i+1].length()) return "";
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(exists[i]) count++;
            if(indegree[i] == 0 && exists[i]) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(!queue.isEmpty()){
            int letter = queue.poll();
            sb.append((char)(letter + 'a'));
            i++;
            for(int neigh : adj.get(letter)){
                indegree[neigh] --;
                if(indegree[neigh] == 0 ) queue.offer(neigh);
            }
        }
        // System.out.println(sb.toString());
        return i == count?sb.toString():"";
        
    }
}
