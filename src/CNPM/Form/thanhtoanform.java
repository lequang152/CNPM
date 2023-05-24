
package CNPM.Form;
import CNPM.ThanhToan;
import static CNPM.MyConnection.getConnection;
import CNPM.ThanhToan2;
import static CNPM.dang_nhap.loggedInUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;


public class thanhtoanform extends javax.swing.JFrame {

    private String MAHD;
    private String NGAY;
    private String GIAHD;
    private String TINHTRANG;
    private String MADP;

    public thanhtoanform(String MAHD, String NGAY, String GIAHD, String TINHTRANG, String MADP) {
        initComponents();
        this.MAHD = MAHD;
        this.NGAY = NGAY;
        this.GIAHD = GIAHD;
        this.TINHTRANG = TINHTRANG;
        this.MADP = MADP;
        hienThiDanhSachThanhToan1();
        hienThiDanhSachThanhToan2();
        layThongTin();
        if(loggedInUser.getType().equals("0")) thanhcong.setVisible(false);
    }
    
    public void layThongTin() {
        jLabel14.setText(MAHD);
        jLabel13.setText(NGAY);
        jLabel6.setText(TINHTRANG);
        jLabel10.setText(GIAHD);
    }
    
    public ArrayList<ThanhToan> layDanhSachThanhToan1() {
        ArrayList<ThanhToan> dshd = new ArrayList<ThanhToan>();
        Connection con = getConnection();
        try {
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT ROW_NUMBER() OVER (ORDER BY MADP) STT, TENPHONG,(TIMESTAMPDIFF(day,NGAYNHAN,NGAYTRA) +1) as SONGAY, TENLP ,GIAPHONG,TENLOAI,GIA  FROM datphong d join phong p on p.MAPHONG = d.MAPHONG join loaiphong lp on lp.MALP = p.MALP join sogiuong sg on sg.MASG = p.MASG where MADP = "+MADP;

            ResultSet rs = st.executeQuery(sql);

            
            ThanhToan hd;
            while (rs.next()) {
                hd = new ThanhToan(rs.getInt("STT"), rs.getInt("TENPHONG"), rs.getInt("SONGAY"), rs.getString("TENLP"), rs.getInt("GIAPHONG"), rs.getString("TENLOAI"), rs.getInt("GIA"));

                //Thêm vào danh sách
                dshd.add(hd);
            }
        } catch (Exception ex) {
            showMessageDialog(this, "lỗi database");

        }
        
        
        return dshd;
    }
    
     public void hienThiDanhSachThanhToan1() {
        String colTieuDe1[] = new String[]{"STT", "Tên phòng", "Số ngày", "Tên loại", "Giá phòng", "Số giường", "Giá giường"};
        ArrayList<ThanhToan> dshd = layDanhSachThanhToan1();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dshd.size(); i++) {

            row = new Object[7];
          

            // GÁN GIÁ TRỊ
            row[0] = dshd.get(i).getSTT();
            row[1] = dshd.get(i).getTENPHONG();
            row[2] = dshd.get(i).getSONGAY();
            row[3] = dshd.get(i).getTENLP();
            row[4] = dshd.get(i).getGIAPHONG();
            row[5] = dshd.get(i).getTENLOAI();
            row[6] = dshd.get(i).getGIA();

            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTableThanhToan1.setModel(model);

    }
     
     public ArrayList<ThanhToan2> layDanhSachThanhToan2() {
                 ArrayList<ThanhToan2> dshd = new ArrayList<ThanhToan2>();
        Connection con = getConnection();
        try {
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT ROW_NUMBER() OVER (ORDER BY d.MADP) STT, TENLOAIDV, SOLUONG, THOIHAN, GIALDV,SOLUONG*THOIHAN*GIALDV as TongTien   FROM datphong d join dichvu dv on dv.MADP = d.MADP join loaidichvu l on l.MALDV = dv.MALDV where d.MADP = "+MADP;

            ResultSet rs = st.executeQuery(sql);

            
            ThanhToan2 hd;
            while (rs.next()) {
                hd = new ThanhToan2(rs.getInt("STT"), rs.getString("TENLOAIDV"), rs.getInt("SOLUONG"), rs.getInt("THOIHAN"), rs.getInt("GIALDV"), rs.getInt("TongTien"));

                //Thêm vào danh sách
                dshd.add(hd);
            }
        } catch (Exception ex) {
            showMessageDialog(this, "lỗi database");

        }
        
        
        return dshd;
     }
     
