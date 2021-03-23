public class Auto {
    String mark;
    String mudel;
    String tyyp; // elektriauto, diiselauto, bensiiniauto
    double ostuhind;
    double energiakulu;
    int laadimisaeg;
    int soiduulatus;
    Jaam energiatarnija;

    public Auto(String mark, String mudel, String tyyp, double ostuhind, double energiakulu, int laadimisaeg, int soiduulatus, Jaam energiatarnija) {
        this.mark = mark;
        this.mudel = mudel;
        this.tyyp = tyyp;
        this.ostuhind = ostuhind;
        this.energiakulu = energiakulu;
        this.laadimisaeg = laadimisaeg; // selle viime elektriauto klassi vast?
        this.soiduulatus = soiduulatus; // selle viime elektriauto klassi vast?
        this.energiatarnija = energiatarnija;
    }

    public String getMark() {
        return mark;
    }

    public String getMudel() {
        return mudel;
    }

    public String getTyyp() {
        return tyyp;
    }

    public double getOstuhind() {
        return ostuhind;
    }

    public double getEnergiakulu() {
        return energiakulu;
    }

    public void setEnergiakulu(double energiakulu) {
        this.energiakulu = energiakulu;
    }

    public int getSoiduulatus() {
        return soiduulatus;
    }

    public void setSoiduulatus(int soiduulatus) {
        this.soiduulatus = soiduulatus;
    }

    public int getLaadimisaeg() {
        return laadimisaeg;
    }

    public void setLaadimisaeg(int laadimisaeg) {
        this.laadimisaeg = laadimisaeg;
    }

    public Jaam getEnergiatarnija() {
        return energiatarnija;
    }

    public void setElektritarnija(Jaam energiatarnija) {
        this.energiatarnija = energiatarnija;
    }

    public double maksumus100() {
        return (energiakulu*energiatarnija.energiahind);
    }

    public double maksumus(double teepikkus) {
        return (teepikkus*maksumus100()/100);
    }


// kasutuskulu arvutuse valem, mis võtab arvesse  praegu. see on üks keerulisemaid osi selles programmis, aga tehtav
// küsimus on selles, et võib-olla peaks liisingufirma klassi tegema eraldi?

    public double kasutuskulu (int perioodaastates, double läbisõitaastas, double sissemakseprotsent, double liisinguintress, double jääkväärtuseprotsent ) {
        double sissemaks = ostuhind*sissemakseprotsent/100;
        double jääkväärtus = ostuhind*jääkväärtuseprotsent/100;
        double liisinguosa = ostuhind - sissemaks - jääkväärtus;
        double r = (liisinguintress / 100) / 12;
        double n = 12 * perioodaastates;
        double liisinguKuumakse = (liisinguosa * r) / (1 - Math.pow(1+r, -n));
        double liisingukulu = perioodaastates*12*liisinguKuumakse;
        return sissemaks - jääkväärtus + liisingukulu + maksumus((int) (perioodaastates*läbisõitaastas));
    }

    // bensiini-ja diiselautol on sõiduulatus == teepikkus ja laadimisaeg == 0 või lahendame kuidagi teistmoodi?

    public double reisiKestus(int teepikkus, int keskminekiirus) {
        return (teepikkus/soiduulatus)*laadimisaeg + (teepikkus/keskminekiirus);
    }

    /* tostring tuleks ilmselt teha igale autotüübile eraldi

    public String toString() {
        return ("Auto mark: " + mark + "mudel: " + mudel + ", elektri/kütusekulu: " + energiakulu + " l/kWh/100km, laadimisaeg: "
                + laadimisaeg + " tundi, sõiduulatus: " + soiduulatus + "km, 100km reisi maksumus: "
                + maksumus100()) + " EUR.";
    }

     */

}
