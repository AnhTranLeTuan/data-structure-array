
/* Using generic to limit types provided for the type parameter (only the Student class and its subclasses
 are eligible) */
public class Array<E extends Student>{

    private E[] collection;
    private int arraySize;
    // The variable for keeping track the number of items in the array
    private int counter = 0;

    public Array(){
        collection = (E[]) new Student[1];
        arraySize = 1;
}

    public Array(int arraySize){
        collection = (E[]) new Student[arraySize];
        this.arraySize = arraySize;
    }

    public void add(E item){
        // Checking the eligibility of the argument
        if(item == null)
            throw new IllegalArgumentException();

        // Check if the array is full
        // If it is full, add current items into the new array with double size
        if (counter == arraySize)
            doubleArraySize();

        //Add the argument into the array, and increase the counter
        collection[counter++] = item;
    }

    public boolean containsAny(){
        return counter > 0;
    }

    public E contains(int index){
        // Using private methods for checking the eligibility of the argument
        if (isIndexEligible(index))
            return collection[index];

        throw new IllegalArgumentException();
    }

    public void insert(E item, int index) {
        // Using private methods for checking the eligibility of the two arguments
        if (item == null || !isIndexEligible(index))
            throw new IllegalArgumentException();

        // Check if the array is full
        // If it is full, add current items into the new array with double size
        if (counter == arraySize)
            doubleArraySize();

        // Move items up to 1 positions for getting the space for inserting
        for(int i = counter - 1; i >= index; i--)
            collection[i + 1] = collection[i];

        collection[index] = item;
    }

    public void removeAt(int index){
        if (!isIndexEligible(index))
            throw new IllegalArgumentException();
        // Move items down to 1 positions to fill the removed item's place
        for(int i = index; i < counter - 1; i++)
            collection[i] = collection[i + 1];

        // Decrease the counter by 1 to reflex the current number of items
        counter--;
    }

    public void removeAll(){
        if (!containsAny())
            return;

        collection = (E[]) new Student[10];
        arraySize = 10;
    }

    public int indexOf(E item) {
        if (item == null)
            return -1;

        // Compare the argument to items in the array
        // Return the index of the first occurrence
        for (int i = 0; i < counter; i++)
            if (collection[i].compareTo(item) > 0)
                return i;

        return -1;
    }
    public void print(){
        for (Student student: collection)
            System.out.println(student);
    }

    private void doubleArraySize(){
        arraySize = arraySize * 2;
        E[] tempArray = (E[]) new Student[arraySize];

        for (int i = 0; i < collection.length; i++)
            tempArray[i] = collection[i];

        collection = tempArray;
    }

    private boolean isIndexEligible(int index){
        if (index >= 0 && index < counter)
            return true;

        return false;
    }

}
