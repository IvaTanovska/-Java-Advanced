package SmartArray;

import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.data = new int[INITIAL_CAPACITY];
    }

    //Adds the given element to the end of the list
    public void add(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.data[size] = element;
        size++;
    }

    //this method will be used to increase the internal collection's length twice
    private void resize() {
        this.capacity *= 2;
        int[] copyArray = new int[this.capacity];
        for (int i = 0; i < this.data.length; i++) {
            copyArray[i] = this.data[i];
        }
        this.data = copyArray;
    }

//Returns the element at the specified position in this list

    public int get(int index) {
        check(index);
        return this.data[index];
    }


    //int remove(int index) - Removes the element at the given index

    public int remove(int index) {
        check(index);
        int element = this.data[index];
        this.data[index] = 0;

        shiftLeft(index);
        this.size--;

        if (this.size <= this.capacity/4) {
            shrink();
        }

        return element;
    }

    private void shiftLeft(int index) {

        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = 0;

    }


    private void check(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArithmeticException(String.format("Index %d out of bounds for length %d", index, this.size));
        }


    }

    //this method will help us to decrease the internal collection's length twice
    private void shrink() {
        this.capacity /= 2;
        int[] copyArray = new int[this.capacity];
        for (int i = 0; i < this.data.length; i++) {
            copyArray[i] = this.data[i];
        }
        this.data = copyArray;


    }

    //Checks if the list contains the given element returns (True or False)
    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

  //Adds element at the specific index, the element at this index gets shifted to the right alongside any following elements, increasing the size
  public void add(int index, int element){
        check(index);

        if (index== this.size-1){
            add(this.data[this.size-1]);
            this.data[size-2]=element;
        }else {
            if (this.size == this.capacity) {
                resize();
            }
            shiftRight(index);
            this.size++;
            this.data[index]=element;}


  }
// this method we will use when we inset an element at a specific index
    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            this.data[i]=this.data[i-1];

        }
    }

    public void forEach (Consumer<Integer> consumer){
        for (int i = 0; i <this.size ; i++) {
            consumer.accept(this.data[i]);

        }

    }

}

// Goes through each one of the elements in the list




