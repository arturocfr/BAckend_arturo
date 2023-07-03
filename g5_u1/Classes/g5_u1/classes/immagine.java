package g5_u1.classes;
import g5_1.interfaces.ILuminosita;

public class immagine extends ElementoMultimediale implements ILuminosita{
	public int luminosita;
	
	public Immagine(String title) {
		super(title);
		this.luminosita = 3;
	}
	
	

	@Override
	public String toString() {
		return "Immagine " + this.title + ": [luminosita=" + luminosita + "]";
	}



	@Override
	public void play() {
		this.show();
	};
	   
	public void show() {
		System.out.print("\u001B[32m" + this.title);
		for (int i = 0; i < this.luminosita;i ++) {
			System.out.print('*');
		}
		System.out.println("" + "\u001B[0m");
	}



	@Override
	public int aumentaLuminosità() {
		if(this.luminosita >= 10) {
			System.out.println("\u001B[31m" + "La luminosità non puó essere superiore a 10" + "\u001B[0m");
			return this.luminosita;
		}
		this.luminosita++;
		System.out.println("La luminositá é stata aumentata a: " + this.luminosita);
		return this.luminosita;
	}



	@Override
	public int diminuisciLuminosità() {
		if(this.luminosita <= 0) {
			System.out.println("\u001B[31m" + "La luminosità non puó essere inferiore a 0" + "\u001B[0m");
			return this.luminosita;
		}
		this.luminosita--;
		System.out.println("La luminositá é stata diminuita a: " + this.luminosita);
		return this.luminosita;
	}

}







