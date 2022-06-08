public interface IListOfInts {

    /**
     * Return the list after add new data at given index
     * @param data the data to add
     * @return
     */
    IListOfInts addAtIndex(int data, int index);

    /**
     * Return the list after add new data at the front
     * @param data the data to add
     * @return
     */
    IListOfInts addFront(int data);

    /**
     * Return the list after add new data at the back
     * @param data the data to add
     * @return a list
     */
    IListOfInts addBack(int data);

    /**
     * Return the data at given index
     * @return a data
     */
    int getDataAtIndex(int index);

    /**
     * Return the number of datas in list
     * @return the size
     */
    int count();

    /**
     * Return the sum of all data in the list
     * @return the sum
     */
    int sum();

    /**
     * Create and return a string that can be used to print this list
     * @return
     */
    String toString();
}

