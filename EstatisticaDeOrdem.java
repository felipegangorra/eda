import java.util.Scanner;

class EstatisticaDeOrdem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = arrayInteiros(sc);
        int pivot_index = quickOrdem(sequencia, 0, sequencia.length-1);
        int ordem = estatisticaOrdem(sequencia, pivot_index);
        System.out.println(ordem);
        sc.close();
    }

    //contagem da quantidade de elementos antes do pivot
    private static int estatisticaOrdem(int[] arr, int pivot) {
        int i = 0;
        int cont = 0;
        while(arr[i] <= pivot) {
            cont++;
            i++;
        }
        return cont + 1;
    }

    //ordena e coloca o pivot no centro
    private static int quickOrdem(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;

        for (int j = left+1; j <= right; j++) {
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    //troca elementos de posição
    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    //transforma array string em int
    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];

        for (int i = 0; i < saida.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}
