package if31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.event.ListDataEvent;

public class Topological_Sort_Felix {

	public static class Graf<T>{
		private Set<T> simpul;
		private Map<T, List<T>> sisi;
		
		public Graf() {
			simpul = new HashSet<T>();
			sisi = new HashMap<T, List<T>>();
		}
		public Graf(Collection<T> nodes) {
			this.simpul = new HashSet<T>(nodes);
			this.sisi = new HashMap<T,List<T>>();
			}
		public void addSisi( T asal, T tujuan) {
			simpul.add(asal);
			simpul.add(tujuan);
			if (sisi.containsKey(asal)) {
				sisi.get(asal).add(tujuan);
			}
			else {
				List<T> list = new ArrayList<T>();
				list.add(tujuan);
				sisi.put(asal, list);
			}
				
		}
		public List<T> implementasi_Topological(){
			Map<T, Integer> inDegreee = new HashMap<T, Integer>();
			for(T simpul : simpul) {
				inDegreee.put(simpul, 0);
			}
			for(T simpul : sisi.keySet()) {
				for(T tetangga : sisi.get(simpul)) {
					inDegreee.put(tetangga, inDegreee.get(tetangga)+ 1);
				}
			}
			Queue<T> queque = new LinkedList<T>();
			for(T simpul : simpul) {
				if (inDegreee.get(simpul) == 0) {
					queque.add(simpul);
				}
			}
			List<T> hasil = new ArrayList<T>();
			while(!queque.isEmpty()) {
				T simpul = queque.poll();
				hasil.add(simpul);
				
				if (!sisi.containsKey(simpul)) {
					continue;
				}
				for(T tetangga : sisi.get(simpul)) {
					int degree = inDegreee.get(tetangga);
					--degree;
					if(degree == 0) {
						queque.add(tetangga);
					}
					inDegreee.put(tetangga, degree);
				}
			}
			return hasil;
		}
	}
	
	public static void main(String[] args)throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Masukkan Jumlah Sisi = ");
		int nSisi = Integer.parseInt(br.readLine());
		
		System.out.println("<SimpulAsal>  <Simpul Tujuan>");
		Graf<Integer> graf = new Graf<Integer>();
		
		for(int i = 0; i < nSisi; i++) {
			String[] sisi = br.readLine().split(" ");
			int asal = Integer.parseInt(sisi[0]);
			int tujuan = Integer.parseInt(sisi[1]);
			graf.addSisi(asal, tujuan);
			}
		List<Integer> hasil = graf.implementasi_Topological();
		for (int i  : hasil) {
			System.out.printf("%d", i);
		}
		System.out.println();

	}

}
