package deque;

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

import java.util.Iterator;

public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int starter;
    private int ender;
    private int MaxArratSize;

    /** Creates an empty list. */
    public ArrayDeque() {
        MaxArratSize = 16;
        items = (T[]) new Object[MaxArratSize];
        size = 0;
    }

    /** Move the pointer back. */
    private int pointerStepBack(int pointer){
        if(pointer == 0) return MaxArratSize-1;
        else return pointer - 1;
    }

    /** Move the pointer forward. */
    private int pointerStepForward(int pointer){
        if(pointer == MaxArratSize-1) return 0;
        else return pointer + 1;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if(starter <= ender){
            System.arraycopy(items, starter, a, 0, size);
        }
        else{
            System.arraycopy(items, starter, a, 0, MaxArratSize-starter);
            System.arraycopy(items,0,a,MaxArratSize-starter,size-MaxArratSize+starter);
        }

        items = a;
        starter = 0;
        ender = size-1;
        MaxArratSize = capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    /** Inserts X into the front of the list. */
    public void addFirst(T x){
        if(isEmpty()){
            starter = 0;
            ender = 0;
        }
        else if(size+1 > MaxArratSize){
            resize(2*size);
            starter = pointerStepBack(starter);
        }
        else {
            starter = pointerStepBack(starter);
        }
        items[starter] = x;
        size = size + 1;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if(isEmpty()){
            starter = 0;
            ender = 0;
        }
        else if(size+1 > MaxArratSize){
            resize(2*size);
            ender = pointerStepForward(ender);
        }
        else {
            ender = pointerStepForward(ender);
        }
        items[ender] = x;
        size = size + 1;
    }

    public T removeFirst(){
        if(isEmpty()){
            starter = 0;
            ender = 0;
            return null;
        }

        T dropped = items[starter];
        starter = pointerStepForward(starter);
        size = size - 1;

        if(size*3 < MaxArratSize && size>=16){
            resize(size*2);
        }

        return dropped;
    }

    public T removeLast(){
        if(isEmpty()){
            starter = 0;
            ender = 0;
            return null;
        }

        T dropped = items[ender];
        ender = pointerStepBack(ender);
        size = size - 1;

        if(size*3 < MaxArratSize && size>=16){
            resize(size*2);
        }
        return dropped;
    }

    public void printDeque(){
        int pointer = starter;
        for(int i = 0; i < size; i++){
            System.out.print(items[pointer]);
            pointer = pointerStepForward(pointer);
        }
        System.out.print("\n");
    }

    public T get(int index){
        if(isEmpty()) return null;
        else return items[(starter+index)%MaxArratSize];
    }

    public Iterator<T> iterator(){
        return null;
    }

    public boolean equals(Object o){
        return true;
    }
}
