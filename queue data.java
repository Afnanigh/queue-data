
package dataproject;

public class LLQueue<E> {

    static class Node<E> {

        private E element; 
        private Node<E> next; 

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    protected Node<E> front;
    protected Node<E> rear;
    protected long size;

    public LLQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { 
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void Enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest; 
        } else {
            rear.setNext(newest); 
        }
        rear = newest;  
        size++;
    }

    public E Dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; 
        }
        return answer;
    }

    public void display() {

        long Size = size;
        System.out.print("Front ");
        for (int i = 0; i < Size; i++) {
            E ele = Dequeue();
            System.out.print(ele + " \t");
            Enqueue(ele);
        }
        System.out.println("End");
    }
    
  
    public void sortArrayAscending() {
        int number = (int) size;
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Integer) Dequeue();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            Integer ele = array[i];
            Enqueue((E) ele);
        }
    }


    public void sortArrayDescending() {
        int number = (int) size;
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Integer) Dequeue();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            Integer ele = array[i];
            Enqueue((E) ele);
        }
    }

}