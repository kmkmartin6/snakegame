package snakegame;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
    	
    	while(true) {
    		run_game();
    		if(!check_continue()) {
    			break;
    		}
    	}
    	System.out.println("FINISH !");
    }
    
    public static boolean check_continue() {
    	System.out.println("GAME OVER");
    	System.out.println("Do you want to start snake game?");
    	System.out.println("1: start, other: stop");
    	
        Scanner scanner = new Scanner(System.in);
        char input;
        input = scanner.nextLine().charAt(0);
 
        if (input == '1') {
        	return true;
        }
        else {
        	return false;
        }
    }
 
    public static void run_game() {
        final int BOARD_WIDTH = 20; 
        final int BOARD_HEIGHT = 10; 
        final int START_X = BOARD_WIDTH / 2;
        final int START_Y = BOARD_HEIGHT / 2;
 
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        board.initBoard();
 
        RoomWall wall = new RoomWall('ㅁ');
        wall.addRoomWallRow(board, wall, 0); 
        wall.addRoomWallRow(board, wall, board.getBoardHeight() - 1); 
        wall.addRoomWallColumn(board, wall, 0); 
        wall.addRoomWallColumn(board, wall, board.getBoardWidth() - 1);
 
        SnakeElement snake = new SnakeElement('~', START_X, START_Y);
        board.setObjectOnLocation(snake, snake.getX(), snake.getY());
 
        AppleElement apple = new AppleElement('a');
        apple.addRandomApple(board, apple, snake);

 
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
            	apple.addRandomApple(board, apple, snake);
            	snake.eat_apple();
            	score += 10;
            }
            else {
            	if (check_conflict_wall(snake, board) || check_conflict_body(snake)){
            		return;
            	}
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
    
    public static boolean check_conflict_wall(SnakeElement snake, Board board) {
    	if ((snake.getX() == 0) || (snake.getX() == (board.getBoardWidth() - 1)) || 
    			(snake.getY() == 0) || (snake.getY() == (board.getBoardHeight() -1))) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public static boolean check_conflict_body(SnakeElement snake){
    	
    	return snake.conflict_body();
    }
    
}
