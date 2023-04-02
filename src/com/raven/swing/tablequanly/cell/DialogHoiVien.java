package com.raven.swing.tablequanly.cell;

import com.raven.dialog.*;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.modeldata.HoiVien;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class DialogHoiVien extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;

    public DialogHoiVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        lbIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REPORT_PROBLEM, 60, new Color(254, 86, 96), new Color(113, 74, 67)));
//        lbIcon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/2.png")));
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbNam);
        bg.add(rbNu);
        setOpacity(0f);
        getContentPane().setBackground(Color.WHITE);
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

    public void showHoiVienInFo(String idHoiVien) {
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                HoiVien hv = HoiVienDAO.getInstance().selectByID(idHoiVien);
                if (hv != null) {
                    lbHoTen.setText(hv.getHoTen());
                    lbMSHV.setText(hv.getIdHoiVien());
                    lbMSSV.setText(hv.getMaSV());
                    lbLop.setText(hv.getLop());
                    if (!hv.isGioiTinh()) {
                        rbNu.setSelected(true);
                    }
                    lbSDT.setText(hv.getSdt());
                    lbEmail.setText(hv.getEmail());
                    lbTrangThai.setText(hv.getTrangThai());
                    lbSachDaMuon.setText(HoiVienDAO.getInstance().getSoLuongSachDaMuon(hv.getIdHoiVien())+"");
                    lbChuaTra.setText(HoiVienDAO.getInstance().getSoLuongSachChuaTra(hv.getIdHoiVien())+"");
                }              
                Thread.sleep(5000);
                return 12;
            }
        };
        // Thực thi SwingWorker
        worker.execute();

        animator.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        imageAvartaSquare1 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbHoTen = new javax.swing.JLabel();
        button2 = new com.raven.swing.customswing.buttomcustom.Button();
        lbMessage1 = new javax.swing.JLabel();
        lbMessage2 = new javax.swing.JLabel();
        lbMSSV = new javax.swing.JLabel();
        lbMSHV = new javax.swing.JLabel();
        lbMessage3 = new javax.swing.JLabel();
        lbLop = new javax.swing.JLabel();
        lbMessage4 = new javax.swing.JLabel();
        imageAvartaSquare4 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage5 = new javax.swing.JLabel();
        imageAvartaSquare5 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare6 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage6 = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        imageAvartaSquare7 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage7 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        imageAvartaSquare8 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare9 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare10 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage8 = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        imageAvartaSquare11 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage9 = new javax.swing.JLabel();
        lbSachDaMuon = new javax.swing.JLabel();
        imageAvartaSquare12 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage10 = new javax.swing.JLabel();
        lbChuaTra = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        lbMessage.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage.setText("Họ tên:");

        imageAvartaSquare1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ID_50px.png"))); // NOI18N

        lbHoTen.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbHoTen.setForeground(new java.awt.Color(82, 82, 82));

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
        lbMessage1.setText("THÔNG SINH HỘI VIÊN");

        lbMessage2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage2.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage2.setText("Mã hội viên:");

        lbMSSV.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMSSV.setForeground(new java.awt.Color(82, 82, 82));

        lbMSHV.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMSHV.setForeground(new java.awt.Color(82, 82, 82));

        lbMessage3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage3.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage3.setText("Mã sinh viên:");

        lbLop.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbLop.setForeground(new java.awt.Color(82, 82, 82));

        lbMessage4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage4.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage4.setText("Lớp:");

        imageAvartaSquare4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/university_40px.png"))); // NOI18N

        lbMessage5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage5.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage5.setText("Giới tính:");

        imageAvartaSquare5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/christmas_star_50px.png"))); // NOI18N

        imageAvartaSquare6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/phone_50px.png"))); // NOI18N

        lbMessage6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage6.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage6.setText("SĐT:");

        lbSDT.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/mail_50px.png"))); // NOI18N

        lbMessage7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage7.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage7.setText("Email:");

        lbEmail.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/identity_theft_50px.png"))); // NOI18N

        imageAvartaSquare9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/membership_card_50px.png"))); // NOI18N

        imageAvartaSquare10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/signal_50px.png"))); // NOI18N

        lbMessage8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage8.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage8.setText("Trạng thái:");

        lbTrangThai.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(82, 82, 82));

        jSeparator1.setForeground(new java.awt.Color(75, 134, 253));

        jSeparator2.setForeground(new java.awt.Color(75, 134, 253));

        imageAvartaSquare11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/homework_50px.png"))); // NOI18N

        lbMessage9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage9.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage9.setText("Sách đã mượn:");

        lbSachDaMuon.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbSachDaMuon.setForeground(new java.awt.Color(82, 82, 82));

        imageAvartaSquare12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/man_reading_a_book_50px.png"))); // NOI18N

        lbMessage10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage10.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage10.setText("Sách chưa trả:");

        lbChuaTra.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbChuaTra.setForeground(new java.awt.Color(82, 82, 82));

        rbNam.setSelected(true);
        rbNam.setText("Nam");

        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imageAvartaSquare5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare9, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(imageAvartaSquare11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(imageAvartaSquare10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(imageAvartaSquare12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(imageAvartaSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMessage8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMessage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMessage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMessage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMessage7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMessage5))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMessage9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbChuaTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSachDaMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMSHV, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbNam)
                                .addGap(17, 17, 17)
                                .addComponent(rbNu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lbLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
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
                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvartaSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMessage3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbMSHV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvartaSquare9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMessage4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvartaSquare4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvartaSquare5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNam)
                        .addComponent(rbNu))
                    .addComponent(lbMessage5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageAvartaSquare7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageAvartaSquare6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lbMessage8, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(imageAvartaSquare10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvartaSquare11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSachDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvartaSquare12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbChuaTra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.Button button2;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare1;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare10;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare11;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare12;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare4;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare5;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare6;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare7;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare8;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbChuaTra;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbLop;
    private javax.swing.JLabel lbMSHV;
    private javax.swing.JLabel lbMSSV;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbMessage10;
    private javax.swing.JLabel lbMessage2;
    private javax.swing.JLabel lbMessage3;
    private javax.swing.JLabel lbMessage4;
    private javax.swing.JLabel lbMessage5;
    private javax.swing.JLabel lbMessage6;
    private javax.swing.JLabel lbMessage7;
    private javax.swing.JLabel lbMessage8;
    private javax.swing.JLabel lbMessage9;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbSachDaMuon;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    // End of variables declaration//GEN-END:variables
}
