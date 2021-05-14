package oop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javax.swing.*;
import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.*;

import javafx.scene.text.Font;

import static javax.swing.JOptionPane.CLOSED_OPTION;

public class Peaklass extends Application {
  private static ObservableList<Auto> autod = FXCollections.observableArrayList();
  // energiahindade vaikeväärtused
  static Elektrijaam elektrijaam = new Elektrijaam(0.16, 475); //Siin on kütuseCO2jälg kWh kohta, seetõttu see paistab väiksemana
  static Diislijaam diislijaam = new Diislijaam(1.22, 2640);
  static Bensiinijaam bensiinijaam = new Bensiinijaam(1.40, 2392);

  @Override
  public void start(Stage peaLava) throws Exception {

    //Koostame tabelit
    GridPane gridTabel = new  GridPane();
    gridTabel.setPadding(new Insets(1, 1 , 2, 1));
    gridTabel.setHgap(1);
    gridTabel.setVgap(1);

    //Koostame tabeli mütsi
    Label müts = new Label();
    müts.setMinWidth(453);
    müts.setMaxWidth(453);
    müts.setStyle(" -fx-border-color: #5c5b5b; -fx-background-color: white; -fx-alignment: center");
    müts.setText("Autode andmed järjestatuna kasutuskulude kasvavas järjekorras");
    gridTabel.add(müts, 0,0,3,1); /** Grid'is ammendavamalt {@link Peaklass#lisaauto()}. */

    //Koostame tulpide mütse
    Label automarkMüts = new Label();
    automarkMüts.setMinWidth(250);
    automarkMüts.setMaxWidth(250);
    automarkMüts.setStyle(" -fx-border-color: #5c5b5b; -fx-background-color: white");
    automarkMüts.setText("Automark");
    gridTabel.add(automarkMüts, 0, 1);

    Label ostuhindMüts = new Label();
    ostuhindMüts.setMinWidth(200);
    ostuhindMüts.setMaxWidth(200);
    ostuhindMüts.setStyle(" -fx-border-color: #5c5b5b; -fx-background-color: white");
    ostuhindMüts.setText("Ostuhind");
    gridTabel.add(ostuhindMüts, 2, 1);


    String stiil;
    int i =2;
    for (Auto auto : autod) {

      //Loome kaks ridade stiili, paaritu ja paaris ridade jaoks
      if (i%2==0)
        stiil=" -fx-border-color: #5c5b5b; -fx-background-color: #f5f505";
      else
        stiil=" -fx-border-color: #5c5b5b; -fx-background-color: #fdfda2";

      //Määrame ridade ja tulpide välimust
      Label automarklabel = new Label();
      automarklabel.setMinWidth(250);
      automarklabel.setMaxWidth(250);
      automarklabel.setStyle(stiil);

      Label ostuhindlabel = new Label();
      ostuhindlabel.setMinWidth(200);
      ostuhindlabel.setMaxWidth(200);
      ostuhindlabel.setStyle(stiil);

      automarklabel.setText(auto.getAutomark());
      gridTabel.add(automarklabel, 0, i);

      ostuhindlabel.setText(Double.toString(auto.getOstuhind()));
      gridTabel.add(ostuhindlabel, 2, i);

      i++;
    }
    gridTabel.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,CornerRadii.EMPTY, Insets.EMPTY)));

    /*if (i%2==0)
        stiil="-fx-border-style: dashed; -fx-border-color: #5c5b5b; -fx-background-color: #41d941";
      else
        stiil="-fx-border-style: dashed; -fx-border-color: #5c5b5b; -fx-background-color: #7fec7f";
        */
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setContent(gridTabel);

    GridPane gridNV = new GridPane();
    gridNV.setVgap(4);
    gridNV.setHgap(4);
    gridNV.setPadding(new Insets(20, 5, 5, 5));
    Label bensiini_sõnum=new Label("Bensiini 98 hind (liitri kohta):");
    gridNV.add(bensiini_sõnum, 0, 0);
    TextField bensiini_hind = new TextField(Double.toString(bensiinijaam.energiahind));
    gridNV.add(bensiini_hind, 1, 0);

    Label diisli_sõnum=new Label("Diiselkütuse hind (liitri kohta):");
    gridNV.add(diisli_sõnum, 0, 1);
    TextField diisli_hind = new TextField(Double.toString(diislijaam.energiahind));
    gridNV.add(diisli_hind, 1, 1);

    Label elektri_sõnum=new Label("Elektri hind (kWh kohta):");
    gridNV.add(elektri_sõnum, 0, 2);
    TextField elektri_hind = new TextField(Double.toString(elektrijaam.energiahind));
    gridNV.add(elektri_hind, 1, 2);



    elektri_hind.textProperty().addListener((observable, oldvalie, newvalue)-> {
      elektri_hind.setOnKeyPressed(event ->
      {if (!(event.getCode().isDigitKey()||event.getCode()==KeyCode.PERIOD||event.getCode()==KeyCode.COMMA||event.getCode().isArrowKey()||event.getCode()==KeyCode.BACK_SPACE)) {
        elektri_hind.setText(Double.toString(elektrijaam.energiahind));
      }else{
          try {
            elektrijaam.setEnergiahind(Double.parseDouble(newvalue));
          } catch (NumberFormatException e) {
            System.out.println(e);
          }
        }});
      });

    Button lisafaili  = new Button();
    lisafaili.setText("Lisa faili");
    lisafaili.setFont(new Font(12));
    gridNV.add(lisafaili,0, 3);
    //lisafaili.setOnKeyPressed(event -> );
    Button lisaauto = new Button();
    lisaauto.setText("Lisa auto");
    lisaauto.setFont(new Font(12));
    gridNV.add(lisaauto,1, 3);
    lisaauto.setOnMouseClicked(event -> lisaAuto());

    BorderPane paigutus = new BorderPane();
    paigutus.setRight(scrollPane);
    paigutus.setLeft(gridNV);

    // Koostame üldise aknastruktuuri:
    Scene scene = new Scene(paigutus);
    peaLava.setScene(scene);
    peaLava.setTitle("Autovõrdlus");
    peaLava.setWidth(1000);
    peaLava.setHeight(550);
    peaLava.show();
    //Programmi sulgemine esc
    scene.setOnKeyPressed(event -> {if (event.getCode()== KeyCode.ESCAPE) {peaLava.close(); System.exit(0);}});
  }

  public static void main(String[] args) throws Exception {
    int perioodaastates = 5;
    double läbisõitaastas = 15000;
    double sissemakseprotsent = 10;
    double liisinguintress = 2.5;
    double jääkväärtuseprotsent = 20;
    int teepikkus=1000;
    int keskminekiirus=70;

    JOptionPane.showMessageDialog(null, "Tere! Tegemist on arvutiprogrammiga, mis võimaldab omavahel võrrelda erinevaid automarke. Palun sisestage autode andmed");

    boolean kütusehinnate_uendamine = true;
    loefailist();
    lisaAuto();
    while (kütusehinnate_uendamine) { //Kuna need hinnad muutuvad iga päev
      int suvand_eu = JOptionPane.showConfirmDialog(null, "Kas soovite uuendada kütusehindu?", "Kütusehindade uuendamine", JOptionPane.YES_NO_OPTION);
      if (suvand_eu==0) {
        boolean väljad_on_korras = false;
        JPanel jPanel = new JPanel(new GridBagLayout());
        JLabel bensiin_sõnum = new JLabel("Bensiini 98 hind (liitri kohta): ");
        JLabel diisel_sõnum = new JLabel("Diiselkütuse hind (liitri kohta):");
        JLabel elekter_sõnum = new JLabel("Elektri hind (kWh kohta):");
        java.awt.TextField bensiinihind = new java.awt.TextField( 20);
        java.awt.TextField diislihind = new java.awt.TextField(20);
        java.awt.TextField elektrihind = new java.awt.TextField(20);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        jPanel.add(bensiin_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(bensiinihind, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        jPanel.add(diisel_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(diislihind, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        jPanel.add(elekter_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(elektrihind, constraints);
        while(!väljad_on_korras){
          JOptionPane.showConfirmDialog(null,jPanel, "Hindade uuendamine", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
          if (bensiinihind.getText().length() <= 0 || diislihind.getText().length() <= 0 || elektrihind.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Palun kontrollige et kõik väljad on korrektselt täidetud");
            String s1 = bensiinihind.getText();
            String s2 = diislihind.getText();
            String s3 = elektrihind.getText();
            bensiinihind.setText(s1);
            diislihind.setText(s2);
            elektrihind.setText(s3);
          }
          else{
            väljad_on_korras=true;
          }
          bensiinijaam.setEnergiahind(Double.parseDouble(bensiinihind.getText()));
          diislijaam.setEnergiahind(Double.parseDouble(diislihind.getText()));
          elektrijaam.setEnergiahind(Double.parseDouble(elektrihind.getText()));
        }
      } else {
        JOptionPane.showMessageDialog(null, "Kütusehindu ei uuendata");
      }
      kütusehinnate_uendamine = false;

    }

    AutodeVõrdleja autodeVõrdleja = new AutodeVõrdleja(autod);
    autodeVõrdleja.kasutuskulu(perioodaastates, läbisõitaastas,sissemakseprotsent, liisinguintress, jääkväärtuseprotsent);
    autodeVõrdleja.näitaAutod(perioodaastates);
    System.out.println();
    System.out.println("Kolm autot, mille reisi kestus on kõige väiksem: ");
    autodeVõrdleja.kolmkiireimadRändajad(teepikkus, keskminekiirus);
    System.out.println();
    System.out.println("Top 3 kõige loodussõbralikumat autot: ");
    autodeVõrdleja.kolmloodussõbralikkutauto();
    launch(args);
  }

  //Need välisväljad on tehtud niimoodi, et säilitada väärtusi, kui sisend on vale.
  static java.awt.TextField automark = new java.awt.TextField(20);
  static java.awt.TextField ostuhind = new java.awt.TextField(20);
  static java.awt.TextField energiakulu = new java.awt.TextField(20);
  static java.awt.TextField soiduulatus = new java.awt.TextField(20);
  static java.awt.TextField laadimisaeg = new java.awt.TextField(20);

  public static void lisaAuto() {
    boolean autolisamisetsükkel = true;
    while (autolisamisetsükkel) { //Selle tsükli raames lisatakse auto(sid), et neid omavahel võrrelda.
      int suvand_al = JOptionPane.showConfirmDialog(null, "Kas soovite lisada auto?", "Autode lisamine", JOptionPane.YES_NO_OPTION);
      if (suvand_al == 0) {
        boolean väljad_on_korras = false;
        String buttons[] = {"Elektriauto", "Bensiiniauto", "Diiselauto"};
        int autotüüp = JOptionPane.showOptionDialog(null, "Palun valige autotüüp", "Autode lisamine ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, "Bensiiniauto");
        JPanel jPanel = new JPanel(new GridBagLayout()); //Autotüüp 0 on elektriauto isend, 1 on bensiiniauto isenda ja 2 on diiselautoisend
        JLabel automark_sõnum = new JLabel("Automark (firma ja mudel): ");
        JLabel ostuhind_sõnum = new JLabel("Ostuhind (eurodes):");
        JLabel energiakulu_sõnum = new JLabel("Energiakulu (100km kohta):");
        JLabel soiduulatus_sõnum = new JLabel("Sõiduulatus (km):");
        JLabel laadimisaeg_sõnum = new JLabel("Laadimisaeg (tunnides):");
        /*  Kommentaar gridx gridy kohta
                      java.awt.TextField and Jlabel kohad on defineeritud gridy ja gridx läbi samamoel nagu 2D masiivid
                      Illustatsioon:
                        gridx
                       0      1
                g  0
                r  1
                i  2
                d  3
                y  4
                   5                    */

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        jPanel.add(automark_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(automark, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        jPanel.add(ostuhind_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(ostuhind, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        jPanel.add(energiakulu_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(energiakulu, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        jPanel.add(soiduulatus_sõnum, constraints);
        constraints.gridx = 1;
        jPanel.add(soiduulatus, constraints);
        if (autotüüp == 0) {
          constraints.gridx = 0;
          constraints.gridy = 4;
          jPanel.add(laadimisaeg_sõnum, constraints);
          constraints.gridx = 1;
          jPanel.add(laadimisaeg, constraints);
        }
        while (!väljad_on_korras) {
          JOptionPane.showConfirmDialog(null, jPanel, "Autode lisandamine", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
          if(automark.getText().length() == 0 && ostuhind.getText().length() == 0 && energiakulu.getText().length() == 0 && soiduulatus.getText().length() == 0 ) {
            autotüüp=CLOSED_OPTION;
            break; //Juhuks kui kasutaja mõtleb ümber ja ei taha rohkem autosid lisada
          }
          String s1 = automark.getText();
          String s2 = ostuhind.getText();
          String s3 = energiakulu.getText();
          String s4 = soiduulatus.getText();
          automark.setText(s1);
          ostuhind.setText(s2);
          energiakulu.setText(s3);
          soiduulatus.setText(s4);
          if (automark.getText().length() <= 0 || ostuhind.getText().length() <= 0 || energiakulu.getText().length() <= 0 || soiduulatus.getText().length() <= 0) {
              JOptionPane.showMessageDialog(null, "Palun kontrollige et kõik väljad on korrektselt täidetud");
          }else {
              väljad_on_korras = true;

          }
        }
        try{
        switch (autotüüp) {
          case 0 -> autod.add(new Elektriauto(automark.getText(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), elektrijaam, Double.parseDouble(laadimisaeg.getText())));
          case 1 -> autod.add(new Bensiiniauto(automark.getText(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), bensiinijaam));
          case 2 -> autod.add(new Diiselauto(automark.getText(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), diislijaam));
          case CLOSED_OPTION -> autolisamisetsükkel=false;
        }
      }catch (NumberFormatException e){
          JOptionPane.showMessageDialog(null,"Palun kontrollige et arvud on antud arvudena, lünki arvudes loetakse vigaks!");
          lisaAuto();
          break;
        }
        automark.setText(null);
        ostuhind.setText(null);
        energiakulu.setText(null);
        soiduulatus.setText(null);
        laadimisaeg.setText(null);
      } else {
        autolisamisetsükkel = false;
        JOptionPane.showMessageDialog(null, "Autosid rohkem ei lisata");
      }
    }
  }

  public void lisafaili() throws Exception{/*
    int perioodaastates = 5;
    double läbisõitaastas = 15000;
    double sissemakseprotsent = 10;
    double liisinguintress = 2.5;
    double jääkväärtuseprotsent = 20;
    int teepikkus=1000;
    int keskminekiirus=70;
    System.out.println("Aruanne salvestatakse faili aruanne.txt");
    try (
            OutputStream output = new FileOutputStream("aruanne.txt");
            PrintStream printOut = new PrintStream(output)
    ) {
      System.setOut(printOut); // määrame, et kirjutatakse faili.
      System.out.println("Autode andmed järjestatuna kasutuskulude kasvavas järjekorras:");
      System.out.println();
      AutodeVõrdleja.kasutuskulu(perioodaastates, läbisõitaastas, sissemakseprotsent, liisinguintress, jääkväärtuseprotsent);
      AutodeVõrdleja.näitaAutod(perioodaastates);
      System.out.println();
      System.out.println("Kolm autot, mille reisi kestus on kõige väiksem: ");
      AutodeVõrdleja.kolmkiireimadRändajad(teepikkus, keskminekiirus);
      System.out.println();
      System.out.println("Top 3 kõige loodussõbralikumat autot: ");
      AutodeVõrdleja.kolmloodussõbralikkutauto();
    }*/
  }

  public static void loefailist() throws Exception {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(new FileInputStream("autod.txt")));
      String rida = br.readLine();
      while (rida != null) {
        String[] parameetrid = rida.split(",");
        String autotüüp = parameetrid[0];
        String automark = parameetrid[1];
        double ostuhind = Double.parseDouble(parameetrid[2]);
        double energiakulu = Double.parseDouble(parameetrid[3]);
        int soiduulatus = Integer.parseInt(parameetrid[4]);

        switch (autotüüp) {
          case "elekter" -> autod.add(new Elektriauto(automark, ostuhind, energiakulu, soiduulatus, elektrijaam, Double.parseDouble(parameetrid[5])));
          case "bensiin" -> autod.add(new Bensiiniauto(automark, ostuhind, energiakulu, soiduulatus, bensiinijaam));
          case "diisel" -> autod.add(new Diiselauto(automark, ostuhind, energiakulu, soiduulatus, diislijaam));
        }

        rida = br.readLine();
      }
    } catch (FileNotFoundException e){
      JOptionPane.showMessageDialog(null,"Ei leidnud faili andmetega");
      System.exit(-1);
    }finally {
      br.close();
    }
  }
}