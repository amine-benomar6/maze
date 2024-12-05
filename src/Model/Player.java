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

    public void move(Direction direction){
        switch (direction){
            case TOP:
                int targetXTop = position.getPositionX() - 1;
                if (targetXTop >= 0 && tilePlayer.getIsOpenTop()) { // Vérifiez les conditions initiales
                    // Simulez la nouvelle position
                    Position newPosition = new Position(targetXTop, position.getPositionY());
                    Tile targetTile = board.getTile(newPosition); // Récupérez la tuile cible

                    if (targetTile != null && targetTile.getIsOpenBottom()) { // Vérifiez la connexion de la tuile cible
                        setPosition(new Position(targetXTop, getPosition().getPositionY())); // Déplacez le joueur
                        tilePlayer = targetTile; // Mettez à jour la tuile actuelle
                    }
                }
                break;
            case RIGHT:
                int targetYRight = position.getPositionY() +1;
                if (targetYRight < 7 && tilePlayer.getIsOpenRight()) {
                    Position newPosition = new Position(position.getPositionX(), targetYRight);
                    Tile targetTile = board.getTile(newPosition);
                    if (targetTile != null && targetTile.getIsOpenLeft()) { // Vérifiez la connexion de la tuile cible
                        setPosition(new Position(getPosition().getPositionX(), targetYRight)); // Déplacez le joueur
                        tilePlayer = targetTile; // Mettez à jour la tuile actuelle
                    }
                }
                break;
            case BOTTOM:
                int targetXBottom = position.getPositionX() + 1; // Calculer la position cible en bas
                if (targetXBottom < 7 && tilePlayer.getIsOpenBottom()) { // Vérifiez les conditions initiales
                    // Simulez la nouvelle position
                    Position newPosition = new Position(targetXBottom, position.getPositionY());
                    Tile targetTile = board.getTile(newPosition); // Récupérez la tuile cible

                    if (targetTile != null && targetTile.getIsOpenTop()) { // Vérifiez la connexion de la tuile cible
                        setPosition(new Position(targetXBottom, getPosition().getPositionY()));
                        tilePlayer = targetTile; // Mettez à jour la tuile actuelle
                    }
                }
                break;
            case LEFT:
                int targetYLeft = position.getPositionY() - 1; // Calculer la position cible à gauche
                if (targetYLeft >= 0 && tilePlayer.getIsOpenLeft()) { // Vérifiez les conditions initiales
                    // Simulez la nouvelle position
                    Position newPosition = new Position(position.getPositionX(), targetYLeft);
                    Tile targetTile = board.getTile(newPosition); // Récupérez la tuile cible

                    if (targetTile != null && targetTile.getIsOpenRight()) { // Vérifiez la connexion de la tuile cible
                        setPosition(new Position(getPosition().getPositionX(), targetYLeft)); // Déplacez le joueur
                        tilePlayer = targetTile; // Mettez à jour la tuile actuelle
                    }
                }
                break;
        }

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
