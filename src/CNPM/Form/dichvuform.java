
package CNPM.Form;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import CNPM.DichVu;
import static CNPM.MyConnection.getConnection;
import java.sql.SQLException;
import javax.swing.JFrame;


public class dichvuform extends javax.swing.JFrame {

    /**
     * Creates new form dichvuform
     */
    public dichvuform() {
        initComponents();
        getConnection();
        hienThiDanhSachDichVu();
    }
    Connection con= null;
    Statement st= null;
    
        public ArrayList<DichVu> layDanhSachDichVu() {
        ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
        Connection con = getConnection();
        try {
            st = (Statement) con.createStatement();
            String sql = "SELECT MADP,(select TENKH from khachhang h where h.MAKH = (select MAKH from datphong dp where dp.MADP = dv.MADP)) as TENKH, (select TENPHONG from phong p where p.MAPHONG = (select MAPHONG from datphong dp where dp.MADP = dv.MADP)) as SOPHONG, MALDV, (select TENLOAIDV from loaidichvu l where l.MALDV = dv.MALDV) as TENLOAIDV, SOLUONG, THOIHAN, SOLUONG*THOIHAN*(SELECT GIALDV FROM loaidichvu l where l.MALDV = dv.MALDV) as GIATHANH  FROM khachsan.dichvu dv;";
            // Thưcj thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery(sql);

            DichVu dv;
            while (rs.next()) {
                dv = new DichVu(rs.getString("MADP"),rs.getString("TENKH"), rs.getString("SOPHONG"),rs.getString("MALDV"), rs.getString("TENLOAIDV"), rs.getInt("SOLUONG"), rs.getInt("THOIHAN"), rs.getInt("GIATHANH") );

                //Thêm vào danh sách
                dsdv.add(dv);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessageDialog(this, "lỗi database");

        }
        return dsdv;
    }
    public void hienThiDanhSachDichVu() {
        String colTieuDe1[] = new String[]{ "Mã đặp phòng","Tên khách hàng", "Số phòng", "Mã ldv", "Loại hình dịch vụ", "Số lượng", "Số ngày", "Giá dịch vụ"};
        ArrayList<DichVu> dsdv = layDanhSachDichVu();

        DefaultTableModel model = new DefaultTableModel(colTieuDe1, 0);

        Object[] row;

        for (int i = 0; i < dsdv.size(); i++) {

            row = new Object[8];

            // GÁN GIÁ TRỊ
            row[0] = dsdv.get(i).getMADP();
            row[1] = dsdv.get(i).getTENKH();
            row[2] = dsdv.get(i).getTENPHONG();
            row[3] = dsdv.get(i).getMALDV();
            row[4] = dsdv.get(i).getLOAIDV();
            row[5] = dsdv.get(i).getSOLUONG();
            row[6] = dsdv.get(i).getSONGAY();
            row[7] = dsdv.get(i).getGIATHANH();

            model.addRow(row);
        }
        
        //    }catch(ArrayIndexOutOfBoundsException ex){

        jTableDichvu.setModel(model);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        sophong = new javax.swing.JTextField();
        loaidv = new javax.swing.JTextField();
        soluong = new javax.swing.JTextField();
        them2 = new javax.swing.JButton();
        sua2 = new javax.swing.JButton();
        xoa2 = new javax.swing.JButton();
        thoat2 = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        songay = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tenkh = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        giadv = new javax.swing.JTextField();
        madp = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        maldv = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDichvu = new javax.swing.JTable();
        jButtonLoaiDV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));

        jPanel14.setBackground(new java.awt.Color(255, 204, 204));

        jLabel18.setBackground(new java.awt.Color(0, 0, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/dichvu.png"))); // NOI18N
        jLabel18.setText("DANH SÁCH DỊCH VỤ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Dịch Vụ"));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Số phòng");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Loại hình dịch vụ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Số lượng");

