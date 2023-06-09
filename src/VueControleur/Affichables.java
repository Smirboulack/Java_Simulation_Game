package VueControleur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* Cette classe permet simplement de charger les images , cela évite d'encombrer le code des fonctionnalités.
* */
public class Affichables {
    private static ImageIcon icoAil;
    private static ImageIcon icoAil_action;
    private static ImageIcon icoAil_variete;
    private static ImageIcon icoAil_morte;
    private static ImageIcon icoAnanas;
    private static ImageIcon icoAnanas_action;
    private static ImageIcon icoAnanas_variete;
    private static ImageIcon icoAnanas_morte;
    private static ImageIcon icoAubergine;
    private static ImageIcon icoAubergine_action;
    private static ImageIcon icoAubergine_variete;
    private static ImageIcon icoAubergine_morte;
    private static ImageIcon icoAvocat;
    private static ImageIcon icoAvocat_action;
    private static ImageIcon icoAvocat_variete;
    private static ImageIcon icoAvocat_morte;
    private static ImageIcon icoBrocoli;
    private static ImageIcon icoBrocoli_action;
    private static ImageIcon icoBrocoli_variete;
    private static ImageIcon icoBrocoli_morte;
    private static ImageIcon icoCarotte;
    private static ImageIcon icoCarotte_action;
    private static ImageIcon icoCarotte_variete;
    private static ImageIcon icoCarotte_morte;
    private static ImageIcon icoChampignon;
    private static ImageIcon icoChampignon_action;
    private static ImageIcon icoChampignon_variete;
    private static ImageIcon icoChampignon_morte;
    private static ImageIcon icoChoufleur;
    private static ImageIcon icoChoufleur_action;
    private static ImageIcon icoChoufleur_variete;
    private static ImageIcon icoChoufleur_morte;
    private static ImageIcon icoCitron;
    private static ImageIcon icoCitron_action;
    private static ImageIcon icoCitron_variete;
    private static ImageIcon icoCitron_morte;
    private static ImageIcon icoComcombre;
    private static ImageIcon icoComcombre_action;
    private static ImageIcon icoComcombre_variete;
    private static ImageIcon icoComcombre_morte;
    private static ImageIcon icoCornichon;
    private static ImageIcon icoCornichon_action;
    private static ImageIcon icoCornichon_variete;
    private static ImageIcon icoCornichon_morte;
    private static ImageIcon icoFraise;
    private static ImageIcon icoFraise_action;
    private static ImageIcon icoFraise_variete;
    private static ImageIcon icoFraise_morte;
    private static ImageIcon icoHaricot;
    private static ImageIcon icoHaricot_action;
    private static ImageIcon icoHaricot_variete;
    private static ImageIcon icoHaricot_morte;
    private static ImageIcon icoMais;
    private static ImageIcon icoMais_action;
    private static ImageIcon icoMais_variete;
    private static ImageIcon icoMais_morte;
    private static ImageIcon icoMelon;
    private static ImageIcon icoMelon_action;
    private static ImageIcon icoMelon_variete;
    private static ImageIcon icoMelon_morte;
    private static ImageIcon icoOignon;
    private static ImageIcon icoOignon_action;
    private static ImageIcon icoOignon_variete;
    private static ImageIcon icoOignon_morte;
    private static ImageIcon icoOrange;
    private static ImageIcon icoOrange_action;
    private static ImageIcon icoOrange_variete;
    private static ImageIcon icoOrange_morte;
    private static ImageIcon icoPasteque;
    private static ImageIcon icoPasteque_action;
    private static ImageIcon icoPasteque_variete;
    private static ImageIcon icoPasteque_morte;
    private static ImageIcon icoPoire;
    private static ImageIcon icoPoire_action;
    private static ImageIcon icoPoire_variete;
    private static ImageIcon icoPoire_morte;
    private static ImageIcon icoPoivron;
    private static ImageIcon icoPoivron_action;
    private static ImageIcon icoPoivron_variete;
    private static ImageIcon icoPoivron_morte;
    private static ImageIcon icoRadis;
    private static ImageIcon icoRadis_action;
    private static ImageIcon icoRadis_variete;
    private static ImageIcon icoRadis_morte;
    private static ImageIcon icoSalade;
    private static ImageIcon icoSalade_action;
    private static ImageIcon icoSalade_variete;
    private static ImageIcon icoSalade_morte;
    private static ImageIcon icoTomate;
    private static ImageIcon icoTomate_action;

