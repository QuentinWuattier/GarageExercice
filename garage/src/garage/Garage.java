package garage;

import java.util.ArrayList;


public class Garage
{
    int place;
	ArrayList<Voiture> voiture;
	
	Garage(){
		this.place = 0;
		this.voiture = new ArrayList<Voiture>();
	}
	
	Garage(int nbMax){
		this.place = nbMax;
		this.voiture = new ArrayList<Voiture>();
	}
	
	void ajout(Voiture voit){
		if (this.voiture.size() < this.place) this.voiture.add(voit);
		else System.out.println("La voiture n'a pas pu être ajouter a ce garage.");
	}
	
	void retire(Voiture voit){
		if(this.place > 0 && this.voiture.contains(voit)) this.voiture.remove(voit);
		else System.out.println("La voiture n'a pas été trouver dans ce garage.");
	}
	
	int getNbVoiture(){
		return this.place;
	}
	
	ArrayList<Voiture> getVoiture(){
		return this.voiture;
	}

}
