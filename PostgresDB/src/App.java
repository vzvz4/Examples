import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=178ueee34&ssl=false";

        Connection conn = DriverManager.getConnection(url);
        System.out.println("Connected");
        Statement st = conn.createStatement();

//        PreparedStatement ps = conn.prepareStatement("INSERT INTO public.\"Books\" (id, Name) values (?,?)");
//        for (int i = 5; i < 10; i++) {
//            ps.setInt(1, i);
//            ps.setString(2, i+" Client");
//            int a = ps.executeUpdate();
//            System.out.println(a);
//        }

        Statement res = conn.createStatement();
        ResultSet rs = res.executeQuery("select * from test.\"phones\"");


        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("phone"));
        }

        conn.close();
        rs.close();
        st.close();
        res.close();
    }
}
