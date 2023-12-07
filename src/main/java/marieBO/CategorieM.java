package marieBO;

public class CategorieM {

	private int no_categorie; //  INTEGER IDENTITY(1,1) NOT NULL
	private String libelle; // VARCHAR(30) NOT NULL
	
	// Constructeur vide
    public CategorieM() {
        // Initialisation par défaut si nécessaire
    }

    // Constructeur surchargé
    public CategorieM(int no_categorie, String libelle) {
        this.no_categorie = no_categorie;
        this.libelle = libelle;
    }

    // y mettre les méthodes logique métier
	
	public int getNo_categorie() {
		return no_categorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "CategorieM [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}
	
	
}
