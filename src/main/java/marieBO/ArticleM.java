package marieBO;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleM {
	
	private int no_article; // INTEGER IDENTITY(1,1) NOT NULL
	private String nom_article; // VARCHAR(30) NOT NULL 
	private String description; // VARCHAR(300) NOT NULL
	private LocalDate  date_debut_enchere;  // DATE NOT NULL
    private LocalDate date_fin_encheres; // DATE NOT NULL
	private int prix_initial; // INT
	private int prix_de_vente; // INT
	private int no_utilisateur; // INTEGER NOT NULL
	private int no_categorie; // INTEGER NOT NULL
	private UtilisateurM un_utilisateur; 
	private ArrayList<EnchereM> enchere;
	private CategorieM categorie;
	
	

    // Constructeur par défaut
    public ArticleM() {
        // Initialisation par défaut si nécessaire
        enchere = new ArrayList<>();
    }

    // Constructeur surchargé
    public ArticleM(int no_article, String nom_article, String description,
                    LocalDate date_debut_enchere, LocalDate date_fin_encheres,
                    int prix_initial, int prix_de_vente, int no_utilisateur,
                    int no_categorie, UtilisateurM un_utilisateur, CategorieM categorie) {
        this.no_article = no_article;
        this.nom_article = nom_article;
        this.description = description;
        this.date_debut_enchere = date_debut_enchere;
        this.date_fin_encheres = date_fin_encheres;
        this.prix_initial = prix_initial;
        this.prix_de_vente = prix_de_vente;
        this.no_utilisateur = no_utilisateur;
        this.no_categorie = no_categorie;
        this.un_utilisateur = un_utilisateur;
        this.enchere = new ArrayList<>();
        this.categorie = categorie;
    }

	
	public ArrayList<ArticleM> getEncheres() {
		// TODO Auto-generated method stub
		return null;
		
		
	
		
			
		}
	public int getNo_article() {
		return no_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getDate_debut_enchere() {
		return date_debut_enchere;
	}
	public LocalDate getDate_fin_encheres() {
		return date_fin_encheres;
	}
	public int getPrix_initial() {
		return prix_initial;
	}
	public int getPrix_de_vente() {
		return prix_de_vente;
	}
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public int getNo_categorie() {
		return no_categorie;
	}
	public UtilisateurM getUn_utilisateur() {
		return un_utilisateur;
	}
	public ArrayList<EnchereM> getEnchere() {
		return enchere;
	}
	public CategorieM getCategorie() {
		return categorie;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate_debut_enchere(LocalDate date_debut_enchere) {
		this.date_debut_enchere = date_debut_enchere;
	}
	public void setDate_fin_encheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}
	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}
	public void setPrix_de_vente(int prix_de_vente) {
		this.prix_de_vente = prix_de_vente;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public void setUn_utilisateur(UtilisateurM un_utilisateur) {
		this.un_utilisateur = un_utilisateur;
	}
	public void setEnchere(ArrayList<EnchereM> enchere) {
		this.enchere = enchere;
	}
	public void setCategorie(CategorieM categorie) {
		this.categorie = categorie;
	}

	
	@Override
	public String toString() {
		return "ArticleM [no_article=" + no_article + ", nom_article=" + nom_article + ", description=" + description
				+ ", date_debut_enchere=" + date_debut_enchere + ", date_fin_encheres=" + date_fin_encheres
				+ ", prix_initial=" + prix_initial + ", prix_de_vente=" + prix_de_vente + ", no_utilisateur="
				+ no_utilisateur + ", no_categorie=" + no_categorie + ", un_utilisateur=" + un_utilisateur
				+ ", enchere=" + enchere + ", categorie=" + categorie + "]";

	
	
	

	
			}
}
