class Solution {
    public int smallestNumber(int n, int t) {
        int value = product(n);
        while(value%t!=0){
            n++;
            value = product(n);
        }
        return n;
    }
    private int product(int n){
        int prod = 1;
        while(n!=0){
            prod *= n%10;
            n /= 10;
        }
        return prod;
    }
}