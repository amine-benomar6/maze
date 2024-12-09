package Model;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Tile extraTile;
    public Game(Board board, List<Player> players, Tile extraTile){
        this.board=board;
        this.players=players;
        this.extraTile=extraTile;
    }

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

    public Tile getExtraTile() {
        return extraTile;
    }

    public boolean playerOnRow(int index, Player player){
        for(int i=0; i<7; i++){
            Position newPosition = new Position(index, i);
            if(player.getTilePlayer()== board.getTile(newPosition)){
                return true;
            }
        }
        return false;
    }

    /**
     * Pousser une ligne du plateau
     *
     * @param row ligne à pousser
     * @param direction direction dans laquelle pousser la ligne
     */
    public void pushRow(int row, Direction direction){
        Tile tempExtraTile=extraTile;
        if(direction==Direction.LEFT){
            extraTile= board.getTile(new Position(row,6));
            board.pushRowLeft(row);
            board.setTileAt(tempExtraTile, new Position(row,0));
        } else if (direction==Direction.RIGHT) {
            extraTile= board.getTile(new Position(row,0));
            board.pushRowRight(row);
            board.setTileAt(tempExtraTile, new Position(row,6));
        }
        else{
            throw new IllegalArgumentException("Direction invalide. Utilisez RIGHT ou LEFT.");
        }

    }

    public void pushColumn(int column, Direction direction){
        Tile tempExtraTile=extraTile;
        if(direction==Direction.TOP) {
            extraTile = board.getTile(new Position(6, column));
            board.pushColumnTop(column);
            board.setTileAt(tempExtraTile, new Position(0, column));
        }
        else if(direction==Direction.BOTTOM){
            extraTile = board.getTile(new Position(0, column));
            board.pushColumnBottom(column);
            board.setTileAt(tempExtraTile, new Position(6, column));
        }
        else{
            throw new IllegalArgumentException("Direction invalide. Utilisez TOP ou BOTTOM.");
        }
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Board getBoard(){
        return board;
    }

}
