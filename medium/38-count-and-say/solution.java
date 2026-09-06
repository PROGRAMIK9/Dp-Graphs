class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String prev = countAndSay(n-1);
        int currcnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < prev.length()-1; i++){
            while(i < prev.length()-1 && prev.charAt(i) == prev.charAt(i+1)){
                currcnt++;
                i++;
                System.out.println(currcnt+" "+i);
            }
            sb.append(currcnt);
            sb.append(prev.charAt(i));
            currcnt = 1;
        }
        if(prev.length()<=1 || prev.charAt(prev.length()-1) != prev.charAt(prev.length()-2)) sb.append("1"+prev.charAt(prev.length()-1));
        return sb.toString();
    }
}