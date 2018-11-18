package book.read.suggest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RatingBook extends javax.swing.JFrame {

    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    private Connection conn = null; //Bağlantı nesnemiz
    private String properties = "?useUnicode=true&characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
    private String user_id ;
    private int counter = 0;
    private String username, password, location, age, authority;
    private int count = 0;
    private String[] isbn_array = new String[50];

    public RatingBook() throws IOException {
        initComponents();
        addComboBox("isbn", "books");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        booksList = new javax.swing.JButton();
        partbooksComboBox = new javax.swing.JComboBox<>();
        picturebookLabel = new javax.swing.JLabel();
        ratingComboBox = new javax.swing.JComboBox<>();
        ratingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                booksTableMousePressed(evt);
            }
        });
        jScrollPane12.setViewportView(booksTable);

        booksList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        booksList.setText("List");
        booksList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksListMouseClicked(evt);
            }
        });

        partbooksComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        picturebookLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        ratingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        ratingButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ratingButton.setText("Oyla");
        ratingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ratingButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picturebookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partbooksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(booksList, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ratingButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(ratingComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(booksList, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(partbooksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(picturebookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(ratingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(ratingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void booksTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMousePressed
        try {
            String urlPath = (booksTable.getValueAt(booksTable.getSelectedRow(), 5).toString()); //6. sutun yani Medium boyunu aliyor
            URL url = new URL(urlPath);
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            picturebookLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_booksTableMousePressed

    private void booksListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksListMouseClicked
        try {
            Object[] header = {"ISBN", "Book Title", "Book Author", "Year Of Publication", "Publisher", "Image URL M"};
            int part = partbooksComboBox.getSelectedIndex();//ComboBox'daki degeri aliyor 
            part = (part + 1) * 40;//Ornegin 2.sayfayi hesaplarken ComboBox'da degeri 1 oluyor 2*40=80 e kadar olacak 2.sayfa 
            TableFill("books", header, 6, part);
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_booksListMouseClicked

    private void ratingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingButtonMouseClicked

        try {
            int rating = ratingComboBox.getSelectedIndex();
            String isbn = (booksTable.getValueAt(booksTable.getSelectedRow(), 0).toString()); //1. sutun yani isbn degerini aliyor

            isbn_array[count] = isbn;

            this.count++;
            int control;

            if (count - 1 == 0) {
                control = 1;
            } else {
                control = AgainControl(isbn_array, isbn);
            }

            if (control == 1) {
                String sql = "INSERT INTO book_ratings (user_id, isbn, book_rating) VALUES (?,?,?)";
                connection connect = new connection();
                PreparedStatement pre = connect.connectionOpen(sql);
                pre.setString(1, user_id);
                pre.setString(2, isbn);
                pre.setString(3, rating + "");
                pre.executeUpdate(); //sorguyu çalıştır
                connect.connectionClose();
                counter++;//Her oy kullandigimizda sayaci 1 arttiriyoruz
                if (counter >= 10) {
                    JOptionPane.showConfirmDialog(null, "En az 10 Oy Başarıyla Oy Kullanıldı Giriş Yapabilirsiniz", "Rating Table", JOptionPane.PLAIN_MESSAGE);
                    Register save = new Register();
                    save.RegisterData(username, password, user_id, location, age, authority);//10 oy kullaninca kayit islemini yapiyoruz
                }
                JOptionPane.showConfirmDialog(null, "Başarıyla Oy Kullanıldı ", "Rating Table", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(null, "Farklı Kitabı Deneyiniz ", "Rating Table", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (Exception ex) {
            Logger.getLogger(RatingBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ratingButtonMouseClicked
    private void addComboBox(String colomn, String table) {

        int part = 0;
        int value = 0;
        try {
            ListMain list = new ListMain();
            value = list.findvalue(colomn, table); //Tablo ve kolon ismine gore veritabanında kac deger var onu dondurur
            for (int i = 0; value >= 0; i++) {
                part = part + 1;
                value -= 40;
                partbooksComboBox.addItem(part + "");
            }
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int AgainControl(String[] isbn_array, String isbn) {

        for (int i = 0; i < count - 1; i++) {
            if (isbn_array[i].equals(isbn)) {
                return 0;
            }
        }

        return 1;

    }

    public void setValues(String username, String password, String location, String age, String authority) {//Kayiti bu sinifta yapabilmemiz icin verileri alip sakliyoruz
        this.username = username;
        this.password = password;
        this.location = location;
        this.age = age;
        this.username = username;
        this.authority = authority;
    }

    public void setterUserID(String id) {
        this.user_id = id;
    }

    public int getterCounter() {
        return counter;
    }

    //Gelen verilere göre tabloyu doldurur
    private void TableFill(String tbl, Object[] header, int counter, int part) throws Exception {

        Object[][] veri;
        String sql = "SELECT  isbn,book_title,book_author,year_of_publication,publisher,image_url_m  FROM " + tbl + " LIMIT  " + (part - 40) + ", 40";
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

                booksTable.setModel(new DefaultTableModel(veri, header));
            }
            connect.connectionClose();

        }
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
            java.util.logging.Logger.getLogger(RatingBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RatingBook().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(RatingBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton booksList;
    private javax.swing.JTable booksTable;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JComboBox<String> partbooksComboBox;
    private javax.swing.JLabel picturebookLabel;
    private javax.swing.JButton ratingButton;
    private javax.swing.JComboBox<String> ratingComboBox;
    // End of variables declaration//GEN-END:variables
}
