package marieBO;

import java.util.ArrayList;

public class UtilisateurM {

	
	// Etape 1, déclaration des variable (-> réserve un espace mémoire)
	private int no_utilisateur; // INTEGER IDENTITY(1,1) NOT NULL
	private String pseudo; //VARCHAR(30) NOT NULL
	private String nom; // VARCHAR(30) NOT NULL
	private String prenom; // VARCHAR(30) NOT NULL
	private String email; //  VARCHAR(50) NOT NULL
	private String telephone; // VARCHAR(15)
	private String rue; // VARCHAR(30) NOT NULL
	private String code_postal; // VARCHAR(10) NOT NULL
	private String ville; //  VARCHAR(50) NOT NULL
	private String mot_de_passe; // VARCHAR(30) NOT NULL
	private int credit; // INTEGER NOT NULL
	private boolean administrateur; // bit NOT NULL
	private ArrayList<ArticleM> article;
	private ArrayList<EnchereM> enchere;
	

    
	// Constructeur par défaut
    public UtilisateurM() {
        // Initialisation par défaut si nécessaire
        article = new ArrayList<>();
        enchere = new ArrayList<>();
    }

    // Constructeur surchargé
    public UtilisateurM(int no_utilisateur, String pseudo, String nom, String prenom,
                         String email, String telephone, String rue, String code_postal,
                         String ville, String mot_de_passe, int credit, boolean administrateur) {
        this.no_utilisateur = no_utilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.mot_de_passe = mot_de_passe;
        this.credit = credit;
        this.administrateur = administrateur;
        this.article = new ArrayList<>();
        this.enchere = new ArrayList<>();
    }

	

	
		
		
	
		public void setNo_utilisateur(int no_utilisateur) {
			this.no_utilisateur = no_utilisateur;
		}
		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public void setRue(String rue) {
			this.rue = rue;
		}
		public void setCode_postal(String code_postal) {
			this.code_postal = code_postal;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public void setMot_de_passe(String mot_de_passe) {
			this.mot_de_passe = mot_de_passe;
		}
		public void setCredit(int credit) {
			this.credit = credit;
		}
		public void setAdministrateur(boolean administrateur) {
			this.administrateur = administrateur;
		}
		public void setArticle(ArrayList<ArticleM> article) {
			this.article = article;
		}
		public void setEnchere(ArrayList<EnchereM> enchere) {
			this.enchere = enchere;
		}
		
		
		public int getNo_utilisateur() {
			return no_utilisateur;
		}
		public String getPseudo() {
			return pseudo;
		}
		public String getNom() {
			return nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public String getEmail() {
			return email;
		}
		public String getTelephone() {
			return telephone;
		}
		public String getRue() {
			return rue;
		}
		public String getCode_postal() {
			return code_postal;
		}
		public String getVille() {
			return ville;
		}
		public String getMot_de_passe() {
			return mot_de_passe;
		}
		public int getCredit() {
			return credit;
		}
		public boolean isAdministrateur() {
			return administrateur;
		}
		public ArrayList<ArticleM> getArticle() {
			return article;
		}
		public ArrayList<EnchereM> getEnchere() {
			return enchere;
		}

		@Override
		public String toString() {
			return "UtilisateurM [pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
					+ ", telephone=" + telephone + ", rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville
					+ ", mot_de_passe=" + mot_de_passe + ", credit=" + credit + ", administrateur=" + administrateur
					+ ", no_utilisateur=" + no_utilisateur + ", getNo_utilisateur()=" + getNo_utilisateur()
					+ ", getPseudo()=" + getPseudo() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
					+ ", getEmail()=" + getEmail() + ", getTelephone()=" + getTelephone() + ", getRue()=" + getRue()
					+ ", getCode_postal()=" + getCode_postal() + ", getVille()=" + getVille() + ", getMot_de_passe()="
					+ getMot_de_passe() + ", getCredit()=" + getCredit() + ", isAdministrateur()=" + isAdministrateur()
					+ ", getArticle()=" + getArticle() + ", getEnchere()=" + getEnchere() + "]";
		}
	

	
}
