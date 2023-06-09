package VueControleur.Fenetres;
import modele.Chrono;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* Cette classe permettra de gérer l'écoulement du temps sans devoir faire appels aux composants de la classe Ordonnanceur. Les données membres de l'objet chrono de type Chrono
* seront mis à jour continuellement . On pourra faire varierer la vitesse d'écoulement du temps grâce au bouton Jslider.
* */
public class FenetreChrono extends JFrame {
    private static final int Largeur = 400;
    private static final int Hauteur = 150;
    private static final int valeur_min = 1;
    private static final int valeur_max = 99;
    private static final int valeur_min_slider = 1;
    private static final int TIMER_DELAY = 1000; // en millisecondes
    private Chrono chrono;
    private JButton startButton;
    private JButton pauseButton;
    private JSlider slider;
    private JLabel Temps_Label;
    private Timer timer;
    private int secondes_ecoules = 0;
    private int sliderValue = valeur_min_slider;
    private boolean Pause;

    public FenetreChrono(Chrono chron) {
        setTitle("FenetreChrono");
        setSize(Largeur, Hauteur);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        slider = new JSlider(valeur_min, valeur_max, valeur_min_slider);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SliderListener());

        Temps_Label = new JLabel("00:00:00");
        Temps_Label.setFont(new Font("Arial", Font.BOLD, 24));
        Temps_Label.setHorizontalAlignment(SwingConstants.CENTER);

        startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());

        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new PauseButtonListener());

        JPanel sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.add(slider, BorderLayout.CENTER);
        sliderPanel.add(Temps_Label, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);

        setLayout(new BorderLayout());
        add(sliderPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        chrono=chron;
    }

    public void start() {
        if (timer == null) {
            timer = new Timer(TIMER_DELAY, new TimerListener());
            timer.start();
            startButton.setEnabled(false);

        } else {
            timer.restart();
            startButton.setEnabled(false);
            pauseButton.setEnabled(true);
            chrono.setEn_pause(Pause);
        }
        Pause = false;
        chrono.setEn_pause(Pause);
    }

    public void pause() {
        if (timer != null) {
            if (Pause) {
                timer.restart();
                Pause = false;
                chrono.setEn_pause(Pause);
            } else {
                timer.stop();
                startButton.setEnabled(true);
                pauseButton.setEnabled(false);
                Pause = true;
                chrono.setEn_pause(Pause);
            }
        }
    }

    public void updateTimerLabel() {
            int hours = secondes_ecoules / 3600;
            int minutes = (secondes_ecoules % 3600) / 60;
            int seconds = secondes_ecoules % 60;
            chrono.setSeconde(seconds);
            chrono.setMinutes(minutes);
            chrono.setHeures(hours);
            Temps_Label.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            chrono.setTemps_actuel(Temps_Label.getText());
            chrono.setEn_pause(Pause);
            chrono.setVitesse_chrono(getSliderValue());
    }

    public void reinitialiser_chrono() {
        if (timer != null) {
            timer.stop();
        }
        secondes_ecoules = 0;
        slider.setValue(valeur_min_slider);
        timer.start();
        updateTimerLabel();
    }

    private class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent event) {
            sliderValue = slider.getValue();
            if (timer != null) {
                timer.setDelay(1000 / sliderValue);
            }
        }
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            start();
        }
    }

    private class PauseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pause();
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondes_ecoules++;
            updateTimerLabel();
        }
    }

    public int getSliderValue() {
        return sliderValue;
    }
    public String getTimerLabelValue(){
        return Temps_Label.getText();
    }

}