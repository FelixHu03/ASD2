package if31;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class DFS_Garcia {

	public void implementasi_DFS_Garcia(int [][] matriks_Garcia, int simpulAwal_Garcia) {
		Stack<Integer> stack = new Stack<>();
		int jumlahSimpul_Garcia = matriks_Garcia[simpulAwal_Garcia].length-1;
		int kunjungi_Garcia[] = new int[jumlahSimpul_Garcia+1];
		int element_Garcia = simpulAwal_Garcia;
		int i = simpulAwal_Garcia;
		System.out.println(simpulAwal_Garcia);
		kunjungi_Garcia[simpulAwal_Garcia] = 1;
		stack.push(simpulAwal_Garcia);
		while(!stack.isEmpty()) {
			element_Garcia = stack.peek(); // top stack
			i = element_Garcia;
			while(i <= jumlahSimpul_Garcia) {
				if (matriks_Garcia[element_Garcia][i] == 1 && kunjungi_Garcia[i] == 0) {
					stack.push(i);
					kunjungi_Garcia[i] = 1;
					element_Garcia = i;
					i = 1;
					System.out.println(element_Garcia);
					continue;
				}
				i++;
			}
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int jumlahSimpul_Garcia, jumlahSisi_Garcia, count = 1;
		int simpulAsal_Garcia, simpulTujuan_Garcia;
		int simpulAwal_Garcia;
		
		DFS_Garcia dfs = new DFS_Garcia();
		System.out.print("Masukkankan Jumlah Simpul = ");
		jumlahSimpul_Garcia = sc.nextInt();
		System.out.print("Masuusk Jumlah Sisi = ");
		jumlahSisi_Garcia = sc.nextInt();
		
		Matriks_Bertetanggan_Garcia mtBertetangga = new Matriks_Bertetanggan_Garcia(jumlahSimpul_Garcia);
		int matriks [][] = new int [jumlahSimpul_Garcia+1][jumlahSimpul_Garcia+1];
		System.out.println("Masukkan Sisi pada Graf [Simpul asal] [Simpul Tujuan]");
		while(count <= jumlahSimpul_Garcia) {
			simpulAsal_Garcia = sc.nextInt();
			simpulTujuan_Garcia = sc.nextInt();
			mtBertetangga.setSisi_Garcia(simpulAsal_Garcia, simpulTujuan_Garcia, 1);
			count++;
		}
		System.out.println("Tampil Matriks Ketetanggan = ");
		System.out.print("  ");
		for(int i = 1; i <= jumlahSimpul_Garcia; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int i = 1 ; i <= jumlahSimpul_Garcia; i++) {
			System.out.print(i + "  ");
			for(int j = 1 ; j<=jumlahSimpul_Garcia; j++) {
				System.out.print(mtBertetangga.getSisi_Garcia(i, j) + "  ");
				matriks[i][j] = mtBertetangga.getSisi_Garcia(i, j);
			}
			System.out.println();
		}
		System.out.println("Masukkan Simpul Awal DFS = ");
		simpulAwal_Garcia = sc.nextInt();
		
		System.out.println("--Tranvelsan DFS --");
		dfs.implementasi_DFS_Garcia(matriks, simpulAwal_Garcia);
	}

}
