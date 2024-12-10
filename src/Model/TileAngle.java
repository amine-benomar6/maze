package Model;

import java.util.ArrayList;
import java.util.List;

public class TileAngle extends Tile{
    private List<BoardObserver> observers = new ArrayList<>();
    public TileAngle(boolean isMovable){
        super(isMovable, true, true,false,false); //La forme d'un L
    }

    @Override
    public TypeTile getType(){
        return TypeTile.ANGLE;
    }

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

    @Override
    public String affichage(){
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
