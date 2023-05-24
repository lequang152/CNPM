/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CNPM.Form;

import CNPM.SoGiuong;
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
public class sogiuongform extends javax.swing.JFrame {

    /**
     * Creates new form sogiuong
     */
    public sogiuongform() {
        initComponents();
        hienThiDanhSachSoGiuong();
    }
    
  public ArrayList<SoGiuong> layDanhSachSoGiuong() {
        ArrayList<SoGiuong> dsdv = new ArrayList<SoGiuong>();
        Connection con = getConnection();
        try {
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT * FROM khachsan.sogiuong;";
            // Thưcj thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery(sql);

            SoGiuong dv;
            while (rs.next()) {
                dv = new SoGiuong(rs.getInt("MASG"), rs.getString("TENLOAI"),rs.getInt("GIA") , rs.getString("CHUTHICH"));
                //Thêm vào danh sách
                dsdv.add(dv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessageDialog(this, "lỗi database");

        }
        return dsdv;
    }
    public void hienThiDanhSachSoGiuong() {
        String colTieuDe1[] = new String[]{"Mã số giường", "Tên loại", "Giá", "Chú thích"};
        ArrayList<SoGiuong> dsdv = layDanhSachSoGiuong();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsdv.size(); i++) {

            row = new Object[4];

            // GÁN GIÁ TRỊ
            row[0] = dsdv.get(i).getMASG();
            row[1] = dsdv.get(i).getTENLOAI();
            row[2] = dsdv.get(i).getGIA();
            row[3] = dsdv.get(i).getCHUTHICH();


            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTable1.setModel(model);

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
        them3 = new javax.swing.JButton();
        sua3 = new javax.swing.JButton();
        jButtonclear3 = new javax.swing.JButton();
        xoa3 = new javax.swing.JButton();
        thoat3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        masg = new javax.swing.JTextField();
        tenloai = new javax.swing.JTextField();
        gia = new javax.swing.JTextField();
        chuthich = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý số giường");

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

        jLabel2.setText("Mã số giường");
        jLabel2.setToolTipText("");

        jLabel3.setText("Tên loại");

        jLabel4.setText("Giá ");

        jLabel5.setText("Chú thích");

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
                .addGap(28, 28, 28)
                .addComponent(thoat3)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chuthich, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masg, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(thoat3)
                            .addComponent(xoa3)
                            .addComponent(jButtonclear3)
                            .addComponent(sua3)
                            .addComponent(them3))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chuthich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if(masg.getText().equals("") || tenloai.getText().equals("") || gia.getText().equals("") || chuthich.getText().equals("")) {
            showMessageDialog(this, "Không có đủ thông tin");
            return;
        }
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            Statement st = (Statement) con.createStatement();
            String query = "INSERT INTO sogiuong(MASG, TENLOAI, GIA, CHUTHICH) VALUES('" + masg.getText() + "',"
            + "'" + tenloai.getText() + "','" + gia.getText() + "', '" + chuthich.getText() + "')";

            st.execute(query);
            hienThiDanhSachSoGiuong();

        } catch (Exception ex) {
            showMessageDialog(this, "thông tin không hợp lệ");
        }
    }//GEN-LAST:event_them3ActionPerformed

    private void sua3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua3ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow()==-1) {
            if (jTable1.getRowCount()==0) {
                // lblError.setText("Table is empty");
            }
            else{
                //  lblError.setText("You must select a Tennis Player");
            }
        }
        else{
            if(masg.getText().equals("") || tenloai.getText().equals("") || gia.getText().equals("") || chuthich.getText().equals("")) {
                showMessageDialog(this, "Không có đủ thông tin");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String old = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
            System.out.print(old);
            Connection con = getConnection();
            try {
                // Tạo một đối tượng để thực hiện công việc
                Statement st = (Statement) con.createStatement();
                String query = "UPDATE sogiuong SET MASG = "+ "'" +masg.getText()+ "'" +
                ", TENLOAI =" + "'" +tenloai.getText()+ "'" +
                ", GIA =" + "'" +gia.getText()+  "'" +
                ", CHUTHICH =" + "'" +chuthich.getText()+  "'" +
                " where MASG = " + "'" + old + "'" ;

                st.executeUpdate(query);
                hienThiDanhSachSoGiuong();
            } catch (Exception ex) {

                showMessageDialog(this, "thông tin không hợp lệ");
            }
        }
    }//GEN-LAST:event_sua3ActionPerformed

    private void jButtonclear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclear3ActionPerformed
        // TODO add your handling code here:
        masg.setText("");
        tenloai.setText("");
        gia.setText("");
        chuthich.setText("");
    }//GEN-LAST:event_jButtonclear3ActionPerformed

    private void xoa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa3ActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            Statement st = (Statement) con.createStatement();
            String query = "DELETE FROM sogiuong WHERE MASG = '" + masg.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachSoGiuong();

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        masg.setText(model.getValueAt(i, 0).toString());
        tenloai.setText(model.getValueAt(i, 1).toString());
        gia.setText(model.getValueAt(i, 2).toString());
        chuthich.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(sogiuongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sogiuongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sogiuongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sogiuongform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sogiuongform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chuthich;
    private javax.swing.JTextField gia;
    private javax.swing.JButton jButtonclear3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField masg;
    private javax.swing.JButton sua3;
    private javax.swing.JTextField tenloai;
    private javax.swing.JButton them3;
    private javax.swing.JButton thoat3;
    private javax.swing.JButton xoa3;
    // End of variables declaration//GEN-END:variables
}
