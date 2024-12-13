package if31;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class DFS_Felix {

	public void implementasi_DFS_Felix(int [][] matriks_Felix, int simpulAwal_Felix) {
		Stack<Integer> stack = new Stack<>();
		int jumlahSimpul_Felix = matriks_Felix[simpulAwal_Felix].length-1;
		int kunjungi_Felix[] = new int[jumlahSimpul_Felix+1];
		int element_Felix = simpulAwal_Felix;
		int i = simpulAwal_Felix;
		System.out.println(simpulAwal_Felix);
		kunjungi_Felix[simpulAwal_Felix] = 1;
		stack.push(simpulAwal_Felix);
		while(!stack.isEmpty()) {
			element_Felix = stack.peek(); // top stack
			i = element_Felix;
			while(i <= jumlahSimpul_Felix) {
				if (matriks_Felix[element_Felix][i] == 1 && kunjungi_Felix[i] == 0) {
					stack.push(i);
					kunjungi_Felix[i] = 1;
					element_Felix = i;
					i = 1;
					System.out.println(element_Felix);
					continue;
				}
				i++;
			}
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int jumlahSimpul_Felix, jumlahSisi_Felix, count = 1;
		int simpulAsal_Felix, simpulTujuan_Felix;
		int simpulAwal_Felix;
		
		DFS_Felix dfs = new DFS_Felix();
		System.out.print("Masukkankan Jumlah Simpul = ");
		jumlahSimpul_Felix = sc.nextInt();
		System.out.print("Masuusk Jumlah Sisi = ");
		jumlahSisi_Felix = sc.nextInt();
		
		Matriks_Bertetanggan_Felix mtBertetangga = new Matriks_Bertetanggan_Felix(jumlahSimpul_Felix);
		int matriks [][] = new int [jumlahSimpul_Felix+1][jumlahSimpul_Felix+1];
		System.out.println("Masukkan Sisi pada Graf [Simpul asal] [Simpul Tujuan]");
		while(count <= jumlahSimpul_Felix) {
			simpulAsal_Felix = sc.nextInt();
			simpulTujuan_Felix = sc.nextInt();
			mtBertetangga.setSisi_Felix(simpulAsal_Felix, simpulTujuan_Felix, 1);
			count++;
		}
		System.out.println("Tampil Matriks Ketetanggan = ");
		System.out.print("  ");
//		header
		for(int i = 1; i <= jumlahSimpul_Felix; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int i = 1 ; i <= jumlahSimpul_Felix; i++) {
			System.out.print(i + "  ");
			for(int j = 1 ; j<=jumlahSimpul_Felix; j++) {
				System.out.print(mtBertetangga.getSisi_Felix(i, j) + "  ");
				matriks[i][j] = mtBertetangga.getSisi_Felix(i, j);
			}
			System.out.println();
		}
		System.out.println("Masukkan Simpul Awal DFS = ");
		simpulAwal_Felix = sc.nextInt();
		
		System.out.println("--Tranvelsan DFS --");
		dfs.implementasi_DFS_Felix(matriks, simpulAwal_Felix);
	}

}
