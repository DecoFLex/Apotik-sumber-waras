package apotik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Company extends javax.swing.JFrame {

    public Company() {
        initComponents();
        GetAllCompanies();
        tbtnMedicine.setSelected(false);
        tbtnCompany.setSelected(true);
        tbtnAgents.setSelected(false);
        tbtnSelling.setSelected(false);
    }

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        CompanyTable = new javax.swing.JTable();
        tfCompanyAddress = new javax.swing.JTextField();
        tfCompanyName = new javax.swing.JTextField();
        tfCompanyPhone = new javax.swing.JTextField();
        tfCompanyId = new javax.swing.JTextField();
        tfCompanyPos = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        tbtnSelling = new javax.swing.JToggleButton();
        tbtnAgents = new javax.swing.JToggleButton();
        tbtnMedicine = new javax.swing.JToggleButton();
        tbtnCompany = new javax.swing.JToggleButton();
        btnAddCompany = new javax.swing.JButton();
        btnUpdateCompany = new javax.swing.JButton();
        btnDeleteCompany = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CompanyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "COMPANY", "ADDRESS", "EXPERIENCE", "PHONE"
            }
        ));
        CompanyTable.setRowHeight(25);
        CompanyTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        CompanyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompanyTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CompanyTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 480, 170));

        tfCompanyAddress.setBorder(null);
        getContentPane().add(tfCompanyAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 170, 20));

        tfCompanyName.setBorder(null);
        getContentPane().add(tfCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 150, 20));

        tfCompanyPhone.setBorder(null);
        getContentPane().add(tfCompanyPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 160, 30));

        tfCompanyId.setBorder(null);
        getContentPane().add(tfCompanyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 170, 30));

        tfCompanyPos.setBorder(null);
        getContentPane().add(tfCompanyPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 160, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/APOTIK SUMBER WARAS (5).png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 580));

        tbtnSelling.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnSelling.setText("Penjualan");
        tbtnSelling.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnSelling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnSellingMouseClicked(evt);
            }
        });
        tbtnSelling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnSellingActionPerformed(evt);
            }
        });
        getContentPane().add(tbtnSelling, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 100, 150, 60));

        tbtnAgents.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnAgents.setText("Karyawan");
        tbtnAgents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnAgents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnAgentsMouseClicked(evt);
            }
        });
        getContentPane().add(tbtnAgents, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 350, 150, 70));

        tbtnMedicine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnMedicine.setText("Stok Obat");
        tbtnMedicine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnMedicineMouseClicked(evt);
            }
        });
        tbtnMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnMedicineActionPerformed(evt);
            }
        });
        getContentPane().add(tbtnMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 189, 150, 60));

        tbtnCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnCompany.setText("Perusahaan");
        tbtnCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tbtnCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtnCompanyMouseClicked(evt);
            }
        });
        tbtnCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnCompanyActionPerformed(evt);
            }
        });
        getContentPane().add(tbtnCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 269, 150, 60));

        btnAddCompany.setBackground(new java.awt.Color(204, 204, 204));
        btnAddCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddCompany.setForeground(new java.awt.Color(102, 102, 102));
        btnAddCompany.setText("Tambah");
        btnAddCompany.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCompanyActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 319, 110, 30));

        btnUpdateCompany.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdateCompany.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateCompany.setText("Update");
        btnUpdateCompany.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCompanyActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 320, 130, -1));

        btnDeleteCompany.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeleteCompany.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteCompany.setText("Hapus");
        btnDeleteCompany.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCompanyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 320, 110, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void GetAllCompanies()
    {
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
           st = conn.createStatement();
           rs = st.executeQuery("Select * from apotik.companies");
           CompanyTable.setModel(DbUtils.resultSetToTableModel(rs));      
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    
    private void btnAddCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCompanyActionPerformed
       
        try {          
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
            PreparedStatement ps = conn.prepareStatement("insert into companies values(?,?,?,?,?)");
            
            ps.setInt(1, Integer.valueOf(tfCompanyId.getText()));
            ps.setString(2, tfCompanyName.getText());
            ps.setString(3, tfCompanyAddress.getText());
            ps.setInt(4, Integer.valueOf(tfCompanyPos.getText()));
            ps.setString(5, tfCompanyPhone.getText());
        
            
            int row =  ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Company Successfully Added!");
            conn.close();
            GetAllCompanies();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnAddCompanyActionPerformed

    
    private void btnUpdateCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCompanyActionPerformed
        if (tfCompanyId.getText().isEmpty() || tfCompanyName.getText().isEmpty() || tfCompanyAddress.getText().isEmpty() || tfCompanyPos.getText().isEmpty() || tfCompanyPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information about Company");
        }
        else
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");                
                PreparedStatement ps = conn.prepareStatement("update companies set name=?, address=?, companyExp=?, phone=? where id=?");

                ps.setString(1, tfCompanyName.getText());
                ps.setString(2, tfCompanyAddress.getText());
                ps.setInt(3, Integer.valueOf(tfCompanyPos.getText()));
                ps.setString(4, tfCompanyPhone.getText());
                ps.setInt(5, Integer.valueOf(tfCompanyId.getText()));
        
               
                ps.executeUpdate();
                
                GetAllCompanies();
                JOptionPane.showMessageDialog(this, "Company Successfully Updated!");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_btnUpdateCompanyActionPerformed

    
    private void btnDeleteCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCompanyActionPerformed
       
        if (tfCompanyId.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Enter ID of The Company To Be Deleted....");
        }
        else
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
                String id = tfCompanyId.getText();
                String query = "Delete from apotik.companies where id = " + id;
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                
                GetAllCompanies();
                JOptionPane.showMessageDialog(this, "Company Successfully Deleted!");
           
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnDeleteCompanyActionPerformed

    
    private void CompanyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompanyTableMouseClicked

        DefaultTableModel model = (DefaultTableModel)CompanyTable.getModel();
        int myIndex = CompanyTable.getSelectedRow();
        tfCompanyId.setText(model.getValueAt(myIndex, 0).toString());
        tfCompanyName.setText(model.getValueAt(myIndex, 1).toString());
        tfCompanyAddress.setText(model.getValueAt(myIndex, 2).toString());
        tfCompanyPos.setText(model.getValueAt(myIndex, 3).toString());
        tfCompanyPhone.setText(model.getValueAt(myIndex, 4).toString());

    }//GEN-LAST:event_CompanyTableMouseClicked

    
    private void tbtnSellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnSellingMouseClicked
        new Selling().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnSellingMouseClicked

    private void tbtnMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnMedicineMouseClicked
        new Medicine().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnMedicineMouseClicked

    private void tbtnCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnCompanyMouseClicked
        tbtnCompany.setSelected(true);
    }//GEN-LAST:event_tbtnCompanyMouseClicked

    private void tbtnAgentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnAgentsMouseClicked
        new Agents().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbtnAgentsMouseClicked

    private void tbtnSellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnSellingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnSellingActionPerformed

    private void tbtnMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnMedicineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnMedicineActionPerformed

    private void tbtnCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnCompanyActionPerformed

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
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CompanyTable;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAddCompany;
    private javax.swing.JButton btnDeleteCompany;
    private javax.swing.JButton btnUpdateCompany;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton tbtnAgents;
    private javax.swing.JToggleButton tbtnCompany;
    private javax.swing.JToggleButton tbtnMedicine;
    private javax.swing.JToggleButton tbtnSelling;
    private javax.swing.JTextField tfCompanyAddress;
    private javax.swing.JTextField tfCompanyId;
    private javax.swing.JTextField tfCompanyName;
    private javax.swing.JTextField tfCompanyPhone;
    private javax.swing.JTextField tfCompanyPos;
    // End of variables declaration//GEN-END:variables
}
