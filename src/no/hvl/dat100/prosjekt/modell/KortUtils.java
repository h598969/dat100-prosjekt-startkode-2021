package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		int length=samling.getAntalKort();
		Kort[] temp=new Kort[length];
		Kort[] samlingTemp= samling.getAllekort();
		for(int i=0; i<length; i++) {
			int minPos=0;
			for(int j=0;j<length; j++) {
				int tall=samlingTemp[j].compareTo(samlingTemp[minPos]);
				if (tall<0) {
					minPos=j;
				}
				
			}
			temp[i]=samlingTemp[minPos];
			Kort MAX_Value=new Kort(Kortfarge.Spar, 14);
			samlingTemp[minPos]=MAX_Value;
			// antar her at spar har h�yest enum value. dersom dette ikke stemmer vil det bli feil n�r flere kortfarger benyttes.
		}
		samling.fjernAlle();
		for(int i=0; i<length; i++) {
			int minPos=0;
			for(int j=0;j<length; j++) {
				int tall=temp[j].compareTo(temp[minPos]);
				if (tall<0) {
					minPos=j;
				}
				
			}
			samling.leggTil(temp[minPos]);
			Kort MAX_Value=new Kort(Kortfarge.Spar, 14);
			temp[minPos]=MAX_Value;
		}
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		int length=samling.getAntalKort();
		Kort[] temp=samling.getSamling();
		Kort[] stokket=new Kort[length];
		Random rand=new Random();
		for (int i=0; i<length; i++) {
			int tall;
			do{
				tall = rand.nextInt(length);
			}while(stokket[tall]!=null);
			stokket[tall]=temp[i];
			
		}
		samling.fjernAlle();
		for(int i=0; i<length; i++){
		samling.leggTil(stokket[i]);
		}
	}
	
}
