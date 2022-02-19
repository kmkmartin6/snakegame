package snakegame;

public class BoardComponent {
    
    private int x, y;
    private char icon;
     
 
    public int getX() {
        return this.x;
    }
 
    public int getY() {
        return this.y;
    }
 
    public char getIcon() {
        return icon;
    }
 
    public void setX(int newLocation) {
        this.x = newLocation;
    }
     
    public void setY(int newLocation) {
        this.y = newLocation;
    }
     
    public void setIcon(char newSymbol) {
        this.icon = newSymbol;
    }
}