package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Position position; //Position du joueur
    private Board board;
    private Tile tilePlayer;
    private List<PlayerObserver> observers = new ArrayList<>();
    public Player(Position position, Board board){
        this.position=position;
        this.board=board;
    }


    public void setTilePlayer(Tile tilePlayer) {
        this.tilePlayer = tilePlayer;
    }

    public Tile getTilePlayer() {
        return tilePlayer;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        notifyObserversUpdatePosition(position);
    }


    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }

    private void notifyObserversUpdatePosition(Position newPosition) {
        for (PlayerObserver observer : observers) {
            observer.updatePosition(newPosition);
        }
    }

    public String affichage(){
        return "(P)->";
    }
}
