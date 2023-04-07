package Models;

import java.time.LocalDate;

public class Plata {
    int id_plata;
    int id_contract;
    String status;
    String metoda_plata;
    LocalDate data;

    public Plata(String metoda_plata, String status, LocalDate data)
    {
        this.metoda_plata = metoda_plata;
        this.status = status;
        this.data = data;
    }
}
