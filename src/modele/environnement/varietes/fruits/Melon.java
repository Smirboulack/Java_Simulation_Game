package modele.environnement.varietes.fruits;

import modele.environnement.varietes.Fruit;
import modele.environnement.varietes.Varietes;

import java.util.Date;
import java.util.Random;

public class Melon extends Fruit {
    @Override
    public Varietes getVariete() {
        return Varietes.melon;
    }
    @Override
    public void SoleilFruit(int valsol) {
        taux_ensoleillement_fruit=valsol;
    }

    @Override
    public void HumiditeFruit(int valhum) {
        taux_humidite_fruit=valhum;
    }

    @Override
    public void VentFruit(int valvent) {
        taux_vents_fruit=valvent;
    }

    @Override
    public void maj_temps_croissance(int h,int m,int s,int vitesse) {
        temps_croissance_fruit_heure=h;
        temps_croissance_fruit_minute=m;
        temps_croissance_fruit_seconde=s;
        vitesse_croissance=vitesse;
    }

    public String getNomVariete() {
        return "melon";
    }
    public String getEtatFruit(){
        return etatfruit;
    }

    public float getPrix_plantation(){
        return prix_plantation;
    }
    @Override
    public float getPrix_recolte() {
        return prix_recolte;
    }

    @Override
    public void accelerer_croissance() {
        compteur_secondes+=50;
    }

    @Override
    public void nextStep() {
        if(!pause_croissance){
            compteur_secondes++;
            if(vitesse_croissance!=1 && compteur_secondes<1270){
                if(compteur_secondes<=1200){
                    compteur_secondes=compteur_secondes+vitesse_croissance;
                }else{
                    compteur_secondes=1290;
                }
            }
            if(compteur_secondes<1350){
                croissance();
            }else{

            }
        }
    }

    @Override
    protected void croissance() {
        if(pause_croissance==false){
            if(compteur_secondes<1300) {
                if (compteur_secondes < 350) {
                    Random random = new Random();
                    etatfruit = "en plante";
                    est_pourrie = false;
                    prix_recolte = 0 + random.nextFloat(); // prix aléatoire entre 4 et 5

                } else if (compteur_secondes >= 350 && compteur_secondes < 1299) {
                    Random random = new Random();
                    etatfruit = "en pousse";
                    est_pourrie = false;
                    prix_recolte = 1 + random.nextFloat(); // prix aléatoire entre 1 et 2
                } else if ((taux_ensoleillement_fruit == 0 || taux_humidite_fruit == 0 || taux_vents_fruit == 0
                        || taux_ensoleillement_fruit == 100 || taux_humidite_fruit == 100 || taux_vents_fruit == 100)
                ) {
                    etatfruit = "pourrie";
                    est_pourrie = true;
                    prix_recolte = 0;
                } else if (taux_ensoleillement_fruit >= 10 && taux_humidite_fruit >= 10 && taux_vents_fruit >= 10
                        && taux_ensoleillement_fruit < 55 && taux_humidite_fruit < 55 && taux_vents_fruit < 55
                ) {
                    Random random = new Random();
                    est_pourrie = (random.nextInt(5) == 0); // 1 chance sur 5 que l'état soit "pourrie"
                    etatfruit = (est_pourrie ? "pourrie" : "normal");
                    prix_recolte = 2 + random.nextFloat(); // prix aléatoire entre 2 et 3

                } else if (taux_ensoleillement_fruit > 55 && taux_humidite_fruit > 55 && taux_vents_fruit > 55
                        && taux_ensoleillement_fruit < 85 && taux_humidite_fruit < 85 && taux_vents_fruit < 85
                ) {
                    Random random = new Random();
                    est_pourrie = (random.nextInt(2) == 0); // 1 chance sur 2 que l'état soit "pourrie"
                    if (!est_pourrie) {
                        etatfruit = (random.nextInt(2) == 0) ? "normal" : "variete"; // 1 chance sur 2 que l'état soit "normal" ou "variete"
                    } else {
                        etatfruit = "pourrie";
                    }
                    prix_recolte = 4 + random.nextFloat(); // prix aléatoire entre 4 et 5

                } else {
                    Random random = new Random();
                    est_pourrie = (random.nextInt(2) == 0); // 1 chance sur 7 que l'état soit "pourrie"
                    etatfruit = (est_pourrie ? "pourrie" : "normal");
                    prix_recolte = 1 + random.nextFloat() * 2; // prix aléatoire entre 1 et 3
                    compteur_secondes++;
                    compteur_secondes *= vitesse_croissance;
                }
                if (est_pourrie == true) {
                    prix_recolte = 0;
                }
            }else if(compteur_secondes>1340){
                etatfruit="pourrie";
                est_pourrie=true;
            }
        }else{

        }

    }
}
