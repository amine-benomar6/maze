package Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<Tile> tiles;
    private Tile extraTile;
    private TileFactory tileFactory = new TileFactory();

    public Board() {
        tiles = new ArrayList<>();
        initializeBoard();
    }

    public void initializeBoard(){
        for(int i=0; i<20; i++){
            tiles.add(tileFactory.createTileL());
        }

        for(int i=0; i<12; i++){
            tiles.add(tileFactory.createTileLine());
        }

        for(int i=0; i<17; i++){
            tiles.add(tileFactory.createTileT());
        }

        Collections.shuffle(tiles);

        extraTile=tileFactory.createTileT();
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public Tile getExtraTile() {
        return extraTile;
    }
}
