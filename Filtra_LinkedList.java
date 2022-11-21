import java.util.Scanner;

/* ---------- MAIN ---------- */

class Filta_LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequencia = arrayInteiros(sc);
        int valor = sc.nextInt();
        
        LinkedList_Filtra lista = new LinkedList_Filtra();
        for(int e : sequencia) {
            lista.addLast(e);
        }

        removeEsperado(lista, valor);

        if(lista.isEmpty()) {
            System.out.println("vazia");
        } else {
            System.out.println(lista.toString());
        }
    
        sc.close();
    }

    //remover da lista o(s) elemento(s).
    private static void removeEsperado(LinkedList_Filtra lista, int valor) {
        while(lista.contains(valor)) {
            lista.remove(valor);
        }
    }

    //converter array para int
    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];

        for (int i = 0; i < saida.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}

/* ---------- LinkedList ---------- */

class LinkedList_Filtra {
    private Nodee head;
    private Nodee tail;
    private int size;

    public LinkedList_Filtra() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void addLast(int n) {
        Nodee newNode = new Nodee(n);

        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode; 
        }

        this.size++;
    }

    //removendo elemento desejado
    public boolean remove(int n) {
        Nodee aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if(aux.value == n) {
                if(i == 0) {removeFirst();}     //se for o primeiro
                else if(i == size - 1) {removeLast();}  //se for o ultimo
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;   //excluindo o aux
                    this.size--;
                }
                return true;
            }
            aux = aux.next;     //atualizando variavel
        }
        return false;
    }

    private int removeLast() {
        if(isEmpty()) {
            throw new RuntimeException("Lista Vazia!");
        }

        int value = this.tail.value;

        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return value;
    }

    private int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException("Lista Vazia!");
        }

        int value = this.head.value;

        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head.next.prev = null;
            this.head = this.head.next;
        }
        this.size--;
        return value;
    }

    //verifica se há o elemento na lista
    public int indexOf(int n) {
        int index = 0;
        Nodee aux = this.head;
    
        while(aux != null) {
            if(aux.value == n) {
                return index;
            }
            aux = aux.next;
            index++;
        }
        return -1;
    }

    //método pra validar se tem
    public boolean contains(int n) {
        return indexOf(n) != -1;
    }

    //tamanho da lista
    public int getSize() {
        return this.size;
    }

    //representação
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        if (size == 0) {
            sb.append("vazia");
        }
        Nodee aux = this.head;
        while (aux != null) {
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }
}

/* ---------- NODE ---------- */

class Nodee {
    int value;
    Nodee next;
    Nodee prev;

    public Nodee(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}