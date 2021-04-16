public abstract class Auto implements Comparable<Auto>{
    String automark;
    double ostuhind;
    double energiakulu;
    int soiduulatus;
    Jaam energiatarnija;
    double kasutuskulu;


    public Auto(String automark, double ostuhind, double energiakulu, int soiduulatus, Jaam energiatarnija) {
        this.automark =automark;
        this.soiduulatus = soiduulatus;
        this.ostuhind = ostuhind;
        this.energiakulu = energiakulu;
        this.energiatarnija = energiatarnija;
    }
    public double getOstuhind() {
        return ostuhind;
    }

    public String getAutomark() {
        return automark;
    }

    public double maksumus100() {
        return (energiakulu*energiatarnija.energiahind);
    }

    public double maksumus(double teepikkus) {
        return (teepikkus*maksumus100()/100);
    }

    abstract double reisiKestus(int teepikkus, int keskminekiirus);

    public double autoCO2jälg(){
        return energiakulu*energiatarnija.kütuseCO2jälg;
    }

    public int compareTo(Auto o) {
        return Double.compare(this.kasutuskulu, o.kasutuskulu);
    }

    public String toString() {
        return "sõiduulatus: " + soiduulatus + "km, 100km reisi maksumus: "
                + Math.round(maksumus100()*100)/100.0 + " EUR. ";
    }
}


