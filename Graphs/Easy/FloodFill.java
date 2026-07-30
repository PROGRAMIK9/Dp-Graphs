class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]!=color)
            changeMat(image,sr,sc,color,image.length, image[0].length, image[sr][sc]);
        return image;
    }
    private void changeMat(int[][] image, int sr, int sc , int color, int m , int n, int init){
        if(sr < 0 || sc < 0 || sr >=m ||sc >= n || image[sr][sc] != init)  return;
        image[sr][sc] = color;
        changeMat(image, sr+1, sc, color, m, n, init);
        changeMat(image, sr-1, sc, color, m, n, init);
        changeMat(image, sr, sc-1, color, m, n, init);
        changeMat(image, sr, sc+1, color, m, n, init);
    }
}
