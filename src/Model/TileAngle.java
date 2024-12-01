package Model;

public class TileAngle extends Tile{
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
                break;
            case RIGHT:
                setOpenTop(false);
                setOpenRight(true);
                setOpenBottom(true);
                setOpenLeft(false);
                break;
            case BOTTOM:
                setOpenTop(false);
                setOpenRight(false);
                setOpenBottom(true);
                setOpenLeft(true);
                break;
            case LEFT:
                setOpenTop(true);
                setOpenRight(false);
                setOpenBottom(false);
                setOpenLeft(true);
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
