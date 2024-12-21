package Model;

public class TileLine extends Tile{
    public TileLine(){
        super(false,true,false,true);
    }

    /**
     * Retourne le type de tuile
     * @return type de tuile
     */

    @Override
    public TypeTile getType(){
        return TypeTile.LINE;
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
                setOpenBottom(false);
                setOpenLeft(true);
                notifyRotate(Direction.TOP);
                break;
            case RIGHT:
                setOpenTop(true);
                setOpenRight(false);
                setOpenBottom(true);
                setOpenLeft(false);
                notifyRotate(Direction.RIGHT);
                break;
            case BOTTOM:
                setOpenTop(false);
                setOpenRight(true);
                setOpenBottom(false);
                setOpenLeft(true);
                notifyRotate(Direction.BOTTOM);
                break;
            case LEFT:
                setOpenTop(true);
                setOpenRight(false);
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
        String affichage="[-";
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
