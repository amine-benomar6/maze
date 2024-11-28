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

    public Tile getTile(Position position){
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    public Tile getExtraTile() {
        return extraTile;
    }
}
