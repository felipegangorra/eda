import java.util.Scanner;

class CoutingSortPassoPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = arrayInteiros(sc);
        int k_valor = sc.nextInt();
        sc.close();
    
        int[] retorno = coutingSort(array, k_valor);
        printArray(retorno);
    }

    private static int[] coutingSort(int[] A, int k) {

        //array da auxiliar no tamanho de k (maior elemento do array padrão)
        int[] C = new int[k+1];

        //laço de frequencia
        for (int i = 0; i < A.length; i++) {
            C[A[i]] += 1;       //pegando "indice" de A e adicionando +1, respectivamente, em C.
            
            printArray(C);
        }

        //laço para cumulativa!
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];     //o valor é somado com seu anterior!
        }
        String saida = "Cumulativa do vetor de contagem - " + arrayString(C);
        System.out.println(saida);

        //array de saida contendo os elementos ordenados
        int[] B = new int[A.length];

        for (int i = A.length-1; i >= 0; i--) {
            B[C[A[i]]-1] = A[i];
            C[A[i]] -= 1;
        }

        printArray(C);
        return B;
    }

    
    private static String arrayString(int[] arr) {
        String aux = "";
        for (int i = 0; i < arr.length-1; i++) {
            aux += arr[i] + " ";
        }
        aux += arr[arr.length-1] + "";
        return aux;
    }

    private static void printArray(int[] arr) {
        System.out.println(arrayString(arr));
    }

    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];

        for (int i = 0; i < saida.length; i++) {
            saida[i] = Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}