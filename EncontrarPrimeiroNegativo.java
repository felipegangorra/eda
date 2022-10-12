import java.util.Scanner;

class EncontrarPrimeiroNegativo {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        System.out.println(primeiroNegativo(sequencia, 0));
    }

    static String primeiroNegativo(String[] sequencia, int i) {
        
        if(i >= sequencia.length) {         //caso não encontre
            return "-";
        }

        if(Integer.parseInt(sequencia[i]) < 0) {    //encontrou, parou
            return sequencia[i];
        }

        return primeiroNegativo(sequencia, i + 1);
    }
}
