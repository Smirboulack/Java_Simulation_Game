/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import VueControleur.Fenetres.FenetreAction;
import VueControleur.Fenetres.FenetreInfos;
import VueControleur.Fenetres.FenetreInventaire;
import VueControleur.Fenetres.FenetreProfil;
import VueControleur.Fenetres.FenetreRestart;
import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.CaseNonCultivable;
import modele.environnement.varietes.legumes.*;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.*;
import modele.environnement.varietes.fruits.*;

import java.awt.Point;
import java.text.DecimalFormat;


public class SimulateurPotager {
    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 10;
    private Legume current_graine_legume;
    private Fruit current_graine_fruit;
    private String current_action_profil;
    public FenetreInfos fenetreInfos;
    public FenetreInventaire fenetreInventaire;
    public FenetreProfil fenetreProfil;
    public FenetreAction fenetreAction;
    public FenetreRestart fenetreRestart;
    public SimulateurMeteo simMet;
    //Cette variable sera appelée dans la FenetreRestart pour être mise à jour par celle-ci . Tant que game_over==false , la partie ne s'arrête pas.
    private boolean game_over = false;

    //Cette méthode permet de créer un objet legume ou fruit selon la selection de l'utilisateur depuis la fenetre_action.
    public void choix_curent(String s){
        if(s == "ail"){
            current_graine_legume = new Ail();
        }
        if(s == "ananas"){
            current_graine_fruit= new Ananas();
        }
        if(s == "aubergine"){
            current_graine_legume = new Aubergine();
        }
        if(s == "avocat"){
            current_graine_legume = new Avocat();
        }
        if(s == "brocoli") {
            current_graine_legume = new Brocoli();
        }
        if(s == "carotte") {
            current_graine_legume = new Carotte();
        }
        if(s == "champignon"){
            current_graine_legume = new Champignon();
        }
        if(s == "choufleur"){
            current_graine_legume = new Choufleur();
        }
        if(s == "citron"){
            current_graine_legume = new Citron();
        }
        if(s == "comcombre"){
            current_graine_legume = new Comcombre();
        }
        if(s == "cornichon"){
            current_graine_legume = new Cornichon();
        }
        if(s == "fraise"){
            current_graine_fruit = new Fraise();
        }
        if(s == "haricot"){
            current_graine_legume = new Haricot();
        }
        if(s == "mais"){
            current_graine_legume = new Mais();
        }
        if(s == "melon"){
            current_graine_fruit = new Pasteque();
        }
        if(s == "oignon"){
            current_graine_legume = new Oignon();
        }
        if(s == "orange"){
            current_graine_fruit = new Orange();
        }
        if(s == "poire"){
            current_graine_fruit = new Poire();
        }
        if(s == "pasteque"){
            current_graine_fruit = new Pasteque();
        }
        if(s == "poivron"){
            current_graine_legume = new Poivron();
        }
        if(s == "radis"){
            current_graine_legume = new Radis();
        }
        if(s == "salade"){
            current_graine_legume = new Salade();
        }
        if(s == "tomate"){
            current_graine_fruit = new Tomate();
        }
        if(s=="mode_recolte" || s=="mode_excaver" ||s=="mode_engrais" ){
            current_graine_fruit=null;
            current_graine_legume=null;
            current_action_profil=s;
        }
        if(s=="mode_vente"){
            current_action_profil=s;
        }
        if(s==null){
            current_graine_legume=null;
            current_action_profil=null;
            current_graine_fruit=null;
        }

    }


    // private HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une entité à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une entité à partir de ses coordonnées

    public SimulateurPotager() {
        initialisationDesEntites();
        simMet = new SimulateurMeteo(this);
    }
    public Case[][] getPlateau() {
        return grilleCases;
    }

    //On initialise les différentes cases de la grille , certaines seront cultivable par défaut , d'autres seront non cultivables
    private void initialisationDesEntites() {

        // murs extérieurs horizontaux
        for (int x = 0; x < 20; x++) {
            addEntite(new CaseNonCultivable(this), x, 0);
            addEntite(new CaseNonCultivable(this), x, 9);
        }

        // murs extérieurs verticaux
        for (int y = 1; y < 9; y++) {
            addEntite(new CaseNonCultivable(this), 0, y);
            addEntite(new CaseNonCultivable(this), 19, y);
        }

        addEntite(new CaseNonCultivable(this), 2, 6);
        addEntite(new CaseNonCultivable(this), 3, 6);



        for (int x = 5; x < 15; x++) {
            for (int y = 3; y < 7; y++) {
                CaseCultivable cc = new CaseCultivable(this);
                addEntite(cc , x, y);
                Ordonnanceur.getOrdonnanceur().add(cc);

            }
        }

    }

