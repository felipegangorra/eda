import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/* ---------- Árvore Binária de Pesquisa ---------- */

public class BST_Base {
    
    private Node root;  //raiz
    private int size;

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size() {
        return this.size;
    }

    public void recursiveAdd(int element) {

        if(isEmpty()) {   //fica no primeiro nó
            this.root = new Node(element);
        } else {
            recursiveAdd(this.root, element);
        }

    }

    private void recursiveAdd(Node node, int element) {

        if(element < node.value) {  //chama pela esquerda da árvore
            if(node.left == null) {     //se não existir cria com o valor
                Node newNode = new Node(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            recursiveAdd(node.left, element);   //se não for null chama novamente
        }

        else if (element > node.value) {
            if(node.right == null) {
                Node newNode = new Node(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }
            recursiveAdd(node.right, element);
        }
    }

    public Node recursiveSearch(int element) {
        return recursiveSearch(this.root, element);
    }

    private Node recursiveSearch(Node node, int element) {
        if(node == null) {  //raiz nula!
            return null;
        }

        if(element == node.value) { //encontrou
            return node;
        }

        if(element < node.value) {  //se for menor
            return recursiveSearch(node.left, element);
        } else {    //se for maior
            return recursiveSearch(node.right, element);
        }
    }

    //pegar menor valor da árvore
    public Node min() {
        if(isEmpty()) {
            return null;
        }
        return min(this.root);
    }

    private Node min(Node node) {
        if(node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    //pegar maior valor da árvore
    public Node max() {
        if(isEmpty()) {
            return null;
        } 
        return max(this.root);
    }

    private Node max(Node node) {
        if(node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    //maior depois dele
    public Node sucessor(Node node) {
        if(node == null) {
            return null;
        }

        if(node.right != null) {    //se tiver a direita então é o menor dela
            return min(node.right);
        } else {                       //se não vai para o pai até encontrar um maior
            Node aux = node.parent; //acima do node

            while(aux != null && aux.value < node.value) {
                aux = aux.parent;
            }
            return aux;
        }
    }

    //menor depois dele
    public Node predecessor(Node node) {
        if(node == null) {
            return null;
        }

        if(node.left != null) { //se tiver a esquerda então é o maior dela
            return max(node.left);
        } else {                    //vai para o pai até encontrar um menor
            Node aux = node.parent;

            while(aux != null && aux.value > node.value) {
                aux = aux.parent;
            }
            return aux;
        }
    }

    //remover
    public void remove(int value) {
        Node toRemove = recursiveSearch(root, value);
        if(toRemove != null) {
            remove(toRemove);
            this.size -= 1;
        }
    }

    // REMOÇÃO
    // CASO 1: nó é uma folha
    // CASO 2: nó possui apenas um filho
    // CASO 3: nó possui dois filhos

    private void remove(Node toRemove) {
        // CASO 1
        if(toRemove.isLeaf()) {     //leaf = folha
            if(toRemove == this.root) { //um só nó
                this.root = null;
            } else {
                if(toRemove.value < toRemove.parent.value) {    //então ele tá na esquerda
                    toRemove.parent.left = null;
                } else {
                    toRemove.parent.right = null;   //se não na direita
                }
            }

        // CASO 2
        } else if(toRemove.hasOnlyLeftChild()) {    //só tem filho a esquerda
            if(toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if(toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.left;
                } else {
                    toRemove.parent.right = toRemove.left;
                }
            }
        } else if(toRemove.hasOnlyRightChild()) {   //só tem filho a direita
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }

        // CASO 3
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }

    }

    //altura da árvore
    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if(node == null) {
            return -1;      //return -1 pois 0 é uma raiz sozinha
        } else {
            return 1 + Math.max(height(node.left), height(node.right));     //anda até o fim da esquerda e depois da direita
        }

    }

    /* PECORRER ÁRVORE: PROFUNDIDADE*/

    //PRÉ-ORDEM
    public void preOrdem() {
        preOrdem(this.root);
    }

    private void preOrdem(Node node) {      //printa e esquerda, depois faz processo pela direita
        if(node != null) {
            System.out.println(node.value);
            preOrdem(node.left);
            preOrdem(node.right);
        }
    }

    //EM-ORDEM
    public void emOrdem() {
        emOrdem(this.root);
    }

    private void emOrdem(Node node) {   //esquerda e printa, depois pela direita
        if(node != null) {
            emOrdem(node.left);
            System.out.println(node.value);
            emOrdem(node.right);
        }
    }

    //PÓS-ORDEM
    public void posOrdem() {
        posOrdem(this.root);
    }

    private void posOrdem(Node node) {  //esquerda e direita, depois printa
        if(node != null) {
            emOrdem(node.left);
            emOrdem(node.right);
            System.out.println(node.value);
        }
    }


    /* PECORRER ÁRVORE: LARGURA*/

    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>(); //para retorna print
        Deque<Node> queue = new LinkedList<Node>();

        if(!isEmpty()) {
            queue.addLast(this.root);       //addlast vem do deque
            while(!queue.isEmpty()) {
                Node current = queue.removeFirst();

                list.add(current.value);

                if(current.left != null) {
                    queue.addLast(current.left);
                }
                if(current.right != null) {
                    queue.addLast(current.right);
                }
            }
        }
        return list;
    }

}

/* ----- Classe do nó ----- */
class Node {
    int value;
    Node left;
    Node right;
    Node parent;

    Node (int value) {
        this.value = value;
    }

    //só filho a direita
    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    //só filho a esquerda
    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }

    //é uma folha
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }
}
