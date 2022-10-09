class Palindromo {

    public static void main(String[] args) {
        String palavra = "omississimo";
        char[] test1 = palavra.toCharArray();
        String palavra2 = "palindromo";
        char[] test2 =  palavra2.toCharArray();
        System.out.println(eh_palindromo(test1));
        System.out.println(eh_palindromo(test2));
    }

    static boolean eh_palindromo(char[] palavra){
 
        for (int i = 0, j = palavra.length - 1; i < palavra.length/2; i++, j--) {
            if(palavra[i] != palavra[j]){
                return false;
            }
        }

        return true;
    }
}


//NÃO PODE USAR FUNÇÕES PRONTAS :(

/**
import java.util.Scanner;

class Palindromo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String palavra = sc.nextLine();
        palavra = palavra.toLowerCase();
        String inverso =  new StringBuffer(palavra).reverse().toString();

        boolean resultado = false;
        if (formatacao(palavra).equals(formatacao(inverso))) {
            resultado = true;
        }

        System.out.println(resultado);
        sc.close();
    }

    public static String formatacao(String palavra) {
        palavra = palavra.substring(0, palavra.length()-1);
        palavra = palavra.substring(0, 0) + palavra.substring(0+1);
        return palavra;
    }
}
*/