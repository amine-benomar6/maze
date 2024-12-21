package Model;

public class TileT extends Tile{
    public TileT(){
        super(false,true,true,true);
    }

    /**
     * Retourne le type de tuile
     * @return type de tuile
     */

    @Override
    public TypeTile getType(){
        return TypeTile.T;
    }

    /**
     * Tourne la tuile dans une direction
     * @param direction nouvelle direction de la tuile
     */
    @Override
    public void rotate(Direction direction){
        switch (direction){
            case TOP:
                setOpenTop(false);
                setOpenRight(true);
                setOpenBottom(true);
                setOpenLeft(true);
                notifyRotate(Direction.TOP);
                break;
            case RIGHT:
                setOpenTop(true);
                setOpenRight(false);
                setOpenBottom(true);
                setOpenLeft(true);
                notifyRotate(Direction.RIGHT);
                break;
            case BOTTOM:
                setOpenTop(true);
                setOpenRight(true);
                setOpenBottom(false);
                setOpenLeft(true);
                notifyRotate(Direction.BOTTOM);
                break;
            case LEFT:
                setOpenTop(true);
                setOpenRight(true);
                setOpenBottom(true);
                setOpenLeft(false);
                notifyRotate(Direction.LEFT);
                break;
        }
    }

    /**
     * Affiche la tuile dans la console
     * @return tuile sous forme console
     */

    @Override
    public String output(){
        String affichage="[T";
        if(getIsOpenTop()){affichage+="O";}
        else{affichage+="X";}
        if(getIsOpenRight()){affichage+="O";}
        else{affichage+="X";}
        if(getIsOpenBottom()){affichage+="O";}
        else{affichage+="X";}
        if(getIsOpenLeft()){affichage+="O";}
        else{affichage+="X";}
        affichage+="]";

        return affichage;
    }
}
