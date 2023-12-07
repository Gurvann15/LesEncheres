package marieBO;




public class RetraitM {
	
	
	private String rue; // VARCHAR(30) NOT NULL,
	private String code_postal;  // VARCHAR(15) NOT NULL,
	private String ville; // VARCHAR(30) NOT NULL
	
	
	// Constructeur par défaut
    public RetraitM() {
        // Initialisation par défaut si nécessaire
    }

    // Constructeur surchargé
    public RetraitM(String rue, String code_postal, String ville) {
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
    }

	private int no_article; // INTEGER NOT NULL,
	public int getNo_article() {
		return no_article;
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
	public void setNo_article(int no_article) {
		this.no_article = no_article;
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
	
	
	@Override
	public String toString() {
		return "RetraitM [no_article=" + no_article + ", rue=" + rue + ", code_postal=" + code_postal + ", ville="
				+ ville + "]";
	

    
    
	}
    
    
}
