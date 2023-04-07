package Models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import Models.Plata;

public class Contract extends TipContract {
    int id_contract;
    Client client;
    Copil copil;
    float pret_total;
    LocalDate data_incepere_contract;
    LocalDate data_sfarsit_contract;
    Plata plata;

    public Contract(String denumire, float pret, int id_contract, Client client, Copil copil, float pret_total, LocalDate data_incepere_contract, LocalDate data_sfarsit_contract, Plata plata)
    {
        super(denumire, pret);
        this.id_contract = id_contract;
        this.client = client;
        this.copil = copil;
        this.pret_total = pret_total;
        this.data_incepere_contract = data_incepere_contract;
        this.data_sfarsit_contract = data_sfarsit_contract;
        this.plata = plata;
    }
}
