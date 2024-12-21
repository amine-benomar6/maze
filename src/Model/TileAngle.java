package Model;

import java.util.ArrayList;
import java.util.List;

public class TileAngle extends Tile{
    private List<BoardObserver> observers = new ArrayList<>();
    public TileAngle(){
        super(true, true,false,false); //La forme d'un L
    }

    /**
     * Retourne le type de tuile
     * @return type de tuile
     */
    @Override
    public TypeTile getType(){
        return TypeTile.ANGLE;
    }

    /**
     * Tourne la tuile dans une direction
     * @param direction nouvelle direction de la tuile
     */
    @Override
    public void rotate(Direction direction){
        switch (direction){
            case TOP:
                setOpenTop(true);
                setOpenRight(true);
                setOpenBottom(false);
                setOpenLeft(false);
                notifyRotate(Direction.TOP);
                break;
            case RIGHT:
                setOpenTop(false);
                setOpenRight(true);
                setOpenBottom(true);
                setOpenLeft(false);
                notifyRotate(Direction.RIGHT);
                break;
            case BOTTOM:
                setOpenTop(false);
                setOpenRight(false);
                setOpenBottom(true);
                setOpenLeft(true);
                notifyRotate(Direction.BOTTOM);
                break;
            case LEFT:
                setOpenTop(true);
                setOpenRight(false);
                setOpenBottom(false);
                setOpenLeft(true);
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
        String affichage="[L";
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
