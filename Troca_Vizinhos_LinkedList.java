import java.util.Scanner;

/* ---------- MAIN ---------- */

class Troca_Vizinhos_LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = arrayInteiros(sc);
        int index = sc.nextInt();

        LinkedList_Troca lista = new LinkedList_Troca();
        for(int e : sequencia) {
            lista.addLast(e);
        }

        lista.trocaNos(lista, index);
        System.out.println(lista.toString());

        sc.close();
    }

    //converte array em inteiro
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

class LinkedList_Troca {
    private Nod head;
    private Nod tail;
    private int size;

    public LinkedList_Troca() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void trocaNos(LinkedList_Troca lista, int index) {
        Nod aux = this.head;
        for (int i = 0; i < index; i++) {   //pega o valor do index
            aux = aux.next;
        }

        //guardando valor de antes e depois
        Nod auxPrev = aux.prev; //1
        Nod auxNext = aux.next; //3

        aux.next = aux.next.next; // 13 -> 4
        //4 -> 13
        if(auxNext.next == null) {
            this.tail = aux;
        } else {
            auxNext.next.prev = aux; 
        }


        aux.prev = auxNext; //3 <- 13
        auxNext.next = aux; //13 -> 3

        auxNext.prev = auxPrev; //1 <- 3
        //1 -> 3
        if(auxPrev == null) {
            this.head = auxNext;
        } else {
            auxPrev.next = auxNext;
        }

    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void addLast(int n) {

        Nod newNode = new Nod(n);   //criando no

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

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        if(size == 0){
            sb.append("vazia");
        }

        Nod aux = this.head;
        while(aux != null) {
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }

}

/* ---------- NODE ---------- */

class Nod {
    int value;
    Nod next;
    Nod prev;

    public Nod(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
