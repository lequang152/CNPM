/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CNPM.Form;

import static CNPM.MyConnection.getConnection;
import CNPM.LoaiPhong;
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
public class loaiphongform extends javax.swing.JFrame {

    /**
     * Creates new form loaiphongform
     */
    public loaiphongform() {
        initComponents();
        hienThiDanhSachLoaiPhong();
    }

      public ArrayList<LoaiPhong> layDanhSachLoaiPhong() {
        ArrayList<LoaiPhong> dsdv = new ArrayList<LoaiPhong>();
        Connection con = getConnection();
        try {
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT * FROM khachsan.loaiphong;";
            // Thưcj thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery(sql);

            LoaiPhong dv;
            while (rs.next()) {
                dv = new LoaiPhong(rs.getInt("MALP"), rs.getString("TENLP"),rs.getInt("GIAPHONG") , rs.getString("CHUTHICH"));

                //Thêm vào danh sách
                dsdv.add(dv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessageDialog(this, "lỗi database");

        }
        return dsdv;
    }
    public void hienThiDanhSachLoaiPhong() {
        String colTieuDe1[] = new String[]{"Mã loại phòng", "Tên loại phòng", "Giá phòng", "Chú thích"};
        ArrayList<LoaiPhong> dsdv = layDanhSachLoaiPhong();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsdv.size(); i++) {

            row = new Object[4];

            // GÁN GIÁ TRỊ
            row[0] = dsdv.get(i).getMALP();
            row[1] = dsdv.get(i).getTENLP();
            row[2] = dsdv.get(i).getGIAPHONG();
            row[3] = dsdv.get(i).getCHUTHICH();


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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        malp = new javax.swing.JTextField();
        tenlp = new javax.swing.JTextField();
        giaphong = new javax.swing.JTextField();
        chuthich = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        them4 = new javax.swing.JButton();
        sua4 = new javax.swing.JButton();
        clear4 = new javax.swing.JButton();
        xoa4 = new javax.swing.JButton();
        thoat4 = new javax.swing.JButton();
        jTableLoaiDV2 = new javax.swing.JScrollPane();
        jTableLoaiDV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setBackground(new java.awt.Color(204, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý loại phòng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mã loại phòng");

        jLabel3.setText("Tên loại phòng");
        jLabel3.setToolTipText("");

        jLabel4.setText("Giá phòng");

        jLabel5.setText("Chú thích");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Thông tin loại phòng");

        them4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THEM.png"))); // NOI18N
        them4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them4ActionPerformed(evt);
            }
        });

        sua4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/SUA.png"))); // NOI18N
        sua4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua4ActionPerformed(evt);
            }
        });

        clear4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/CLEAR.png"))); // NOI18N
        clear4.setToolTipText("");
        clear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear4ActionPerformed(evt);
            }
        });

        xoa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/delete.png"))); // NOI18N
        xoa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa4ActionPerformed(evt);
            }
        });

        thoat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THOAT.png"))); // NOI18N
        thoat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(them4)
                        .addGap(28, 28, 28)
                        .addComponent(sua4)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenlp)
                    .addComponent(giaphong)
                    .addComponent(chuthich)
                    .addComponent(malp)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(clear4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xoa4)
                        .addGap(28, 28, 28)
                        .addComponent(thoat4)
                        .addGap(14, 14, 14)))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel6)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(malp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chuthich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xoa4)
                    .addComponent(them4)
                    .addComponent(sua4)
                    .addComponent(clear4)
                    .addComponent(thoat4))
                .addGap(25, 25, 25))
        );

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
        jTableLoaiDV2.setViewportView(jTableLoaiDV);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jTableLoaiDV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTableLoaiDV2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void them4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them4ActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        if(malp.getText().equals("") || tenlp.getText().equals("") || giaphong.getText().equals("")) {
            showMessageDialog(this, "Không có đủ thông tin");
            return;
        }

        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
           Statement st = (Statement) con.createStatement();
            String query = "INSERT INTO loaiphong(MALP, TENLP, GIAPHONG, CHUTHICH) VALUES('" + malp.getText() + "','"
                 + tenlp.getText() + "','" + giaphong.getText()+ "','" + chuthich.getText()+ "')";
            st.execute(query);
            hienThiDanhSachLoaiPhong();

        } catch (Exception ex) {
            showMessageDialog(this, "thông tin không hợp lệ");
        }
        
    }//GEN-LAST:event_them4ActionPerformed

    private void sua4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua4ActionPerformed
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
            if(malp.getText().equals("") || tenlp.getText().equals("") || giaphong.getText().equals("")) {
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
                String query = "UPDATE loaiphong SET MALP = "+ "'" + malp.getText()+ "'" +
                ", TENLP =" + "'" +tenlp.getText()+ "'" +
                ", GIAPHONG =" + "'" +giaphong.getText()+  "'" +
                ", CHUTHICH =" + "'" +chuthich.getText()+  "'" +
                " where MALP = " + "'" + old + "'" ;

                st.executeUpdate(query);
                hienThiDanhSachLoaiPhong();
            } catch (Exception ex) {

                showMessageDialog(this, "thông tin không hợp lệ");
            }
        }
    }//GEN-LAST:event_sua4ActionPerformed

    private void clear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear4ActionPerformed
        // TODO add your handling code here:
        malp.setText("");
        tenlp.setText("");
        giaphong.setText("");
        chuthich.setText("");
    }//GEN-LAST:event_clear4ActionPerformed

    private void xoa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa4ActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            Statement st = (Statement) con.createStatement();
            String query = "DELETE FROM loaiphong WHERE MALP = '" + malp.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachLoaiPhong();

        } catch (Exception ex) {

            showMessageDialog(this, "Lỗi database");
        }
    }//GEN-LAST:event_xoa4ActionPerformed

    private void thoat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat4ActionPerformed
        // TODO add your handling code here:
        thoat4.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_thoat4ActionPerformed

    private void jTableLoaiDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoaiDVMouseClicked
        int i = jTableLoaiDV.getSelectedRow();
        TableModel model = jTableLoaiDV.getModel();
        malp.setText(model.getValueAt(i, 0).toString());
        tenlp.setText(model.getValueAt(i, 1).toString());
        giaphong.setText(model.getValueAt(i, 2).toString());
        chuthich.setText(model.getValueAt(i, 3).toString());
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
            java.util.logging.Logger.getLogger(loaiphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loaiphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loaiphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loaiphongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loaiphongform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chuthich;
    private javax.swing.JButton clear4;
    private javax.swing.JTextField giaphong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jTableLoaiDV;
    private javax.swing.JScrollPane jTableLoaiDV2;
    private javax.swing.JTextField malp;
    private javax.swing.JButton sua4;
    private javax.swing.JTextField tenlp;
    private javax.swing.JButton them4;
    private javax.swing.JButton thoat4;
    private javax.swing.JButton xoa4;
    // End of variables declaration//GEN-END:variables
}
