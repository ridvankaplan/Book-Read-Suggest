package book.read.suggest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connection {

    private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "bx"; //veritabanının ismi
    private String properties = "?useUnicode=true&characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
    private String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak

    public PreparedStatement connectionOpen(String sql) throws Exception {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName, userName, password);//bağlantı açılıyor
        return conn.prepareStatement(sql); //sorguya uygun hazır ifadeyi döndür
    }

    public void connectionClose() throws SQLException {
        conn.close();
    }
}