    private static ImageIcon icoTomate_variete;
    private static ImageIcon icoTomate_morte;
    private static ImageIcon icoPlante;
    private static ImageIcon icoPlante_pousse;
    private static ImageIcon icoExcaver;
    private static ImageIcon icoRecolter;
    private static ImageIcon icoInventaire;
    private static ImageIcon icoVendre;
    private static ImageIcon icoPoubelle;
    private static ImageIcon icoEngrais;
    private static ImageIcon icoTerre;
    private static ImageIcon icoVide;
    private static ImageIcon icoMur;

    void construction_images_icons(){

        icoAil = chargerIcone("Images/Legumes/ail.png");
        icoAnanas = chargerIcone("Images/Fruits/ananas.png");
        icoAubergine = chargerIcone("Images/Legumes/aubergine.png");
        icoAvocat = chargerIcone("Images/Legumes/avocat.png");
        icoBrocoli = chargerIcone("Images/Legumes/brocoli.png");
        icoCarotte = chargerIcone("Images/Legumes/carotte.png");
        icoChampignon = chargerIcone("Images/Legumes/champignon.png");
        icoChoufleur = chargerIcone("Images/Legumes/choufleur.png");
        icoCitron = chargerIcone("Images/Legumes/citron.png");
        icoComcombre = chargerIcone("Images/Legumes/comcombre.png");
        icoCornichon = chargerIcone("Images/Legumes/cornichon.png");
        icoFraise = chargerIcone("Images/Fruits/fraise.png");
        icoHaricot = chargerIcone("Images/Legumes/haricot.png");
        icoMais = chargerIcone("Images/Legumes/mais.png");
        icoMelon = chargerIcone("Images/Fruits/melon.png");
        icoOignon = chargerIcone("Images/Legumes/oignon.png");
        icoOrange = chargerIcone("Images/Fruits/orange.png");
        icoPasteque = chargerIcone("Images/Fruits/pasteque.png");
        icoPoire = chargerIcone("Images/Fruits/poire.png");
        icoPoivron = chargerIcone("Images/Legumes/poivron.png");
        icoRadis = chargerIcone("Images/Legumes/radis.png");
        icoSalade = chargerIcone("Images/Legumes/salad.png");
        icoTomate = chargerIcone("Images/Fruits/tomate.png");

        icoAil_variete = chargerIcone("Images/Legumes/ail_jaune.png");
        icoAnanas_variete = chargerIcone("Images/Fruits/ananas_rouge.png");
        icoAubergine_variete = chargerIcone("Images/Legumes/aubergine_rouge.png");
        icoAvocat_variete = chargerIcone("Images/Legumes/avocat_bleu.png");
        icoBrocoli_variete = chargerIcone("Images/Legumes/brocoli_rouge.png");
        icoCarotte_variete = chargerIcone("Images/Legumes/carotte_violet.png");
        icoChampignon_variete = chargerIcone("Images/Legumes/champignon_bleu.png");
        icoChoufleur_variete = chargerIcone("Images/Legumes/choufleur_jaune.png");
        icoCitron_variete = chargerIcone("Images/Legumes/citron_vert.png");
        icoComcombre_variete = chargerIcone("Images/Legumes/comcombre_rouge.png");
        icoCornichon_variete = chargerIcone("Images/Legumes/cornichon_rouge.png");
        icoFraise_variete = chargerIcone("Images/Fruits/fraise_verte.png");
        icoHaricot_variete = chargerIcone("Images/Legumes/haricot_rouge.png");
        icoMais_variete = chargerIcone("Images/Legumes/mais_violet.png");
        icoMelon_variete = chargerIcone("Images/Fruits/melon_violet.png");
        icoOignon_variete = chargerIcone("Images/Legumes/oignon_rose.png");
        icoOrange_variete = chargerIcone("Images/Fruits/orange_rouge.png");
        icoPasteque_variete = chargerIcone("Images/Fruits/pasteque_jaune.png");
        icoPoire_variete = chargerIcone("Images/Fruits/poire_rose.png");
        icoPoivron_variete = chargerIcone("Images/Legumes/poivron_vert.png");
        icoRadis_variete = chargerIcone("Images/Legumes/radis_jaune.png");
        icoSalade_variete = chargerIcone("Images/Legumes/salad_jaune.png");
        icoTomate_variete = chargerIcone("Images/Fruits/tomate_bleu.png");

        icoPlante=chargerIcone("Images/plante.png");
        icoPlante_pousse=chargerIcone("Images/plante_pousse.png");

        icoAil_morte = chargerIcone("Images/Legumes/ail_morte.png");
        icoAnanas_morte = chargerIcone("Images/Fruits/ananas_morte.png");
        icoAubergine_morte = chargerIcone("Images/Legumes/aubergine_morte.png");
        icoAvocat_morte = chargerIcone("Images/Legumes/avocat_morte.png");
        icoBrocoli_morte = chargerIcone("Images/Legumes/brocoli_morte.png");
        icoCarotte_morte = chargerIcone("Images/Legumes/carotte_morte.png");
        icoChampignon_morte = chargerIcone("Images/Legumes/champignon_morte.png");
        icoChoufleur_morte = chargerIcone("Images/Legumes/choufleur_morte.png");
        icoCitron_morte = chargerIcone("Images/Legumes/citron_morte.png");
        icoComcombre_morte = chargerIcone("Images/Legumes/comcombre_morte.png");
        icoCornichon_morte = chargerIcone("Images/Legumes/cornichon_morte.png");
        icoFraise_morte = chargerIcone("Images/Fruits/fraise_morte.png");
        icoHaricot_morte = chargerIcone("Images/Legumes/haricot_morte.png");
        icoMais_morte = chargerIcone("Images/Legumes/mais_morte.png");
        icoMelon_morte = chargerIcone("Images/Fruits/melon_morte.png");
        icoOignon_morte = chargerIcone("Images/Legumes/oignon_morte.png");
        icoOrange_morte = chargerIcone("Images/Fruits/orange_morte.png");
        icoPasteque_morte = chargerIcone("Images/Fruits/pasteque_morte.png");
        icoPoire_morte = chargerIcone("Images/Fruits/poire_morte.png");
        icoPoivron_morte = chargerIcone("Images/Legumes/poivron_morte.png");
        icoRadis_morte = chargerIcone("Images/Legumes/radis_morte.png");
        icoSalade_morte = chargerIcone("Images/Legumes/salad_morte.png");
        icoTomate_morte = chargerIcone("Images/Fruits/tomate_morte.png");


        icoAil_action=chargerIcone("Images/ail.png");
        icoAnanas_action=chargerIcone("Images/ananas.png");
        icoAubergine_action=chargerIcone("Images/aubergine.png");
        icoAvocat_action=chargerIcone("Images/avocat.png");
        icoBrocoli_action=chargerIcone("Images/brocoli.png");
        icoCarotte_action = chargerIcone("Images/carott.png");
        icoChampignon_action=chargerIcone("Images/champignon.png");
        icoChoufleur_action=chargerIcone("Images/choufleur.png");
        icoCitron_action=chargerIcone("Images/citron.png");
        icoComcombre_action=chargerIcone("Images/comcombre.png");
        icoCornichon_action=chargerIcone("Images/cornichon.png");
        icoFraise_action=chargerIcone("Images/fraise.png");
        icoHaricot_action=chargerIcone("Images/haricot.png");
        icoMais_action=chargerIcone("Images/mais.png");
        icoMelon_action=chargerIcone("Images/melon.png");
        icoOignon_action=chargerIcone("Images/oignon.png");
        icoOrange_action=chargerIcone("Images/orange.png");
        icoPasteque_action=chargerIcone("Images/pasteque.png");
        icoPoire_action=chargerIcone("Images/poire.png");
        icoPoivron_action=chargerIcone("Images/poivron.png");
        icoRadis_action=chargerIcone("Images/radis.png");
        icoSalade_action=chargerIcone("Images/salad.png");
        icoTomate_action=chargerIcone("Images/tomate.png");

        icoVide = chargerIcone("Images/Vide.png");
        icoMur = chargerIcone("Images/Mur.png");
        icoTerre = chargerIcone("Images/Terre.png");
        icoExcaver=chargerIcone("Images/pelle.png");
        icoRecolter=chargerIcone("Images/recolter.png");
        icoInventaire=chargerIcone("Images/inventaire.png");
        icoVendre=chargerIcone("Images/vendre.png");
        icoPoubelle=chargerIcone("Images/poubelle.png");
        icoEngrais = chargerIcone("Images/engrais.png");


    }

