import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        sc.close();

        for (int i = 0; i < sequencia.length; i++) {
		
            int cont = 1;
            int i_menor = i;
            for (int j = i + 1; j < sequencia.length; j++)
                if (Integer.parseInt(sequencia[j]) < Integer.parseInt(sequencia[i_menor])) {
                    i_menor = j;
                    cont = 2;
                }

            String aux = sequencia[i];
            sequencia[i] = sequencia[i_menor];
            sequencia[i_menor] = aux;

            if(cont == 2) {System.out.println(Arrays.toString(sequencia));}
        
        }
    }
}
