package VueControleur.Fenetres;

import VueControleur.Affichables;
import VueControleur.BoutonRond;
import modele.SimulateurPotager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/*Cette classe permettra de pouvoir selectionner les fruits ou légumes , de parametrer les variables météorologique grâce aux boutons JSlider*/
public class FenetreAction extends JFrame {
    private JLabel labelAil;
    private JLabel labelAnanas;
    private JLabel labelAubergine;
    private JLabel labelAvocat;
    private JLabel labelBrocoli ;
    private JLabel labelCarotte ;
    private JLabel labelChampignon;
    private JLabel labelChoufleur;
    private JLabel labelCitron;
    private JLabel labelComcombre;
    private JLabel labelCornichon;
    private JLabel labelFraise;
    private JLabel labelHarricot ;
    private JLabel labelMais;
    private JLabel labelMelon ;
    private JLabel labelOignon;
    private JLabel labelOrange;
    private JLabel labelPasteque;
    private JLabel labelPoire ;
    private JLabel labelPoivron ;
    private JLabel labelRadis ;
    private JLabel labelSalade;
    private JLabel labelTomate;
    private JPanel panelBoutons_fenetre_action;
    private JLabel TableauxJlab_fruits[]= new JLabel[7];
    private JLabel TableauxJlab_legumes[]= new JLabel[16];
    public BoutonRond TableauxBoutonsRond_fruits[]=new BoutonRond[TableauxJlab_fruits.length];
    public BoutonRond TableauxBoutonsRond_legumes[]= new BoutonRond[TableauxJlab_legumes.length];
    private Border border_Humidite;
    private Border border_Ensoleillement;
    private Border border_Vents;
    private JCheckBox checkBox_nuit_jour;
    private JCheckBox checkBox_pause_reprendre;
    private JButton btn_Fruit;
    private JButton btn_Legume;
    private JButton btn_simulation;
    // Création du bouton-variateur humidité
    private JSlider slider_humidite;
    // Création du bouton-variateur Ensoleillement
    private JSlider slider_Ensoleillement;
    // Création du bouton-variateur vents
    private JSlider slider_vents;
    // Création du champ de texte pour les sliders et boutons de la fenetre_action
    private JTextField textField_humidite;
    private JTextField textField_ensoleillement;
    private JTextField textField_vents;
    private JTextField textField_fruits;
    private JTextField textField_legumes;

