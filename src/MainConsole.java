import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainConsole {

	static ArrayList<Domino> liste = new Data().getDeck();

	public static void main(String[] args) {
		KingDomination();
		/*
		 * ArrayList<Tuile> pioche = tirage(liste, 24); ArrayList<Tuile> selection =
		 * tirage(pioche, 4); Tuile emptyTile = new Tuile(0,0,0,'#','#');
		 * selection.set(1, emptyTile); afficheTuile(triTuile(selection));
		 * System.out.println("\nchoix = " + choiceDomino(pioche,selection));
		 */
		/*
		 * ArrayList<Integer> listeCoeffs = new ArrayList<Integer>();
		 * listeCoeffs.add(-1); listeCoeffs.add(2); listeCoeffs.add(9);
		 * listeCoeffs.add(-1); listeCoeffs.add(1); listeCoeffs.add(2);
		 * listeCoeffs.add(-1); listeCoeffs.add(17); listeCoeffs.add(20);
		 * listeCoeffs.add(-1); listeCoeffs.add(13);
		 * afficheListeCoeffs(triCoeffs(listeCoeffs));
		 * System.out.println(estTrieeCoeffs(triCoeffs(listeCoeffs)));
		 * System.out.println(lastCoeff(triCoeffs(listeCoeffs)));
		 */
		/*
		 * Board board = new Board(9); Tuile domino = new Tuile(10, 1, 2, 'W', 'F');
		 * 
		 * ArrayList<Integer[]> listMovePlayable = board.listMovePlayable(domino);
		 * board.print(); printMovePlayable(listMovePlayable);
		 */
	}

	public static void KingDomination() {
		Scanner scan = new Scanner(System.in);
		boolean nbValide = true;
		System.out.println("Bienvenue dans le jeu King Domination !" + "\n");
		do {
			try {
				System.out.println("Choisissez le nombre de joueurs :\n" + "1 joueur\n" + "2 joueurs\n" + "3 joueurs\n"
						+ "4 joueurs\n");
				int nbJoueurs = scan.nextInt();
				if (nbJoueurs == 1) {
					boolean nbValide1Players = true;
					do {
						try {
							System.out.println("Choisissez votre mode de jeu :\n" + "1. Classique\n" + "2. Dynastie\n"
									+ "3. Empire du milieu\n" + "4. Harmonie\n" + "5. Le Grand Duel\n");
							int modeDeJeu = scan.nextInt();
							if (modeDeJeu == 1) {
								onePlayer("Classique");
								nbValide1Players = false;
							} else if (modeDeJeu == 2) {
								onePlayer("Dynastie");
								nbValide1Players = false;
							} else if (modeDeJeu == 3) {
								onePlayer("Empire du milieu");
								nbValide1Players = false;
							} else if (modeDeJeu == 4) {
								onePlayer("Harmonie");
								nbValide1Players = false;
							} else if (modeDeJeu == 5) {
								onePlayer("Le Grand Duel");
								nbValide1Players = false;
							} else {
								System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :" + "\n");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :" + "\n");
							scan.nextLine();
						}
					} while (nbValide1Players);
					nbValide = false;
				} else if (nbJoueurs == 2) {
					boolean nbValide2Players = true;
					do {
						try {
							System.out.println("Choisissez votre mode de jeu :\n" + "1. Classique\n" + "2. Dynastie\n"
									+ "3. Empire du milieu\n" + "4. Harmonie\n" + "5. Le Grand Duel\n");
							int modeDeJeu = scan.nextInt();
							if (modeDeJeu == 1) {
								twoPlayersb("Classique");
								nbValide2Players = false;
							} else if (modeDeJeu == 2) {
								twoPlayers("Dynastie");
								nbValide2Players = false;
							} else if (modeDeJeu == 3) {
								twoPlayers("Empire du milieu");
								nbValide2Players = false;
							} else if (modeDeJeu == 4) {
								twoPlayers("Harmonie");
								nbValide2Players = false;
							} else if (modeDeJeu == 5) {
								twoPlayers("Le Grand Duel");
								nbValide2Players = false;
							} else {
								System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :" + "\n");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :" + "\n");
							scan.nextLine();
						}
					} while (nbValide2Players);
					nbValide = false;
				} else if (nbJoueurs == 3) {
					boolean nbValide3Players = true;
					do {
						try {
							System.out.println("Choisissez votre mode de jeu :\n" + "1. Classique\n" + "2. Dynastie\n"
									+ "3. Empire du milieu\n" + "4. Harmonie\n");
							int modeDeJeu = scan.nextInt();
							if (modeDeJeu == 1) {
								threePlayers("Classique");
								nbValide3Players = false;
							} else if (modeDeJeu == 2) {
								threePlayers("Dynastie");
								nbValide3Players = false;
							} else if (modeDeJeu == 3) {
								threePlayers("Empire du milieu");
								nbValide3Players = false;
							} else if (modeDeJeu == 4) {
								threePlayers("Harmonie");
								nbValide3Players = false;
							} else {
								System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :" + "\n");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :" + "\n");
							scan.nextLine();
						}
					} while (nbValide3Players);
					nbValide = false;
				} else if (nbJoueurs == 4) {
					boolean nbValide4Players = true;
					do {
						try {
							System.out.println("Choisissez votre mode de jeu :\n" + "1. Classique\n" + "2. Dynastie\n"
									+ "3. Empire du milieu\n" + "4. Harmonie\n");
							int modeDeJeu = scan.nextInt();
							if (modeDeJeu == 1) {
								fourPlayers("Classique");
								nbValide4Players = false;
							} else if (modeDeJeu == 2) {
								fourPlayers("Dynastie");
								nbValide4Players = false;
							} else if (modeDeJeu == 3) {
								fourPlayers("Empire du milieu");
								nbValide4Players = false;
							} else if (modeDeJeu == 4) {
								fourPlayers("Harmonie");
								nbValide4Players = false;
							} else {
								System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :" + "\n");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :" + "\n");
							scan.nextLine();
						}
					} while (nbValide4Players);
					nbValide = false;
				} else {
					System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :" + "\n");
					scan.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :" + "\n");
				scan.nextLine();
			}
		} while (nbValide);
		scan.close();
	}
	
	public static void twoPlayersb(String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 24;
		if (modeDeJeu == "Dynastie") {
			nbParties = 3;
		}
		if (modeDeJeu == "Le Grand Duel") {
			boardSize = 13;
			nbDominos = 48;
		}
		System.out.println("Bienvenue dans le mode " + modeDeJeu + " pour 2 joueurs !\n" + "\n"
				+ "Joueur 1, entre ton pseudo : \n");
		String namePlayer1 = scan.next();
		System.out.println("Bonjour " + namePlayer1 + "! Bonne chance!\n" + "Joueur 2, entre ton pseudo : \n");
		String namePlayer2 = scan.next();
		System.out.println("Bonjour " + namePlayer2 + "! Bonne chance!\n");
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer1 = new Plateau(boardSize);
		Plateau boardPlayer2 = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player1 = new Player(namePlayer1, boardPlayer1);
		Player player2 = new Player(namePlayer2, boardPlayer2);
		ArrayList<Player> debut2Joueurs = debut2Players(player1, player2);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu == "Dynastie") {
				System.out.println("Début de la partie " + (ruler + 1) + " :\n");
			} else {
				System.out.println("Début de la partie :\n");
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut2Players(player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				System.out.println("Tour " + nbTour + "\nLes joueurs commenceront dans cet ordre :\n"
						+ debut2Joueurs.get(0).getname() + ", " + debut2Joueurs.get(1).getname() + ", "
						+ debut2Joueurs.get(2).getname() + ", " + debut2Joueurs.get(3).getname());
				for (int i = 0; i < 3; i++) {
					boolean nbValide = true;
					do {
						try {
							System.out.println("\n" + debut2Joueurs.get(i).getname()
									+ " c'est à ton tour. Voici ton terrain : \n");
							debut2Joueurs.get(i).getboard().print();
							System.out.println("\nVoici la liste des tuiles :\n");
							afficheTuile(triTuile(listeTuiles));
							System.out.println("Sélectionne la tuile de ton choix :");
							int choixTuile = scan.nextInt();
							if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut2Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut2Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut2Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut2Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut2Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut2Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut2Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut2Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
								}
							} else {
								System.out.println("Cette tuile ne peut être prise ! Veuillez réessayer :");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :");
							scan.nextLine();
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :");
							scan.nextLine();
						}
					} while (nbValide);
				}
				System.out.println(
						"\n" + debut2Joueurs.get(3).getname() + ", c'est à ton tour. Voici la dernière tuile :\n");
				afficheTuile(triTuile(listeTuiles));
				if (debut2Joueurs.get(3).getboard().canPlay(listeTuiles.get(lastTile - 1))) {
					play(debut2Joueurs.get(3), listeTuiles.get(lastTile - 1), modeDeJeu);
					System.out.println("\n" + debut2Joueurs.get(3).getname() + " tu possèdes maintenant un score de "
							+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
				} else {
					System.out.println(
							"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
									+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
				}
				debut2Joueurs = tourSuivant;
				nbTour += 1;
			}
			int newScore1 = player1.getboard().copy().score();
			int newScore2 = player2.getboard().copy().score();
			int domaineMax1 = player1.getboard().domaineMax();
			int domaineMax2 = player2.getboard().domaineMax();
			int nbCouronnes1 = player1.getboard().nbCouronnes();
			int nbCouronnes2 = player2.getboard().nbCouronnes();
			scoresPlayer1[0] += newScore1;
			scoresPlayer2[0] += newScore2;
			scoresPlayer1[1] += domaineMax1;
			scoresPlayer2[1] += domaineMax2;
			scoresPlayer1[2] += nbCouronnes1;
			scoresPlayer2[2] += nbCouronnes2;
			if (modeDeJeu == "Dynastie") {
				System.out.println("Fin de la partie " + (ruler + 1) + "!");
				Plateau emptyBoard1 = new Plateau(boardSize);
				Plateau emptyBoard2 = new Plateau(boardSize);
				player1.setboard(emptyBoard1);
				player2.setboard(emptyBoard2);
				nbTour = 1;
			}
		}
		int[] newScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
		int[] newScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
		player1.setscores(newScoresPlayer1);
		player2.setscores(newScoresPlayer2);
		if (modeDeJeu == "Harmonie") {
			if (player1.getboard().complet()) {
				scoresPlayer1[0] += 5;
			}
			if (player2.getboard().complet()) {
				scoresPlayer2[0] += 5;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			printClassement2(player1, player2);
		} else if (modeDeJeu == "Empire du milieu") {
			if (player1.getboard().estAuMilieu()) {
				scoresPlayer1[0] += 10;
			}
			if (player2.getboard().estAuMilieu()) {
				scoresPlayer2[0] += 10;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			printClassement2(player1, player2);
		} else {
			printClassement2(player1, player2);
		}
		System.out.println("\n\nFin de la partie!");
		scan.close();
	}

	public static void twoPlayers(String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 24;
		if (modeDeJeu == "Dynastie") {
			nbParties = 3;
		}
		if (modeDeJeu == "Le Grand Duel") {
			boardSize = 13;
			nbDominos = 48;
		}
		System.out.println("Bienvenue dans le mode " + modeDeJeu + " pour 2 joueurs !\n" + "\n"
				+ "Joueur 1, entre ton pseudo : \n");
		String namePlayer1 = scan.next();
		System.out.println("Bonjour " + namePlayer1 + "! Bonne chance!\n" + "Joueur 2, entre ton pseudo : \n");
		String namePlayer2 = scan.next();
		System.out.println("Bonjour " + namePlayer2 + "! Bonne chance!\n");
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer1 = new Plateau(boardSize);
		Plateau boardPlayer2 = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player1 = new Player(namePlayer1, boardPlayer1);
		Player player2 = new Player(namePlayer2, boardPlayer2);
		ArrayList<Player> debut2Joueurs = debut2Players(player1, player2);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu == "Dynastie") {
				System.out.println("Début de la partie " + (ruler + 1) + " :\n");
			} else {
				System.out.println("Début de la partie :\n");
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut2Players(player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				System.out.println("Tour " + nbTour + "\nLes joueurs commenceront dans cet ordre :\n"
						+ debut2Joueurs.get(0).getname() + ", " + debut2Joueurs.get(1).getname() + ", "
						+ debut2Joueurs.get(2).getname() + ", " + debut2Joueurs.get(3).getname());
				for (int i = 0; i < 3; i++) {
					boolean nbValide = true;
					int choixTuile;
					do {
						try {
							System.out.println("\n" + debut2Joueurs.get(i).getname()
									+ " c'est à ton tour. Voici ton terrain : \n");
							debut2Joueurs.get(i).getboard().print();
							System.out.println("\nVoici la liste des tuiles :\n");
							afficheTuile(triTuile(listeTuiles));
							System.out.println("Sélectionne la tuile de ton choix :");
							choixTuile = scan.nextInt();
							scan.nextLine();
							if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut2Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut2Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut2Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut2Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut2Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut2Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut2Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut2Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut2Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
								}
							} else {
								System.out.println("Cette tuile ne peut être prise ! Veuillez réessayer :");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :");
							scan.nextLine();
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :");
							scan.nextLine();
						}
					} while (nbValide);
				}
				System.out.println(
						"\n" + debut2Joueurs.get(3).getname() + ", c'est à ton tour. Voici la dernière tuile :\n");
				afficheTuile(triTuile(listeTuiles));
				if (debut2Joueurs.get(3).getboard().canPlay(listeTuiles.get(lastTile - 1))) {
					play(debut2Joueurs.get(3), listeTuiles.get(lastTile - 1), modeDeJeu);
					System.out.println("\n" + debut2Joueurs.get(3).getname() + " tu possèdes maintenant un score de "
							+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
				} else {
					System.out.println(
							"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
									+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
				}
				debut2Joueurs = tourSuivant;
				nbTour += 1;
			}
			int newScore1 = player1.getboard().copy().score();
			int newScore2 = player2.getboard().copy().score();
			int domaineMax1 = player1.getboard().domaineMax();
			int domaineMax2 = player2.getboard().domaineMax();
			int nbCouronnes1 = player1.getboard().nbCouronnes();
			int nbCouronnes2 = player2.getboard().nbCouronnes();
			scoresPlayer1[0] += newScore1;
			scoresPlayer2[0] += newScore2;
			scoresPlayer1[1] += domaineMax1;
			scoresPlayer2[1] += domaineMax2;
			scoresPlayer1[2] += nbCouronnes1;
			scoresPlayer2[2] += nbCouronnes2;
			if (modeDeJeu == "Dynastie") {
				System.out.println("Fin de la partie " + (ruler + 1) + "!");
				Plateau emptyBoard1 = new Plateau(boardSize);
				Plateau emptyBoard2 = new Plateau(boardSize);
				player1.setboard(emptyBoard1);
				player2.setboard(emptyBoard2);
				nbTour = 1;
			}
		}
		int[] newScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
		int[] newScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
		player1.setscores(newScoresPlayer1);
		player2.setscores(newScoresPlayer2);
		if (modeDeJeu == "Harmonie") {
			if (player1.getboard().complet()) {
				scoresPlayer1[0] += 5;
			}
			if (player2.getboard().complet()) {
				scoresPlayer2[0] += 5;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			printClassement2(player1, player2);
		} else if (modeDeJeu == "Empire du milieu") {
			if (player1.getboard().estAuMilieu()) {
				scoresPlayer1[0] += 10;
			}
			if (player2.getboard().estAuMilieu()) {
				scoresPlayer2[0] += 10;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			printClassement2(player1, player2);
		} else {
			printClassement2(player1, player2);
		}
		System.out.println("\n\nFin de la partie!");
		scan.close();
	}

	public static void threePlayers(String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 36;
		if (modeDeJeu == "Dynastie") {
			nbParties = 3;
		}
		System.out.println("Bienvenue dans le mode " + modeDeJeu + " pour 3 joueurs !\n" + "\n"
				+ "Joueur 1, entre ton pseudo : \n");
		String namePlayer1 = scan.next();
		System.out.println("Bonjour " + namePlayer1 + "! Bonne chance!\n" + "Joueur 2, entre ton pseudo : \n");
		String namePlayer2 = scan.next();
		System.out.println("Bonjour " + namePlayer2 + "! Bonne chance!\n" + "Joueur 3, entre ton pseudo : \n");
		String namePlayer3 = scan.next();
		System.out.println("Bonjour " + namePlayer3 + "! Bonne chance!\n");
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer1 = new Plateau(boardSize);
		Plateau boardPlayer2 = new Plateau(boardSize);
		Plateau boardPlayer3 = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player1 = new Player(namePlayer1, boardPlayer1);
		Player player2 = new Player(namePlayer2, boardPlayer2);
		Player player3 = new Player(namePlayer3, boardPlayer3);
		ArrayList<Player> debut3Joueurs = debut3Players(player1, player2, player3);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		int[] scoresPlayer3 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu == "Dynastie") {
				System.out.println("Début de la partie " + (ruler + 1) + " :\n");
			} else {
				System.out.println("Début de la partie :\n");
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 3);
				ArrayList<Player> tourSuivant = debut3Players(player0, player0, player0);
				int lastTile = 6;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				System.out.println("Tour " + nbTour + "\nLes joueurs commenceront dans cet ordre :\n"
						+ debut3Joueurs.get(0).getname() + ", " + debut3Joueurs.get(1).getname() + ", "
						+ debut3Joueurs.get(2).getname());
				for (int i = 0; i < 2; i++) {
					boolean nbValide = true;
					do {
						try {
							System.out.println("\n" + debut3Joueurs.get(i).getname()
									+ " c'est à ton tour. Voici ton terrain : \n");
							debut3Joueurs.get(i).getboard().print();
							System.out.println("\nVoici la liste des tuiles :\n");
							afficheTuile(triTuile(listeTuiles));
							System.out.println("Sélectionne la tuile de ton choix :");
							int choixTuile = scan.nextInt();
							if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
								if (debut3Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut3Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut3Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut3Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut3Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
								if (debut3Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut3Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut3Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut3Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut3Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
								if (debut3Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut3Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut3Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut3Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut3Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								}
							} else {
								System.out.println("Cette tuile ne peut être prise ! Veuillez réessayer :");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :");
							scan.nextLine();
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :");
							scan.nextLine();
						}
					} while (nbValide);
				}
				System.out.println(
						"\n" + debut3Joueurs.get(2).getname() + ", c'est à ton tour. Voici la dernière tuile :\n");
				afficheTuile(triTuile(listeTuiles));
				if (debut3Joueurs.get(2).getboard().canPlay(listeTuiles.get(lastTile - 1))) {
					play(debut3Joueurs.get(2), listeTuiles.get(lastTile - 1), modeDeJeu);
					System.out.println("\n" + debut3Joueurs.get(2).getname() + " tu possèdes maintenant un score de "
							+ debut3Joueurs.get(2).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut3Joueurs.get(2));
				} else {
					System.out.println(
							"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
									+ debut3Joueurs.get(2).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut3Joueurs.get(2));
				}
				debut3Joueurs = tourSuivant;
				nbTour += 1;
			}
			int newScore1 = player1.getboard().copy().score();
			int newScore2 = player2.getboard().copy().score();
			int newScore3 = player3.getboard().copy().score();
			int domaineMax1 = player1.getboard().domaineMax();
			int domaineMax2 = player2.getboard().domaineMax();
			int domaineMax3 = player3.getboard().domaineMax();
			int nbCouronnes1 = player1.getboard().nbCouronnes();
			int nbCouronnes2 = player2.getboard().nbCouronnes();
			int nbCouronnes3 = player3.getboard().nbCouronnes();
			scoresPlayer1[0] += newScore1;
			scoresPlayer2[0] += newScore2;
			scoresPlayer3[0] += newScore3;
			scoresPlayer1[1] += domaineMax1;
			scoresPlayer2[1] += domaineMax2;
			scoresPlayer3[1] += domaineMax3;
			scoresPlayer1[2] += nbCouronnes1;
			scoresPlayer2[2] += nbCouronnes2;
			scoresPlayer3[2] += nbCouronnes3;
			if (modeDeJeu == "Dynastie") {
				System.out.println("Fin de la partie " + (ruler + 1) + "!");
				Plateau emptyBoard1 = new Plateau(boardSize);
				Plateau emptyBoard2 = new Plateau(boardSize);
				Plateau emptyBoard3 = new Plateau(boardSize);
				player1.setboard(emptyBoard1);
				player2.setboard(emptyBoard2);
				player3.setboard(emptyBoard3);
				nbTour = 1;
			}
		}
		int[] newScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
		int[] newScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
		int[] newScoresPlayer3 = { scoresPlayer3[0], scoresPlayer3[1], scoresPlayer3[2] };
		player1.setscores(newScoresPlayer1);
		player2.setscores(newScoresPlayer2);
		player3.setscores(newScoresPlayer3);
		if (modeDeJeu == "Harmonie") {
			if (player1.getboard().complet()) {
				scoresPlayer1[0] += 5;
			}
			if (player2.getboard().complet()) {
				scoresPlayer2[0] += 5;
			}
			if (player3.getboard().complet()) {
				scoresPlayer3[0] += 5;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			int[] newNewScoresPlayer3 = { scoresPlayer3[0], scoresPlayer3[1], scoresPlayer3[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			player3.setscores(newNewScoresPlayer3);
			printClassement3(player1, player2, player3);
		} else if (modeDeJeu == "Empire du milieu") {
			if (player1.getboard().estAuMilieu()) {
				scoresPlayer1[0] += 10;
			}
			if (player2.getboard().estAuMilieu()) {
				scoresPlayer2[0] += 10;
			}
			if (player3.getboard().estAuMilieu()) {
				scoresPlayer3[0] += 10;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			int[] newNewScoresPlayer3 = { scoresPlayer3[0], scoresPlayer3[1], scoresPlayer3[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			player3.setscores(newNewScoresPlayer3);
			printClassement3(player1, player2, player3);
		} else {
			printClassement3(player1, player2, player3);
		}
		System.out.println("\n\nFin de la partie!");
		scan.close();
	}

	public static void fourPlayers(String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 48;
		if (modeDeJeu == "Dynastie") {
			nbParties = 3;
		}
		System.out.println("Bienvenue dans le mode " + modeDeJeu + " pour 4 joueurs !\n" + "\n"
				+ "Joueur 1, entre ton pseudo : \n");
		String namePlayer1 = scan.next();
		System.out.println("Bonjour " + namePlayer1 + "! Bonne chance!\n" + "Joueur 2, entre ton pseudo : \n");
		String namePlayer2 = scan.next();
		System.out.println("Bonjour " + namePlayer2 + "! Bonne chance!\n" + "Joueur 3, entre ton pseudo : \n");
		String namePlayer3 = scan.next();
		System.out.println("Bonjour " + namePlayer3 + "! Bonne chance!\n" + "Joueur 4, entre ton pseudo : \n");
		String namePlayer4 = scan.next();
		System.out.println("Bonjour " + namePlayer4 + "! Bonne chance!\n");
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer1 = new Plateau(boardSize);
		Plateau boardPlayer2 = new Plateau(boardSize);
		Plateau boardPlayer3 = new Plateau(boardSize);
		Plateau boardPlayer4 = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player1 = new Player(namePlayer1, boardPlayer1);
		Player player2 = new Player(namePlayer2, boardPlayer2);
		Player player3 = new Player(namePlayer3, boardPlayer3);
		Player player4 = new Player(namePlayer4, boardPlayer4);
		ArrayList<Player> debut4Joueurs = debut4Players(player1, player2, player3, player4);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		int[] scoresPlayer3 = new int[3];
		int[] scoresPlayer4 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu == "Dynastie") {
				System.out.println("Début de la partie " + (ruler + 1) + " :\n");
			} else {
				System.out.println("Début de la partie :\n");
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut4Players(player0, player0, player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				System.out.println("Tour " + nbTour + "\nLes joueurs commenceront dans cet ordre :\n"
						+ debut4Joueurs.get(0).getname() + ", " + debut4Joueurs.get(1).getname() + ", "
						+ debut4Joueurs.get(2).getname() + ", " + debut4Joueurs.get(3).getname());
				for (int i = 0; i < 3; i++) {
					boolean nbValide = true;
					do {
						try {
							System.out.println("\n" + debut4Joueurs.get(i).getname()
									+ " c'est à ton tour. Voici ton terrain : \n");
							debut4Joueurs.get(i).getboard().print();
							System.out.println("\nVoici la liste des tuiles :\n");
							afficheTuile(triTuile(listeTuiles));
							System.out.println("Sélectionne la tuile de ton choix :");
							int choixTuile = scan.nextInt();
							if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
								if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut4Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut4Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut4Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
								if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut4Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut4Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut4Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
								if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut4Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut4Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut4Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
								if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									System.out.println("\n" + debut4Joueurs.get(i).getname()
											+ " tu possèdes maintenant un score de "
											+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut4Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
								} else {
									System.out.println(
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n");
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut4Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
								}
							} else {
								System.out.println("Cette tuile ne peut être prise ! Veuillez réessayer :");
								scan.nextLine();
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :");
							scan.nextLine();
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Ce chiffre n'est pas valide ! Veuillez réessayer :");
							scan.nextLine();
						}
					} while (nbValide);
				}
				System.out.println(
						"\n" + debut4Joueurs.get(3).getname() + ", c'est à ton tour. Voici la dernière tuile :\n");
				afficheTuile(triTuile(listeTuiles));
				if (debut4Joueurs.get(3).getboard().canPlay(listeTuiles.get(lastTile - 1))) {
					play(debut4Joueurs.get(3), listeTuiles.get(lastTile - 1), modeDeJeu);
					System.out.println("\n" + debut4Joueurs.get(3).getname() + " tu possèdes maintenant un score de "
							+ debut4Joueurs.get(3).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut4Joueurs.get(3));
				} else {
					System.out.println(
							"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
									+ debut4Joueurs.get(3).getboard().copy().score() + " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut4Joueurs.get(3));
				}
				debut4Joueurs = tourSuivant;
				nbTour += 1;
			}
			int newScore1 = player1.getboard().copy().score();
			int newScore2 = player2.getboard().copy().score();
			int newScore3 = player3.getboard().copy().score();
			int newScore4 = player4.getboard().copy().score();
			int domaineMax1 = player1.getboard().domaineMax();
			int domaineMax2 = player2.getboard().domaineMax();
			int domaineMax3 = player3.getboard().domaineMax();
			int domaineMax4 = player4.getboard().domaineMax();
			int nbCouronnes1 = player1.getboard().nbCouronnes();
			int nbCouronnes2 = player2.getboard().nbCouronnes();
			int nbCouronnes3 = player3.getboard().nbCouronnes();
			int nbCouronnes4 = player4.getboard().nbCouronnes();
			scoresPlayer1[0] += newScore1;
			scoresPlayer2[0] += newScore2;
			scoresPlayer3[0] += newScore3;
			scoresPlayer4[0] += newScore4;
			scoresPlayer1[1] += domaineMax1;
			scoresPlayer2[1] += domaineMax2;
			scoresPlayer3[1] += domaineMax3;
			scoresPlayer4[1] += domaineMax4;
			scoresPlayer1[2] += nbCouronnes1;
			scoresPlayer2[2] += nbCouronnes2;
			scoresPlayer3[2] += nbCouronnes3;
			scoresPlayer4[2] += nbCouronnes4;
			if (modeDeJeu == "Dynastie") {
				System.out.println("Fin de la partie " + (ruler + 1) + "!");
				Plateau emptyBoard1 = new Plateau(boardSize);
				Plateau emptyBoard2 = new Plateau(boardSize);
				Plateau emptyBoard3 = new Plateau(boardSize);
				Plateau emptyBoard4 = new Plateau(boardSize);
				player1.setboard(emptyBoard1);
				player2.setboard(emptyBoard2);
				player3.setboard(emptyBoard3);
				player4.setboard(emptyBoard4);
				nbTour = 1;
			}
		}
		int[] newScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
		int[] newScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
		int[] newScoresPlayer3 = { scoresPlayer3[0], scoresPlayer3[1], scoresPlayer3[2] };
		int[] newScoresPlayer4 = { scoresPlayer4[0], scoresPlayer4[1], scoresPlayer4[2] };
		player1.setscores(newScoresPlayer1);
		player2.setscores(newScoresPlayer2);
		player3.setscores(newScoresPlayer3);
		player4.setscores(newScoresPlayer4);
		if (modeDeJeu == "Harmonie") {
			if (player1.getboard().complet()) {
				scoresPlayer1[0] += 5;
			}
			if (player2.getboard().complet()) {
				scoresPlayer2[0] += 5;
			}
			if (player3.getboard().complet()) {
				scoresPlayer3[0] += 5;
			}
			if (player4.getboard().complet()) {
				scoresPlayer4[0] += 5;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			int[] newNewScoresPlayer3 = { scoresPlayer3[0], scoresPlayer3[1], scoresPlayer3[2] };
			int[] newNewScoresPlayer4 = { scoresPlayer4[0], scoresPlayer4[1], scoresPlayer4[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			player3.setscores(newNewScoresPlayer3);
			player4.setscores(newNewScoresPlayer4);
			printClassement4(player1, player2, player3, player4);
		} else if (modeDeJeu == "Empire du milieu") {
			if (player1.getboard().estAuMilieu()) {
				scoresPlayer1[0] += 10;
			}
			if (player2.getboard().estAuMilieu()) {
				scoresPlayer2[0] += 10;
			}
			if (player3.getboard().estAuMilieu()) {
				scoresPlayer3[0] += 10;
			}
			if (player4.getboard().estAuMilieu()) {
				scoresPlayer4[0] += 10;
			}
			int[] newNewScoresPlayer1 = { scoresPlayer1[0], scoresPlayer1[1], scoresPlayer1[2] };
			int[] newNewScoresPlayer2 = { scoresPlayer2[0], scoresPlayer2[1], scoresPlayer2[2] };
			int[] newNewScoresPlayer3 = { scoresPlayer3[0], scoresPlayer3[1], scoresPlayer3[2] };
			int[] newNewScoresPlayer4 = { scoresPlayer4[0], scoresPlayer4[1], scoresPlayer4[2] };
			player1.setscores(newNewScoresPlayer1);
			player2.setscores(newNewScoresPlayer2);
			player3.setscores(newNewScoresPlayer3);
			player4.setscores(newNewScoresPlayer4);
			printClassement4(player1, player2, player3, player4);
		} else {
			printClassement4(player1, player2, player3, player4);
		}
		System.out.println("\n\nFin de la partie!");
		scan.close();
	}

	public static void play(Player player, Domino tile, String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		boolean jouable = true;
		int boardSize = 8;
		if (modeDeJeu == "Le Grand Duel") {
			boardSize = 12;
		}
		do {
			boolean x1Valide = true;
			boolean y1Valide = true;
			boolean x2Valide = true;
			boolean y2Valide = true;
			int[] coordonnees = new int[4];
			System.out.println("Voici ton terrain " + player.getname() + " :\n");
			player.getboard().print();
			do {
				try {
					System.out.print("\nInsère cette tuile : ");
					printTile(tile);
					System.out.println();
					System.out.println("Pour ce faire, entre la position du terrain " + tile.gettile1() + " :\nx1 =");
					int x1 = scan.nextInt();
					if (x1 >= 0 && x1 <= boardSize) {
						coordonnees[0] = x1;
						x1Valide = false;
					} else {
						System.out.println("Ce chiffre n'est pas valide! Veuillez réessayer :");
						scan.nextLine();
					}
				} catch (InputMismatchException e) {
					System.out.println("Ce n'est pas un chiffre! Veuillez réessayer :");
					scan.nextLine();
				}
			} while (x1Valide);
			do {
				try {
					System.out.println("y1 =");
					int y1 = scan.nextInt();
					if (y1 >= 0 && y1 <= boardSize) {
						coordonnees[1] = y1;
						y1Valide = false;
					} else {
						System.out.println("Ce chiffre n'est pas valide! Veuillez réessayer :");
						scan.nextLine();
					}
				} catch (InputMismatchException e) {
					System.out.println("Ce n'est pas un chiffre! Veuillez réessayer :");
					scan.nextLine();
				}
			} while (y1Valide);
			do {
				try {
					System.out.println("Maintenant, entre la position du terrain " + tile.gettile2() + " :\nx2 =");
					int x2 = scan.nextInt();
					if (x2 >= 0 && x2 <= boardSize) {
						coordonnees[2] = x2;
						x2Valide = false;
					} else {
						System.out.println("Ce chiffre n'est pas valide! Veuillez réessayer :");
						scan.nextLine();
					}
				} catch (InputMismatchException e) {
					System.out.println("Ce n'est pas un chiffre! Veuillez réessayer :");
					scan.nextLine();
				}
			} while (x2Valide);
			do {
				try {
					System.out.println("y2 =");
					int y2 = scan.nextInt();
					if (y2 >= 0 && y2 <= boardSize) {
						coordonnees[3] = y2;
						y2Valide = false;
					} else {
						System.out.println("Ce chiffre n'est pas valide! Veuillez réessayer :");
						scan.nextLine();
					}
				} catch (InputMismatchException e) {
					System.out.println("Ce n'est pas un chiffre! Veuillez réessayer :");
					scan.nextLine();
				}
			} while (y2Valide);
			if (player.getboard().printJouable(tile, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3])) {
				tile.inserttuile(player.getboard(), coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3]);
				System.out.print("Ta tuile ");
				printTile(tile);
				System.out.print("a été ajoutée aux coordonnées [" + coordonnees[0] + "," + coordonnees[1] + "],["
						+ coordonnees[2] + "," + coordonnees[3] + "].");
				jouable = false;
			} else {
				System.out.println("Ce mouvement est impossible ! Veuillez réessayer :");
				scan.nextLine();
			}
		} while (jouable);
		scan.close();
	}

	public static ArrayList<Player> winner2(Player player1, Player player2) {
		ArrayList<Player> listeWinners = new ArrayList<Player>();
		int[] scoresPlayer1 = player1.getscores();
		int[] scoresPlayer2 = player2.getscores();
		int score1 = scoresPlayer1[0];
		int score2 = scoresPlayer2[0];
		int domaineMax1 = scoresPlayer1[1];
		int domaineMax2 = scoresPlayer2[1];
		int nbCouronnes1 = scoresPlayer1[2];
		int nbCouronnes2 = scoresPlayer2[2];
		if (score1 == score2) {
			if (domaineMax1 == domaineMax2) {
				if (nbCouronnes1 == nbCouronnes2) {
					listeWinners.add(player1);
					listeWinners.add(player2);
				} else if (nbCouronnes1 > nbCouronnes2) {
					listeWinners.add(player1);
				} else {
					listeWinners.add(player2);
				}
			} else if (domaineMax1 > domaineMax2) {
				listeWinners.add(player1);
			} else {
				listeWinners.add(player2);
			}
		} else if (score1 > score2) {
			listeWinners.add(player1);
		} else {
			listeWinners.add(player2);
		}
		return listeWinners;
	}

	public static ArrayList<Player> winner3(Player player1, Player player2, Player player3) {
		ArrayList<Player> winners = new ArrayList<Player>();
		ArrayList<Player> winnerPlayer1Player2 = winner2(player1, player2);
		if (winnerPlayer1Player2.size() == 2) {
			if (winner2(winnerPlayer1Player2.get(0), player3).size() == 2) {
				winners.add(player1);
				winners.add(player2);
				winners.add(player3);
				return winners;
			} else if (winner2(winnerPlayer1Player2.get(0), player3) == winner2(winnerPlayer1Player2.get(1), player3)) {
				winners.add(player3);
				return winners;
			} else {
				winners.add(player1);
				winners.add(player2);
				return winners;
			}
		} else {
			return winner2(winnerPlayer1Player2.get(0), player3);
		}
	}

	public static ArrayList<Player> winner4(Player player1, Player player2, Player player3, Player player4) {
		ArrayList<Player> winners = new ArrayList<Player>();
		ArrayList<Player> winnerPlayer1Player2Player3 = winner3(player1, player2, player3);
		if (winnerPlayer1Player2Player3.size() == 3) {
			if (winner2(winnerPlayer1Player2Player3.get(0), player4).size() == 2) {
				winners.add(player1);
				winners.add(player2);
				winners.add(player3);
				winners.add(player4);
				return winners;
			} else if (winner2(winnerPlayer1Player2Player3.get(0),
					player4) == winner2(winnerPlayer1Player2Player3.get(1), player4)) {
				winners.add(player4);
				return winners;
			} else {
				winners.add(player1);
				winners.add(player2);
				winners.add(player3);
				return winners;
			}
		} else if (winnerPlayer1Player2Player3.size() == 2) {
			if (winner2(winnerPlayer1Player2Player3.get(0), player4).size() == 2) {
				winners.add(winnerPlayer1Player2Player3.get(0));
				winners.add(winnerPlayer1Player2Player3.get(1));
				winners.add(player4);
				return winners;
			} else if (winner2(winnerPlayer1Player2Player3.get(0),
					player4) == winner2(winnerPlayer1Player2Player3.get(1), player4)) {
				winners.add(player4);
				return winners;
			} else {
				winners.add(winnerPlayer1Player2Player3.get(0));
				winners.add(winnerPlayer1Player2Player3.get(1));
				return winners;
			}
		} else {
			return winner2(winnerPlayer1Player2Player3.get(0), player4);
		}
	}

	public static void printWinners(ArrayList<Player> listeWinners) {
		if (listeWinners.size() == 1) {
			Player player1 = listeWinners.get(0);
			System.out.println("Le grand gagnant est " + player1.getname() + "!\nIl obtient un score de "
					+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
					+ " cases!\nEnfin il possède un total de " + player1.getscores()[2] + " couronnes!\nBravo à toi "
					+ player1.getname() + "!\n");
		} else if (listeWinners.size() == 2) {
			Player player1 = listeWinners.get(0);
			Player player2 = listeWinners.get(1);
			System.out.println("Les grands gagnants sont " + player1.getname() + " et " + player2.getname()
					+ "!\nVous obtenez un score de " + player1.getscores()[0]
					+ " points!\nVos domaines les plus étendus sont de " + player1.getscores()[1]
					+ " cases!\nEnfin vous possédez un total de " + player1.getscores()[2]
					+ " couronnes!\nBravo à vous deux!\n");
		} else if (listeWinners.size() == 3) {
			Player player1 = listeWinners.get(0);
			Player player2 = listeWinners.get(1);
			Player player3 = listeWinners.get(2);
			System.out.println("Les grands gagnants sont " + player1.getname() + " et " + player2.getname() + " et "
					+ player3.getname() + "!\nVous obtenez un score de " + player1.getscores()[0]
					+ " points!\nVos domaines les plus étendus sont de " + player1.getscores()[1]
					+ " cases!\nEnfin vous possédez un total de " + player1.getscores()[2]
					+ " couronnes!\nBravo à vous trois!\n");
		} else {
			Player player1 = listeWinners.get(0);
			Player player2 = listeWinners.get(1);
			Player player3 = listeWinners.get(2);
			Player player4 = listeWinners.get(3);
			System.out.println("Les grands gagnants sont " + player1.getname() + " et " + player2.getname() + " et "
					+ player3.getname() + " et " + player4.getname() + "!\nVous obtenez un score de "
					+ player1.getscores()[0] + " points!\nVos domaines les plus étendus sont de "
					+ player1.getscores()[1] + " cases!\nEnfin vous possédez un total de " + player1.getscores()[2]
					+ " couronnes!\nBravo à vous quatre!\n");
		}
	}

	public static void printClassement2(Player player1, Player player2) {
		ArrayList<Player> listeWinners = winner2(player1, player2);
		printWinners(listeWinners);
		if (listeWinners.size() == 1) {
			if (listeWinners.get(0) == player1) {
				System.out.println("Le perdant est donc " + player2.getname() + "!\nIl obtient un score de "
						+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player2.getscores()[1] + " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n");
			} else {
				System.out.println("Le perdant est donc " + player1.getname() + "!\nIl obtient un score de "
						+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player1.getscores()[1] + " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n");
			}
		}
	}

	public static void printClassement3(Player player1, Player player2, Player player3) {
		ArrayList<Player> listeWinners = winner3(player1, player2, player3);
		printWinners(listeWinners);
		if (listeWinners.size() == 1) {
			if (listeWinners.get(0) == player1) {
				System.out.println("Les perdants sont donc " + player2.getname() + " et " + player3.getname() + "!\n"
						+ player2.getname() + " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			} else if (listeWinners.get(0) == player2) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player3.getname() + "!\n"
						+ player1.getname() + " obtient un score de " + player1.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			} else {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player2.getname() + "!\n"
						+ player1.getname() + " obtient un score de " + player1.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player2.getname()
						+ " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n");
			}
		} else if (listeWinners.size() == 2) {
			if ((listeWinners.get(0) != player1) || (listeWinners.get(1) != player1)) {
				System.out.println("Le perdant est donc " + player1.getname() + "!\nIl obtient un score de "
						+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player1.getscores()[1] + " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n");
			} else if ((listeWinners.get(0) != player2) || (listeWinners.get(1) != player2)) {
				System.out.println("Le perdant est donc " + player2.getname() + "!\nIl obtient un score de "
						+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player2.getscores()[1] + " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n");
			} else {
				System.out.println("Le perdant est donc " + player3.getname() + "!\nIl obtient un score de "
						+ player3.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player3.getscores()[1] + " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			}
		}
	}

	public static void printClassement4(Player player1, Player player2, Player player3, Player player4) {
		ArrayList<Player> listeWinners = winner4(player1, player2, player3, player4);
		printWinners(listeWinners);
		if (listeWinners.size() == 1) {
			if (listeWinners.get(0) == player1) {
				System.out.println("Les perdants sont donc " + player2.getname() + " et " + player3.getname() + " et "
						+ player4.getname() + "!\n" + player2.getname() + " obtient un score de "
						+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player2.getscores()[1] + " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n" + player4.getname()
						+ " obtient un score de " + player4.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			} else if (listeWinners.get(0) == player2) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player3.getname() + " et "
						+ player4.getname() + "!\n" + player1.getname() + " obtient un score de "
						+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player1.getscores()[1] + " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n" + player4.getname()
						+ " obtient un score de " + player4.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			} else if (listeWinners.get(0) == player3) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player2.getname() + " et "
						+ player4.getname() + "!\n" + player1.getname() + " obtient un score de "
						+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player1.getscores()[1] + " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player2.getname()
						+ " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n" + player4.getname()
						+ " obtient un score de " + player4.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			} else if (listeWinners.get(0) == player4) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player2.getname() + " et "
						+ player3.getname() + "!\n" + player1.getname() + " obtient un score de "
						+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player1.getscores()[1] + " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player2.getname()
						+ " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			}
		} else if (listeWinners.size() == 2) {
			if ((listeWinners.get(0) == player1 || listeWinners.get(1) == player1)
					&& (listeWinners.get(0) == player2 || listeWinners.get(1) == player2)) {
				System.out.println("Les perdants sont donc " + player3.getname() + " et " + player4.getname() + "!\n"
						+ player3.getname() + " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n" + player4.getname()
						+ " obtient un score de " + player4.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			} else if ((listeWinners.get(0) == player1 || listeWinners.get(1) == player1)
					&& (listeWinners.get(0) == player3 || listeWinners.get(1) == player3)) {
				System.out.println("Les perdants sont donc " + player2.getname() + " et " + player4.getname() + "!\n"
						+ player2.getname() + " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n" + player4.getname()
						+ " obtient un score de " + player4.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			} else if ((listeWinners.get(0) == player1 || listeWinners.get(1) == player1)
					&& (listeWinners.get(0) == player4 || listeWinners.get(1) == player4)) {
				System.out.println("Les perdants sont donc " + player2.getname() + " et " + player3.getname() + "!\n"
						+ player2.getname() + " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			} else if ((listeWinners.get(0) == player2 || listeWinners.get(1) == player2)
					&& (listeWinners.get(0) == player3 || listeWinners.get(1) == player3)) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player4.getname() + "!\n"
						+ player1.getname() + " obtient un score de " + player1.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player4.getname()
						+ " obtient un score de " + player4.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			} else if ((listeWinners.get(0) == player2 || listeWinners.get(1) == player2)
					&& (listeWinners.get(0) == player4 || listeWinners.get(1) == player4)) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player3.getname() + "!\n"
						+ player1.getname() + " obtient un score de " + player1.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player3.getname()
						+ " obtient un score de " + player3.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			} else if ((listeWinners.get(0) == player3 || listeWinners.get(1) == player3)
					&& (listeWinners.get(0) == player4 || listeWinners.get(1) == player4)) {
				System.out.println("Les perdants sont donc " + player1.getname() + " et " + player2.getname() + "!\n"
						+ player1.getname() + " obtient un score de " + player1.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n" + player2.getname()
						+ " obtient un score de " + player2.getscores()[0]
						+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
						+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n");
			}
		} else if (listeWinners.size() == 3) {
			if ((listeWinners.get(0) != player1) || (listeWinners.get(1) != player1)
					|| (listeWinners.get(2) != player1)) {
				System.out.println("Le perdant est donc " + player1.getname() + "!\nIl obtient un score de "
						+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player1.getscores()[1] + " cases!\nEnfin il possède un total de " + player1.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n");
			} else if ((listeWinners.get(0) != player2) || (listeWinners.get(1) != player2)
					|| (listeWinners.get(2) != player2)) {
				System.out.println("Le perdant est donc " + player2.getname() + "!\nIl obtient un score de "
						+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player2.getscores()[1] + " cases!\nEnfin il possède un total de " + player2.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n");
			} else if ((listeWinners.get(0) != player3) || (listeWinners.get(1) != player3)
					|| (listeWinners.get(2) != player3)) {
				System.out.println("Le perdant est donc " + player3.getname() + "!\nIl obtient un score de "
						+ player3.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player3.getscores()[1] + " cases!\nEnfin il possède un total de " + player3.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n");
			} else if ((listeWinners.get(0) != player4) || (listeWinners.get(1) != player4)
					|| (listeWinners.get(2) != player4)) {
				System.out.println("Le perdant est donc " + player4.getname() + "!\nIl obtient un score de "
						+ player4.getscores()[0] + " points!\nSon domaine le plus étendu est de "
						+ player4.getscores()[1] + " cases!\nEnfin il possède un total de " + player4.getscores()[2]
						+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n");
			}
		}
	}

	public static ArrayList<Domino> tirage(ArrayList<Domino> liste, int nbDominos) {
		ArrayList<Domino> pioche = new ArrayList<Domino>();
		ArrayList<Domino> copyListe = copyTuile(liste);
		for (int i = 0; i < nbDominos; i++) {
			int rand = new Random().nextInt(copyListe.size());
			pioche.add(copyListe.get(rand));
			copyListe.remove(rand);
		}
		return pioche;
	}

	public static void affiche(ArrayList<Integer[]> liste) {
		for (int i = 0; i < liste.size(); i++) {
			System.out.print("[" + liste.get(i)[0] + "," + liste.get(i)[1] + "]");
		}
		System.out.print("\n");
	}

	public static void afficheTuile(ArrayList<Domino> liste) {
		for (int i = 0; i < liste.size(); i++) {
			Domino tile = liste.get(i);
			if (!emptyTuile(tile)) {
				if (tile.getcrown1() == 0 && tile.getcrown2() == 0) {
					System.out.println(
							i + 1 + ". [" + tile.getnumber() + "," + tile.gettile1() + "," + tile.gettile2() + "]\r");
				} else if (tile.getcrown1() > 0 && tile.getcrown2() == 0) {
					System.out.println(i + 1 + ". [" + tile.getnumber() + "," + tile.getcrown1() + tile.gettile1() + ","
							+ tile.gettile2() + "]\r");
				} else if (tile.getcrown2() > 0 && tile.getcrown1() == 0) {
					System.out.println(i + 1 + ". [" + tile.getnumber() + "," + tile.gettile1() + "," + tile.getcrown2()
							+ tile.gettile2() + "]\r");
				} else if (tile.getcrown1() > 0 && tile.getcrown2() > 0) {
					System.out.println(i + 1 + ". [" + tile.getnumber() + "," + tile.getcrown1() + tile.gettile1() + ","
							+ tile.getcrown2() + tile.gettile2() + "]\r");
				}
			}
		}
	}

	public static void afficheJoueurs(ArrayList<Player> liste) {
		for (int i = 0; i < liste.size(); i++) {
			int[] scoresPlayer = liste.get(i).getscores();
			System.out.println("[[" + scoresPlayer[0] + "," + scoresPlayer[1] + "," + scoresPlayer[2] + "],"
					+ liste.get(i).getname() + ",\t");
			liste.get(i).getboard().print();
			System.out.println("]\t");
		}
	}

	public static ArrayList<Integer> listIndexTile(ArrayList<Domino> liste) {
		ArrayList<Integer> listIndex = new ArrayList<Integer>();
		for (int i = 0; i < liste.size(); i++) {
			if (!emptyTuile(liste.get(i))) {
				listIndex.add(i);
			}
		}
		return listIndex;
	}

	public static boolean estTrieeTuile(ArrayList<Domino> liste) {
		if (nbEmptyTile(liste) > liste.size() - 2) {
			return true;
		} else {
			ArrayList<Integer> listIndexTile = listIndexTile(liste);
			for (int i = 0; i < listIndexTile.size() - 1; i++) {
				if (liste.get(listIndexTile.get(i)).getnumber() > liste.get(listIndexTile.get(i + 1)).getnumber()) {
					return false;
				}
			}
		}
		return true;
	}

	public static ArrayList<Domino> triTuile(ArrayList<Domino> liste) {
		if (nbEmptyTile(liste) > liste.size() - 2) {
			return liste;
		} else {
			while (!estTrieeTuile(liste)) {
				ArrayList<Integer> listIndexTile = listIndexTile(liste);
				for (int i = 0; i < listIndexTile.size() - 1; i++) {
					if (liste.get(listIndexTile.get(i)).getnumber() > liste.get(listIndexTile.get(i + 1)).getnumber()) {
						int index1 = listIndexTile.get(i);
						int index2 = listIndexTile.get(i + 1);
						Domino tile1 = liste.get(index1);
						Domino tile2 = liste.get(index2);
						liste.set(index1, tile2);
						liste.set(index2, tile1);
					}
				}
			}
			return liste;
		}
	}

	public static int nbEmptyTile(ArrayList<Domino> liste) {
		int nbTuilesVides = 0;
		for (int i = 0; i < liste.size(); i++) {
			if (emptyTuile(liste.get(i))) {
				nbTuilesVides += 1;
			}
		}
		return nbTuilesVides;
	}

	public static boolean estTriee(ArrayList<Integer[]> liste) {
		for (int i = 0; i < liste.size() - 1; i++) {
			if (liste.get(i)[1] > liste.get(i + 1)[1]) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer[]> tri(ArrayList<Integer[]> liste) {
		while (!estTriee(liste)) {
			for (int i = 0; i < liste.size() - 1; i++) {
				if (liste.get(i)[1] > liste.get(i + 1)[1]) {
					int index = i;
					Integer[] pos1 = liste.get(index);
					Integer[] pos2 = liste.get(index + 1);
					liste.set(index, pos2);
					liste.set(index + 1, pos1);
				}
			}
		}
		return liste;
	}

	public static ArrayList<Domino> copyTuile(ArrayList<Domino> listeTuiles) {
		ArrayList<Domino> newListeTuiles = new ArrayList<Domino>();
		for (int i = 0; i < listeTuiles.size(); i++) {
			Domino tile = listeTuiles.get(i);
			Domino tuile = new Domino(tile.getnumber(), tile.getcrown1(), tile.getcrown2(), tile.gettile1(),
					tile.gettile2());
			newListeTuiles.add(tuile);
		}
		return newListeTuiles;
	}

	public static void printTile(Domino tile) {
		if (tile.getcrown1() == 0 && tile.getcrown2() == 0) {
			System.out.print("[" + tile.getnumber() + "," + tile.gettile1() + "," + tile.gettile2() + "] ");
		} else if (tile.getcrown1() > 0 && tile.getcrown2() == 0) {
			System.out.print(
					"[" + tile.getnumber() + "," + tile.getcrown1() + tile.gettile1() + "," + tile.gettile2() + "] ");
		} else if (tile.getcrown2() > 0 && tile.getcrown1() == 0) {
			System.out.print(
					"[" + tile.getnumber() + "," + tile.gettile1() + "," + tile.getcrown2() + tile.gettile2() + "] ");
		} else if (tile.getcrown1() > 0 && tile.getcrown2() > 0) {
			System.out.print("[" + tile.getnumber() + "," + tile.getcrown1() + tile.gettile1() + "," + tile.getcrown2()
					+ tile.gettile2() + "] ");
		}
	}

	public static boolean endGame(ArrayList<Domino> liste) {
		if (liste.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Player> debut2Players(Player player1, Player player2) {
		ArrayList<Player> debut = new ArrayList<Player>();
		ArrayList<Player> listePlayers = new ArrayList<Player>();
		listePlayers.add(player1);
		listePlayers.add(player2);
		listePlayers.add(player1);
		listePlayers.add(player2);
		for (int i = 0; i < 4; i++) {
			int rand = new Random().nextInt(listePlayers.size());
			debut.add(listePlayers.get(rand));
			listePlayers.remove(rand);
		}
		return debut;
	}

	public static ArrayList<Player> debut3Players(Player player1, Player player2, Player player3) {
		ArrayList<Player> debut = new ArrayList<Player>();
		ArrayList<Player> listePlayers = new ArrayList<Player>();
		listePlayers.add(player1);
		listePlayers.add(player2);
		listePlayers.add(player3);
		for (int i = 0; i < 3; i++) {
			int rand = new Random().nextInt(listePlayers.size());
			debut.add(listePlayers.get(rand));
			listePlayers.remove(rand);
		}
		return debut;
	}

	public static ArrayList<Player> debut4Players(Player player1, Player player2, Player player3, Player player4) {
		ArrayList<Player> debut = new ArrayList<Player>();
		ArrayList<Player> listePlayers = new ArrayList<Player>();
		listePlayers.add(player1);
		listePlayers.add(player2);
		listePlayers.add(player3);
		listePlayers.add(player4);
		for (int i = 0; i < 4; i++) {
			int rand = new Random().nextInt(listePlayers.size());
			debut.add(listePlayers.get(rand));
			listePlayers.remove(rand);
		}
		return debut;
	}

	public static ArrayList<Domino> listeTuiles(ArrayList<Domino> liste, int nbDominos) {
		ArrayList<Domino> listeDominos = new ArrayList<Domino>();
		for (int i = 0; i < nbDominos; i++) {
			int rand = new Random().nextInt(liste.size());
			listeDominos.add(liste.get(rand));
			liste.remove(rand);
		}
		return listeDominos;
	}

	public static boolean emptyTuile(Domino tile) {
		if (tile.getnumber() == 0 && tile.getcrown1() == 0 && tile.getcrown2() == 0 && tile.gettile1() == '#'
				&& tile.gettile2() == '#') {
			return true;
		}
		return false;
	}

	public static int[] crownsPWFLQM(ArrayList<Domino> Pioche) {
		int[] CrownsPWFLQM = new int[6];
		for (int domino = 0; domino < Pioche.size(); domino++) {
			if (Pioche.get(domino).tile1 == 'P') {
				CrownsPWFLQM[0] = Pioche.get(domino).crown1 + CrownsPWFLQM[0];
			}
			if (Pioche.get(domino).tile1 == 'W') {
				CrownsPWFLQM[1] = Pioche.get(domino).crown1 + CrownsPWFLQM[1];
			}
			if (Pioche.get(domino).tile1 == 'F') {
				CrownsPWFLQM[2] = Pioche.get(domino).crown1 + CrownsPWFLQM[2];
			}
			if (Pioche.get(domino).tile1 == 'L') {
				CrownsPWFLQM[3] = Pioche.get(domino).crown1 + CrownsPWFLQM[3];
			}
			if (Pioche.get(domino).tile1 == 'Q') {
				CrownsPWFLQM[4] = Pioche.get(domino).crown1 + CrownsPWFLQM[4];
			}
			if (Pioche.get(domino).tile1 == 'M') {
				CrownsPWFLQM[5] = Pioche.get(domino).crown1 + CrownsPWFLQM[5];
			}
			if (Pioche.get(domino).tile2 == 'P') {
				CrownsPWFLQM[0] = Pioche.get(domino).crown1 + CrownsPWFLQM[0];
			}
			if (Pioche.get(domino).tile2 == 'W') {
				CrownsPWFLQM[1] = Pioche.get(domino).crown1 + CrownsPWFLQM[1];
			}
			if (Pioche.get(domino).tile2 == 'F') {
				CrownsPWFLQM[2] = Pioche.get(domino).crown1 + CrownsPWFLQM[2];
			}
			if (Pioche.get(domino).tile2 == 'L') {
				CrownsPWFLQM[3] = Pioche.get(domino).crown1 + CrownsPWFLQM[3];
			}
			if (Pioche.get(domino).tile2 == 'Q') {
				CrownsPWFLQM[4] = Pioche.get(domino).crown1 + CrownsPWFLQM[4];
			}
			if (Pioche.get(domino).tile2 == 'M') {
				CrownsPWFLQM[5] = Pioche.get(domino).crown1 + CrownsPWFLQM[5];
			}
		}
		return CrownsPWFLQM;
	}

	public static void onePlayer(String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 24;
		if (modeDeJeu.equals("Dynastie")) {
			nbParties = 3;
		}
		if (modeDeJeu.equals("Le Grand Duel")) {
			boardSize = 13;
			nbDominos = 48;
		}
		System.out.println("Bienvenue dans le mode " + modeDeJeu + " pour 1 joueur !\n" + "\n"
				+ "Joueur 1, entre ton pseudo : \n");
		String namePlayer = scan.next();
		System.out.println("Bonjour " + namePlayer + "! Bonne chance!\n");
		String nameIA = "IA";
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer = new Plateau(boardSize);
		Plateau boardPlayerIA = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player = new Player(namePlayer, boardPlayer);
		Player ia = new Player(nameIA, boardPlayerIA);
		ia.setIA(true);
		ArrayList<Player> debut2Joueurs = debut2Players(player, ia);
		int[] scoresPlayer = new int[3];
		int[] scoresPlayerIA = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu.equals("Dynastie")) {
				System.out.println("Début de la partie " + (ruler + 1) + " :\n");
			} else {
				System.out.println("Début de la partie :\n");
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			int[] valuesPWFLQM = crownsPWFLQM(liste);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut2Players(player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				System.out.println("Tour " + nbTour + "\nLes joueurs commenceront dans cet ordre :\n"
						+ debut2Joueurs.get(0).getname() + ", " + debut2Joueurs.get(1).getname() + ", "
						+ debut2Joueurs.get(2).getname() + ", " + debut2Joueurs.get(3).getname());
				for (int i = 0; i < 3; i++) {
					boolean nbValide = true;
					do {
						try {
							if (!debut2Joueurs.get(i).getIA()) {
								System.out.println("\n" + debut2Joueurs.get(i).getname()
										+ " c'est à ton tour. Voici ton terrain : \n");
								debut2Joueurs.get(i).getboard().print();
								System.out.println("\nVoici la liste des tuiles :\n");
								afficheTuile(triTuile(listeTuiles));
								System.out.println("Sélectionne la tuile de ton choix :");
								int choixTuile = scan.nextInt();
								if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(0, tileEmpty);
										tourSuivant.set(0, debut2Joueurs.get(i));
										lastTile = lastTile - 1;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(0, tileEmpty);
										tourSuivant.set(0, debut2Joueurs.get(i));
										lastTile = lastTile - 1;
										nbValide = false;
									}
								} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(1, tileEmpty);
										tourSuivant.set(1, debut2Joueurs.get(i));
										lastTile = lastTile - 2;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(1, tileEmpty);
										tourSuivant.set(1, debut2Joueurs.get(i));
										lastTile = lastTile - 2;
										nbValide = false;
									}
								} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(2, tileEmpty);
										tourSuivant.set(2, debut2Joueurs.get(i));
										lastTile = lastTile - 3;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(2, tileEmpty);
										tourSuivant.set(2, debut2Joueurs.get(i));
										lastTile = lastTile - 3;
										nbValide = false;
									}
								} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(3, tileEmpty);
										tourSuivant.set(3, debut2Joueurs.get(i));
										lastTile = lastTile - 4;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(3, tileEmpty);
										tourSuivant.set(3, debut2Joueurs.get(i));
										lastTile = lastTile - 4;
										nbValide = false;
									}
								} else {
									System.out.println("Cette tuile ne peut être prise ! Veuillez réessayer :");
									scan.nextLine();
								}
							} else {
								int value = 0;
								int choixTuile = 0;
								for (int rank = 0; rank < listeTuiles.size(); rank++) {
									if (value < listeTuiles.get(rank).evaluate(valuesPWFLQM)) {
										value = listeTuiles.get(rank).evaluate(valuesPWFLQM);
										choixTuile = rank;
									}
								}
								System.out.println("L'IA a choisi la tuile: " + (choixTuile + 1));
								playIA(debut2Joueurs.get(i), listeTuiles.get(choixTuile));
								listeTuiles.set(choixTuile, tileEmpty);
								tourSuivant.set(choixTuile, debut2Joueurs.get(i));
								lastTile = lastTile - (choixTuile + 1);
								System.out.println("Voici le terrain de l'IA : \n");
								debut2Joueurs.get(i).getboard().print();
								System.out.println("L'IA possède un score de : "
										+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
								nbValide = false;
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :");
							scan.nextLine();
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Ce chiffre n'est pas valide  ! Veuillez réessayer :");
							scan.nextLine();
						}
					} while (nbValide);
				}
				if (!debut2Joueurs.get(3).getIA()) {
					System.out.println(
							"\n" + debut2Joueurs.get(3).getname() + " c'est à ton tour. Voici la dernière tuile :\n");
					afficheTuile(triTuile(listeTuiles));
					if (debut2Joueurs.get(3).getboard().canPlay(listeTuiles.get(lastTile - 1))) {
						play(debut2Joueurs.get(3), listeTuiles.get(lastTile - 1), modeDeJeu);
						System.out
								.println("\n" + debut2Joueurs.get(3).getname() + " tu possèdes maintenant un score de "
										+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
						listeTuiles.set(lastTile - 1, tileEmpty);
						tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
					} else {
						System.out.println(
								"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
										+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
						listeTuiles.set(lastTile - 1, tileEmpty);
						tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
					}
				} else {
					playIA(debut2Joueurs.get(3), listeTuiles.get(lastTile - 1));
					System.out.println("Voici le terrain de l'IA :\n");
					debut2Joueurs.get(3).getboard().print();
					System.out.println("L'IA possède un score de : " + debut2Joueurs.get(3).getboard().copy().score()
							+ " points!\n");
					listeTuiles.set(lastTile - 1, tileEmpty);
					tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
				}
				debut2Joueurs = tourSuivant;
				nbTour += 1;
			}
			int newScore = player.getboard().copy().score();
			int newScoreIA = ia.getboard().copy().score();
			int domaineMax = player.getboard().domaineMax();
			int domaineMaxIA = ia.getboard().domaineMax();
			int nbCouronnes = player.getboard().nbCouronnes();
			int nbCouronnesIA = ia.getboard().nbCouronnes();
			scoresPlayer[0] += newScore;
			scoresPlayerIA[0] += newScoreIA;
			scoresPlayer[1] += domaineMax;
			scoresPlayerIA[1] += domaineMaxIA;
			scoresPlayer[2] += nbCouronnes;
			scoresPlayerIA[2] += nbCouronnesIA;
			if (modeDeJeu.equals("Dynastie")) {
				System.out.println("Fin de la partie " + (ruler + 1) + "!");
				Plateau emptyBoard = new Plateau(boardSize);
				Plateau emptyBoardIA = new Plateau(boardSize);
				player.setboard(emptyBoard);
				ia.setboard(emptyBoardIA);
				nbTour = 1;
			}
		}
		int[] newScoresPlayer = { scoresPlayer[0], scoresPlayer[1], scoresPlayer[2] };
		int[] newScoresPlayerIA = { scoresPlayerIA[0], scoresPlayerIA[1], scoresPlayerIA[2] };
		player.setscores(newScoresPlayer);
		ia.setscores(newScoresPlayerIA);
		if (modeDeJeu.equals("Harmonie")) {
			if (player.getboard().complet()) {
				scoresPlayer[0] += 5;
			}
			if (ia.getboard().complet()) {
				scoresPlayerIA[0] += 5;
			}
			int[] newNewScoresPlayer = { scoresPlayer[0], scoresPlayer[1], scoresPlayer[2] };
			int[] newNewScoresPlayerIA = { scoresPlayerIA[0], scoresPlayerIA[1], scoresPlayerIA[2] };
			player.setscores(newNewScoresPlayer);
			ia.setscores(newNewScoresPlayerIA);
			printClassement2(player, ia);
		} else if (modeDeJeu.equals("Empire du milieu")) {
			if (player.getboard().estAuMilieu()) {
				scoresPlayer[0] += 10;
			}
			if (ia.getboard().estAuMilieu()) {
				scoresPlayerIA[0] += 10;
			}
			int[] newNewScoresPlayer = { scoresPlayer[0], scoresPlayer[1], scoresPlayer[2] };
			int[] newNewScoresPlayerIA = { scoresPlayerIA[0], scoresPlayerIA[1], scoresPlayerIA[2] };
			player.setscores(newNewScoresPlayer);
			ia.setscores(newNewScoresPlayerIA);
			printClassement2(player, ia);
		} else {
			printClassement2(player, ia);
		}
		System.out.println("\n\nFin de la partie!");
		//scan.close();
	}

	/*public static void onePlayerBis(String modeDeJeu) {
		Scanner scan = new Scanner(System.in);
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 24;
		if (modeDeJeu.equals("Dynastie")) {
			nbParties = 3;
		}
		if (modeDeJeu.equals("Le Grand Duel")) {
			boardSize = 13;
			nbDominos = 48;
		}
		System.out.println("Bienvenue dans le mode " + modeDeJeu + " pour 1 joueur !\n" + "\n"
				+ "Joueur 1, entre ton pseudo : \n");
		String namePlayer = scan.next();
		System.out.println("Bonjour " + namePlayer + "! Bonne chance!\n");
		String nameIA = "IA";
		Board boardPlayer0 = new Board(boardSize);
		Board boardPlayer = new Board(boardSize);
		Board boardPlayerIA = new Board(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player = new Player(namePlayer, boardPlayer);
		Player ia = new Player(nameIA, boardPlayerIA);
		ia.setIA(true);
		ArrayList<Player> debut2Joueurs = debut2Players(player, ia);
		int[] scoresPlayer = new int[3];
		int[] scoresPlayerIA = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu.equals("Dynastie")) {
				System.out.println("Début de la partie " + (ruler + 1) + " :\n");
			} else {
				System.out.println("Début de la partie :\n");
			}
			ArrayList<Tuile> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				int lastTile = 10;
				ArrayList<Tuile> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut2Players(player0, player0);
				Tuile tileEmpty = new Tuile(0, 0, 0, '#', '#');
				System.out.println("Tour " + nbTour + "\nLes joueurs commenceront dans cet ordre :\n"
						+ debut2Joueurs.get(0).getname() + ", " + debut2Joueurs.get(1).getname() + ", "
						+ debut2Joueurs.get(2).getname() + ", " + debut2Joueurs.get(3).getname());
				for (int i = 0; i < 3; i++) {
					boolean nbValide = true;
					do {
						try {
							if (!debut2Joueurs.get(i).getIA()) {
								System.out.println("\n" + debut2Joueurs.get(i).getname()
										+ " c'est à ton tour. Voici ton terrain : \n");
								debut2Joueurs.get(i).getboard().print();
								System.out.println("\nVoici la liste des tuiles :\n");
								afficheTuile(triTuile(listeTuiles));
								System.out.println("Sélectionne la tuile de ton choix :");
								scan.nextLine();
								int choixTuile = scan.nextInt();
								if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(0, tileEmpty);
										tourSuivant.set(0, debut2Joueurs.get(i));
										lastTile = lastTile - 1;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(0, tileEmpty);
										tourSuivant.set(0, debut2Joueurs.get(i));
										lastTile = lastTile - 1;
										nbValide = false;
									}
								} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(1, tileEmpty);
										tourSuivant.set(1, debut2Joueurs.get(i));
										lastTile = lastTile - 2;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(1, tileEmpty);
										tourSuivant.set(1, debut2Joueurs.get(i));
										lastTile = lastTile - 2;
										nbValide = false;
									}
								} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(2, tileEmpty);
										tourSuivant.set(2, debut2Joueurs.get(i));
										lastTile = lastTile - 3;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(2, tileEmpty);
										tourSuivant.set(2, debut2Joueurs.get(i));
										lastTile = lastTile - 3;
										nbValide = false;
									}
								} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
									if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
										play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
										System.out.println("\n" + debut2Joueurs.get(i).getname()
												+ " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
										listeTuiles.set(3, tileEmpty);
										tourSuivant.set(3, debut2Joueurs.get(i));
										lastTile = lastTile - 4;
										nbValide = false;
									} else {
										System.out.println(
												"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
														+ debut2Joueurs.get(i).getboard().copy().score()
														+ " points!\n");
										listeTuiles.set(3, tileEmpty);
										tourSuivant.set(3, debut2Joueurs.get(i));
										lastTile = lastTile - 4;
										nbValide = false;
									}
								} else {
									System.out.println("Cette tuile ne peut être prise ! Veuillez réessayer :");
									scan.nextLine();
								}
							} else {
								System.out.println("\n" + debut2Joueurs.get(i).getname()
										+ " c'est à ton tour.\nVoici la liste des tuiles :\n");
								afficheTuile(triTuile(listeTuiles));
								lastTile = playIAbis(debut2Joueurs.get(i), player, pioche, listeTuiles, tourSuivant, lastTile);
								System.out.println("\nVoici le terrain de l'IA : \n");
								debut2Joueurs.get(i).getboard().print();
								System.out.println("L'IA possède un score de : "
										+ debut2Joueurs.get(i).getboard().copy().score() + " points!\n");
								nbValide = false;
							}
						} catch (InputMismatchException e) {
							System.out.println("Ce n'est pas un chiffre ! Veuillez réessayer :");
							scan.nextLine();
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Ce chiffre n'est pas valide  ! Veuillez réessayer :");
							scan.nextLine();
						}
					} while (nbValide);
				}
				if (!debut2Joueurs.get(3).getIA()) {
					System.out.println(
							"\n" + debut2Joueurs.get(3).getname() + " c'est à ton tour. Voici la dernière tuile :\n");
					afficheTuile(triTuile(listeTuiles));
					if (debut2Joueurs.get(3).getboard().canPlay(listeTuiles.get(lastTile - 1))) {
						play(debut2Joueurs.get(3), listeTuiles.get(lastTile - 1), modeDeJeu);
						System.out
								.println("\n" + debut2Joueurs.get(3).getname() + " tu possèdes maintenant un score de "
										+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
						listeTuiles.set(lastTile - 1, tileEmpty);
						tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
					} else {
						System.out.println(
								"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
										+ debut2Joueurs.get(3).getboard().copy().score() + " points!\n");
						listeTuiles.set(lastTile - 1, tileEmpty);
						tourSuivant.set(lastTile - 1, debut2Joueurs.get(3));
					}
				} else {
					lastTile = playIAbis(debut2Joueurs.get(3), player, pioche, listeTuiles, tourSuivant, lastTile);
					System.out.println("\nVoici le terrain de l'IA : \n");
					debut2Joueurs.get(3).getboard().print();
					System.out.println("L'IA possède un score de : " + debut2Joueurs.get(3).getboard().copy().score()
							+ " points!\n");
				}

				debut2Joueurs = tourSuivant;
				nbTour += 1;
			}
			int newScore = player.getboard().copy().score();
			int newScoreIA = ia.getboard().copy().score();
			int domaineMax = player.getboard().domaineMax();
			int domaineMaxIA = ia.getboard().domaineMax();
			int nbCouronnes = player.getboard().nbCouronnes();
			int nbCouronnesIA = ia.getboard().nbCouronnes();
			scoresPlayer[0] += newScore;
			scoresPlayerIA[0] += newScoreIA;
			scoresPlayer[1] += domaineMax;
			scoresPlayerIA[1] += domaineMaxIA;
			scoresPlayer[2] += nbCouronnes;
			scoresPlayerIA[2] += nbCouronnesIA;
			if (modeDeJeu.equals("Dynastie")) {
				System.out.println("Fin de la partie " + (ruler + 1) + "!");
				Board emptyBoard = new Board(boardSize);
				Board emptyBoardIA = new Board(boardSize);
				player.setboard(emptyBoard);
				ia.setboard(emptyBoardIA);
				nbTour = 1;
			}
		}
		int[] newScoresPlayer = { scoresPlayer[0], scoresPlayer[1], scoresPlayer[2] };
		int[] newScoresPlayerIA = { scoresPlayerIA[0], scoresPlayerIA[1], scoresPlayerIA[2] };
		player.setscores(newScoresPlayer);
		ia.setscores(newScoresPlayerIA);
		if (modeDeJeu.equals("Harmonie")) {
			if (player.getboard().complet()) {
				scoresPlayer[0] += 5;
			}
			if (ia.getboard().complet()) {
				scoresPlayerIA[0] += 5;
			}
			int[] newNewScoresPlayer = { scoresPlayer[0], scoresPlayer[1], scoresPlayer[2] };
			int[] newNewScoresPlayerIA = { scoresPlayerIA[0], scoresPlayerIA[1], scoresPlayerIA[2] };
			player.setscores(newNewScoresPlayer);
			ia.setscores(newNewScoresPlayerIA);
			printClassement2(player, ia);
		} else if (modeDeJeu.equals("Empire du milieu")) {
			if (player.getboard().estAuMilieu()) {
				scoresPlayer[0] += 10;
			}
			if (ia.getboard().estAuMilieu()) {
				scoresPlayerIA[0] += 10;
			}
			int[] newNewScoresPlayer = { scoresPlayer[0], scoresPlayer[1], scoresPlayer[2] };
			int[] newNewScoresPlayerIA = { scoresPlayerIA[0], scoresPlayerIA[1], scoresPlayerIA[2] };
			player.setscores(newNewScoresPlayer);
			ia.setscores(newNewScoresPlayerIA);
			printClassement2(player, ia);
		} else {
			printClassement2(player, ia);
		}
		System.out.println("\n\nFin de la partie!");
		scan.close();
	}*/

	public static void playIA(Player player, Domino tile) {
		int[] coordonnees = player.choosemove(tile);
		int nbCouronnes1 = tile.getcrown1();
		int nbCouronnes2 = tile.getcrown2();
		if (player.choosemove(tile)[0] == -1) {
			System.out.println("L'IA a été contrainte de défausser son domino!");
		} else if (player.getboard().jouable(tile, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3])) {
			if (nbCouronnes1 == 0 && nbCouronnes2 == 0) {
				System.out.println(("L'IA a joué " + tile.gettile1() + " en (" + coordonnees[0] + ";" + coordonnees[1]
						+ ") et " + tile.gettile2() + " en (" + coordonnees[2] + ";" + coordonnees[3] + ")"));
			} else if (nbCouronnes1 > 0 && nbCouronnes2 == 0) {
				System.out.println(("L'IA a joué " + tile.getcrown1() + tile.gettile1() + " en (" + coordonnees[0] + ";"
						+ coordonnees[1] + ") et " + tile.gettile2() + " en (" + coordonnees[2] + ";" + coordonnees[3]
						+ ")"));
			} else if (nbCouronnes1 == 0 && nbCouronnes2 > 0) {
				System.out.println(("L'IA a joué " + tile.gettile1() + " en (" + coordonnees[0] + ";" + coordonnees[1]
						+ ") et " + tile.getcrown2() + tile.gettile2() + " en (" + coordonnees[2] + ";" + coordonnees[3]
						+ ")"));
			} else {
				System.out.println(("L'IA a joué " + tile.getcrown1() + tile.gettile1() + " en (" + coordonnees[0] + ";"
						+ coordonnees[1] + ") et " + tile.getcrown2() + tile.gettile2() + " en (" + coordonnees[2] + ";"
						+ coordonnees[3] + ")"));
			}
			tile.inserttuile(player.getboard(), coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3]);
		} else {
			System.out.println("L'IA a été contrainte de défausser son domino!");
		}
	}

	public static int playIAbis(Player ia, Player opponent, ArrayList<Domino> pioche, ArrayList<Domino> selection,
			ArrayList<Player> tourSuivant, int lastTile) {
		Plateau board = ia.getboard();
		Domino emptyTile = new Domino(0, 0, 0, '#', '#');
		ArrayList<Integer> indexTileNotEmpty = indexTileNotEmpty(selection);
		if (indexTileNotEmpty.size() == 1) {
			Domino domino = selection.get(indexTileNotEmpty.get(0));
			if (board.canPlay(domino)) {
				System.out.println("hello11");
				Integer[] position = ia.choicePosition(domino);
				domino.inserttuile(board, position[0], position[1], position[2], position[3]);
				selection.set(indexTileNotEmpty.get(0), emptyTile);
				tourSuivant.set(indexTileNotEmpty.get(0), ia);
				lastTile = lastTile - (indexTileNotEmpty.get(0) + 1);
				System.out.println(lastTile);
				System.out.print("L'IA a joué cette tuile ");
				printTile(domino);
				System.out.print(
						"en " + "[" + position[0] + "," + position[1] + "," + position[2] + "," + position[3] + "]");
			} else {
				System.out.println("hello12");
				selection.set(indexTileNotEmpty.get(0), emptyTile);
				tourSuivant.set(indexTileNotEmpty.get(0), ia);
				lastTile = lastTile - (indexTileNotEmpty.get(0) + 1);
				System.out.println(lastTile);
				System.out.println("L'IA a été contrainte de défausser son domino!");
			}
		} else {
			ArrayList<Domino> listeDominosJouables = board.listeDominosJouables(selection);
			if (listeDominosJouables.size() == 0) {
				System.out.println("hello2");
				Plateau opponentBoard = opponent.getboard();
				ArrayList<Domino> listeDominosJouablesAdversaire = opponentBoard.listeDominosJouables(selection);
				if (listeDominosJouablesAdversaire.size() == 0) {
					System.out.println("hello21");
					selection.set(indexTileNotEmpty.get(0), emptyTile);
					tourSuivant.set(indexTileNotEmpty.get(0), ia);
					lastTile = lastTile - (indexTileNotEmpty.get(0) + 1);
					System.out.println(lastTile);
					System.out.println("L'IA a été contrainte de défausser son domino!");
				} else if (listeDominosJouablesAdversaire.size() == 1) {
					System.out.println("hello22");
					int index = listeDominosJouablesAdversaire.get(0).indexTile(selection);
					selection.set(index, emptyTile);
					tourSuivant.set(index, ia);
					lastTile = lastTile - (index + 1);
					System.out.println(lastTile);
					System.out.println("L'IA a été contrainte de défausser son domino!");
				} else {
					System.out.println("hello23");
					int choice = opponent.takeBestOpponentDomino(selection);
					selection.set(choice, emptyTile);
					tourSuivant.set(choice, ia);
					lastTile = lastTile - (choice + 1);
					System.out.println(lastTile);
					System.out.println("L'IA a été contrainte de défausser son domino!");
				}

			} else if (listeDominosJouables.size() == 1) {
				System.out.println("hello3");
				int index = listeDominosJouables.get(0).indexTile(selection);
				Domino domino = selection.get(index);
				Integer[] position = ia.choicePosition(domino);
				domino.inserttuile(board, position[0], position[1], position[2], position[3]);
				selection.set(index, emptyTile);
				tourSuivant.set(index, ia);
				lastTile = lastTile - (index + 1);
				System.out.println(lastTile);
				System.out.print("L'IA a joué cette tuile ");
				printTile(domino);
				System.out.print(
						"en " + "[" + position[0] + "," + position[1] + "," + position[2] + "," + position[3] + "]");
			} else {
				System.out.println("hello4");
				int choiceDomino = choiceDomino(pioche, selection);
				Domino domino = selection.get(choiceDomino);
				int index = domino.indexTile(selection);
				Integer[] position = ia.choicePosition(domino);
				domino.inserttuile(board, position[0], position[1], position[2], position[3]);
				selection.set(index, emptyTile);
				tourSuivant.set(index, ia);
				lastTile = lastTile - (index + 1);
				System.out.println(lastTile);
				System.out.print("L'IA a joué cette tuile ");
				printTile(domino);
				System.out.print(
						"en " + "[" + position[0] + "," + position[1] + "," + position[2] + "," + position[3] + "]");
			}
		}
		return lastTile;
	}

	public static void printMovePlayable(ArrayList<Integer[]> listMovePlayable) {
		for (int i = 0; i < listMovePlayable.size(); i++) {
			Integer[] position = listMovePlayable.get(i);
			System.out.println("[" + position[0] + "," + position[1] + "," + position[2] + "," + position[3] + "] ");
		}
	}

	public static boolean notIn(Integer[] position, ArrayList<Integer[]> listMovePlayable) {
		for (int i = 0; i < listMovePlayable.size(); i++) {
			Integer[] pos = listMovePlayable.get(i);
			if (pos[0] == position[0] && pos[1] == position[1] && pos[2] == position[2] && pos[3] == position[3]) {
				return false;
			}
		}
		return true;
	}

	public static int choiceDomino(ArrayList<Domino> pioche, ArrayList<Domino> selection) {
		ArrayList<Coeff> evaluationPioche = evaluationPioche(pioche);
		ArrayList<Double> listeCoeffs = new ArrayList<Double>();
		for (int i = 0; i < selection.size(); i++) {
			if (emptyTuile(selection.get(i))) {
				listeCoeffs.add(-1.0);
			} else {
				Domino domino = selection.get(i);
				double coeff = domino.sommeCoeffs(evaluationPioche);
				listeCoeffs.add(coeff);
			}
		}
		double coeff = lastCoeff(triCoeffs(listeCoeffs));
		for (int i = 0; i < selection.size(); i++) {
			Domino domino = selection.get(i);
			if (!emptyTuile(domino)) {
				if (coeff == domino.sommeCoeffs(evaluationPioche)) {
					return i;
				}
			}
		}
		return -1;
	}

	public static double lastCoeff(ArrayList<Double> listeCoeffs) {
		int longueur = listeCoeffs.size();
		for (int i = 0; i < longueur; i++) {
			if (listeCoeffs.get(longueur - (i + 1)) != -1.0) {
				return listeCoeffs.get(longueur - (i + 1));
			}
		}
		return -1.0;
	}

	public static int nbNegatif(ArrayList<Double> listeCoeffs) {
		int nbNegatif = 0;
		for (int i = 0; i < listeCoeffs.size(); i++) {
			if (listeCoeffs.get(i) == -1.0) {
				nbNegatif += 1;
			}
		}
		return nbNegatif;
	}

	public static ArrayList<Integer> listIndexPositive(ArrayList<Double> listeCoeffs) {
		ArrayList<Integer> listIndexPositive = new ArrayList<Integer>();
		for (int i = 0; i < listeCoeffs.size(); i++) {
			if (listeCoeffs.get(i) != -1.0) {
				listIndexPositive.add(i);
			}
		}
		return listIndexPositive;
	}

	public static boolean estTrieeCoeffs(ArrayList<Double> listeCoeffs) {
		if (nbNegatif(listeCoeffs) > listeCoeffs.size() - 2) {
			return true;
		} else {
			ArrayList<Integer> listIndexPositive = listIndexPositive(listeCoeffs);
			for (int i = 0; i < listIndexPositive.size() - 1; i++) {
				int index1 = listIndexPositive.get(i);
				int index2 = listIndexPositive.get(i + 1);
				if (listeCoeffs.get(index1) > listeCoeffs.get(index2)) {
					return false;
				}
			}
		}
		return true;
	}

	public static ArrayList<Double> triCoeffs(ArrayList<Double> listeCoeffs) {
		if (nbNegatif(listeCoeffs) > listeCoeffs.size() - 2) {
			return listeCoeffs;
		} else {
			while (!estTrieeCoeffs(listeCoeffs)) {
				ArrayList<Integer> listIndexPositive = listIndexPositive(listeCoeffs);
				for (int i = 0; i < listIndexPositive.size() - 1; i++) {
					int index1 = listIndexPositive.get(i);
					int index2 = listIndexPositive.get(i + 1);
					if (listeCoeffs.get(index1) > listeCoeffs.get(index2)) {
						double coeff1 = listeCoeffs.get(index1);
						double coeff2 = listeCoeffs.get(index2);
						listeCoeffs.set(index1, coeff2);
						listeCoeffs.set(index2, coeff1);
					}
				}
			}
		}
		return listeCoeffs;
	}

	public static void afficheListeCoeffs(ArrayList<Double> listeCoeffs) {
		for (int i = 0; i < listeCoeffs.size(); i++) {
			System.out.print(listeCoeffs.get(i) + " ; ");
		}
	}

	public static ArrayList<Integer> indexTileNotEmpty(ArrayList<Domino> selection) {
		ArrayList<Integer> indexTileNotEmpty = new ArrayList<Integer>();
		for (int i = 0; i < selection.size(); i++) {
			if (!emptyTuile(selection.get(i))) {
				indexTileNotEmpty.add(i);
			}
		}
		return indexTileNotEmpty;
	}

	public static ArrayList<Domino> newSelection(ArrayList<Domino> selection) {
		ArrayList<Domino> newSelection = new ArrayList<Domino>();
		for (int i = 0; i < selection.size(); i++) {
			if (!emptyTuile(selection.get(i))) {
				newSelection.add(selection.get(i));
			}
		}
		return newSelection;
	}

	public static ArrayList<Coeff> evaluationPioche(ArrayList<Domino> pioche) {
		ArrayList<Coeff> listeCoeffs = new ArrayList<Coeff>();
		double nbDominos = pioche.size();
		double nbCouronnesW = nbCouronnesParCases(pioche, 'W');
		double nbCouronnesP = nbCouronnesParCases(pioche, 'P');
		double nbCouronnesQ = nbCouronnesParCases(pioche, 'Q');
		double nbCouronnesL = nbCouronnesParCases(pioche, 'L');
		double nbCouronnesM = nbCouronnesParCases(pioche, 'M');
		double nbCouronnesF = nbCouronnesParCases(pioche, 'F');
		double coeffW = nbCouronnesW / nbDominos;
		double coeffP = nbCouronnesP / nbDominos;
		double coeffQ = nbCouronnesQ / nbDominos;
		double coeffL = nbCouronnesL / nbDominos;
		double coeffM = nbCouronnesM / nbDominos;
		double coeffF = nbCouronnesF / nbDominos;
		char[] listeChar = { 'W', 'P', 'Q', 'L', 'M', 'F' };
		double[] listeCoeff = { coeffW, coeffP, coeffQ, coeffL, coeffM, coeffF };
		for (int i = 0; i < listeChar.length; i++) {
			Coeff coeff = new Coeff(listeChar[i], listeCoeff[i]);
			listeCoeffs.add(coeff);
		}
		return listeCoeffs;
	}

	public static int nbCouronnesParCases(ArrayList<Domino> pioche, char nature) {
		int nbCouronnes = 0;
		for (int i = 0; i < pioche.size(); i++) {
			Domino tuile = pioche.get(i);
			if (tuile.gettile1() == nature) {
				nbCouronnes += tuile.getcrown1();
			}
			if (tuile.gettile2() == nature) {
				nbCouronnes += tuile.getcrown2();
			}
		}
		return nbCouronnes;
	}

	public static void afficheCoeffs(ArrayList<Coeff> listeCoeffs) {
		for (int i = 0; i < listeCoeffs.size(); i++) {
			listeCoeffs.get(i).afficheCoeff();
		}
	}

	public static boolean estTrieeListeCoeffs(ArrayList<Coeff> listeCoeffs) {
		for (int i = 0; i < listeCoeffs.size() - 1; i++) {
			if (listeCoeffs.get(i).getCoeff() < listeCoeffs.get(i + 1).getCoeff()) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Coeff> triListeCoeffs(ArrayList<Coeff> listeCoeffs) {
		while (!estTrieeListeCoeffs(listeCoeffs)) {
			for (int i = 0; i < listeCoeffs.size() - 1; i++) {
				if (listeCoeffs.get(i).getCoeff() < listeCoeffs.get(i + 1).getCoeff()) {
					Coeff coeff = listeCoeffs.get(i + 1);
					listeCoeffs.remove(i + 1);
					listeCoeffs.add(i, coeff);
				}
			}
		}
		return listeCoeffs;
	}
	
}