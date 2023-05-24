package Models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import Models.Plata;

public class Contract extends TipContract {
    int id_contract;
    int id_client;
    String tip_contract_id;
    float pret_total;
    LocalDate data_incepere_contract;
    LocalDate data_sfarsit_contract;
    Plata plata;

    public Contract(String tip_contract_id, int id_client, LocalDate data_incepere_contract, LocalDate data_sfarsit_contract, float pret_total) {
        this.tip_contract_id = tip_contract_id;
        this.id_client = id_client;
        this.pret_total = pret_total;
        this.data_incepere_contract = data_incepere_contract;
        this.data_sfarsit_contract = data_sfarsit_contract;
    }

    public int getId_contract() {
        return id_contract;
    }

    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getTip_contract_id() {
        return tip_contract_id;
    }

    public void setTip_contract_id(String tip_contract_id) {
        this.tip_contract_id = tip_contract_id;
    }

    public float getPret_total() {
        return pret_total;
    }

    public void setPret_total(float pret_total) {
        this.pret_total = pret_total;
    }

    public LocalDate getData_incepere_contract() {
        return data_incepere_contract;
    }

    public void setData_incepere_contract(LocalDate data_incepere_contract) {
        this.data_incepere_contract = data_incepere_contract;
    }

    public LocalDate getData_sfarsit_contract() {
        return data_sfarsit_contract;
    }

    public void setData_sfarsit_contract(LocalDate data_sfarsit_contract) {
        this.data_sfarsit_contract = data_sfarsit_contract;
    }
    //    public void setPlata(Plata plata) {
//        this.plata = plata;
//    }
//
//    public String toString()
//    {
//        return "Clientul: " + client.toString() + "\n" + "Copilul: " + copil.toString() + "\n" + "Pret total: " + pret_total;
//    }
}
