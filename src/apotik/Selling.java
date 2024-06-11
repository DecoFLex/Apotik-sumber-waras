package apotik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Selling extends javax.swing.JFrame {

    public Selling() {
        initComponents();
        GetAllMedicines();
        ShowDate();
        tbtnMedicine.setSelected(false);
        tbtnCompany.setSelected(false);
        tbtnAgents.setSelected(false);
        tbtnSelling.setSelected(true);
    }
    
     public void ShowDate()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lblDate.setText(sdf.format(date));
    }
    
   

    /* Connection with db*/
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfMedQty = new javax.swing.JTextField();
        tfMedName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taBill = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        MedicineTable = new javax.swing.JTable();
        lblDate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        tbtnAgents = new javax.swing.JToggleButton();
        tbtnSelling = new javax.swing.JToggleButton();
        tbtnMedicine = new javax.swing.JToggleButton();
        tbtnCompany = new javax.swing.JToggleButton();
        btnAddBill = new javax.swing.JButton();
        btnPrintBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfMedQty.setBorder(null);
        getContentPane().add(tfMedQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 150, 30));

        tfMedName.setBorder(null);
        getContentPane().add(tfMedName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 140, 30));

        taBill.setColumns(20);
        taBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        taBill.setRows(5);
        jScrollPane1.setViewportView(taBill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 560, 170));

        MedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MEDNAME", "PRICE", "QUANTITY", "FABDATE", "EXPDATE", "COMPANY"
            }
        ));
        MedicineTable.setRowHeight(25);
        MedicineTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        MedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicineTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MedicineTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 440, 150));

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(102, 102, 102));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("dd-MM-yyyy");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/PENJUALAN.png"))); // NOI18N
        jLabel14.setText("Tanggal :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

        tbtnAgents.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnAgents.setText("Karyawan");
        tbtnAgents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnAgents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnAgentsMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnAgents, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 360, 130, 50));

        tbtnSelling.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnSelling.setText("Penjualan");
        tbtnSelling.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnSelling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnSellingMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnSelling, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 100, 150, 60));

        tbtnMedicine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnMedicine.setText("Stok Obat");
        tbtnMedicine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnMedicineMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 189, 150, 50));

        tbtnCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnCompany.setText("Perusahaan");
        tbtnCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnCompanyMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 60));

        btnAddBill.setBackground(new java.awt.Color(204, 204, 204));
        btnAddBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddBill.setForeground(new java.awt.Color(102, 102, 102));
        btnAddBill.setText("Tambah");
        btnAddBill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddBillMouseClicked(evt);
            }
        });
        getContentPane().add(btnAddBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 279, 120, 50));

        btnPrintBill.setBackground(new java.awt.Color(204, 204, 204));
        btnPrintBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPrintBill.setForeground(new java.awt.Color(102, 102, 102));
        btnPrintBill.setText("Cetak");
        btnPrintBill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrintBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(843, 460, 110, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void GetAllMedicines()
              
    {
        
        try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             System.out.println("Registro exitoso");
          } catch (Exception e) {
             System.out.println(e.toString());
          }
        
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
           st = conn.createStatement();
           rs = st.executeQuery("Select * from apotik.medicines");
           MedicineTable.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public void UpdateQty()
    {
        
        try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             System.out.println("Registro exitoso");
          } catch (Exception e) {
             System.out.println(e.toString());
          }
        
        
        int newQty;
        newQty = oldQty - Integer.valueOf(tfMedQty.getText());
        System.out.println(newQty);
        
        try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
//                String id = tbBillId.getText();
                System.out.println(medId);
                String queryUpdate = "Update apotik.medicines set quantity = " + newQty + " " + "where id = " + medId;
                Statement st = conn.createStatement();
                st.executeUpdate(queryUpdate);
                System.out.println(queryUpdate);
                
                GetAllMedicines();
                JOptionPane.showMessageDialog(this, "Quantity of medicine Successfully Updated!");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
    }
    
    int i = 0, medId, oldQty;
    double price;
    
    private void MedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineTableMouseClicked

        DefaultTableModel model = (DefaultTableModel)MedicineTable.getModel();
        int myIndex = MedicineTable.getSelectedRow();
        medId = Integer.valueOf(model.getValueAt(myIndex, 0).toString());
        tfMedName.setText(model.getValueAt(myIndex, 1).toString());
        oldQty = Integer.valueOf(model.getValueAt(myIndex, 2).toString());
        price = Double.valueOf(model.getValueAt(myIndex, 6).toString());
    }//GEN-LAST:event_MedicineTableMouseClicked

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed
        try {
            taBill.print();
            
        } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void tbtnSellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnSellingMouseClicked
        tbtnSelling.setSelected(true);
    }//GEN-LAST:event_tbtnSellingMouseClicked

    private void tbtnMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnMedicineMouseClicked
        new Medicine().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnMedicineMouseClicked

    private void tbtnCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnCompanyMouseClicked
        new Company().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnCompanyMouseClicked

    private void tbtnAgentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnAgentsMouseClicked
        new Agents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnAgentsMouseClicked

    private void btnAddBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBillMouseClicked
        if (tfMedName.getText().isEmpty() || tfMedQty.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Missing Information about Bill");
        }
        else
        {
           i++;
           UpdateQty();
           if (i == 1) 
           {
               taBill.setText(taBill.getText()+"                 ********************************Apotik Sumber Waras********************************\n\n  "
                                   + "\t      ID     NAMA OBAT   BANYAKNYA   Harga         TOTAL\n\t"
                                   + "      "+i+"        "+tfMedName.getText()+"         "+tfMedQty.getText()+"               "+price+"      "+ Integer.valueOf(tfMedQty.getText())*price);
           }
           else
           {
               taBill.setText(taBill.getText()+"\n  \t      "+i+"        "+tfMedName.getText()+"        "+tfMedQty.getText()+"          "+price+"        "+ Integer.valueOf(tfMedQty.getText())*price);
           }
        }
    }//GEN-LAST:event_btnAddBillMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MedicineTable;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAddBill;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTextArea taBill;
    private javax.swing.JToggleButton tbtnAgents;
    private javax.swing.JToggleButton tbtnCompany;
    private javax.swing.JToggleButton tbtnMedicine;
    private javax.swing.JToggleButton tbtnSelling;
    private javax.swing.JTextField tfMedName;
    private javax.swing.JTextField tfMedQty;
    // End of variables declaration//GEN-END:variables
}
