import java.util.Scanner;

/*---------- Pilha ----------*/
class Inverte_pilha_index {

    private int capacidade;
    private int[] pilha;
    private int topo;

    public Inverte_pilha_index(int tamanho) {
        this.capacidade = tamanho;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public void push(int n) {
        this.topo += 1;
        this.pilha[topo] = n;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        int valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        return this.pilha[topo];
    }

    /*---------- Main ----------*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacidade = sc.nextInt();

        Inverte_pilha_index pilha = new Inverte_pilha_index(capacidade);

        //adicionando elementos na pilha
        for (int i = 0; i < capacidade; i++) {
            int aux = sc.nextInt();
            pilha.push(aux);
        }

        int index = sc.nextInt();
        
        invertePilha(capacidade, pilha, index);
        System.out.println();
        printElemento(pilha);

        sc.close();
    }

    private static void invertePilha(int capacidade, Inverte_pilha_index pilha, int index) {
        System.out.println("-");

        int[] aux = new int[index + 1]; //array para guarda os removidos
        int cont = 0;       //var para verificar a parada

        //remove os elementos até bate o index e joga no aux
        while(cont <= index) {
            aux[cont] = pilha.pop();
            cont++;
        }

        //add os elementos de aux de volta na pilha (ao contrario agora)
        for (int i = 0; i < aux.length; i++) {
            pilha.push(aux[i]);
        }

    }

    //printar elementos da pilha
    public static void printElemento(Inverte_pilha_index pilha) {
        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

}
