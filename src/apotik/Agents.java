package apotik;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Agents extends javax.swing.JFrame {

    public Agents() {
        initComponents();
        GetAllAgents();
        tbtnMedicine.setSelected(false);
        tbtnCompany.setSelected(false);
        tbtnAgents.setSelected(true);
        tbtnSelling.setSelected(false);
    }

    /* Connection with db*/
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfAgentAge = new javax.swing.JTextField();
        tfAgentPass = new javax.swing.JTextField();
        tfAgentName = new javax.swing.JTextField();
        tfAgentId = new javax.swing.JTextField();
        tfAgentPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AgentsTable = new javax.swing.JTable();
        cbGender = new javax.swing.JComboBox<>();
        background = new javax.swing.JLabel();
        tbtnSelling = new javax.swing.JToggleButton();
        tbtnAgents = new javax.swing.JToggleButton();
        tbtnMedicine = new javax.swing.JToggleButton();
        tbtnCompany = new javax.swing.JToggleButton();
        btnAddAgent = new javax.swing.JButton();
        btnUpdateAgent = new javax.swing.JButton();
        btnDeleteAgent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfAgentAge.setBorder(null);
        getContentPane().add(tfAgentAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 252, 160, 30));

        tfAgentPass.setBorder(null);
        getContentPane().add(tfAgentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 150, 30));

        tfAgentName.setBorder(null);
        getContentPane().add(tfAgentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 170, 30));

        tfAgentId.setBorder(null);
        getContentPane().add(tfAgentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 170, 20));

        tfAgentPhone.setBorder(null);
        getContentPane().add(tfAgentPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 170, 20));

        AgentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Umur", "Nomor", "Password", "Gender"
            }
        ));
        AgentsTable.setRowHeight(25);
        AgentsTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        AgentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AgentsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 540, 160));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - laki", "Perempuan" }));
        getContentPane().add(cbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 252, 110, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/KARYAWAN.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        getContentPane().add(tbtnAgents, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 359, 150, 60));

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
        getContentPane().add(tbtnCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 269, 160, 60));

        btnAddAgent.setBackground(new java.awt.Color(204, 204, 204));
        btnAddAgent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddAgent.setForeground(new java.awt.Color(102, 102, 102));
        btnAddAgent.setText("Tambah");
        btnAddAgent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAgentActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 309, 100, 40));

        btnUpdateAgent.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateAgent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdateAgent.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateAgent.setText("Update");
        btnUpdateAgent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAgentActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 120, 40));

        btnDeleteAgent.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteAgent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeleteAgent.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteAgent.setText("Hapus");
        btnDeleteAgent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAgentActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 120, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void GetAllAgents()
    {
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
           st = conn.createStatement();
           rs = st.executeQuery("Select * from apotik.agents");
           AgentsTable.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    
    private void btnUpdateAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAgentActionPerformed
        
        if (tfAgentId.getText().isEmpty() || tfAgentName.getText().isEmpty() || tfAgentAge.getText().isEmpty() || tfAgentPhone.getText().isEmpty() || tfAgentPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information about Agent");
        }
        else
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
                PreparedStatement ps = conn.prepareStatement("update agents set name=?, age=?, phone=?, password=?, gender=? where id=?");

                ps.setString(1, tfAgentName.getText());
                ps.setInt(2, Integer.valueOf(tfAgentAge.getText()));
                ps.setString(3, tfAgentPhone.getText());
                ps.setString(4, tfAgentPass.getText());
                ps.setString(5, cbGender.getSelectedItem().toString());
                ps.setInt(6, Integer.valueOf(tfAgentId.getText()));


                ps.executeUpdate();
                
                
                GetAllAgents();
                JOptionPane.showMessageDialog(this, "Agent Successfully Updated!");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnUpdateAgentActionPerformed

    
    private void btnAddAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAgentActionPerformed
        
        try {          
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
            PreparedStatement ps = conn.prepareStatement("insert into agents values(?,?,?,?,?,?)");
            
            ps.setInt(1, Integer.valueOf(tfAgentId.getText()));
            ps.setString(2, tfAgentName.getText());
            ps.setInt(3, Integer.valueOf(tfAgentAge.getText()));
            ps.setString(4, tfAgentPhone.getText());
            ps.setString(5, tfAgentPass.getText());
            ps.setString(6, cbGender.getSelectedItem().toString());
        
            
            int row =  ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Agent Successfully Added!");
            conn.close();
            GetAllAgents();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnAddAgentActionPerformed

    
    private void btnDeleteAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAgentActionPerformed
        
        if (tfAgentId.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Enter ID of The Agent To Be Deleted....");
        }
        else
        {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apotik?user=root&password=");
                String id = tfAgentId.getText();
                String query = "Delete from apotik.agents where id = " + id;
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                
                GetAllAgents();
                JOptionPane.showMessageDialog(this, "Agent Successfully Deleted!");
           
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnDeleteAgentActionPerformed

    
    private void AgentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgentsTableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)AgentsTable.getModel();
        int myIndex = AgentsTable.getSelectedRow();
        tfAgentId.setText(model.getValueAt(myIndex, 0).toString());
        tfAgentName.setText(model.getValueAt(myIndex, 1).toString());
        tfAgentAge.setText(model.getValueAt(myIndex, 2).toString());
        tfAgentPhone.setText(model.getValueAt(myIndex, 3).toString());
        tfAgentPass.setText(model.getValueAt(myIndex, 4).toString());
        
    }//GEN-LAST:event_AgentsTableMouseClicked

    private void tbtnSellingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnSellingMouseClicked
        dispose();
        Selling selling = new Selling();
        selling.setVisible(true);
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
        dispose();
        Agents agents = new Agents();
        agents.setVisible(true);
    }//GEN-LAST:event_tbtnAgentsMouseClicked

    private void tbtnSellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnSellingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtnSellingActionPerformed

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
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AgentsTable;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAddAgent;
    private javax.swing.JButton btnDeleteAgent;
    private javax.swing.JButton btnUpdateAgent;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton tbtnAgents;
    private javax.swing.JToggleButton tbtnCompany;
    private javax.swing.JToggleButton tbtnMedicine;
    private javax.swing.JToggleButton tbtnSelling;
    private javax.swing.JTextField tfAgentAge;
    private javax.swing.JTextField tfAgentId;
    private javax.swing.JTextField tfAgentName;
    private javax.swing.JTextField tfAgentPass;
    private javax.swing.JTextField tfAgentPhone;
    // End of variables declaration//GEN-END:variables
}
