package Model;

public class Position {
    private int positionX;
    private int positionY;
    public Position(int positionX, int positionY){
        this.positionX=positionX;
        this.positionY=positionY;
    }

    /**
     * Retourne la positionX
     * @return positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Retourne la positionY
     * @return positionY
     */
    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Pour les affichages
     * @return la positon dans un meilleur affichage
     */
    @Override
    public String toString() {
        return "(" + positionX + ", " + positionY + ")";
    }
}