    public FenetreAction(SimulateurPotager simulateurPotager, Affichables cultivable) {

        super("Action");
        this.setSize(380, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Création d'un panel pour les boutons sur fenetre_action
        panelBoutons_fenetre_action = new JPanel();
        panelBoutons_fenetre_action.setLayout(null); // Utilisation d'un layout null pour pouvoir positionner les boutons avec setBounds

         checkBox_nuit_jour = new JCheckBox("Mode nuit/jour");
         checkBox_pause_reprendre = new JCheckBox("Pause/Resume Game");
          btn_Fruit = new JButton("Fruits");
          btn_Legume = new JButton("Legumes");
          btn_simulation = new JButton("Mode Simulation");
        //Creation des borders pour les boutons-variateurs
        border_Humidite = BorderFactory.createTitledBorder("Humidité");
        border_Ensoleillement = BorderFactory.createTitledBorder("Ensoleillement");
        border_Vents = BorderFactory.createTitledBorder("Vents");
        // Création du bouton-variateur humidité
          slider_humidite = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
        // Création du bouton-variateur Ensoleillement
          slider_Ensoleillement = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
        // Création du bouton-variateur vents
          slider_vents = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);

          textField_humidite = new JTextField();
          textField_ensoleillement = new JTextField();
          textField_vents = new JTextField();
          textField_fruits = new JTextField();
          textField_legumes = new JTextField();
        // Ajout des boutons au panel de la fenetre_action
        panelBoutons_fenetre_action.add(slider_humidite);
        panelBoutons_fenetre_action.add(slider_Ensoleillement);
        panelBoutons_fenetre_action.add(slider_vents);
        panelBoutons_fenetre_action.add(textField_humidite);
        panelBoutons_fenetre_action.add(textField_ensoleillement);
        panelBoutons_fenetre_action.add(textField_vents);
        panelBoutons_fenetre_action.add(textField_fruits);
        panelBoutons_fenetre_action.add(textField_legumes);
        panelBoutons_fenetre_action.add(btn_Fruit);
        panelBoutons_fenetre_action.add(btn_Legume);
        panelBoutons_fenetre_action.add(btn_simulation);
        panelBoutons_fenetre_action.add(checkBox_nuit_jour);
        panelBoutons_fenetre_action.add(checkBox_pause_reprendre);

        // Création de JLabels pour afficher des icones images dans la fenetre_action
        labelAil = new JLabel(cultivable.getIcoAil_action());
        labelAnanas = new JLabel(cultivable.getIcoAnanas_action());
        labelAubergine = new JLabel(cultivable.getIcoAubergine_action());
        labelAvocat = new JLabel(cultivable.getIcoAvocat_action());
        labelBrocoli = new JLabel(cultivable.getIcoBrocoli_action());
        labelCarotte = new JLabel(cultivable.getIcoCarotte_action());
        labelChampignon = new JLabel(cultivable.getIcoChampignon_action());
        labelChoufleur = new JLabel(cultivable.getIcoChoufleur_action());
        labelCitron = new JLabel(cultivable.getIcoCitron_action());
        labelComcombre = new JLabel(cultivable.getIcoComcombre_action());
        labelCornichon = new JLabel(cultivable.getIcoCornichon_action());
        labelFraise = new JLabel(cultivable.getIcoFraise_action());
        labelHarricot = new JLabel(cultivable.getIcoHaricot_action());
        labelMais = new JLabel(cultivable.getIcoMais_action());
        labelMelon = new JLabel(cultivable.getIcoMelon_action());
        labelOignon = new JLabel(cultivable.getIcoOignon_action());
        labelOrange = new JLabel(cultivable.getIcoOrange_action());
        labelPasteque = new JLabel(cultivable.getIcoPasteque_action());
        labelPoire = new JLabel(cultivable.getIcoPoire_action());
        labelPoivron = new JLabel(cultivable.getIcoPoivron_action());
        labelRadis = new JLabel(cultivable.getIcoRadis_action());
        labelSalade = new JLabel(cultivable.getIcoSalade_action());
        labelTomate = new JLabel(cultivable.getIcoTomate_action());

        TableauxJlab_fruits[0]=labelAnanas;
        TableauxJlab_fruits[1]=labelFraise;
        TableauxJlab_fruits[2]=labelMelon;
        TableauxJlab_fruits[3]=labelOrange;
        TableauxJlab_fruits[4]=labelPasteque;
        TableauxJlab_fruits[5]=labelPoire;
        TableauxJlab_fruits[6]=labelTomate;

        TableauxJlab_legumes[0]=labelAil;
        TableauxJlab_legumes[1]=labelAubergine;
        TableauxJlab_legumes[2]=labelAvocat;
        TableauxJlab_legumes[3]=labelBrocoli;
        TableauxJlab_legumes[4]=labelCarotte;
        TableauxJlab_legumes[5]=labelChampignon;
        TableauxJlab_legumes[6]=labelChoufleur;
        TableauxJlab_legumes[7]=labelCitron;
        TableauxJlab_legumes[8]=labelComcombre;
        TableauxJlab_legumes[9]=labelCornichon;
        TableauxJlab_legumes[10]=labelHarricot;
        TableauxJlab_legumes[11]=labelMais;
        TableauxJlab_legumes[12]=labelOignon;
        TableauxJlab_legumes[13]=labelPoivron;
        TableauxJlab_legumes[14]=labelRadis;
        TableauxJlab_legumes[15]=labelSalade;


        for(int i=0;i<TableauxJlab_fruits.length;i++){
            BoutonRond btntempo = new BoutonRond(Color.WHITE);
            TableauxBoutonsRond_fruits[i] = btntempo;
        }

        for(int i=0;i<TableauxJlab_legumes.length;i++){
            BoutonRond btntempo = new BoutonRond(Color.WHITE);
            TableauxBoutonsRond_legumes[i] = btntempo;
        }

        int pos_x_initial = 50;
        int pos_y_initial = 50;
        int col_count = 0;
        int col_max = 3;

        // Positionnement du JLabel sur la fenetre_action
        for (int i = 0; i < TableauxJlab_fruits.length; i++) {
            TableauxJlab_fruits[i].setBounds(pos_x_initial + col_count * 100, pos_y_initial, 60, 60);
            TableauxBoutonsRond_fruits[i].setBounds(pos_x_initial + col_count * 100, pos_y_initial, 60, 60);
            col_count++;
            if (col_count >= col_max) {
                col_count = 0;
                pos_y_initial += 75;
            }
        }

        int pos_y_initial2 = 50;
        int col_count2 = 0;
        int col_max2 = 3;
        // Positionnement du JLabel sur la fenetre_action
        for (int i = 0; i < TableauxJlab_legumes.length; i++) {
            TableauxJlab_legumes[i].setBounds(pos_x_initial + col_count2 * 100, pos_y_initial2, 60, 60);
            TableauxBoutonsRond_legumes[i].setBounds(pos_x_initial + col_count2 * 100, pos_y_initial2, 60, 60);
            col_count2++;
            if (col_count2 >= col_max2) {
                col_count2 = 0;
                pos_y_initial2 += 75;
            }
        }

        // Ajout du panel à la fenetre_action
        this.add(panelBoutons_fenetre_action);
        // Ajout du JLabel au panelBoutons_fenetre_action
        for(int i=0;i<TableauxJlab_fruits.length;i++){
            panelBoutons_fenetre_action.add(TableauxJlab_fruits[i]);
        }
        for(int i=0;i<TableauxJlab_legumes.length;i++){
            panelBoutons_fenetre_action.add(TableauxJlab_legumes[i]);
        }

        for(int i=0;i< TableauxBoutonsRond_fruits.length;i++){
            panelBoutons_fenetre_action.add(TableauxBoutonsRond_fruits[i]);
        }
        for(int i=0;i< TableauxBoutonsRond_legumes.length;i++){
            panelBoutons_fenetre_action.add(TableauxBoutonsRond_legumes[i]);
            TableauxBoutonsRond_legumes[i].setVisible(false);
            TableauxJlab_legumes[i].setVisible(false);
        }

        checkBox_nuit_jour.setFont(new Font("Arial", Font.BOLD, 14)); // changer la police en gras
        checkBox_nuit_jour.setBounds(100,300,200,30);
        checkBox_pause_reprendre.setFont(new Font("Arial", Font.BOLD, 14)); // changer la police en gras
        checkBox_pause_reprendre.setBounds(100,320,200,30);
        checkBox_nuit_jour.setVisible(false);
        checkBox_pause_reprendre.setVisible(false);

        btn_Fruit.setBounds(0, 0, 100, 30);
        btn_Fruit.setBackground(Color.WHITE);
        btn_Legume.setBounds(110, 0, 100, 30);
        btn_Legume.setBackground(Color.RED);
        btn_simulation.setBounds(220, 0, 150, 30);
        btn_simulation.setBackground(Color.GREEN);

        slider_humidite.setMajorTickSpacing(20);
        slider_humidite.setMinorTickSpacing(5);
        slider_humidite.setPaintTicks(true);
        slider_humidite.setPaintLabels(true);
        slider_humidite.setBounds(50, 50, 300, 60);
        slider_humidite.setVisible(false);

        slider_Ensoleillement.setMajorTickSpacing(20);
        slider_Ensoleillement.setMinorTickSpacing(5);
        slider_Ensoleillement.setPaintTicks(true);
        slider_Ensoleillement.setPaintLabels(true);
        slider_Ensoleillement.setBounds(50, 110, 300, 60);
        slider_Ensoleillement.setVisible(false);

        slider_vents.setMajorTickSpacing(20);
        slider_vents.setMinorTickSpacing(5);
        slider_vents.setPaintTicks(true);
        slider_vents.setPaintLabels(true);
        slider_vents.setBounds(50, 170, 300, 60);
        slider_vents.setVisible(false);

        // Ajout des bordures aux boutons-sliders
        slider_humidite.setBorder(border_Humidite);
        slider_Ensoleillement.setBorder(border_Ensoleillement);
        slider_vents.setBorder(border_Vents);

        textField_humidite.setBounds(20, 50, 20, 20);
        textField_ensoleillement.setBounds(20, 110, 20, 20);
        textField_vents.setBounds(20, 180, 20, 20);
        textField_humidite.setVisible(false);
        textField_ensoleillement.setVisible(false);
        textField_vents.setVisible(false);
        textField_fruits.setVisible(false);
        textField_legumes.setVisible(false);


        btn_Fruit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slider_humidite.setVisible(false);
                slider_Ensoleillement.setVisible(false);
                slider_vents.setVisible(false);
                textField_humidite.setVisible(false);
                textField_ensoleillement.setVisible(false);
                textField_vents.setVisible(false);

                textField_legumes.setVisible(false);
                checkBox_nuit_jour.setVisible(false);
                checkBox_pause_reprendre.setVisible(false);
                for(int i=0;i<TableauxJlab_fruits.length;i++){
                    TableauxJlab_fruits[i].setVisible(true);
                    TableauxBoutonsRond_fruits[i].setVisible(true);
                }
                for(int i=0;i<TableauxJlab_legumes.length;i++){
                    TableauxBoutonsRond_legumes[i].setVisible(false);
                    TableauxJlab_legumes[i].setVisible(false);
                }
                simulateurPotager.setCurrent_graine_legume(null);
            }
        });

        btn_Legume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slider_humidite.setVisible(false);
                slider_Ensoleillement.setVisible(false);
                slider_vents.setVisible(false);
                textField_humidite.setVisible(false);
                textField_ensoleillement.setVisible(false);
                textField_vents.setVisible(false);
                textField_fruits.setVisible(false);
                textField_legumes.setVisible(true);
                checkBox_nuit_jour.setVisible(false);
                checkBox_pause_reprendre.setVisible(false);
                for(int i=0;i<TableauxJlab_fruits.length;i++){
                    TableauxJlab_fruits[i].setVisible(false);
                    TableauxBoutonsRond_fruits[i].setVisible(false);
                }
                for(int i=0;i<TableauxJlab_legumes.length;i++){
                    TableauxBoutonsRond_legumes[i].setVisible(true);
                    TableauxJlab_legumes[i].setVisible(true);
                }
                simulateurPotager.setCurrent_graine_fruit(null);
            }
        });

        // Action listener pour le bouton btn3
        btn_simulation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Afficher ou cacher le slider selon sa visibilité actuelle
                slider_humidite.setVisible(true);
                slider_Ensoleillement.setVisible(true);
                slider_vents.setVisible(true);
                textField_fruits.setVisible(false);
                checkBox_nuit_jour.setVisible(true);
                checkBox_pause_reprendre.setVisible(true);
                for(int i=0;i<TableauxJlab_fruits.length;i++){
                    TableauxJlab_fruits[i].setVisible(false);
                    TableauxBoutonsRond_fruits[i].setVisible(false);
                }
                for(int i=0;i<TableauxJlab_legumes.length;i++){
                    TableauxBoutonsRond_legumes[i].setVisible(false);
                    TableauxJlab_legumes[i].setVisible(false);
                }
            }
        });

        // Ajouter un ActionListener sur le champ de texte du slider_humidite
        textField_humidite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer la valeur entrée dans le champ de texte
                String text = textField_humidite.getText();
                int value = Integer.parseInt(text);

                // Mettre à jour la valeur du slider
                slider_humidite.setValue(value);
            }
        });

        // Ajouter un ActionListener sur le champ de texte du slider_ensoleillement
        textField_ensoleillement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer la valeur entrée dans le champ de texte
                String text = textField_ensoleillement.getText();
                int value = Integer.parseInt(text);
                // Mettre à jour la valeur du slider
                slider_Ensoleillement.setValue(value);
            }
        });

        // Ajouter un ActionListener sur le champ de texte du slider_vents
        textField_vents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer la valeur entrée dans le champ de texte
                String text = textField_vents.getText();
                int value = Integer.parseInt(text);
                // Mettre à jour la valeur du slider
                slider_vents.setValue(value);
            }
        });


        checkBox_nuit_jour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Le bouton a été coché, on change la couleur de fond en noir
                    panelBoutons_fenetre_action.setBackground(Color.BLACK);
                    textField_ensoleillement.setText(Integer.toString(0));
                    slider_Ensoleillement.setValue(0); // Mettre le slider à 0
                    slider_Ensoleillement.setEnabled(false); // désactiver le slider
                } else {
                    // Le bouton a été décoché, on enlève la couleur de fond
                    panelBoutons_fenetre_action.setBackground(null);
                    slider_Ensoleillement.setEnabled(true); // réactiver le slider
                    textField_ensoleillement.setText(Integer.toString(50));
                    slider_Ensoleillement.setValue(50); // Mettre le slider à 0
                }
            }
        });

        for (int i = 0; i < TableauxBoutonsRond_legumes.length; i++) {
            final int index = i; // variable finale pour stocker l'index de chaque bouton
            TableauxBoutonsRond_legumes[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            textField_legumes.setText("Ail");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("ail");
                            break;
                        case 1:
                            textField_legumes.setText("Aubergine");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("aubergine");
                            break;
                        case 2:
                            textField_legumes.setText("Avocat");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("avocat");
                            break;
                        case 3:
                            textField_legumes.setText("Brocoli");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("brocoli");
                            break;
                        case 4:
                            textField_legumes.setText("Carotte");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("carotte");
                            break;
                        case 5:
                            textField_legumes.setText("Champignon");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("champignon");
                            break;
                        case 6:
                            textField_legumes.setText("Choufleur");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("choufleur");
                            break;
                        case 7:
                            textField_legumes.setText("Citron");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("citron");
                            break;
                        case 8:
                            textField_legumes.setText("Comcombre");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("comcombre");
                            break;
                        case 9:
                            textField_legumes.setText("Cornichon");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("cornichon");
                            break;
                        case 10:
                            textField_legumes.setText("Haricot");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("haricot");
                            break;
                        case 11:
                            textField_legumes.setText("Mais");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("mais");
                            break;
                        case 12:
                            textField_legumes.setText("Oignon");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("oignon");
                            break;
                        case 13:
                            textField_legumes.setText("Poivron");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("poivron");
                            break;
                        case 14:
                            textField_legumes.setText("Radis");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("radis");
                            break;
                        case 15:
                            textField_legumes.setText("Salade");
                            textField_legumes.setBounds(TableauxBoutonsRond_legumes[index].getX(), TableauxBoutonsRond_legumes[index].getY()+5, 80, 20);
                            textField_legumes.setEditable(false);
                            textField_legumes.setVisible(true);
                            simulateurPotager.choix_curent("salade");
                            break;
                        // ajouter des cas pour chaque bouton

                    }
                }
            });
        }

        for (int i = 0; i < TableauxBoutonsRond_fruits.length; i++) {
            final int index = i; // variable finale pour stocker l'index de chaque bouton
            TableauxBoutonsRond_fruits[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            textField_fruits.setText("Ananas");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("ananas");
                            break;
                        case 1:

                            textField_fruits.setText("Fraise");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("fraise");
                            break;
                        case 2:

                            textField_fruits.setText("Melon");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("melon");
                            break;
                        case 3:

                            textField_fruits.setText("Orange");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("orange");
                            break;
                        case 4:

                            textField_fruits.setText("Pasteque");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("pasteque");
                            break;
                        case 5:
                            textField_fruits.setText("Poire");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("poire");
                            break;
                        case 6:
                            textField_fruits.setText("Tomate");
                            textField_fruits.setBounds(TableauxBoutonsRond_fruits[index].getX(), TableauxBoutonsRond_fruits[index].getY()+5, 60, 20);
                            textField_fruits.setEditable(false);
                            textField_fruits.setVisible(true);
                            simulateurPotager.choix_curent("tomate");
                            break;
                        // ajouter des cas pour chaque bouton
                    }
                }
            });
        }
    }

    public void reinit_action(){
        slider_Ensoleillement.setValue(30);
        slider_vents.setValue(30);
        slider_humidite.setValue(30);
    }

    public JCheckBox getCheckBox_nuit_jour() {
        return checkBox_nuit_jour;
    }

    public JCheckBox getCheckBox_pause_reprendre() {
        return checkBox_pause_reprendre;
    }

    public JButton getBtn_Fruit() {
        return btn_Fruit;
    }

    public JButton getBtn_Legume() {
        return btn_Legume;
    }

    public JSlider getSlider_humidite() {
        return slider_humidite;
    }

    public JSlider getSlider_vents(){
        return slider_vents;
    }


    public JSlider getSlider_Ensoleillement() {
        return slider_Ensoleillement;
    }

    public JTextField getTextField_vents() {
        return textField_vents;
    }

    public JTextField getTextField_ensoleillement(){
        return textField_ensoleillement;
    }
    public JTextField getTextField_humidite(){
        return textField_humidite;
    }



}