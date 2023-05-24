/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CNPM.Form;

import CNPM.TTphong;
import static CNPM.MyConnection.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public class TTphongform extends javax.swing.JFrame {

    /**
     * Creates new form TTphong
     */
    public TTphongform() {
        initComponents();
        hienThiDanhSachLoaiDichVu();
    }

        public ArrayList<TTphong> layDanhSachLoaiDichVu() {
        ArrayList<TTphong> dsdv = new ArrayList<TTphong>();
        Connection con = getConnection();
        try {
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT * FROM khachsan.tinhtrangphong;";
            // Thưcj thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery(sql);

            TTphong dv;
            while (rs.next()) {
                dv = new TTphong(rs.getInt("MATTP"), rs.getString("TENTTP"), rs.getString("CHUTHICH"));

                //Thêm vào danh sách
                dsdv.add(dv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessageDialog(this, "lỗi database");

        }
        return dsdv;
    }
    public void hienThiDanhSachLoaiDichVu() {
        String colTieuDe1[] = new String[]{"Mã tình trạng", "Tình trạng", "Chú thích"};
        ArrayList<TTphong> dsdv = layDanhSachLoaiDichVu();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsdv.size(); i++) {

            row = new Object[3];

            // GÁN GIÁ TRỊ
            row[0] = dsdv.get(i).getMATT();
            row[1] = dsdv.get(i).getTT();
            row[2] = dsdv.get(i).getCHUTHICH();


            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTableLoaiDV.setModel(model);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLoaiDV = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        them3 = new javax.swing.JButton();
        sua3 = new javax.swing.JButton();
        jButtonclear3 = new javax.swing.JButton();
        xoa3 = new javax.swing.JButton();
        thoat3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mattp = new javax.swing.JTextField();
        ttp = new javax.swing.JTextField();
        chuthich = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jTableLoaiDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableLoaiDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLoaiDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLoaiDV);

        them3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THEM.png"))); // NOI18N
        them3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them3ActionPerformed(evt);
            }
        });

        sua3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/SUA.png"))); // NOI18N
        sua3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua3ActionPerformed(evt);
            }
        });

        jButtonclear3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/CLEAR.png"))); // NOI18N
        jButtonclear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclear3ActionPerformed(evt);
            }
        });

        xoa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/delete.png"))); // NOI18N
        xoa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa3ActionPerformed(evt);
            }
        });

        thoat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THOAT.png"))); // NOI18N
        thoat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã tình trạng");

        jLabel3.setText("Tình trạng");

        jLabel4.setText("Chú thích");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(them3)
                .addGap(36, 36, 36)
                .addComponent(sua3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonclear3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(xoa3)
                .addGap(26, 26, 26)
                .addComponent(thoat3)
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ttp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chuthich, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(mattp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mattp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chuthich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(thoat3)
                    .addComponent(xoa3)
                    .addComponent(jButtonclear3)
                    .addComponent(sua3)
                    .addComponent(them3))
                .addGap(30, 30, 30))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tình trạng phòng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(273, 273, 273)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(191, 191, 191)))
                    .addContainerGap(55, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void them3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them3ActionPerformed
        // TODO add your handling code here
            if(mattp.getText().equals("") || ttp.getText().equals("") || chuthich.getText().equals("")) {
            showMessageDialog(this, "Không có đủ thông tin");
            return;
        }
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            Statement st = (Statement) con.createStatement();
            String query = "INSERT INTO tinhtrangphong(MATTP, TENTTP, CHUTHICH) VALUES('" + mattp.getText() + "',"
            + "'" + ttp.getText() + "','" + chuthich.getText()+ "')";

            st.execute(query);
            hienThiDanhSachLoaiDichVu();

        } catch (Exception ex) {
            showMessageDialog(this, "thông tin không hợp lệ");
        }
    }//GEN-LAST:event_them3ActionPerformed

    private void sua3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua3ActionPerformed
        // TODO add your handling code here:
        if (jTableLoaiDV.getSelectedRow()==-1) {
            if (jTableLoaiDV.getRowCount()==0) {
                // lblError.setText("Table is empty");
            }
            else{
                //  lblError.setText("You must select a Tennis Player");
            }
        }
        else{
            if(mattp.getText().equals("") || ttp.getText().equals("") || chuthich.getText().equals("")) {
                showMessageDialog(this, "Không có đủ thông tin");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) jTableLoaiDV.getModel();
            String old = model.getValueAt(jTableLoaiDV.getSelectedRow(), 0).toString();
            System.out.print(old);
            Connection con = getConnection();
            try {
                // Tạo một đối tượng để thực hiện công việc
                Statement st = (Statement) con.createStatement();
                String query = "UPDATE tinhtrangphong SET MATTP = "+ "'" +mattp.getText()+ "'" +
                ", TENTTP =" + "'" +ttp.getText()+ "'" +
                ", CHUTHICH =" + "'" +chuthich.getText()+  "'" +
                " where MATTP = " + "'" + old + "'" ;

                st.executeUpdate(query);
                hienThiDanhSachLoaiDichVu();
            } catch (Exception ex) {

                showMessageDialog(this, "thông tin không hợp lệ");
            }
        }
    }//GEN-LAST:event_sua3ActionPerformed

    private void jButtonclear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclear3ActionPerformed
        // TODO add your handling code here:
        mattp.setText("");
        ttp.setText("");
        chuthich.setText("");
    }//GEN-LAST:event_jButtonclear3ActionPerformed

    private void xoa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa3ActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            Statement st = (Statement) con.createStatement();
            String query = "DELETE FROM tinhtrangphong WHERE MATTP = '" + mattp.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachLoaiDichVu();

        } catch (Exception ex) {

            showMessageDialog(this, "thông tin không hợp lệ");
        }
    }//GEN-LAST:event_xoa3ActionPerformed

    private void thoat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat3ActionPerformed
        // TODO add your handling code here:
        thoat3.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_thoat3ActionPerformed

    private void jTableLoaiDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoaiDVMouseClicked
        int i = jTableLoaiDV.getSelectedRow();
        TableModel model = jTableLoaiDV.getModel();
        mattp.setText(model.getValueAt(i, 0).toString());
        ttp.setText(model.getValueAt(i, 1).toString());
        chuthich.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_jTableLoaiDVMouseClicked

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
            java.util.logging.Logger.getLogger(TTphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TTphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TTphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TTphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TTphongform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chuthich;
    private javax.swing.JButton jButtonclear3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLoaiDV;
    private javax.swing.JTextField mattp;
    private javax.swing.JButton sua3;
    private javax.swing.JButton them3;
    private javax.swing.JButton thoat3;
    private javax.swing.JTextField ttp;
    private javax.swing.JButton xoa3;
    // End of variables declaration//GEN-END:variables
}
