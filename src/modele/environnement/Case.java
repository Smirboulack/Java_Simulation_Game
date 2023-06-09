/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Fruit;

public abstract class Case implements Runnable {
    protected SimulateurPotager simulateurPotager;
    public abstract Legume getLegume();
    public abstract Fruit getFruit();
    public Case(SimulateurPotager _simulateurPotager) {
        simulateurPotager = _simulateurPotager;
    }
    public abstract void pause_croissance_fruits_legume(boolean b);
    public abstract void actionUtilisateur(Legume l);
    public abstract void actionUtilisateur(Fruit F);
    public abstract void accelerer_croissance(Legume l);
    public abstract void accelerer_croissance(Fruit F);
    public abstract void actionSoleilFruit(Fruit f,int val);
    public abstract void actionHumiditeFruit(Fruit f,int val);
    public abstract void actionVentFruit(Fruit f,int val);
    public abstract void actionSoleilLegume(Legume l,int val);
    public abstract void actionHumiditeLegume(Legume l,int val);
    public abstract void actionVentLegume(Legume l,int val);
    public abstract void ActionTempsFruit(Fruit f,int h,int m,int s,int vitesse);
    public abstract void ActionTempsLegume(Legume l,int h,int m,int s,int vitesse);

}
