import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Predecessor_BST {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] elements = getArrayInteiros(scan);
		int elem = Integer.parseInt(scan.nextLine());

		BstBase<Integer> bst = new BstBase<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

        Integer[] out = bst.predecessor(elem);

        System.out.println(Arrays.toString(out));

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
class BstBase<T> {
    private NoBst root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int element) {
        if(isEmpty()) {
            this.root = new NoBst(element);
        } else {
            insert(this.root, element);
        }
    }

    private void insert(NoBst node, int element) {
        if(element < node.value) {  //então fica na esquerda
            if(node.left == null) {
                NoBst newNode = new NoBst(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }

            insert(node.left, element);     //se não for null continha até ser
        
        
        } else {    //então vai pra direita da árvore
            if(node.right == null) {
                NoBst newNode = new NoBst(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }

            insert(node.right, element);    //continha até ser null!
        } 
    }
    
    public NoBst max(NoBst node, ArrayList<Integer> out) {
        out.add(node.value);

        if(isEmpty()) {
            return null;
        }

        while(node.right != null) {
            node = node.right;
            out.add(node.value);
        }
        
        return node;
    }

    public Integer[] predecessor(int element) {

        ArrayList<Integer> out = new ArrayList<>(); //printar saida

        NoBst node = search(this.root, element);

        if(node == null) {
            return null;
        }

        out.add(element);   //referencia do caminho

        if(node.left != null) {
            max(node.left, out);  
        } else {
            NoBst aux = node.parent;

            out.add(aux.value);

            while(aux != null && aux.value > node.value) {
                aux = aux.parent;
                if(aux != null) {out.add(aux.value);}   //se não ele quebra
            }
            
        }

        return out.toArray(new Integer[0]);
    }

    public NoBst search(NoBst node, int element) {
        if(node == null) {
            return null;
        }

        if(element == node.value) {
            return node;
        }

        if(element < node.value) {
            return search(node.left, element);
        } else {
            return search(node.right, element);
        }
    }

}

//nó
class NoBst {
    int value;
    NoBst left;
    NoBst right;
    NoBst parent;

    NoBst(int value) {
        this.value = value;
    }

}
