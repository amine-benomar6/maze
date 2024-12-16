package Model;

public class Objective {
    private String nameObjective;
    private Position positionObjective;
    public Objective(String nameObjective){
        this.nameObjective=nameObjective;
    }

    public Position getPositionObjective() {
        return positionObjective;
    }

    public void setPositionObjective(Position positionObjective){
        this.positionObjective=positionObjective;
    }

    public String getNameObjective(){
        return nameObjective;
    }

    public String affichage(){
        return "{"+ nameObjective +"}->";
    }
}
