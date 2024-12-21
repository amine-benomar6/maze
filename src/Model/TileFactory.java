package Model;

public class TileFactory {
    public TileFactory(){}

    /**
     * Créer une tuile en forme d'angle
     * @return la tuile créé
     */
    public Tile createTileAngle(){
        return new TileAngle();
    }

    /**
     * Créer une tuile en forme de ligne
     * @return la tuile créé
     */
    public Tile createTileLine(){
        return new TileLine();
    }

    /**
     * Créer une tuile en forme de T
     * @return la tuile créé
     */
    public Tile createTileT(){
        return new TileT();
    }
}
