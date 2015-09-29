package meiqin520;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbhelper {

	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=test1";
	Connection con = null;
    ResultSet res = null;
    String userName="sa";

	String userPwd="12345678";
    public void DataBase() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("���ӳɹ�");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
              System.err.println("װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("�޷��������ݿ�" ); 
            e.printStackTrace();
        }
}
    public ResultSet  Search(String sql, String str[]) {
        DataBase();
        try {
            PreparedStatement pst =con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
    public int AddU(String sql, String str[]) {
        int a = 0;
        DataBase();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            a = pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }

}
