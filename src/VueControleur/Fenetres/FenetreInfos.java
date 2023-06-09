package VueControleur.Fenetres;

import javax.swing.*;

/*Cette classe permettra de pouvoir gérer le système d'informations en temps réels facilitant l'arrivée des informations à l'utilisateur
* Presque tous les évenements du jeu parviendrons à l'utilisateur.
**/
public class FenetreInfos extends JFrame {
    private JPanel infos = new JPanel();
    private static JTextArea txtaction = new JTextArea("Action en cours : ");
    private JTextArea txtvaleur_action = new JTextArea(" Aucune action en cours");
    private static JTextArea txttemps_jeu = new JTextArea("Temps de jeu : ");
    private JTextArea txtvaleur_temps_jeu = new JTextArea("0");
    private static JTextArea txtEnsoleillement = new JTextArea("Ensoleillement : ");
    private JTextArea txtvaleur_Ensoleillement = new JTextArea("30");
    private static JTextArea txtHumidite = new JTextArea("Humidité : ");
    private JTextArea txtvaleur_Humidite = new JTextArea("30");
    private static JTextArea txtVents = new JTextArea("Vents : ");
    private JTextArea txtvaleur_Vents = new JTextArea("30");
    private static JTextArea txtVitesse = new JTextArea("Vitesse : ");
    private JTextArea txtvaleur_Vitesse = new JTextArea("0");
    private static JTextArea txtinformations = new JTextArea("Information : ");
    private JTextArea txtvaleur_informations = new JTextArea("Rien de nouveau sous le soleil ... ");
    public FenetreInfos(){
        super("Informations");
        this.setSize(1000, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Positionnement des JTextArea
        txtaction.setBounds(0, 0, 90, 20);
        txtvaleur_action.setBounds(txtaction.getX()+90,txtaction.getY(),1000,20);
        txttemps_jeu.setBounds(0, 20, 90, 20);
        txtvaleur_temps_jeu.setBounds(txttemps_jeu.getX()+90,txttemps_jeu.getY(),50,20);

        txtEnsoleillement.setBounds(0,40,90,20);
        txtvaleur_Ensoleillement.setBounds(txtEnsoleillement.getX()+90,txtEnsoleillement.getY(),20,20);

        txtHumidite.setBounds(txtvaleur_Ensoleillement.getX()+20,txtvaleur_Ensoleillement.getY(),60,20);
        txtvaleur_Humidite.setBounds(txtHumidite.getX()+60,txtHumidite.getY(),20,20);

        txtVents.setBounds(txtvaleur_Humidite.getX()+20,txtvaleur_Humidite.getY(),40,20);
        txtvaleur_Vents.setBounds(txtVents.getX()+40,txtVents.getY(),20,20);

        txtVitesse.setBounds(txtvaleur_Vents.getX()+20,txtvaleur_Vents.getY(),50,20);
        txtvaleur_Vitesse.setBounds(txtVitesse.getX()+50,txtVitesse.getY(),20,20);

        txtinformations.setBounds(0, 60, 70, 20);
        txtvaleur_informations.setBounds(txtinformations.getX()+70,txtinformations.getY(),1000,20);

        //Les JtxtArea deviennent non editable (la saisie clavier est interdite pour éviter la modification des valeurs)
        txtaction.setEditable(false);
        txttemps_jeu.setEditable(false);
        txtinformations.setEditable(false);
        txtEnsoleillement.setEditable(false);
        txtHumidite.setEditable(false);
        txtVents.setEditable(false);
        txtVitesse.setEditable(false);
        txtvaleur_action.setEditable(false);
        txtvaleur_temps_jeu.setEditable(false);
        txtvaleur_informations.setEditable(false);
        txtvaleur_Ensoleillement.setEditable(false);
        txtvaleur_Humidite.setEditable(false);
        txtvaleur_Vents.setEditable(false);
        txtvaleur_Vitesse.setEditable(false);

        // Ajout des JTextArea au panel infos
        infos.setLayout(null);
        infos.add(txtaction);
        infos.add(txttemps_jeu);
        infos.add(txtinformations);
        infos.add(txtEnsoleillement);
        infos.add(txtHumidite);
        infos.add(txtVents);
        infos.add(txtVitesse);

        infos.add(txtvaleur_action);
        infos.add(txtvaleur_temps_jeu);
        infos.add(txtvaleur_informations);
        infos.add(txtvaleur_Ensoleillement);
        infos.add(txtvaleur_Humidite);
        infos.add(txtvaleur_Vents);
        infos.add(txtvaleur_Vitesse);

        // Ajout du panel infos à la fenêtre
        this.add(infos);
    }

    public String getTxtvaleur_action() {
        return txtvaleur_action.getText();
    }
    public void setTxtvaleur_action(String valeur) {
        this.txtvaleur_action.setText(valeur);
    }

    public void setTxtvaleur_temps_jeu(String valeur) {
        this.txtvaleur_temps_jeu.setText(valeur);
    }

    public void setTxtvaleur_Ensoleillement(String valeur) {
        this.txtvaleur_Ensoleillement.setText(valeur);
    }

    public void setTxtvaleur_Humidite(String valeur) {
        this.txtvaleur_Humidite.setText(valeur);
    }

    public void setTxtvaleur_Vents(String valeur) {
        this.txtvaleur_Vents.setText(valeur);
    }

    public void setTxtvaleur_Vitesse(String valeur) {
        this.txtvaleur_Vitesse.setText(valeur);
    }

    public void setTxtvaleur_informations(String valeur) {
        this.txtvaleur_informations.setText(valeur);
    }

}


