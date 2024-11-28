package Model;

public class TileFactory {
    public TileFactory(){}
    public Tile createTileAngle(){
        return new TileAngle();
    }

    public Tile createTileLine(){
        return new TileLine();
    }

    public Tile createTileT(){
        return new TileT();
    }
}
