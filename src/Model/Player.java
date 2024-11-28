package Model;

public class Player {
    private int num;
    private Position position;
    public Player(int num, Position position){
        this.num=num;
        this.position=position;

    }

    public Position getPosition() {
        return position;
    }

    /*
    public void move(int direction){
        switch (direction){
            case 0:
                position-=7;
            case 1:
                position+=1;
            case 2:
                position+=7;
            case 3:
                position-=1;
        }

    }
    */

    public String affichage(){
        return "P";
    }
}
