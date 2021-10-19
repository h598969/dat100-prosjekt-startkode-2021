package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	* Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	*/
	//Sivert
	public KortSamling() {
		
		this.samling = new Kort[MAKS_KORT];
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	//Anders
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	
	public int getAntalKort() {
		
		return antall;
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	//Sivert
	public boolean erTom() {
		for (int i=0; i<samling.length; i++) { 
			if (samling[i] != null) {
				return false;
			}
		}
		return true;
		
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	//Anders
	public void leggTil(Kort kort) {
		samling[antall]=kort;
		antall++;
	}

//int length = samling.length;
//
//		samling = Arrays.copyOf(samling, length+1);
//		samling[length - 1] = kort;
//		
//		}
//		
			
	
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	//Sivert
	public void leggTilAlle() {
		for (Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				leggTil(new Kort(f,i));
				}
			}
		}
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
		
		

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	//Anders
	public void fjernAlle() {
		for (int i = 0; i<samling.length; i++) {
			if (samling[i] != null) {
				samling[i] = null;
				antall-=1;
			}

		}
	}

	
		

	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	//Sivert
	public Kort seSiste() {
//		int siste = 0;
//		int neste = siste + 1;
//		for (int i = samling.length-1; i>=0; i--) {
//			if (samling[i] != null) {
//				siste = samling[i];
//				break;
//			}
//		}
//		while (samling[neste] != null) {
//			siste++;
//			neste++;
//		}
		int siste=samling.length-1;
		while (samling[siste]==(null) && siste>0) {
			siste--;
		}
		return samling[siste];
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	//Anders
	public Kort taSiste() {
		
//		int siste = 0;
//		int neste = siste + 1;
//		while (samling[neste] != null) {
//			siste++;
//			neste++;
//		}
	int siste=samling.length-1;
	while (samling[siste]==null && siste>0) {
		siste--;
	}
		
		Kort ref = samling[siste];
		samling[siste] = null;
		antall--;
		
		return ref;
	
	}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	//Sivert
	public boolean har(Kort kort) {
		if (kort == null) {
			return false;
		}
	
		for(int i=0; i<samling.length; i++) {
			if(samling[i] != null && samling[i].lik(kort)) {
				return true;
			}
		}return false;
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
	//Anders		 
	public boolean fjern(Kort kort) {
		
		for(int i=0; i<samling.length; i++) {
			if(samling[i] == kort && samling[i] != null) {
				samling[i]=null;
				antall--;
			return true;
			}
		}return false;
		
		
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	//Sivert
	public Kort[] getAllekort() {
		Kort[] antallKort = new Kort[antall];
		for (int i = 0; i<antallKort.length; i++) {
			antallKort[i] = samling[i];
		}
		return antallKort;
	}
	
}
