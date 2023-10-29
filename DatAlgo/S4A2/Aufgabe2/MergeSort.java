import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] A) {
        sort(A, 0, A.length);
    }
    public static void sort(int[] A, int p, int q) {
        int remaining_length = q - p;
        if (remaining_length <= 1) return;
        int mid = (p + q) / 2; //Hälfte des Arrays festlegen (aufteilen)
        sort(A, p, mid); //Sortieren der linken Hälfte
        sort(A, mid, q); //Sortieren der rechten Hälfte
        merge(A, p, mid, q); //zusammenführen der sortierten Hälften
    }
    public static void merge(int[] A, int p, int mid, int q) {
        int[] L = Arrays.copyOfRange(A, p, mid);
        int[] R = Arrays.copyOfRange(A, mid, q);
        int L_index = 0;
        int R_index = 0;
        for(int i = p; i < q; i++) {
            boolean more_left = L_index < L.length;
            boolean more_right = R_index < R.length;
            boolean left_smaller = more_left && more_right
                    && L[L_index] <= R[R_index];
            if (!more_right || left_smaller) {
                A[i] = L[L_index];
                L_index++;
            } else {
                A[i] = R[R_index];
                R_index++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Dateiname = args[0];

        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(Dateiname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
            i=i+1;
        }
        scan.close();

        int[] A = new int[i];
        for (int j=0;j<i;j++) {
            A[j]=list.get(j);
        }
        long start =new Date().getTime();
        MergeSort.sort(A);
        long runningTime = new Date().getTime()-start;
        System.out.print("Running Time: "+runningTime);

        for (int j=0;j<A.length;j++) {
            System.out.println(A[j]);
        }


    }


}
