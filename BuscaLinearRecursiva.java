import java.util.Scanner;

class BuscaLinearRecursiva {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int numero = Integer.parseInt(sc.nextLine());
        sc.close();

        System.out.println(contido(sequencia, 0, numero));
    }

    static int contido(String[] sequencia, int i, int numero) {
        if (i >= sequencia.length) {
            return -1;
        }

        if (Integer.parseInt(sequencia[i]) == numero) {
            return i;
        }

        return contido(sequencia, i + 1, numero);
    }
}
