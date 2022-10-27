import java.util.Arrays;
import java.util.Scanner;

class MoveTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = formataArray(sc);
        
        moveTres(sequencia);
        sc.close();
    }

    private static void moveTres(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                int j = i;
                while(j > 0 && arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                    j--;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[i-1];
        arr[i-1] = aux;
    }

    private static int[] formataArray(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] saida = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            saida[i] =  Integer.parseInt(entrada[i]);
        }
        return saida;
    }
}
