package marieBO;

import java.time.LocalDate;

public class EnchereM {
	
	private LocalDate  date_fin_enchere;
	private int montant_enchere; // INTEGER NOT NULL,
	private int no_article; // INTEGER NOT NULL,
	private int no_utilisateur; // INTEGER NOT NULL
	
    // Constructeur par défaut
    public EnchereM() {
        // Initialisation par défaut si nécessaire
    }

    // Constructeur surchargé
    public EnchereM(LocalDate date_fin_enchere, int montant_enchere, int no_article, int no_utilisateur) {
        this.date_fin_enchere = date_fin_enchere;
        this.montant_enchere = montant_enchere;
        this.no_article = no_article;
        this.no_utilisateur = no_utilisateur;
    }
   
    
    

    // Méthodes d'accès et de modification (getters et setters) pour chaque propriété
    public LocalDate getDate_fin_enchere1() {
        return date_fin_enchere;
    }

    public void setDate_fin_enchere1(LocalDate date_fin_enchere) {
        this.date_fin_enchere = date_fin_enchere;
    }

    public int getMontant_enchere1() {
        return montant_enchere;
    }

    public void setMontant_enchere(int montant_enchere) {
        this.montant_enchere = montant_enchere;
    }

    public int getNo_article() {
        return no_article;
    }

    public void setNo_article(int no_article) {
        this.no_article = no_article;
    }

    public int getNo_utilisateur() {
        return no_utilisateur;
    }

    public void setNo_utilisateur(int no_utilisateur) {
        this.no_utilisateur = no_utilisateur;
    }

	

	private int no_enchere; // INTEGER IDENTITY(1,1) NOT NULL
	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}


	public void setDate_debut_enchere(LocalDate date_debut_enchere) {
		this.date_debut_enchere = date_debut_enchere;
	}


	public void setDate_fin_enchere(LocalDate date_fin_enchere) {
		this.date_fin_enchere = date_fin_enchere;
	}


	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}


	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	
	private  LocalDate  date_debut_enchere;
	public LocalDate getDate_debut_enchere() {
		return date_debut_enchere;
	}


	public LocalDate getDate_fin_enchere() {
		return date_fin_enchere;
	}


	public int getMontant_enchere() {
		return montant_enchere;
	}


	public int getNo_article() {
		return no_article;
	}


	public int getNo_utilisateur() {
		return no_utilisateur;
	}


	public int getNo_enchere() {
		return no_enchere;
	}


	
	@Override
	public String toString() {
		return "EnchereM [date_fin_enchere=" + date_fin_enchere + ", montant_enchere=" + montant_enchere
				+ ", no_article=" + no_article + ", no_utilisateur=" + no_utilisateur + ", no_enchere=" + no_enchere
				+ ", date_debut_enchere=" + date_debut_enchere + ", getDate_debut_enchere()=" + getDate_debut_enchere()
				+ ", getDate_fin_enchere()=" + getDate_fin_enchere1() + ", getMontant_enchere()=" + getMontant_enchere1()
				+ ", getNo_article()=" + getNo_article() + ", getNo_utilisateur()=" + getNo_utilisateur()
				+ ", getNo_enchere()=" + getNo_enchere() + "]";
	}





	
	
}



