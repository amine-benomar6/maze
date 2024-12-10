package Model;

public class TileFactory {
    public TileFactory(){}
    public Tile createTileAngle(boolean isMovable){
        return new TileAngle(isMovable);
    }

    public Tile createTileLine(boolean isMovable){
        return new TileLine(isMovable);
    }

    public Tile createTileT(boolean isMovable){
        return new TileT(isMovable);
    }
}
