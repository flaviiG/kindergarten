package Repositories;

import Models.Educator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducatorRepository {
    private static EducatorRepository INSTANCE;
    Connection conn;

    private EducatorRepository(){
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

    public static EducatorRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EducatorRepository();
        }
        return INSTANCE;
    }

//    @Override
    public boolean add(Educator entity) {

        try{

            String insert = "INSERT INTO EDUCATOR VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmnt = conn.prepareStatement(insert);
            pstmnt.setInt(1,entity.getId());
            pstmnt.setString(2,entity.getNume());
            pstmnt.setString(3,entity.getPrenume());
            pstmnt.setString(4,entity.getTelefon());
            pstmnt.setString(5,entity.getAdresa());
            pstmnt.setString(6,entity.getEmail());
            pstmnt.setInt(7,entity.getSalariu());

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
    public List<Educator> getAll() {
        try {
            List<Educator> educators = new ArrayList<Educator>();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM EDUCATOR";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                Educator e = new Educator(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(5), rs.getInt(7));
                e.setId(rs.getInt(1));
                educators.add(new Educator(e));
            }
            return educators;

        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

//    @Override
    public boolean update(String id, Educator entity) {
        try{
            String sql = "UPDATE EDUCATOR SET nume = ? , prenume = ?, telefon = ? , email = ? , adresa = ?, salariu = ? WHERE id_educator = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);

            pstmnt.setString(1,entity.getNume());
            pstmnt.setString(2,entity.getPrenume());
            pstmnt.setString(3,entity.getTelefon());
            pstmnt.setString(4,entity.getEmail());
            pstmnt.setString(5,entity.getAdresa());
            pstmnt.setInt(6, entity.getSalariu());
            int int_id=Integer.parseInt(id);
            pstmnt.setInt(7,int_id);

            pstmnt.executeUpdate();
            return true;

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }

    }

 //   @Override
    public boolean delete(String id) {
        try{
            String sql = "DELETE FROM EDUCATOR WHERE id_educator = ?";
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
