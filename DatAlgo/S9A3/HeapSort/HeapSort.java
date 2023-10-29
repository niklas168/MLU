import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;

public class HeapSort {
	
	public static void heapify(int a[], int n, int i) {  
	    int largest = i;  
	    int left = 2 * i + 1;
	    int right = 2 * i + 2; 
	    if (left < n && a[left] > a[largest])  
	        largest = left;   
	    if (right < n && a[right] > a[largest])  
	        largest = right;   
	    if (largest != i) {   
	        int temp = a[i];  
	        a[i] = a[largest];  
	        a[largest] = temp;  
	        
	        
	        heapify(a, n, largest);  
	    }
	    
	}  
	public static void heapSort(int a[], int n) {  
	    for (int i = n/2 - 1; i >= 0; i--)  
	        heapify(a, n, i);  
	  
	    for (int i = n - 1; i >= 0; i--) {   
	        int temp = a[0];  
	        a[0] = a[i];  
	        a[i] = temp;  
	          
	        heapify(a, i, 0);  
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
        heapSort(A, A.length);
        long runningTime = new Date().getTime()-start;
        System.out.println("Running Time: "+runningTime);

        for (int j=0;j<A.length;j++) {
            System.out.println(A[j]);
        }

    }


}
