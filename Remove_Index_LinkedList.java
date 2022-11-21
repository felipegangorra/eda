import java.util.Scanner;

/* ---------- MAIN ---------- */

class Remove_Index_LinkedList {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int[] sequencia = arrayInteiros(sc);
        int index = sc.nextInt();

        LinkedList_remove lista = new LinkedList_remove();

        for(int e : sequencia) {
            lista.addLast(e);
        }

        lista.remove(index);

        if(lista.isEmpty()) {
            System.out.println("vazia");
        } else {
            System.out.println(lista.toString());
        }

        sc.close();
    }

    //transforma em inteiros
    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];

        for (int i = 0; i < saida.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}

/* ---------- CLASSE DO LINKEDLIST ---------- */

class LinkedList_remove {

    private No head;
    private No tail;
    private int size;

    public LinkedList_remove() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    //adicionando em ultimo
    public void addLast(int value) {
        No newNode = new No(value);

        if(isEmpty()) {     //se for o primeiro
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode; 
        }

        this.size++;
    }

    public int remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {return removeFirst();}  //se for o primeiro
        if(index == size - 1) {return removeLast();}    //se for o segundo

        No aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        this.size--;
        return aux.value;
    }

    //remove primeiro elemento
    public int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        int value = this.head.value;    //será removido //inicio

        if(this.head.next == null) {    //só um elemento
            this.head = null;
            this.tail = null;
        } else {
            this.head.next.prev = null;
            this.head = this.head.next;
        }

        this.size--;
        return value;
    }

    //remove ultimo elemento
    public int removeLast() {
        if(isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        int value = this.tail.value;    //fim

        if(this.head.next == null) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size--;
        return value;
    }

    //representação
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        if (size == 0) {
            sb.append("vazia");
        }
        No aux = this.head;
        while (aux != null) {
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }
    
    
}

/* ---------- CLASSE DO NODE ---------- */

class No {
    int value;
    No next;
    No prev;

    public No(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
