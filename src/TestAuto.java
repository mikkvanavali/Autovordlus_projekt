public class TestAuto {


    public static void main(String[] args) {
        Jaam testbensiinijaam = new Jaam("Shell", 1.23);
        Jaam testelektrijaam = new Jaam("Eesli energia", 0.15);

        Auto audi1 = new Auto("Audi", "A6", "bensiiniauto", 60000, 8, 0,1000, testbensiinijaam );
        Auto nissan = new Auto("Nissan", "Leaf", "elektriauto", 40000, 18.5, 1,160, testelektrijaam );

        // arvan, et Liisingufirma võiks tekitada eraldi?
        int perioodaastates = 5;
        double läbisõitaastas = 20000;
        double sissemakseprotsent = 10;
        double liisinguintress = 2;
        double jääkväärtuseprotsent = 25;

        //int perioodaastates, double läbisõitaastas, double sissemakseprotsent, double liisinguintress, double jääkväärtuseprotsent
        System.out.println((int) audi1.kasutuskulu(perioodaastates, läbisõitaastas, sissemakseprotsent, liisinguintress, jääkväärtuseprotsent));
        System.out.println((int) nissan.kasutuskulu(perioodaastates, läbisõitaastas, sissemakseprotsent, liisinguintress, jääkväärtuseprotsent));
        System.out.println((int) audi1.reisiKestus(1000, 90));
        System.out.println((int) nissan.reisiKestus(1000, 90));

    }

}
