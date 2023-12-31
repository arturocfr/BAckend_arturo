package g5_u1.Classes;

import g5_u1.Interfaces.ILuminosita;

public class Immagine {

	public class Immagine extends ElementoMultimediale implements ILuminosita{
		
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
				System.out.println("\u001B[31m" + "La luminosità non superiore a 10" + "\u001B[0m");
				return this.luminosita;
			}
			this.luminosita++;
			System.out.println("La luminositá è di: " + this.luminosita);
			return this.luminosita;
		}



		@Override
		public int diminuisciLuminosità() {
			if(this.luminosita <= 0) {
				System.out.println("\u001B[31m" + "La luminosità non inferiore a 0" + "\u001B[0m");
				return this.luminosita;
			}
			this.luminosita--;
			System.out.println("La luminositá è diminuita di: " + this.luminosita);
			return this.luminosita;
		}

	}







