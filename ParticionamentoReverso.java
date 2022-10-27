import java.util.Arrays;
import java.util.Scanner;

class ParticionamentoReverso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = arrayInteiros(sc);

        quickSort(sequencia, sequencia.length-1, 0);
        System.out.println(Arrays.toString(sequencia));
        sc.close();
    }

    private static void quickSort(int[] array, int left, int right) {
        partition(array, left, right);
    }

    private static void partition(int[] array, int left, int right) {
        int pivotIndex = array[left];
        int i = left;
        boolean troca =  false;

        for (int j = left-1; j >= right; j--) {
            if(array[j] >= pivotIndex) {
                i--;
                swap(array, j, i);
                troca = true;
            }

            //para printar
            if(troca == true) { System.out.println(Arrays.toString(array)); }
            troca = false;

        }
        swap(array, left, i);
        System.out.println(Arrays.toString(array));
    }

    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] array = new int[entrada.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}