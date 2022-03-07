package snakegame;

public class SnakeElement extends BoardComponent {
	
	private int body_len;
	private int body_x[];
	private int body_y[];
	
	private char head_symbol;
	
	private boolean eat;
	
	private char direction;
	
	@Override
	public void setX(int newLocation) {
		this.body_x[0] = newLocation;
	}
	
	@Override
	public void setY(int newLocation) {
		this.body_y[0] = newLocation;
	}
	
	@Override
	public int getX() {
		return this.body_x[0];
	}
	
	@Override
	public int getY() {
		return this.body_y[0];
	}

    public SnakeElement(char symbol, int xStartingLocation, int yStartingLocation) {
        this.body_len = 1;
        this.body_x = new int[50];
        this.body_y = new int[50];
        
        this.head_symbol = 'o';
        this.eat = false;
        this.direction = 'r';
    	setIcon(symbol);
        setX(xStartingLocation);
        setY(yStartingLocation);
       
    }
    
    public void eat_apple() {
    	this.body_len += 1;
    	this.eat = true;
    }
    public boolean conflict_body() {
    	int x = this.body_x[0];
    	int y= this.body_y[0];
    	
    	return isBody(x,y);
    }
    
    
    public boolean isHead(int x, int y) {
    	if((x==body_x[0]) && (y == body_y[0])) {
    		return true;
    	}
    	return false;
    }
    public boolean isBody(int x, int y) {
    	for(int i=1; i<this.body_len; i++) {
    		if((x == body_x[i]) && (y == body_y[i])) {
    			return true;
    		}
    		
    	}
    	return false;
    }
    

    public void moveLeft(Board screen, SnakeElement snake) {
    	
    	if(snake.direction == 'r') {
    		return;
    	}
    	snake.direction = 'l';
    	
    	int[] new_location_x = new int[snake.body_len];
    	int[] new_location_y = new int[snake.body_len];
    	
        new_location_x[0] = snake.getX() - 1;
        new_location_y[0] = snake.getY();
        screen.setObjectOnLocation(snake.head_symbol, new_location_x[0], new_location_y[0]);
        
        for(int i=1;i<snake.body_len;i++) {
        	new_location_x[i] = snake.body_x[i-1];
        	new_location_y[i] = snake.body_y[i-1];
        	screen.setObjectOnLocation(snake, new_location_x[i], new_location_y[i]);
        }
        
        if (this.eat == true) {
        	this.eat = false;
        }
        else {
        	screen.ClearScreenLocation(snake.body_x[snake.body_len-1], snake.body_y[snake.body_len-1]);
        }
        this.body_x = new_location_x;
        this.body_y = new_location_y;
    }
     
    public void moveRight(Board screen, SnakeElement snake) {
    	
    	if(snake.direction == 'l') {
    		return;
    	}
    	snake.direction = 'r';
    	
    	
    	int[] new_location_x = new int[snake.body_len];
    	int[] new_location_y = new int[snake.body_len];
    	
    	new_location_x[0] = snake.getX() + 1;
    	new_location_y[0] = snake.getY();
    	screen.setObjectOnLocation(snake.head_symbol, new_location_x[0], new_location_y[0]);
    	
        for(int i=1;i<snake.body_len;i++) {
        	new_location_x[i] = snake.body_x[i-1];
        	new_location_y[i] = snake.body_y[i-1];
        	screen.setObjectOnLocation(snake, new_location_x[i], new_location_y[i]);
        }
    	
    	if (this.eat == true) {
    		this.eat = false;
    	}
    	else {
    		screen.ClearScreenLocation(snake.body_x[snake.body_len-1], snake.body_y[snake.body_len-1]);
    	}
        this.body_x = new_location_x;
        this.body_y = new_location_y;
    }
     
    public void moveUp(Board screen, SnakeElement snake) {
    	
    	if(snake.direction == 'd') {
    		return;
    	}
    	
    	snake.direction = 'u';
    	
    	int[] new_location_x = new int[snake.body_len];
    	int[] new_location_y = new int[snake.body_len];
    	
    	new_location_x[0] = snake.getX();
    	new_location_y[0] = snake.getY() - 1;
    	screen.setObjectOnLocation(snake.head_symbol, new_location_x[0], new_location_y[0]);
    	
        for(int i=1;i<snake.body_len;i++) {
        	new_location_x[i] = snake.body_x[i-1];
        	new_location_y[i] = snake.body_y[i-1];
        	screen.setObjectOnLocation(snake, new_location_x[i], new_location_y[i]);
        }
        
        if (this.eat == true) {
        	this.eat = false;
        }
        else {
        	screen.ClearScreenLocation(snake.body_x[snake.body_len-1], snake.body_y[snake.body_len-1]);
        }
        this.body_x = new_location_x;
        this.body_y = new_location_y;
    }
     
    public void moveDown(Board screen, SnakeElement snake) {
    	
    	if(snake.direction == 'u') {
    		return;
    	}
    	snake.direction = 'd';
    	
    	int[] new_location_x = new int[snake.body_len];
    	int[] new_location_y = new int[snake.body_len];
    	
    	new_location_x[0] = snake.getX();
    	new_location_y[0] = snake.getY() + 1;
    	screen.setObjectOnLocation(snake.head_symbol, new_location_x[0], new_location_y[0]);
    	
        for(int i=1;i<snake.body_len;i++) {
        	new_location_x[i] = snake.body_x[i-1];
        	new_location_y[i] = snake.body_y[i-1];
        	screen.setObjectOnLocation(snake, new_location_x[i], new_location_y[i]);
        }
        
        if (this.eat == true) {
        	this.eat = false;
        }
        else {
        	screen.ClearScreenLocation(snake.body_x[snake.body_len-1], snake.body_y[snake.body_len-1]);
        }
        this.body_x = new_location_x;
        this.body_y = new_location_y;
    }
}
