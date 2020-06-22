import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	ArrayList<Domino> deck = new ArrayList<Domino>();

	public Data() {
		File file = new File("dominos.csv");
		Scanner sc;
		{
			try {
				sc = new Scanner(file);
				sc.nextLine();
				while (sc.hasNextLine()) {
					String[] ligne = sc.nextLine().split(",");
					if (ligne[1].equals("Champs")) {
						ligne[1] = "P";
					} else if (ligne[1].equals("Mer")) {
						ligne[1] = "W";
					} else if (ligne[1].equals("Foret")) {
						ligne[1] = "F";
					} else if (ligne[1].equals("Prairie")) {
						ligne[1] = "L";
					} else if (ligne[1].equals("Mine")) {
						ligne[1] = "Q";
					} else if (ligne[1].equals("Montagne")) {
						ligne[1] = "M";
					} else {
						ligne[1] = "?";
						System.out.println("?");
					}
					if (ligne[3].equals("Champs")) {
						ligne[3] = "P";
					} else if (ligne[3].equals("Mer")) {
						ligne[3] = "W";
					} else if (ligne[3].equals("Foret")) {
						ligne[3] = "F";
					} else if (ligne[3].equals("Prairie")) {
						ligne[3] = "L";
					} else if (ligne[3].equals("Mine")) {
						ligne[3] = "Q";
					} else if (ligne[3].equals("Montagne")) {
						ligne[3] = "M";
					} else {
						ligne[3] = "?";
						System.out.println("?");
					}
					this.deck.add(new Domino(Integer.parseInt(ligne[4]), Integer.parseInt(ligne[0]),
							Integer.parseInt(ligne[2]), ligne[1].charAt(0), ligne[3].charAt(0)));
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			}
		}
	}

	public ArrayList<Domino> getDeck() {
		return this.deck;
	}

}