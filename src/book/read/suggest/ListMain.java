package book.read.suggest;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class ListMain extends javax.swing.JFrame {

    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    private String properties = "?useUnicode=true&characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
    private int user_id;

    public ListMain() throws MalformedURLException, IOException {
        initComponents();
        addComboBox("user_id", "users"); //ComboBox'lara sayfalama icin sayfa numaralarını yaziyor
        addComboBox("isbn", "books");
        addComboBox("user_id", "book_ratings");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        usersListele = new javax.swing.JButton();
        partusersComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        booksListele = new javax.swing.JButton();
        partbooksComboBox = new javax.swing.JComboBox<>();
        picturebookLabel = new javax.swing.JLabel();
        readButton = new javax.swing.JButton();
        suggestButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        booksratingsList = new javax.swing.JButton();
        partratingsComboBox = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        booksratingsTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        newpictureLabel = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        newbooksTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        bestbooksTable = new javax.swing.JTable();
        bestButton = new javax.swing.JButton();
        bestpictureLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        popularButton = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        popularbooksTable = new javax.swing.JTable();
        popularpictureLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User-ID", "Location", "Age", "Username", "Password"
            }
        ));
        jScrollPane2.setViewportView(usersTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        usersListele.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        usersListele.setText("List");
        usersListele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersListeleMouseClicked(evt);
            }
        });

        partusersComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(usersListele, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(231, 231, 231))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(partusersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(usersListele, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(partusersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        tab.addTab("Kullanıcılar", jPanel1);

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

        booksListele.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        booksListele.setText("List");
        booksListele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksListeleMouseClicked(evt);
            }
        });

        partbooksComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        picturebookLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        readButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        readButton.setText("Oku");
        readButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readButtonMouseClicked(evt);
            }
        });

        suggestButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        suggestButton.setText("Öneri");
        suggestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suggestButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(readButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(booksListele, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(partbooksComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suggestButton, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(picturebookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(booksListele, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(partbooksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(readButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(picturebookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(suggestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
        );

        tab.addTab("Kitaplar", jPanel3);

        booksratingsList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        booksratingsList.setText("List");
        booksratingsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksratingsListMouseClicked(evt);
            }
        });

        partratingsComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        booksratingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Marka", "Model"
            }
        ));
        jScrollPane13.setViewportView(booksratingsTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(booksratingsList, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(partratingsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(booksratingsList, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(partratingsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tab.addTab("Kitap Değerlendirme", jPanel4);

        newButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        newButton.setText("Yenile");
        newButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newButtonMouseClicked(evt);
            }
        });

        newbooksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        newbooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newbooksTableMousePressed(evt);
            }
        });
        jScrollPane17.setViewportView(newbooksTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newpictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(newpictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("Yeni Kitaplar", jPanel7);

        bestbooksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        bestbooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bestbooksTableMousePressed(evt);
            }
        });
        jScrollPane14.setViewportView(bestbooksTable);

        bestButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bestButton.setText("Yenile");
        bestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bestButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bestButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bestpictureLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(bestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bestpictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tab.addTab("En İyi Kitaplar", jPanel5);

        popularButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        popularButton.setText("Yenile");
        popularButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popularButtonMouseClicked(evt);
            }
        });

        popularbooksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        popularbooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                popularbooksTableMousePressed(evt);
            }
        });
        jScrollPane15.setViewportView(popularbooksTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(popularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(popularpictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(popularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(popularpictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane15)
                .addContainerGap())
        );

        tab.addTab("En Popüler Kitaplar", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 1408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void booksratingsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksratingsListMouseClicked
        try {
            Object[] header = {"User ID", "ISBN", "Book Rating"};
            int part = partratingsComboBox.getSelectedIndex();//ComboBox'daki degeri aliyor
            part = (part + 1) * 40;//Ornegin 2.sayfayi hesaplarken ComboBox'da degeri 1 oluyor 2*40=80 e kadar olacak 2.sayfa
            String sql = "SELECT * FROM " + "book_ratings" + " LIMIT  " + (part - 40) + ", 40";
            TableFill("booksratingsTable", header, sql, 3); //Tabloyu dolduruyor
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_booksratingsListMouseClicked

    private void readButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readButtonMouseClicked

        try {
            //Pdf okutmayi ornek olarak bir pdf yeterli oldugu icin default atadim.
            //Eger tum kitaplarin pdf dosyalari bir klasorun icerisinde olsaydi
            //Kitap ismine gore o klasorden cekip acabilirdik
            Random random = new Random();
            int pdf = 1 + random.nextInt(10);
            String defaultPdf = "C:/Users/Rıdvan/Desktop/Java Çalışma/Book-Read-Suggest/PDF/" + pdf + ".pdf";
            File myFile = new File(defaultPdf); //Pdf dosyasının yolunu belirtir
            Desktop.getDesktop().open(myFile); //Dosyası acar

        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_readButtonMouseClicked

    //Kitap Listeleme butonuna tıklayınca verileri tabloDoldur methoduna gönderiyor
    private void booksListeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksListeleMouseClicked
        try {
            Object[] header = {"ISBN", "Book Title", "Book Author", "Year Of Publication", "Publisher", "Image URL M"};
            int part = partbooksComboBox.getSelectedIndex();//ComboBox'daki degeri aliyor
            part = (part + 1) * 40;//Ornegin 2.sayfayi hesaplarken ComboBox'da degeri 1 oluyor 2*40=80 e kadar olacak 2.sayfa
            String sql = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_m FROM " + "books" + " LIMIT  " + (part - 40) + ", 40";
            TableFill("booksTable", header, sql, 6); //Tabloyu dolduruyor
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_booksListeleMouseClicked

    //Kitaplar tablosunda herhangi bir satira tiklandiginda o kitabin resmini url ile cekiyor ve ekrana basiyor
    private void booksTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMousePressed
        try {
            String urlPath = (booksTable.getValueAt(booksTable.getSelectedRow(), 5).toString()); //5. sutun yani Medium boyunu aliyor
            URL url = new URL(urlPath);
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            picturebookLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_booksTableMousePressed

    //Kullanıcı Listeleme butonuna tıklayınca verileri tabloDoldur methoduna gönderiyor
    private void usersListeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersListeleMouseClicked
        try {
            Object[] header = {"User-ID", "Location", "Age", "Username", "Password"};
            int part = partusersComboBox.getSelectedIndex();//ComboBox'daki degeri aliyor
            part = (part + 1) * 40;//Ornegin 2.sayfayi hesaplarken ComboBox'da degeri 1 oluyor 2*40=80 e kadar olacak 2.sayfa
            String sql = "SELECT * FROM " + "users" + " LIMIT  " + (part - 40) + ", 40";
            TableFill("usersTable", header, sql, 5); //Tabloyu dolduruyor

        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_usersListeleMouseClicked
//En yüksek oy ortalamasina sahip olan ilk 10 kitabı bulma methodu
    private void bestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bestButtonMouseClicked
        try {
            Object[] header = {"ISBN", "Book Title", "Book Author", "Year Of Publication", "Publisher", "Image URL M"};
            String sql = "SELECT isbn FROM `book_ratings` GROUP BY isbn ORDER BY AVG(book_rating) DESC LIMIT 0,20"; //Oy ortalamasi en yuksek ilk 10 kitap siralamasi icin SQL sorgusu
            //Veritabaninda bir tabloda olup diger tabloda bazi kitaplar olmadigi icin ilk 20 kitabi buldum. Yaklasik ilk 10 kitabı ekrana basiyor.
            //Bu SQL sorgusunda sadece 'book_ratings' tablosundan kitaplarin ISBN degerlerini buluyor

            connection connect = new connection();
            PreparedStatement pre = connect.connectionOpen(sql);
            res = pre.executeQuery(); //Sql sorgusunu calistirir

            String[] isbn = new String[20];
            int count = 0;
            while (res.next()) { //Bulunan ISBN degerlerini bir arraya atiyorum
                isbn[count] = res.getString("isbn");
                count++;
            }
            connect.connectionClose();
            sql = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_m FROM `books` WHERE isbn IN ( " + isbn[0];//Onceki sorguda bulunan kitaplarin ISBN 
            //degerlerini alip  'books' tablosundaki verilerini bulmak icin kullandim SQL sorgusu
            for (int i = 1; i < 20; i++) {
                sql = sql + " , " + isbn[i];
            }
            sql = sql + " )";
            TableFill("bestbooksTable", header, sql, 6); //Tabloyu dolduruyor
            connect.connectionClose();
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bestButtonMouseClicked
//En çok oylanan ilk 10 kitabı bulma methodu
    private void popularButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popularButtonMouseClicked
        try {
            Object[] header = {"ISBN", "Book Title", "Book Author", "Year Of Publication", "Publisher", "Image URL M"};
            String sql = "SELECT isbn , count( * ) AS counter FROM `book_ratings` GROUP BY isbn ORDER BY counter DESC LIMIT 0,11";//En cok oylanan ilk 10 kitabın sorgusu icin kullandigim
            //SQL sorgusu.  Burada da sadece ISBN degerlerini buluyor

            connection connect = new connection();
            PreparedStatement pre = connect.connectionOpen(sql);
            res = pre.executeQuery(); //Sql sorgusunu calistirir

            String[] isbn = new String[11];
            int count = 0;
            while (res.next()) {//Bulunan ISBN degerlerini bir arraya atiyorum
                isbn[count] = res.getString("isbn");
                count++;
            }
            connect.connectionClose();
            sql = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_m  FROM `books` WHERE isbn IN ( " + isbn[0];//Onceki sorguda bulunan kitaplarin ISBN 
            //degerlerini alip  'books' tablosundaki verilerini bulmak icin kullandim SQL sorgusu
            for (int i = 1; i < 11; i++) {
                sql = sql + " , " + isbn[i];
            }
            sql = sql + " )";

            TableFill("popularbooksTable", header, sql, 6); //Tabloyu dolduruyor
            connect.connectionClose();
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_popularButtonMouseClicked

//Oy ortalamasi en yuksek olan ilk 10 kitapta herhangi bir satira tiklayinca o satirdaki kitaba ait resmi verilen url den cekip labelin iconu hale getiriyor ve resim getirilmis oluyor
    private void bestbooksTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bestbooksTableMousePressed
        try {
            String urlPath = (bestbooksTable.getValueAt(bestbooksTable.getSelectedRow(), 5).toString()); //5. sutun yani Medium boyunu aliyor
            URL url = new URL(urlPath);
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            bestpictureLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bestbooksTableMousePressed
//En cok oylanan ilk 10 kitapta herhangi bir satira tiklayinca o satirdaki kitaba ait resmi verilen url den cekip labelin iconu hale getiriyor ve resim getirilmis oluyor
    private void popularbooksTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popularbooksTableMousePressed
        try {
            String urlPath = (popularbooksTable.getValueAt(popularbooksTable.getSelectedRow(), 5).toString()); //5. sutun yani Medium boyunu aliyor
            URL url = new URL(urlPath);
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            popularpictureLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_popularbooksTableMousePressed

    private void newButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newButtonMouseClicked
        try {
            Object[] header = {"ISBN", "Book Title", "Book Author", "Year Of Publication", "Publisher", "Image URL M"};
            String sql = "SELECT isbn,book_title,book_author,year_of_publication,publisher,image_url_m,new FROM books order by New desc LIMIT 5";//En yeni ilk 5 kitabın sorgusu icin kullandigim
            //SQL sorgusu.  Burada da sadece ISBN degerlerini buluyor

            TableFill("newbooksTable", header, sql, 7); //Tabloyu dolduruyor

        } catch (Exception ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newButtonMouseClicked

    private void newbooksTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newbooksTableMousePressed
        try {
            String urlPath = (newbooksTable.getValueAt(newbooksTable.getSelectedRow(), 5).toString()); //5. sutun yani Medium boyunu aliyor
            URL url = new URL(urlPath);
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            newpictureLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ListMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newbooksTableMousePressed

    private void suggestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suggestButtonMouseClicked
        Suggest suggest = new Suggest();
        suggest.setterUserID(user_id);
        suggest.setVisible(true);
    }//GEN-LAST:event_suggestButtonMouseClicked

//Her sayfaya 40 satir gelecek sekilde sayfalama yaptim. Toplam veri adedini 40'a bolup kac sayfa olacak ise 1'den o sayfaya kadar ComboBox'a yerlestirdim
    protected void addComboBox(String colomn, String table) {

        int part = 0;
        int value = 0;
        try {
            value = findvalue(colomn, table); //Tablo ve kolon ismine gore veritabanında kac deger var onu dondurur
            for (int i = 0; value >= 0; i++) {//Gelen satir sayisina gore (value degeri verilen tablodaki satir sayisi) bir algoritma kurdum.
                part = part + 1;//ComboBox'in ilk degeri 1 olacak sekilde birer artiyor
                value -= 40;//Gelen satir sayisindan surekli 40 eksilttim. 0 dan buyuk oldugu surece dongu devam edecek
                switch (table) {
                    case "users":
                        partusersComboBox.addItem(part + "");
                        break;
                    case "books":
                        partbooksComboBox.addItem(part + "");
                        break;
                    case "book_ratings":
                        partratingsComboBox.addItem(part + "");
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListMain.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int findvalue(String colomn, String table) throws Exception { //Tablo ve kolon ismine gore veritabanında kac deger var onu bulur ve dondurur
        String sql = "SELECT COUNT(" + colomn + ") FROM " + table;
        connection connect = new connection();
        PreparedStatement pre = connect.connectionOpen(sql);
        res = pre.executeQuery();
        String counter = null;
        while (res.next()) {
            counter = res.getString(1);
        }
        connect.connectionClose();
        return Integer.parseInt(counter);

    }

    //Gelen verilere göre tabloyu doldurur
    private void TableFill(String tbl, Object[] header, String sql, int counter) throws Exception {

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
            switch (tbl) {
                case "usersTable":
                    usersTable.setModel(new DefaultTableModel(veri, header));
                    break;
                case "booksTable":
                    booksTable.setModel(new DefaultTableModel(veri, header));
                    break;
                case "booksratingsTable":
                    booksratingsTable.setModel(new DefaultTableModel(veri, header));
                    break;
                case "popularbooksTable":
                    popularbooksTable.setModel(new DefaultTableModel(veri, header));
                    break;
                case "bestbooksTable":
                    bestbooksTable.setModel(new DefaultTableModel(veri, header));
                    break;
                case "newbooksTable":
                    newbooksTable.setModel(new DefaultTableModel(veri, header));
                    break;

                default:
                    break;
            }
        }
        connect.connectionClose();

    }

    public void setterUserID(int user_id) {
        this.user_id = user_id;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new Login().setVisible(true);

            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bestButton;
    private javax.swing.JTable bestbooksTable;
    private javax.swing.JLabel bestpictureLabel;
    private javax.swing.JButton booksListele;
    private javax.swing.JTable booksTable;
    private javax.swing.JButton booksratingsList;
    private javax.swing.JTable booksratingsTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newButton;
    private javax.swing.JTable newbooksTable;
    private javax.swing.JLabel newpictureLabel;
    private javax.swing.JComboBox<String> partbooksComboBox;
    private javax.swing.JComboBox<String> partratingsComboBox;
    private javax.swing.JComboBox<String> partusersComboBox;
    private javax.swing.JLabel picturebookLabel;
    private javax.swing.JButton popularButton;
    private javax.swing.JTable popularbooksTable;
    private javax.swing.JLabel popularpictureLabel;
    private javax.swing.JButton readButton;
    private javax.swing.JButton suggestButton;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JButton usersListele;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
