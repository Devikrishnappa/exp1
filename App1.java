import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
       Scanner sc=new Scanner(System.in);
      

       int str=sc.nextInt();
        DbConnector db=new DbConnector();
       //d.create();
      

     if(str==1){
         int id=sc.nextInt();
       String name=sc.next();
       String address=sc.next();
       String source=sc.next();
       String destination=sc.next();
       String phone_no=sc.next();
         db.insertVar2(id,name,address,source,destination,phone_no);

     }
     else if(str==2){
        int id=sc.nextInt();
        String name=sc.next();
        String address=sc.next();
        String source=sc.next();
        String destination=sc.next();
        String phone_no=sc.next();
                db.updatedate(id,name,address,source,destination,phone_no);

     }
     else if(str==3){
        int id=sc.nextInt();
        db.deletedate(id);
     }
     else{
        db.readData();
     }
    }



}
