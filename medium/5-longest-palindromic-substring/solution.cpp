class Solution {
    public:
    string longestPalindrome(string s) {
        int length = s.length();
        if(length==1)
        {
            return s;
        }
        std::string max_str = s.substr(0,1);
        for(int i=0;i<s.length();i++){
            std::string odd = expand(i,i,s);
            std::string even = expand(i,i+1,s);
            if(odd.length()>max_str.length()){
                max_str=odd;
            }
            if(even.length()>max_str.length()){
                max_str=even;
            }
        }
        return max_str;
    }
    
    string expand(int left, int right, string s) {
        while(left>=0 && right<s.length() && s[left]==s[right]){
            left--;
            right++;
        }
        return s.substr(left+1,right-left-1);
    }
};