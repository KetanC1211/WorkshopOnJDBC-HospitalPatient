import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBoperation {
    static Connection con;
    static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

    static List<PatientDetails> pList = new ArrayList<PatientDetails>();

    public static void readFromDB() {
        boolean f = false;
        try {
            con = ConnectionProvider.createC();
            String q = "select * from patient";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phoneNumber = set.getString(3);
                String Address = set.getString(4);
                String email = set.getString(5);
                int billAmount = set.getInt(6);
                PatientDetails pObj = new PatientDetails(name, phoneNumber, Address, email, billAmount);
                pList.add(pObj);
            }
            //Print DB
            System.out.println(pList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoDB() {
        boolean t = false;
        try {
            System.out.println("Enter name");
            String name = br.readLine();
            System.out.println("Enter phoneNumber");
            String phoneNumber = br.readLine();
            System.out.println("Enter address");
            String Address= br.readLine();
            System.out.println("Enter email");
            String email=br.readLine();
            System.out.println("Enter billAmount");
            int billAmount = Integer.parseInt(br.readLine());

            PatientDetails pObj = new PatientDetails(name, phoneNumber, Address, email, billAmount);
            pList.add(pObj);

            System.out.println("+++++++++++++++++++");

            con = ConnectionProvider.createC();
            String q = "insert into patient(name,phoneNumber,address,email,billAmount) values(?,?,?,?,?);";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, phoneNumber);
            pstmt.setString(3, Address);
            pstmt.setString(4, email);
            pstmt.setInt(5, billAmount);

            //execute
            pstmt.executeUpdate();
            System.out.println("Added successfully");
            t = true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        if (t != true) {
            System.out.println("Something went wrong");
        }
    }
}
