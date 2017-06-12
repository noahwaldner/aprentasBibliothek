package ui;

import java.util.Scanner;

import logic.LibraryLogic;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class Console {

	static Scanner sc;

	private static LibraryLogic logic;

	public Console() throws Exception {
		logic = new LibraryLogic();
		sc = new Scanner(System.in);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) throws Exception {

		Console c = new Console();

		int count = 0;

		System.out.print("Bibliothek");
		System.out.print("");
		System.out.print("1 für Mitarbeiter, 2 für Kunde: ");
		int benutzer = sc.nextInt();
		int aufgabe;

		do {
			switch (benutzer) {

			case 1:
				System.out.print(
						"1 um Kunde hinzuzufügen, 2 um Medium hinzuzufügen, 3 um eine Adresse zu aendern, 4 um Kunde anzuzeigen, 5 um Medium anzuzeigen.");
				aufgabe = sc.nextInt();
				switch (aufgabe) {
				case 1:
					c.addKunde();
					break;

				case 2:
					c.addMedium();
					break;

				case 3:
					c.changeAdress();
					break;

				case 4:
					c.showKundeById();
					break;

				case 5:
					c.showMediumById();
				}

				count++;
				break;

			case 2:	
				c.ausleihenRuckgabeById();
				count++;
				break;

			default:
				System.out.print("Dies ist eine ungueltige Nummer, bitte geben Sie eine gueltige Nummer ein: ");
				System.out.print("1 für Mitarbeiter, 2 für Kunde: ");
				benutzer = sc.nextInt();

			}
		} while (count == 0);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void addKunde() {

		System.out.print("Name: ");
		String nameEinlesen = sc.nextLine();
		sc.nextLine();

		System.out.print("Vorname: ");
		String vornameEinlesen = sc.nextLine();

		System.out.print("Strasse: ");
		String strasseEinlesen = sc.nextLine();

		System.out.print("Ort: ");
		String ortEinlesen = sc.nextLine();

		System.out.print("PLZ: ");
		int plzEinlesen = sc.nextInt();

		System.out.print("Hausnummer: ");
		int hnrEinlesen = sc.nextInt();

		System.out.print("Geburtsjahr: ");
		int geburtsjahrEinlesen = sc.nextInt();

		System.out.print("ID: ");
		long idEinlesen = sc.nextLong();

		logic.addKunde(geburtsjahrEinlesen, hnrEinlesen, idEinlesen, nameEinlesen, ortEinlesen, plzEinlesen,
				strasseEinlesen, vornameEinlesen);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void addMedium() {

		System.out.print("Titel: ");
		String titelEinlesen = sc.nextLine();
		sc.nextLine();

		System.out.print("Autor: ");
		String autorEinlesen = sc.nextLine();

		System.out.print("Genre: ");
		String genreEinlesen = sc.nextLine();

		System.out.print("ISBN: ");
		String ISBNEinlesen = sc.nextLine();

		System.out.print("Standort-Code: ");
		String standortEinlesen = sc.nextLine();

		System.out.print("ID: ");
		long idEinlesen = sc.nextLong();

		System.out.print("Altersfreigabe: ");
		short altersfreigabeEinlesen = sc.nextShort();

		logic.addMedien(altersfreigabeEinlesen, autorEinlesen, genreEinlesen, idEinlesen, ISBNEinlesen,
				standortEinlesen, titelEinlesen);
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	public void ausleihenRuckgabeById() {
		
		System.out.print("ID des Mediums eingeben \n: ");
		int id = sc.nextInt(); 
		
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void changeAdress() {

		System.out.print("Neuer Ort: ");
		String ortNeu = sc.nextLine();
		sc.nextLine();

		System.out.print("Neuer PLZ: ");
		int plzNeu = sc.nextInt();

		System.out.print("Neue Strasse: ");
		String strasseNeu = sc.nextLine();
		sc.nextLine();

		System.out.print("Neue Hausnummer: ");
		int hnrNeu = sc.nextInt();

		System.out.print("Kunden-ID: ");
		long kundeIDNeu = sc.nextLong();

		logic.changeAdress(strasseNeu, hnrNeu, plzNeu, ortNeu, kundeIDNeu);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void showKundeById() {

		System.out.print("ID des Kunden angeben: ");
		Long id = sc.nextLong();
		logic.searchKunde(id);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void showMediumById() {

		System.out.print("ID des Mediums angeben: ");
		Long id = sc.nextLong();
		logic.searchMedien(id);
	}

}