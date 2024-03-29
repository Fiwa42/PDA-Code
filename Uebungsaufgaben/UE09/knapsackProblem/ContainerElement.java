package knapsackProblem;

public class ContainerElement{
    private ContainerElement next;
    private ContainerElement last;
    private Package value;

    public ContainerElement(){
        
    }

    public ContainerElement(ContainerElement next, Package value){
        this.next=next;
        this.value=value;
    }



    public ContainerElement getNext(){
        return next;
    }
    public void setNext(ContainerElement next){
        this.next=next;
    }

    public ContainerElement getLast(){
        return last;
    }
    public void setLast(ContainerElement last){
        this.last=last;
    }

    public Package getValue(){
        return value;
    }
    public void setValue(Package value){
        this.value=value;
    }
}