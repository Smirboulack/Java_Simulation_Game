package modele;

import modele.environnement.Case;
import modele.environnement.CaseCultivable;

public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;
    private Case[][] grilleCases_meteo;
    private Chrono Temps=new Chrono();
    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
        grilleCases_meteo=_simPot.getPlateau();
    }


    // Méthode pour appliquer l'action d'ensoleillement sur les fruits et légumes du plateau de culture
    // Prend en paramètre la valeur d'ensoleillement
    public void ActionEnsoleillement(int valeurenso){
        for(int i=0;i<simPot.SIZE_X;i++){
            for(int j=0;j<simPot.SIZE_Y;j++){
                if(grilleCases_meteo[i][j] instanceof CaseCultivable){
                    if(grilleCases_meteo[i][j].getFruit() != null ){
                        grilleCases_meteo[i][j].actionSoleilFruit(grilleCases_meteo[i][j].getFruit(),valeurenso);
                    }
                    else if(grilleCases_meteo[i][j].getLegume() != null){
                        grilleCases_meteo[i][j].actionSoleilLegume(grilleCases_meteo[i][j].getLegume(),valeurenso);
                    }
                }
            }
        }
    }
    // Méthode pour appliquer l'action d'humidité sur les fruits et légumes du plateau de culture
    // Prend en paramètre la valeur d'humidité
    public void ActionHumidite(int valhum){
        for(int i=0;i<simPot.SIZE_X;i++){
            for(int j=0;j<simPot.SIZE_Y;j++){
                if(grilleCases_meteo[i][j] instanceof CaseCultivable){
                    if(grilleCases_meteo[i][j].getFruit() != null ){
                        grilleCases_meteo[i][j].actionHumiditeFruit(grilleCases_meteo[i][j].getFruit(),valhum);
                    }
                    else if(grilleCases_meteo[i][j].getLegume() != null){
                        grilleCases_meteo[i][j].actionHumiditeLegume(grilleCases_meteo[i][j].getLegume(),valhum);
                    }
                }
            }
        }
    }

    // Méthode pour appliquer l'action de vents sur les fruits et légumes du plateau de culture
    // Prend en paramètre la valeur de vent
    public void ActionVents(int valvent){
        for(int i=0;i<simPot.SIZE_X;i++){
            for(int j=0;j<simPot.SIZE_Y;j++){
                if(grilleCases_meteo[i][j] instanceof CaseCultivable){
                    if(grilleCases_meteo[i][j].getFruit() != null ){
                        grilleCases_meteo[i][j].actionVentFruit(grilleCases_meteo[i][j].getFruit(),valvent);
                    }
                    else if(grilleCases_meteo[i][j].getLegume() != null){
                        grilleCases_meteo[i][j].actionVentLegume(grilleCases_meteo[i][j].getLegume(),valvent);
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        //ici nous allons stopper ou relancer la croissance de chaque fruits/legumes du plateau selon si le temps à été mis en pause ou non par l'utilisateur.
        //Aussi les conditions météorologiques des fruits et legumes serront mis à jour selon l'actiond de l'utilisateur depuis la fenetre_action.
        if(Temps.isEn_pause()){
            for(int i=0;i<simPot.SIZE_X;i++){
                for(int j=0;j<simPot.SIZE_Y;j++){
                    if(grilleCases_meteo[i][j] instanceof CaseCultivable){
                        if(grilleCases_meteo[i][j].getFruit() != null ){
                            grilleCases_meteo[i][j].pause_croissance_fruits_legume(true);
                        }
                        else if(grilleCases_meteo[i][j].getLegume() != null ){
                            grilleCases_meteo[i][j].pause_croissance_fruits_legume(true);
                        }
                    }
                }
            }
        }else{
            for(int i=0;i<simPot.SIZE_X;i++){
                for(int j=0;j<simPot.SIZE_Y;j++){
                    if(grilleCases_meteo[i][j] instanceof CaseCultivable){
                        if(grilleCases_meteo[i][j].getFruit() != null ){
                            grilleCases_meteo[i][j].ActionTempsFruit(grilleCases_meteo[i][j].getFruit(),Temps.getHeures(),Temps.getMinutes(),Temps.getSeconde(),Temps.getVitesse_chrono());
                        }
                        else if(grilleCases_meteo[i][j].getLegume() != null ){
                            grilleCases_meteo[i][j].ActionTempsLegume(grilleCases_meteo[i][j].getLegume(),Temps.getHeures(),Temps.getMinutes(),Temps.getSeconde(),Temps.getVitesse_chrono());
                        }
                    }
                }
            }

        }


    }

    public Chrono getTemps(){
        return Temps;
    }

}
