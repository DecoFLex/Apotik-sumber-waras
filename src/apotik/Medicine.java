
package apotik;

import java.sql.Connection;
import com.toedter.calendar.JDateChooser;  // Baris 8
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Medicine extends javax.swing.JFrame {

    public Medicine() {
        initComponents();
        GetAllMedicines();
        GetCompany();
        tbtnMedicine.setSelected(true);
        tbtnCompany.setSelected(false);
        tbtnAgents.setSelected(false);
        tbtnSelling.setSelected(false);
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    java.util.Date fabDate,expDate;
    java.util.Date myFabDate, myExpDate;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        MedicineTable = new javax.swing.JTable();
        dpFabDate = new com.toedter.calendar.JDateChooser();
        dpExpDate = new com.toedter.calendar.JDateChooser();
        cbCompany = new javax.swing.JComboBox<>();
        tfMedQty = new javax.swing.JTextField();
        tfMedName = new javax.swing.JTextField();
        tfMedPrice = new javax.swing.JTextField();
        tfMedId = new javax.swing.JTextField();
        BACKGROUND = new javax.swing.JLabel();
        btnAddMeddicine = new javax.swing.JButton();
        btnUpdateMeddicine = new javax.swing.JButton();
        btnDeletemeddicine = new javax.swing.JButton();
        tbtnAgents = new javax.swing.JToggleButton();
        tbtnCompany = new javax.swing.JToggleButton();
        tbtnSelling = new javax.swing.JToggleButton();
        tbtnMedicine = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 640, 150));
        getContentPane().add(dpFabDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 110, 30));
        getContentPane().add(dpExpDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 110, 30));

        getContentPane().add(cbCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 90, 30));

        tfMedQty.setBorder(null);
        tfMedQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMedQtyActionPerformed(evt);
            }
        });
        getContentPane().add(tfMedQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 120, 20));

        tfMedName.setBorder(null);
        getContentPane().add(tfMedName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 90, 20));

        tfMedPrice.setBorder(null);
        tfMedPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMedPriceActionPerformed(evt);
            }
        });
        getContentPane().add(tfMedPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 60, 30));

        tfMedId.setBorder(null);
        getContentPane().add(tfMedId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 100, 30));

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/APOTIK SUMBER WARAS (2).png"))); // NOI18N
        BACKGROUND.setText("PERUSAHAAN");
        getContentPane().add(BACKGROUND, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 580));

        btnAddMeddicine.setBackground(new java.awt.Color(204, 204, 204));
        btnAddMeddicine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddMeddicine.setForeground(new java.awt.Color(102, 102, 102));
        btnAddMeddicine.setText("Tambah");
        btnAddMeddicine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddMeddicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMeddicineActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddMeddicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 90, -1));

        btnUpdateMeddicine.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateMeddicine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdateMeddicine.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateMeddicine.setText("Update");
        btnUpdateMeddicine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateMeddicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMeddicineActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateMeddicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 90, -1));

        btnDeletemeddicine.setBackground(new java.awt.Color(204, 204, 204));
        btnDeletemeddicine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeletemeddicine.setForeground(new java.awt.Color(102, 102, 102));
        btnDeletemeddicine.setText("Hapus");
        btnDeletemeddicine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeletemeddicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletemeddicineActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletemeddicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 110, -1));

        tbtnAgents.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnAgents.setText("Karyawan");
        tbtnAgents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnAgents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnAgentsMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnAgents, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, 60));

        tbtnCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnCompany.setText("Perusahaan");
        tbtnCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnCompanyMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 150, 50));

        tbtnSelling.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnSelling.setBorder(null);
        tbtnSelling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnSellingMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnSelling, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 50));

        tbtnMedicine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnMedicine.setText("Stok Obat");
        tbtnMedicine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnMedicineMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbtnCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnCompanyMouseClicked
        new Company().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnCompanyMouseClicked

    private void tbtnMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnMedicineMouseClicked
        tbtnMedicine.setSelected(true);
    }//GEN-LAST:event_tbtnMedicineMouseClicked

    private void tbtnAgentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnAgentsMouseClicked
        new Agents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnAgentsMouseClicked

    private void tbtnSellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnSellingMouseClicked
        new Selling().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnSellingMouseClicked

    private void MedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicineTableMouseClicked

        DefaultTableModel model = (DefaultTableModel)MedicineTable.getModel();
        int myIndex = MedicineTable.getSelectedRow();
        tfMedId.setText(model.getValueAt(myIndex, 0).toString());
        tfMedName.setText(model.getValueAt(myIndex, 1).toString());
        tfMedQty.setText(model.getValueAt(myIndex, 2).toString());
        dpFabDate.setDate((Date)model.getValueAt(myIndex, 3));
        dpExpDate.setDate((Date)model.getValueAt(myIndex, 4));
        tfMedPrice.setText(model.getValueAt(myIndex, 6).toString());
    }//GEN-LAST:event_MedicineTableMouseClicked

    private void btnDeletemeddicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletemeddicineActionPerformed

        if (tfMedId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter ID of The Medicine To Be Deleted....");
        }
        else
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
                String id = tfMedId.getText();
                String query = "Delete from apotik.medicines where id = " + id;
                Statement st = conn.createStatement();
                st.executeUpdate(query);

                GetAllMedicines();
                JOptionPane.showMessageDialog(this, "Medicine Successfully Deleted!");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletemeddicineActionPerformed

    private void btnUpdateMeddicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMeddicineActionPerformed

        if (tfMedId.getText().isEmpty() || tfMedName.getText().isEmpty() || tfMedPrice.getText().isEmpty() || tfMedQty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information about Medicine");
        }
        else
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
                String id = tfMedId.getText();
                fabDate = dpFabDate.getDate();
                myFabDate = new java.sql.Date(fabDate.getTime());
                expDate = dpExpDate.getDate();
                myExpDate = new java.sql.Date(expDate.getTime());

                String queryUpdate = "Update apotik.medicines set medname = '" + tfMedName.getText() + "'" + ",price = " + tfMedPrice.getText() + "" + ",quantity = " + tfMedQty.getText() + "" + ",fabdate = '" + myFabDate + "'" + ",expdate = '" + myExpDate + "'" + ",medcomp = '" + cbCompany.getSelectedItem().toString() + "'" + "where id = " + id;
                Statement st = conn.createStatement();
                st.executeUpdate(queryUpdate);

                GetAllMedicines();
                JOptionPane.showMessageDialog(this, "Medicine Successfully Updated!");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateMeddicineActionPerformed

    private void btnAddMeddicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMeddicineActionPerformed

        fabDate = dpFabDate.getDate(); // Mengambil tanggal dari dpFabDate
        myFabDate = new java.sql.Date(fabDate.getTime());
        expDate = dpExpDate.getDate(); // Mengambil tanggal dari dpExpDate
        myExpDate = new java.sql.Date(expDate.getTime());

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
            PreparedStatement ps = conn.prepareStatement("insert into medicines values(?,?,?,?,?,?,?)");

            ps.setInt(1, Integer.valueOf(tfMedId.getText()));
            ps.setString(2, tfMedName.getText());
            ps.setInt(3, Integer.valueOf(tfMedQty.getText()));
            ps.setDate(4, (Date) myFabDate);
            ps.setDate(5, (Date) myExpDate);
            ps.setString(6, cbCompany.getSelectedItem().toString());
            ps.setDouble(7, Double.valueOf(tfMedPrice.getText()));

            int row =  ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Medicine Successfully Added!");
            conn.close();
            GetAllMedicines();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddMeddicineActionPerformed

    private void tfMedQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMedQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMedQtyActionPerformed

    private void tfMedPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMedPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMedPriceActionPerformed

   public void GetAllMedicines()
    {
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
    
    public void GetCompany()
    {
        try {
              
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
           st = conn.createStatement();
           rs = st.executeQuery("Select * from apotik.companies");
           
           while(rs.next())
           {
               String myCompany = rs.getString("name");
               cbCompany.addItem(myCompany);
           }
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    } 
    
    
    
    
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
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JTable MedicineTable;
    private javax.swing.JButton btnAddMeddicine;
    private javax.swing.JButton btnDeletemeddicine;
    private javax.swing.JButton btnUpdateMeddicine;
    private javax.swing.JComboBox<String> cbCompany;
    private com.toedter.calendar.JDateChooser dpExpDate;
    private com.toedter.calendar.JDateChooser dpFabDate;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton tbtnAgents;
    private javax.swing.JToggleButton tbtnCompany;
    private javax.swing.JToggleButton tbtnMedicine;
    private javax.swing.JToggleButton tbtnSelling;
    private javax.swing.JTextField tfMedId;
    private javax.swing.JTextField tfMedName;
    private javax.swing.JTextField tfMedPrice;
    private javax.swing.JTextField tfMedQty;
    // End of variables declaration//GEN-END:variables
}
