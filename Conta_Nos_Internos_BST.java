import java.util.Scanner;

class Conta_Nos_Internos_BST {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] elements = getArrayInteiros(scan);
		Arvore<Integer> bst = new Arvore<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

        int cont = bst.contaInternos();
        System.out.println(cont);

		scan.close();
	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
}

//árvore
class Arvore<T> {
    private Nozinho root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public int contaInternos() {
        return contaInternos(this.root);
    }

    private int contaInternos(Nozinho node) {
		int result = 0;
		if (!node.isEmpty()) {
            if(node.hasChildLeft() && node.hasChildRight()) {
                result = 1 + contaInternos(node.getLeft()) + contaInternos(node.getRight());
            } else if (node.hasChildLeft()) {
				result = 1 + contaInternos(node.getLeft());
			} else if (node.hasChildRight()) {
				result = 1 + contaInternos(node.getRight());
			}
		}
		return result;
    }

    public void insert(int element) {
        if(isEmpty()) {
            this.root = new Nozinho(element);
        } else {
            insert(this.root, element);
        }
    }

    private void insert(Nozinho node, int element) {
        if(element < node.value) {  //então fica na esquerda
            if(node.left == null) {
                Nozinho newNode = new Nozinho(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            insert(node.left, element);     //se não for null continha até ser
        
        } else {    //então vai pra direita da árvore
            if(node.right == null) {
                Nozinho newNode = new Nozinho(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }
            insert(node.right, element);    //continha até ser null!
        } 
    }
}

//nó
class Nozinho {
    Integer value;
    Nozinho left;
    Nozinho right;
    Nozinho parent;

    Nozinho(int value) {
        this.value = value;
    }
    
    public boolean isEmpty() {
        return this.value == null;
    }

    public boolean hasChildLeft() {
        return this.left != null;
    }

    public boolean hasChildRight() {
        return this.right != null;
    }

    public Nozinho getLeft() {
        return this.left;
    }

    public Nozinho getRight() {
        return this.right;
    }
}
