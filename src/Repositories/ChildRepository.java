package Repositories;

import Models.Copil;

import java.sql.*;

public class ChildRepository implements CRUDRepository<Copil> {

    private static ChildRepository INSTANCE;
    Connection conn;

    private ChildRepository(){
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

    public static ChildRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChildRepository();
        }
        return INSTANCE;
    }

    @Override
    public boolean add(Copil entity) {

        try{

            String insert = "INSERT INTO COPIL VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmnt = conn.prepareStatement(insert);
            pstmnt.setString(1,entity.getId());
            pstmnt.setInt(2,entity.getId_contract());
            pstmnt.setInt(3,entity.getId_educator());
            pstmnt.setString(4,entity.getId_grupa());
            pstmnt.setString(5,entity.getNume());
            pstmnt.setString(6,entity.getPrenume());
            pstmnt.setDate(7,Date.valueOf(entity.getData_nastere()));

            pstmnt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Copil[] getAll() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM COPIL";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " ");
                }
                System.out.println("");
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean update(String id, Copil entity) {
        try{
            String sql = "UPDATE COPIL SET nume = ? , prenume = ?, data_nastere = ? WHERE id_copil = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);

            pstmnt.setString(1,entity.getNume());
            pstmnt.setString(2,entity.getPrenume());
            pstmnt.setDate(3,Date.valueOf(entity.getData_nastere()));
            pstmnt.setString(4,id);

            pstmnt.executeUpdate();
            return true;

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }

    }

    @Override
    public boolean delete(String id) {
        try{
            String sql = "DELETE FROM COPIL WHERE id_copil = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);
            pstmnt.setString(1,id);
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
