package Model;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private Tile extraTile;

    private List<Objective> objectives;
    public Game(Board board, List<Player> players, Tile extraTile){
        this.board=board;
        this.players=players;
        currentPlayer=players.get(0);
        this.extraTile=extraTile;
        this.objectives=new ArrayList<>();
    }

    /**
     * Change le joueur actuel (currentPlayer)
     */
    public void switchCurrentPlayer(){
        int currentIndex = players.indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        currentPlayer = players.get(nextIndex);
    }

    /**
     * Obtenir le joueur actuel
     * @return le joueur actuel
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Bouge le joueur en parametre dans une direction
     * @param player joueur à bouger
     * @param direction direction dans laquelle il va bouger
     */
    public void movePlayer(Player player, Direction direction){
        Position positionPlayer=player.getPosition();

        Tile currentTilePlayer;
        Tile targetTilePlayer;
        currentTilePlayer= board.getTile(positionPlayer);

        switch (direction){
            case TOP:
                if (positionPlayer.getPositionX()-1 >= 0 && currentTilePlayer.getIsOpenTop()) {
                    Position newPosition = new Position(positionPlayer.getPositionX()-1, positionPlayer.getPositionY());
                    targetTilePlayer= board.getTile(newPosition);
                    if(targetTilePlayer!=null && targetTilePlayer.getIsOpenBottom())
                    {
                        player.setPosition(targetTilePlayer.getPosition());
                    }
                }
                break;
            case RIGHT:
                if (positionPlayer.getPositionY()+1 < 7 && currentTilePlayer.getIsOpenRight()) {
                    Position newPosition = new Position(positionPlayer.getPositionX(), positionPlayer.getPositionY()+1);
                    targetTilePlayer= board.getTile(newPosition);
                    if(targetTilePlayer!=null && targetTilePlayer.getIsOpenLeft())
                    {
                        player.setPosition(targetTilePlayer.getPosition());
                    }
                }
                break;
            case BOTTOM:
                if (positionPlayer.getPositionX()+1 < 7 && currentTilePlayer.getIsOpenBottom()) {
                    Position newPosition = new Position(positionPlayer.getPositionX()+1, positionPlayer.getPositionY());
                    targetTilePlayer= board.getTile(newPosition);
                    if(targetTilePlayer!=null && targetTilePlayer.getIsOpenTop())
                    {
                        player.setPosition(targetTilePlayer.getPosition());
                    }
                }
                break;
            case LEFT:
                if (positionPlayer.getPositionY()-1 >= 0 && currentTilePlayer.getIsOpenLeft()) {
                    Position newPosition = new Position(positionPlayer.getPositionX(), positionPlayer.getPositionY()-1);
                    targetTilePlayer= board.getTile(newPosition);
                    if(targetTilePlayer!=null && targetTilePlayer.getIsOpenRight())
                    {
                        player.setPosition(targetTilePlayer.getPosition());
                    }
                }
                break;

        }
    }

    /**
     * Initialisation des objectifs (pas super developpé)
     */
    public void initObjectives(){
        for(int i=0; i<24; i++){
            Objective obj=new Objective("obj"+i);
            objectives.add(obj);
        }

        Collections.shuffle(objectives);

        Random rand = new Random();
        for (Objective obj : objectives)
        {
            int line = rand.nextInt(7);
            int column = rand.nextInt(7);
            Position posObj=new Position(line,column);
            obj.setPositionObjective(posObj);
        }
    }

    /**
     * Fonction qui aurait du servir pour distribuer les objectifs
     * @return
     */
    /*
    public void dealObjectivesToPlayer(){
        for (Player p:players)
        {
            for(int i=0; i<6; i++){
                p.pushObjectivePlayer(objectives.get(0));
            }
        }
    }
*/

    /**
     * Retourne les objectifs
     * @return tout les objectifs
     */
    public List<Objective> getObjectives(){
        return objectives;
    }

    /**
     * Retourne l'ectra tuile
     * @return extra tuile
     */
    public Tile getExtraTile() {
        return extraTile;
    }

    /**
     * Retourne tout les joueurs sur une ligne donné
     * @param index index de la ligne souhaité
     * @return les joueurs sur la ligne
     */
    public List<Player> getPlayersOnRow(int index){
        if (index<0 || index>6) {
            throw new IllegalArgumentException("Index de la ligne invalide. Sélectionnez un index entre 0 et 6 inclus.");
        }
        System.out.println("Appel de playersOnRow pour la ligne " + index);
        List<Player> playersOnRow= new ArrayList<>();
        for(int i=0; i<7; i++){
            Position newPosition = new Position(index, i);

            for (Player p:players) {
                if(p.getPosition().getPositionX()==newPosition.getPositionX() &&
                        p.getPosition().getPositionY() == newPosition.getPositionY()){
                    System.out.println("Joueur trouvé à la position :" + newPosition);
                    playersOnRow.add(p);
                }
            }

        }
        return playersOnRow;
    }

    /**
     * Retourne tout les joueurs sur une colonne donné
     * @param index index de la colonne souhaité
     * @return les joueurs sur la colonne
     */
    public List<Player> getPlayersOnColumn(int index) {
        if (index<0 || index>6) {
            throw new IllegalArgumentException("Index de la colonne invalide. Sélectionnez un index entre 0 et 6 inclus.");
        }
        System.out.println("Appel de playersOnColumn pour la ligne " + index);
        List<Player> playersOnColumn = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Position newPosition = new Position(i, index);

            for (Player p : players) {
                if (p.getPosition().getPositionX() == newPosition.getPositionX() &&
                        p.getPosition().getPositionY() == newPosition.getPositionY()) {
                    System.out.println("Joueur trouvé à la position :" + newPosition);
                    playersOnColumn.add(p);
                }
            }

        }
        return playersOnColumn;
    }

    /**
     * Pousser une ligne du plateau
     *
     * @param row ligne à pousser
     * @param direction direction dans laquelle pousser la ligne
     */
    public void pushRow(int row, Direction direction)
    {
        Tile tempExtraTile = extraTile;
        if(direction == Direction.LEFT)
        {
            extraTile = board.getTile(new Position(row,6));
            board.pushRowLeft(row);
            board.setTileAt(tempExtraTile, new Position(row,0));
            List<Player> playersRow=getPlayersOnRow(row);
            if(playersRow!=null){
                for (Player p:playersRow)
                {

                    if (p.getPosition().getPositionY() == 6) {
                        p.setPosition(new Position(row, 0));
                    } else {
                        p.setPosition(new Position(row, p.getPosition().getPositionY() + 1));
                    }
                }
            }
        }
        else if (direction == Direction.RIGHT)
        {
            extraTile= board.getTile(new Position(row,0));
            board.pushRowRight(row);
            board.setTileAt(tempExtraTile, new Position(row,6));
            List<Player> playersRow=getPlayersOnRow(row);
            if(playersRow!=null){
                for (Player p:playersRow)
                {
                    if (p.getPosition().getPositionY() == 0) {
                        p.setPosition(new Position(row, 6));
                    } else {
                        p.setPosition(new Position(row, p.getPosition().getPositionY() - 1));
                    }
                }
            }
        }
        else if (direction!=Direction.RIGHT || direction!=Direction.LEFT) {
            throw new IllegalArgumentException("Direction invalide. Utilisez LEFT ou RIGHT.");
        }
        else if (row<0 || row>6) {
            throw new IllegalArgumentException("Index de la ligne invalide. Sélectionnez un index entre 0 et 6 inclus.");
        }
    }

    /**
     * Pousser une colonne du plateau
     *
     * @param column colonne à pousser
     * @param direction direction dans laquelle pousser la colonne
     */
    public void pushColumn(int column, Direction direction){
        Tile tempExtraTile=extraTile;
        if(direction==Direction.TOP) {
            extraTile = board.getTile(new Position(6, column));
            board.pushColumnTop(column);
            board.setTileAt(tempExtraTile, new Position(0, column));
            List<Player> playersColumn=getPlayersOnColumn(column);
            if(playersColumn!=null){
                for (Player p:playersColumn)
                {
                    if (p.getPosition().getPositionX() == 6) {
                        p.setPosition(new Position(0, column));
                    } else {
                        p.setPosition(new Position(p.getPosition().getPositionX() + 1, column));
                    }
                }
            }
        }
        else if(direction==Direction.BOTTOM){
            extraTile = board.getTile(new Position(0, column));
            board.pushColumnBottom(column);
            board.setTileAt(tempExtraTile, new Position(6, column));
            List<Player> playersColumn=getPlayersOnColumn(column);
            if(playersColumn!=null){
                for (Player p:playersColumn)
                {
                    if (p.getPosition().getPositionX() == 0) {
                        p.setPosition(new Position(6, column));
                    } else {
                        p.setPosition(new Position(p.getPosition().getPositionX() - 1, column));
                    }
                }
            }
        } else if (direction!=Direction.TOP || direction!=Direction.BOTTOM) {
            throw new IllegalArgumentException("Direction invalide. Utilisez TOP ou BOTTOM.");
        }
        else if (column<0 || column>6) {
            throw new IllegalArgumentException("Index de la colonne invalide. Sélectionnez un index entre 0 et 6 inclus.");
        }

    }

    public List<Player> getPlayers(){
        return players;
    }

    public Board getBoard(){
        return board;
    }

}
