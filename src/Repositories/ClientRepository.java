package Repositories;

import Models.Client;

import java.sql.*;

public class ClientRepository implements CRUDRepository<Client> {

    private static ClientRepository INSTANCE;
    Connection conn;

    private ClientRepository(){
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

    public static ClientRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ClientRepository();
        }
        return INSTANCE;
    }

    @Override
    public boolean add(Client entity) {

        try{

            String insert = "INSERT INTO CLIENT VALUES (?,?,?,?,?,?)";
            PreparedStatement pstmnt = conn.prepareStatement(insert);
            pstmnt.setInt(1,entity.getId());
            pstmnt.setString(2,entity.getNume());
            pstmnt.setString(3,entity.getPrenume());
            pstmnt.setString(4,entity.getTelefon());
            pstmnt.setString(5,entity.getEmail());
            pstmnt.setString(6,entity.getAdresa());

            return pstmnt.execute();
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Client[] getAll() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM CLIENT";
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
    public boolean update(String id, Client entity) {
        try{
            String sql = "UPDATE CLIENT SET nume = ? , prenume = ?, telefon = ? , email = ? , adresa = ? WHERE id_client = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);

            pstmnt.setString(1,entity.getNume());
            pstmnt.setString(2,entity.getPrenume());
            pstmnt.setString(3,entity.getTelefon());
            pstmnt.setString(4,entity.getEmail());
            pstmnt.setString(5,entity.getAdresa());
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

    @Override
    public boolean delete(String id) {
        try{
            String sql = "DELETE FROM CLIENT WHERE id_client = ?";
            PreparedStatement pstmnt = conn.prepareStatement(sql);
            int int_id=Integer.parseInt(id);
            pstmnt.setInt(6,int_id);
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
