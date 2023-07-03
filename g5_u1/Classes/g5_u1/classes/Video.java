package g5_u1.classes;

public class Video {

}






import com.Progetto_U1.interfaces.ILuminosita;

import com.Progetto_U1.interfaces.IVolume;

public class Video extends ElementoMultimediale implements IVolume,ILuminosita{

	public int durata;
	public int volume;
	public int luminosita;
	
	public Video(String title, int durata) {
		super(title);
		this.durata = durata;
		this.volume = 4; // li inizializzo come valori giá predefiniti
		this.luminosita = 2; 
	}
	

	@Override
	public String toString() {
		return "Video " + this.title + ": [durata=" + durata + ", volume=" + volume + ", luminosita=" + luminosita + "]";
	}


	@Override
	public int abbassaVolume() {
		if(this.volume <= 0) {
			System.out.println("\u001B[31m" + "Il volume non puó essere inferiore a 0" + "\u001B[0m");
			return this.volume;
		}
		this.volume--;
		System.out.println("Il volume é stato diminuito a: " + this.volume);
		return this.volume;
	}

	@Override
	public int alzaVolume() {
		if(this.volume >= 5) {
			System.out.println("\u001B[31m" + "Il volume non puó essere superiore a 5" + "\u001B[0m");
			return this.volume;
		}
		this.volume++;
		System.out.println("Il volume é stato aumentato a: " + this.volume);
		return this.volume;
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


	@Override
	public void play() {
		for(int i = 0; i < this.durata;i++){
			System.out.print("\u001B[32m" + this.title);			
			for (int x = 0; x < this.volume;x ++) {
			System.out.print('!');
			}
			for (int j = 0; j < this.luminosita;j ++) {
			System.out.print('*');
			}
			System.out.println("" + "\u001B[0m");
		}
		
	}
}