package business;

public class Teppich {
    
    private String artikelnummer;
    private String kategorie;
    private int breite;
    private int laenge;
    private String[] farben;
    
    public Teppich(String artikelnummer, String kategorie, int breite,
       	int laenge, String[] farben){
    	this.artikelnummer = artikelnummer;
      	this.kategorie = kategorie;
       	this.breite = breite;
       	this.laenge = laenge;
       	this.farben = farben;
    }

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public String[] getFarben() {
		return farben;
	}

	public void setFarben(String[] farben) {
		this.farben = farben;
	}
	
 	public String getFarbenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarben().length - 1; i++) {
			ergebnis = ergebnis + this.getFarben()[i] + trenner; 
		}
		return ergebnis	+ this.getFarben()[i];
	}
	
	public String gibTeppichZurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getKategorie() + trenner
  			+ this.getBreite() + trenner
  		    + this.getLaenge() + trenner + "\n"
  		    + this.getFarbenAlsString(trenner) + "\n";
  	}
}