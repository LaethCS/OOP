package business.parkett;

public class Parkett {
	
	String kategorie;
	String farbe;
	int preisJeMeter;
	
	public Parkett(String kategorie, String farbe, String preisJeMeter) {
		super();
		this.kategorie = kategorie;
		this.farbe = farbe;
		this.preisJeMeter = Integer.parseInt(preisJeMeter);
	}
	
	public String gibParkettZurueck(char trenner){
  		return this.getKategorie() + trenner 
  			+ this.getFarbe() + trenner
  		    + this.getPreisJeMeter();
   	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getPreisJeMeter() {
		return preisJeMeter;
	}

	public void setPreisJeMeter(int preisJeMeter) {
		this.preisJeMeter = preisJeMeter;
	}
}
