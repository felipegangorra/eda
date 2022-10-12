import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        System.out.println(Arrays.toString(InsertionRecursivo(sequencia, 1)));
    }

    public static String[] InsertionRecursivo(String[] sequencia, int i) {

        if(i >= sequencia.length) {return sequencia;}

        int j = i;
        while (j > 0 && Integer.parseInt(sequencia[j]) < Integer.parseInt(sequencia[j-1])) {
            String aux = sequencia[j];
            sequencia[j] = sequencia[j-1];
            sequencia[j-1] = aux;
            j -= 1;
        }

        if(i + 1 < sequencia.length) {System.out.println(Arrays.toString(sequencia));}
        return InsertionRecursivo(sequencia, i + 1);
    }
}
