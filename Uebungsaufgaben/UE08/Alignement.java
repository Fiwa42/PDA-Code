import java.util.Locale;
import java.util.Scanner;

public class Alignement{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double edgeLength;
        double radius;
        double increment;

        //Identifies whether it's Case 1 or Case 2
        int caseIdentifier=-1;

        System.out.print("Edgelength      :");
        while(true){
            edgeLength=scanner.nextDouble();
            if(edgeLength>0){
                break;
            } 

            System.out.println("Your number must be greater than zero. Enter a new one:");
        }

        System.out.print("Radius          :");
        while(true){
            radius=scanner.nextDouble();
            if(radius>0){
                break;
            }

            System.out.println("Your number must be greater than zero. Enter a new one:");
        }

        Cube cube1 = new Cube(edgeLength);
        Sphere sphere1 = new Sphere(radius);

        System.out.println("Cube volume     :"+cube1.getVolume());
        System.out.println("Sphere volume   :"+sphere1.getVolume());

        System.out.print("Increment       :");
        increment=scanner.nextDouble();
        double negIncrement= -increment;

        scanner.close();

        //Case 1: VCube>VSphere
        while (cube1.getVolume()>sphere1.getVolume()) {
            cube1.change(negIncrement);
            sphere1.change(increment);
        }
        
        //Case 2: VSphere>VCube
        while (sphere1.getVolume()>cube1.getVolume() && caseIdentifier<0) {
            sphere1.change(negIncrement);
            cube1.change(increment);
        }

        System.out.println("Cube volume     :"+cube1.getVolume());
        System.out.println("Sphere volume   :"+sphere1.getVolume());
        System.out.println("Cube surface    :"+cube1.getSurfaceArea());
        System.out.println("Sphere surface  :"+sphere1.getSurfaceArea());

    }
}