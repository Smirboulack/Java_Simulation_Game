package VueControleur.Fenetres;

import modele.SimulateurPotager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*Cette classe permettra de pouvoir gérer le système de Game Over , cette fenêtre contient un Timer décremental de 10 à 0 , une fois le Timer à 0 le programme s'achève
 * Si l'utilisateur clique sur le bouton Recommencer, la partie peut redémarrer en faisant appel à la méthode réinitialiser de simulateurPotager.
*  */
public class FenetreRestart extends JFrame {

    private JLabel labelTemps;
    private JLabel labelMessage;
    private JButton boutonRecommencer;
    private Timer timer;
    private int tempsRestant = 10;
    private boolean arret=true;
    private boolean fin_compte=false;
    private SimulateurPotager simpot;
    public FenetreRestart(SimulateurPotager _simpot, FenetreChrono fenetre_chrono) {
        super("Game Over");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        simpot=_simpot;

        // Mettre la fenetre au milieu de l'écran.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;
        this.setLocation(centerX, centerY);

        // Création du label pour le temps
        labelTemps = new JLabel("10");
        labelTemps.setFont(new Font("Arial", Font.BOLD, 20));
        labelTemps.setHorizontalAlignment(SwingConstants.CENTER);

        // Création du label pour le message "continue ?"
        labelMessage = new JLabel("GAME OVER , CONTINUE ?");
        labelMessage.setFont(new Font("Arial", Font.PLAIN, 18));
        labelMessage.setHorizontalAlignment(SwingConstants.CENTER);

        // Création d'un panel pour contenir les labels temps et message
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(labelTemps, BorderLayout.NORTH);
        panel.add(labelMessage, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);

        // Création du bouton de redémarrage
        boutonRecommencer = new JButton("Recommencer");
        boutonRecommencer.setBackground(Color.GREEN);
        boutonRecommencer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Annulation du timer et réinitialisation du compte à rebours
                timer.stop();
                tempsRestant=10;
                arret=false;
                simpot.setGame_over(false);
                simpot.simMet.getTemps().setEn_pause(false);
                simpot.reinitialisation();
                fenetre_chrono.reinitialiser_chrono();
                dispose();
            }
        });
        this.add(boutonRecommencer, BorderLayout.SOUTH);

        // Affichage de la fenêtre
        this.setSize(300, 150);
        this.setVisible(false);
    }
    public void demarrer_decompte(){
        // Création du timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempsRestant--;
                labelTemps.setText(Integer.toString(tempsRestant));
                if (tempsRestant == 0 && arret==true) {
                    // Arrêt du timer lorsque le temps est écoulé
                    timer.stop();
                    boutonRecommencer.setEnabled(false);
                    fin_compte=true;
                    dispose();
                }
            }
        });
        timer.start();
    }

    public boolean getFin_compte(){
        return fin_compte;
    }

}