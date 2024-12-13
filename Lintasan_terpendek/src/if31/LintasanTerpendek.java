package if31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.constant.DirectMethodHandleDesc.Kind;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

import javax.print.DocFlavor.INPUT_STREAM;

public class LintasanTerpendek {

	static class Sisi{
		int asal;
		int tujuan;
		int bobot;
		Sisi(int asal, int tujuan, int bobot){
			this.asal = asal;
			this.tujuan = tujuan;
			this.bobot = bobot;
		}
	}
	static class Lintasan implements Comparable<Lintasan>{
		int simpul;
		String path;
		int bobotPath;
		
		Lintasan(int simpul, String lintasn, int bobot){
			this.simpul = simpul;
			this.path = lintasn;
			this.bobotPath = bobot;
		}
		public int compareTo(Lintasan l) {
			return this.bobotPath - l.bobotPath;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nSisi, nSimpul;
		System.out.println("Masukkan Jumlah Simpul = ");
		nSimpul = Integer.parseInt(br.readLine());
		System.out.println("Masukkan Jumlah Sisi = ");
		nSisi = Integer.parseInt(br.readLine());
		
		ArrayList<Sisi> [] graf = new ArrayList[nSimpul];
		for(int i = 0; i < nSimpul; i++) {
            graf[i] = new ArrayList<>();
        }
		System.out.println("<Simpul Asal> <Simpul Tujuan> <Bobot>");
        for(int i = 0; i < nSisi; i++) {
            String[]parts = br.readLine().split(" ");
            int simpul1 = Integer.parseInt(parts[0]);
            int simpul2 = Integer.parseInt(parts[1]);
            int bobot = Integer.parseInt(parts[2]);
            // kasus kalo graf tidak berarah maka dua, jika 1 hanya simpul 1
            graf[simpul1].add(new Sisi(simpul1, simpul2, bobot));
//            graf[simpul2].add(new Sisi(simpul2, simpul1, bobot));
        }
		System.out.println("Massukkan Simpul Awal = ");
		int awal = Integer.parseInt(br.readLine());
		boolean [] kunjungi = new boolean [nSimpul];
		
//		menampung lintasan
		PriorityQueue<Lintasan> pq = new PriorityQueue<>();
		pq.add(new Lintasan(awal, awal + " ", 0));
		
		System.out.println("Lintasan Terpendek = ");
        while(pq.size()>0) {
            Lintasan remove = pq.remove();
            if(kunjungi[remove.simpul] == true ) {
                continue;
            }
            kunjungi[remove.simpul] = true;
            System.out.println(remove.simpul + " : lintasan = " + remove.path + " bobot = " + remove.bobotPath);

            for(Sisi s : graf[remove.simpul]) {
                if(kunjungi[s.tujuan] == false) {
                    pq.add(new Lintasan(s.tujuan, remove.path + " -> " + s.tujuan, remove.bobotPath + s.bobot));
                }
            }
        }

	}

}
