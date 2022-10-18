import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] preArray = sc.nextLine().split(" ");
        int[] array = converte(preArray);
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        sc.close();
    }

    //Metodo Merge Sort
    public static void mergeSort(int[] v, int ini, int fim) {
        printArray(v, ini, fim);  //printa os passos do array
        
        if(ini >= fim) {
            return;
        } else {
            int meio = (ini + fim) / 2;
            mergeSort(v, ini, meio);
            mergeSort(v, meio + 1, fim);
            merge(v, ini, meio, fim);
    
            //parte destinada a printar os passos do mergeSort, não faz parte do algoritmo!
            if(fim - ini < v.length-1) {
                printArray(v, ini, fim);
            }
        }
    }

    //Merge do Merge Sort
    public static void merge(int[] v, int ini, int meio, int fim) {
        int[] helper = new int [v.length];
        for (int i = 0; i < helper.length; i++) {   //clonando array
            helper[i] = v[i];
        }

        int i = ini;
        int j = meio + 1; //pois o meio conta na primeira parte
        int k = ini;
        
        //verificando menor entre i e j
        while(i <= meio && j <= fim) {
            if(helper[i] <= helper[j]) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }
            k++;
        }

        //caso i acabe, add o resto de j.
        while(j <= fim) {
            v[k] = helper[j];
            j++;
            k++;
        }

        //caso j acabe, add o resto de i.
        while(i <= meio) {
            v[k] = helper[i];
            i++;
            k++;
        }

    }

    //converte array em inteiro.
    public static int[] converte( String[] array) {
        int[] aux = new int[array.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = Integer.parseInt(array[i]);
        }
        return aux;
    }

    //get e print do intervalo especificado
    public static void printArray(int[] array, int ini, int fim) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, ini, fim + 1)));
    }
}
