package garage;

public class Voiture
{
    	String marque;
	int vitMax;
	
	Voiture(){
		this.marque = "";
		this.vitMax = 0;
	}
	
	Voiture(String marque, int vitMax){
		this.marque = marque;
		this.vitMax = vitMax;
	}
	
	String getMarque(){ 
		return this.marque;
	}
	
	int getVitMax(){ 
		return this.vitMax;
	}

	void setMarque(String marque){
		this.marque = marque;
	}
	
	void setVitMax(int vitMax){ 
		this.vitMax = vitMax;
	}
}
