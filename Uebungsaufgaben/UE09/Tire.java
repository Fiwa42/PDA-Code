package Automobile;

public class Tire {
    private int treadDepth; //In millimeters
    private boolean flat;

    public Tire(){

    }
    public Tire(int treadDepth,boolean flat){
        setTreadDepth(treadDepth);
        setFlat(flat);
    }

    //Getters & Setters
    public int getTreadDepth(){
        return treadDepth;
    }
    public void setTreadDepth(int treadDepth){
        this.treadDepth=treadDepth;
    }

    public boolean isFlat(){
        return flat;
    }
    public void setFlat(boolean flat){
        this.flat=flat;
    }

}