        sophong.setEditable(false);
        sophong.setBackground(new java.awt.Color(204, 204, 204));
        sophong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sophongActionPerformed(evt);
            }
        });

        loaidv.setEditable(false);
        loaidv.setBackground(new java.awt.Color(204, 204, 204));

        them2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THEM.png"))); // NOI18N
        them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them2ActionPerformed(evt);
            }
        });

        sua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/SUA.png"))); // NOI18N
        sua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sua2ActionPerformed(evt);
            }
        });

        xoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/delete.png"))); // NOI18N
        xoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa2ActionPerformed(evt);
            }
        });

        thoat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/THOAT.png"))); // NOI18N
        thoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat2ActionPerformed(evt);
            }
        });

        clear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/CLEAR.png"))); // NOI18N
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Số ngày");

        songay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songayActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Tên khách hàng");

        tenkh.setEditable(false);
        tenkh.setBackground(new java.awt.Color(204, 204, 204));
        tenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Giá dịch vụ");

        giadv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giadvActionPerformed(evt);
            }
        });

        madp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                madpActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Mã đặp phòng");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Mã loại dịch vụ");

        maldv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maldvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(them2)
                        .addGap(18, 18, 18)
                        .addComponent(sua2)
                        .addGap(18, 18, 18)
                        .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(thoat2))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(giadv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sophong, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maldv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(madp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loaidv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songay, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(madp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(sophong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(maldv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(loaidv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(songay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(16, 16, 16)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giadv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(32, 32, 32)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sua2)
                    .addComponent(clear2)
                    .addComponent(them2)
                    .addComponent(xoa2)
                    .addComponent(thoat2))
                .addContainerGap())
        );

        jTableDichvu.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDichvuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDichvu);

        jButtonLoaiDV.setBackground(new java.awt.Color(102, 255, 102));
        jButtonLoaiDV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonLoaiDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNPM/Form/hinh/loại dv.png"))); // NOI18N
        jButtonLoaiDV.setText("Loại dịch vụ");
        jButtonLoaiDV.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jButtonLoaiDVAncestorResized(evt);
            }
        });
        jButtonLoaiDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoaiDVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLoaiDV)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLoaiDV))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them2ActionPerformed
        // TODO add your handling code here:
        if(sophong.getText().equals("") || loaidv.getText().equals("") || soluong.getText().equals("") || madp.getText().equals("")  || giadv.getText().equals("")) {
                showMessageDialog(this, "Không có đủ thông tin");
                return;
        }
        Connection con = getConnection();
        try {
                
                Statement st = (Statement) con.createStatement();
                String query = "INSERT INTO dichvu(MADP,SOLUONG, THOIHAN, MALDV) VALUES("+ madp.getText() +","+ soluong.getText() +","+ songay.getText() +","+ maldv.getText() +")" ;
                st.executeUpdate(query);
                hienThiDanhSachDichVu();

            } catch (Exception ex) {
                try {
                Statement st = (Statement) con.createStatement();
                String query2 = "UPDATE dichvu set SOLUONG = SOLUONG + "+ soluong.getText() +" ,THOIHAN = THOIHAN + "+ songay.getText() +" where MADP = "+ madp.getText() +" and MALDV = "+ maldv.getText();
            
                st.executeUpdate(query2);
                hienThiDanhSachDichVu();
            } catch (SQLException ex1) {
            }
            }
    }//GEN-LAST:event_them2ActionPerformed

    private void sua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sua2ActionPerformed
        // TODO add your handling code here:
        if (jTableDichvu.getSelectedRow()==-1) {
            if (jTableDichvu.getRowCount()==0) {
                // lblError.setText("Table is empty");
            }
            else{
                //  lblError.setText("You must select a Tennis Player");
            }
        }
        else{
        if(sophong.getText().equals("") || loaidv.getText().equals("") || soluong.getText().equals("") || songay.getText().equals("") || madp.getText().equals("")  || giadv.getText().equals("")) {
                showMessageDialog(this, "Không có đủ thông tin");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) jTableDichvu.getModel();
            String old = model.getValueAt(jTableDichvu.getSelectedRow(), 0).toString();
            System.out.print(old);
            Connection con = getConnection();
            try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "UPDATE dichvu set MADP = "+ "'" +madp.getText()+ "'" +
                    ", SOLUONG =" + "'" +soluong.getText()+ "'" + 
                    ", THOIHAN =" + "'" +songay.getText()+  "'" +
                    ", MALDV =" + "'" +maldv.getText()+  "'" +
                    " where MADP = "+ madp.getText() +" and MALDV = "+ maldv.getText();
            
                    
            st.executeUpdate(query);
            hienThiDanhSachDichVu();

        } catch (Exception ex) {

            showMessageDialog(this, "thông tin không hợp lệ");
        }
        
        }


    }//GEN-LAST:event_sua2ActionPerformed

    private void xoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa2ActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "DELETE FROM dichvu where MADP = "+ madp.getText() +" and MALDV = "+ maldv.getText();
            st.executeUpdate(query);
            hienThiDanhSachDichVu();

        } catch (Exception ex) {

            showMessageDialog(this, "thông tin không hợp lệ");
        }
    }//GEN-LAST:event_xoa2ActionPerformed

    private void thoat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat2ActionPerformed
        // TODO add your handling code here:
        thoat2.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }

    }//GEN-LAST:event_thoat2ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        // TODO add your handling code here:
        madp.setText("");
        tenkh.setText("");
        sophong.setText("");
        maldv.setText("");
        loaidv.setText("");
        soluong.setText("");
        songay.setText("");
        giadv.setText("");
    }//GEN-LAST:event_clear2ActionPerformed

    private void jTableDichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDichvuMouseClicked
        // TODO add your handling code here
        int i = jTableDichvu.getSelectedRow();
        TableModel model = jTableDichvu.getModel();
        madp.setText(model.getValueAt(i, 0).toString());
        tenkh.setText(model.getValueAt(i, 1).toString());
        sophong.setText(model.getValueAt(i, 2).toString());
        maldv.setText(model.getValueAt(i, 3).toString());
        loaidv.setText(model.getValueAt(i, 4).toString());
        soluong.setText(model.getValueAt(i, 5).toString());
        songay.setText(model.getValueAt(i, 6).toString());
        giadv.setText(model.getValueAt(i, 7).toString());
        
    }//GEN-LAST:event_jTableDichvuMouseClicked

    private void sophongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sophongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sophongActionPerformed

    private void songayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_songayActionPerformed

    private void tenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhActionPerformed

    private void giadvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giadvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giadvActionPerformed

    private void jButtonLoaiDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoaiDVActionPerformed
        // TODO add your handling code here:
        Loaidichvuform ldvf = new Loaidichvuform();
        ldvf.setVisible(true);
        ldvf.pack();
        ldvf.setLocationRelativeTo(null);
        ldvf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonLoaiDVActionPerformed

    private void jButtonLoaiDVAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jButtonLoaiDVAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLoaiDVAncestorResized

    private void madpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_madpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_madpActionPerformed

    private void maldvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maldvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maldvActionPerformed

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
            java.util.logging.Logger.getLogger(dichvuform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dichvuform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dichvuform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dichvuform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dichvuform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear2;
    private javax.swing.JTextField giadv;
    private javax.swing.JButton jButtonLoaiDV;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDichvu;
    private javax.swing.JTextField loaidv;
    private javax.swing.JTextField madp;
    private javax.swing.JTextField maldv;
    private javax.swing.JTextField soluong;
    private javax.swing.JTextField songay;
    private javax.swing.JTextField sophong;
    private javax.swing.JButton sua2;
    private javax.swing.JTextField tenkh;
    private javax.swing.JButton them2;
    private javax.swing.JButton thoat2;
    private javax.swing.JButton xoa2;
    // End of variables declaration//GEN-END:variables
}