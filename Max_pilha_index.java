import java.util.Scanner;

/*---------- Pilha ----------*/
class Max_pilha_index {

    private int capacidade;
    private int[] pilha;
    private int topo;

    public Max_pilha_index(int tamanho) {
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

        int[] elementos = arrayInteiros(sc);
        int capacidade = tamanho(elementos);
        Inverte_pilha_index pilha = new Inverte_pilha_index(capacidade);

        //adicionando elementos na pilha
        for (int i = 0; i < capacidade; i++) {
            int aux = elementos[i];
            pilha.push(aux);
        }

        int index = sc.nextInt();
        
        int max = maiorElemento(pilha, index);
        System.out.println(max);

        sc.close();
    }

    private static int maiorElemento(Inverte_pilha_index pilha, int index) {
        int[] aux = new int[index+1];

        //separando elementos até o index
        int cont = 0;
        while(cont <= index) {
            aux[cont] = pilha.pop();
            cont++;
        }

        //pegando maior elemento
        int maior = aux[0];
        for (int i = 0; i < aux.length; i++) {
            if(aux[i] > maior) {
                maior = aux[i];
            }
        }

        //adicionando de volta na pilha
        for (int j = aux.length-1; j >= 0; j--) {
            pilha.push(aux[j]);
        }

        return maior;

    }

    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];

        for (int i = 0; i < saida.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }

    public static int tamanho(int[] array) {
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            cont++;   
        }
        return cont;
    }

}
