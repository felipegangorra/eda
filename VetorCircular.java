import java.util.Scanner;

class VetorCircular {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        String saida = "";
        for (int i = 0; i < n; i++) {
            saida += sequencia[(i % sequencia.length)] + " ";
        }
        System.out.println(saida.trim());
    }
}


// NÃO PASSOU EM TODOS OS TESTES

/**
class VetorCircular {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        String aux = "";
        String saida = "";
        for (int i = sequencia.length; i < n; i++) {
            for (int j = 0; j < sequencia.length; j++) {
                if(aux.length() == n){
                    break;
                }
                aux += sequencia[j];
                saida += sequencia[j] + " ";
            }   
        }

        System.out.println(saida.trim());
    }
}
*/