package fr.eni.lesencheres.bo;

// Liée à la BDD avec la table : retraits
public class Retrait {
	// ATTRIBUTS 
	private String rue; //rue / TO DO: vérifier pas + 30 caractères en DLL
	private String codePostal; //code_postal / TO DO: vérifier pas + 15 caractères en DLL
	private String ville; //ville / TO DO: vérifier pas + 30 caractères en DLL
	private Article article; 

	//CONSTRUCTEURS
	//Constructeur par défault
	public Retrait() {
		
	}
	//Constructeur complet
	public Retrait(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	//Constructeur complet
	public Retrait(String rue, String codePostal, String ville, Article article) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}
	
	//GETTERS
	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public Article getArticle() {
		return article;
	}
	
	//SETTERS
	public void setRue(String rue) {
		this.rue = rue;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	
	//METHODES
	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", article=" + article + "]";
	}
	
}