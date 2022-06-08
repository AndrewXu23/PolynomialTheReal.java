import java.util.LinkedList;

/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list
 */

public class ElementNode implements IListOfInts{
    private int data;
    private IListOfInts rest;

    public ElementNode(int data, IListOfInts rest){
        this.data = data;
        this.rest = rest;
    }

    @Override
    public IListOfInts addAtIndex(int data, int index){
        if(index == 0){
            return addFront(data);
        }
        else{
            this.rest = this.rest.addAtIndex(data, index - 1);
            return this;
        }
    }

    @Override
    public IListOfInts addFront(int data){
        return new ElementNode(data, this);
    }

    @Override
    public IListOfInts addBack(int data){
        this.rest = this.rest.addBack(data);
        return this;
    }

    @Override
    public int count(){ return 1+this.rest.count();}

    @Override
    public int getDataAtIndex(int index){
        if(index == 0){
            return this.data;
        }
        else{
            return this.rest.getDataAtIndex(index - 1);
        }
    }

    @Override
    public int sum(){
        return this.data+this.rest.sum();
    }

    @Override
    public String toString(){
        String dataString = String.format("%d"+" ", this.data);
        String rest = this.rest.toString();
        if (rest.length()>0){
            return dataString + " " + rest;}
        else{
            return dataString;}
    }
}

