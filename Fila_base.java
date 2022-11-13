//código base da Fila

public class Fila_base {
    
    private int[] fila;
    private int capacidade, head, tail; //cabeça e rabo da fila

    public Fila_base (int capacidade) {
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
        this.fila = new int[capacidade];
    }

    //se tá vazia
    public boolean isEmpty() {
        return (this.head == -1 && this.tail == -1);
    }

    //se tá cheia
    public boolean isFull() {
        return ((this.tail + 1) % capacidade) == this.head;     //não necessariamente a fila acaba no fim
    }

    //adicionar elemento
    public void add( int n) {
        if(isFull()) {
            throw new RuntimeException("Fila cheia!");
        }
        if(isEmpty()) {
            this.head = 0;
            this.tail = 0;
            this.fila[0] = n;
        } else {
            tail = (tail+1) % capacidade;   //pega o próximo espaço livre para add.
            this.fila[tail] = n;
        }
    }

    //remove elemento
    public int remove() {
        if(isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        
        int value = fila[head];     //retorn quem foi removido

        if(this.head == this.tail) {    //caso tenha só um elemento
            this.head = -1;
            this.head = -1;
        } else {
            this.head = ((this.head+1) % capacidade);
        }
        
        return value;
    }

    //get primeiro elemento
    public int head() {
        if(this.isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        
        return this.fila[head];
    }

    /*---------- Testes ----------*/

    public static void main(String[] args) {
        Fila_base fila = new Fila_base(10);
        assert fila.isEmpty();
        fila.add(2);
        fila.add(5);
        fila.add(7);
        assert fila.head() == 2;
        assert fila.remove() == 2;
        assert fila.head() == 5;
        fila.add(3);
        fila.add(1);
        fila.add(10);
        fila.add(9);
        fila.add(4);
        fila.add(6);
        
        assert fila.remove() == 5;
        assert fila.head() == 7;

        fila.add(2);
        assert !fila.isFull();
        
        assert fila.isFull();
    }
}