    // chargement de l'image entière comme icone
    private ImageIcon chargerIcone(String urlIcone) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


        return new ImageIcon(image);
    }

    // chargement d'une sous partie de l'image
    private ImageIcon chargerIcone(String urlIcone, int x, int y, int w, int h) {
        // charger une sous partie de l'image à partir de ses coordonnées dans urlIcone
        BufferedImage bi = getSubImage(urlIcone, x, y, w, h);
        // adapter la taille de l'image a la taille du composant (ici : 20x20)
        return new ImageIcon(bi.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
    }


    private BufferedImage getSubImage(String urlIcone, int x, int y, int w, int h) {
        BufferedImage image = null;

        try {
            File f = new File(urlIcone);
            image = ImageIO.read(new File(urlIcone));
        } catch (IOException ex) {
            Logger.getLogger(VueControleurPotager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        BufferedImage bi = image.getSubimage(x, y, w, h);
        return bi;
    }

    public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return new ImageIcon(newImg);
    }

    public static ImageIcon getIcoAil() {
        return icoAil;
    }

    public static ImageIcon getIcoAil_action() {
        return icoAil_action;
    }

    public static ImageIcon getIcoAil_morte() {
        return icoAil_morte;
    }

    public static ImageIcon getIcoAnanas() {
        return icoAnanas;
    }
    public static ImageIcon getIcoAnanas_variete(){return icoAnanas_variete;}

    public static ImageIcon getIcoAnanas_action() {
        return icoAnanas_action;
    }

    public static ImageIcon getIcoAnanas_morte() {
        return icoAnanas_morte;
    }

    public static ImageIcon getIcoAubergine() {
        return icoAubergine;
    }

    public static ImageIcon getIcoAubergine_action() {
        return icoAubergine_action;
    }

    public static ImageIcon getIcoAubergine_morte() {
        return icoAubergine_morte;
    }

    public static ImageIcon getIcoAvocat() {
        return icoAvocat;
    }

    public static ImageIcon getIcoAvocat_action() {
        return icoAvocat_action;
    }

    public static ImageIcon getIcoAvocat_morte() {
        return icoAvocat_morte;
    }

    public static ImageIcon getIcoBrocoli() {
        return icoBrocoli;
    }

    public static ImageIcon getIcoBrocoli_action() {
        return icoBrocoli_action;
    }

    public static ImageIcon getIcoBrocoli_morte() {
        return icoBrocoli_morte;
    }

    public static ImageIcon getIcoCarotte() {
        return icoCarotte;
    }

    public static ImageIcon getIcoCarotte_action() {
        return icoCarotte_action;
    }

    public static ImageIcon getIcoCarotte_morte() {
        return icoCarotte_morte;
    }

    public static ImageIcon getIcoChampignon() {
        return icoChampignon;
    }

    public static ImageIcon getIcoChampignon_action() {
        return icoChampignon_action;
    }

    public static ImageIcon getIcoChampignon_morte() {
        return icoChampignon_morte;
    }

    public static ImageIcon getIcoChoufleur() {
        return icoChoufleur;
    }

    public static ImageIcon getIcoChoufleur_action() {
        return icoChoufleur_action;
    }

    public static ImageIcon getIcoChoufleur_morte() {
        return icoChoufleur_morte;
    }

    public static ImageIcon getIcoCitron() {
        return icoCitron;
    }

    public static ImageIcon getIcoCitron_action() {
        return icoCitron_action;
    }

    public static ImageIcon getIcoCitron_morte() {
        return icoCitron_morte;
    }

    public static ImageIcon getIcoComcombre() {
        return icoComcombre;
    }

    public static ImageIcon getIcoComcombre_action() {
        return icoComcombre_action;
    }

    public static ImageIcon getIcoComcombre_morte() {
        return icoComcombre_morte;
    }

    public static ImageIcon getIcoCornichon() {
        return icoCornichon;
    }

    public static ImageIcon getIcoCornichon_action() {
        return icoCornichon_action;
    }

    public static ImageIcon getIcoCornichon_morte() {
        return icoCornichon_morte;
    }

    public static ImageIcon getIcoFraise() {
        return icoFraise;
    }

    public static ImageIcon getIcoFraise_action() {
        return icoFraise_action;
    }

    public static ImageIcon getIcoFraise_morte() {
        return icoFraise_morte;
    }

    public static ImageIcon getIcoHaricot() {
        return icoHaricot;
    }

    public static ImageIcon getIcoHaricot_action() {
        return icoHaricot_action;
    }

    public static ImageIcon getIcoHaricot_morte() {
        return icoHaricot_morte;
    }

    public static ImageIcon getIcoMais() {
        return icoMais;
    }

    public static ImageIcon getIcoMais_action() {
        return icoMais_action;
    }

    public static ImageIcon getIcoMais_morte() {
        return icoMais_morte;
    }

    public static ImageIcon getIcoMelon() {
        return icoMelon;
    }

    public static ImageIcon getIcoMelon_action() {
        return icoMelon_action;
    }

    public static ImageIcon getIcoMelon_morte() {
        return icoMelon_morte;
    }

    public static ImageIcon getIcoOignon() {
        return icoOignon;
    }

    public static ImageIcon getIcoOignon_action() {
        return icoOignon_action;
    }

    public static ImageIcon getIcoOignon_morte() {
        return icoOignon_morte;
    }

    public static ImageIcon getIcoOrange() {
        return icoOrange;
    }

    public static ImageIcon getIcoOrange_action() {
        return icoOrange_action;
    }

    public static ImageIcon getIcoOrange_morte() {
        return icoOrange_morte;
    }

    public static ImageIcon getIcoPasteque() {
        return icoPasteque;
    }

    public static ImageIcon getIcoPasteque_action() {
        return icoPasteque_action;
    }

    public static ImageIcon getIcoPasteque_morte() {
        return icoPasteque_morte;
    }

    public static ImageIcon getIcoPoire() {
        return icoPoire;
    }

    public static ImageIcon getIcoPoire_action() {
        return icoPoire_action;
    }

    public static ImageIcon getIcoPoire_morte() {
        return icoPoire_morte;
    }

    public static ImageIcon getIcoPoivron() {
        return icoPoivron;
    }

    public static ImageIcon getIcoPoivron_action() {
        return icoPoivron_action;
    }

    public static ImageIcon getIcoPoivron_morte() {
        return icoPoivron_morte;
    }

    public static ImageIcon getIcoRadis() {
        return icoRadis;
    }

    public static ImageIcon getIcoRadis_action() {
        return icoRadis_action;
    }

    public static ImageIcon getIcoRadis_morte() {
        return icoRadis_morte;
    }

    public static ImageIcon getIcoSalade() {
        return icoSalade;
    }

    public static ImageIcon getIcoSalade_action() {
        return icoSalade_action;
    }

    public static ImageIcon getIcoSalade_morte() {
        return icoSalade_morte;
    }

    public static ImageIcon getIcoTomate() {
        return icoTomate;
    }

    public static ImageIcon getIcoTomate_action() {
        return icoTomate_action;
    }

    public static ImageIcon getIcoTomate_morte() {
        return icoTomate_morte;
    }

    public static ImageIcon getIcoPlante() {
        return icoPlante;
    }

    public static ImageIcon getIcoPlante_pousse() {
        return icoPlante_pousse;
    }

    public static ImageIcon getIcoExcaver() {
        return icoExcaver;
    }

    public static ImageIcon getIcoRecolter() {
        return icoRecolter;
    }

    public static ImageIcon getIcoInventaire() {
        return icoInventaire;
    }

    public static ImageIcon getIcoVendre() {
        return icoVendre;
    }

    public static ImageIcon getIcoPoubelle() {
        return icoPoubelle;
    }

    public static ImageIcon getIcoTerre() {
        return icoTerre;
    }

    public static ImageIcon getIcoVide() {
        return icoVide;
    }

    public static ImageIcon getIcoMur() {
        return icoMur;
    }

    public static ImageIcon getIcoFraise_variete() { return icoFraise_variete; }
    public static ImageIcon getIcoMelon_variete() { return icoMelon_variete; }
    public static ImageIcon getIcoOrange_variete() { return icoOrange_variete; }
    public static ImageIcon getIcoPasteque_variete() { return icoPasteque_variete; }
    public static ImageIcon getIcoPoire_variete() { return icoPoire_variete; }
    public static ImageIcon getIcoTomate_variete() { return icoTomate_variete; }
    public static ImageIcon getIcoAil_variete() { return icoAil_variete; }
    public static ImageIcon getIcoAubergine_variete() { return icoAubergine_variete; }
    public static ImageIcon getIcoAvocat_variete() { return icoAvocat_variete; }
    public static ImageIcon getIcoBrocoli_variete() { return icoBrocoli_variete; }
    public static ImageIcon getIcoCarotte_variete() { return icoCarotte_variete; }
    public static ImageIcon getIcoChampignon_variete() { return icoChampignon_variete; }
    public static ImageIcon getIcoChoufleur_variete() { return icoChoufleur_variete; }
    public static ImageIcon getIcoCitron_variete() { return icoCitron_variete; }
    public static ImageIcon getICocomcombre_variete() { return icoComcombre_variete; }
    public static ImageIcon getIcoCornichon_variete() { return icoCornichon_variete; }
    public static ImageIcon getIcoHaricot_variete() { return icoHaricot_variete; }
    public static ImageIcon getIcoMais_variete() { return icoMais_variete; }
    public static ImageIcon getIcoOignon_variete() { return icoOignon_variete; }
    public static ImageIcon getIcoPoivron_variete() { return icoPoivron_variete; }
    public static ImageIcon getIcoRadis_variete() { return icoRadis_variete; }
    public static ImageIcon getIcoSalade_variete() { return icoSalade_variete; }
    public static ImageIcon getIcoEngrais(){
        return icoEngrais;
    }
}
