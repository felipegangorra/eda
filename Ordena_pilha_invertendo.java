
//INCOMPLETO!!!

import java.util.Scanner;

/*---------- Pilha ----------*/
class Ordena_pilha_invertendo {

    private int capacidade;
    private int[] pilha;
    private int topo;

    public Ordena_pilha_invertendo(int tamanho) {
        this.capacidade = tamanho;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade-1);
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

        Ordena_pilha_invertendo pilha = new Ordena_pilha_invertendo(capacidade);

        //adicionando elementos na pilha
        for (int i = 0; i < capacidade; i++) {
            int aux = sc.nextInt();
            pilha.push(aux);
        }
        
        Ordena_pilha_invertendo pilhaSaida = OrdenaPilha(pilha, capacidade);

        printElemento(pilhaSaida);

        sc.close();
    }

    
    //
    private static Ordena_pilha_invertendo OrdenaPilha(Ordena_pilha_invertendo pilha, int capacidade) {
        Ordena_pilha_invertendo novaPilha = new Ordena_pilha_invertendo(capacidade);

        while(!(novaPilha.isFull())) {
            int maior = getMaior(pilha, capacidade);
            novaPilha.push(maior);
        }

        return novaPilha;
        
    }

    //pega o maior e retira da pilha
    public static int getMaior(Ordena_pilha_invertendo pilha, int capacidade) {
        int[] aux = new int[capacidade];

        int maior = pilha.peek();
        int cont = 0;
        while(!(pilha.isEmpty())) {
            aux[cont] = pilha.pop();

            if(aux[cont] >= maior) {
                maior = aux[cont];
            }
            
            cont++;
        }

        //adicionando de volta na pilha
        for (int j = aux.length-1; j >= 0; j--) {
            if(aux[j] < maior) {
                pilha.push(aux[j]);
            }
            if(aux[j] == maior) {
                pilha.push(-1000);
            }
        }

        return maior;
    }

    //printar elementos da pilha
    public static void printElemento(Ordena_pilha_invertendo pilha) {

        System.out.println("-");

        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

}
