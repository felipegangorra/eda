import java.util.Scanner;

class TemRepetido {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        boolean result = false;
        for (int i = 0; i < sequencia.length; i++) {
            for (int j = i + 1; j < sequencia.length; j++) {
                if (sequencia[i].equals(sequencia[j])){
                    result = true;
                }
            }
        }
        System.out.println(result);
    }    
}
