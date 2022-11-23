import java.util.Arrays;
import java.util.Scanner;

/* ---------- MAIN ---------- */

class HashSetRefatorado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanho = Integer.parseInt(sc.nextLine());  //tamanho da tabela
        HashSetRe tabela = new HashSetRe(tamanho);

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

/* ---------- TABELA HASH ---------- */

class HashSetRe {
    
    private Integer[] tabela;
    
    public HashSetRe(int tamanho) {
        this.tabela = new Integer[tamanho];
    }

    public void put(Integer value) {
        int aux = 0;
        boolean out = false;    //var de saida
        int hash;               //var de mapeamento

        while(aux < this.tabela.length - 1 && out == false) {
            hash = (hash(value) + aux) % this.tabela.length;  //cada laço muda o hash (i)

            if(this.tabela[hash] == value || this.tabela[hash] == null) {
                this.tabela[hash] = value;
                out = true;     //saida do while
            }
            aux++;
        }
    
        System.out.println(toString()); //printar a cada mudança
    }

    public void remove(Integer value) {

        int aux = 0;
        boolean out = false;
        int hash;

        while(aux < this.tabela.length - 1 && out == false) {
            hash = (this.hash(value) + aux) % this.tabela.length;

            if(this.tabela[hash] == value) {
                this.tabela[hash] = null;
                out = true;
            }
            aux++;
        }

        System.out.println(toString());
    }

    public boolean contains(Integer value) {
        int aux = 0;
        boolean out = false;
        int hash;

        while(aux < this.tabela.length -1 && out == false) {
            hash = (this.hash(value) + aux) % this.tabela.length;

            if(this.tabela[hash] == value) {
                out = true;
            }
            aux++;
        }
        return out;
    }

    //mapear para espaço na tabela
    public int hash(Integer chave) {
        return chave % this.tabela.length;
    }

    //formatar tabela
    public String toString() {
        return Arrays.toString(tabela);
    }
}