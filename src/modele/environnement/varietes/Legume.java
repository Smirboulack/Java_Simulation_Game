package modele.environnement.varietes;


/*NOTE : L'idée derrière cette stratégie d'implémentation est de pouvoir permettre à chaque légume d'avoir ses propres proprietes de croissance */
public abstract class Legume {

    public String etatlegume;
    public float prix_plantation = (float) (Math.random() + 1.0);
    public float prix_recolte=0;
    public int compteur_secondes=0;
    public boolean pause_croissance=false;
    public int temps_croissance_legume_heure=0;
    public int temps_croissance_legume_minute=0;
    public int temps_croissance_legume_seconde=0;
    public int taux_ensoleillement_legume=30;
    public int taux_humidite_legume=30;
    public int taux_vents_legume=30;
    public int vitesse_croissance=0;
    public boolean est_pourrie = false;
    public abstract void SoleilLegume(int valsol);
    public abstract void HumiditeLegume(int valhum);
    public abstract void VentLegume(int valvent);
    public abstract void nextStep();
    public abstract String getEtatLegume();
    public abstract float getPrix_plantation();
    //On se servira essentiellement de la variable vitesse pour pouvoir gérer la vitesse de croissance des Fruits/Legumes.
    //La variable vitesse est continuellement mis à jour par le simulateurMeteo
    public abstract void maj_temps_croissance(int h,int m,int s,int vitesse);
    public abstract float getPrix_recolte();
    public abstract Varietes getVariete();
    public abstract String getNomVariete();
    protected abstract void croissance(); // définir selon les conditions

    public void accelerer_croissance() {
        compteur_secondes+=50;
    }
}
