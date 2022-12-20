import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		Integer[] array = getArrayInteiros(sc);

        BuildHeap_Contro(array);
        System.out.println(Arrays.toString(array));
        sc.close();
    }

    public static void BuildHeap_Contro(Integer[] array) {
        for (int i = array.length/2; i >= 0; i--) {
            heapfy(i, array);
        }
    }

    private static void heapfy(int index, Integer[] array) {
        int index_max = max_index(array, index, left(index), right(index));

        if(index_max != index) {
            swap(array, index, index_max);
            heapfy(index_max, array);
        }
    }

    private static int max_index(Integer[] array, int index, int left, int right) {
        int maior;
        if(isValid(left, array) && array[left] > array[index]) {
            maior = left;
        } else {
            maior = index;
        }

        if(isValid(right, array) && array[right] > array[maior]) {
            maior = right;
        }

        return maior;
    }

    private static boolean isValid(int index, Integer[] array) {
        return index >= 0 && index <= array.length - 1;
    }

    private static int right(int index) {
        return 2 * (index + 1);
    }

    private static int left(int index) {
        return (2 * index) + 1;
    }

    private static void swap(Integer[] array, int index, int index2) {
        int aux = array[index];
        array[index] = array[index2];
        array[index2] = aux;
    }

    private static Integer[] getArrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
		Integer[] array = new Integer[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
    }
}
