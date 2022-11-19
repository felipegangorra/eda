import java.util.NoSuchElementException;

import util.Aluno;

public class LinkedList_base {

    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList_base() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }
    
    //
    public void addFirst(Aluno aluno) {
        Node newNode = new Node(aluno);
        
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;   //add novo antes do primeiro
            this.head.prev = newNode;   //ligando antes do primeiro com o novo
            this.head = newNode;        //primeiro passa a ser o novo
        }
        
        size += 1;
    }
    
    public void addLast(Aluno aluno) {
        Node newNode = new Node(aluno);
        
        if(isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            this.tail.next = newNode;   //add novo no fim
            newNode.prev = tail;        //ligando o tail com novo
            this.tail = newNode;        //tail passa a ser novo
        }
        this.size += 1;
    }
    
    public Aluno getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.head.aluno;
    }
    
    public Aluno getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.tail.aluno;
    }
    
    
    public Aluno removeFirst() {
        
        if (isEmpty()) return null;
        
        Aluno aluno = this.head.aluno;
        
        if (this.head.next == null) {   //se for só um elemento
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next; //head passa a ser o proximo
            this.head.prev = null;      //null pra antes do head
        }
        
        size -= 1;
        return aluno;
    }
    
    public Aluno removeLast() {
        
        if (isEmpty()) return null;
        
        Aluno aluno = this.tail.aluno;
        
        if (this.head.next == null) {   //se for só um elemento
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;     //tail igual seu anterior
            this.tail.next = null;          //null pra proximo do tail
        }              
        
        size -= 1;
        return aluno;
    }
    
    
    public void addR(int index, Aluno aluno) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0)
            this.addFirst(aluno);
        else if (index == size - 1)
            this.addLast(aluno);
        else
            addR(this.head, index, aluno, 0);
    }
    
    private void addR(Node node, int index, Aluno aluno, int i) {
            // hora de adicionar.
            if (i == (index - 1)) {
                Node newNode = new Node(aluno);
                newNode.next = node.next;
                node.next = newNode;
                newNode.next.prev = newNode;
                newNode.prev = node;
                this.size += 1;
            } else {
                addR(node.next, index, aluno, i+1);
            }
    }

    public void add(int index, Aluno aluno) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        Node newNode = new Node(aluno);
        
        if (index == 0) {
            this.addFirst(aluno);
        
        } else if (index == size - 1) {
            this.addLast(aluno);
        
        } else {
            Node aux = this.head;
            
            for (int i = 0; i < index - 1; i++)
                aux = aux.next;
            
            newNode.next = aux.next;
            aux.next = newNode;
            
            size += 1;
        }
            
    }
    
    public Aluno get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        Node aux = this.head;
        
        for (int i = 0; i < index; i++)
            aux = aux.next;
        
        return aux.aluno;
    }
    
    public int indexOf(Aluno aluno) {
        Node aux = this.head;
        int index = 0;
        while (aux != null) { 
            if(aux.aluno.equals(aluno))
                return index;
            aux = aux.next;
            index += 1;
        }
        
        return -1;
    }
    
    public Aluno remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        
        Node aux = this.head;
        for (int i = 0; i < index; i++)
            aux = aux.next;
        
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        size -= 1;
        return aux.aluno;
    }
    
    public boolean remove(Aluno aluno) {
        
        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux.aluno.equals(aluno)) {
                if (i == 0) removeFirst();
                else if (i == size - 1) removeLast();
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size -= 1;
                }
                
                return true;
            }
            aux = aux.next;
        }
        
        return false;
    }
    
    public String toString() {
        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.aluno.getNome() + " ";
            aux = aux.next;
        }
        return out;
            
    }
    
    public boolean contains(Aluno aluno) {
        return indexOf(aluno) != -1;
    }
    
    public int size() {
        return this.size;
    }

}

class Node {
    
    Aluno aluno;
    Node next;
    Node prev;
    
    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.prev = null;
        this.next = null;
    }

}