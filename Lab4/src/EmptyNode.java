/**
 * This represents an empty node in the list
 */

public class EmptyNode implements IListOfInts {

    @Override
    public IListOfInts addAtIndex(int data, int index){
        return new ElementNode(data, new EmptyNode());
    }

    @Override
    public IListOfInts addFront(int data){
        return new ElementNode(data, this);
    }

    @Override
    public IListOfInts addBack(int data){return addFront(data);}

    @Override
    public int getDataAtIndex(int index) throws IllegalArgumentException {
        throw new IllegalArgumentException("wrong index");
    }

    @Override
    public int count(){return 0;}

    @Override
    public int sum(){return 0;}

    @Override
    public String toString(){return "";}

}

