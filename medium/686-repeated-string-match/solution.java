class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(b == null) return 0;
        if(a.equals(b)) return 1;
        int iterations = 1;
        iterations += b.length() / a.length();
        if (b.length() % a.length() != 0) iterations++;

        StringBuilder repeatedA = new StringBuilder(a);

        for (int i = 1; i <= iterations; i++, repeatedA.append(a))
            if (repeatedA.indexOf(b) != -1)
                return i;

        return -1;

    }
}