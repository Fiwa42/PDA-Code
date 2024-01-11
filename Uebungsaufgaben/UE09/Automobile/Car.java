package Automobile;

public class Car {
    private int numberOfSeats;
    private int numberOfDoors;
    private int maxVelocity=150;  //in kph
    private Tire [] tires = new Tire[4];

    public Car(){

    }

    public Car(int numberOfSeats,int numberOfDoors, int maxVelocity){
        setNumberOfDoors(numberOfDoors);
        setNumberOfSeats(numberOfSeats);
        this.maxVelocity=maxVelocity; //Overwrite the maximum Velocity once

        //Create tires
        for(int i=0;i<tires.length;i++){
            tires[i]=new Tire(26,false);
        }

        Motor motor = new Motor(2000);
        Trunk trunk = new Trunk(400000);
    }

    //Getters & Setters
    public void setNumberOfSeats(int numberOfSeats){
        this.numberOfSeats=numberOfSeats;
    }
    public int getNumberOfSeats(){
        return numberOfSeats;
    }

    public void setNumberOfDoors(int numberOfDoors){
        this.numberOfDoors=numberOfDoors;
    }
    public int getNumberOfDoors(){
        return numberOfDoors;
    }

    public int getMaxVelocity(){
        return maxVelocity;
    }

    public boolean isFasterThan(Car other){
        if(this.getMaxVelocity()>other.getMaxVelocity()){
            return true;
        }
        return false;
    }

    public boolean changeTire(int index){
        tires[index]=null;
        tires[index]=new Tire(27,false);
        return true;
    }

}
