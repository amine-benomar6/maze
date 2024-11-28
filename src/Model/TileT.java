package Model;

public class TileT extends Tile{
    public TileT(){}

    @Override
    public TypeTile getType(){
        return TypeTile.T;
    }

    @Override
    public String affichage(){
        return "T";
    }
}
