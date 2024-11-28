package Model;

public class TileAngle extends Tile{
    public TileAngle(){
    }

    @Override
    public TypeTile getType(){
        return TypeTile.ANGLE;
    }

    @Override
    public String affichage(){
        return "L";
    }
}
