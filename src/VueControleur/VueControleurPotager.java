package VueControleur;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import VueControleur.Fenetres.*;
import modele.SimulateurPotager;
import modele.environnement.*;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Fruit;
import java.util.TimerTask;
import java.util.Timer;



/** Cette classe a deux fonctions :
 *  (1) Vue : proposer une représentation graphique de l'application (cases graphiques, etc.)
 *  (2) Controleur : écouter les évènements clavier et déclencher le traitement adapté sur le modèle
 *
 */
public class VueControleurPotager extends JFrame implements Observer {
    private SimulateurPotager simulateurPotager; // référence sur une classe de modèle : permet d'accéder aux données du modèle pour le rafraichissement, permet de communiquer les actions clavier (ou souris)
    private int sizeX; // taille de la grille affichée
    private int sizeY;
    private Affichables cultivable = new Affichables();
    private JLabel[][] tabJLabel; // cases graphique (au moment du rafraichissement, chaque case va être associée à une icône, suivant ce qui est présent dans le modèle)
    private FenetreChrono fenetre_chrono;
    private FenetreProfil fenetre_profil;
    private FenetreInfos fenetre_infos;
    private FenetreAction fenetre_action;
    private FenetreInventaire fenetre_inventaire;
    private FenetreRestart fenetre_restart;

