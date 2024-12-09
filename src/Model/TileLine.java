package Model;

public class TileLine extends Tile{
    public TileLine(boolean isMovable){
        super(isMovable,false,true,false,true);
    }

    @Override
    public TypeTile getType(){
        return TypeTile.LINE;
    }

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

    @Override
    public String affichage(){
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
