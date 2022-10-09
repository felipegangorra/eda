import java.util.Scanner;

class SomaDois {

    public static void main(String[] aargs) {
        Scanner sc =  new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");
        int target = Integer.parseInt(sc.nextLine());
        sc.close();

        //System.out.println("[" + Calculo(sequencia, target) + "]");
        System.out.println(Calculo(sequencia, target));
    }
    
    //função que verifica cada elemento e os soma para comparar com target
    public static String Calculo(String[] sequencia, int target) {

        for (int i = 0; i < sequencia.length; i++) {
            for (int j = i + 1; j < sequencia.length; j++) {
                if(Integer.parseInt(sequencia[i]) + Integer.parseInt(sequencia[j]) == target) {

                    //return (sequencia[i] +  ", " + sequencia[j]);
                    return (sequencia[i] + " " + sequencia[j]);
                }
            }
        }
        return "-1";
    }
}
