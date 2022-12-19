import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

class LarguraInversa {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] elements = getArrayInteiros(scan);
		BST_Larg<Integer> bst = new BST_Larg<Integer>();

		for (int element : elements) {
			bst.insert(element);
		}

        ArrayList<Integer> out = bst.LarguraDirEsq();
        System.out.println(out);

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

class BST_Larg<Integer> {
    private NoLarg root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public ArrayList<Integer> LarguraDirEsq() {
        ArrayList<Integer> out = new ArrayList<Integer>();
        Deque<NoLarg> queue = new LinkedList<NoLarg>();
        queue.addLast(this.root);

        if(!isEmpty()) {
            queue.addLast((this.root));
            while(!queue.isEmpty()) {
                NoLarg current = queue.removeFirst();

                out.add(current.value);

                if(current.left != null) {
                    queue.addLast(current.left);
                }
                if(current.right != null) {
                    queue.addLast(current.right);
                }
            }
        }
        return out;
    }

    public void insert(int element) {
        if(isEmpty()) {
            this.root = new NoLarg(element);
        } else {
            insert(this.root, element);
        }
    }

    private void insert(NoLarg node, int element) {
        if(element < node.value) {
            if(node.left == null) {
                NoLarg newNode = new NoLarg(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            insert(node.left, element);
        } else {
            if(node.right == null) {
                NoLarg newNode = new NoLarg(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }
            insert(node.right, element);
        }
    }

}

class NoLarg {

    Integer value;
    NoLarg left;
    NoLarg right;
    NoLarg parent;

    public NoLarg(Integer value) {
        this.value = value;
    }

}
