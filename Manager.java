package snakegame;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
 
        final int BOARD_WIDTH = 20; 
        final int BOARD_HEIGHT = 10; 
        final int START_X = BOARD_WIDTH / 2;
        final int START_Y = BOARD_HEIGHT / 2;
 
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        board.initBoard();
 
        RoomWall wall = new RoomWall('|');
        wall.addRoomWallRow(board, wall, 0); 
        wall.addRoomWallRow(board, wall, board.getBoardHeight() - 1); 
        wall.addRoomWallColumn(board, wall, 0); 
        wall.addRoomWallColumn(board, wall, board.getBoardWidth() - 1);
 
        SnakeElement snake = new SnakeElement('~', START_X, START_Y);
        board.setObjectOnLocation(snake, snake.getX(), snake.getY());
 
        AppleElement apple = new AppleElement('a');
        apple.addRandomApple(board, apple);

 
        Scanner scanner = new Scanner(System.in);
        char input;
 
 
        boolean isRunning = true;
        int score = 0;
 
        while (isRunning) {
            board.printBoard(score);
            switch (input = scanner.nextLine().charAt(0)) {
            case 'l':
                snake.moveLeft(board, snake);
                break;
            case 'r':
                snake.moveRight(board, snake);
                break;
            case 'u':
                snake.moveUp(board, snake);
                break;
            case 'd':
                snake.moveDown(board, snake);
                break;
            }
            if (check_eat(snake, apple)) {
            	apple.addRandomApple(board, apple);
            	score += 10;
            }
        }
    }
    public static boolean check_eat(SnakeElement snake, AppleElement apple) {
    if ((snake.getX() == apple.getX()) && (snake.getY() == apple.getY())) {
    	return true;
		}
    else {
    	return false;
    	}
    }
}