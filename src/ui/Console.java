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

		System.out.println("Bibliothek");
		System.out.println("");
		System.out.print("1 fuer Mitarbeiter, 2 fuer Kunde: ");
		int benutzer = sc.nextInt();
		int aufgabe;

		do {
			switch (benutzer) {

			case 1:
				System.out.print(
						"1 um Kunde hinzuzufuegen, 2 um Medium hinzuzufuegen, 3 um eine Adresse zu Aendern, 4 um Kunde anzuzeigen, 5 um Medium anzuzeigen.");
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
				System.out.print("1 fuer Mitarbeiter, 2 fuer Kunde: ");
				benutzer = sc.nextInt();

			}
		} while (count == 0);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void addKunde() throws Exception {

		System.out.print("Name: ");
		String nameEinlesen;
		String pause = sc.nextLine();
		nameEinlesen = sc.nextLine();

		System.out.print("Vorname: ");
		String vornameEinlesen = sc.nextLine();

		System.out.print("Strasse: ");
		String strasseEinlesen = sc.nextLine();

		System.out.print("Ort: ");
		String ortEinlesen = sc.nextLine();

		System.out.print("PLZ: ");
		String plzEinlesen = sc.nextLine();

		System.out.print("Hausnummer: ");
		int hnrEinlesen = sc.nextInt();

		System.out.print("Geburtsjahr: ");
		int geburtsjahrEinlesen = sc.nextInt();
		// geburtsjahrEinlesen = sc.nextInt();

		System.out.print("step 0");

		try {
			System.out.print("step 1");
			Boolean success = logic.addKunde(geburtsjahrEinlesen, hnrEinlesen, nameEinlesen, ortEinlesen, plzEinlesen,
					strasseEinlesen, vornameEinlesen);
			System.out.print("step 2");
			if (success) {
				System.out.println("Kunde hinzugefügt");
			} else {
				System.out.println("Fehler");
			}
		} catch (Exception e) {
			System.out.println("Fehler beim hinzufügen! " + e);
		}

	}

	// --------------------------------------------------------------------------------------------------------------------

	public void addMedium() {

		System.out.print("Titel: ");
		String pause = sc.nextLine();
		String titelEinlesen = sc.nextLine();

		System.out.print("Autor: ");
		String autorEinlesen = sc.nextLine();

		System.out.print("Genre: ");
		String genreEinlesen = sc.nextLine();

		System.out.print("ISBN: ");
		String ISBNEinlesen = sc.nextLine();

		System.out.print("Standort-Code: ");
		String standortEinlesen = sc.nextLine();

		System.out.print("Altersfreigabe: ");
		short altersfreigabeEinlesen = sc.nextShort();

		logic.addMedien(altersfreigabeEinlesen, autorEinlesen, genreEinlesen, ISBNEinlesen, standortEinlesen,
				titelEinlesen);
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
		String plzNeu = sc.nextLine();

		System.out.print("Neue Strasse: ");
		String strasseNeu = sc.nextLine();
		

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
		String result = logic.searchKunde(id);
		System.out.print(result);
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void showMediumById() {

		System.out.print("ID des Mediums angeben: ");
		Long id = sc.nextLong();
		String result = logic.searchMedien(id);
		System.out.print(result);
	}

}