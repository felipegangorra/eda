import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(",");
        sc.close();

        for (int i = 1; i < sequencia.length; i++) {

            int j = i;
            int x = sequencia[j].compareTo(sequencia[j-1]);
            while (j > 0 && x < 0) {
                String aux = sequencia[j];
                sequencia[j] = sequencia[j-1];
                sequencia[j-1] = aux;
                j -= 1;
                System.out.println(Arrays.toString(sequencia));
            }
        }

        System.out.println(Arrays.toString(sequencia));
    }
}
