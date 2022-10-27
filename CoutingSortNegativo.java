import java.util.Arrays;
import java.util.Scanner;

class CoutingSortNegativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = arrayInteiros(sc);
        int k_valor = sc.nextInt();
        int menor = sc.nextInt();
        sc.close();
    
        coutingSort(array, k_valor, menor);
    }

    private static void coutingSort(int[] arr, int maior, int menor) {

        //int aux = -menor;   //deixa valor positivo para operação
        int[] C = new int[-menor + maior + 1]; //do menor ate o maior +1!

        //frequencia
        for (int i = 0; i < arr.length; i++) {
            C[arr[i] -menor] += 1;
            printArray(C);
        }

        //cumulativa
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }
        printCumulativa(C);

        int[] B = new int[arr.length];
        //alocação
        for (int i = arr.length-1; i >= 0; i--) {
            B[C[arr[i] -menor]-1] = arr[i];
            C[arr[i] -menor] -= 1;
        }

        printArray(C);
        printArray(B);
        
    }

	private static int[] arrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	private static void printCumulativa(int[] array) {
		String result = "Cumulativa do vetor de contagem - " + Arrays.toString(array);
		System.out.println(result);
	}
}
