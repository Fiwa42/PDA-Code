public class StarsDatabase{
    public static void main (String [] args){

        //Database
        String [] starName = {"Sirius","Alpha Centauri","Rigel","Almaaz","Luhman 16"};
        String [] starId = {"TYC 5949-2777-1","TYC 9007-5849-1","TYC 5331-1752-1","TYC 2907-1275-1","WISE J1049-5319A"};
        double [] starDistance = {8.6,4.37,860,2000,6.589};
        double [] starApparentMagnitude = {-1.46,-0.27,0.13,2.92,14.94};
        String [] starType = {"Main sequence","Main sequence","Blue supergiant","Yellow supergiant","Brown dwarf"}; 



        //executing methods
        entryCount(starName);
        indexOfStarId(starId, "TYC 9007-5849-1" );
        nameAndTypeOfIndex(starName, starType,2);
        starsDistanceCheck (starDistance, 12);
        changeTypeOfStar(starType, 3, "White dwarf");
    }


    //This method returns the count of entered stars of the array
    public static int entryCount (String array []){   
        return array.length;
    }


    //If the requested Star Id is in the database, return it's index; If not, return -1
    public static int indexOfStarId (String array [],String starId) {
        for(int i=0;i<array.length;i++){
            if(array[i].equals(starId)){
                return i;
            }  
        } 
        return -1;
    }


    //Returns the Name and Type of a Star by it's Index in the form of Name(Type)
    public static String nameAndTypeOfIndex (String arrayName[],String arrayType[], int a){
        return arrayName[a] + " (" + arrayType[a] + ")" ;
    }


    public static int [] starsDistanceCheck (double [] array, double maxDistance) {
        
        //Check the length of the final array
        int length=0;
        for(int i=0;i<array.length;i++){
            if (array[i]<maxDistance){
                length++;
            }
        }
        
        //Write the array with the indices of stars with distance < maxDistance
        int [] product = new int [length];
        
        int indexCounter = 0;

        for(int i=0; i<array.length; i++){
            if (array[i]<maxDistance){
                product [indexCounter] = i;
                indexCounter++;
            }
        }

        return product;
    }

    //Changes the Type of a star by index to a new Type
    public static void changeTypeOfStar(String [] array, int index, String type){
        //If the entered String type is empty don't change it
        if(type.equals("")){
        }else{          //else change type
        array[index] = type;
        }
    }

}