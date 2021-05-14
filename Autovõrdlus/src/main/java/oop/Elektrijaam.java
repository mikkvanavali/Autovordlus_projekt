package oop;
public class Elektrijaam extends Jaam{
    double elektriCO2jälg; //Kuna CO2 toodetakse mitte autos, vaid elektrijaamas
    public Elektrijaam(double energiahind, double kütuseCO2jälg) {
        super(energiahind,kütuseCO2jälg);
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
