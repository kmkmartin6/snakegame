package snakegame;

public class AppleElement extends BoardComponent {
	 
    public AppleElement(char symbol) {
        setIcon(symbol);
    }
 
    public void addRandomApple(Board screen, AppleElement apple) {
         
        int x = (int) (((Math.random()) * (screen.getBoardWidth() - 1)));
        int y = (int) (((Math.random()) * (screen.getBoardHeight() - 1)));
 
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