import java.util.Scanner;

class ElementosDuplicados {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//sequencia de numeros separados por espaço
		String[] sequencia = sc.nextLine().split(" ");

		//dica para mim: rode o debug para ver o funcionamento
		boolean aux = false;
		for(int i = 0; i < sequencia.length; i++) {
			for(int h = i + 1; h < sequencia.length; h++) {		//começando uma casa a frente
				if (sequencia[i].equals(sequencia[h])) {
					aux = true;
					break;
				}
			}
		}
		System.out.println(aux);
		sc.close();
	}
}