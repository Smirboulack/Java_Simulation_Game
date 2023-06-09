package modele.environnement.varietes;


/*NOTE : L'idée derrière cette stratégie d'implémentation est de pouvoir permettre à chaque fruit d'avoir ses propres propriétés de croissance */
public abstract class Fruit {
    public boolean est_pourrie = false;
    public String etatfruit="en pousse";
    public float prix_plantation = (float) (Math.random() + 1.0);
    public float prix_recolte=0;
    public int compteur_secondes=0;
    public boolean pause_croissance=false;
    public int temps_croissance_fruit_heure=0;
    public int temps_croissance_fruit_minute=0;
    public int temps_croissance_fruit_seconde=0;
    public int taux_ensoleillement_fruit=30;
    public int taux_humidite_fruit=30;
    public int taux_vents_fruit=30;
    public int vitesse_croissance=0;
    public abstract void nextStep();
    public abstract Varietes getVariete();
    public abstract void SoleilFruit(int valsol);
    public abstract void HumiditeFruit(int valhum);
    public abstract void VentFruit(int valvent);

    //On se servira essentiellement de la variable vitesse pour pouvoir gérer la vitesse de croissance des Fruits/Legumes.
    //La variable vitesse est continuellement mis à jour par le simulateurMeteo
    public abstract void maj_temps_croissance(int h,int m,int s,int vitesse);
    public abstract String getNomVariete();
    public abstract float getPrix_plantation();
    public abstract float getPrix_recolte();
    public String getEtatfruit(){
        return etatfruit;
    }
    public abstract void accelerer_croissance();
    protected abstract void croissance();
}
