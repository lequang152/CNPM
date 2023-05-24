

package CNPM.Form;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import CNPM.HoaDon;
import CNPM.KhachHang;
import static CNPM.MyConnection.getConnection;
import CNPM.Phong;
import CNPM.HoaDon2;

public class hoadonform extends javax.swing.JFrame {

    /**
     * Creates new form hoadonform
     */
    public hoadonform() {
        initComponents();
        getConnection();
        layThongtinMa();
        hienThiDanhSachHoaDon();
        hienThiDanhSachHoaDon2();
        jTextFieldNGAY.setDate(new java.util.Date());
        
    }
    
    Connection con=null;
    Statement st=null;
    private int maxmahd = 1;
    
    public void layThongtinMa() {
        Connection con = getConnection();
        try {
            Statement st = (Statement) con.createStatement();
            String sql = "SELECT max(MAHD) as MAXMAHD FROM hoadon;"; 
            // Thưcj thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maxmahd = rs.getInt("MAXMAHD") +1;
            }
            jTextFieldMAHD.setText(String.valueOf(maxmahd));
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessageDialog(this, "lỗi database");

        }
       }
    
    public ArrayList<HoaDon> layDanhSachHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT * FROM hoadon";

            ResultSet rs = st.executeQuery(sql);

            
            HoaDon hd;
            while (rs.next()) {
                hd = new HoaDon(rs.getString("MAHD"), rs.getDate("NGAY"), rs.getInt("GIAHD"), rs.getString("TinhTrang"), rs.getString("MADP"));

                //Thêm vào danh sách
                dshd.add(hd);
            }
        } catch (Exception ex) {
            showMessageDialog(this, "lỗi database");

        }
        
        
        return dshd;
    }
     public void hienThiDanhSachHoaDon() {
        String colTieuDe1[] = new String[]{"Mã Hóa Đơn", "Ngày", "Giá Hóa Đơn", "Tình trạng", "Mã Đặt Phòng"};
        ArrayList<HoaDon> dshd = layDanhSachHoaDon();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dshd.size(); i++) {

            row = new Object[5];
          

            // GÁN GIÁ TRỊ
            row[0] = dshd.get(i).getMAHD();
            row[1] = dshd.get(i).getNGAY();
            row[2] = dshd.get(i).getGIAHD();
            row[3] = dshd.get(i).getTINHTRANG();
            row[4] = dshd.get(i).getMADP();

            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTableHOADON.setModel(model);

    }
     
    public ArrayList<HoaDon2> layDanhSachHoaDon2() {
        ArrayList<HoaDon2> dskh = new ArrayList<HoaDon2>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT MADP,(SELECT TENPHONG FROM phong p where p.MAPHONG=D.MAPHONG) as TENPHONG ,(SELECT (select GIAPHONG + (select Gia from sogiuong s where s.MASG = p.MASG) from loaiphong l where p.MALP = l.MALP) FROM phong p where p.MAPHONG = d.MAPHONG) as GIAPHONG, (TIMESTAMPDIFF(day,NGAYNHAN,NGAYTRA) +1) as SONGAY, (select Sum(SOLUONG*THOIHAN*(SELECT GIALDV FROM loaidichvu l where l.MALDV = dv.MALDV)) FROM dichvu dv where dv.MADP = d.MADP) GIADV from datphong d join phong p on p.MAPHONG = d.MAPHONG where p.MATTP = 2;";
            // Thưcj thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery(sql);

            HoaDon2 kh;
            while (rs.next()) {
                kh = new HoaDon2(rs.getInt("MADP"), rs.getString("TENPHONG"),rs.getInt("GIAPHONG"),rs.getInt("SONGAY"),rs.getInt("GIADV"));

                //Thêm vào danh sách
                dskh.add(kh);
            }
        } catch (Exception ex) {
            showMessageDialog(this, "lỗi database");

        }
        return dskh;
    }
     public void hienThiDanhSachHoaDon2() {
        String colTieuDe1[] = new String[]{"Mã đặt phòng","Tên phòng","Giá Phòng", "Số ngày", "Giá dv"};
        ArrayList<HoaDon2> dskh = layDanhSachHoaDon2();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dskh.size(); i++) {

            row = new Object[5];

            // GÁN GIÁ TRỊ
            row[0] = dskh.get(i).getMADP();
            row[1] = dskh.get(i).getTENPHONG();
            row[2] = dskh.get(i).getGIAPHONG();
            row[3] = dskh.get(i).getSONGAY();
            row[4] = dskh.get(i).getGIADV();

            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTableHoaDon2.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldMAHD = new javax.swing.JTextField();
        jTextFieldMADP = new javax.swing.JTextField();
        jTextFieldGIAHD = new javax.swing.JTextField();
        them4 = new javax.swing.JButton();
        sua4 = new javax.swing.JButton();
        xoa4 = new javax.swing.JButton();
        thoat4 = new javax.swing.JButton();
        jButtonclear4 = new javax.swing.JButton();
        jTextFieldNGAY = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldTINHTRANG = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHoaDon2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHOADON = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Hóa Đơn"));

        jLabel32.setText("Mã Hóa Đơn");

        jLabel34.setText("Mã Đặt phòng");

        jLabel35.setText("Ngày");

        jLabel36.setText("Giá Hóa Đơn");

        jTextFieldMAHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMAHDActionPerformed(evt);
            }
        });

        jTextFieldMADP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMADPActionPerformed(evt);
            }
        });

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

        jButtonclear4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/CLEAR.png"))); // NOI18N
        jButtonclear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclear4ActionPerformed(evt);
            }
        });

        jTextFieldNGAY.setDateFormatString("dd/MM/yyyy");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/receipt.png"))); // NOI18N
        jButton1.setText("Thanh toán");
        jButton1.setMaximumSize(new java.awt.Dimension(321, 233));
        jButton1.setMinimumSize(new java.awt.Dimension(321, 233));
        jButton1.setPreferredSize(new java.awt.Dimension(321, 233));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel37.setText("Tình trạng");
        jLabel37.setToolTipText("");

        jTextFieldTINHTRANG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTINHTRANGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldTINHTRANG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel35)
                                .addComponent(jLabel36)
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addComponent(them4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sua4))
                                .addComponent(jLabel34))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldGIAHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel21Layout.createSequentialGroup()
                                            .addComponent(jButtonclear4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(xoa4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(thoat4))
                                        .addComponent(jTextFieldMAHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNGAY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTextFieldMADP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jTextFieldNGAY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(6, 6, 6))
                    .addComponent(jTextFieldGIAHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldTINHTRANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37)))
                .addGap(9, 9, 9)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jTextFieldMADP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sua4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonclear4)
                        .addComponent(them4))
                    .addComponent(xoa4)
                    .addComponent(thoat4))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTableHoaDon2.setAutoCreateRowSorter(true);
        jTableHoaDon2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHoaDon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHoaDon2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableHoaDon2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/refresh.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableHOADON.setAutoCreateRowSorter(true);
        jTableHOADON.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHOADON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHOADONMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableHOADON);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/hoadon.png"))); // NOI18N
        jLabel31.setText("HÓA ĐƠN");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Danh sách phòng đang thuê");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1)
                        .addGap(430, 430, 430))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5)))))
                .addGap(74, 74, 74))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(61, 61, 61)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHOADONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHOADONMouseClicked
        // TODO add your handling code here:
        int i = jTableHOADON.getSelectedRow();
        TableModel model = jTableHOADON.getModel();;
        jTextFieldMAHD.setText(model.getValueAt(i, 0).toString());
        jTextFieldNGAY.setDate(new java.util.Date());
        jTextFieldGIAHD.setText(model.getValueAt(i, 2).toString());
        jTextFieldTINHTRANG.setText(model.getValueAt(i, 3).toString());
        jTextFieldMADP.setText(model.getValueAt(i, 4).toString());
        

    }//GEN-LAST:event_jTableHOADONMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        hienThiDanhSachHoaDon();
        hienThiDanhSachHoaDon2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableHoaDon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHoaDon2MouseClicked

        jTextFieldMAHD.requestFocus();

        jTextFieldNGAY.setDate(new java.util.Date());

        int i = jTableHoaDon2.getSelectedRow();
        TableModel model = jTableHoaDon2.getModel();
        jTextFieldTINHTRANG.setText("Chưa thanh toán");
        jTextFieldGIAHD.setText(Integer.toString(Integer.valueOf(model.getValueAt(i, 2).toString())*
                 Integer.valueOf(model.getValueAt(i, 3).toString())
                +Integer.valueOf(model.getValueAt(i, 4).toString())));
        jTextFieldMADP.setText(model.getValueAt(i, 0).toString());
        
    }//GEN-LAST:event_jTableHoaDon2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            thanhtoanform tt = new thanhtoanform(jTextFieldMAHD.getText(),  new SimpleDateFormat( "dd/MM/yyyy" ).format(jTextFieldNGAY.getCalendar().getTime()), jTextFieldGIAHD.getText(), jTextFieldTINHTRANG.getText(), jTextFieldMADP.getText());
            tt.setVisible(true);
            tt.pack();
            tt.setLocationRelativeTo(null);
            tt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonclear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclear4ActionPerformed
        // TODO add your handling code here:
        jTextFieldTINHTRANG.setText("");
        jTextFieldMADP.setText("");
        jTextFieldNGAY.setCalendar(null);
        jTextFieldGIAHD.setText("");
        jTextFieldMAHD.requestFocus();
    }//GEN-LAST:event_jButtonclear4ActionPerformed

    private void thoat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat4ActionPerformed
        // TODO add your handling code here:
        thoat4.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_thoat4ActionPerformed

    private void xoa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa4ActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "DELETE FROM hoadon WHERE MAHD = '" + jTextFieldMAHD.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachHoaDon();

        } catch (Exception ex) {

            showMessageDialog(this, "thông tin không hợp lệ");
        }
    }//GEN-LAST:event_xoa4ActionPerformed

    private void sua4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua4ActionPerformed
        // TODO add your handling code here:
        if (jTableHOADON.getSelectedRow()==-1) {
            if (jTableHOADON.getRowCount()==0) {
                // lblError.setText("Table is empty");
            }
            else{
                //  lblError.setText("You must select a Tennis Player");
            }
        }
        else{
            if(jTextFieldMAHD.getText().equals("") || jTextFieldTINHTRANG.getText().equals("") || jTextFieldMADP.getText().equals("") || jTextFieldNGAY.toString().equals("") || jTextFieldGIAHD.getText().equals("")) {
                showMessageDialog(null, "Không có đủ thông tin");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) jTableHOADON.getModel();
            String old = model.getValueAt(jTableHOADON.getSelectedRow(), 0).toString();
            System.out.print(old);
            Connection con = getConnection();
            try {
                // Tạo một đối tượng để thực hiện công việc
                st = (Statement) con.createStatement();
                String query = "UPDATE hoadon set MAHD = "+ "'" +jTextFieldMAHD.getText()+ "'" +
                ", MADP =" + "'" +jTextFieldMADP.getText()+ "'" +
                ", TINHTRANG =" + "'" +jTextFieldTINHTRANG.getText()+  "'" +
                ", NGAY = " + "'" +new java.sql.Date(jTextFieldNGAY.getDate().getTime())+ "'" +
                ",GIAHD =" + "'" +jTextFieldGIAHD.getText()+  "'" +
                " where MAHD = " + "'" + old + "'" ;

                st.executeUpdate(query);
                hienThiDanhSachHoaDon();

            } catch (Exception ex) {

                showMessageDialog(this, "thông tin không hợp lệ");
            }

        }

    }//GEN-LAST:event_sua4ActionPerformed

    private void them4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them4ActionPerformed
        // TODO add your handling code here:
        if(jTextFieldMAHD.getText().equals("") || jTextFieldTINHTRANG.getText().equals("") || jTextFieldMADP.getText().equals("") || jTextFieldNGAY.toString().equals("") || jTextFieldGIAHD.getText().equals("")) {
            showMessageDialog(this, "Không có đủ thông tin");
            return;
        }

        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "INSERT INTO hoadon(MAHD,TINHTRANG, MADP, NGAY, GIAHD) VALUES('" + jTextFieldMAHD.getText() + "',"
            + "'" + jTextFieldTINHTRANG.getText() + "','" + jTextFieldMADP.getText() + "', '" + new java.sql.Date(jTextFieldNGAY.getDate().getTime()) + "', '" + jTextFieldGIAHD.getText() + "')";
            st.execute(query);
            hienThiDanhSachHoaDon();

        } catch (Exception ex) {
            showMessageDialog(this, "thông tin không hợp lệ");
        }
    }//GEN-LAST:event_them4ActionPerformed

    private void jTextFieldMADPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMADPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMADPActionPerformed

    private void jTextFieldMAHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMAHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMAHDActionPerformed

    private void jTextFieldTINHTRANGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTINHTRANGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTINHTRANGActionPerformed

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
            java.util.logging.Logger.getLogger(hoadonform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hoadonform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hoadonform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hoadonform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hoadonform().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonclear4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableHOADON;
    private javax.swing.JTable jTableHoaDon2;
    private javax.swing.JTextField jTextFieldGIAHD;
    private javax.swing.JTextField jTextFieldMADP;
    private javax.swing.JTextField jTextFieldMAHD;
    private com.toedter.calendar.JDateChooser jTextFieldNGAY;
    private javax.swing.JTextField jTextFieldTINHTRANG;
    private javax.swing.JButton sua4;
    private javax.swing.JButton them4;
    private javax.swing.JButton thoat4;
    private javax.swing.JButton xoa4;
    // End of variables declaration//GEN-END:variables
}
