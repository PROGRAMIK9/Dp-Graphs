class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        String word= "";
        for(char c: paragraph.toCharArray()){
            if(!Character.isLetter(c)){
                if(word.length()>0){
                    map.put(word, map.getOrDefault(word, 0)+1);
                    word = "";
                }
            }else{
                word += Character.toLowerCase(c);     
            }
        }
        if(word.length()>0) map.put(word, map.getOrDefault(word, 0)+1);
        HashSet<String> list = new HashSet<>();
        for(String words: banned){
            list.add(words);
        }
        int max  = 0;
        String res = "";
        for(String key: map.keySet()){
            if(list.contains(key)){
                continue;
            }
            else{
                if(map.get(key)>max){
                    res = key;
                    max = map.get(key);
                } 
            }
        }
        return res;
    }
}
