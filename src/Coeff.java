
public class Coeff {

	char nature;
	double coeff;
	
	public char getNature() {
		return nature;
	}
	public void setNature(char nature) {
		this.nature = nature;
	}
	public double getCoeff() {
		return coeff;
	}
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	public Coeff(char nature, double coeff) {
		this.nature = nature;
		this.coeff = coeff;
	}
	
	public void afficheCoeff() {
		System.out.println("[" + this.getNature() + "," + this.getCoeff() + "]");
	}
	
}
