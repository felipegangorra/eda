//código base da Pilha

public class Pilha_base {
    private int[] pilha;
    private int capacidade;
    private int topo;

    //construtor
    public Pilha_base(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    //verificar se tá vazia
    public boolean isEmpty() {
        return this.topo == -1;
    }

    //verificar se tá cheia
    public boolean isFull() {
        return this.topo == (capacidade-1);
    }

    //adicionar elemento
    public void push(int n) {
        if(this.isFull()) {
            throw new RuntimeException("Pilha cheia!");
        }

        this.topo += 1;
        this.pilha[topo] = n;
    }

    //remover elemento
    public int pop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }

        int valor_topo = this.pilha[topo];  //retorna o removido
        topo -= 1;
        return valor_topo;
    }

    //get elemento do top
    public int peek() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }

        return this.pilha[topo];
    }

    //quantidade de elementos
    public int size() {
        return this.topo + 1;
    }

    /*---------- Testes ---------- */
    public static void main(String[] args) {
        Pilha_base pilha = new Pilha_base(5);
        assert pilha.isEmpty();
        assert !pilha.isFull();
        assert pilha.size() == 0;
    
        pilha.push(10);
        assert pilha.peek() == 10;
        assert pilha.size() == 1;
        assert !pilha.isEmpty();
    
        pilha.push(5);
        assert pilha.size() == 2;

        assert pilha.pop() == 5;

        pilha.push(7);
        assert pilha.peek() == 7;
        pilha.pop();

        assert !pilha.isEmpty();
    }
}
