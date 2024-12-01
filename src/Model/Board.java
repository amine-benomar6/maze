package Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private Tile[][] tiles;
    private Tile extraTile;
    private TileFactory tileFactory = new TileFactory();

    public Board() {
        tiles = new Tile[7][7];
        initializeBoard();
    }

    public void initializeBoard(){
        int totalIndex = 0;

        for(int i=0; i<20; i++){
            int line = totalIndex / 7;
            int colum = totalIndex % 7;
            Position position=new Position(line,colum);
            tiles[line][colum] = tileFactory.createTileAngle();
            tiles[line][colum].setPosition(position);
            totalIndex++;
        }

        for(int i=0; i<12; i++) {
            int line = totalIndex / 7;
            int colum = totalIndex % 7;
            Position position=new Position(line,colum);
            tiles[line][colum] = tileFactory.createTileLine();
            tiles[line][colum].setPosition(position);
            totalIndex++;
        }

        for(int i=0; i<17; i++){
            int line = totalIndex / 7;
            int colum = totalIndex % 7;
            Position position=new Position(line,colum);
            tiles[line][colum] = tileFactory.createTileT();
            tiles[line][colum].setPosition(position);
            totalIndex++;
        }


        extraTile=tileFactory.createTileT();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void pushRow(int row, Direction direction){
        Tile extraTileTemp=getExtraTile();
        if(direction==Direction.LEFT){
            extraTile=tiles[row][6];
            for(int i=6; i>0; i--){
                tiles[row][i]=tiles[row][i-1];
            }
            tiles[row][0]=extraTileTemp;}
        else if(direction==Direction.RIGHT){
            extraTile = tiles[row][0];
            for (int i = 0; i < 6; i++) {
                tiles[row][i] = tiles[row][i + 1];
            }
            tiles[row][6] = extraTileTemp;
        }
        else{
            throw new IllegalArgumentException("Direction invalide. Utilisez RIGHT ou LEFT.");
        }
    }

    public void pushColumn(int colum, Direction direction) {
        Tile extraTileTemp = getExtraTile();

        if (direction == Direction.TOP) {
            extraTile = tiles[6][colum];
            for (int i = 6; i > 0; i--) {
                tiles[i][colum] = tiles[i - 1][colum];
            }
            tiles[0][colum] = extraTileTemp;
        } else if (direction == Direction.BOTTOM) {
            extraTile = tiles[0][colum];
            for (int i = 0; i < 6; i++) {
                tiles[i][colum] = tiles[i + 1][colum];
            }
            tiles[6][colum] = extraTileTemp;

        } else {
            throw new IllegalArgumentException("Direction invalide. Utilisez TOP ou BOTTOM.");
        }
    }

    public Tile getTile(Position position){
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    public Tile getExtraTile() {
        return extraTile;
    }
    public void setExtraTile(Tile extraTile) {
        this.extraTile=extraTile;
    }

}
