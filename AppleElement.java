package snakegame;

public class AppleElement extends BoardComponent {
	 
    public AppleElement(char symbol) {
        setIcon(symbol);
    }
 
    public void addRandomApple(Board screen, AppleElement apple, SnakeElement snake) {
    	
    	int x;
    	int y;
    	
    	while(true) {
    		 x = (int) (((Math.random()) * (screen.getBoardWidth() - 1)));
    		 y = (int) (((Math.random()) * (screen.getBoardHeight() - 1)));
    		 
    		 if((snake.isBody(x, y)== false) && (snake.isHead(x, y)==false)) {
    			 break;
    		 }
    	}
         
        if(x==0)
        {
            x = 2;
        }
         
        if(y==0)
        {
            y= 2;
        }
        screen.setObjectOnLocation(apple,x,y);

        this.setX(x);
        this.setY(y);
    }
}
