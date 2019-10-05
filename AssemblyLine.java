import java.util.Scanner;

public class AssemblyLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] a = new int[3][n + 1];
		int [][] t = new int[3][n + 1];
		int[] e = new int[3];
		int [] x = new int[3];
		
		System.out.println("Insert values for Assembly Line 1");
		for(int i = 1; i <= n; i++) {
			a[1][i] = s.nextInt();
		}
		
		System.out.println("Insert values for Assembly Line 2");
		for(int i = 1; i <= n; i++) {
			a[2][i] = s.nextInt();
		}

		System.out.println("Insert t1,j");
		for(int i = 1; i <= n - 1; i++) {
			t[1][i] = s.nextInt();
		}
		
		System.out.println("Insert t2,j");
		for(int i = 1; i <= n - 1; i++) {
			t[2][i] = s.nextInt();
		}
		
		System.out.println("Insert value of e");
		e[1] = s.nextInt();
		e[2] = s.nextInt();
		
		x[1] = s.nextInt();
		x[2] = s.nextInt();
		AssemblyLine obj = new AssemblyLine();
		
		obj.fastestWay(a, t, e, x, n);
	}

	public void fastestWay(int[][] a, int[][] t, int e[], int[] x, int n) {
		
		int[] f1 = new int[n + 1];
		int[] f2 = new int[n + 1];
		int[][] l = new int[3][n + 1];
		
		f1[1] = e[1] + a[1][1];
		f2[1] = e[2] + a[2][1];
		
		for(int j = 2; j <= n; j++) {
			if(f1[j - 1] + a[1][j] <= f2[j - 1] + t[2][j - 1] +a[1][j]) {
				f1[j] = f1[j - 1] + a[1][j];
				l[1][j] = 1;
				
			}
			else
			{
				f1[j] = f2[j - 1] + t[2][j - 1] +a[1][j];
				l[1][j] = 2;
			}
			
			if(f2[j - 1] + a[2][j] <= f1[j - 1] + t[1][j - 1] +a[2][j]) {
				f2[j] = f2[j - 1] + a[2][j];
				l[2][j] = 2;
				
			}
			else
			{
				f2[j] = f1[j - 1] + t[1][j - 1] +a[2][j];
				l[2][j] = 1;
				
			}
			
		}
		
		printTables(f1,f2,l);
		System.out.println();
		if(f1[n] + x[1] <= f2[n] + x[2])
		{
			System.out.println("f* : "+ (f1[n] + x[1]) + "  l* : 1" );
		}
		else
			System.out.println("f* : "+ (f2[n] + x[2]) + " l* : 2" );
		
	}

	private void printTables(int[] f1, int[] f2, int[][] l) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < f1.length; i++) {
			
			System.out.print(" "+ f1[i]);
		}
		System.out.println();
		for(int i = 1; i < f1.length; i++) {
			
			System.out.print(" "+ f2[i]);
		}
		System.out.println();
		System.out.println("The l[1]* is : ");
		for(int i = 1; i < f1.length; i++) {
			
			System.out.print(" "+ l[1][i]);
		}
		System.out.println();
		System.out.println("The l[2]* is : ");
		for(int i = 1; i < f1.length; i++) {
			
			System.out.print(" "+ l[2][i]);
		}
		System.out.println();
	}
}
