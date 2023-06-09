package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Fruit;

public class CaseCultivable extends Case {
    private Legume legume;
    private Fruit fruit;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }
    public Legume getLegume() {
        return legume;
    }
    public Fruit getFruit() {
        return fruit;
    }
    @Override
    public void actionUtilisateur(Legume l) {
        legume=l;
    }
    public void actionUtilisateur(Fruit f) {
        fruit=f;
    }
    @Override
    public void accelerer_croissance(Legume l) {
        l.accelerer_croissance();
    }

    @Override
    public void accelerer_croissance(Fruit F) {
        F.accelerer_croissance();
    }

    @Override
    public void pause_croissance_fruits_legume(boolean b) {
        if(fruit!=null)fruit.pause_croissance=b;
        else if(legume!=null){
            legume.pause_croissance=b;
        }
    }
    public void actionSoleilFruit(Fruit f,int val){
        f.SoleilFruit(val);
    }
    @Override
    public void actionHumiditeFruit(Fruit f, int val) {
        f.HumiditeFruit(val);
    }
    @Override
    public void actionVentFruit(Fruit f, int val) {
        f.VentFruit(val);
    }

    @Override
    public void actionSoleilLegume(Legume l, int val) {
        l.SoleilLegume(val);
    }

    @Override
    public void actionHumiditeLegume(Legume l, int val) {
        l.HumiditeLegume(val);
    }
    @Override
    public void actionVentLegume(Legume l, int val) {
        l.VentLegume(val);
    }
    @Override
    public void ActionTempsFruit(Fruit f,int h,int m,int s,int vitesse) {
        f.maj_temps_croissance(h,m,s,vitesse);
    }
    @Override
    public void ActionTempsLegume(Legume l, int h, int m, int s, int vitesse) {
        l.maj_temps_croissance(h,m,s,vitesse);
    }

    @Override
    public void run() {

        if (legume != null) {
            legume.nextStep();
        }
        if(fruit !=null) {
            fruit.nextStep();
        }

    }
}
