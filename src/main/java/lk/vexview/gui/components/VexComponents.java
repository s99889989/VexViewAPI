package lk.vexview.gui.components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class VexComponents {

    protected String type = "";

    protected int x;

    protected int y;


    public int getPosition(){
        if(x == -1 && y == -1){
            return 5;
        }
        if(x == -1){
            return 2;
        }
        if(y == -1){
            return 4;
        }
        return 1;
    }

    public int getX(){
        if(x == -1){
            return 0;
        }
        return x;
    }

    public int getY(){
        if(y == -1){
            return 0;
        }
        return y;
    }

}
