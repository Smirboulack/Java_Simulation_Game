package VueControleur.Fenetres;

import VueControleur.Affichables;
import VueControleur.BoutonRond;

import javax.swing.*;
import java.awt.*;

/*Cette classe permettra de pouvoir selectionner une action (excaver , récolter , engrais , inventaire)*/
public class FenetreProfil extends JFrame {
    // Création d'un panel pour la fenetre_profil
    private JPanel Pannel_fenetre_profil;
    private JLabel labelBourse;
    private JLabel labelValeur_bourse;
    private float bourse=20;
    // Création des boutons ronds DANS fenetre_profil
    private BoutonRond bouton_excaver;
    private BoutonRond bouton_recolter;
    private BoutonRond bouton_vendre;
    private BoutonRond bouton_inventaire;
    private BoutonRond bouton_poubelle;
    private BoutonRond bouton_engrais;
    // Création des JLabels pour les titres
    private JLabel labelTitreExcaver;
    private JLabel labelTitreRecolter;
    private JLabel labelTitreInventaire;
    private JLabel labelTitreVendre;
    private JLabel labelTitrePoubelle;
    private JLabel labelTitreEngrais;
    // Mise en forme des titres en gras
    private Font fontGras;
    // Création de JLabels pour afficher des icones images dans la fenetre_profil
    private JLabel labelExcaver;
    private JLabel labelRecolter;
    private JLabel labelInventaire;
    private JLabel labelVendre;
    private JLabel labelPoubelle;
    private JLabel labelEngrais;


