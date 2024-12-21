package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Position position; //Position du joueur
    private List<PlayerObserver> observers = new ArrayList<>();
    public Player(Position position){
        this.position=position;
    }


    /**
     * Permet d'obtenir la position du joueur
     * @return
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Pour changer la position du joueur
     * @param position nouvelle position
     */
    public void setPosition(Position position) {
        this.position = position;
        notifyObserversUpdatePosition(position);
    }


    /**
     * Ajoute un observeur de joueur
     * @param observer observeur à ajouter
     */
    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifie quand le joueur change de position
     * @param newPosition
     */
    private void notifyObserversUpdatePosition(Position newPosition) {
        for (PlayerObserver observer : observers) {
            observer.updatePosition(newPosition);
        }
    }

    /**
     * Pour l'affichage sur console
     * @return l'affichage console d'un joueur
     */
    public String output(){
        return "(P)->";
    }
}
