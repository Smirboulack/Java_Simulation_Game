package VueControleur.Fenetres;
import VueControleur.BoutonRond;
import modele.SimulateurPotager;
import modele.environnement.varietes.Fruit;
import modele.environnement.varietes.Legume;

import javax.swing.*;
import java.util.ArrayList;

/*Cette fenetre permet de pouvoir gérer le sytème d'inventaire , pour pouvoir stocker des fruits ou légumes issues de la récolte , on pourra aussi les vendre
* Cette fonctionnalité n'a pas encore été implementée
* */
public class FenetreInventaire extends JFrame {
    private int nombreElements;
    private Legume legumeInventaire;
    private Fruit fruitInventaire;

    private JLabel TableauxJlab_fruits[]= new JLabel[7];
    private JLabel TableauxJlab_legumes[]= new JLabel[16];

    public BoutonRond TableauxBoutonsRond_fruits[]=new BoutonRond[TableauxJlab_fruits.length];
    public BoutonRond TableauxBoutonsRond_legumes[]= new BoutonRond[TableauxJlab_legumes.length];
    private ArrayList<Legume> listeLegumes = new ArrayList<>();
    private ArrayList<Fruit> listeFruits = new ArrayList<>();
    private SimulateurPotager simpotager;
    public FenetreInventaire(SimulateurPotager _simpot){
        super("Inventaire");
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.simpotager=_simpot;
    }



    public void insererFruit(Fruit fruit){
        nombreElements++;
        if(fruit != null && fruit instanceof Fruit){
            listeFruits.add(fruit);
        }
        else{
            System.err.println("Erreur d'insertion dans l'inventaire de fruits");
        }
    }

    public void insererLegume(Legume legume){
        nombreElements++;
        if(legume != null && legume instanceof Legume){
            listeLegumes.add(legume);
        }
        else{
            System.err.println("Erreur d'insertion dans l'inventaire de legume");
        }
    }

    public void supprimerFruit(Fruit fruit){
        nombreElements--;
        listeFruits.remove(fruit);
    }

    public void supprimerLegume(Legume legume){
        nombreElements--;
        listeLegumes.remove(legume);
    }

    public void viderInventaire(){
        nombreElements = 0;
        listeFruits.clear();
        listeLegumes.clear();
    }

    // Getters et setters pour accéder aux variables privées
    public int getNombreElements() {
        return nombreElements;
    }

    public Legume getLegumeInventaire() {
        return legumeInventaire;
    }

    public void setLegumeInventaire(Legume legumeInventaire) {
        this.legumeInventaire = legumeInventaire;
    }

    public Fruit getFruitInventaire() {
        return fruitInventaire;
    }

    public void setFruitInventaire(Fruit fruitInventaire) {
        this.fruitInventaire = fruitInventaire;
    }

    public ArrayList<Legume> getListeLegumes() {
        return listeLegumes;
    }

    public void setListeLegumes(ArrayList<Legume> listeLegumes) {
        this.listeLegumes = listeLegumes;
    }

    public ArrayList<Fruit> getListeFruits() {
        return listeFruits;
    }

    public void setListeFruits(ArrayList<Fruit> listeFruits) {
        this.listeFruits = listeFruits;
    }
}