    public FenetreProfil(Affichables cultivable) {

        super("Profil");
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        labelBourse = new JLabel("Bourse € ");
        labelValeur_bourse=new JLabel();

        Pannel_fenetre_profil = new JPanel();
        Pannel_fenetre_profil.setBackground(Color.orange);
        Pannel_fenetre_profil.setLayout(null);

        labelBourse.setFont(new Font("Arial", Font.BOLD, 24));
        labelBourse.setBounds(60, 30, 110, 50);
        labelBourse.setBackground(Color.gray);
        labelBourse.setOpaque(true);

        labelValeur_bourse.setFont(new Font("Arial", Font.BOLD, 24));
        labelValeur_bourse.setBounds(labelBourse.getX()+110, labelBourse.getY(), 100, 50);
        labelValeur_bourse.setBackground(Color.gray);
        labelValeur_bourse.setOpaque(true);
        labelValeur_bourse.setText(Float.toString(bourse));


        // Ajout du panel à la fenêtre_profil
        this.add(Pannel_fenetre_profil);
        Pannel_fenetre_profil.add(labelBourse);
        Pannel_fenetre_profil.add(labelValeur_bourse);

        bouton_excaver = new BoutonRond(Color.GRAY);
        bouton_recolter = new BoutonRond(Color.BLUE);
        bouton_vendre = new BoutonRond(Color.YELLOW);
        bouton_inventaire = new BoutonRond(Color.BLUE);
        bouton_poubelle = new BoutonRond(Color.RED);
        bouton_engrais = new BoutonRond(Color.green);

        bouton_excaver.setBounds(150, 100, 100, 100);
        bouton_recolter.setBounds(75, 210, 100, 100);
        bouton_vendre.setBounds(150, 320, 100, 100);
        bouton_inventaire.setBounds(150,430,100,100);
        bouton_poubelle.setBounds(150,540,100,100);
        bouton_engrais.setBounds(bouton_recolter.getX()+150,bouton_recolter.getY(),100,100);
        bouton_excaver.setVisible(true);
        bouton_recolter.setVisible(true);
        bouton_vendre.setVisible(true);
        bouton_inventaire.setVisible(true);
        bouton_poubelle.setVisible(true);
        bouton_engrais.setVisible(true);

        labelTitreExcaver = new JLabel("Excaver");
        labelTitreRecolter = new JLabel("Récolter");
        labelTitreInventaire = new JLabel("Inventaire");
        labelTitreVendre = new JLabel("Vendre");
        labelTitrePoubelle = new JLabel("Poubelle");
        labelTitreEngrais = new JLabel("Engrais");

        fontGras = new Font("Arial", Font.BOLD, 12);
        labelTitreExcaver.setFont(fontGras);
        labelTitreRecolter.setFont(fontGras);
        labelTitreInventaire.setFont(fontGras);
        labelTitreVendre.setFont(fontGras);
        labelTitrePoubelle.setFont(fontGras);
        labelTitreEngrais.setFont(fontGras);

        // Positionnement des titres
        labelTitreExcaver.setBounds(bouton_excaver.getX()-50, bouton_excaver.getY(), bouton_excaver.getWidth(), 20);
        labelTitreRecolter.setBounds(bouton_recolter.getX()-50, bouton_recolter.getY(), bouton_recolter.getWidth()-10, 20);
        labelTitreVendre.setBounds(bouton_vendre.getX()-50, bouton_vendre.getY(), bouton_vendre.getWidth(), 20);
        labelTitreInventaire.setBounds(bouton_inventaire.getX()-50, bouton_inventaire.getY(), bouton_inventaire.getWidth(), 20);
        labelTitrePoubelle.setBounds(bouton_poubelle.getX()-50, bouton_poubelle.getY(), bouton_poubelle.getWidth(), 20);
        labelTitreEngrais.setBounds(bouton_engrais.getX()+100,bouton_engrais.getY(),bouton_engrais.getWidth(),20);

        labelExcaver = new JLabel(cultivable.getIcoExcaver());
        labelRecolter = new JLabel(cultivable.getIcoRecolter());
        labelInventaire = new JLabel(cultivable.getIcoInventaire());
        labelVendre = new JLabel(cultivable.getIcoVendre());
        labelPoubelle = new JLabel(cultivable.getIcoPoubelle());
        labelEngrais = new JLabel(cultivable.getIcoEngrais());

        //Positionnement des Labels images
        labelExcaver.setBounds(bouton_excaver.getX(),bouton_excaver.getY(),bouton_excaver.getWidth(),bouton_excaver.getHeight());
        labelRecolter.setBounds(bouton_recolter.getX(),bouton_recolter.getY(),bouton_recolter.getWidth()-10,bouton_recolter.getHeight());
        labelVendre.setBounds(bouton_vendre.getX()-5,bouton_vendre.getY(),bouton_vendre.getWidth(),bouton_vendre.getHeight());
        labelInventaire.setBounds(bouton_inventaire.getX(),bouton_inventaire.getY(),bouton_inventaire.getWidth(),bouton_inventaire.getHeight());
        labelPoubelle.setBounds(bouton_poubelle.getX(),bouton_poubelle.getY(),bouton_poubelle.getWidth(),bouton_poubelle.getHeight());
        labelEngrais.setBounds(bouton_engrais.getX(),bouton_engrais.getY(),bouton_engrais.getWidth(),bouton_engrais.getHeight());
        // Ajout des boutons et images au panel de la fenetre_profil
        Pannel_fenetre_profil.add(labelExcaver);
        Pannel_fenetre_profil.add(labelRecolter);
        Pannel_fenetre_profil.add(labelInventaire);
        Pannel_fenetre_profil.add(labelVendre);
        Pannel_fenetre_profil.add(labelPoubelle);
        Pannel_fenetre_profil.add(labelEngrais);


        Pannel_fenetre_profil.add(bouton_excaver);
        Pannel_fenetre_profil.add(bouton_recolter);
        Pannel_fenetre_profil.add(bouton_inventaire);
        Pannel_fenetre_profil.add(bouton_vendre);
        Pannel_fenetre_profil.add(bouton_poubelle);
        Pannel_fenetre_profil.add(bouton_engrais);
        // Ajout des titres au panel de la fenetre_profil
        Pannel_fenetre_profil.add(labelTitreExcaver);
        Pannel_fenetre_profil.add(labelTitreRecolter);
        Pannel_fenetre_profil.add(labelTitreInventaire);
        Pannel_fenetre_profil.add(labelTitreVendre);
        Pannel_fenetre_profil.add(labelTitrePoubelle);
        Pannel_fenetre_profil.add(labelTitreEngrais);


    }

    public JLabel getLabelValeur_bourse() {
        return labelValeur_bourse;
    }

    public float getBourse() {
        return bourse;
    }

    public BoutonRond getBouton_excaver() {
        return bouton_excaver;
    }

    public BoutonRond getBouton_recolter() {
        return bouton_recolter;
    }

    public BoutonRond getBouton_vendre() {
        return bouton_vendre;
    }

    public BoutonRond getBouton_inventaire() {
        return bouton_inventaire;
    }

    public BoutonRond getBouton_poubelle() {
        return bouton_poubelle;
    }
    public BoutonRond getBouton_engrais() {
        return bouton_engrais;
    }

    public void setBourse(float value) {
        this.bourse = value;
    }


}

