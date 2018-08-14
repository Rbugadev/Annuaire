package IhmFinal;

public class Departement {

	private String numeroDepartement;
	private String nomDpartement;
	
	
	
	
	
	public Departement() {
		super();
	}

	public Departement(String numeroDepartement, String nomDpartement) {
		super();
		this.numeroDepartement = numeroDepartement;
		this.nomDpartement = nomDpartement;
	}
	
	public String getNumeroDepartement() {
		return numeroDepartement;
	}
	public void setNumeroDepartement(String numeroDepartement) {
		this.numeroDepartement = numeroDepartement;
	}
	public String getNomDpartement() {
		return nomDpartement;
	}
	public void setNomDpartement(String nomDpartement) {
		this.nomDpartement = nomDpartement;
	}

	@Override
	public String toString() {
		return numeroDepartement + " - " + nomDpartement;
	}

	
	
}
