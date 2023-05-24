import Controllers.*;
import Models.*;
import Utils.Operations_Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

                            if(clientController.add(c) == true)
                            {
                                Operations_Logger.logOperation("Client adaugat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Client adaugat", "nu");
                            }

                            break;
                        }
                        case 2:
                        {
                            clientController.getAll();
                            Operations_Logger.logOperation("Clienti afisati", "da");


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


                            if(clientController.update(id, c) == true)
                            {
                                Operations_Logger.logOperation("Client updatat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Clienti updatat", "nu");
                            }
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Client id that you want to delete: ");
                            String id = sc.nextLine();


                            if(clientController.delete(id) == true)
                            {
                                Operations_Logger.logOperation("Client sters", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Clienti sters", "nu");
                            }
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


                            if(childController.add(c) == true)
                            {
                                Operations_Logger.logOperation("Copil adaugat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Copil adaugat", "nu");
                            }
                            break;
                        }

                        case 2:
                        {
                            childController.getAll();
                            Operations_Logger.logOperation("Copii afisati", "da");

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


                            if(childController.update(id, c) == true)
                            {
                                Operations_Logger.logOperation("Copil updatat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Copil updatat", "nu");
                            }

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Child id that you want to delete: ");
                            String id = sc.nextLine();

                            if(childController.delete(id) == true)
                            {
                                Operations_Logger.logOperation("Copil sters", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Copil sters", "nu");
                            }
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

                            if(educatorController.add(e) == true)
                            {
                                Operations_Logger.logOperation("Educator adaugat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Educator adaugat", "nu");
                            }

                            break;
                        }

                        case 2:
                        {
                            educatorController.getAll();
                            Operations_Logger.logOperation("Educatori afisati", "da");

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

                            if(educatorController.update(id, e) == true)
                            {
                                Operations_Logger.logOperation("Educator updatat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Educator updatat", "nu");
                            }

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Educator id that you want to delete: ");
                            String id = sc.nextLine();


                            if(educatorController.delete(id) == true)
                            {
                                Operations_Logger.logOperation("Educator sters", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Educator sters", "nu");
                            }
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


                            if(contractController.add(c) == true)
                            {
                                Operations_Logger.logOperation("Contract adaugat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Contract adaugat", "nu");
                            }
                            break;
                        }

                        case 2:
                        {
                            contractController.getAll();
                            Operations_Logger.logOperation("Contracte afisate", "da");

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


                            if(contractController.update(id, c) == true)
                            {
                                Operations_Logger.logOperation("Contract updatat", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Contract updatat", "nu");
                            }

                            break;
                        }
                        case 4:
                        {
                            System.out.println("Select the Contract id that you want to delete: ");
                            String id = sc.nextLine();


                            if(contractController.delete(id) == true)
                            {
                                Operations_Logger.logOperation("Contract sters", "da");
                            }
                            else
                            {
                                Operations_Logger.logOperation("Contract sters", "nu");
                            }
                            break;
                        }
                    }
                    break;

                }

//                case 5:
//                {
//                    clientController.getAll();
//                    break;
//                }
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
//
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

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("logs.txt"));
//            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.csv"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] fields = line.split("\\s+"); // Split by whitespace (adjust as per your TXT format)
//                String csvLine = String.join(",", fields); // Join fields with comma as CSV format
//                writer.write(csvLine);
//                writer.newLine();
//                System.out.println("Conversion completed successfully.");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        option=sc.nextLine();

    }
}