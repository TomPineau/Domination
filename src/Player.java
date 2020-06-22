import java.util.ArrayList;

public class Player {
	int[] scores;
	String name;
	Plateau board;
	boolean isAIcontrolled;
	int Color;

	public int[] getscores() {
		return this.scores;
	}

	public int getColor() {
		return this.Color;
	}

	public void setscores(int[] scores) {
		this.scores = scores;
	}

	public void setColor(int color) {
		this.Color = color;
	}

	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Plateau getboard() {
		return this.board;
	}

	public void setboard(Plateau board) {
		this.board = board;
	}

	public boolean getIA() {
		return this.isAIcontrolled;
	}

	public void setIA(boolean isIA) {
		this.isAIcontrolled = isIA;
	}

	public Player(String name, Plateau board) {
		int[] scores = { 0, 0, 0 };
		this.scores = scores;
		this.name = name;
		this.board = board;
		this.isAIcontrolled = false;
	}

	public Integer[] choicePosition(Domino domino) {
		Plateau iaBoard = this.getboard();
		Domino emptyTile = new Domino(0, 0, 0, '#', '#');
		ArrayList<Integer[]> listMovePlayable = iaBoard.listMovePlayable(domino);
		ArrayList<Integer[]> listeScoreDomaineMax = new ArrayList<Integer[]>();
		Integer[] firstPosition = listMovePlayable.get(0);
		domino.inserttuile(iaBoard, firstPosition[0], firstPosition[1], firstPosition[2], firstPosition[3]);
		int firstScore = iaBoard.copy().score();
		int firstDomaineMax = iaBoard.copy().domaineMax();
		Integer[] firstScoreDomaineMAx = { firstScore, firstDomaineMax };
		listeScoreDomaineMax.add(firstScoreDomaineMAx);
		Integer[] move = {firstPosition[0], firstPosition[1], firstPosition[2], firstPosition[3]};
		emptyTile.inserttuile(iaBoard, firstPosition[0], firstPosition[1], firstPosition[2], firstPosition[3]);
		for (int i = 1; i < listMovePlayable.size(); i++) {
			Integer[] position = listMovePlayable.get(i);
			domino.inserttuile(iaBoard, position[0], position[1], position[2], position[3]);
			int score = iaBoard.copy().score();
			int domaineMax = iaBoard.copy().domaineMax();
			Integer[] scoreDomaineMax = { score, domaineMax };
			if (scoreDomaineMax[0] > listeScoreDomaineMax.get(0)[0]) {
				listeScoreDomaineMax.remove(0);
				listeScoreDomaineMax.add(scoreDomaineMax);
				emptyTile.inserttuile(iaBoard, position[0], position[1], position[2], position[3]);
				Integer[] newMove = {position[0], position[1], position[2], position[3]};
				return newMove;
			} else if (scoreDomaineMax[0] == listeScoreDomaineMax.get(0)[0]) {
				if (scoreDomaineMax[1] > listeScoreDomaineMax.get(0)[1]) {
					listeScoreDomaineMax.remove(0);
					listeScoreDomaineMax.add(scoreDomaineMax);
					emptyTile.inserttuile(iaBoard, position[0], position[1], position[2], position[3]);
					Integer[] newMove = {position[0], position[1], position[2], position[3]};
					return newMove;
				}
			}
			emptyTile.inserttuile(iaBoard, position[0], position[1], position[2], position[3]);
		}
		return move;
	}
	
