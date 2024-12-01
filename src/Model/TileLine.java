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
                break;
            case RIGHT:
                setOpenTop(true);
                setOpenRight(false);
                setOpenBottom(true);
                setOpenLeft(false);
                break;
            case BOTTOM:
                setOpenTop(false);
                setOpenRight(true);
                setOpenBottom(false);
                setOpenLeft(true);
                break;
            case LEFT:
                setOpenTop(true);
                setOpenRight(false);
                setOpenBottom(true);
                setOpenLeft(false);
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
