package com.raven.swing.tablequanly.cell;

import com.raven.dialog.*;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.Sach;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Color;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class DialogSach extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;

    public DialogSach(java.awt.Frame parent, boolean modal, ChiTietSach cts) {
        super(parent, modal);
        initComponents();
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                if (cts != null) {
                    Sach s = SachDAO.getInstance().selectByIDCTS(cts.getIdChiTietSach());
                    if (s != null) {
                        lbTenSach.setText(s.getTenSach());
                        try {
                            ImageIcon icon = new ImageIcon(getClass().getResource("/com/raven/icon/book_images/" + s.getIdSach() + ".jpg"));
                        if (icon != null) {
                            pic.setIcon(icon);
                        }
                        } catch (Exception e) {
                            System.out.println("Lỗi cast icon");
                        }
                    }
                    lbIDCTS.setText(cts.getIdChiTietSach());
                    lbTheLoai.setText(cts.getStringTheLoai());
                    lbNam.setText(cts.getNamPhatHanh() + "");
                    lbTacGia.setText(cts.getStringTacGia());
                    lbNXB.setText(cts.getNhaXuatBan());
                    lbNgonNgu.setText(cts.getNgonNgu());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    if (cts.getNgayNhap() != null) {
                        lbNgayNhap.setText(sdf.format(cts.getNgayNhap().getTime()));
                    }
                    lbGiaTien.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN"))
                            .format(cts.getGiaTien()));
                    lbTrangThai.setText(cts.getTrangThai());
                    lbViTri.setText(s.getViTri());
                }
                Thread.sleep(100);
                return 12;
            }
        };
        // Thực thi SwingWorker
        worker.execute();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }
        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }

    //STT bắt đầu từ 0
    public void showSach() {
        animator.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        pic = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbTenSach = new javax.swing.JLabel();
        button2 = new com.raven.swing.customswing.buttomcustom.Button();
        lbMessage1 = new javax.swing.JLabel();
        lbMessage2 = new javax.swing.JLabel();
        lbIDCTS = new javax.swing.JLabel();
        lbTheLoai = new javax.swing.JLabel();
        lbMessage3 = new javax.swing.JLabel();
        lbNam = new javax.swing.JLabel();
        lbMessage4 = new javax.swing.JLabel();
        imageAvartaSquare4 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage5 = new javax.swing.JLabel();
        imageAvartaSquare5 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbTacGia = new javax.swing.JLabel();
        imageAvartaSquare6 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage6 = new javax.swing.JLabel();
        lbNXB = new javax.swing.JLabel();
        imageAvartaSquare7 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage7 = new javax.swing.JLabel();
        lbNgonNgu = new javax.swing.JLabel();
        imageAvartaSquare8 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare9 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare10 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage8 = new javax.swing.JLabel();
        lbNgayNhap = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        imageAvartaSquare11 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage9 = new javax.swing.JLabel();
        lbGiaTien = new javax.swing.JLabel();
        imageAvartaSquare12 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage10 = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        imageAvartaSquare13 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage11 = new javax.swing.JLabel();
        lbViTri = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        lbMessage.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage.setText("Tên sách:");

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icon_book_50px.png"))); // NOI18N

        lbTenSach.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbTenSach.setForeground(new java.awt.Color(82, 82, 82));

        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 161, 38)));
        button2.setForeground(new java.awt.Color(66, 66, 66));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png"))); // NOI18N
        button2.setText("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        lbMessage1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbMessage1.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage1.setText("THÔNG SINH SÁCH");

        lbMessage2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage2.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage2.setText("Mã sách:");

        lbIDCTS.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbIDCTS.setForeground(new java.awt.Color(82, 82, 82));

        lbTheLoai.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbTheLoai.setForeground(new java.awt.Color(82, 82, 82));

        lbMessage3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage3.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage3.setText("Thể loại:");

        lbNam.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbNam.setForeground(new java.awt.Color(82, 82, 82));

        lbMessage4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage4.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage4.setText("Năm:");

        imageAvartaSquare4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/university_40px.png"))); // NOI18N

        lbMessage5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage5.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage5.setText("Tác giả:");

        imageAvartaSquare5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/collaborator_male_skin_type_2_50px.png"))); // NOI18N

        lbTacGia.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbTacGia.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/christmas_star_25px.png"))); // NOI18N

        lbMessage6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage6.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage6.setText("NXB:");

        lbNXB.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbNXB.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/language_50px.png"))); // NOI18N

        lbMessage7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage7.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage7.setText("Ngôn ngữ:");

        lbNgonNgu.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbNgonNgu.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/identity_theft_50px.png"))); // NOI18N

        imageAvartaSquare9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/membership_card_50px.png"))); // NOI18N

        imageAvartaSquare10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_50px.png"))); // NOI18N

        lbMessage8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage8.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage8.setText("Ngày nhập:");

        lbNgayNhap.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbNgayNhap.setForeground(new java.awt.Color(82, 82, 82));

        jSeparator1.setForeground(new java.awt.Color(75, 134, 253));

        jSeparator2.setForeground(new java.awt.Color(75, 134, 253));

        imageAvartaSquare11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/us_dollar_circled_50px.png"))); // NOI18N

        lbMessage9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage9.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage9.setText("Giá tiền:");

        lbGiaTien.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbGiaTien.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/signal_50px.png"))); // NOI18N

        lbMessage10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage10.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage10.setText("Trạng thái:");

        lbTrangThai.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/inbox_40px.png"))); // NOI18N

        lbMessage11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage11.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage11.setText("Vị trí:");

        lbViTri.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbViTri.setForeground(new java.awt.Color(82, 82, 82));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageAvartaSquare5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageAvartaSquare4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageAvartaSquare8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageAvartaSquare9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageAvartaSquare6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageAvartaSquare7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imageAvartaSquare11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(imageAvartaSquare10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(imageAvartaSquare12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(imageAvartaSquare13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addGap(8, 8, 8)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbMessage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbMessage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbMessage5)
                                                    .addComponent(lbMessage7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbMessage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbMessage8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbMessage9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lbMessage2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                                .addComponent(lbMessage10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbGiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbNgonNgu, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                        .addGap(9, 9, 9))
                                    .addComponent(lbNXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                        .addGap(10, 10, 10))
                                    .addComponent(lbNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbIDCTS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbTenSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                                        .addGap(12, 12, 12))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbMessage11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbViTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIDCTS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageAvartaSquare8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMessage3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvartaSquare9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMessage4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvartaSquare4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvartaSquare5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMessage5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvartaSquare6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imageAvartaSquare7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lbMessage8, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(imageAvartaSquare10, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbMessage9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvartaSquare11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvartaSquare13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessage10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvartaSquare12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        closeMenu();
    }//GEN-LAST:event_button2ActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.Button button2;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare10;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare11;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare12;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare13;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare4;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare5;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare6;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare7;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare8;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbGiaTien;
    private javax.swing.JLabel lbIDCTS;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbMessage10;
    private javax.swing.JLabel lbMessage11;
    private javax.swing.JLabel lbMessage2;
    private javax.swing.JLabel lbMessage3;
    private javax.swing.JLabel lbMessage4;
    private javax.swing.JLabel lbMessage5;
    private javax.swing.JLabel lbMessage6;
    private javax.swing.JLabel lbMessage7;
    private javax.swing.JLabel lbMessage8;
    private javax.swing.JLabel lbMessage9;
    private javax.swing.JLabel lbNXB;
    private javax.swing.JLabel lbNam;
    private javax.swing.JLabel lbNgayNhap;
    private javax.swing.JLabel lbNgonNgu;
    private javax.swing.JLabel lbTacGia;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JLabel lbTheLoai;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JLabel lbViTri;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare pic;
    // End of variables declaration//GEN-END:variables
}
