
import VueControleur.VueControleurPotager;
import modele.Ordonnanceur;
import modele.SimulateurPotager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Main {

    private static boolean musiqueEnPause = false;
    private static Clip clip = null;

    //Methode simple permettant de lancer/arrêter une piste audio au format wav uniquement .
    public static void charger_audio() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./audio/River.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            // Ajout du LineListener pour mettre en pause la musique
            clip.addLineListener(event -> {
                if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                    if (!musiqueEnPause) {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimulateurPotager simulateurPotager = new SimulateurPotager();

        VueControleurPotager vc = new VueControleurPotager(simulateurPotager);
        vc.setVisible(true);

        Ordonnanceur.getOrdonnanceur().addObserver(vc);
        Ordonnanceur.getOrdonnanceur().start(300);

        charger_audio();

        // Ajout du KeyListener sur la fenêtre
        vc.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                    if (clip.isRunning()) {
                        clip.stop();
                        musiqueEnPause = true;
                    } else {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        musiqueEnPause = false;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        vc.setFocusable(true);
        vc.requestFocusInWindow();
        System.out.println("Appuyer la touche m pour arrêter/relancer la musique");
    }
}
