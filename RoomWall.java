package snakegame;

public class RoomWall extends BoardComponent {
 
    public RoomWall(char icon) {
        setIcon(icon);
    }
 
 
    public void addRoomWallRow(Board board, RoomWall wall, int rowNumber) {
        for (int i = 0; i < board.getBoardWidth(); i++) {
            board.setObjectOnLocation(wall, i, rowNumber);
        }
    }
 
    
    public void addRoomWallColumn(Board board, RoomWall wall, int columnNumber) {
        for (int i = 0; i < board.getBoardHeight(); i++) {
            board.setObjectOnLocation(wall, columnNumber, i);
        }
    }
}