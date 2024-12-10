package Model;

public class TileT extends Tile{
    public TileT(boolean isMovable){
        super(isMovable, false,true,true,true);
    }

    @Override
    public TypeTile getType(){
        return TypeTile.T;
    }

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

    @Override
    public String affichage(){
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
