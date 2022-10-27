import java.util.Scanner;

class TopN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = arrayInteiros(sc);
        int n = sc.nextInt();
        insertionSort(array);
        System.out.println(printSaida(array, n).trim());
        sc.close();
    
    }

    private static String printSaida(int[] array, int n) {
        String retorno = "";
        int cont = 0;
        for (int i = array.length-1; i >= 0; i--) {
            if(cont < n) {
                retorno += array[i] + " ";
                cont++;
            }
        }
        return retorno;
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    private static int[] arrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
}
