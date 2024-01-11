package Automobile;

public class Trunk {
    private int volume; //In cubic centimeters (cm³)

    public Trunk(){

    }
    public Trunk(int volume){
        setVolume(volume);
    }

    //Getters & Setters
    public void setVolume(int volume){
        this.volume=volume;
    }
    public int getVolume(){
        return volume;
    }
}
