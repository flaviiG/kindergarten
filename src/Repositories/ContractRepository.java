package Repositories;

import Models.Contract;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class ContractRepository{
    private static ContractRepository INSTANCE;
    Connection conn;

    private ContractRepository(){
        try {
            String url = "jdbc:oracle:thin:system/admin@localhost:1521:xe";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection(url);

            if (conn != null) {
                System.out.println("Connected");
                this.conn = conn;
            }
            else {
                System.out.println("Not connected");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public static ContractRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ContractRepository();
        }
        return INSTANCE;
    }

//    @Override
    public boolean add(Contract entity) {

        try{
            String get_price_per_month = "SELECT pret_pe_luna FROM TIP_CONTRACT WHERE tip_contract_id = ?";
            PreparedStatement pstmnt = conn.prepareStatement(get_price_per_month);
            pstmnt.setString(1,entity.getTip_contract_id());
            ResultSet rs = pstmnt.executeQuery();
            rs.next();
            int price_per_month = rs.getInt(1);
            pstmnt.close();
            String insert = "INSERT INTO CONTRACT VALUES (?,?,?,?,?,?)";
            pstmnt = conn.prepareStatement(insert);
            pstmnt.setInt(1,entity.getId_contract());
            pstmnt.setString(2,entity.getTip_contract_id());
            pstmnt.setInt(3,entity.getId_client());

            Period period = Period.between(entity.getData_incepere_contract(), entity.getData_sfarsit_contract());
            long months = period.toTotalMonths();
            float total_price = (int)months*price_per_month;

            pstmnt.setFloat(4,total_price);
            pstmnt.setDate(5,Date.valueOf(entity.getData_incepere_contract()));
            pstmnt.setDate(6,Date.valueOf(entity.getData_sfarsit_contract()));

            pstmnt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

//    @Override
    public HashMap<String,SortedSet<Contract>> getAll() {
        try {
            Comparator<Contract> conditie = (o1, o2) -> o1.compareTo(o2);
            HashMap<String, SortedSet<Contract>> contracts = new HashMap<String,SortedSet<Contract>>();
            SortedSet<Contract> semi = new TreeSet<Contract>(conditie);
            SortedSet<Contract> full = new TreeSet<Contract>(conditie);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM CONTRACT WHERE tip_contract_id = 'S3' ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Contract c = new Contract(rs.getString(2),rs.getInt(3), rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(), rs.getInt(4));
                c.setId_contract(rs.getInt(1));
                semi.add(new Contract(c));
            }
            rs.close();
            stmt.close();
            stmt = conn.createStatement();
            sql = "SELECT * FROM CONTRACT WHERE tip_contract_id = 'F3' ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Contract c = new Contract(rs.getString(2),rs.getInt(3), rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(), rs.getInt(4));
                c.setId_contract(rs.getInt(1));
                full.add(new Contract(c));
            }
            contracts.put("Program Semi", semi);
            contracts.put("Program Full", full);
            return contracts;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }

    }

//    @Override
    public boolean update(String id, Contract entity) {
        try{
            String sql = "UPDATE CONTRACT SET tip_contract_id = ? , id_client = ?, pret = ? , data_incepere_contract = ? , data_sfarsit_contract = ? WHERE id_contract = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);

            pstmnt.setString(1,entity.getTip_contract_id());
            pstmnt.setInt(2,entity.getId_client());
            pstmnt.setFloat(3,entity.getPret_total());
            pstmnt.setDate(4,Date.valueOf(entity.getData_incepere_contract()));
            pstmnt.setDate(5,Date.valueOf(entity.getData_sfarsit_contract()));
            int int_id=Integer.parseInt(id);
            pstmnt.setInt(6,int_id);

            pstmnt.executeUpdate();
            return true;

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }

//    @Override
    public boolean delete(String id) {
        try{
            String sql = "DELETE FROM CONTRACT WHERE id_contract = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);
            int int_id=Integer.parseInt(id);
            pstmnt.setInt(1,int_id);
            pstmnt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }

}
