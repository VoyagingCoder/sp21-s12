package deque;

import net.sf.saxon.functions.ConstantFunction;

import java.util.Iterator;

public class LinkedListDeque<T>{
    private class Tnode{
        public T item;
        public Tnode next;
        public Tnode prev;

        public Tnode(T i, Tnode n, Tnode p){
            item = i;
            next = n;
            prev = p;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Tnode sentinal;
    private int size;

    public LinkedListDeque(){
        sentinal = new Tnode(null, null, null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
        size = 0;
    }

    /** Adds x to the front of the list. */
    public void addFirst(T item){
        Tnode FirstNode = sentinal.next;
        Tnode InsertNode = new Tnode(item, FirstNode,sentinal);
        sentinal.next = InsertNode;
        FirstNode.prev = InsertNode;
        size++;
    }

    /** Adds x to the back of the list. */
    public void addLast(T item){
        Tnode LastNode = sentinal.prev;
        Tnode InsertNode = new Tnode(item, sentinal,LastNode);
        LastNode.next = InsertNode;
        sentinal.prev = InsertNode;
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Tnode iter = sentinal.next;
        while(iter != sentinal){
            System.out.print(iter.item);
            iter = iter.next;
        }
        System.out.print("\n");
    }

    public T removeFirst(){
        Tnode FirstNode = sentinal.next;
        Tnode SecondNode = sentinal.next.next;
        sentinal.next = SecondNode;
        SecondNode.prev = sentinal;

        if(!this.isEmpty()){
            size--;
        }
        return FirstNode.item;
    }

    public T removeLast(){
        Tnode SecontToLastNode = sentinal.prev.prev;
        Tnode LastNode = sentinal.prev;
        SecontToLastNode.next = sentinal;
        sentinal.prev = SecontToLastNode;

        if(!this.isEmpty()){
            size--;
        }
        return LastNode.item;
    }

    public T get(){
        return null;
    }

    public T getRecursive(int index){ return null; }

    public Iterator<T> iterator(){
        return null;
    }

    public boolean equals(Object o){
        return true;
    }
}
