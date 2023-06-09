package VueControleur;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JToggleButton;

public class BoutonRond extends JToggleButton {
    private Color couleur;

    public BoutonRond(Color couleur) {
        this.couleur = couleur;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(couleur.darker());
        } else {
            g.setColor(couleur);
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(couleur.darker().darker());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
/*
    @Override
    public boolean contains(int x, int y) {
        if ((getSize().width / 2 - x) * (getSize().width / 2 - x) +
                (getSize().height / 2 - y) * (getSize().height / 2 - y) <=
                (getSize().width / 2) * (getSize().height / 2)) {
            return true;
        } else {
            return false;
        }
    }
    */
}