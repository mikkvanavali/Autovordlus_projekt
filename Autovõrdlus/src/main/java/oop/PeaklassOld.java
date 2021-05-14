/*package oop;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PeaklassOld {
    public static void main(String[] args) {

        int perioodaastates = 5;
        double läbisõitaastas = 15000;
        double sissemakseprotsent = 10;
        double liisinguintress = 2.5;
        double jääkväärtuseprotsent = 20;
        int teepikkus=1000;
        int keskminekiirus=70;
        List<Auto> autod = new ArrayList<>();

        // energiahindade vaikeväärtused

        Elektrijaam elektrijaam = new Elektrijaam(0.16, 475); //Siin on kütuseCO2jälg kWh kohta, seetõttu see paistab väiksemana
        Diislijaam diislijaam = new Diislijaam(1.22, 2640);
        Bensiinijaam bensiinijaam = new Bensiinijaam(1.40, 2392);

        Auto audi = new Diiselauto("Audi A6",  50000, 8,1000, diislijaam);
        Auto tesla = new Elektriauto("Tesla Model S", 100000, 20,250, elektrijaam, 1.5 );
        Auto skoda = new Bensiiniauto("Skoda Fabia", 18000, 7, 600, bensiinijaam);
        autod.add(audi);
        autod.add(tesla);
        autod.add(skoda);

        JOptionPane.showMessageDialog(null, "Tere! Tegemist on arvutiprogrammiga, mis võimaldab omavahel võrrelda erinevaid automarke. Palun sisestage autode andmed");

        boolean autolisamisetsükkel = true;
        boolean kütusehinnate_uendamine = true;
        while (autolisamisetsükkel) { //Selle tsükli raames lisatakse auto(sid), et neid omavahel võrrelda.
            int suvand_al = JOptionPane.showConfirmDialog(null, "Kas soovite lisada auto?", "Autode lisamine", JOptionPane.YES_NO_OPTION);
            if (suvand_al == 0) {
                boolean väljad_on_korras = false;
                String buttons[]={"Elektriauto", "Bensiiniauto", "Diiselauto"};
                int autotüüp = JOptionPane.showOptionDialog(null, "Palun valige autotüüp","Autode lisamine ",JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, buttons, "Bensiiniauto");
                JPanel jPanel = new JPanel(new GridBagLayout()); //Autotüüp 0 on elektriauto isend, 1 on bensiiniauto isenda ja 2 on diiselautoisend
                JLabel automark_sõnum = new JLabel("Automark (firma ja mudel): ");
                JLabel ostuhind_sõnum = new JLabel("Ostuhind (eurodes):");
                JLabel energiakulu_sõnum = new JLabel("Energiakulu (100km kohta):");
                JLabel soiduulatus_sõnum = new JLabel("Sõiduulatus (km):");
                JLabel laadimisaeg_sõnum = new JLabel("Laadimisaeg (tunnides):");
                TextField automark = new TextField(20);
                TextField ostuhind = new TextField(20);
                TextField energiakulu = new TextField(20);
                TextField soiduulatus = new TextField(20);
                TextField laadimisaeg = new TextField(20);
                /* Kommentaar gridx gridy kohta
                      Textfield and Jlabel kohad on defineeritud gridy ja gridx läbi samamoel nagu 2D masiivid
                      Illustatsioon:
                        gridx
                       0      1
                g  0
                r  1
                i  2
                d  3
                y  4
                   5
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
                if(autotüüp==0){
                    constraints.gridx = 0;
                    constraints.gridy = 4;
                    jPanel.add(laadimisaeg_sõnum, constraints);
                    constraints.gridx = 1;
                    jPanel.add(laadimisaeg, constraints);
                }
                while (!väljad_on_korras) {
                    JOptionPane.showConfirmDialog(null, jPanel, "Autode lisandamine", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (autotüüp==0){
                        if (automark.getText().length() <= 0 || ostuhind.getText().length() <= 0 || energiakulu.getText().length() <= 0 || soiduulatus.getText().length() <= 0 ||laadimisaeg.getText().length()<=0) {
                            JOptionPane.showMessageDialog(null, "Palun kontrollige et kõik väljad on korrektselt täidetud");
                            String s1 = automark.getText();
                            String s2 = ostuhind.getText();
                            String s3 = energiakulu.getText();
                            String s4 = soiduulatus.getText();
                            String s5 = laadimisaeg.getText();
                            automark.setText(s1);
                            ostuhind.setText(s2);
                            energiakulu.setText(s3);
                            soiduulatus.setText(s4);
                            laadimisaeg.setText(s5);
                        } else {
                            väljad_on_korras = true;
                        }
                    }else {if (automark.getText().length() <= 0 || ostuhind.getText().length() <= 0 || energiakulu.getText().length() <= 0 || soiduulatus.getText().length() <= 0) {
                        JOptionPane.showMessageDialog(null, "Palun kontrollige et kõik väljad on korrektselt täidetud");
                        String s1 = automark.getText();
                        String s2 = ostuhind.getText();
                        String s3 = energiakulu.getText();
                        String s4 = soiduulatus.getText();
                        automark.setText(s1);
                        ostuhind.setText(s2);
                        energiakulu.setText(s3);
                        soiduulatus.setText(s4);
                    } else {
                        väljad_on_korras = true;
                    }
                    }
                }
                switch (autotüüp) {
                    case 0 -> autod.add(new Elektriauto(automark.getText().toString(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), elektrijaam, Double.parseDouble(laadimisaeg.getText())));
                    case 1 -> autod.add(new Bensiiniauto(automark.getText().toString(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), bensiinijaam));
                    case 2 -> autod.add(new Diiselauto(automark.getText().toString(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), diislijaam));
                }
            } else {
                autolisamisetsükkel = false;
                JOptionPane.showMessageDialog(null, "Autosid rohkem ei lisata");
            }
        }

        while (kütusehinnate_uendamine) { //Kuna need hinnad muutuvad iga päev
            int suvand_eu = JOptionPane.showConfirmDialog(null, "Kas soovite uuendada kütusehindu?", "Kütusehindade uuendamine", JOptionPane.YES_NO_OPTION);
            if (suvand_eu==0) {
                boolean väljad_on_korras = false;
                JPanel jPanel = new JPanel(new GridBagLayout());
                JLabel bensiin_sõnum = new JLabel("Bensiini 98 hind (liitri kohta): ");
                JLabel diisel_sõnum = new JLabel("Diiselkütuse hind (liitri kohta):");
                JLabel elekter_sõnum = new JLabel("Elektri hind (kWh kohta):");
                TextField bensiinihind = new TextField( 20);
                TextField diislihind = new TextField(20);
                TextField elektrihind = new TextField(20);
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

        System.out.println();

        System.out.println("Autode andmed järjestatuna kasutuskulude kasvavas järjekorras:" );
        System.out.println();
        autodeVõrdleja.kasutuskulu(perioodaastates, läbisõitaastas,sissemakseprotsent, liisinguintress, jääkväärtuseprotsent);
        autodeVõrdleja.näitaAutod(perioodaastates);
        System.out.println();
        System.out.println("Kolm autot, mille reisi kestus on kõige väiksem: ");
        autodeVõrdleja.kolmkiireimadRändajad(teepikkus, keskminekiirus);
        System.out.println();
        System.out.println("Top 3 kõige loodussõbralikumat autot: ");
        autodeVõrdleja.kolmloodussõbralikkutauto();
    }
}
*/

