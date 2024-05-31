import java.sql.*;
import java.util.*;
public class DbConnector {

    public static void insertVar2(int id,String name,String address,String source,String destination,String phone_no) throws Exception{
        String url="jdbc:mysql://localhost:3306/busmanage";
        String userName="root";
        String Password="Devi@2004";
      

        String query="insert into bus values(?,?,?,?,?,?)";

        Connection con=DriverManager.getConnection(url,userName,Password);
      
      PreparedStatement pst = con.prepareStatement(query);
    pst.setInt(1, id);
    pst.setString(2, name);
    pst.setString(3, address);
    pst.setString(4, source);
    pst.setString(5, destination);

    pst.setString(6, phone_no);

    pst.executeUpdate();
     
      con.close();

    }
    public static void readData() throws Exception{
        String url="jdbc:mysql://localhost:3306/busmanage";
        String userName="root";
        String Password="Devi@2004";
        String query="select *from bus";
 
    Connection con=DriverManager.getConnection(url,userName,Password);
    Statement st=con.createStatement();
    ResultSet rt= st.executeQuery(query);
    while(rt.next()){

    System.out.println("id: "+rt.getInt(1));
    System.out.println("name: "+rt.getString(2));
    System.out.println("address: "+rt.getString(3));
    System.out.println("source: "+rt.getString(4));
    System.out.println("destination: "+rt.getString(5));
    System.out.println("phone_no: "+rt.getString(6));


    }
}
public static void updatedate(int id,String name,String address,String source,String destination,String phone_no) throws Exception{
    String url="jdbc:mysql://localhost:3306/busmanage";
    String userName="root";
    String Password="Devi@2004";

    String query="update bus set name=?,address=?,source=?,destination=?,phone_no=? where id=?";

    Connection con=DriverManager.getConnection(url,userName,Password);
    PreparedStatement pst=con.prepareStatement(query);
   pst.setInt(6, id);
   pst.setString(1,name );
   pst.setString(2,address );
   pst.setString(3,source );
   pst.setString(4,destination );
   pst.setString(5,phone_no);



pst.executeUpdate();
  }
  
  public static void deletedate(int id) throws Exception{
    String url="jdbc:mysql://localhost:3306/busmanage";
    String userName="root";
    String Password="Devi@2004";

    String query="delete from bus where id=?";
   
    Connection con=DriverManager.getConnection(url,userName,Password);
    PreparedStatement pst=con.prepareStatement(query);
  pst.setInt(1, id);

pst.executeUpdate();
  }

}
//CREATE TABLE Vehicles (
    VehicleID INT AUTO_INCREMENT PRIMARY KEY,
    Make VARCHAR(50) NOT NULL,
    Model VARCHAR(50) NOT NULL,
    Year INT NOT NULL,
    Type VARCHAR(20),
    VIN VARCHAR(17) UNIQUE NOT NULL,
    OwnerID INT,
    RegistrationDate DATE,
    LastServiceDate DATE,
    FOREIGN KEY (OwnerID) REFERENCES Owners(OwnerID)
);
