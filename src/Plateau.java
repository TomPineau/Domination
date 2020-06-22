import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Plateau {
	int size;
	Case[][] plate;
	int borders[];
	// borders[0] = lignemin;
	// borders[1] = lignemax;
	// borders[2] = colonnemin;
	// borders[3] = colonnemax;

	public int getsize() {
		return this.size;
	}

	public void setsize(int size) {
		size = this.getsize();
		plate = this.getplate();
		Case plate[][] = new Case[size][size];
		for (int ligne = 0; ligne < size; ligne++) {
			for (int colonne = 0; colonne < size; colonne++) {
				Case tile = new Case(ligne, colonne, 0, '#');
				plate[ligne][colonne] = tile;
			}
		}
		Case castle = new Case(size / 2, size / 2, 0, 'C');
		this.setcase(castle);
	}

	public Case[][] getplate() {
		return this.plate;
	}

	public void setplate(Case[][] tableauDeCases) {
		this.plate = tableauDeCases;
	}

	public void setcase(Case tile) {
		plate = this.getplate();
		int x = tile.getx();
		int y = tile.gety();
		plate[x][y] = tile;
		this.setplate(plate);
		this.borders = this.contours();
	}

	public Plateau(int size) {
		this.size = size;
		this.plate = new Case[size][size];
		for (int ligne = 0; ligne < size; ligne++) {
			for (int colonne = 0; colonne < size; colonne++) {
				Case tile = new Case(ligne, colonne, 0, '#');
				plate[ligne][colonne] = tile;
			}
		}
		Case castle = new Case(size / 2, size / 2, 0, 'C');
		this.setcase(castle);
		this.borders = this.contours();
	}

	public void print() {
		size = this.getsize();
		plate = this.getplate();
		for (int ligne = 0; ligne < size + 1; ligne++) {
			for (int colonne = 0; colonne < size + 1; colonne++) {
				if (ligne == 0 && colonne == 0) {
					System.out.print("  ");
				} else if (ligne == 0 && colonne < size) {
					if (colonne - 1 >= 10) {
						System.out.print((colonne - 1) + "  ");
					} else {
						System.out.print((colonne - 1) + "   ");
					}
				} else if (ligne == 0 && colonne == size) {
					System.out.print((colonne - 1) + "\n");
				} else if (colonne == 0) {
					if (ligne - 1 >= 10) {
						System.out.print(ligne - 1);
					} else {
						System.out.print(ligne - 1 + " ");
					}
				} else {
					Case tile = plate[ligne - 1][colonne - 1];
					if (colonne == size) {
						if (tile.getcrown() > 0) {
							System.out.print(tile.getcrown());
						}
						System.out.print(tile.gettile() + "\n");
					} else {
						if (tile.getcrown() > 0) {
							System.out.print(tile.getcrown());
							System.out.print(tile.gettile() + "  ");
						} else {
							System.out.print(tile.gettile() + "   ");
						}
					}
				}
			}
		}
	}

	public void viewplayable(Domino tuile, int pos) {
		size = this.getsize();
		char play[][] = new char[size][size];
		char ident = 'e';
		int[] borders = this.borders;
		if (pos == 1) {
			ident = tuile.gettile1();
		}
		if (pos == 2) {
			ident = tuile.gettile2();
		}
		int ligne = 0;
		System.out.println(' ');
		for (int colonne = 0; colonne < size; colonne++) {
			boolean notprint = true;
			if (plate[ligne][colonne].gettile() == '#') {
				notprint = true;
				while (notprint) {
					if (ligne - (size / 2 + 1) >= borders[0] || ligne + (size / 2 + 1) <= borders[1]
							|| colonne - (size / 2 + 1) >= borders[2] || colonne + (size / 2 + 1) <= borders[3]) {
						System.out.print(this.plate[0][0].gettile());
						System.out.print(' ');
						break;
					}
					if (colonne > 0 && (plate[ligne][colonne - 1].gettile() == ident
							|| (plate[ligne][colonne - 1].gettile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					}
					if (colonne < size - 1 && (plate[ligne][colonne + 1].gettile() == ident
							|| (plate[ligne][colonne + 1].gettile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					}
					if (ligne < size - 1 && (plate[ligne + 1][colonne].gettile() == ident
							|| (plate[ligne + 1][colonne].gettile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					}
					if (ligne > 0 && ((plate[ligne - 1][colonne].gettile() == ident)
							|| (plate[ligne - 1][colonne].gettile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					} else {
						System.out.print('X');
						System.out.print(' ');
						break;
					}
				}
			} else {
				System.out.print('X');
				System.out.print(' ');
			}
			if (colonne == size - 1 && ligne < size) {
				ligne = ligne + 1;
				colonne = -1;
				if (ligne == size) {
					break;
				}
				System.out.println(' ');
			}
		}
	}

	public char[][] playable(Domino tuile, int pos) {
		size = this.getsize();
		char play[][] = new char[size][size];
		char ident = 'e';
		int[] borders = this.borders;
		if (pos == 1) {
			ident = tuile.gettile1();
		}
		if (pos == 2) {
			ident = tuile.gettile2();
		}
		int ligne = 0;
		System.out.println(' ');
		for (int colonne = 0; colonne < size; colonne++) {
			boolean notread = true;
			if (plate[colonne][ligne].gettile() == '#') {
				notread = true;
				while (notread) {
					if (ligne - (size / 2 + 1) >= borders[0] || ligne + (size / 2 + 1) <= borders[1]
							|| colonne - (size / 2 + 1) >= borders[2] || colonne + (size / 2 + 1) <= borders[3]) {
						play[ligne][colonne] = 'X';
						break;
					}
					if (colonne > 0 && (plate[ligne][colonne - 1].gettile() == ident
							|| plate[ligne][colonne - 1].gettile() == 'C')) {
						play[ligne][colonne] = 'O';
						break;
					}
					if (colonne < size - 1 && (plate[ligne][colonne + 1].gettile() == ident
							|| plate[ligne][colonne + 1].gettile() == 'C')) {
						play[ligne][colonne] = 'O';
						break;
					}
					if (ligne < size - 1 && (plate[ligne + 1][colonne].gettile() == ident
							|| plate[ligne + 1][colonne].gettile() == 'C')) {
						play[ligne][colonne] = 'O';
						break;
					}
					if (ligne > 0 && ((plate[ligne - 1][colonne].gettile() == ident)
							|| plate[ligne - 1][colonne].gettile() == 'C')) {
						play[ligne][colonne] = 'O';
						break;
					} else {
						play[ligne][colonne] = 'X';
						break;
					}
				}
			} else {
				play[ligne][colonne] = 'X';
			}
			if (colonne == size - 1 && ligne < size) {
				ligne = ligne + 1;
				colonne = -1;
				if (ligne == size) {
					break;
				}
			}
		}
		return play;
	}

	public boolean canPlay(Domino tile) {
		ArrayList<Integer[]> listeDomaine = this.listeDomaine();
		for (int i = 0; i < listeDomaine.size(); i++) {
			ArrayList<Integer[]> listeCadre = cadre(listeDomaine.get(i)[0], listeDomaine.get(i)[1]);
			for (int j = 0; j < listeCadre.size(); j++) {
				ArrayList<Integer[]> nextToCase = nextToCase(listeCadre.get(j)[0], listeCadre.get(j)[1]);
				ArrayList<Integer[]> supprNextToCase = supprNextToCase(listeDomaine.get(i)[0], listeDomaine.get(i)[1],
						nextToCase);
				if (supprNextToCase.size() > 0) {
					for (int elt = 0; elt < supprNextToCase.size(); elt++) {
						if (this.jouable(tile, listeCadre.get(j)[0], listeCadre.get(j)[1], supprNextToCase.get(elt)[0],
								supprNextToCase.get(elt)[1])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean jouable(Domino tile, int x1, int y1, int x2, int y2) {
		plate = this.getplate();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1)
				|| (y2 < 0 || y2 > size - 1)) {
			return false;
		}
		if (!collés(x1, y1, x2, y2)) {
			return false;
		}
		if (plate[x1][y1].gettile() != '#' || plate[x2][y2].gettile() != '#') {
			return false;
		}
		if (!possible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean printJouable(Domino tile, int x1, int y1, int x2, int y2) {
		plate = this.getplate();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1)
				|| (y2 < 0 || y2 > size - 1)) {
			System.out.println("Les coordonnées entrées dépassent du terrain de jeu autorisé!");
			return false;
		}
		if (x1 == x2 && y1 == y2) {
			System.out.println("Vous ne pouvez pas jouer sur une seule case!!");
			return false;
		}
		if (!collés(x1, y1, x2, y2)) {
			System.out.println("Les coordonnées entrées correspondent à des cases non collées!");
			return false;
		}
		if (plate[x1][y1].gettile() != '#' || plate[x2][y2].gettile() != '#') {
			System.out.println("Les coordonnées entrées correspondent à des cases déjà prises!");
			return false;
		}
		if (!printPossible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean graphicJouable(Domino tile, int x1, int y1, int x2, int y2) {
		plate = this.getplate();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1)
				|| (y2 < 0 || y2 > size - 1)) {
			JOptionPane.showMessageDialog(null, "Les coordonnées entrées dépassent du terrain de jeu autorisé!",
					"Erreur", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (x1 == x2 && y1 == y2) {
			JOptionPane.showMessageDialog(null, "Vous ne pouvez pas jouer sur une seule case!", "Erreur",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (!collés(x1, y1, x2, y2)) {
			JOptionPane.showMessageDialog(null, "Les coordonnées entrées correspondent à des cases non collées!",
					"Erreur", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (plate[x1][y1].gettile() != '#' || plate[x2][y2].gettile() != '#') {
			JOptionPane.showMessageDialog(null, "Les coordonnées entrées correspondent à des cases déjà prises!",
					"Erreur", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (!graphicPossible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean possible(Domino tile, int x1, int y1, int x2, int y2) {
		tile.inserttuile(this, x1, y1, x2, y2);
		ArrayList<Integer[]> listeDomaine = this.listeDomaine();
		if (listeDomaine.size() == 0) {
			Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
			tuileEmpty.inserttuile(this, x1, y1, x2, y2);
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
			tuileEmpty.inserttuile(this, x1, y1, x2, y2);
			return false;
		}
		Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
		tuileEmpty.inserttuile(this, x1, y1, x2, y2);
		return true;
	}

	public boolean printPossible(Domino tile, int x1, int y1, int x2, int y2) {
		tile.inserttuile(this, x1, y1, x2, y2);
		ArrayList<Integer[]> listeDomaine = this.listeDomaine();
		if (listeDomaine.size() == 0) {
			Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
			tuileEmpty.inserttuile(this, x1, y1, x2, y2);
			System.out.println("Les coordonnées entrées dépassent du cadre autorisé!");
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
			tuileEmpty.inserttuile(this, x1, y1, x2, y2);
			System.out.println("Les cases adjacentes n'ont pas de cases de même nature!");
			return false;
		}
		Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
		tuileEmpty.inserttuile(this, x1, y1, x2, y2);
		return true;
	}

	public boolean graphicPossible(Domino tile, int x1, int y1, int x2, int y2) {
		tile.inserttuile(this, x1, y1, x2, y2);
		ArrayList<Integer[]> listeDomaine = this.listeDomaine();
		if (listeDomaine.size() == 0) {
			Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
			tuileEmpty.inserttuile(this, x1, y1, x2, y2);
			JOptionPane.showMessageDialog(null, "Les coordonnées entrées dépassent du cadre autorisé!", "Erreur",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
			tuileEmpty.inserttuile(this, x1, y1, x2, y2);
			JOptionPane.showMessageDialog(null, "Les cases adjacentes n'ont pas de cases de même nature!", "Erreur",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		Domino tuileEmpty = new Domino(tile.getnumber(), 0, 0, '#', '#');
		tuileEmpty.inserttuile(this, x1, y1, x2, y2);
		return true;
	}

	public ArrayList<Integer[]> supprNextToCase(Integer x, Integer y, ArrayList<Integer[]> nextToCase) {
		ArrayList<Integer[]> cadre = cadre(x, y);
		for (int i = 0; i < nextToCase.size(); i++) {
			Integer[] pos = { nextToCase.get(i)[0], nextToCase.get(i)[1] };
			if (!In(cadre, pos)) {
				nextToCase.remove(i);
			}
		}
		return nextToCase;
	}

	public ArrayList<Integer[]> deleteNextTo(ArrayList<Integer[]> nextTo, int x, int y) {
		for (int i = 0; i < nextTo.size(); i++) {
			if (x == nextTo.get(i)[0] && y == nextTo.get(i)[1]) {
				nextTo.remove(i);
			}
		}
		return nextTo;
	}

	public boolean collés(int x1, int y1, int x2, int y2) {
		if (x1 == x2) {
			if (y1 == y2 - 1 || y1 == y2 + 1) {
				return true;
			}
		} else if (y1 == y2) {
			if (x1 == x2 - 1 || x1 == x2 + 1) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer[]> nextToCase(int ligne, int colonne) {
		ArrayList<Integer[]> liste = new ArrayList<Integer[]>();
		plate = this.getplate();
		size = this.getsize();
		if (ligne - 1 >= 0) {
			Integer[] pos = { ligne - 1, colonne };
			liste.add(pos);
		}
		if (colonne + 1 <= size - 1) {
			Integer[] pos = { ligne, colonne + 1 };
			liste.add(pos);
		}
		if (ligne + 1 <= size - 1) {
			Integer[] pos = { ligne + 1, colonne };
			liste.add(pos);
		}
		if (colonne - 1 >= 0) {
			Integer[] pos = { ligne, colonne - 1 };
			liste.add(pos);
		}
		return liste;
	}

	public int[] contours() {
		int[] extreme = new int[4];
		plate = this.getplate();
		size = this.getsize();
		int lignemax = size / 2;
		int colonnemax = size / 2;
		int lignemin = size / 2;
		int colonnemin = size / 2;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((plate[i][j].gettile() != '#') && (lignemin >= i)) {
					lignemin = i;
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (plate[i][j].gettile() != '#' && colonnemin >= j) {
					colonnemin = j;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (plate[i][j].gettile() != '#' && lignemax <= i) {
					lignemax = i;
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (plate[i][j].gettile() != '#' && colonnemax <= j) {
					colonnemax = j;
				}
			}
		}
		extreme[0] = lignemin;
		extreme[1] = lignemax;
		extreme[2] = colonnemin;
		extreme[3] = colonnemax;
		return extreme;
	}

	public int score() {
		Plateau board = this;
		plate = board.getplate();
		int longueur = board.getsize();
		int score = 0;
		for (int ligne = 0; ligne < longueur; ligne++) {
			for (int colonne = 0; colonne < longueur; colonne++) {
				if (plate[ligne][colonne].gettile() != '#') {
					int nbCouronnes = 0;
					int nbCases = 0;
					ArrayList<Integer[]> pack = board.paquet(ligne, colonne);
					for (int compteur = 0; compteur < pack.size(); compteur++) {
						nbCases += 1;
						nbCouronnes += plate[pack.get(compteur)[0]][pack.get(compteur)[1]].getcrown();
						Case tile = new Case(pack.get(compteur)[0], pack.get(compteur)[1],
								plate[pack.get(compteur)[0]][pack.get(compteur)[1]].getcrown(), '#');
						board.setcase(tile);
					}
					score += nbCases * nbCouronnes;
				}
			}
		}
		return score;
	}

	public Plateau copy() {
		plate = this.getplate();
		size = this.getsize();
		Plateau terrain = new Plateau(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				terrain.setcase(plate[i][j]);
			}
		}
		return terrain;
	}

	public ArrayList<Integer[]> nextToCastle(int ligne, int colonne) {
		ArrayList<Integer[]> liste = new ArrayList<Integer[]>();
		plate = this.getplate();
		size = this.getsize();
		if ((ligne - 1 >= 0) && (plate[ligne][colonne].gettile() == plate[ligne - 1][colonne].gettile()
				|| plate[ligne - 1][colonne].gettile() == 'C')) {
			Integer[] pos = { ligne - 1, colonne };
			liste.add(pos);
		}
		if ((colonne + 1 <= size - 1) && (plate[ligne][colonne].gettile() == plate[ligne][colonne + 1].gettile()
				|| plate[ligne][colonne + 1].gettile() == 'C')) {
			Integer[] pos = { ligne, colonne + 1 };
			liste.add(pos);
		}
		if ((ligne + 1 <= size - 1) && (plate[ligne][colonne].gettile() == plate[ligne + 1][colonne].gettile()
				|| plate[ligne + 1][colonne].gettile() == 'C')) {
			Integer[] pos = { ligne + 1, colonne };
			liste.add(pos);
		}
		if ((colonne - 1 >= 0) && (plate[ligne][colonne].gettile() == plate[ligne][colonne - 1].gettile()
				|| plate[ligne][colonne - 1].gettile() == 'C')) {
			Integer[] pos = { ligne, colonne - 1 };
			liste.add(pos);
		}
		return liste;
	}

	public ArrayList<Integer[]> nextTo(int ligne, int colonne) {
		ArrayList<Integer[]> liste = new ArrayList<Integer[]>();
		plate = this.getplate();
		size = this.getsize();
		if ((ligne - 1 >= 0) && (plate[ligne][colonne].gettile() == plate[ligne - 1][colonne].gettile())) {
			Integer[] pos = { ligne - 1, colonne };
			liste.add(pos);
		}
		if ((colonne + 1 <= size - 1) && (plate[ligne][colonne].gettile() == plate[ligne][colonne + 1].gettile())) {
			Integer[] pos = { ligne, colonne + 1 };
			liste.add(pos);
		}
		if ((ligne + 1 <= size - 1) && (plate[ligne][colonne].gettile() == plate[ligne + 1][colonne].gettile())) {
			Integer[] pos = { ligne + 1, colonne };
			liste.add(pos);
		}
		if ((colonne - 1 >= 0) && (plate[ligne][colonne].gettile() == plate[ligne][colonne - 1].gettile())) {
			Integer[] pos = { ligne, colonne - 1 };
			liste.add(pos);
		}
		return liste;
	}

	public ArrayList<Integer[]> paquet(int ligne, int colonne) {
		ArrayList<Integer[]> liste = new ArrayList<Integer[]>();
		Integer[] pos = { ligne, colonne };
		liste.add(pos);
		int nbCases = 0;
		while (nbCases != liste.size()) {
			ArrayList<Integer[]> next = this.nextTo(liste.get(nbCases)[0], liste.get(nbCases)[1]);
			for (int compteur = 0; compteur < next.size(); compteur++) {
				if (!(In(liste, next.get(compteur)))) {
					liste.add(next.get(compteur));
				}
			}
			nbCases += 1;
		}
		return liste;
	}

	public boolean In(ArrayList<Integer[]> liste, Integer[] pos) {
		for (int compteur = 0; compteur < liste.size(); compteur++) {
			if ((liste.get(compteur)[0] == pos[0]) && (liste.get(compteur)[1] == pos[1])) {
				return true;
			}
		}
		return false;
	}

	public int domaineMax() {
		plate = this.getplate();
		size = this.getsize();
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int ligne = 0; ligne < size; ligne++) {
			for (int colonne = 0; colonne < size; colonne++) {
				if (plate[ligne][colonne].gettile() != '#') {
					ArrayList<Integer[]> listePaquet = paquet(ligne, colonne);
					liste.add(listePaquet.size());
					for (int compteur = 0; compteur < listePaquet.size(); compteur++) {
						plate[listePaquet.get(compteur)[0]][listePaquet.get(compteur)[1]].settile('#');
					}
				}
			}
		}
		return max(liste);
	}

	public int max(ArrayList<Integer> liste) {
		int max = liste.get(0);
		for (int compteur = 0; compteur < liste.size(); compteur++) {
			if (liste.get(compteur) > max) {
				max = liste.get(compteur);
			}
		}
		return max;
	}

	public int nbCouronnes() {
		plate = this.getplate();
		size = this.getsize();
		int nbCouronnes = 0;
		for (int ligne = 0; ligne < size; ligne++) {
			for (int colonne = 0; colonne < size; colonne++) {
				nbCouronnes += plate[ligne][colonne].getcrown();
			}
		}
		return nbCouronnes;
	}

	public int scoreHarmonie() {
		int harmonie = 0;
		if (this.complet()) {
			harmonie = 5;
		}
		return this.copy().score() + harmonie;
	}

	public boolean complet() {
		plate = this.getplate();
		size = this.getsize();
		this.borders = this.contours();
		int lignemin = this.borders[0];
		int lignemax = this.borders[1];
		int colonnemin = this.borders[2];
		int colonnemax = this.borders[3];
		if (lignemax - lignemin < (size - 1) / 2) {
			return false;
		}
		if (colonnemax - colonnemin < (size - 1) / 2) {
			return false;
		} else {
			for (int pointerX = lignemin; pointerX <= lignemax; pointerX++) {
				for (int pointerY = colonnemin; pointerY <= colonnemax; pointerY++) {
					if (plate[pointerX][pointerY].gettile() == '#') {
						return false;

					}
				}
			}
		}
		return true;
	}

	public int scoreMilieu() {
		int milieu = 0;
		if (this.estAuMilieu()) {
			milieu = 10;
		}
		return this.copy().score() + milieu;
	}

	public boolean estAuMilieu() {
		plate = this.getplate();
		size = this.getsize();
		ArrayList<Integer[]> listeDomaine = this.listeDomaine();
		for (int compteur = 0; compteur < listeDomaine.size(); compteur++) {
			if (plate[listeDomaine.get(compteur)[0] + (size - 1) / 4][listeDomaine.get(compteur)[1] + (size - 1) / 4]
					.gettile() == 'C') {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer[]> listeDomaine() {
		plate = this.getplate();
		size = this.getsize();
		ArrayList<Integer[]> listeDomaine = new ArrayList<Integer[]>();
		ArrayList<Integer[]> listePos = this.listePosition();
		for (int ligne = 0; ligne < (size / 2 + 1); ligne++) {
			for (int colonne = 0; colonne < (size / 2 + 1); colonne++) {
				if (allIn(ligne, colonne, listePos)) {
					Integer[] pos = { ligne, colonne };
					listeDomaine.add(pos);
				}
			}
		}
		return listeDomaine;
	}

	public ArrayList<Integer[]> listePosition() {
		plate = this.getplate();
		size = this.getsize();
		ArrayList<Integer[]> liste = new ArrayList<Integer[]>();
		for (int ligne = 0; ligne < size; ligne++) {
			for (int colonne = 0; colonne < size; colonne++) {
				if (plate[ligne][colonne].gettile() != '#') {
					Integer[] pos = { ligne, colonne };
					liste.add(pos);
				}
			}
		}
		return liste;
	}

	public boolean allIn(int ligne, int colonne, ArrayList<Integer[]> listePos) {
		plate = this.getplate();
		size = this.getsize();
		ArrayList<Integer[]> listeCadre = this.cadre(ligne, colonne);
		for (int compteur = 0; compteur < listePos.size(); compteur++) {
			if (!(In(listeCadre, listePos.get(compteur)))) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer[]> cadre(Integer borderLigne, Integer borderColonne) {
		plate = this.getplate();
		size = this.getsize();
		ArrayList<Integer[]> liste = new ArrayList<Integer[]>();
		for (int ligne = borderLigne; ligne < borderLigne + (size + 1) / 2; ligne++) {
			for (int colonne = borderColonne; colonne < borderColonne + (size + 1) / 2; colonne++) {
				Integer[] pos = { ligne, colonne };
				liste.add(pos);
			}
		}
		return liste;
	}

	/*
	 * public ArrayList<Tuile> choiceDomino(ArrayList<Tuile> pioche,
	 * ArrayList<Tuile> selection) { ArrayList<Tuile> bestDominos = new
	 * ArrayList<Tuile>(); ArrayList<Coeff> listeCoeffs =
	 * MainConsole.triListeCoeffs(MainConsole.evaluationPioche(pioche));
	 * bestDominos.add(selection.get(0)); for (int i = 1; i < selection.size(); i++)
	 * { int sommeCoeffs = selection.get(i).sommeCoeffs(listeCoeffs); if
	 * (sommeCoeffs > bestDominos.get(0).sommeCoeffs(listeCoeffs)) {
	 * bestDominos.remove(0); bestDominos.add(selection.get(i)); } } return
	 * bestDominos; }
	 */

	public ArrayList<Integer[]> listMovePlayable(Domino domino) {
		ArrayList<Integer[]> listMovePlayable = new ArrayList<Integer[]>();
		ArrayList<Integer[]> listeDomaine = listeDomaine();
		for (int i = 0; i < listeDomaine.size(); i++) {
			ArrayList<Integer[]> listeCadre = cadre(listeDomaine.get(i)[0], listeDomaine.get(i)[1]);
			for (int j = 0; j < listeCadre.size(); j++) {
				ArrayList<Integer[]> nextToCase = nextToCase(listeCadre.get(j)[0], listeCadre.get(j)[1]);
				ArrayList<Integer[]> supprNextToCase = supprNextToCase(listeDomaine.get(i)[0], listeDomaine.get(i)[1],
						nextToCase);
				if (supprNextToCase.size() > 0) {
					for (int elt = 0; elt < supprNextToCase.size(); elt++) {
						if (jouable(domino, listeCadre.get(j)[0], listeCadre.get(j)[1], supprNextToCase.get(elt)[0],
								supprNextToCase.get(elt)[1])) {
							Integer[] position = { listeCadre.get(j)[0], listeCadre.get(j)[1],
									supprNextToCase.get(elt)[0], supprNextToCase.get(elt)[1] };
							if (MainConsole.notIn(position, listMovePlayable)) {
								listMovePlayable.add(position);
							}
						}
					}
				}
			}
		}
		return listMovePlayable;
	}

	public ArrayList<Domino> listDominoPlayable(ArrayList<Domino> selection) {
		ArrayList<Domino> listDominoPlayable = new ArrayList<Domino>();
		for (int i = 0; i < selection.size(); i++) {
			if (!MainConsole.emptyTuile(selection.get(i))) {
				if (canPlay(selection.get(i))) {
					listDominoPlayable.add(selection.get(i));
				}
			}
		}
		return listDominoPlayable;
	}

	/*
	 * public Integer[] choiceMove(ArrayList<Tuile> pioche, ArrayList<Tuile>
	 * selection) { Integer[] position = new Integer[4]; Tuile domino =
	 * choiceDomino(pioche, selection).get(0); ArrayList<Integer[]> listMovePlayable
	 * = listMovePlayable(domino); domino.inserttuile(this,
	 * listMovePlayable.get(0)[0], listMovePlayable.get(0)[1],
	 * listMovePlayable.get(0)[2], listMovePlayable.get(0)[3]); int score =
	 * this.copy().score(); int domaineMax = this.domaineMax(); Integer[] pos = {
	 * listMovePlayable.get(0)[0], listMovePlayable.get(0)[1],
	 * listMovePlayable.get(0)[2], listMovePlayable.get(0)[3] }; position = pos;
	 * Tuile emptyTile = new Tuile(0, 0, 0, '#', '#'); emptyTile.inserttuile(this,
	 * listMovePlayable.get(0)[0], listMovePlayable.get(0)[1],
	 * listMovePlayable.get(0)[2], listMovePlayable.get(0)[3]); for (int i = 1; i <
	 * listMovePlayable.size(); i++) { Integer[] newPos = listMovePlayable.get(i);
	 * domino.inserttuile(this, newPos[0], newPos[1], newPos[2], newPos[3]); int
	 * newScore = this.copy().score(); int newDomaineMax = this.domaineMax(); if
	 * (newScore == score) { if (newDomaineMax > domaineMax) { position = newPos; }
	 * } else if (newScore > score) { position = newPos; }
	 * emptyTile.inserttuile(this, newPos[0], newPos[1], newPos[2], newPos[3]); }
	 * return position; }
	 */

	public ArrayList<Domino> listeDominosJouables(ArrayList<Domino> selection) {
		ArrayList<Domino> listeDominosJouables = new ArrayList<Domino>();
		ArrayList<Domino> newSelection = MainConsole.newSelection(selection);
		for (int i = 0; i < newSelection.size(); i++) {
			if (this.canPlay(newSelection.get(i))) {
				listeDominosJouables.add(newSelection.get(i));
			}
		}
		return listeDominosJouables;
	}

}