import java.util.Random;

public class Shell
{
	public static void sort(Comparable[] a)
	{ // Sort a[] into increasing order.
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1)
		{ // h-sort the array.
			for (int i = h; i < N; i++)
			{ // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j-h);
			}
			h = h/3;
		}
	}

	public static Double[] bubbleSort(Double[] arr) {

		Double temp;
		for(int i=0; i < arr.length-1; i++){

			for(int j=1; j < arr.length-i; j++){
				if(arr[j-1] > arr[j]){
					temp=arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}





	private static boolean less(Comparable<Comparable<?>> v, Comparable<?> w)
	{ return v.compareTo(w) < 0; }
	private static void exch(Comparable[] a, int i, int j)
	{ Comparable<?> t = a[i]; a[i] = a[j]; a[j] = t; }



	public static void main(String[] args)
	{ 
		int n = 10;


		Random random = new Random();
		for (int j = 0; j < 100; j++) {
			Double[] a = new Double[n];
			System.out.println("The value of n is " + n);
			for (int i = 0; i < n; i++) {
				a[i] = random.nextDouble();
			}
			Double[] b = a;
			Stopwatch sw = new Stopwatch();
			sort(a);
			double time = sw.elapsedTime();
			System.out.println("For n of size " + n + ", the elapsed time was " + time + " seconds.");
			n = n*2;
			//		Stopwatch stop = new Stopwatch();
			//		bubbleSort(b);
			//		double time2 = stop.elapsedTime();
			//		System.out.println("For n of size " + n + ", the elapsed time for bubblesort was " + time + " seconds.");

		}		


	} 


}
