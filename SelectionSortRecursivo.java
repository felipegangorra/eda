import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        SelectionRecursivo(sequencia, 0);
    }


    public static String[] SelectionRecursivo(String[] sequencia, int i) {

        if(i >= sequencia.length) { return sequencia;}

        int i_menor = i;
        for (int j = i + 1; j < sequencia.length; j++) {
            if (Integer.parseInt(sequencia[j]) < Integer.parseInt(sequencia[i_menor])) {
                i_menor = j;
            }
        }

        String aux = sequencia[i];
        sequencia[i] = sequencia[i_menor];
        sequencia[i_menor] = aux;

        if(i + 1 < sequencia.length) {System.out.println(Arrays.toString(sequencia));}
        return SelectionRecursivo(sequencia, i + 1);
    }

}