    //On vérifie si le terrain est vide , c'est une des conditions au Game over.
    public boolean terrain_vide(){
        for(int i = 0 ; i < SIZE_X ; i++){
            for(int j=0 ; j< SIZE_Y ; j++){
                if(grilleCases[i][j] instanceof CaseCultivable && (grilleCases[i][j].getFruit() != null || grilleCases[i][j].getLegume() != null) ){
                    return false;
                }
            }
        }
        return true;
    }

    //La partie se termine si aucun fruits/legumes est en pousse sur le terrain et que l'utilisateur n'a plus assez d'argent pour réaliser une action. Il ne pourra donc plus rien faire.
    //La partie s'arretera alors.
    public boolean partie_fini(){
        return (terrain_vide() && fenetreProfil.getBourse() < 1.0 );
    }

    //méthode qui gère les actions vers la bourse de la fenetre_profil.
    public void gestion_bourse(Legume L,Fruit F,String action){

        DecimalFormat df = new DecimalFormat("#.##");
        float valeur_bourse = fenetreProfil.getBourse();
        if(L!=null && action=="perte"){
            valeur_bourse -= L.getPrix_plantation();
        }else if (L!=null && action=="gain"){
            valeur_bourse += L.getPrix_recolte();
        }else if(F!=null && action=="perte"){
            valeur_bourse -= F.getPrix_plantation();
        }else if(F!=null && action=="gain") {
            valeur_bourse += F.getPrix_recolte();
        }else if(action=="exacver"){
            valeur_bourse -= 5;
        }else if(action=="engrais"){
            valeur_bourse -= 3;
        }else if(action=="vente"){
            valeur_bourse += (float) (Math.random() + 2.0);
        }
        fenetreProfil.setBourse(valeur_bourse);
        String resultat = df.format(valeur_bourse);
        fenetreProfil.getLabelValeur_bourse().setText(resultat);
    }

