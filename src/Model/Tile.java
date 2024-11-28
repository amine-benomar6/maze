package Model;

public abstract class Tile {
    Position position;
    Tile(){
    }
    public abstract TypeTile getType();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position){
        this.position=position;
    }

    public abstract String affichage();
}
