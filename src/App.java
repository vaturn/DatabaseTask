import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        System.out.println("책 삽입, 삭제, 조회 기능이 있습니다.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 삽입 2 삭제 3 조회");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertData();
                    break;
                case 2:
                    deleteData();
                    break;
                case 3:
                    searchData();
                    break;
                default:
                    break;
            }
        }
    }

    private static void insertData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:3308/madang", "mskim", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) +
                        " " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void deleteData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:3308/madang", "mskim", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) +
                        " " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void searchData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:3308/madang", "mskim", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) +
                        " " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}