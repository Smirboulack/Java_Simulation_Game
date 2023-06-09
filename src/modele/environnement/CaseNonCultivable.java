package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Fruit;


/* NOTE : LES METHODES DE CETTE CLASSE N'ONT PAS ENCORE ETE UTILISEES */
public class CaseNonCultivable extends Case {
    public CaseNonCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void pause_croissance_fruits_legume(boolean b) {
    }

    protected SimulateurPotager simulateurPotager;

    //Si l'on essaye de cliquer sur un arbre pour réaliser une action ...
    @Override
    public void actionUtilisateur(Legume l) {
        System.out.println("Vous ne pouvez pas planter un legume ici , il y a un arbre");
    }
    //Si l'on essaye de cliquer sur un arbre pour réaliser une action ...
    public void actionUtilisateur(Fruit F) {
        System.out.println("Vous ne pouvez pas planter un fruit ici , il y a un arbre");
    }

    @Override
    public void accelerer_croissance(Legume l) {

    }

    @Override
    public void accelerer_croissance(Fruit F) {

    }

    @Override
    public void actionSoleilFruit(Fruit f, int val) {

    }

    @Override
    public void actionHumiditeFruit(Fruit f, int val) {

    }

    @Override
    public void actionVentFruit(Fruit f, int val) {

    }

    @Override
    public void actionSoleilLegume(Legume l, int val) {

    }

    @Override
    public void actionHumiditeLegume(Legume l, int val) {

    }
    @Override
    public void actionVentLegume(Legume l, int val) {

    }
    @Override
    public void ActionTempsFruit(Fruit f, int h,int m ,int s,int vitesse) {

    }

    @Override
    public void ActionTempsLegume(Legume l, int h, int m, int s, int vitesse) {

    }

    public Legume getLegume(){
        return null;
    }

    public Fruit getFruit(){
        return null;
    }


    @Override
    public void run() {

    }
}
