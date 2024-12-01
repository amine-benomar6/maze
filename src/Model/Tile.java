package Model;

public abstract class Tile {
    private Position position;
    private boolean isMovable;
    private boolean isOpenTop;
    private boolean isOpenRight;
    private boolean isOpenBottom;
    private boolean isOpenLeft;

    Tile(boolean isMovable, boolean isOpenTop, boolean isOpenRight, boolean isOpenBottom, boolean isOpenLeft){
        this.isMovable=isMovable;
        this.isOpenTop=isOpenTop;
        this.isOpenRight=isOpenRight;
        this.isOpenBottom=isOpenBottom;
        this.isOpenLeft=isOpenLeft;
    }
    public abstract TypeTile getType();

    public Position getPosition() {
        return position;
    }

    public boolean getIsOpenTop(){
        return isOpenTop;
    }
    public boolean getIsOpenRight(){
        return isOpenRight;
    }
    public boolean getIsOpenBottom(){
        return isOpenBottom;
    }
    public boolean getIsOpenLeft(){
        return isOpenLeft;
    }

    public void setPosition(Position position){
        this.position=position;
    }
    public void setOpenTop(boolean isOpenTop){
        this.isOpenTop=isOpenTop;
    }
    public void setOpenRight(boolean isOpenRight){
        this.isOpenRight=isOpenRight;
    }
    public void setOpenBottom(boolean isOpenBottom){
        this.isOpenBottom=isOpenBottom;
    }
    public void setOpenLeft(boolean isOpenLeft){
        this.isOpenLeft=isOpenLeft;
    }

    public abstract void rotate(Direction direction);

    public abstract String affichage();
}
