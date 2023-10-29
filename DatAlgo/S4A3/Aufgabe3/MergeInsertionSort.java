import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;

public class MergeInsertionSort{
	
	static int k;
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String Dateiname = args[0];
	k = Integer.parseInt(args[1]);
	
	int i =0;
	ArrayList<Integer> List = new ArrayList();
	Scanner scan = null;
	try{
		scan = new Scanner(new File(Dateiname));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	
	while (scan.hasNextInt()) {
		List.add(scan.nextInt());
		i=i+1;
	}
	scan.close();
	int[] A = new int[i];
	for (int j=0;j<i;j++) {
		A[j] = List.get(j);
	}
	long start =new Date().getTime();
	MergeSort(A, 0, A.length);
	long runningTime = new Date().getTime()-start;
	for (int j = 0; j<A.length;j++) {
		System.out.println(A[j]);
	}
	System.out.println("Laufzeit beträgt: " + runningTime + " ms");
}

	public static void InsertionSort(int[] A, int p, int q) {
		int key = 0;
		int i = p;
		for (int j=p; j<=q-1; j++) {
			key=A[j];
			i = j-1;
				while (i>=0 && A[i]>key) {
				A[i+1]=A[i];
				i=i-1;
				}
				A[i+1]=key;
		}
   	}	
 
  	 
  	public static void MergeSort(int[]A, int p, int q) {
	  	int remaining_length = q - p;
		if (remaining_length <=k) {
		InsertionSort(A, p, q);
		return;
		}
		int mid = (p + q) / 2;
		MergeSort(A, p, mid);
		MergeSort(A, mid, q);
		merge(A, p, mid, q);
	}
	
	public static void merge(int[] A, int p, int mid, int q) {
		int[] L = Arrays.copyOfRange(A, p, mid);
		int[] R = Arrays.copyOfRange(A, mid, q);
		int L_index = 0;
		int R_index = 0;
		for(int i = p; i < q; i ++) {
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
}

