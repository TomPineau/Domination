import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainGraphics {
	static ArrayList<Domino> liste = new Data().getDeck();
	static Image imageF;
	static Image imageL;
	static Image imageM;
	static Image imageP;
	static Image imageQ;
	static Image imageW;
	static Image imageredC;
	static Image imageblueC;
	static Image imagegreenC;
	static Image imageyellowC;
	static int choixTuile;
	static boolean case1Selected = false, case2Selected = false;
	static int x1, x2, y1, y2;
	static Color fond = new Color(238, 231, 188);

	static {
		try {
			imageF = ImageIO.read(new File("F.jpg"));
			imageL = ImageIO.read(new File("L.jpg"));
			imageM = ImageIO.read(new File("M.jpg"));
			imageP = ImageIO.read(new File("P.jpg"));
			imageQ = ImageIO.read(new File("Q.jpg"));
			imageW = ImageIO.read(new File("W.jpg"));
			imageredC = ImageIO.read(new File("redC.png"));
			imageblueC = ImageIO.read(new File("blueC.png"));
			imagegreenC = ImageIO.read(new File("greenC.png"));
			imageyellowC = ImageIO.read(new File("yellowC.png"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("King Domination");
		fenetre.setSize(300, 100);
		fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.getContentPane().setLayout(new FlowLayout());
		Menu menu = new Menu(null, "Menu", true);
		PassValue valeur = menu.passe();
		String nbJoueurs = valeur.getInfo()[0];
		if (nbJoueurs.equals("1")) {
			onePlayer(valeur.getInfo()[1]);
		} else if (nbJoueurs.equals("2")) {
			twoPlayers(valeur.getInfo()[1]);
		} else if (nbJoueurs.equals("3")) {
			threePlayers(valeur.getInfo()[1]);
		} else if (nbJoueurs.equals("4")) {
			fourPlayers(valeur.getInfo()[1]);
		}
	}

	public static void onePlayer(String modeDeJeu) {
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
		String namePlayer = JOptionPane.showInputDialog(null, "Nom du Joueur Bleu", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		if (namePlayer == null || namePlayer.equals("")) {
			namePlayer = "Player 1";
		}
		String nameIA = "HAL";
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer = new Plateau(boardSize);
		Plateau boardPlayerIA = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player = new Player(namePlayer, boardPlayer);
		Player ia = new Player(nameIA, boardPlayerIA);
		ia.setIA(true);
		player.setColor(1);
		ia.setColor(2);
		ArrayList<Player> debut2Joueurs = debut2Players(player, ia);
		int[] scoresPlayer = new int[3];
		int[] scoresPlayerIA = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu.equals("Dynastie")) {
				nbParties = 3;
				JOptionPane.showMessageDialog(null, "Début de la partie " + (ruler + 1), "Début",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Début de la partie ", "Début", JOptionPane.INFORMATION_MESSAGE);
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			int[] valuesPWFLQM = crownsPWFLQM(liste);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut2Players(player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				JOptionPane.showMessageDialog(null,
						"Tour " + nbTour + ":\nLes joueurs commenceront dans cet ordre :\n"
								+ debut2Joueurs.get(0).getname() + ", " + debut2Joueurs.get(1).getname() + ", "
								+ debut2Joueurs.get(2).getname() + ", " + debut2Joueurs.get(3).getname(),
						"Tour", JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < 4; i++) {
					boolean nbValide = true;
					do {
						Plateau displayBoard = debut2Joueurs.get(i).getboard();
						String name = debut2Joueurs.get(i).getname();
						JFrame fenetre = new JFrame();
						displayFenetre(fenetre, displayBoard, triTuile(listeTuiles), name,
								debut2Joueurs.get(i).getColor(), modeDeJeu);
						if (!debut2Joueurs.get(i).getIA()) {
							fenetre.addMouseListener(new MouseListener() {
								public void mousePressed(MouseEvent e) {
									int longueurBoard = 9;
									int longueurCase = 70;
									if (modeDeJeu.equals("Le Grand Duel")) {
										longueurBoard = 13;
										longueurCase = 48;
									}
									int x = e.getX();
									int y = e.getY();
									if (x >= 100 && x <= 240) {
										for (int i = 0; i < listeTuiles.size(); i++) {
											if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
												choixTuile = i + 1;
											}
										}
									}
									if (choixTuile != 0) {
										for (int i = 0; i < longueurBoard; i++) {
											for (int j = 0; j < longueurBoard; j++) {
												if (x >= 400 + longueurCase * j && x <= 400 + longueurCase * (j + 1)) {
													if (y >= 60 + longueurCase * i
															&& y <= 60 + longueurCase * (i + 1)) {
														if (!case1Selected) {
															x1 = i;
															y1 = j;
															case1Selected = true;
														} else if (!case2Selected) {
															x2 = i;
															y2 = j;
															case2Selected = true;
														}
													}
												}
											}
										}
									}
								}

								public void mouseReleased(MouseEvent e) {
								}

								public void mouseEntered(MouseEvent e) {
								}

								public void mouseExited(MouseEvent e) {
								}

								public void mouseClicked(MouseEvent e) {
								}
							});

							while (choixTuile == 0) {
								try {
									TimeUnit.MILLISECONDS.sleep(20);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} else {
							try {
								TimeUnit.SECONDS.sleep(2);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (!debut2Joueurs.get(i).getIA()) {
							if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									JOptionPane.showMessageDialog(null,
											debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut2Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								} else {
									JOptionPane.showMessageDialog(null,
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(0, tileEmpty);
									tourSuivant.set(0, debut2Joueurs.get(i));
									lastTile = lastTile - 1;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									JOptionPane.showMessageDialog(null,
											debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut2Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								} else {
									JOptionPane.showMessageDialog(null,
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(1, tileEmpty);
									tourSuivant.set(1, debut2Joueurs.get(i));
									lastTile = lastTile - 2;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									JOptionPane.showMessageDialog(null,
											debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut2Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								} else {
									JOptionPane.showMessageDialog(null,
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(2, tileEmpty);
									tourSuivant.set(2, debut2Joueurs.get(i));
									lastTile = lastTile - 3;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								}
							} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
								if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
									play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
									JOptionPane.showMessageDialog(null,
											debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut2Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								} else {
									JOptionPane.showMessageDialog(null,
											"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);
									listeTuiles.set(3, tileEmpty);
									tourSuivant.set(3, debut2Joueurs.get(i));
									lastTile = lastTile - 4;
									nbValide = false;
									choixTuile = 0;
									case1Selected = false;
									case2Selected = false;
								}
							} else {
								choixTuile = 0;
								fenetre.dispose();
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
							playIA(debut2Joueurs.get(i), listeTuiles.get(choixTuile));
							listeTuiles.set(choixTuile, tileEmpty);
							tourSuivant.set(choixTuile, debut2Joueurs.get(i));
							lastTile = lastTile - (choixTuile + 1);
							nbValide = false;
							choixTuile = 0;
							case1Selected = false;
							case2Selected = false;
							displayFenetre(fenetre, displayBoard, triTuile(listeTuiles), name,
									debut2Joueurs.get(i).getColor(), modeDeJeu);
							fenetre.setBackground(fond);
							try {
								TimeUnit.SECONDS.sleep(3);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							JOptionPane
									.showMessageDialog(null,
											"L'IA possède un score de : "
													+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
											"Score", JOptionPane.INFORMATION_MESSAGE);

						}
						fenetre.dispose();
					} while (nbValide);
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
				JOptionPane.showMessageDialog(null, "Fin de la partie " + (ruler + 1) + "!", "Fin",
						JOptionPane.INFORMATION_MESSAGE);
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
		JOptionPane.showMessageDialog(null, "Fin de la partie!", "Fin", JOptionPane.INFORMATION_MESSAGE);
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

	public static void playIA(Player player, Domino tile) {
		int[] coordonnees = player.choosemove(tile);
		if (player.choosemove(tile)[0] != -1) {
			if (player.getboard().jouable(tile, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3])) {
				tile.inserttuile(player.getboard(), coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3]);
			}
		} else {
			JOptionPane.showMessageDialog(null, "L'IA est contrainte de défausser son domino!", "Erreur",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void twoPlayers(String modeDeJeu) {
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 24;
		if (modeDeJeu.equals("Dynastie")) {
			nbParties = 3;
		} else if (modeDeJeu.equals("Le Grand Duel")) {
			boardSize = 13;
			nbDominos = 48;
		}
		String namePlayer1 = JOptionPane.showInputDialog(null, "Nom du Joueur Bleu", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		String namePlayer2 = JOptionPane.showInputDialog(null, "Nom du Joueur Vert", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		if (namePlayer1 == null || namePlayer1.equals("")) {
			namePlayer1 = "Player 1";
		}
		if (namePlayer2 == null || namePlayer2.equals("")) {
			namePlayer2 = "Player 2";
		}
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer1 = new Plateau(boardSize);
		Plateau boardPlayer2 = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player1 = new Player(namePlayer1, boardPlayer1);
		Player player2 = new Player(namePlayer2, boardPlayer2);
		player1.setColor(1);
		player2.setColor(2);

		ArrayList<Player> debut2Joueurs = debut2Players(player1, player2);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu.equals("Dynastie")) {
				JOptionPane.showMessageDialog(null, "Début de la partie " + (ruler + 1), "Début",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Début de la partie ", "Début", JOptionPane.INFORMATION_MESSAGE);
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);

			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut2Players(player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				JOptionPane.showMessageDialog(null,
						"Tour " + nbTour + " :\nLes joueurs commenceront dans cet ordre :\n"
								+ debut2Joueurs.get(0).getname() + ", " + debut2Joueurs.get(1).getname() + ", "
								+ debut2Joueurs.get(2).getname() + ", " + debut2Joueurs.get(3).getname(),
						"Tour", JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < 4; i++) {
					boolean nbValide = true;
					do {
						Plateau displayBoard = debut2Joueurs.get(i).getboard();
						String name = debut2Joueurs.get(i).getname();
						JFrame fenetre = new JFrame();
						displayFenetre(fenetre, displayBoard, triTuile(listeTuiles), name,
								debut2Joueurs.get(i).getColor(), modeDeJeu);
						fenetre.addMouseListener(new MouseListener() {
							public void mousePressed(MouseEvent e) {
								int longueurBoard = 9;
								int longueurCase = 70;
								if (modeDeJeu.equals("Le Grand Duel")) {
									longueurBoard = 13;
									longueurCase = 48;
								}
								int x = e.getX();
								int y = e.getY();
								if (x >= 100 && x <= 240) {
									for (int i = 0; i < listeTuiles.size(); i++) {
										if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
											choixTuile = i + 1;
										}
									}
								}
								if (choixTuile != 0) {
									for (int i = 0; i < longueurBoard; i++) {
										for (int j = 0; j < longueurBoard; j++) {
											if (x >= 400 + longueurCase * j && x <= 400 + longueurCase * (j + 1)) {
												if (y >= 60 + longueurCase * i && y <= 60 + longueurCase * (i + 1)) {
													if (!case1Selected) {
														x1 = i;
														y1 = j;
														case1Selected = true;
													} else if (!case2Selected) {
														x2 = i;
														y2 = j;
														case2Selected = true;
													}
												}
											}
										}
									}
								}
							}

							public void mouseReleased(MouseEvent e) {
							}

							public void mouseEntered(MouseEvent e) {
							}

							public void mouseExited(MouseEvent e) {
							}

							public void mouseClicked(MouseEvent e) {
							}
						});

						while (choixTuile == 0) {
							try {
								TimeUnit.MILLISECONDS.sleep(20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
							if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {

								play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(0, tileEmpty);
								tourSuivant.set(0, debut2Joueurs.get(i));
								lastTile = lastTile - 1;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(0, tileEmpty);
								listeTuiles.set(0, tileEmpty);
								tourSuivant.set(0, debut2Joueurs.get(i));
								lastTile = lastTile - 1;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
							fenetre.dispose();
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
							if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(1, tileEmpty);
								tourSuivant.set(1, debut2Joueurs.get(i));
								lastTile = lastTile - 2;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(1, tileEmpty);
								tourSuivant.set(1, debut2Joueurs.get(i));
								lastTile = lastTile - 2;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
							fenetre.dispose();
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
							if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(2, tileEmpty);
								tourSuivant.set(2, debut2Joueurs.get(i));
								lastTile = lastTile - 3;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(2, tileEmpty);
								tourSuivant.set(2, debut2Joueurs.get(i));
								lastTile = lastTile - 3;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
							fenetre.dispose();
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
							if (debut2Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut2Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										debut2Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(3, tileEmpty);
								tourSuivant.set(3, debut2Joueurs.get(i));
								lastTile = lastTile - 4;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut2Joueurs.get(i).getboard().copy().score() + " points!",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(3, tileEmpty);
								tourSuivant.set(3, debut2Joueurs.get(i));
								lastTile = lastTile - 4;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
							fenetre.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Cette tuile ne peut être prise ! Veuillez réessayer :",
									"Erreur", JOptionPane.INFORMATION_MESSAGE);
							choixTuile = 0;
							fenetre.dispose();
						}
					} while (nbValide);
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
			if (modeDeJeu.equals("Dynastie")) {
				JOptionPane.showMessageDialog(null, "Fin de la partie " + (ruler + 1) + "!", "Fin",
						JOptionPane.INFORMATION_MESSAGE);
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
		switch (modeDeJeu) {
		case "Harmonie": {
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
			break;
		}
		case "Empire du milieu": {
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
			break;
		}
		default:
			printClassement2(player1, player2);
			break;
		}
		JOptionPane.showMessageDialog(null, "Fin de la partie!", "Fin", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void displayFenetre(JFrame fenetre, Plateau displayBoard, ArrayList<Domino> tuiles, String name,
			int color, String modeDeJeu) {
		fenetre.setTitle(name);
		fenetre.setSize(1080, 720);
		JPanel p = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				affichePlateau(g, displayBoard, color, modeDeJeu);
				afficheDomino(g, tuiles);
			}

		};
		fenetre.setBackground(fond);
		fenetre.add(p);
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
	}

	public static void threePlayers(String modeDeJeu) {
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 36;
		if (modeDeJeu.equals("Dynastie")) {
			nbParties = 3;
		}
		String namePlayer1 = JOptionPane.showInputDialog(null, "Nom du Joueur Bleu", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		String namePlayer2 = JOptionPane.showInputDialog(null, "Nom du Joueur Vert", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		String namePlayer3 = JOptionPane.showInputDialog(null, "Nom du Joueur Jaune", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		if (namePlayer1 == null || namePlayer1.equals("")) {
			namePlayer1 = "Player 1";
		}
		if (namePlayer2 == null || namePlayer2.equals("")) {
			namePlayer2 = "Player 2";
		}
		if (namePlayer3 == null || namePlayer3.equals("")) {
			namePlayer3 = "Player 3";
		}
		Plateau boardPlayer0 = new Plateau(boardSize);
		Plateau boardPlayer1 = new Plateau(boardSize);
		Plateau boardPlayer2 = new Plateau(boardSize);
		Plateau boardPlayer3 = new Plateau(boardSize);
		Player player0 = new Player("player0", boardPlayer0);
		Player player1 = new Player(namePlayer1, boardPlayer1);
		Player player2 = new Player(namePlayer2, boardPlayer2);
		Player player3 = new Player(namePlayer3, boardPlayer3);
		player1.setColor(1);
		player2.setColor(2);
		player3.setColor(3);
		ArrayList<Player> debut3Joueurs = debut3Players(player1, player2, player3);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		int[] scoresPlayer3 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu.equals("Dynastie")) {
				JOptionPane.showMessageDialog(null, "Début de la partie " + (ruler + 1) + " :\n", "Début",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Début de la partie :\n", "Début", JOptionPane.INFORMATION_MESSAGE);
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 3);
				ArrayList<Player> tourSuivant = debut3Players(player0, player0, player0);
				int lastTile = 6;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				JOptionPane.showMessageDialog(null,
						"Tour " + nbTour + ":\nLes joueurs commenceront dans cet ordre :\n"
								+ debut3Joueurs.get(0).getname() + ", " + debut3Joueurs.get(1).getname() + ", "
								+ debut3Joueurs.get(2).getname(),
						"Tour", JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < 3; i++) {
					boolean nbValide = true;
					do {
						Plateau displayBoard = debut3Joueurs.get(i).getboard();
						String name = debut3Joueurs.get(i).getname();
						JFrame fenetre = new JFrame();
						displayFenetre(fenetre, displayBoard, triTuile(listeTuiles), name,
								debut3Joueurs.get(i).getColor(), modeDeJeu);
						fenetre.addMouseListener(new MouseListener() {
							public void mousePressed(MouseEvent e) {
								int longueurBoard = 9;
								int longueurCase = 70;
								if (modeDeJeu.equals("Le Grand Duel")) {
									longueurBoard = 13;
									longueurCase = 48;
								}
								int x = e.getX();
								int y = e.getY();
								if (x >= 100 && x <= 240) {
									for (int i = 0; i < listeTuiles.size(); i++) {
										if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
											choixTuile = i + 1;
										}
									}
								}
								if (choixTuile != 0) {
									for (int i = 0; i < longueurBoard; i++) {
										for (int j = 0; j < longueurBoard; j++) {
											if (x >= 400 + longueurCase * j && x <= 400 + longueurCase * (j + 1)) {
												if (y >= 60 + longueurCase * i && y <= 60 + longueurCase * (i + 1)) {
													if (!case1Selected) {
														x1 = i;
														y1 = j;
														case1Selected = true;
													} else if (!case2Selected) {
														x2 = i;
														y2 = j;
														case2Selected = true;
													}
												}
											}
										}
									}
								}
							}

							public void mouseReleased(MouseEvent e) {
							}

							public void mouseEntered(MouseEvent e) {
							}

							public void mouseExited(MouseEvent e) {
							}

							public void mouseClicked(MouseEvent e) {
							}
						});

						while (choixTuile == 0) {
							try {
								TimeUnit.MILLISECONDS.sleep(20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
							if (debut3Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut3Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut3Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(0, tileEmpty);
								tourSuivant.set(0, debut3Joueurs.get(i));
								lastTile = lastTile - 1;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(0, tileEmpty);
								tourSuivant.set(0, debut3Joueurs.get(i));
								lastTile = lastTile - 1;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
							if (debut3Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut3Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut3Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(1, tileEmpty);
								tourSuivant.set(1, debut3Joueurs.get(i));
								lastTile = lastTile - 2;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showInputDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(1, tileEmpty);
								tourSuivant.set(1, debut3Joueurs.get(i));
								lastTile = lastTile - 2;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
							if (debut3Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut3Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut3Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(2, tileEmpty);
								tourSuivant.set(2, debut3Joueurs.get(i));
								lastTile = lastTile - 3;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut3Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(2, tileEmpty);
								tourSuivant.set(2, debut3Joueurs.get(i));
								lastTile = lastTile - 3;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Cette tuile ne peut être prise ! Veuillez réessayer :",
									"Erreur", JOptionPane.INFORMATION_MESSAGE);
							choixTuile = 0;
							case1Selected = false;
							case2Selected = false;
						}
						fenetre.dispose();
					} while (nbValide);

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
			if (modeDeJeu.equals("Dynastie")) {
				JOptionPane.showMessageDialog(null, "Fin de la partie " + (ruler + 1) + "!", "Fin",
						JOptionPane.INFORMATION_MESSAGE);
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
		if (modeDeJeu.equals("Harmonie")) {
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
		} else if (modeDeJeu.equals("Empire du milieu")) {
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
		JOptionPane.showMessageDialog(null, "Fin de la partie!", "Fin", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void fourPlayers(String modeDeJeu) {
		int nbTour = 1;
		int boardSize = 9;
		int nbParties = 1;
		int nbDominos = 48;
		if (modeDeJeu.equals("Dynastie")) {
			nbParties = 3;
		}
		String namePlayer1 = JOptionPane.showInputDialog(null, "Nom du Joueur Bleu", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		String namePlayer2 = JOptionPane.showInputDialog(null, "Nom du Joueur Vert", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		String namePlayer3 = JOptionPane.showInputDialog(null, "Nom du Joueur Jaune", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		String namePlayer4 = JOptionPane.showInputDialog(null, "Nom du Joueur Rouge", "Joueurs",
				JOptionPane.QUESTION_MESSAGE);
		if (namePlayer1 == null || namePlayer1.equals("")) {
			namePlayer1 = "Player 1";
		}
		if (namePlayer2 == null || namePlayer2.equals("")) {
			namePlayer2 = "Player 2";
		}
		if (namePlayer3 == null || namePlayer3.equals("")) {
			namePlayer3 = "Player 3";
		}
		if (namePlayer4 == null || namePlayer4.equals("")) {
			namePlayer4 = "Player 4";
		}
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
		player1.setColor(1);
		player2.setColor(2);
		player3.setColor(3);
		player4.setColor(4);
		ArrayList<Player> debut4Joueurs = debut4Players(player1, player2, player3, player4);
		int[] scoresPlayer1 = new int[3];
		int[] scoresPlayer2 = new int[3];
		int[] scoresPlayer3 = new int[3];
		int[] scoresPlayer4 = new int[3];
		for (int ruler = 0; ruler < nbParties; ruler++) {
			if (modeDeJeu.equals("Dynastie")) {
				JOptionPane.showMessageDialog(null, "Début de la partie " + (ruler + 1) + " :\n", "Début",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Début de la partie :\n", "Début", JOptionPane.INFORMATION_MESSAGE);
			}
			ArrayList<Domino> pioche = tirage(liste, nbDominos);
			while (!endGame(pioche)) {
				ArrayList<Domino> listeTuiles = listeTuiles(pioche, 4);
				ArrayList<Player> tourSuivant = debut4Players(player0, player0, player0, player0);
				int lastTile = 10;
				Domino tileEmpty = new Domino(0, 0, 0, '#', '#');
				JOptionPane.showMessageDialog(null,
						"Tour " + nbTour + ":\nLes joueurs commenceront dans cet ordre :\n"
								+ debut4Joueurs.get(0).getname() + ", " + debut4Joueurs.get(1).getname() + ", "
								+ debut4Joueurs.get(2).getname() + ", " + debut4Joueurs.get(3).getname(),
						"Tour", JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < 4; i++) {
					boolean nbValide = true;
					do {
						Plateau displayBoard = debut4Joueurs.get(i).getboard();
						String name = debut4Joueurs.get(i).getname();
						JFrame fenetre = new JFrame();
						displayFenetre(fenetre, displayBoard, triTuile(listeTuiles), name,
								debut4Joueurs.get(i).getColor(), modeDeJeu);
						fenetre.addMouseListener(new MouseListener() {
							public void mousePressed(MouseEvent e) {
								int longueurBoard = 9;
								int longueurCase = 70;
								if (modeDeJeu.equals("Le Grand Duel")) {
									longueurBoard = 13;
									longueurCase = 48;
								}
								int x = e.getX();
								int y = e.getY();
								if (x >= 100 && x <= 240) {
									for (int i = 0; i < listeTuiles.size(); i++) {
										if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
											choixTuile = i + 1;
										}
									}
								}
								if (choixTuile != 0) {
									for (int i = 0; i < longueurBoard; i++) {
										for (int j = 0; j < longueurBoard; j++) {
											if (x >= 400 + longueurCase * j && x <= 400 + longueurCase * (j + 1)) {
												if (y >= 60 + longueurCase * i && y <= 60 + longueurCase * (i + 1)) {
													if (!case1Selected) {
														x1 = i;
														y1 = j;
														case1Selected = true;
													} else if (!case2Selected) {
														x2 = i;
														y2 = j;
														case2Selected = true;
													}
												}
											}
										}
									}
								}
							}

							public void mouseReleased(MouseEvent e) {
							}

							public void mouseEntered(MouseEvent e) {
							}

							public void mouseExited(MouseEvent e) {
							}

							public void mouseClicked(MouseEvent e) {
							}
						});

						while (choixTuile == 0) {
							try {
								TimeUnit.MILLISECONDS.sleep(20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 1) {
							if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut4Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(0, tileEmpty);
								tourSuivant.set(0, debut4Joueurs.get(i));
								lastTile = lastTile - 1;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(0, tileEmpty);
								tourSuivant.set(0, debut4Joueurs.get(i));
								lastTile = lastTile - 1;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 2) {
							if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut4Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(1, tileEmpty);
								tourSuivant.set(1, debut4Joueurs.get(i));
								lastTile = lastTile - 2;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(1, tileEmpty);
								tourSuivant.set(1, debut4Joueurs.get(i));
								lastTile = lastTile - 2;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 3) {
							if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut4Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(2, tileEmpty);
								tourSuivant.set(2, debut4Joueurs.get(i));
								lastTile = lastTile - 3;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(2, tileEmpty);
								tourSuivant.set(2, debut4Joueurs.get(i));
								lastTile = lastTile - 3;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else if (!emptyTuile(listeTuiles.get(choixTuile - 1)) && choixTuile == 4) {
							if (debut4Joueurs.get(i).getboard().canPlay(listeTuiles.get(choixTuile - 1))) {
								play(debut4Joueurs.get(i), listeTuiles.get(choixTuile - 1), modeDeJeu);
								JOptionPane.showMessageDialog(null,
										"\n" + debut4Joueurs.get(i).getname() + " tu possèdes maintenant un score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(3, tileEmpty);
								tourSuivant.set(3, debut4Joueurs.get(i));
								lastTile = lastTile - 4;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							} else {
								JOptionPane.showMessageDialog(null,
										"La tuile que tu as choisie ne peut être placée! Elle part à la poubelle! Tu conserves donc le score de "
												+ debut4Joueurs.get(i).getboard().copy().score() + " points!\n",
										"Score", JOptionPane.INFORMATION_MESSAGE);
								listeTuiles.set(3, tileEmpty);
								tourSuivant.set(3, debut4Joueurs.get(i));
								lastTile = lastTile - 4;
								nbValide = false;
								choixTuile = 0;
								case1Selected = false;
								case2Selected = false;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Cette tuile ne peut être prise ! Veuillez réessayer :",
									"Erreur", JOptionPane.INFORMATION_MESSAGE);
							choixTuile = 0;
							case1Selected = false;
							case2Selected = false;
						}
						fenetre.dispose();
					} while (nbValide);
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
			if (modeDeJeu.equals("Dynastie")) {
				JOptionPane.showMessageDialog(null, "Fin de la partie " + (ruler + 1) + "!", "Fin",
						JOptionPane.INFORMATION_MESSAGE);
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
		if (modeDeJeu.equals("Harmonie")) {
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
		} else if (modeDeJeu.equals("Empire du milieu")) {
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
		JOptionPane.showMessageDialog(null, "Fin de la partie!", "Fin", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void play(Player player, Domino tile, String modeDeJeu) {
		int nbCases = 8;
		if (modeDeJeu.equals("Le Grand Duel")) {
			nbCases = 12;
		}
		boolean jouable = true;
		do {
			while (!case1Selected || !case2Selected) {
				try {
					TimeUnit.MILLISECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			boolean x1Valide = true;
			boolean y1Valide = true;
			boolean x2Valide = true;
			boolean y2Valide = true;
			int[] coordonnees = new int[4];
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (x1 >= 0 && x1 <= nbCases) {
					coordonnees[0] = x1;
					x1Valide = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (x1Valide);
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (y1 >= 0 && y1 <= nbCases) {
					coordonnees[1] = y1;
					y1Valide = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (y1Valide);
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (x2 >= 0 && x2 <= nbCases) {
					coordonnees[2] = x2;
					x2Valide = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (x2Valide);
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (y2 >= 0 && y2 <= nbCases) {
					coordonnees[3] = y2;
					y2Valide = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (y2Valide);
			if (player.getboard().graphicJouable(tile, coordonnees[0], coordonnees[1], coordonnees[2],
					coordonnees[3])) {
				tile.inserttuile(player.getboard(), coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3]);
				jouable = false;
			} else {
				case1Selected = false;
				case2Selected = false;
			}
		} while (jouable);
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
			JOptionPane.showMessageDialog(null,
					"Le grand gagnant est " + player1.getname() + "!\nIl obtient un score de " + player1.getscores()[0]
							+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
							+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
							+ " couronnes!\nBravo à toi " + player1.getname() + "!\n",
					"Gagnant", JOptionPane.INFORMATION_MESSAGE);
		} else if (listeWinners.size() == 2) {
			Player player1 = listeWinners.get(0);
			Player player2 = listeWinners.get(1);
			JOptionPane.showMessageDialog(null,
					"Les grands gagnants sont " + player1.getname() + " et " + player2.getname()
							+ "!\nVous obtenez un score de " + player1.getscores()[0]
							+ " points!\nVos domaines les plus étendus sont de " + player1.getscores()[1]
							+ " cases!\nEnfin vous possédez un total de " + player1.getscores()[2]
							+ " couronnes!\nBravo à vous deux!\n",
					"Gagnant", JOptionPane.INFORMATION_MESSAGE);
		} else if (listeWinners.size() == 3) {
			Player player1 = listeWinners.get(0);
			Player player2 = listeWinners.get(1);
			Player player3 = listeWinners.get(2);
			JOptionPane.showMessageDialog(null,
					"Les grands gagnants sont " + player1.getname() + " et " + player2.getname() + " et "
							+ player3.getname() + "!\nVous obtenez un score de " + player1.getscores()[0]
							+ " points!\nVos domaines les plus étendus sont de " + player1.getscores()[1]
							+ " cases!\nEnfin vous possédez un total de " + player1.getscores()[2]
							+ " couronnes!\nBravo à vous trois!\n",
					"Gagnant", JOptionPane.INFORMATION_MESSAGE);
		} else {
			Player player1 = listeWinners.get(0);
			Player player2 = listeWinners.get(1);
			Player player3 = listeWinners.get(2);
			Player player4 = listeWinners.get(3);
			JOptionPane.showMessageDialog(null,
					"Les grands gagnants sont " + player1.getname() + " et " + player2.getname() + " et "
							+ player3.getname() + " et " + player4.getname() + "!\nVous obtenez un score de "
							+ player1.getscores()[0] + " points!\nVos domaines les plus étendus sont de "
							+ player1.getscores()[1] + " cases!\nEnfin vous possédez un total de "
							+ player1.getscores()[2] + " couronnes!\nBravo à vous quatre!\n",
					"Gagnant", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void printClassement2(Player player1, Player player2) {
		ArrayList<Player> listeWinners = winner2(player1, player2);
		printWinners(listeWinners);
		if (listeWinners.size() == 1) {
			if (listeWinners.get(0) == player1) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player2.getname() + "!\nIl obtient un score de "
								+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player2.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player2.getscores()[2] + " couronnes!\nBien joué tout de même " + player2.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player1.getname() + "!\nIl obtient un score de "
								+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player1.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player1.getscores()[2] + " couronnes!\nBien joué tout de même " + player1.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void printClassement3(Player player1, Player player2, Player player3) {
		ArrayList<Player> listeWinners = winner3(player1, player2, player3);
		printWinners(listeWinners);
		if (listeWinners.size() == 1) {
			if (listeWinners.get(0) == player1) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player2.getname() + " et " + player3.getname() + "!\n"
								+ player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n"
								+ player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if (listeWinners.get(0) == player2) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player3.getname() + "!\n"
								+ player1.getname() + " obtient un score de " + player1.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n"
								+ player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player2.getname() + "!\n"
								+ player1.getname() + " obtient un score de " + player1.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n"
								+ player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (listeWinners.size() == 2) {
			if ((listeWinners.get(0) != player1) || (listeWinners.get(1) != player1)) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player1.getname() + "!\nIl obtient un score de "
								+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player1.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player1.getscores()[2] + " couronnes!\nBien joué tout de même " + player1.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) != player2) || (listeWinners.get(1) != player2)) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player2.getname() + "!\nIl obtient un score de "
								+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player2.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player2.getscores()[2] + " couronnes!\nBien joué tout de même " + player2.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player3.getname() + "!\nIl obtient un score de "
								+ player3.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player3.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player3.getscores()[2] + " couronnes!\nBien joué tout de même " + player3.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void printClassement4(Player player1, Player player2, Player player3, Player player4) {
		ArrayList<Player> listeWinners = winner4(player1, player2, player3, player4);
		printWinners(listeWinners);
		if (listeWinners.size() == 1) {
			if (listeWinners.get(0) == player1) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player2.getname() + " et " + player3.getname() + " et "
								+ player4.getname() + "!\n" + player2.getname() + " obtient un score de "
								+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player2.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player2.getscores()[2] + " couronnes!\nBien joué tout de même " + player2.getname()
								+ "!\n\n" + player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n"
								+ player4.getname() + " obtient un score de " + player4.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if (listeWinners.get(0) == player2) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player3.getname() + " et "
								+ player4.getname() + "!\n" + player1.getname() + " obtient un score de "
								+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player1.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player1.getscores()[2] + " couronnes!\nBien joué tout de même " + player1.getname()
								+ "!\n\n" + player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n"
								+ player4.getname() + " obtient un score de " + player4.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if (listeWinners.get(0) == player3) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player2.getname() + " et "
								+ player4.getname() + "!\n" + player1.getname() + " obtient un score de "
								+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player1.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player1.getscores()[2] + " couronnes!\nBien joué tout de même " + player1.getname()
								+ "!\n\n" + player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n"
								+ player4.getname() + " obtient un score de " + player4.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if (listeWinners.get(0) == player4) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player2.getname() + " et "
								+ player3.getname() + "!\n" + player1.getname() + " obtient un score de "
								+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player1.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player1.getscores()[2] + " couronnes!\nBien joué tout de même " + player1.getname()
								+ "!\n\n" + player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n"
								+ player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (listeWinners.size() == 2) {
			if ((listeWinners.get(0) == player1 || listeWinners.get(1) == player1)
					&& (listeWinners.get(0) == player2 || listeWinners.get(1) == player2)) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player3.getname() + " et " + player4.getname() + "!\n"
								+ player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n"
								+ player4.getname() + " obtient un score de " + player4.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) == player1 || listeWinners.get(1) == player1)
					&& (listeWinners.get(0) == player3 || listeWinners.get(1) == player3)) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player2.getname() + " et " + player4.getname() + "!\n"
								+ player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n"
								+ player4.getname() + " obtient un score de " + player4.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) == player1 || listeWinners.get(1) == player1)
					&& (listeWinners.get(0) == player4 || listeWinners.get(1) == player4)) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player2.getname() + " et " + player3.getname() + "!\n"
								+ player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n"
								+ player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) == player2 || listeWinners.get(1) == player2)
					&& (listeWinners.get(0) == player3 || listeWinners.get(1) == player3)) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player4.getname() + "!\n"
								+ player1.getname() + " obtient un score de " + player1.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n"
								+ player4.getname() + " obtient un score de " + player4.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player4.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player4.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player4.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) == player2 || listeWinners.get(1) == player2)
					&& (listeWinners.get(0) == player4 || listeWinners.get(1) == player4)) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player3.getname() + "!\n"
								+ player1.getname() + " obtient un score de " + player1.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n"
								+ player3.getname() + " obtient un score de " + player3.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player3.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player3.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player3.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) == player3 || listeWinners.get(1) == player3)
					&& (listeWinners.get(0) == player4 || listeWinners.get(1) == player4)) {
				JOptionPane.showMessageDialog(null,
						"Les perdants sont donc " + player1.getname() + " et " + player2.getname() + "!\n"
								+ player1.getname() + " obtient un score de " + player1.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player1.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player1.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player1.getname() + "!\n\n"
								+ player2.getname() + " obtient un score de " + player2.getscores()[0]
								+ " points!\nSon domaine le plus étendu est de " + player2.getscores()[1]
								+ " cases!\nEnfin il possède un total de " + player2.getscores()[2]
								+ " couronnes!\nBien joué tout de même " + player2.getname() + "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (listeWinners.size() == 3) {
			if ((listeWinners.get(0) != player1) || (listeWinners.get(1) != player1)
					|| (listeWinners.get(2) != player1)) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player1.getname() + "!\nIl obtient un score de "
								+ player1.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player1.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player1.getscores()[2] + " couronnes!\nBien joué tout de même " + player1.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) != player2) || (listeWinners.get(1) != player2)
					|| (listeWinners.get(2) != player2)) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player2.getname() + "!\nIl obtient un score de "
								+ player2.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player2.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player2.getscores()[2] + " couronnes!\nBien joué tout de même " + player2.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) != player3) || (listeWinners.get(1) != player3)
					|| (listeWinners.get(2) != player3)) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player3.getname() + "!\nIl obtient un score de "
								+ player3.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player3.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player3.getscores()[2] + " couronnes!\nBien joué tout de même " + player3.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
			} else if ((listeWinners.get(0) != player4) || (listeWinners.get(1) != player4)
					|| (listeWinners.get(2) != player4)) {
				JOptionPane.showMessageDialog(null,
						"Le perdant est donc " + player4.getname() + "!\nIl obtient un score de "
								+ player4.getscores()[0] + " points!\nSon domaine le plus étendu est de "
								+ player4.getscores()[1] + " cases!\nEnfin il possède un total de "
								+ player4.getscores()[2] + " couronnes!\nBien joué tout de même " + player4.getname()
								+ "!\n\n",
						"Perdant(s)", JOptionPane.INFORMATION_MESSAGE);
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

	public static void affichePlateau(Graphics g, Plateau displayBoard, int color, String modeDeJeu) {
		int longueurCase = 70;
		int longueurBoard = 9;
		if (modeDeJeu.equals("Le Grand Duel")) {
			longueurCase = 48;
			longueurBoard = 13;
		}
		for (int i = 0; i < longueurBoard; i++) {
			for (int j = 0; j < longueurBoard; j++) {
				char terrain = displayBoard.plate[j][i].gettile();
				int nbCouronnes = displayBoard.plate[j][i].getcrown();
				ImageObserver obs = null;
				if (terrain == 'C') {
					if (color == 1) {
						g.drawImage(imageblueC, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase,
								longueurCase, obs);
					}
					if (color == 2) {
						g.drawImage(imagegreenC, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase,
								longueurCase, obs);
					}
					if (color == 3) {
						g.drawImage(imageyellowC, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase,
								longueurCase, obs);
					}
					if (color == 4) {
						g.drawImage(imageredC, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase,
								longueurCase, obs);
					}
				} else if (terrain == '#') {
					g.setColor(fond);
					g.fillRect(400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase);
				} else if (terrain == 'Q') {
					g.drawImage(imageQ, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase, obs);
				} else if (terrain == 'L') {
					g.drawImage(imageL, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase, obs);
				} else if (terrain == 'W') {
					g.drawImage(imageW, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase, obs);
				} else if (terrain == 'P') {
					g.drawImage(imageP, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase, obs);
				} else if (terrain == 'M') {
					g.drawImage(imageM, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase, obs);
				} else if (terrain == 'F') {
					g.drawImage(imageF, 400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase, obs);
				}
				g.setColor(Color.BLACK);
				g.drawRect(400 + longueurCase * i, 30 + longueurCase * j, longueurCase, longueurCase);
				if (nbCouronnes > 0) {
					Font font = new Font("Calibri", Font.PLAIN, 20);
					g.setFont(font);
					g.setColor(Color.WHITE);
					g.drawString(String.valueOf(nbCouronnes), 405 + longueurCase * i, 50 + longueurCase * j);
				}
			}
		}
	}

	public static void afficheDomino(Graphics g, ArrayList<Domino> liste) {
		for (int i = 0; i < liste.size(); i++) {
			for (int j = 0; j < 2; j++) {
				char terrain;
				int nbCouronnes;
				ImageObserver obs = null;
				if (j == 0) {
					terrain = liste.get(i).gettile1();
					nbCouronnes = liste.get(i).getcrown1();
				} else {
					terrain = liste.get(i).gettile2();
					nbCouronnes = liste.get(i).getcrown2();
				}
				if (terrain == '#') {
					g.setColor(new Color(188, 181, 138));
					g.fillRect(100 + j * 70, 100 + i * 140, 70, 70);
				} else if (terrain == 'Q') {
					g.drawImage(imageQ, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'L') {
					g.drawImage(imageL, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'W') {
					g.drawImage(imageW, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'P') {
					g.drawImage(imageP, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'M') {
					g.drawImage(imageM, 100 + j * 70, 100 + i * 140, obs);
				} else if (terrain == 'F') {
					g.drawImage(imageF, 100 + j * 70, 100 + i * 140, obs);
				}
				if (nbCouronnes > 0) {
					Font font = new Font("Calibri", Font.PLAIN, 20);
					g.setFont(font);
					g.setColor(Color.WHITE);
					g.drawString(String.valueOf(nbCouronnes), 105 + j * 70, 120 + i * 140);
				}
			}
		}
	}
	
}