import Controllers.*;
import Models.*;
import Utils.Operations_Logger;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        ChildController childController= new ChildController();
        ClientController clientController = new ClientController();
        EducatorController educatorController = new EducatorController();
        ContractController contractController = new ContractController();

        Scanner sc = new Scanner(System.in);
        String option;
        do{
            System.out.println("1. Client CRUD");
            System.out.println("2. Child CRUD");
            System.out.println("3. Educator CRUD");
            System.out.println("4. Contract CRUD");
            option = sc.nextLine();

            switch(Integer.parseInt(option))
            {
                case 1:
                {
                    System.out.println("1. Add Client");
                    System.out.println("2. Get all clients");
                    System.out.println("3. Update Client");
                    System.out.println("4. Delete Client");
                    option = sc.nextLine();
                    switch(Integer.parseInt(option))
                    {
                        case 1:
                        {
                            String nume = sc.nextLine();
                            String prenume = sc.nextLine();
                            String telefon = sc.nextLine();
                            String email = sc.nextLine();
                            String adresa = sc.nextLine();

                            Client c = new Client(nume,prenume,telefon,email,adresa);

                            Operations_Logger.logOperation("Client adaugat", clientController.add(c));


                            break;
                        }
                        case 2:
                        {
                            Client[] clients = new Client[101];
                            clients = clientController.getAll();
                            for(int i=0;i<101;i++)
                            {
                                if(clients[i]!=null)
                                    System.out.println(clients[i]);
                            }
                            Operations_Logger.logOperation("Clienti afisati", true);


                            break;
                        }
                        case 3:
                        {
                            System.out.println("Select the Client id that you want to update: ");
                            String id = sc.nextLine();
                            System.out.println("Update the new client: ");
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Telefon: ");
                            String telefon = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            System.out.println("Adresa: ");
                            String adresa = sc.nextLine();

                            Client c = new Client(nume,prenume, telefon, email, adresa);

                            Operations_Logger.logOperation("Client updatat", clientController.update(id, c));

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Client id that you want to delete: ");
                            String id = sc.nextLine();

                            Operations_Logger.logOperation("Client sters", clientController.delete(id));

                            break;
                        }
                    }
                    break;

                }
                case 2:
                {
                    System.out.println("1. Add Child");
                    System.out.println("2. Get all children");
                    System.out.println("3. Update Child");
                    System.out.println("4. Delete Child");
                    option = sc.nextLine();
                    switch(Integer.parseInt(option))
                    {
                        case 1:
                        {
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Data nasterii");
                            LocalDate data;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data = LocalDate.parse(sc.nextLine(), formatter);
                            System.out.println("Id-ul educatorului: ");
                            int id_educator = Integer.parseInt(sc.nextLine());
                            System.out.println("Id-ul grupei: ");
                            String id_grupa = sc.nextLine();
                            System.out.println("Id-ul contractului: ");
                            int id_contract = Integer.parseInt(sc.nextLine());

                            Copil c = new Copil(nume,prenume, data, new FisaMedicala());

                            c.setId_educator(id_educator);
                            c.setId_contract(id_contract);
                            c.setId_grupa(id_grupa);

                            Operations_Logger.logOperation("Copil adaugat", childController.add(c));

                            break;
                        }

                        case 2:
                        {
                            childController.getAll();
                            Operations_Logger.logOperation("Copii afisati", true);

                            break;
                        }

                        case 3:
                        {
                            System.out.println("Select the Child id that you want to update: ");
                            String id = sc.nextLine();
                            System.out.println("Update the new child: ");
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Data nasterii");
                            LocalDate data;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data = LocalDate.parse(sc.nextLine(), formatter);

                            Copil c = new Copil(nume,prenume, data, new FisaMedicala());

                            Operations_Logger.logOperation("Copil updatat", childController.update(id, c));


                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Child id that you want to delete: ");
                            String id = sc.nextLine();

                            Operations_Logger.logOperation("Copil sters", childController.delete(id));

                            break;
                        }
                    }
                    break;

                }
                case 3:
                {
                    System.out.println("1. Add Educator");
                    System.out.println("2. Get all educators");
                    System.out.println("3. Update Educator");
                    System.out.println("4. Delete Educator");
                    option = sc.nextLine();
                    switch(Integer.parseInt(option))
                    {
                        case 1:
                        {
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Telefon: ");
                            String telefon = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            System.out.println("Adresa: ");
                            String adresa = sc.nextLine();
                            System.out.println("Salariu: ");
                            int salariu = Integer.parseInt(sc.nextLine());

                            Educator e = new Educator(nume,prenume, telefon, email, adresa, salariu);

                            Operations_Logger.logOperation("Educator adaugat", educatorController.add(e));


                            break;
                        }

                        case 2:
                        {
                            List<Educator> educators = new ArrayList<Educator>();
                            educators = educatorController.getAll();
                            for(int i=0; i<educators.size();i++)
                            {
                                System.out.println(educators.get(i));
                            }
                            Operations_Logger.logOperation("Educatori afisati", true);

                            break;
                        }

                        case 3:
                        {
                            System.out.println("Select the Educator id that you want to update: ");
                            String id = sc.nextLine();
                            System.out.println("Update the new educator: ");
                            System.out.println("Nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Telefon: ");
                            String telefon = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            System.out.println("Adresa: ");
                            String adresa = sc.nextLine();
                            System.out.println("Salariu: ");
                            int salariu = Integer.parseInt(sc.nextLine());

                            Educator e = new Educator(nume,prenume, telefon, email, adresa, salariu);

                            Operations_Logger.logOperation("Educator updatat", educatorController.update(id, e));

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Educator id that you want to delete: ");
                            String id = sc.nextLine();

                            Operations_Logger.logOperation("Educator sters", educatorController.delete(id));

                            break;
                        }
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("1. Add Contract");
                    System.out.println("2. Get all contracts");
                    System.out.println("3. Update Contract");
                    System.out.println("4. Delete Contract");
                    option = sc.nextLine();
                    switch(Integer.parseInt(option))
                    {
                        case 1:
                        {
                            System.out.println("Tip contract: Program Semi = S3 / Program Full = F3");
                            String tip_contract = sc.nextLine();
                            System.out.println("Id client: ");
                            int id_client = Integer.parseInt(sc.nextLine());
                            System.out.println("Data incepere: ");
                            LocalDate data_incepere;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data_incepere = LocalDate.parse(sc.nextLine(), formatter);
                            System.out.println("Data sfarsit: ");
                            LocalDate data_sfarsit;
                            data_sfarsit = LocalDate.parse(sc.nextLine(), formatter);



                            Contract c = new Contract(tip_contract,id_client, data_incepere, data_sfarsit, 0);

                            Operations_Logger.logOperation("Contract adaugat", contractController.add(c));

                            break;
                        }

                        case 2:
                        {
                            HashMap<String, SortedSet<Contract>> contracts = new HashMap<String,SortedSet<Contract>>();
                            SortedSet<Contract> contracte_semi = new TreeSet<>();
                            SortedSet<Contract> contracte_full = new TreeSet<>();
                            contracts = contractController.getAll();
                            if(contracts != null) {
                                contracte_semi = contracts.get("Program Semi");
                                contracte_full = contracts.get("Program Full");
                                System.out.println("Contracte cu program semi: ");
                                contracte_semi.stream().forEach(System.out::println);
                                System.out.println("\nContracte cu program full: ");
                                contracte_full.stream().forEach(System.out::println);
                                System.out.println("");
                                Operations_Logger.logOperation("Contracte afisate", true);
                            }

                            break;
                        }

                        case 3:
                        {
                            System.out.println("Select the Contract id that you want to update: ");
                            String id = sc.nextLine();
                            System.out.println("Update the new contract: ");
                            System.out.println("Tip contract: Program Semi = S3 / Program Full = F3");
                            String tip_contract = sc.nextLine();
                            System.out.println("Id client: ");
                            int id_client = Integer.parseInt(sc.nextLine());
                            System.out.println("Data incepere: ");
                            LocalDate data_incepere;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            data_incepere = LocalDate.parse(sc.nextLine(), formatter);
                            System.out.println("Data sfarsit: ");
                            LocalDate data_sfarsit;
                            data_sfarsit = LocalDate.parse(sc.nextLine(), formatter);

                            Contract c = new Contract(tip_contract,id_client, data_incepere, data_sfarsit, 0);

                            Operations_Logger.logOperation("Contract updatat", contractController.update(id, c));

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Contract id that you want to delete: ");
                            String id = sc.nextLine();

                            Operations_Logger.logOperation("Contract sters", contractController.delete(id));

                            break;
                        }
                    }
                    break;

                }

//                case 6:
//                {
//                    System.out.println("Select child:");
//                    Copil [] children = childController.getAll();
//                    for(int i=0;i<children.length;i++) {
//                        if(children[i] != null) {
//                            System.out.println(i + ". " + children[i]);
//                        }
//                    }
//                    int index = Integer.parseInt(sc.nextLine());
//                    float greutate;
//                    greutate = Float.parseFloat(sc.nextLine());
//                    String medic = sc.nextLine();
//                    LocalDate data;
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                    data = LocalDate.parse(sc.nextLine(), formatter);
//                    children[index].setMedicalReport(greutate, medic, data);
//                    medicalController.add(print(sorted(matrice_desfasurata)));
//                      childController.addMedical(id_fisa);
//                    break;
//                }
//                case 7:
//                {
//                    Copil [] children = childController.getAll();
//                    for(int i=0;i<children.length;i++) {
//                        if(children[i] != null) {
//                            System.out.println(children[i].getNume() + " " + children[i].getPrenume());
//                            System.out.println(children[i].medicalToString());
//                            System.out.println();
//                        }
//                    }
//                    break;
//                }
//                case 8:
//                {
//                    String denumire = sc.nextLine();
//                    float pret = Float.parseFloat(sc.nextLine());
//                    float pret_total = Float.parseFloat(sc.nextLine());
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                    LocalDate data_inc;
//                    LocalDate data_sf;
//                    data_inc = LocalDate.parse(sc.nextLine(), formatter);
//                    data_sf = LocalDate.parse(sc.nextLine(), formatter);
//
//                    System.out.println("Select client:");
//                    Client[] clients = clientController.getAll();
//                    for(int i=0;i<clients.length;i++) {
//                        if(clients[i] != null) {
//                            System.out.println(i + ". " + clients[i]);
//                        }
//                    }
//                    int client_index = Integer.parseInt(sc.nextLine());
//
//                    System.out.println("Select child:");
//                    Copil [] children = childController.getAll();
//                    for(int i=0;i<children.length;i++) {
//                        if (children[i] != null) {
//                            System.out.println(i + ". " + children[i]);
//                        }
//                    }
//                    int child_index = Integer.parseInt(sc.nextLine());
//
//                    Contract c = new Contract(denumire, pret, clients[client_index], children[child_index], pret_total, data_inc, data_sf, null);
//                    contractRepository.add(c);
//
//                    break;
//                }
//                case 9:
//                {
//                    Contract[] contracts = contractRepository.getAll();
//                    System.out.println("Select contract:");
//                    for(int i=0;i<contracts.length;i++) {
//                        if (contracts[i] != null) {
//                            System.out.println(i + ". " + contracts[i]);
//                        }
//                    }
//                    int index = Integer.parseInt(sc.nextLine());
//                    String[] methods = {"Cash", "Card"};
//                    System.out.println("1 - Cash       2 - Card");
//                    int methods_index = Integer.parseInt(sc.nextLine());
//                    contracts[index].setPlata(new Plata(methods[methods_index - 1], "Accepted", LocalDate.now()));
//                    break;
//                }
//                case 10:
//                {
//                    Contract[] contracts = contractRepository.getAll();
//                    for(int i=0;i<contracts.length;i++) {
//                        if (contracts[i] != null) {
//                            System.out.println(contracts[i].toString());
//                        }
//                    }
//
//                    break;
//                }
            }
        }
        while(Integer.parseInt(option)!=0);

    }
}