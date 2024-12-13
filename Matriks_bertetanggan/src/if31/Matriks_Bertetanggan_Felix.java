package if31;

public class Matriks_Bertetanggan_Felix {

	private int simpul_Felix;
	private int [][] matriks_Felix;
	
//	constractor
	public Matriks_Bertetanggan_Felix(int simpul_Felix) {
		this.simpul_Felix = simpul_Felix;
		matriks_Felix = new int [simpul_Felix+1][simpul_Felix+1];
	}
	public void setSisi_Felix(int simpulAsal_Felix, int simpulTujuan_Felix, int sisi_Felix) {
		try {
			matriks_Felix[simpulAsal_Felix][simpulTujuan_Felix] = sisi_Felix;
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("Array Melebihi Batsas!!!");
		}
	}
	public int getSisi_Felix(int simpulAsal_Felix, int simpulTujuan_Felix) {
		try {
			return matriks_Felix[simpulAsal_Felix][simpulTujuan_Felix];
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("Array Melebihi Batsas!!!");
		}
		return -1;
	}
	public static void main(String[] args) {
		

	}

}
