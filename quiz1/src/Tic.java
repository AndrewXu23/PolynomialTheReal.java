public class Tic {
    private String board_name;
    private String[][] board;

    public Tic(String boardName) {
        this.board_name = boardName;
        this.board = new String[][] {
                {"_", "_", "_",},
                {"_", "_", "_",},
                {"_", "_", "_",} };//there could be just three columns instead of three
        //constructor should not return anything
    }

    public String getBoard_name() {//type here should be String
        return this.board_name;
    }

    public void setBoard_name(String bn) {
        this.board_name = bn;
    }

    public String getBoardCell(int row, int col) {
        return board[row][col];//self cannot be resolved as a variable
    }

    public void setBoardCell(int row, int col, String val) {
        this.board[row][col] = val;
    }
    //public void toString(int row, int col){
    //  for (int i = 0; i < board.size(); i++){
    //  return getBoardCell(int row, int col);
    //      }
    //  }
    // we need a toString method here
}
