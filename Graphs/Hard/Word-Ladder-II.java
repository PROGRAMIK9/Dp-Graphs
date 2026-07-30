class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        // for(String s: wordList) set.add(s);
        if(!set.contains(endWord)) return res;
        Map<String, List<String>> adj = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        boolean foundEnd = false;
        while(!currentLevel.isEmpty()){
            set.removeAll(currentLevel);
            Set<String> nextLevel = new HashSet<>();
            for(String current: currentLevel){
                char[] word = current.toCharArray();
                for(int i = 0; i < word.length; i++){
                    char originalChar = word[i];
                    for(char j = 'a'; j <= 'z'; j++){
                        if(word[i] == j) continue;
                        word[i] = j;
                        String temp = String.valueOf(word);
                        if(set.contains(temp)){
                            adj.computeIfAbsent(temp, k -> new ArrayList<>()).add(current);
                            nextLevel.add(temp);
                            if(temp.equals(endWord)){
                                foundEnd = true;
                            }
                        }
                    }
                    word[i] = originalChar;
                }
            }
            if(foundEnd) break;
            currentLevel = nextLevel;
        }
        if(foundEnd){
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, adj, path, res);
        }
        return res;
    }
    private void backtrack(String current, String endWord, Map<String,List<String>> adj, List<String> path, List<List<String>> res){
        if(current.equals(endWord)){
            List<String> valid = new ArrayList<>(path);
            Collections.reverse(valid);
            res.add(valid);
            return;
        }
        if(!adj.containsKey(current)) return;
        for(String next : adj.get(current)){
            path.add(next);
            backtrack(next, endWord, adj, path, res);
            path.remove(path.size()-1);
        }
    }
}
