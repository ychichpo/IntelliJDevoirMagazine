package Vues;

import Entities.Article;
import Entities.Magazine;
import Entities.Pigiste;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrmMenu extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblMagazines;
    private JTable tblMagazines;
    private JTable tblArticles;
    private JLabel lblArticles;
    private JLabel lblMontantMagazine;
    private JTextField txtMontantMagazine;
    private JLabel lblTitreArticle;
    private JTextField txtTitreArticle;
    private JLabel lblNbPages;
    private JSlider sldNbPages;
    private JComboBox cboPigistes;
    private JLabel lblMontantArticle;
    private JTextField txtMontantArticle;
    private JButton btnAjouterArticle;
    private Magazine magazineClike;

    ArrayList<Magazine> mesMagazines;
    ArrayList<Pigiste> mesPigistes;
    ModelJTable mdl;

    public FrmMenu()
    {
        this.setTitle("Devoir - Magazine");
        this.setContentPane(pnlRoot);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        mesMagazines = new ArrayList<>();
        mesPigistes = new ArrayList<>();

        LoadDatas();

        mdl=new ModelJTable();
        mdl.LoadDataMagazine(mesMagazines);
        tblMagazines.setModel(mdl);


        for (Pigiste pigiste:mesPigistes){
            cboPigistes.addItem(pigiste.getNomPigiste());
        }
        

        tblMagazines.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                txtMontantArticle.setText("");
                txtTitreArticle.setText("");
                int numMagazine=Integer.parseInt(String.valueOf(tblMagazines.getValueAt(tblMagazines.getSelectedRow(),0)));
                for (Magazine mgz:mesMagazines){
                    if (mgz.getNumMagazine()==numMagazine){
                        magazineClike=mgz;
                        DisplayArticles();
                        break;
                    }
                }

            }
        });
        tblArticles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String nomArticle=String.valueOf(tblArticles.getValueAt(tblArticles.getSelectedRow(),0));
                for (Article art:magazineClike.getLesArticles()){
                    if (art.getTitreArticle().equals(nomArticle)){
                       txtMontantArticle.setText(String.valueOf(art.CalculerMontantArticle()));
                       break;
                    }
                }

            }
        });

        btnAjouterArticle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tblMagazines.getSelectedRowCount()==0){
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un magazine","Choix du magazine",JOptionPane.WARNING_MESSAGE);
                }
                else if (txtTitreArticle.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir un Titre","Erreur de saisie",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    Article nouvelArticle = new Article(txtTitreArticle.getText(), sldNbPages.getValue(),mesPigistes.get(cboPigistes.getSelectedIndex()));

                    magazineClike.AjouterArticle(nouvelArticle);
                    DisplayArticles();
                    txtMontantArticle.setText("");
                }
            }
        });
    }
    public void DisplayArticles(){
        mdl=new ModelJTable();
        mdl.LoadDataArticles(magazineClike.getLesArticles());
        tblArticles.setModel(mdl);

        txtMontantMagazine.setText(String.valueOf(magazineClike.CalculerMontantMagazine()));
    }

    public void LoadDatas()
    {
        // Les pigistes
        Pigiste pig1 = new Pigiste(1, "Fortin", 1.76);
        Pigiste pig2 = new Pigiste(2, "Garnier", 1.33);
        Pigiste pig3 = new Pigiste(3, "Alison", 1.89);
        Pigiste pig4 = new Pigiste(4, "Muller", 1.15);
        Pigiste pig5 = new Pigiste(5, "Gand", 1.34);

        mesPigistes.add(pig1);mesPigistes.add(pig2);mesPigistes.add(pig3);
        mesPigistes.add(pig4);mesPigistes.add(pig5);

        // Les magazines
        Magazine mag1 = new Magazine(1, "Le monde du PC");
        Magazine mag2 = new Magazine(2, "Arbres et arbustes");
        Magazine mag3 = new Magazine(3, "Gazette Roland Garros");
        Magazine mag4 = new Magazine(4, "France Football");
        Magazine mag5 = new Magazine(5, "La cuisine BIO");
        Magazine mag6 = new Magazine(6, "Renault mag");

        // Les articles
        Article art1 = new Article("La clé USB", 4, pig2);
        Article art2 = new Article("Le processeur Intel I7", 2, pig2);
        Article art3 = new Article("Windows 10 VS Windows 11", 4, pig4);
        Article art4 = new Article("Série DELL XPS", 3, pig3);
        Article art5 = new Article("La blessure de Rapha", 2, pig1);
        Article art6 = new Article("Tout sur la quizaine à Paris", 6, pig4);
        Article art7 = new Article("La nouvelle Kangoo", 2, pig2);
        Article art8 = new Article("Le nouveau moteur de la twingo", 1, pig2);
        Article art9 = new Article("La saison des tomates", 3, pig4);
        Article art10 = new Article("Le mildiou se développe", 3, pig5);
        Article art11 = new Article("Comment bien corder sa raquette", 2, pig4);
        Article art12 = new Article("Paris près des étoiles", 4, pig5);
        Article art13 = new Article("Bien choisir ses patates", 5, pig5);
        Article art14 = new Article("Kanté positif au Covid-19", 2, pig5);
        Article art15 = new Article("La politique des transferts", 3, pig1);
        Article art16 = new Article("Le peuplier des landes", 2, pig3);
        Article art17 = new Article("L'arbre le plus vieux", 3, pig5);
        Article art18 = new Article("Bien tailler ses haies", 1, pig3);

        mag1.AjouterArticle(art1); mag1.AjouterArticle(art2); mag1.AjouterArticle(art3); mag1.AjouterArticle(art4);
        mag2.AjouterArticle(art16); mag2.AjouterArticle(art17); mag2.AjouterArticle(art18);
        mag3.AjouterArticle(art5); mag3.AjouterArticle(art6); mag3.AjouterArticle(art11);
        mag4.AjouterArticle(art12); mag4.AjouterArticle(art14); mag4.AjouterArticle(art15);
        mag5.AjouterArticle(art9); mag5.AjouterArticle(art10); mag5.AjouterArticle(art13);
        mag6.AjouterArticle(art7); mag6.AjouterArticle(art8);

        mesMagazines.add(mag1);mesMagazines.add(mag2);mesMagazines.add(mag3);
        mesMagazines.add(mag4);mesMagazines.add(mag5);mesMagazines.add(mag6);
    }
}