     public void hienThiDanhSachThanhToan2() {
        String colTieuDe1[] = new String[]{"STT", "Tên dịch vụ", "sô người", "số ngày", "Giá dịch vụ", "Tổng tiền"};
        ArrayList<ThanhToan2> dshd = layDanhSachThanhToan2();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dshd.size(); i++) {

            row = new Object[6];
          

            // GÁN GIÁ TRỊ
            row[0] = dshd.get(i).getSTT();
            row[1] = dshd.get(i).getTENLOAIDV();
            row[2] = dshd.get(i).getSOLUONG();
            row[3] = dshd.get(i).getTHOIHAN();
            row[4] = dshd.get(i).getGIALDV();
            row[5] = dshd.get(i).getTongTien();

            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTableThanhToan2.setModel(model);

    }
    
    /**
     * Creates new form thanhtoanform
     */
    public thanhtoanform() {
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        huy = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        thanhcong = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableThanhToan1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableThanhToan2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("Tình trạng");

        jLabel6.setText("jLabel6");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 0));
        jLabel10.setText("jLabel10");

        jLabel11.setText("Số tiền thanh toán");

        huy.setBackground(new java.awt.Color(255, 51, 51));
        huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THOAT.png"))); // NOI18N
        huy.setText("Hủy");
        huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Mã hóa đơn");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("jLabel14");

        thanhcong.setBackground(new java.awt.Color(0, 255, 0));
        thanhcong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/paymentsuccess.png"))); // NOI18N
        thanhcong.setText("Thanh Toán thành công");
        thanhcong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhcongActionPerformed(evt);
            }
        });

        jTableThanhToan1.setAutoCreateRowSorter(true);
        jTableThanhToan1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableThanhToan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableThanhToan1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableThanhToan1);

        jTableThanhToan2.setAutoCreateRowSorter(true);
        jTableThanhToan2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableThanhToan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableThanhToan2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableThanhToan2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(jLabel11)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(huy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(thanhcong)))
                .addGap(29, 29, 29))
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thanhcong)
                            .addComponent(huy))
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thanhcongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhcongActionPerformed
        int selected = JOptionPane.showConfirmDialog(this, "Thanh toán thành công?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
        try {
                Connection con = getConnection();
                Statement st = (Statement) con.createStatement();
                String query = "UPDATE hoadon set TINHTRANG = 'Đã thanh toán' where MAHD = " + "'" + MAHD + "'" ;
                String query2 = "UPDATE phong set MATTP = 3 where MAPHONG = (SELECT MAPHONG FROM khachsan.datphong where MADP = "+MADP+");";
                String query3 = "UPDATE datphong set TINHTRANG = 'Đã trả' where MADP = "+MADP ;
                st.executeUpdate(query);
                st.executeUpdate(query2);
                st.executeUpdate(query3);

            } catch (Exception ex) {

                showMessageDialog(this, "thông tin không hợp lệ");
            }
        this.dispose();
        }

    }//GEN-LAST:event_thanhcongActionPerformed

    private void huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyActionPerformed
        // TODO add your handling code here:
        huy.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_huyActionPerformed

    private void jTableThanhToan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableThanhToan1MouseClicked


    }//GEN-LAST:event_jTableThanhToan1MouseClicked

    private void jTableThanhToan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableThanhToan2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableThanhToan2MouseClicked

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
            java.util.logging.Logger.getLogger(thanhtoanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thanhtoanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thanhtoanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thanhtoanform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thanhtoanform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton huy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableThanhToan1;
    private javax.swing.JTable jTableThanhToan2;
    private javax.swing.JButton thanhcong;
    // End of variables declaration//GEN-END:variables
}
