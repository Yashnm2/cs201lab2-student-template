import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;
    
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    // write your codes here
    public void swap() {
        if (size < 2) {
            return;
        }

        ArrayList<Node<E>> list = new ArrayList<>();
        TreeMap<E, Integer> map = new TreeMap<>();

        Node<E> cur = head;
        int i = 0;

        while (cur != null) {
            list.add(cur);
            map.put(cur.getElement(), i);
            cur = cur.getNext();
            i++;
        }

        while (map.size() > 1) {
            int a = map.pollFirstEntry().getValue();
            int b = map.pollLastEntry().getValue();

            Collections.swap(list, a, b);
        }

        head = list.get(0);

        for (i = 0; i < size - 1; i++) {
            list.get(i).setNext(list.get(i + 1));
        }

        tail = list.get(size - 1);
        tail.setNext(null);
    }
}
//just a line to "commit"
