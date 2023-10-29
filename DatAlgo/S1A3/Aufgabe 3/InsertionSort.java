import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class InsertionSort {
    public static void sort(int[] A) {
        int key =0;
        int i=0;
        for(int j=1; j<=A.length-1; j++) {
            key=A[j];
            i = j-1;
            while (i>=0 && A[i]>key) {
                A[i+1]=A[i];
                i=i-1;
            }
            A[i+1]=key;
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Dateiname = scanner.nextLine();
        long start =new Date().getTime();
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
        InsertionSort.sort(A);

        for (int j=0;j<A.length;j++) {
            System.out.println(A[j]);
        }
        long runningTime = new Date().getTime()-start;
        System.out.print("Running Time: "+runningTime);
    }


}
