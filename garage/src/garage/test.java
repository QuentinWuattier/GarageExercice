package garage;

import java.util.ArrayList;
import java.util.Scanner;

public class test{
    
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Développer une petite application web client/server de gestion de garage.");
        System.out.println("");
        
        // General
        ArrayList<Garage> garage = new ArrayList<Garage>();
        Scanner sc = new Scanner(System.in);
        
        // Gestion de l'application
        boolean bool = true;
        boolean boolapp = true;
        String game = "Y";
        
        // Gestion des actions Action
        
            //Gestion de l'execution des l'actions
        boolean boolaction = true;
            // Gestion des actions
        boolean actionbool = true;
        
        
        // Variable Voiture
        boolean verif = false;
        String marque = "";
        int vitMax = 0;
        
        
        // Application
        while(bool){
            
            
            boolapp = true;
            // Gestion de l'application
            while (boolapp){
                System.out.println("Voulez vous continuer ? (Y/N)");
                game = sc.nextLine();
                if ((game.equals("N")) || (game.equals("Y"))) boolapp = false;
                System.out.println(""); 
            }
            
            bool = game.equals("Y");
            
            // Gestion des actions
            if ((game.equals("Y"))) boolaction = true;
            else boolaction = false;
            
            //Demande d'action en continue
            while(boolaction){
                String action = "";
                
                // Reponse action 
                actionbool = true;
                while (actionbool){
                    System.out.println("Voullez vous executé une action ? (Y/N)");
                    action = sc.nextLine();
                    if ((action.equals("N")) || (action.equals("Y"))) actionbool = false;
                }
                
                boolaction = action.equals("Y");
                
                // Gestion des Actions  
                
                if(boolaction){
                    
                    String actionEff = "";
                    actionbool = true;
                    
                    //Choix de l'action
                    while(actionbool){
                        System.out.println("Action Disponible : (delG / creatG / delVG / creatVG / delV / creatV / modifV)");
                        System.out.print("Veuillez renseigner l'action : ");
                        actionEff = sc.nextLine();
                        if ((actionEff.equals("delG")) || (actionEff.equals("creatG")) || (actionEff.equals("delVG")) || (actionEff.equals("creatVG")) || (actionEff.equals("delV")) || (actionEff.equals("creatV")) || (actionEff.equals("modifV"))) {
                            actionbool = false;
                        }
                        else System.out.println("Action non disponnible.");
                    }
                    
                    
                            // /#/ Action /#/ //
                            

                    if (actionEff.equals("creatG")){
                        // Creation d'un garage
                        System.out.println("");
                        System.out.print("Veuillez renseigner un nombre de place : ");
                        int nbPlace = sc.nextInt();
                        garage.add(new Garage(nbPlace));
                        System.out.println("Votre garage a été créer avec succès.");
                        System.out.println(garage.size());
                    }
                    
                    //Suppression d'un garage
                    if(actionEff.equals("delG")){
                        if(garage.size() > 0){
                            int numGarage = 0;
                            while(numGarage <= 0 || numGarage > garage.size()){
                                System.out.println("Vous disposez de "+ garage.size()+" garages.");
                                System.out.print("Veuillez renseigner le numéro du garage a supprimer : ");
                                numGarage = sc.nextInt();
                            }
                            garage.remove(garage.get(numGarage-1));
                            System.out.print("Le garage vien d'être supprimé. ");
                        }else System.out.println("Vous ne disposez pas de garage.");
                        System.out.println("");
                    }
                    
                    
                    if (actionEff.equals("creatVG")){
                        // Création d'une voiture dans un garage
                        if(garage.size() > 0){
                            int ver = 0;
                            for(Garage g : garage){
                                if(g.getVoiture().size() < g.getNbVoiture()) ver++;
                            }
                            if(ver > 0){
                                int numGarage = 0;
                                while(numGarage <= 0 || garage.size() < numGarage){

                                    System.out.println("Vous disposez de "+garage.size()+" garages.");
                                    
                                    System.out.print("Veuillez renseigner le numéro du garage de la voiture a ajouter : ");
                                    numGarage = sc.nextInt();
                                    if(garage.get(numGarage-1).getVoiture().size() >= garage.get(numGarage-1).getNbVoiture()){
                                        System.out.println("Le garage n°"+numGarage+" est déja plein.");
                                        numGarage = 0;
                                    }
                                }
                                System.out.println("");
                                marque = "";
                                System.out.print("Veuillez renseigner la marque de la voiture : ");
                                marque = sc.nextLine();
                                
                                vitMax = 0;
                                System.out.print("Veuillez renseigner la vitesse maximal de la voiture : ");
                                vitMax = sc.nextInt();
                                
                                garage.get(numGarage-1).ajout(new Voiture(marque, vitMax));
                                System.out.println("Votre voiture a été placer dans le garage n°"+numGarage+"avec succès.");
                                
                            }else System.out.println("Tous vos garage sont remplis.");
                            
                        }else System.out.println("Vous ne disposez pas de garage.");
                        System.out.println("");
                    }
                    
                    if (actionEff.equals("delVG")){
                        //Suppression d'une voiture dans un garage

                        if(garage.size()>0){
                            int numGarage = 0;
                            while(numGarage <= 0 || garage.size() < numGarage){
                                System.out.print("Veuillez renseigner le numéro du garage : ");
                                numGarage = sc.nextInt();
                            }
                            if (garage.get(numGarage-1).getVoiture().size() > 0 ){
                                int numVoiture = 0;
                                while(numVoiture <= 0 || garage.get(numGarage-1).getVoiture().size() < numVoiture){
                                    System.out.print("Veuillez renseigner le numéro de la voiture : ");
                                    numVoiture = sc.nextInt();
                                }
                                garage.get(numGarage-1).retire(garage.get(numGarage-1).getVoiture().get(numVoiture));
                                System.out.print("La voiture selectionné a été supprimé.");
                            }else{ 
                                System.out.println("Vous ne disposez pas de voiture dans ce garage.");
                            }
                        }else{
                            System.out.println("Vous ne disposez pas de garage.");
                        }
                        
                        System.out.println("");
                    }
                    
                    
                    // Creation d'une voiture
                    if (actionEff.equals("creatV")){
                        if(garage.size() > 0){
                            marque = "";
                            System.out.print("Veuillez renseigner la marque de la voiture : ");
                            marque = sc.nextLine();
                            
                            vitMax = 0;
                            System.out.print("Veuillez renseigner la vitesse maximal de la voiture : ");
                            vitMax = sc.nextInt();
                            
                            verif = false;
                            for(int i = 0;  verif == false && i < garage.size(); i++){
                                if(garage.get(i).getVoiture().size() < garage.get(i).getNbVoiture()){
                                    garage.get(i).ajout(new Voiture(marque,vitMax));
                                    verif = true;
                                }
                            }
                            if(verif == false) System.out.println("La voiture n'a pas pu etre ajouter dans un des garages.");
                            
                        }else System.out.println("Vous ne disposez pas de garage.");
                        
                        System.out.println("");
                    }
                    
                    //suppréssion d'une voiture
                    if (actionEff.equals("delV")){
                    
                        marque = "";
                        System.out.print("Veuillez renseigner la marque de la voiture : ");
                        marque = sc.nextLine();
                        
                        vitMax = 0;
                        System.out.print("Veuillez renseigner la vitesse maximal de la voiture : ");
                        vitMax = sc.nextInt();
                        
                        verif = false;
                        for(int i = 0; verif == false && i <  garage.size(); i++){
                            for(int y = 0; verif == false && y <  garage.get(i).getVoiture().size(); y++)
                            if(garage.get(i).getVoiture().get(y).getMarque().equals(marque) && garage.get(i).getVoiture().get(y).getVitMax() == vitMax){
                                garage.get(i).retire(garage.get(i).getVoiture().get(y));
                                verif = true;
                            }
                        }
                        if(verif) System.out.println("La voiture a été supprimmé avec succès");
                        else System.out.println("La voiture n'a été trouvé");
                        
                        System.out.println("");
                
                    }
                    
                    // modification d'une voiture
                    if (actionEff.equals("modifV")){
                        
                        marque = "";
                        System.out.print("Veuillez renseigner la marque de la voiture d'origine : ");
                        marque = sc.nextLine();
                        
                        vitMax = 0;
                        System.out.print("Veuillez renseigner la vitesse maximal de la voiture d'origine : ");
                        vitMax = sc.nextInt();
                        
                        verif = false;
                        for(int i = 0; verif == false && i <  garage.size(); i++){
                            for(int y = 0; verif == false && y <  garage.get(i).getVoiture().size(); y++){
                            	if(garage.get(i).getVoiture().get(y).getMarque().equals(marque) && garage.get(i).getVoiture().get(y).getVitMax() == vitMax){
	                                System.out.print("Veuillez renseigner la marque de la voiture a modifier: ");
	                                marque = sc.nextLine();
	                                
	                                System.out.print("Veuillez renseigner la vitesse maximal de la voiture a modifier : ");
	                                vitMax = sc.nextInt();
	                        
	                                garage.get(i).getVoiture().get(y).setMarque(marque);
	                                garage.get(i).getVoiture().get(y).setVitMax(vitMax);
	                                verif = true;
                            	}
                            }
                        }
                        if(verif) System.out.println("La voiture a été modifier avec succès");
                        else System.out.println("La voiture n'a été trouvé");
                        
                        System.out.println("");
                    }// Fin action
                
                
                }//Fin boucle action
            
            }//Fin boucle /#/ début de l'application
        
            System.out.println("");
            System.out.println("Je vous remercie d'avoir essayer cette application.");
            System.out.println("");
        } // fin Methode  

    
    }
    
}