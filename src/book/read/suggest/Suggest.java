package book.read.suggest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Suggest extends javax.swing.JFrame {

    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    private int user_id;

    public Suggest() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suggestButton = new javax.swing.JButton();
        suggestpictureLabel = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        suggestbooksTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        suggestButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        suggestButton.setText("Yenile");
        suggestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suggestButtonMouseClicked(evt);
            }
        });

        suggestbooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Book-Title", "Book-Author", "Year-Of-Publication", "Publisher", "Image-URL-M	"
            }
        ));
        suggestbooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                suggestbooksTableMousePressed(evt);
            }
        });
        jScrollPane18.setViewportView(suggestbooksTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suggestpictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(suggestButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(108, 108, 108)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(suggestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(suggestpictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suggestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suggestButtonMouseClicked
        try {

            //1-Ilk once giris yapan kullanicinin kitaplarinin isbn degerlerini buldum
            //2-Bulunan isbn degerlerine oy vermis diger kullanicilarin id degerlerini buldum
            //3-Bulununan kullanicilara default hepsine 0 atadim
            //4-Giris yapan kullaniciyla ortak en fazla kitabi oylayan kullaniciyi bulup onun kitaplarini oneri olarak gosterdim
            Object[] header = {"ISBN", "Book Title", "Book Author", "Year Of Publication", "Publisher", "Image URL M"};
            String sql = "SELECT isbn FROM book_ratings WHERE user_id=" + user_id; //Giriş yapan kullanıcının oyladığı kitapları bulmak için sql kodu
            //isbn değerlerini döndürüyor

            connection connect = new connection();
            PreparedStatement pre = connect.connectionOpen(sql);
            res = pre.executeQuery(); //Sql sorgusunu calistirir

            String[] isbn = new String[500000];
            int count = 0;
            while (res.next()) { //Bulunan ISBN degerlerini bir arraya atiyorum
                isbn[count] = res.getString(1);
                count++;
            }
            connect.connectionClose();

            sql = "SELECT user_id FROM book_ratings WHERE user_id!=" + user_id + " AND isbn IN ( " + isbn[0];//Giriş yapan kullanıcının kitaplarına oylama yapan kullanıcıları döndürüyor
            for (int i = 1; i < count; i++) {
                sql = sql + " , " + isbn[i];
            }
            sql = sql + " )";

            connect = new connection();
            pre = connect.connectionOpen(sql);
            res = pre.executeQuery(); //Sql sorgusunu calistirir
            String[] user = new String[100000];
            count = 0;
            while (res.next()) { //Bulunan user id degerlerini bir arraya atiyorum
                user[count] = res.getString(1);
                count++;
            }
            user[count] = "control";

            String users[][] = FindUsers(); //Books_rating tablosundaki bulunan tum kullanicilarin user id degerleri

            for (int i = 0; !users[i][0].equals("control"); i++) {

                for (int j = 0; !user[j].equals("control"); j++) {
                    if (users[i][0].equals(user[j])) {
                        users[i][1] = "" + (Integer.parseInt(users[i][1]) + 1);
                        //            System.out.print(i + " " + users[i][0] + " " + users[i][1] + "\n");
                    }
                }
            }

            int max[] = FindMax(users);//Ortak oylanan kitaplardan en fazla hangi kullaniciyla ortak oylama yapilmis o degeri buluyor

        //    System.out.println(max[0] + " Tane ortak kitap vardir");//Ilk indis kac ortak kitap oylanmis
            //max[1] Ikinci indis ise users arrayindeki indis sayisini gosteriyor

            sql = "SELECT isbn FROM book_ratings WHERE user_id=" + users[max[1]][0];
            //isbn değerlerini döndürüyor

            connect = new connection();
            pre = connect.connectionOpen(sql);
            res = pre.executeQuery(); //Sql sorgusunu calistirir

            isbn = new String[500000];
            count = 0;
            while (res.next()) { //Bulunan ISBN degerlerini bir arraya atiyorum
                isbn[count] = res.getString(1);
                count++;
            }

            sql = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_m FROM books WHERE isbn IN ( '" + isbn[0];
            for (int i = 1; i < count; i++) {
                sql = sql + "' , '" + isbn[i];
            }
            sql = sql + "') LIMIT 40";

            connect.connectionClose();

            TableFill("suggestbooksTable", header, sql, 6); //Tabloyu dolduruyor
            connect.connectionClose();
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suggestButtonMouseClicked

    public void TableFill(String tbl, Object[] header, String sql, int counter) throws SQLException, Exception {

        Object[][] veri;
        connection connect = new connection();
        PreparedStatement pre = connect.connectionOpen(sql);

        try (ResultSet set = pre.executeQuery()) {
            int count = 0;
            set.last();
            count = set.getRow();
            veri = new Object[count][counter];
            set.first();
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < counter; j++) {
                    veri[i][j] = set.getObject(j + 1);
                }
                set.next();
            }
            suggestbooksTable.setModel(new DefaultTableModel(veri, header));
        }
        connect.connectionClose();
    }

    public String[][] FindUsers() throws Exception {

        String[][] users = new String[19000000][2];
        String sql = "SELECT DISTINCT user_id FROM book_ratings";

        connection connect = new connection();
        PreparedStatement pre = connect.connectionOpen(sql);
        res = pre.executeQuery(); //Sql sorgusunu calistirir
        int count = 0;
        while (res.next()) {//Kullanicinin id'sini degiskene atiyor
            users[count][0] = res.getString("user_id");
            users[count][1] = "0";
            count++;
        }
        users[count][0] = "control";

        return users;
    }

    public int[] FindMax(String array[][]) {

        int[] max = new int[19000000];
        max[0] = Integer.parseInt(array[0][1]);

        for (int i = 1; !array[i + 1][0].equals("control"); i++) {
            if (Integer.parseInt(array[i][1]) > max[0]) {
                max[0] = Integer.parseInt(array[i][1]);
                max[1] = i;
            }
        }

        return max;
    }

    private void suggestbooksTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suggestbooksTableMousePressed
        try {
            String urlPath = (suggestbooksTable.getValueAt(suggestbooksTable.getSelectedRow(), 5).toString()); //5. sutun yani Medium boyunu aliyor
            URL url = new URL(urlPath);
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            suggestpictureLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suggestbooksTableMousePressed
//Her sayfaya 40 satir gelecek sekilde sayfalama yaptim. Toplam veri adedini 40'a bolup kac sayfa olacak ise 1'den o sayfaya kadar ComboBox'a yerlestirdim

    public void setterUserID(int user_id) {
        this.user_id = user_id;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suggest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suggest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JButton suggestButton;
    private javax.swing.JTable suggestbooksTable;
    private javax.swing.JLabel suggestpictureLabel;
    // End of variables declaration//GEN-END:variables
}
