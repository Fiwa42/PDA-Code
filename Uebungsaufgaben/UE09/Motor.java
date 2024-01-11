package Automobile;

public class Motor {
    private int displacement; //In cubic centimeters (cm³)

    public Motor(){

    }
    public Motor(int displacement){
        setDisplacement(displacement);
    }

    //Getters & Setters
    public void setDisplacement(int displacement){
        this.displacement=displacement;
    }
    public int getDisplacement(){
        return displacement;
    }
    
}
