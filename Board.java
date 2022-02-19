package snakegame;

public class Board {
	 
    private int width, height;
    private char[][] boardMatrix;


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.boardMatrix = new char[this.height][this.width];
    }

    public void initBoard() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.boardMatrix[i][j] = '.';
            }
        }
    }
     
    public void printBoard(int score) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.boardMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("[SCORE: "+score+"]");
    }

    public void ClearScreenLocation(int x, int y) {
        this.boardMatrix[y][x] = '.';
    }

    public int getBoardWidth() {
        return this.width;
    }
 
    public int getBoardHeight() {
        return this.height;
    }

    public char getObjectOnLocation(int x, int y) {
        return this.boardMatrix[y][x];
    }

    public void setObjectOnLocation(BoardComponent object, int x, int y) {
        this.boardMatrix[y][x] = object.getIcon();
    }
}