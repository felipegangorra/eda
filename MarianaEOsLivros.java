import java.util.Scanner;

class MarianaEOsLivros {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(",");
        sc.close();

        insertSort(entrada, entrada.length);
    }

    public static void insertSort(String sequencia[], int numLen) {
        if (numLen <= 1) {         
            String nomes = String.join(", ", sequencia);
            System.out.println(nomes.trim());
            return;
        }
           
        insertSort(sequencia, numLen - 1);

        String ult = sequencia[numLen - 1];
        int j = numLen - 2;
        while (j >= 0 && sequencia[j].compareTo(ult) > 0) {
            sequencia[j + 1] = sequencia[j];
            j--;
        }

        sequencia[j + 1] = ult;
        String nomes = String.join(", ", sequencia);
        System.out.println(nomes.trim());
      
    }
}