	public int takeBestOpponentDomino(ArrayList<Domino> selection) {
		int choice = -1;
		Plateau opponentBoard = this.getboard();
		ArrayList<Integer> indexTileNotEmpty = MainConsole.indexTileNotEmpty(selection);
		ArrayList<Integer[]> listeScoreDomaineMax = new ArrayList<Integer[]>();
		Domino emptyTile = new Domino(0, 0, 0, '#', '#');
		for (int i = 0; i < indexTileNotEmpty.size(); i++) {
			Domino domino = selection.get(indexTileNotEmpty.get(i));
			ArrayList<Integer[]> listMovePlayable = opponentBoard.listMovePlayable(domino);
			Integer[] firstPosition = listMovePlayable.get(0);
			domino.inserttuile(opponentBoard, firstPosition[0], firstPosition[1], firstPosition[2], firstPosition[3]);
			int firstScore = opponentBoard.copy().score();
			int firstDomaineMax = opponentBoard.copy().domaineMax();
			Integer[] firstScoreDomaineMAx = { firstScore, firstDomaineMax };
			listeScoreDomaineMax.add(firstScoreDomaineMAx);
			emptyTile.inserttuile(opponentBoard, firstPosition[0], firstPosition[1], firstPosition[2],
					firstPosition[3]);
			for (int j = 1; j < listMovePlayable.size(); j++) {
				Integer[] position = listMovePlayable.get(j);
				int score = opponentBoard.copy().score();
				int domaineMax = opponentBoard.copy().domaineMax();
				Integer[] scoreDomaineMax = { score, domaineMax };
				if (scoreDomaineMax[0] > listeScoreDomaineMax.get(0)[0]) {
					listeScoreDomaineMax.remove(0);
					listeScoreDomaineMax.add(scoreDomaineMax);
					emptyTile.inserttuile(opponentBoard, position[0], position[1], position[2], position[3]);
					choice = indexTileNotEmpty.get(i);
				} else if (scoreDomaineMax[0] == listeScoreDomaineMax.get(0)[0]) {
					if (scoreDomaineMax[1] > listeScoreDomaineMax.get(0)[1]) {
						listeScoreDomaineMax.remove(0);
						listeScoreDomaineMax.add(scoreDomaineMax);
						emptyTile.inserttuile(opponentBoard, position[0], position[1], position[2], position[3]);
						choice = indexTileNotEmpty.get(i);
					}
				}
			}
		}
		return choice;
	}

	public int choosetile(ArrayList<Domino> pioche, int[] CrownsPWFLQM) {
		int choice = 0;
		int value = 0;
		for (int domino = 0; domino < pioche.size(); domino++) {
			if (value < pioche.get(domino).evaluate(CrownsPWFLQM)) {
				value = pioche.get(domino).evaluate(CrownsPWFLQM);
				choice = domino;
			}
		}
		return choice;
	}

	public int[] choosemove(Domino tuile) {
		int[] choice = new int[4];
		choice[0] = -1;
		choice[3] = -1;
		int score = -1;
		char[][] totest = this.getboard().copy().playable(tuile, 1);
		int size = totest.length;
		int currentscore = -1;
		for (int colonne = 0; colonne < size; colonne++) {
			for (int ligne = 0; ligne < size; ligne++) {
				if (totest[colonne][ligne] == 'O') {
					if (this.getboard().jouable(tuile, ligne, colonne, ligne + 1, colonne)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne + 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne + 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne - 1, colonne)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne - 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne - 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne + 1)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne + 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne + 1;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne - 1)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne - 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne - 1;

						}
					}
				}
			}
		}
		totest = this.getboard().copy().playable(tuile, 2);
		size = totest.length;
		for (int colonne = 0; colonne < size; colonne++) {
			for (int ligne = 0; ligne < size; ligne++) {
				if (totest[colonne][ligne] == 'O') {
					if (this.getboard().jouable(tuile, ligne, colonne, ligne + 1, colonne)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne + 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne + 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne - 1, colonne)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne - 1, colonne);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne - 1;
							choice[3] = colonne;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne + 1)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne + 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne + 1;
						}
					}
					if (this.getboard().jouable(tuile, ligne, colonne, ligne, colonne - 1)) {
						Plateau board = this.getboard().copy();
						tuile.inserttuile(board, ligne, colonne, ligne, colonne - 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = ligne;
							choice[1] = colonne;
							choice[2] = ligne;
							choice[3] = colonne - 1;

						}
					}
				}
			}
		}
		return choice;
	}

}