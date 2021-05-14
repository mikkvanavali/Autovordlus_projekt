package oop;
public class Jaam {
    double energiahind;
    double kütuseCO2jälg;

    public Jaam(double energiahind, double kütuseCO2jälg) {
        this.energiahind = energiahind;
        this.kütuseCO2jälg=kütuseCO2jälg;
    }

    public void setEnergiahind(double energiahind) {
        if (energiahind>0)
            this.energiahind = energiahind;
    }

    public double getEnergiahind() {
        return energiahind;
    }

}