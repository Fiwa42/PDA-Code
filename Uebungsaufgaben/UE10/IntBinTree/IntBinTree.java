package IntBinTree;

import java.util.LinkedList;

public class IntBinTree {
    private IntNode root;

    //Constructors
    public IntBinTree (){

    }

    public IntBinTree(Integer content){
        this.root = new IntNode(content);
    }

    public IntBinTree(IntBinTree left, Integer content, IntBinTree right){
        root = new IntNode(content);
		if (left != null) {
			root.setLeft(left.root);
		}
		if (right != null) {
			root.setRight(right.root);
		}
    }

    private IntBinTree(IntNode root){
        this.root=root;
    }

    //methods 
    public boolean isEmpty(){
        if(root==null){
            return true;
        }
        return false;
    }

    public Integer getValue(){
        if(isEmpty()){
            return null; //error
        }
        return root.getContent();
    }

    public IntBinTree getLeft(){
        if(isEmpty()){
            return null; //error
        }
        return new IntBinTree(root.getLeft());
    }
    public void setLeft(IntBinTree tree){
        if(isEmpty()){
            return; //error
        }
        this.root.setLeft(tree.root);
    }

    public IntBinTree getRight(){
        if(isEmpty()){
            return null; //error
        }
        return new IntBinTree(root.getRight());
    }
    public void setRight(IntBinTree tree){
        if(isEmpty()){
            return;
        }
        this.root.setRight(tree.root);
    }
    


    //b)
    public Integer [] inorder(){
        Integer [] resultArray = new Integer[countNodes()];
        inorder(resultArray);
        return resultArray;
    }
    //Helper for inorder(). This just carries an array with it to store the values of the nodes
    private void inorder(Integer [] array){
        if(!isEmpty()){
            getLeft().inorder(array);

            for(int i=0;i<array.length;i++){
                if(array[i]==null){
                    array[i]=getValue();
                    break;
                }
            }
            getRight().inorder(array);
        }
    }


    //c)
    public static IntBinTree createTree(Integer [] values){
        if(values.length==0){
            return null;
        }
        //Queue
        LinkedList<IntBinTree> list = new LinkedList<IntBinTree>();
        int index=0; 

        //Enqueue root
        IntBinTree root = new IntBinTree(values[index]);
        list.add(root);
        index++;

        while (!list.isEmpty()) {
            //Add left side
            if(index<values.length){
                IntBinTree treeLeft = new IntBinTree(values[index]);
                index++;

                list.getFirst().setLeft(treeLeft); //set connection
                list.add(treeLeft); //add to queue
            }

            //Add right side
            if(index<values.length){
                IntBinTree treeRight = new IntBinTree(values[index]);
                index++;

                list.getFirst().setRight(treeRight); //set connection
                list.add(treeRight); //add to queue
            }
            list.removeFirst();
        }
        return root;
    }

    
    //d)
    public int countNodes(){
        if(!isEmpty()){
            return getLeft().countNodes()+1+getRight().countNodes();
        }
        return 0;
    }

    public int countInnerNodes(){
        //we still need to check whether we're looking on an actual node or not
        if(!isEmpty()){
            //just changed the condition of the if statement to look one step ahead
            if(!getLeft().isEmpty() || !getRight().isEmpty()){
                return getLeft().countInnerNodes()+1+getRight().countInnerNodes();
            }
        }
        return 0;
    }

    public int countLeaves(){
        if(!isEmpty()){
            //only counts leaves
            if(getLeft().isEmpty() && getRight().isEmpty()){
                return 1;
            }
            return getLeft().countLeaves()+getRight().countLeaves();
        }
        return 0;
    }

    public int getHeight(){
        if(!isEmpty()){
            //This basically looks for the longest chain of trees
            if(getLeft().getHeight()>getRight().getHeight()){
                return getLeft().getHeight()+1;
            } else if(getRight().getHeight()>getLeft().getHeight()){
                return getRight().getHeight()+1;
            }
            //if both are equally long just work with the left one
            return getLeft().getHeight()+1;
        }
        return 0;
    }

    //e)
    public boolean isFull(){
        if(!isEmpty()){
            if((getLeft().isEmpty() && getRight().isEmpty())){
                return true;
            }
            if(!getLeft().isEmpty() && !getRight().isEmpty()){
                return getLeft().isFull() && getRight().isFull();
            }
        }
        return false; //empty trees are never full
    }

    
    public boolean isComplete(){
        if(!isEmpty()){
            return isComplete(0, countNodes()); //We have to count the total amount of nodes of the root
        }
        return true; //empty trees are always complete
    }
    //Helper for isComplete()
    private boolean isComplete(int index, int nodeCount){
        if(!isEmpty()){
            //indices can't be larger or equal to nodeCount
            if(index>=nodeCount){
                return false;
            }
            //inorder traversel, since it's easy and cheap
            return getLeft().isComplete(index*2+1,nodeCount) && getRight().isComplete(index*2+2,nodeCount);
        }
        //has to return true if node is empty
        return true;
    }


    public boolean isPerfect(){
        if(!isEmpty()){
            return isPerfectLeaves(getHeight()) && isPerfectNodes();
        }
        return true; //empty trees are always perfect
    }

    //This helper looks at the leaves and compares the depths with each of them
    private boolean isPerfectLeaves(int height){
        if(!isEmpty()){
            //Condition for a leaf
            if(getLeft().isEmpty() && getRight().isEmpty()){
                //check for height; Height for all leaves should be 1 if the tree is perfect
                if(height==1){
                    return true;
                }
                return false;
            }
            //inorder traversel
            return getLeft().isPerfectLeaves(height-1) && getRight().isPerfectLeaves(height-1);
        }
        //has to return true if node is empty
        return true;
    }

    //This helper looks at the inner nodes and checks whether both children exist
    private boolean isPerfectNodes(){
        if(!isEmpty()){
            //checks whether current node is a leaf or not
            if(getLeft().isEmpty() && getRight().isEmpty()){
                return true;
            }
            //checks whether current node is an inner node with 2 children
            else if(!getLeft().isEmpty() && !getRight().isEmpty()){
                //keep going deeper
                return getLeft().isPerfectNodes() && getRight().isPerfectNodes();
            } else {
                return false;
            }
        }
        return false; //this should never be reached
    }
}