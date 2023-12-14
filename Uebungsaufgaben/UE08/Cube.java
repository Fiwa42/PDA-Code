public class Cube {
    private double edgeLength;

    public Cube (double edgeLength){
        this.edgeLength=edgeLength;
    }


    public double getSurfaceArea(){
        return 6*Math.pow(edgeLength,2);
    }

    public double getVolume(){
        return Math.pow(edgeLength,3);
    }

    public void change(double increment){
        edgeLength+=increment;
    }
}
