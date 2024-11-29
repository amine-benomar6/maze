package Model;

public class TileFactory {
    public TileFactory(){}
    public Tile createTileAngle(){
        return new TileAngle(true);
    }

    public Tile createTileLine(){
        return new TileLine(true);
    }

    public Tile createTileT(){
        return new TileT(true);
    }
}
