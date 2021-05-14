package oop;
 public class Elektriauto extends Auto{
    private double laadimisaeg;
    private double soiduulatus;

    public Elektriauto(String automark, double ostuhind, double energiakulu, int soiduulatus, Elektrijaam energiatarnija, double laadimisaeg) {
        super(automark, ostuhind, energiakulu, soiduulatus, energiatarnija);
        this.laadimisaeg = laadimisaeg;
        this.soiduulatus = soiduulatus;
    }

    @Override
    public String getAutomark() {
        return super.getAutomark();
    }

    public double reisiKestus(int teepikkus, int keskminekiirus) {
        return Math.round((teepikkus/soiduulatus)*laadimisaeg + (teepikkus/keskminekiirus));
    }

    @Override
    public String toString() {
        return "Elektriauto: "+ automark + " elektrikulu: " + energiakulu + " kWh/100km, "+super.toString();
    }
}
