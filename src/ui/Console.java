package ui;

import java.util.Scanner;

import logic.LibraryLogic;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 *
 *          Diese Klasse ist die direkte Schnittstelle zum Benutzer. Anhand der
 *          Eingaben in der Konsole kann man verschiedene Funktionen wie: Kunde
 *          hinzuf�gen, Medien hinzuf�gen, Kunden anzeigen, ... aufrufen.
 *
 */
public class Console {

	static Scanner sc;
	private static LibraryLogic logic;

	public Console() throws Exception {
		logic = new LibraryLogic();
		sc = new Scanner(System.in);
	}

	// --------------------------------------------------------------------------------------------------------------------
	// In der Main-Klasse wird das "Men�" der Konsole angezeigt. Hier kann man
	// mit den Eingaben (1,2,...) alle notwendigen Funktionen, in den einzelnen
	// Switch-Case aufrufen.

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
						"1 um Kunde hinzuzufuegen, \n 2 um Medium hinzuzufuegen,\n 3 um eine Adresse zu Aendern,\n 4 um Kunde anzuzeigen,\n 5 um Medium anzuzeigen,\n 6 um ein Medium auszuleihen/zurueckgeben.");
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
					break;
				case 6:
					c.ausleihenRuckgabeById();
					break;
				}

				count++;
				break;

			case 2:
				System.out.print("BenutzerID eingeben:");
				Long benutzerid = sc.nextLong();
				c.kundenAktion(benutzerid);
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
	// Diese Methode wird f�r die Erstellung eines Kundens benutzt. Zuerst
	// werden
	// alle Attribute abgefragt und dann weiter an die Logik �bergeben.

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

		try {

			Boolean success = logic.addKunde(geburtsjahrEinlesen, hnrEinlesen, nameEinlesen, ortEinlesen, plzEinlesen,
					strasseEinlesen, vornameEinlesen);

			if (success) {
				System.out.println("Kunde hinzugefuegt");
			} else {
				System.out.println("Fehler");
			}
		} catch (Exception e) {
			System.out.println("Fehler beim hinzuegen! " + e);
		}

	}

	// --------------------------------------------------------------------------------------------------------------------
	// Diese Methode wird f�r die Erstellung eines Mediums benutzt. Zuerst
	// werden
	// alle Attribute abgefragt und dann weiter an die Logik �bergeben.

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
	// Mit der Eingabe von einem Kunden und dem Medium, ein Medium
	// ausleihen/zur�ckgeben indem man die Methode in der Logik aufruft.

	public void ausleihenRuckgabeById() throws Exception {

		System.out.print("ID des Kundens eingeben:\n ");
		long id_kunde = sc.nextInt();
		System.out.print("ID des Mediums eingeben:\n ");
		long id_medium = sc.nextInt();

		logic.ausleihenRuckgabe(id_medium, id_kunde);

	}

	// --------------------------------------------------------------------------------------------------------------------
	// Indem man die neue Adresse und die ID des Kunden eingibt, kann man in
	// dieser Methode die Adresse �ndern. Alle Angaben werden in die Logik an
	// eine Methode �bergeben.

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
	// Anzeige eines Kundens anhand der Eingabe der Kunden-ID.

	public void showKundeById() {

		System.out.print("ID des Kunden angeben: ");
		Long id = sc.nextLong();
		String result = logic.searchKunde(id);
		System.out.print(result);
	}

	// --------------------------------------------------------------------------------------------------------------------
	// Anzeige eines Mediums anhand der Eingabe der Medium-ID.

	public void showMediumById() {

		System.out.print("ID des Mediums angeben: ");
		Long id = sc.nextLong();
		String result = logic.searchMedien(id);
		System.out.print(result);
	}

	public void kundenAktion(Long kundenId) throws Exception {

		System.out.println("+++ MENU AUSLEIHE / RUCKGABE +++");
		System.out.println();

		System.out.print("Medien ID eingeben");
		Long mediumId = sc.nextLong();

		logic.ausleihenRuckgabe(mediumId, kundenId);

	}

}