/*
* if (automark.getText().length() <= 0 || ostuhind.getText().length() <= 0 || energiakulu.getText().length() <= 0 || soiduulatus.getText().length() <= 0) {
              JOptionPane.showMessageDialog(null, "Palun kontrollige et kõik väljad on korrektselt täidetud");
              String s1 = automark.getText();
              String s2 = ostuhind.getText();
              String s3 = energiakulu.getText();
              String s4 = soiduulatus.getText();
              automark.setText(s1);
              ostuhind.setText(s2);
              energiakulu.setText(s3);
              soiduulatus.setText(s4);
            } else {
              väljad_on_korras = true;
            }
          }
        }
        try{
        switch (autotüüp) {
          case 0 -> autod.add(new Elektriauto(automark.getText(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), elektrijaam, Double.parseDouble(laadimisaeg.getText())));
          case 1 -> autod.add(new Bensiiniauto(automark.getText(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), bensiinijaam));
          case 2 -> autod.add(new Diiselauto(automark.getText(), Double.parseDouble(ostuhind.getText()), Double.parseDouble(energiakulu.getText()), Integer.parseInt(soiduulatus.getText()), diislijaam));
        }
      }catch (NumberFormatException e){
          JOptionPane.showMessageDialog(null,"Palun kontrollige et arvud on antud arvudena, lünki arvudes loetakse vigaks!");

        }*/