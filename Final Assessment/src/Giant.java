import java.awt.Color;

public class Giant extends Critter {

    private int counter;

    public Giant(){
        counter =1;
    }

    public Color getColor(){
        return Color.GRAY;
    }

    /*"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves,
    then "fum" for 6 moves, then repeat.*/
    public String toString(){
        if(counter > 24){
            counter = 1;
        }
        if(counter <= 6){
            return "fee";
        }
        else if(counter <= 12){
            return "fie";
        }
        else if(counter <= 18){
            return "foe";
        }
        return "fum";
    }
    /*	always infect if an enemy is in front, otherwise hop if possible,
    otherwise turn right.*/
    public Action getMove(CritterInfo info){

        counter++;
        if (info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        }
        else{
            return Action.RIGHT;
        }
    }
}