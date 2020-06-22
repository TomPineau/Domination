public class Case {
	int crown, x, y;
	char tile;

	public int getcrown() {
		return this.crown;
	}

	public int getx() {
		return this.x;
	}

	public int gety() {
		return this.y;
	}

	public char gettile() {
		return this.tile;
	}

	public void setcrown(int crown) {
		this.crown = crown;
	}

	public void setx(int x) {
		this.x = x;
	}

	public void sety(int y) {
		this.y = y;
	}

	public void settile(char title) {
		this.tile = gettile();
	}

	public Case(int x, int y, int crown, char tile) {
		this.crown = crown;
		this.tile = tile;
		this.x = x;
		this.y = y;
	}

}