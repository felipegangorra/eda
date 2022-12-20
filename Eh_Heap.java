import java.util.Scanner;

class Eh_Heap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heap = getArrayInteiros(sc);

        boolean out = isHeap(heap);
        System.out.println(out);
        sc.close();

    }

    public static boolean isHeap( int[] heap) {
        return isHeap(heap, 0);
    }

    private static boolean isHeap(int[] heap, int index) {
        if(isValid(heap, left(index)) && isValid(heap, right(index))) {

            if(heap[left(index)] < heap[index] && heap[right(index)] < heap[index]) {
                return isHeap(heap, left(index)) && isHeap(heap, right(index));
            } else {
                return false;
            }

        } else {
            return true;
        }
    }

    private static boolean isValid(int[] heap, int index) {
        return index >= 0 && index <= heap.length-1;
    }

    private static int right(int index) {
        return 2 * (index + 1);
    }

    private static int left(int index) {
        return (2 * index) + 1;
    }

    private static int[] getArrayInteiros(Scanner scan) {
        String[] elements = scan.nextLine().split(" ");
        int[] out = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            out[i] = Integer.parseInt(elements[i]);
        }
        return out;
    }
}