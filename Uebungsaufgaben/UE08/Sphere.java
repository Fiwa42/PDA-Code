public class Sphere {
    private double radius;

    public Sphere(double radius){
        this.radius=radius;
    }

    public double getSurfaceArea(){
        return 4*Math.PI*Math.pow(radius,2);
    }

    public double getVolume(){
        return (4.0/3) *Math.PI*Math.pow(radius,3);
    }

    public void change(double increment){
        radius+=increment;
    }
}
