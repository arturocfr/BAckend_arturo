package g5_u1;

import java.util.Scanner;

import g5_u1.Classes.ElementoMultimediale;
import g5_u1.Classes.Immagine;
import g5_u1.Classes.RegistrazioneAudio;
import g5_u1.Classes.Video;


public class MainProject {

			public static void main(String[] args) {

				// ORA FARÓ SI CHE SIA L'UTENTE A SCEGLIERE, TRAMITE LO SCANNER, I VARI ELEMENTI
				// MULTIMEDIALI
				System.out.println("\u001B[35m" + "=====================" + "\u001B[0m");
				System.out.println("\u001B[33m" + "LETTORE MULTIMEDIALE" + "\u001B[0m");
				System.out.println("\u001B[35m" + "=====================" + "\u001B[0m");
				System.out.println("Salve! In questo momento riempiamo il tuo lettore con 5 elementi multimediali!");
				Scanner input = new Scanner(System.in);
				ElementoMultimediale[] lettoreMultimediale = new ElementoMultimediale[5];

				for (int i = 0; i < 5; i++) {

					int tipologia, durata;
					String title;
					boolean variabile = true;

					while (variabile) {
						System.out.println("Specifica il tipo di file multimediale che desideri inserire:");
						System.out.println("\u001B[36m" + "(Attualmente hai " + "\u001B[33m" + i + "\u001B[0m" + "\u001B[36m"
								+ " /5 Elementi Multimediali)" + "\u001B[0m");
						System.out.println("1 per Immagine \n2 per Audio \n3 per Video");
						tipologia = Integer.parseInt(input.nextLine());

						switch (tipologia) {

						case 1:
							System.out.println("\u001B[36m" + "Inserire il titolo dell'immagine:" + "\u001B[0m");
							title = input.nextLine();
							lettoreMultimediale[i] = new Immagine(title);
							variabile = false;
							break;
						case 2:
							System.out.println("\u001B[36m" + "Inserire il titolo dell'audio:" + "\u001B[0m");
							title = input.nextLine();
							System.out.println("\u001B[36m" + "Inserire la durata dell'audio `" + title + "`." + "\u001B[0m");
							durata = Integer.parseInt(input.nextLine());
							lettoreMultimediale[i] = new RegistrazioneAudio(title, durata);
							variabile = false;
							break;
						case 3:
							System.out.println("\u001B[36m" + "Inserire il titolo del video." + "\u001B[0m");
							title = input.nextLine();
							System.out.println("\u001B[36m" + "Inserire la durata del video `" + title + "`." + "\u001B[0m");
							durata = Integer.parseInt(input.nextLine());
							lettoreMultimediale[i] = new Video(title, durata);
							variabile = false;
							break;
						default:
							System.out.println("\u001B[31m" + "Selezione errata!" + "\u001B[0m");
							break;
						}
					}
				}

			
				int inputLettoreMultimediale;
				boolean condizione = true;

				while (condizione) {
					System.out.println("\u001B[35m" + "=============" + "\u001B[0m");
					System.out.println("\u001B[33m" + "    MENU   " + "\u001B[0m");
					System.out.println("\u001B[35m" + "=============" + "\u001B[0m");
					System.out.println(
							"\u001B[36m" + "Scegli da 1 a 5 per mettere play, altrimenti 0 per stoppare tutto!" + "\u001B[0m");

					for (int i = 0; i < 5; i++) {
						System.out.print((i + 1) + ")" + lettoreMultimediale[i].getTitle() + " ");
					}
					System.out.println("");
					inputLettoreMultimediale = Integer.parseInt(input.nextLine());

					if (inputLettoreMultimediale == 0) {
						condizione = false;
						System.out.println("\u001B[31m" + "Stop! Lettore Multimediale interrotto!" + "\u001B[0m");
						break;
					}

					ElementoMultimediale el = lettoreMultimediale[inputLettoreMultimediale - 1];
					lettoreMultimediale[inputLettoreMultimediale - 1].play();
					System.out.println("\u001B[36m" + "Vuoi modificare qualcosa del file multimediale? [Y/N]" + "\u001B[0m");
					String risposta = input.nextLine();
					if (risposta.equalsIgnoreCase("Y")) {
						if (el instanceof Immagine) {

							System.out.println("\u001B[36m" + "Vuoi modificare la luminosità?" + "\u001B[0m"
									+ "\n1. Si \n2. No, va bene così");
							int risposta1 = Integer.parseInt(input.nextLine());

							switch (risposta1) {
							case 1:
								boolean exit = true;
								while (exit) {
									System.out.println("\u001B[36m" + "Vuoi abbassare o alzare la luminosità?" + "\u001B[0m"
											+ "\n1. Abbassare la luminosità. \n2. Alzare la luminosità. \n3. Indietro");
									int risposta2 = Integer.parseInt(input.nextLine());
									switch (risposta2) {
									case 1:
										((Immagine) el).diminuisciLuminosità();
										System.out.println(((Immagine) el));
										break;
									case 2:
										((Immagine) el).aumentaLuminosità();
										System.out.println(((Immagine) el));
										break;
									case 3:
										exit = false;
										break;
									}
								}

								break;

							case 2:
								System.out.println("\u001B[36m" + "Ok a posto così" + "\u001B[0m");
								continue;
							}

						} else if (el instanceof RegistrazioneAudio) {

							System.out.println("\u001B[36m" + "Vuoi modificare il volume?" + "\u001B[0m"
									+ "\n1. Si \n2. No, va bene così");
							int risposta1 = Integer.parseInt(input.nextLine());

							switch (risposta1) {
							case 1:
								boolean exit = true;
								while (exit) {
									System.out.println("\u001B[36m" + "Vuoi abbassare o alzare il volume?" + "\u001B[0m"
											+ "\n1. Abbassare il volume. \n2. Alzare il volume. \n3. Indietro");
									int risposta2 = Integer.parseInt(input.nextLine());
									switch (risposta2) {
									case 1:
										((RegistrazioneAudio) el).abbassaVolume();
										System.out.println(((RegistrazioneAudio) el));
										break;
									case 2:
										((RegistrazioneAudio) el).alzaVolume();
										System.out.println(((RegistrazioneAudio) el));
										break;
									case 3:
										exit = false;
										break;
									}
								}

								break;

							case 2:
								System.out.println("\u001B[36m" + "Ok a posto così" + "\u001B[0m");
								continue;
							}
						}

						else if (el instanceof Video) {
							System.out.println("\u001B[36m" + "Vuoi modificare il volume o la luminosità?" + "\u001B[0m"
									+ "\n1. Il volume \n2. La luminosità");

							int risposta1 = Integer.parseInt(input.nextLine());

							boolean exit1 = true;
							boolean exit2 = true;

							switch (risposta1) {
							// Il volume
							case 1:
								System.out.println("\u001B[36m" + "Vuoi modificare il volume?" + "\u001B[0m"
										+ "\n1. Si \n2. No, va bene così");
								int risposta1a = Integer.parseInt(input.nextLine());
								switch (risposta1a) {
								case 1:
									while (exit1) {
										System.out.println("\u001B[36m" + "Vuoi abbassare o alzare il volume?" + "\u001B[0m"
												+ "\n1. Abbassare il volume. \n2. Alzare il volume. \n3. Indietro");
										int risposta1b = Integer.parseInt(input.nextLine());

										switch (risposta1b) {
										case 1:
											((Video) el).abbassaVolume();
											System.out.println(((Video) el));
											break;
										case 2:
											((Video) el).alzaVolume();
											System.out.println(((Video) el));
											break;
										case 3:
											exit1 = false;
											break;
										}
									}
									break;
								case 2:
									System.out.println("\u001B[36m" + "Ok a posto così" + "\u001B[0m");
									continue;
								}
								// La luminosità
							case 2:
								System.out.println("\u001B[36m" + "Vuoi modificare la luminosità?" + "\u001B[0m"
										+ "\n1. Si \n2. No, va bene così");
								int risposta2a = Integer.parseInt(input.nextLine());
								switch (risposta2a) {
								case 1:
									while (exit2) {
										System.out.println("\u001B[36m" + "Vuoi abbassare o alzare la luminosità?" + "\u001B[0m"
												+ "\n1. Abbassare la luminosità. \n2. Alzare la luminosità. \n3. Indietro");
										int risposta2b = Integer.parseInt(input.nextLine());

										switch (risposta2b) {
										case 1:
											((Video) el).diminuisciLuminosità();
											System.out.println(((Video) el));
											break;
										case 2:
											((Video) el).aumentaLuminosità();
											System.out.println(((Video) el));
											break;
										case 3:
											exit2 = false;
											break;
										}
									}
									break;
								case 2:
									System.out.println("\u001B[36m" + "Ok a posto così" + "\u001B[0m");
									continue;
								}
							}

						}
					}

				}
				input.close();
			}
		}
	}

}




