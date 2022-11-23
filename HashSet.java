import java.util.Arrays;
import java.util.Scanner;

/* ---------- MAIN ---------- */

class HashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer tamanho = Integer.parseInt(sc.nextLine());  //tamanho da tabela
        HashSetTabela tabela = new HashSetTabela(tamanho);

        Integer value;
        String entrada[];   //armazenar dois elementos da entrada(comando e valor)
        String comando = "";    //comando da vez

        while(!comando.equals("end")) {
            entrada = sc.nextLine().split(" ");
            comando = entrada[0];

            switch (comando) {
                case "put":
                value = Integer.parseInt(entrada[1]);   //valor
                tabela.put(value);
                break;

                case "remove":
                value = Integer.parseInt(entrada[1]);
                tabela.remove(value);
                break;

                case "contains":
                value = Integer.parseInt(entrada[1]);
                System.out.println(tabela.contains(value));
                break;
            }
        }

        sc.close();
    } 
}

/* ---------- CLASS TABELA HASH ---------- */

class HashSetTabela {
    private Element[] tabela;
    private int elements;

    public HashSetTabela(Integer tamanho) {
        this.tabela = new Element[tamanho];
        this.elements = 0;
    }

    //adicionar elemento na tabela
    public void put(Integer value){
        if(!this.isFull() && !this.contains(value)) {    //se tiver espaço e não tiver o elemento
            int i = 0;
            int j;

            boolean okay = false;   //var de parada
            while(i < this.tabela.length && okay == false) {
                j = (this.hash(value) + i) % this.tabela.length;    //pega posição na tabela
                if(this.tabela[j] == null || this.tabela[j].getFlag()) {    //se é null ou se foi deletado(true)
                    this.tabela[j] = new Element(value);
                    this.elements++;
                    okay = true;    //para sair do while
                }
                i++;
            }
        }
        System.out.println(this.toString());        //printar a cada mudança
    }

    //remover elemento da tabela e adicionar flag
    public void remove(Integer value) {
        if(this.contains(value)) {
            int i = 0;
            int j = (this.hash(value) + i) % this.tabela.length;
            boolean okay = false;

            while(i < this.tabela.length && okay == false && this.tabela[j] != null) {
                j = (this.hash(value) + i) % this.tabela.length;    //lugar na tabela

                if(this.tabela[j].getvalue() == value) {    //verificando valor do objeto com o valor passado
                    this.tabela[j].setFlag();   //passando o boolean para true (flag de deletado)
                    this.elements--;
                    okay = true;
                }
                i++;
            }
        }
        System.out.println(this.toString());        //printar cada mudança
    }

    public boolean contains(Integer value) {
        boolean okay = false;   //var de parada
        if(!isEmpty()) {
            int i = 0;
            while(i < this.tabela.length-1 && okay == false) {
                int j = (this.hash(value) + i) % this.tabela.length;    //pegando lugar na tabela

                if(this.tabela[j] != null && this.tabela[j].getFlag() == false) {  //verificando se é valido
                    if(this.tabela[j].getvalue() == value){     //verificando se é o elemento
                        okay = true;
                    }
                }
                i++;
            }
        }
        return okay;
    }

    public boolean isFull() {
        return (this.elements == this.tabela.length);
    }

    public boolean isEmpty() {
        return this.elements == 0;
    }

    //pega lugar dentro da tebal
    public int hash(Integer key) {
        return key % this.tabela.length;
    }

    //printa tabela
    public String toString() {
        return Arrays.toString(this.tabela);
    }
}

/* ---------- CLASS OBJECT ---------- */

class Element {
    private Integer value;  //value
    private boolean flag;    //flag

    public Element(Integer value) {
        this.value = value;
        this.flag = false;
    }

    public void setFlag() {     //muda value se foi flag
        this.flag = true;
    }

    public boolean getFlag() {   //retorna estado da var 
        return this.flag;
    }

    public Integer getvalue() {
        return value;
    }
    
    @Override
    public String toString() {
        String result = "";
        if(!this.flag) {
            result += this.value;
        } else {
            result = null;
        }
        return result;
    }
}
