package snakegame;

public class SnakeElement extends BoardComponent {
	 
    public SnakeElement(char symbol, int xStartingLocation, int yStartingLocation) {
        setIcon(symbol);
        setX(xStartingLocation);
        setY(yStartingLocation);
    }
     
    public void moveLeft(Board screen, SnakeElement snake) {
        snake.setX(getX() - 1);
        screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
        screen.ClearScreenLocation(snake.getX() + 1, snake.getY());
    }
     
    public void moveRight(Board screen, SnakeElement snake) {
    	snake.setX(getX() + 1);
    	screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
    	screen.ClearScreenLocation(snake.getX() - 1, snake.getY());
    }
     
    public void moveUp(Board screen, SnakeElement snake) {
    	snake.setY(getY() - 1);
        screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
        screen.ClearScreenLocation(snake.getX(), snake.getY() + 1);
    }
     
    public void moveDown(Board screen, SnakeElement snake) {
    	snake.setY(getY() + 1);
        screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
        screen.ClearScreenLocation(snake.getX(), snake.getY() - 1);
    }
}