class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
        int index = 1;
        for(char c: s.toCharArray()){
            int charvl = 26 - (c-'a');
            // System.out.println(index+" "+charvl);
            degree+=charvl*index;
            index++;
        }
        return degree;
    }
}