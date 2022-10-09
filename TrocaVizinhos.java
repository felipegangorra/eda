import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        String[] inteiros = sc.nextLine().split(" ");

        for (int index = 0; index < inteiros.length - 1; index += 2) {      //pular de 2 em 2
            String aux = inteiros[index];
            inteiros[index] = inteiros[index + 1];
            inteiros[index + 1] = aux;
        }

        System.out.println(Arrays.toString(inteiros));      //representação dos elementos em array
        sc.close();
    }
}