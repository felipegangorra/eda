import java.util.Scanner;

class PotenciaRecursiva {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int numA = Integer.parseInt(sc.nextLine());
        int numB = Integer.parseInt(sc.nextLine());
        sc.close();
        int cont = 0;
        System.out.println(potencia(numA, numB, cont));
    }

    static int potencia(int a, int b, int cont) {
        cont++;
        if(cont >= b) {
            return a;
        }

        return a * potencia(a, b, cont);
    }

}
