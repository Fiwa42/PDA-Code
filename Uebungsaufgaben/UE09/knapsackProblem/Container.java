package knapsackProblem;

public class Container {
    private ContainerElement start;
    private ContainerElement end;
    private int maxWeight;
    private ContainerElement current;
    private int actualWeight = -1;

    private int counter=0;

    public Container(){

    }

    public Container(int maxWeight){
        this.maxWeight=maxWeight;
    }

    //Iterates over the Container and counts the elements
    public int size(){
        if(start==null){
            return 0;
        }

        int size=1;
        reset();

        while(current.getNext()!=null){
            size++;
            current=current.getNext();
        }
        return size;
    }

    public void reset() {
        current = start;
    }

    //Iterates over the Container and adds the weights of the elements
    public int getWeight(){
        //list is empty
        if (start==null) {
            return 0;
        }

        int totalWeight=0;
        reset();

        while(current!=null){
            totalWeight += current.getValue().getWeight();
            current=current.getNext();
        }
        return totalWeight;
    }

    public void clear(){
        start=null;
        end=null;
    }

    public boolean add(Package value){
        ContainerElement elem1 = new ContainerElement(null,value);

        //Check if the element doesn't exceed the weight limit
        if(this.getWeight() + elem1.getValue().getWeight() > maxWeight){
            System.out.println("weight limit reached. Didn't add weight: "+elem1.getValue().getWeight());
            return false;
        }

        //empty Container
        if (start==null) {
            start=elem1;
            end=elem1;
            System.out.println("weight: "+elem1.getValue().getWeight()+" added succesfully spot: 1");
            counter++;
            return true;
        }

        reset();

        while(current.getNext() != null){
            current=current.getNext();
        }

        current.setNext(elem1);
        end=elem1;
        elem1.setLast(current);
        counter++;
        System.out.println("weight: "+elem1.getValue().getWeight()+ " added succesfully spot: "+counter);
        return true;
    }


    //The values array has to be sorted from the heaviest to the lightest
    public void addOpt(Package [] values){

        //Termination conditions: maxWeight has been reached/No more packages
        if(this.getWeight()==maxWeight){
            return;
        } else if(values.length==0){
            return;
        }

        ContainerElement elem1 = new ContainerElement();
        elem1.setValue(values[0]);
    
        this.add(values[0]);

        if(this.fits(values [0])==true){
            actualWeight=actualWeight+values[0].getWeight();
        }
        System.out.println(this.getWeight());

        //Copy the array of Packages except for the Package we already added
        Package [] finalPackages = new Package[values.length-1];

        for(int i=0;i<finalPackages.length;i++){
            finalPackages[i]=values[i+1];
        }

        addOpt(finalPackages);
    }


    //removes the latest added element
    public boolean removeLast(){
        //empty container
        if(end==null){
            return false;
        }

        if(this.size()==1){
            clear();
        }

        current=end;

        System.out.println(end.getValue().getWeight()+" has been removed");
        end=current.getLast();
        end.setNext(null);

        counter--;
        return true;
    }

    //Checks if an element would fit in the container
    public boolean fits(Package value){  
        if(this.getWeight() + value.getWeight() > maxWeight){
            return false;
        }
        return true;
    }
}
