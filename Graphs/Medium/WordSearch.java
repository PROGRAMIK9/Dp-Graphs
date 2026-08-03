class Solution {
    // StringBuilder sb = new StringBuilder();
    private boolean dfs(char[][]board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j]!=word.charAt(index)) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean result = dfs(board, word, i+1, j, index+1) ||
        dfs(board, word, i, j+1, index+1) ||
        dfs(board, word, i-1, j, index+1) ||
        dfs(board, word, i, j-1, index+1);
        board[i][j] = c;
        return result;

    }
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j  = 0; j< board[i].length; j++){
                if(board[i][j] == words[0]){
                    if(dfs(board, word, i, j,0)) return true;
                }
            }
        }
        return false;
    }
}
