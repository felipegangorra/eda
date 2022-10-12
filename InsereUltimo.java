import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        for (int i = 1; i < sequencia.length; i++) {

            int j = i;
            while (j > 0 && Integer.parseInt(sequencia[j]) < Integer.parseInt(sequencia[j-1])) {
                String aux = sequencia[j];
                sequencia[j] = sequencia[j-1];
                sequencia[j-1] = aux;
                j -= 1;
            }
        }

        System.out.println(Arrays.toString(sequencia));
    }
}
