package modele;

import VueControleur.VueControleurPotager;

public class Chrono {
    private int seconde;
    private int minutes;
    private int heures;
    private String temps_actuel;
    private boolean En_pause;
    private int vitesse_chrono;

    public int getSeconde() {
        return seconde;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public String getTemps_actuel() {
        return temps_actuel;
    }

    public void setTemps_actuel(String temps_actuel) {
        this.temps_actuel = temps_actuel;
    }

    public boolean isEn_pause() {
        return En_pause;
    }

    public void setEn_pause(boolean en_pause) {
        En_pause = en_pause;
    }

    public int getVitesse_chrono() {
        return vitesse_chrono;
    }

    public void setVitesse_chrono(int vitesse_chrono) {
        this.vitesse_chrono = vitesse_chrono;
    }

}
