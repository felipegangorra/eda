import java.util.Scanner;

class QuickSortPassoAPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = arrayInteiros(sc);

        quickSort(sequencia, 0, sequencia.length-1);
        sc.close();
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot-1);
            quickSort(array, pivot+1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot_index = array[left];
        int i = left;
        for (int j = left+1; j <= right; j++) {
            if(array[j] < pivot_index) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, left, i);
        printArray(array);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] array = new int[entrada.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }
        return array;
    }

    private static void printArray(int[] arr) {
        String saida = "";
        for (int i = 0; i < arr.length-1; i++) {
            saida += arr[i] + " ";
        }
        saida += arr[arr.length-1] + "";
        System.out.println(saida);
    }
}