    public VueControleurPotager(SimulateurPotager _simulateurPotager) {
        sizeX = simulateurPotager.SIZE_X;
        sizeY = _simulateurPotager.SIZE_Y;
        simulateurPotager = _simulateurPotager;
        cultivable.construction_images_icons();

        //Creation d'une fenetre_Chrono
        fenetre_chrono = new FenetreChrono(simulateurPotager.simMet.getTemps());
        //Creation d'une fenetre_action
        fenetre_action = new FenetreAction(simulateurPotager,cultivable);
        simulateurPotager.fenetreAction=fenetre_action;
        //Creation d'une fenetre_infos
        fenetre_infos = new FenetreInfos();
        //Creation d'une fenetre_profil
        fenetre_profil = new FenetreProfil(cultivable);
        //Creation d'une fenetre_iventaire
        fenetre_inventaire = new FenetreInventaire(simulateurPotager);
        //Creation d'une fenetre_restart
        fenetre_restart = new FenetreRestart(simulateurPotager,fenetre_chrono);
        simulateurPotager.fenetreRestart=fenetre_restart;


        placerLesComposantsGraphiques();
        gestion_fenetres_evenements();
    }
    private void placerLesComposantsGraphiques() {

        setTitle("Super Jardin Simulator");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Jpanel pour les boutons au sommet de la fenetre principal
        JPanel panel_sommet = new JPanel();
        panel_sommet.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // alignement à gauche avec un espace de 10px entre les composants
        //Les boutonsRond de la fenetre principal
        BoutonRond bouton_Action = new BoutonRond(Color.GRAY);
        BoutonRond bouton_Profil = new BoutonRond(Color.YELLOW);
        BoutonRond bouton_Infos = new BoutonRond(Color.BLUE);
        //On ajoute les boutonsRond au Jpanel de la fenetre principal
        panel_sommet.add(bouton_Action);
        panel_sommet.add(bouton_Infos);
        panel_sommet.add(bouton_Profil);
        // ajout du panel en haut de la fenêtre
        this.add(panel_sommet, BorderLayout.NORTH);
        // Positionnement de la fenêtre principale
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;
        this.setLocation(centerX - this.getWidth() / 2, centerY - this.getHeight() / 2);
        int coordx_fenetre_principal=centerX - this.getWidth() / 2;
        int coordy_fenetre_principal=centerY - this.getHeight() / 2;
        // Positionnement des différentes fenêtres.
        fenetre_profil.setLocation(coordx_fenetre_principal+1000, this.getY());
        fenetre_action.setLocation(this.getX()-380, this.getY());
        fenetre_infos.setLocation(coordx_fenetre_principal-380, this.getY()-150);
        fenetre_chrono.setLocation(fenetre_infos.getX()+1000, fenetre_infos.getY());

        bouton_Action.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fenetre_action.setVisible(true);
            }
        });
        bouton_Profil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fenetre_profil.setVisible(true);
            }
        });
        bouton_Infos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fenetre_infos.setVisible(true);
            }
        });

        JComponent grilleJLabels = new JPanel(new GridLayout(sizeY, sizeX));
        tabJLabel = new JLabel[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                JLabel jlab = new JLabel();
                tabJLabel[x][y] = jlab;
                grilleJLabels.add(jlab);
            }
        }
        add(grilleJLabels, BorderLayout.CENTER);

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                final int xx = x;
                final int yy = y;
                tabJLabel[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        simulateurPotager.actionUtilisateur(xx, yy);
                    }
                });
            }
        }



    }


    /**
     * Il y a une grille du côté du modèle ( jeu.getGrille() ) et une grille du côté de la vue (tabJLabel)
     */
    private void mettreAJourAffichage() {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (simulateurPotager.getGame_over() == false) {

                    if (simulateurPotager.getPlateau()[x][y] instanceof CaseCultivable) {

                        Legume legume = ((CaseCultivable) simulateurPotager.getPlateau()[x][y]).getLegume();
                        Fruit fruit = ((CaseCultivable) simulateurPotager.getPlateau()[x][y]).getFruit();

                        if (fruit != null) {

                            switch (fruit.getVariete()) {
                                case ananas:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAnanas());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAnanas_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAnanas_morte());
                                    }

                                    break;
                                case fraise:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoFraise());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoFraise_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoFraise_morte());
                                    }
                                    break;
                                case melon:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoMelon());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoMelon_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoMelon_morte());
                                    }
                                    break;
                                case orange:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoOrange());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoOrange_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoOrange_morte());
                                    }
                                    break;
                                case pasteque:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPasteque());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPasteque_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPasteque_morte());
                                    }
                                    break;
                                case poire:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPoire());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPoire_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPoire_morte());
                                    }
                                    break;
                                case tomate:
                                    if (fruit.etatfruit == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (fruit.etatfruit == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (fruit.etatfruit == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoTomate());
                                    } else if (fruit.etatfruit == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoTomate_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoTomate_morte());
                                    }
                                    break;
                            }
                        } else if (legume != null) {
                            switch (legume.getVariete()) {
                                case ail:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAil());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAil_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAil_morte());
                                    }
                                    break;
                                case aubergine:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAubergine());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAubergine_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAubergine_morte());
                                    }
                                    break;
                                case avocat:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAvocat());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAvocat_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoAvocat_morte());
                                    }
                                    break;
                                case brocoli:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoBrocoli());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoBrocoli_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoBrocoli_morte());
                                    }
                                    break;
                                case carotte:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCarotte());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCarotte_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCarotte_morte());
                                    }
                                    break;
                                case champignon:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoChampignon());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoChampignon_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoChampignon_morte());
                                    }
                                    break;
                                case choufleur:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoChoufleur());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoChoufleur_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoChoufleur_morte());
                                    }
                                    break;
                                case citron:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCitron());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCitron_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCitron_morte());
                                    }
                                    break;
                                case comcombre:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoComcombre());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getICocomcombre_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoComcombre_morte());
                                    }
                                    break;
                                case cornichon:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCornichon());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCornichon_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoCornichon_morte());
                                    }
                                    break;
                                case haricot:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoHaricot());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoHaricot_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoHaricot_morte());
                                    }
                                    break;
                                case mais:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoMais());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoMais_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoMais_morte());
                                    }
                                    break;
                                case oignon:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoOignon());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoOignon_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoOignon_morte());
                                    }
                                    break;
                                case poivron:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPoivron());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPoivron_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPoivron_morte());
                                    }
                                    break;
                                case radis:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoRadis());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoRadis_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoRadis_morte());
                                    }
                                    break;
                                case salade:
                                    if (legume.etatlegume == "en plante") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante());
                                    } else if (legume.etatlegume == "en pousse") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoPlante_pousse());
                                    } else if (legume.etatlegume == "normal") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoSalade());
                                    } else if (legume.etatlegume == "variete") {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoSalade_variete());
                                    } else {
                                        tabJLabel[x][y].setIcon(cultivable.getIcoSalade_morte());
                                    }
                                    break;
                            }
                        } else if (fruit == null && legume == null && simulateurPotager.getCurrent_action_profil() == null) {
                            tabJLabel[x][y].setIcon(cultivable.getIcoTerre());
                        } else if (simulateurPotager.getCurrent_action_profil() != null) {
                            if (simulateurPotager.getCurrent_action_profil() == "mode_recolte") {
                                tabJLabel[x][y].setIcon(cultivable.getIcoTerre());
                            }
                            if (simulateurPotager.getCurrent_action_profil() == "mode_excaver") {
                                tabJLabel[x][y].setIcon(cultivable.getIcoTerre());
                            }
                        }
                    } else if (simulateurPotager.getPlateau()[x][y] instanceof CaseNonCultivable) {
                        tabJLabel[x][y].setIcon(cultivable.getIcoMur());
                    } else if (!(simulateurPotager.getPlateau()[x][y] instanceof CaseCultivable) && !(simulateurPotager.getPlateau()[x][y] instanceof CaseNonCultivable)) {
                        tabJLabel[x][y].setIcon(cultivable.getIcoVide());
                    } else if(simulateurPotager.getPlateau()[x][y] instanceof  CaseCultivable){
                        if(simulateurPotager.getCurrent_action_profil() == "mode_vente"){
                            tabJLabel[x][y].setIcon(cultivable.getIcoVide());
                        }
                    }
                }else{
                    tabJLabel[x][y].setIcon(cultivable.getIcoMur());
                }
            }
        }


    }

    @Override
    public void update(Observable o, Object arg) {
        mettreAJourAffichage();
        //Si le compte à rebour atteint 0 , le jeu s'arrête.
        if (simulateurPotager.fenetreRestart.getFin_compte()) {
            System.exit(0);
        }
    }


    //Cette méthode va servir à pouvoir gérer les interractions inter-fenetres , par exemple lorsque l'utilisateur clique sur un fruit/légume depuis la fenetre_action
    // le champ information de la fenetre_infos se met à jour.
    //
    public void gestion_fenetres_evenements(){


        fenetre_chrono.start();



        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                fenetre_infos.setTxtvaleur_temps_jeu(fenetre_chrono.getTimerLabelValue());
                fenetre_infos.setTxtvaleur_Vitesse(Integer.toString(fenetre_chrono.getSliderValue()));
            }
        }, 0, 10);


        fenetre_profil.getBouton_recolter().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulateurPotager.choix_curent("mode_recolte");
                simulateurPotager.setCurrent_graine_fruit(null);
                simulateurPotager.setCurrent_graine_legume(null);
                fenetre_infos.setTxtvaleur_action("Vous êtes en mode récolte");
            }
        });

        fenetre_profil.getBouton_engrais().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulateurPotager.choix_curent("mode_engrais");
                simulateurPotager.setCurrent_graine_fruit(null);
                simulateurPotager.setCurrent_graine_legume(null);
                fenetre_infos.setTxtvaleur_action("Vous êtes en mode engrais");
            }
        });


        fenetre_profil.getBouton_excaver().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulateurPotager.choix_curent("mode_excaver");
                simulateurPotager.setCurrent_graine_fruit(null);
                simulateurPotager.setCurrent_graine_legume(null);
                fenetre_infos.setTxtvaleur_action("Vous êtes en mode excavation");
            }
        });

        fenetre_profil.getBouton_vendre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulateurPotager.choix_curent("mode_vente");
                simulateurPotager.setCurrent_graine_fruit(null);
                simulateurPotager.setCurrent_graine_legume(null);
                fenetre_infos.setTxtvaleur_action("Vous êtes en mode vente");
            }
        });
        fenetre_profil.getBouton_poubelle().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulateurPotager.choix_curent("mode_excaver");
                simulateurPotager.setCurrent_graine_fruit(null);
                simulateurPotager.setCurrent_graine_legume(null);
                String evenement_prec=fenetre_infos.getTxtvaleur_action();
                fenetre_infos.setTxtvaleur_action("Vous avez vider votre inventaire ! ");

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        fenetre_infos.setTxtvaleur_action(evenement_prec);
                    }
                }, 3000); // Déclenche la tâche après 3000 ms (3 secondes)
            }
        });

        fenetre_profil.getBouton_inventaire().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fenetre_inventaire.setLocation(fenetre_profil.getLocation());
                fenetre_inventaire.setVisible(true);
            }
        });

        // Ajout d'un change listener pour mettre à jour les donnees relatives au slider ensoleillement
        fenetre_action.getSlider_Ensoleillement().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                fenetre_action.getTextField_ensoleillement().setText(Integer.toString(fenetre_action.getSlider_Ensoleillement().getValue()));
                fenetre_action.getTextField_ensoleillement().setVisible(true);
                fenetre_infos.setTxtvaleur_Ensoleillement(fenetre_action.getTextField_ensoleillement().getText());
                simulateurPotager.simMet.ActionEnsoleillement(fenetre_action.getSlider_Ensoleillement().getValue());
            }
        });

        // Ajout d'un change listener pour mettre à jour les donnees relatives au slider humidite
        fenetre_action.getSlider_humidite().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                fenetre_action.getTextField_humidite().setText(Integer.toString(fenetre_action.getSlider_humidite().getValue()));
                fenetre_action.getTextField_humidite().setVisible(true);
                fenetre_infos.setTxtvaleur_Humidite(fenetre_action.getTextField_humidite().getText());
                simulateurPotager.simMet.ActionHumidite(fenetre_action.getSlider_humidite().getValue());
            }
        });

        // Ajout d'un change listener pour mettre à jour les donnees relatives au slider vents
        fenetre_action.getSlider_vents().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                fenetre_action.getTextField_vents().setText(Integer.toString(fenetre_action.getSlider_vents().getValue()));
                fenetre_action.getTextField_vents().setVisible(true);
                fenetre_infos.setTxtvaleur_Vents(fenetre_action.getTextField_vents().getText());
                simulateurPotager.simMet.ActionVents(fenetre_action.getSlider_vents().getValue());
            }
        });




        fenetre_action.getCheckBox_pause_reprendre().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Le bouton a été coché
                    fenetre_action.getCheckBox_nuit_jour().setEnabled(false);
                    fenetre_action.getSlider_Ensoleillement().setEnabled(false);
                    fenetre_action.getSlider_humidite().setEnabled(false);
                    fenetre_action.getSlider_vents().setEnabled(false);
                    fenetre_action.getBtn_Fruit().setEnabled(false);
                    fenetre_action.getBtn_Legume().setEnabled(false);
                    fenetre_profil.getBouton_inventaire().setEnabled(false);
                    fenetre_profil.getBouton_poubelle().setEnabled(false);
                    fenetre_profil.getBouton_excaver().setEnabled(false);
                    fenetre_profil.getBouton_recolter().setEnabled(false);
                    fenetre_profil.getBouton_vendre().setEnabled(false);
                    simulateurPotager.choix_curent(null);
                    fenetre_chrono.pause();
                } else {
                    // Le bouton a été décoché
                    fenetre_action.getCheckBox_nuit_jour().setEnabled(true);
                    fenetre_action.getSlider_Ensoleillement().setEnabled(true);
                    fenetre_action.getSlider_humidite().setEnabled(true);
                    fenetre_action.getSlider_vents().setEnabled(true);
                    fenetre_action.getBtn_Fruit().setEnabled(true);
                    fenetre_action.getBtn_Legume().setEnabled(true);
                    fenetre_profil.getBouton_inventaire().setEnabled(true);
                    fenetre_profil.getBouton_poubelle().setEnabled(true);
                    fenetre_profil.getBouton_excaver().setEnabled(true);
                    fenetre_profil.getBouton_recolter().setEnabled(true);
                    fenetre_profil.getBouton_vendre().setEnabled(true);
                    fenetre_chrono.start();
                }
            }
        });


        //Mettre les fenetres suivantes visibles à l'écran initialement
        fenetre_action.setVisible(true);
        fenetre_profil.setVisible(true);
        fenetre_infos.setVisible(true);
        fenetre_inventaire.setVisible(false);
        fenetre_chrono.setVisible(true);


        simulateurPotager.fenetreInfos=fenetre_infos;
        simulateurPotager.fenetreProfil=fenetre_profil;
    }


}
