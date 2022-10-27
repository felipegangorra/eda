import java.util.Scanner;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sequencia = arrayInteiros(sc);
        int pivo_um = sc.nextInt();
        int pivo_dois = sc.nextInt();

        int pivot = melhorPivot(sequencia, pivo_um, pivo_dois);
        System.out.println(pivot);
        sc.close();
    }

    private static int melhorPivot(int[] array, int i, int j) {
        
        int cont_i = 0;
        int cont_j = 0;

        for (int k = 0; k < array.length; k++) {
            if(array[i] > array[k]) {
                cont_i++;
            } else if(array[i] < array[k]) {
                cont_i--;
            }
            if(array[j] > array[k]) {
                cont_j++;
            } else if(array[j] < array[k]) {
                cont_j--;
            }
        }

        //verificando mais perto do meio
        if (cont_i==array.length/2) {
			return i;
		}
		
		if (cont_j==array.length/2) {
			return j;
		}

        if(cont_i < 0) {cont_i = cont_i * -1;}  //deixar positivo
        if(cont_j < 0) {cont_j = cont_j * -1;} 

        if(cont_i <= cont_j) {
            return i;
        } else {return j;}

    }

    private static int[] arrayInteiros(Scanner sc) {
        String[] entrada = sc.nextLine().split(" ");
        int[] array = new int[entrada.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }
        return array;
    }
}