    //Méthode centrale de la classe qui permet de pouvoir interagir avec le plateau via les clics de l'utilisateur. Les appels à la fonction choix_curent et aux méthodes de la classe Case
    //permettrons de varier les actions sur le plateau (planter , récolter , excaver , engrais ..).
    public void actionUtilisateur(int x, int y) {
        if( !partie_fini() ) {
            if (current_graine_legume != null && grilleCases[x][y].getLegume()==null &&  grilleCases[x][y] instanceof CaseCultivable) {

                if(fenetreProfil.getBourse() > 1.0){
                current_graine_fruit = null;
                current_action_profil = null;
                choix_curent(current_graine_legume.getNomVariete());
                if (grilleCases[x][y] != null) {
                    grilleCases[x][y].actionUtilisateur(current_graine_legume);
                    simMet.ActionEnsoleillement(fenetreAction.getSlider_Ensoleillement().getValue());
                    simMet.ActionHumidite(fenetreAction.getSlider_humidite().getValue());
                    simMet.ActionVents(fenetreAction.getSlider_vents().getValue());
                }
                String infos_plantation_legume = "Vous avez planté ";
                infos_plantation_legume += current_graine_legume.getNomVariete();
                infos_plantation_legume += " le prix de la graine était : ";
                infos_plantation_legume += current_graine_legume.getPrix_plantation();
                fenetreInfos.setTxtvaleur_informations(infos_plantation_legume);
                gestion_bourse(current_graine_legume,null,"perte");

                }else {
                    fenetreInfos.setTxtvaleur_informations("Pas assez d'argent pour planter un legume !");
                }
            } else if (current_graine_fruit != null && grilleCases[x][y].getFruit()==null &&  grilleCases[x][y] instanceof CaseCultivable) {
                if(fenetreProfil.getBourse() > 1.0){
                current_graine_legume = null;
                current_action_profil = null;
                choix_curent(current_graine_fruit.getNomVariete());
                if (grilleCases[x][y] != null) {
                    grilleCases[x][y].actionUtilisateur(current_graine_fruit);
                    simMet.ActionEnsoleillement(fenetreAction.getSlider_Ensoleillement().getValue());
                    simMet.ActionHumidite(fenetreAction.getSlider_humidite().getValue());
                    simMet.ActionVents(fenetreAction.getSlider_vents().getValue());
                }
                String infos_plantation_fruit = "Vous avez planté ";
                infos_plantation_fruit += current_graine_fruit.getNomVariete();
                infos_plantation_fruit += " le prix de la graine était : ";
                infos_plantation_fruit += current_graine_fruit.getPrix_plantation();
                fenetreInfos.setTxtvaleur_informations(infos_plantation_fruit);
                gestion_bourse(null,current_graine_fruit,"perte");
                }else {
                    fenetreInfos.setTxtvaleur_informations("Pas assez d'argent pour planter un fruit !");
                }
            } else if (current_action_profil != null) {

                current_graine_fruit = null;
                current_graine_legume = null;

                if (current_action_profil == "mode_recolte") {
                    Fruit f = grilleCases[x][y].getFruit();
                    Legume l = grilleCases[x][y].getLegume();
                    choix_curent("mode_recolte");
                    String objetramasser;
                    objetramasser = "vous avez ramasser quelque chose , c'est un : ";
                    if (f != null) {
                        objetramasser += f.getNomVariete();
                        objetramasser += " son etat est : ";
                        objetramasser += f.getEtatfruit();
                        gestion_bourse(null,f,"gain");

                    }
                    if (l != null) {
                        objetramasser += l.getNomVariete();
                        objetramasser += " son etat est : ";
                        objetramasser += l.getEtatLegume();
                        gestion_bourse(l,null,"gain");

                    }
                    fenetreInfos.setTxtvaleur_informations(objetramasser);

                }
                if (current_action_profil == "mode_excaver") {
                    if (!(grilleCases[x][y] instanceof CaseNonCultivable)) {
                        choix_curent("mode_excaver");
                        CaseCultivable cc = new CaseCultivable(this);
                        addEntite(cc, x, y);
                        Ordonnanceur.getOrdonnanceur().add(cc);
                        String infosexcaver;
                        infosexcaver = "Vous avez excaver un terrain ";
                        fenetreInfos.setTxtvaleur_informations(infosexcaver);
                        gestion_bourse(null,null,"excaver");
                    }
                }

                if(current_action_profil == "mode_engrais"){
                    choix_curent("mode_engrais");
                    Fruit f = grilleCases[x][y].getFruit();
                    Legume l = grilleCases[x][y].getLegume();
                    if (grilleCases[x][y] != null && fenetreProfil.getBourse()>3) {
                        if(f!=null){
                            grilleCases[x][y].accelerer_croissance(f);
                            gestion_bourse(null,null,"engrais");
                        }else if(l!=null){
                            grilleCases[x][y].accelerer_croissance(l);
                            gestion_bourse(null,null,"engrais");
                        }
                    }
                }

                if(current_action_profil == "mode_vente"){
                    if(grilleCases[x][y] instanceof CaseCultivable){
                        choix_curent("mode_vente");
                        addEntite(null,x,y);
                        fenetreInfos.setTxtvaleur_informations("Vous avez vendu un terrain");
                        gestion_bourse(null,null,"vente");
                    }
                }

                if (grilleCases[x][y] != null && current_action_profil!="mode_engrais") {
                    grilleCases[x][y].actionUtilisateur(current_graine_legume);
                    grilleCases[x][y].actionUtilisateur(current_graine_fruit);
                }
            } else {
                fenetreInfos.setTxtvaleur_informations("Veuillez selectionner un légume ou un fruit à planter ou une action !");
            }
        }else {
            fenetreInfos.setTxtvaleur_informations("Partie fini: Game Over , vous n'avez plus d'argent et le terrain est vide ! ");
            game_over=true;
            fenetreRestart.demarrer_decompte();
            fenetreRestart.setVisible(true);
            simMet.getTemps().setEn_pause(true);
        }
    }
    private void addEntite(Case e, int x, int y) {
        grilleCases[x][y] = e;
    }
    public String getCurrent_action_profil() {
        return current_action_profil;
    }
    public boolean getGame_over(){
        return game_over;
    }
    public void setCurrent_graine_legume(Legume current_graine_legume) {
        this.current_graine_legume = current_graine_legume;
    }
    public void setCurrent_graine_fruit(Fruit current_graine_fruit) {
        this.current_graine_fruit = current_graine_fruit;
    }
    public void setGame_over(boolean b){
        game_over = b;
    }

    //méthode qui sera utilisé pour reinitialiser le plateau de jeu si l'utilisateur choisit de recommancer la partie après Game Over.
    public void reinitialisation(){
        choix_curent(null);
        fenetreProfil.setBourse(20.0F);
        fenetreProfil.getLabelValeur_bourse().setText("20");
        for(int i = 0 ; i < SIZE_X ; i++){
            for(int j=0 ; j< SIZE_Y ; j++){
                grilleCases[i][j] = null;
            }
        }
       initialisationDesEntites();
        fenetreAction.reinit_action();

    }

}
