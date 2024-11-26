package Model;

public class TileFactory {
    public TileFactory(){}
    public Tile createTileL(){
        return new TileL();
    }

    public Tile createTileLine(){
        return new TileLine();
    }

    public Tile createTileT(){
        return new TileT();
    }
}
