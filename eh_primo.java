import java.util.Scanner;

class Eh_primo {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int numero =  Integer.parseInt(sc.nextLine());
        sc.close();

        boolean result = true;
        for (int i = 2; i < numero ; i++) {
            if(numero % i == 0){
                result = false;
            }
        }
        System.out.println(result);
    }
}