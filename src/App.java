import java.sql.*;
import java.util.Scanner;

public class App {
    static Scanner scanner;
    static int bookid = 30;

    public static void main(String args[]) {
        System.out.println("책 삽입, 삭제, 조회 기능이 있습니다.");
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 삽입 2 삭제 3 조회 그외 종료");
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
                    return;
            }
        }
    }

    private static void insertData() {
        scanner.nextLine();
        System.out.println("책 이름 입력");
        String name = scanner.nextLine();
        System.out.println("출판사 입력");
        String publi = scanner.nextLine();
        System.out.println("가격 입력");
        String price = scanner.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:3308/madang", "mskim", "1234");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO Book VALUE(" + bookid + ", \"" + name + "\", \"" + publi + "\", " + price + ")");
            System.out.println("입력 완료");
            bookid++;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void deleteData() {
        System.out.println("삭제 하려는 bookid를 입력하시오");
        int choice = scanner.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:3308/madang", "mskim", "1234");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Book WHERE bookid=" + choice);
            System.out.println("삭제 완료");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void searchData() {
        System.out.println("전체 book 데이터를 조회합니다.");
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