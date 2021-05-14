package oop;
import java.util.Collections;
import java.util.List;

public class AutodeVõrdleja {
    private List<Auto> autod;

    public AutodeVõrdleja(List<Auto> autod) {
        this.autod = autod;
    }

    public void kasutuskulu (int perioodaastates, double läbisõitaastas, double sissemakseprotsent, double liisinguintress, double jääkväärtuseprotsent) {
        for (Auto auto : autod) {
            double sissemaks = auto.getOstuhind() * sissemakseprotsent / 100;
            double jääkväärtus = auto.getOstuhind() * jääkväärtuseprotsent / 100;
            double liisinguosa = auto.getOstuhind() - sissemaks - jääkväärtus;
            double r = (liisinguintress / 100) / 12;
            double n = 12 * perioodaastates;
            double liisinguKuumakse = (liisinguosa * r) / (1 - Math.pow(1 + r, -n));
            double liisingukulu = perioodaastates * 12 * liisinguKuumakse;
            auto.kasutuskulu=sissemaks - jääkväärtus + liisingukulu + auto.maksumus((int) (perioodaastates*läbisõitaastas));
        }
    }


    public void näitaAutod(int perioodaastates){
        Collections.sort(autod);
        for (Auto auto : autod) {
            System.out.println(auto.toString() + " Kasutuskulu perioodi "+perioodaastates+ " a. jooksul on " + Math.round(auto.kasutuskulu*100)/100.0 + " eurot.");
        }
    }
    public void kolmkiireimadRändajad(int teepikkus, int keskminekiirus){ //Polee ideet kuidas seda nimetada
        Auto esimene_koht=autod.get(0);
        Auto teine_koht=autod.get(0);
        Auto kolmas_koht=autod.get(0);
        Auto temp1; //"Ajutine muutuja", et vahetada Autosid assigneeritud erinevatele kohtadele
        Auto temp2; //temp1 parema reisiKestuse jaoks(vähema jaoks)
        for (Auto auto : autod) {
            if(esimene_koht.reisiKestus(teepikkus, keskminekiirus)<auto.reisiKestus(teepikkus, keskminekiirus)){
                esimene_koht=auto;//See tsükkel teeb niimoodi, et esimesel kolm kohal on kõige aeglasemad sõidukid.
            }
        }
        teine_koht=esimene_koht;  //See omakorda tagab teise foreach tsükli korrektse töö.
        kolmas_koht=esimene_koht; //Tegisime just niiimoodi, sest autod.get(0) Auto võib olla kõige kiirem ja siis oleks raske võrreldada
        for (Auto auto : autod) {
            if(esimene_koht.reisiKestus(teepikkus, keskminekiirus)>auto.reisiKestus(teepikkus, keskminekiirus)){
                temp1=esimene_koht;
                temp2=teine_koht;
                esimene_koht=auto;
                teine_koht=temp1;
                kolmas_koht=temp2;
            } else if(teine_koht.reisiKestus(teepikkus, keskminekiirus)>auto.reisiKestus(teepikkus, keskminekiirus)) {
                temp1=teine_koht;
                teine_koht=auto;
                kolmas_koht=temp1;
            } else if(kolmas_koht.reisiKestus(teepikkus, keskminekiirus)>auto.reisiKestus(teepikkus, keskminekiirus)){
                kolmas_koht=auto;
            }
        }
        System.out.println("Auto "+esimene_koht.getAutomark()+" aeg "+teepikkus+" km läbimiseks keskmise kiirusega "+keskminekiirus+"km/h on "+ esimene_koht.reisiKestus(teepikkus, keskminekiirus)+"tundi.");
        System.out.println("Auto "+teine_koht.getAutomark()+" aeg "+teepikkus+" km läbimiseks keskmise kiirusega "+keskminekiirus+"km/h on "+ teine_koht.reisiKestus(teepikkus, keskminekiirus)+"tundi.");
        System.out.println("Auto "+kolmas_koht.getAutomark()+" aeg "+teepikkus+" km läbimiseks keskmise kiirusega "+keskminekiirus+"km/h on "+kolmas_koht.reisiKestus(teepikkus, keskminekiirus)+"tundi.");
    }

  public void kolmloodussõbralikkutauto() {
      Auto esimene_koht = autod.get(0);
      Auto teine_koht = autod.get(0);
      Auto kolmas_koht = autod.get(0);
      Auto temp1; //"Ajutine muutuja", et vahetada Autosid assigneeritud erinevatele kohtadele
      Auto temp2; //temp1 parema reisiKestuse jaoks(vähema jaoks)
      for (Auto auto : autod) {
          if (esimene_koht.autoCO2jälg() < auto.autoCO2jälg()) {
              esimene_koht = auto;// See tsükkel teeb niimoodi, et esimesel kolm kohal on vähem loodussõbralikud autod ;
          }
      }
      teine_koht = esimene_koht;  //See omakorda tagab teise foreach tsükli korrektse töö.
      kolmas_koht = esimene_koht; //Tegisime just niiimoodi, sest autod.get(0) Auto võib olla kõige loodussõbralikum ja siis oleks raske võrreldada
      for (Auto auto : autod) {
          if (esimene_koht.autoCO2jälg() > auto.autoCO2jälg()) {
              temp1 = esimene_koht;
              temp2 = teine_koht;
              esimene_koht = auto;
              teine_koht = temp1;
              kolmas_koht = temp2;
          } else if (teine_koht.autoCO2jälg() > auto.autoCO2jälg()) {
              temp1 = teine_koht;
              teine_koht = auto;
              kolmas_koht = temp1;
          } else if (kolmas_koht.autoCO2jälg() > auto.autoCO2jälg()) {
              kolmas_koht = auto;
          }
      }

      System.out.println(esimene_koht);
      System.out.println(teine_koht);
      System.out.println(kolmas_koht);
  }
}
