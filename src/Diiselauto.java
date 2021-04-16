 public class Diiselauto extends Auto{
    public Diiselauto(String automark, double ostuhind, double energiakulu, int soiduulatus, Jaam energiatarnija ) {
        super( automark, ostuhind, energiakulu, soiduulatus, energiatarnija);
   }
     public double reisiKestus(int teepikkus, int keskminekiirus) {
         return Math.round(teepikkus/keskminekiirus);
     }

     @Override
     public String getAutomark() {
         return super.getAutomark();
     }
     @Override
     public String toString() {
         return "Diiselauto: "+automark + " kütusekulu: " + energiakulu + " l/100km, "+super.toString();
     }

}
