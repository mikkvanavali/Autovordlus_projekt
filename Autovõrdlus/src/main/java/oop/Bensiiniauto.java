package oop;
public class Bensiiniauto extends Auto {
    public Bensiiniauto(String automark, double ostuhind, double energiakulu, int soiduulatus, Bensiinijaam energiatarnija) {
        super(automark, ostuhind, energiakulu, soiduulatus, energiatarnija);
    }

    @Override
    public String getAutomark() {
        return super.getAutomark();
    }

    public double reisiKestus(int teepikkus, int keskminekiirus) {
        return Math.round(teepikkus/keskminekiirus);
    }

    public String toString() {
        return "Bensiiniauto: "+automark + " kütusekulu: " + energiakulu + " l/100km, "+super.toString();
    }
}
