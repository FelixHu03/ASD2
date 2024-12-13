package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Matriks_Ketetangggan {
	private int simpul;
	private int[][] matrix_ketetanggan;

	public Matriks_Ketetangggan(int simpul) {
		this.simpul = simpul;
		matrix_ketetanggan = new int[simpul + 1][simpul + 1];
	}

	public void setSisi(int asal, int tujuan, int sisi) {
		try {
			matrix_ketetanggan[asal][tujuan] = sisi;
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("Error!!!");
		}
	}

	public int getSisi(int asal, int tujuan) {
		try {
			return matrix_ketetanggan[asal][tujuan];
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("Error!!!");
		}
		return -1;
	}
}

public class Graf_BFS {

	private Queue queue;

//konstruktor
	public Graf_BFS() {
		
		queue = new LinkedList();
	}
	public void implementasi_bfs1(int[][] matrix, int simpulAwal, int jumlahSimpul) {
        int[] kunjungi = new int[jumlahSimpul + 1];
        int element;

        kunjungi[simpulAwal] = 1;
        queue.add(simpulAwal);
        System.out.print(convertIntToChar(simpulAwal) + " ");
        while (!queue.isEmpty()) {
            element = (int) queue.remove();
            int i = 1;
            while (i <= jumlahSimpul) {
                if (matrix[element][i] == 1 && kunjungi[i] == 0) {
                    queue.add(i);
                    kunjungi[i] = 1;
                    System.out.print(convertIntToChar(i) + " ");
                }
                i++;
            }
        }
        System.out.println();
    }

	public void implementasi_bfs(int[][] matrix, int simpulAwal, int jumlahSimpul) {
		int[] kunjungi = new int[jumlahSimpul + 1]; // 1 = telah dikunjungi, 0 = belum dikunjungi (secara default = 0)

		int element;

		kunjungi[simpulAwal] = 1;
		queue.add(simpulAwal);
		System.out.println(simpulAwal + "");
		while (!queue.isEmpty()) {
			element = (int) queue.remove();
			int i = 1;
			while (i <= jumlahSimpul) {
				if (matrix[element][i] == 1 && kunjungi[i] == 0) { // syarat : kunjungi jika tetangga dan jika belum
																	// dikunjungi
					queue.add(i);
					kunjungi[i] = 1;
					System.out.println(i + "");
				}
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int jumlahSimpul, jumlahSisi, count = 1;
        Matriks_Ketetangggan graf;
        Graf_BFS bfs = new Graf_BFS();
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan Jumlah Simpul = ");
        jumlahSimpul = sc.nextInt();
        System.out.println("Masukkan Jumlah Sisi = ");
        jumlahSisi = sc.nextInt();

        graf = new Matriks_Ketetangggan(jumlahSimpul);
        int matrix[][] = new int[jumlahSimpul + 1][jumlahSimpul + 1];

        System.out.println("Masukkan Simpul Awal dan Simpul Tujuan (huruf a-z) = ");
        while (count <= jumlahSisi) {
            char asalChar = sc.next().charAt(0);
            char tujuanChar = sc.next().charAt(0);
            int asal = convertCharToInt(asalChar);
            int tujuan = convertCharToInt(tujuanChar);
            graf.setSisi(asal, tujuan, 1);
            count++;
        }

        System.out.println("Matriks Ketetanggan : ");
        for (int i = 1; i <= jumlahSimpul; i++) {
            System.out.print("  Fe"  + i);
        }
        System.out.println();
        for (int i = 1; i <= jumlahSimpul; i++) {
            System.out.print(" Fe" + i);
            for (int j = 1; j <= jumlahSimpul; j++) {
                System.out.print(graf.getSisi(i, j) + "  ");
                matrix[i][j] = graf.getSisi(i, j);
            }
            System.out.println();
        }

        System.out.println("Masukkan Simpul Awal (huruf a-z) = ");
        char simpulAwalChar = sc.next().charAt(0);
        int simpulAwal = convertCharToInt(simpulAwalChar);

        System.out.println("Traversal BFS = ");
        bfs.implementasi_bfs(matrix, simpulAwal, jumlahSimpul);
    }
	private static String convertIntToChar(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	private static int convertCharToInt(char asalChar) {
		// TODO Auto-generated method stub
		return 0;
	}

}