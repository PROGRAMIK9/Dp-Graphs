class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> res = new ArrayList<>();
        // HashMap<Integer, List<String>> map = new HashMap<>();
        // for(String str:strs){
        //     int key = 0;
        //     for(char s: str.toCharArray()){
        //         key += (int)(s-'a');
        //     }
        //     map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        // }
        // int i = 0;
        // for(int key: map.keySet()){
        //     res.add(map.get(key));
        // }
        // return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
           int count[] = new int[26];
           for(char c : str.toCharArray()){
            count[c-'a']++;
           }
           String key = Arrays.toString(count);
           map.computeIfAbsent(key, k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
