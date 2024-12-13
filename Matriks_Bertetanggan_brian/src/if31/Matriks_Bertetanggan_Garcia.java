package if31;

public class Matriks_Bertetanggan_Garcia {

	private int simpul_Garcia;
	private int [][] matriks_Garcia;
	
//	constractor
	public Matriks_Bertetanggan_Garcia(int simpul_Garcia) {
		this.simpul_Garcia = simpul_Garcia;
		matriks_Garcia = new int [simpul_Garcia+1][simpul_Garcia+1];
	}
	public void setSisi_Garcia(int simpulAsal_Garcia, int simpulTujuan_Garcia, int sisi_Garcia) {
		try {
			matriks_Garcia[simpulAsal_Garcia][simpulTujuan_Garcia] = sisi_Garcia;
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("Array Melebihi Batsas!!!");
		}
	}
	public int getSisi_Garcia(int simpulAsal_Garcia, int simpulTujuan_Garcia) {
		try {
			return matriks_Garcia[simpulAsal_Garcia][simpulTujuan_Garcia];
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("Array Melebihi Batsas!!!");
		}
		return -1;
	}
	public static void main(String[] args) {
		

	}

}
