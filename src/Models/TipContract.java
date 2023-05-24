package Models;

public class TipContract {
    String denumire;
    float pret; // pe luna

    public TipContract(String denumire, float pret) {
        this.denumire = denumire;
        this.pret = pret;
    }
    public TipContract(){}
}
