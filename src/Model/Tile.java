package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    private Position position;
    private boolean isOpenTop;
    private boolean isOpenRight;
    private boolean isOpenBottom;
    private boolean isOpenLeft;

    private List<TileObserver> observers = new ArrayList<>();

    Tile(boolean isOpenTop, boolean isOpenRight, boolean isOpenBottom, boolean isOpenLeft){
        this.isOpenTop=isOpenTop;
        this.isOpenRight=isOpenRight;
        this.isOpenBottom=isOpenBottom;
        this.isOpenLeft=isOpenLeft;
    }

    public abstract TypeTile getType();

    /**
     * Pour avoir la position de la tuile
     * @return
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Pour voir si la direction en haut est ouverte
     * @return true ou false
     */
    public boolean getIsOpenTop(){
        return isOpenTop;
    }

    /**
     * Pour voir si la direction à droite est ouverte
     * @return true ou false
     */
    public boolean getIsOpenRight(){
        return isOpenRight;
    }

    /**
     * Pour voir si la direction en bas est ouverte
     * @return true ou false
     */
    public boolean getIsOpenBottom(){
        return isOpenBottom;
    }

    /**
     * Pour voir si la direction à gauche est ouverte
     * @return true ou false
     */
    public boolean getIsOpenLeft(){
        return isOpenLeft;
    }

    /**
     * Pour mettre une nouvelle position à la tuile
     * @param position nouvelle position
     */
    public void setPosition(Position position){
        this.position=position;
    }

    /**
     * Pour mettre un nouveau status à la direction haute de la tuile (ouvert ou non)
     * @param isOpenTop true ou false
     */
    public void setOpenTop(boolean isOpenTop){
        this.isOpenTop=isOpenTop;
    }

    /**
     * Pour mettre un nouveau status à la direction droite de la tuile (ouvert ou non)
     * @param isOpenRight true ou false
     */
    public void setOpenRight(boolean isOpenRight){
        this.isOpenRight=isOpenRight;
    }

    /**
     * Pour mettre un nouveau status à la direction basse de la tuile (ouvert ou non)
     * @param isOpenBottom true ou false
     */
    public void setOpenBottom(boolean isOpenBottom){
        this.isOpenBottom=isOpenBottom;
    }

    /**
     * Pour mettre un nouveau status à la direction gauche de la tuile (ouvert ou non)
     * @param isOpenLeft true ou false
     */
    public void setOpenLeft(boolean isOpenLeft){
        this.isOpenLeft=isOpenLeft;
    }


    public abstract void rotate(Direction direction);

    /**
     * Ajoute un observeur à tuile
     * @param tileObserver observeur de la tuile
     */
    public void addObserver(TileObserver tileObserver){
        observers.add(tileObserver);
    }

    /**
     * Notifie quand il y'a une rotation
     * @param direction direction de la rotation
     */
    public void notifyRotate(Direction direction) {
        for (TileObserver observer : observers) {
            observer.updateRotate(direction, this);
        }
    }

    public abstract String output();
}
