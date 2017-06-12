package ui;

import java.util.Scanner;

import logic.LibraryLogic;

/**
 * @author aprentas
 * @version 1.0
 * @created 12-Jun-2017 09:46:49
 */
public class Console {

	private static LibraryLogic logic;
	
	public Console() throws Exception {
		logic = new LibraryLogic();
	}

	public static void addKunde() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Name: ");
		String nameEinlesen = sc.nextLine();

		System.out.println("Vorname: ");
		String vornameEinlesen = sc.nextLine();
		
		System.out.println("Strasse: ");
		String strasseEinlesen = sc.nextLine();

		System.out.println("Ort: ");
		String ortEinlesen = sc.nextLine();

		System.out.println("PLZ: ");
		int plzEinlesen = sc.nextInt();

		System.out.println("Hausnummer: ");
		int hnrEinlesen = sc.nextInt();

		System.out.println("Geburtsjahr: ");
		int geburtsjahrEinlesen = sc.nextInt();
		
		System.out.println("ID: ");
		long idEinlesen = sc.nextLong();

		logic.addKunde(geburtsjahrEinlesen, hnrEinlesen, idEinlesen, nameEinlesen, ortEinlesen, plzEinlesen,
				strasseEinlesen, vornameEinlesen);
		
		sc.close();
	}

	public static void addMedium() {

	}

	public void ausleihenRuckgabeById() {

	}

	public static void changeAdress() {

	}
	

	public static void main(String[] args) {

		int count = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Bibliothek");
		System.out.println("");
		System.out.println("1 für Mitarbeiter, 2 für Kunde: ");
		int benutzer = sc.nextInt();
		int aufgabe;

		do {
			switch (benutzer) {

			case 1:
				System.out.println("1 um Kunde hinzuzufügen, 2 um Medium hinzuzufügen, 3 um eine Adresse zu aendern, 4 um Kunde anzuzeigen, 5 um Medium anzuzeigen.");
				aufgabe = sc.nextInt();
				switch (aufgabe) {
				case 1: addKunde();
				break;
				
				case 2: addMedium();
				break;
				
				case 3: changeAdress();
				break;
				
				case 4: showKundeById();
				break;
				
				case 5: showMediumById();
				}

				count++;
				break;

			case 2:
				;
				count++;
				break;

			default:
				System.out.println("Dies ist eine ungueltige Nummer, bitte geben Sie eine gueltige Nummer ein.");
				System.out.println("1 für Mitarbeiter, 2 für Kunde: ");
				benutzer = sc.nextInt();

			}
		} while (count == 0);
		sc.close();
	}

	public static void showKundeById() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID des Kunden angeben: ");
		Long id = sc.nextLong();
		logic.searchKunde(id);
		
		sc.close();		
	}

	public static void showMediumById() {

	}

}