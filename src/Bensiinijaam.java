public class Bensiinijaam extends Jaam{
    public Bensiinijaam(double energiahind, double kütuseCO2jälg) {
                 super(energiahind, kütuseCO2jälg);
     }

    @Override
    public void setEnergiahind(double energiahind) {
        super.setEnergiahind(energiahind);
    }

    @Override
    public double getEnergiahind() {
        return super.getEnergiahind();
    }
}
