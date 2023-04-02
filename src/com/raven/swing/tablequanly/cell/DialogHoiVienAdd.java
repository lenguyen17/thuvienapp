package com.raven.swing.tablequanly.cell;

import com.raven.dialog.*;
import static com.raven.main.Main.fram;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.modeldata.HoiVien;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.notification.Notification;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

@SuppressWarnings("unchecked")
public class DialogHoiVienAdd extends javax.swing.JDialog {

    private final Animator animator;
    private boolean show = true;

    public DialogHoiVienAdd(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbNam);
        bg.add(rbNu);
        setOpacity(0f);
        // Combobox Trang Thai
        comboBox_TrangThai.addItem("Sẵn sàng");
        comboBox_TrangThai.addItem("Đang mượn");
        comboBox_TrangThai.addItem("Khóa");
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

    public void showTheHVMoi() {
        animator.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        imageAvartaSquare1 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        cmdSave = new com.raven.swing.customswing.buttomcustom.Button();
        lbMessage1 = new javax.swing.JLabel();
        lbMessage2 = new javax.swing.JLabel();
        lbMessage3 = new javax.swing.JLabel();
        lbMessage4 = new javax.swing.JLabel();
        imageAvartaSquare4 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage5 = new javax.swing.JLabel();
        imageAvartaSquare5 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare6 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage6 = new javax.swing.JLabel();
        imageAvartaSquare7 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage7 = new javax.swing.JLabel();
        imageAvartaSquare8 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare9 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        imageAvartaSquare10 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        lbMessage8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        textField_hoTen = new com.raven.swing.messagedialog.textFieldCustom();
        textField_MSSV = new com.raven.swing.messagedialog.textFieldCustom();
        textField_MSHV = new com.raven.swing.messagedialog.textFieldCustom();
        textField_Lop = new com.raven.swing.messagedialog.textFieldCustom();
        textField_SDT = new com.raven.swing.messagedialog.textFieldCustom();
        textField_email = new com.raven.swing.messagedialog.textFieldCustom();
        cmdHuy1 = new com.raven.swing.customswing.buttomcustom.Button();
        comboBox_TrangThai = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        lbMessage.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage.setText("Họ tên:");

        imageAvartaSquare1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ID_50px.png"))); // NOI18N

        cmdSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 161, 38)));
        cmdSave.setForeground(new java.awt.Color(66, 66, 66));
        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png"))); // NOI18N
        cmdSave.setText("Lưu mới");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        lbMessage1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbMessage1.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage1.setText("THÔNG SINH HỘI VIÊN");

        lbMessage2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage2.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage2.setText("Mã sinh viên:");

        lbMessage3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage3.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage3.setText("Mã hội viên:");

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

        imageAvartaSquare7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/mail_50px.png"))); // NOI18N

        lbMessage7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage7.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage7.setText("Email:");

        imageAvartaSquare8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/identity_theft_50px.png"))); // NOI18N

        imageAvartaSquare9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/membership_card_50px.png"))); // NOI18N

        imageAvartaSquare10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/signal_50px.png"))); // NOI18N

        lbMessage8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage8.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage8.setText("Trạng thái:");

        jSeparator1.setForeground(new java.awt.Color(75, 134, 253));

        jSeparator2.setForeground(new java.awt.Color(75, 134, 253));

        rbNam.setSelected(true);
        rbNam.setText("Nam");

        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        textField_hoTen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_hoTen.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_hoTen.setLabelText("");
        textField_hoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_hoTenActionPerformed(evt);
            }
        });

        textField_MSSV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_MSSV.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_MSSV.setLabelText("");
        textField_MSSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_MSSVActionPerformed(evt);
            }
        });

        textField_MSHV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_MSHV.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_MSHV.setLabelText("");
        textField_MSHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_MSHVActionPerformed(evt);
            }
        });

        textField_Lop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_Lop.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_Lop.setLabelText("");
        textField_Lop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_LopActionPerformed(evt);
            }
        });

        textField_SDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_SDT.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_SDT.setLabelText("");
        textField_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SDTActionPerformed(evt);
            }
        });

        textField_email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_email.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_email.setLabelText("");
        textField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_emailActionPerformed(evt);
            }
        });

        cmdHuy1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        cmdHuy1.setForeground(new java.awt.Color(66, 66, 66));
        cmdHuy1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cancel_22px.png"))); // NOI18N
        cmdHuy1.setText("Hủy bỏ");
        cmdHuy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHuy1ActionPerformed(evt);
            }
        });

        comboBox_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_TrangThaiActionPerformed(evt);
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
                .addComponent(cmdHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(imageAvartaSquare10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageAvartaSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage5)
                            .addComponent(lbMessage4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMessage8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 37, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbMessage7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbMessage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbNam)
                                        .addGap(17, 17, 17)
                                        .addComponent(rbNu))
                                    .addComponent(textField_MSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField_MSHV, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(15, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textField_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                        .addComponent(textField_hoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textField_SDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(comboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(textField_hoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_MSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imageAvartaSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(imageAvartaSquare8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMessage3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_MSHV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvartaSquare9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMessage4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvartaSquare4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageAvartaSquare5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage5, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(rbNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageAvartaSquare7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbMessage7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(imageAvartaSquare6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMessage8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imageAvartaSquare10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        if (kiemTraNhapLieu()) {
            if (HoiVienDAO.getInstance().selectByID(textField_MSHV.getText()) == null) {
                try {
                    HoiVien newHV = getHoiVienEditted();
                    if (newHV != null) {
                        HoiVienDAO.getInstance().insert(newHV);
                    }
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Đã thêm một hội viên mới.");
                    noti.showNotification();
                } catch (Exception e) {
                    Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Thêm hội viên thất bại, vui lòng thử lại sau.");
                    noti.showNotification();
                }
                closeMenu();
            } else {
                Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Mã hội viên đã tồn tại.");
                noti.showNotification();
            }
        } else {
            Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Bạn chưa nhập đủ dữ liệu.");
            noti.showNotification();
        }
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuActionPerformed

    private void textField_hoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_hoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_hoTenActionPerformed

    private void textField_MSSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_MSSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_MSSVActionPerformed

    private void textField_MSHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_MSHVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_MSHVActionPerformed

    private void textField_LopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_LopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_LopActionPerformed

    private void textField_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SDTActionPerformed

    private void textField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_emailActionPerformed

    private void cmdHuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHuy1ActionPerformed
        closeMenu();
    }//GEN-LAST:event_cmdHuy1ActionPerformed

    private void comboBox_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_TrangThaiActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    public boolean kiemTraNhapLieu() {
        if (textField_hoTen.getText().trim().length() == 0
                || textField_MSHV.getText().trim().length() == 0
                || textField_MSSV.getText().trim().length() == 0
                || textField_Lop.getText().trim().length() == 0
                || textField_SDT.getText().trim().length() != 10
                || textField_email.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

    public HoiVien getHoiVienEditted() {
        boolean gioi = true;
        if (rbNu.isSelected()) {
            gioi = false;
        }
        return new HoiVien(textField_MSHV.getText(), textField_MSSV.getText(), textField_hoTen.getText(), textField_Lop.getText(), gioi, textField_SDT.getText(), textField_email.getText(), comboBox_TrangThai.getSelectedItem().toString());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.Button cmdHuy1;
    private com.raven.swing.customswing.buttomcustom.Button cmdSave;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_TrangThai;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare1;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare10;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare4;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare5;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare6;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare7;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare8;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbMessage2;
    private javax.swing.JLabel lbMessage3;
    private javax.swing.JLabel lbMessage4;
    private javax.swing.JLabel lbMessage5;
    private javax.swing.JLabel lbMessage6;
    private javax.swing.JLabel lbMessage7;
    private javax.swing.JLabel lbMessage8;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private com.raven.swing.messagedialog.textFieldCustom textField_Lop;
    private com.raven.swing.messagedialog.textFieldCustom textField_MSHV;
    private com.raven.swing.messagedialog.textFieldCustom textField_MSSV;
    private com.raven.swing.messagedialog.textFieldCustom textField_SDT;
    private com.raven.swing.messagedialog.textFieldCustom textField_email;
    private com.raven.swing.messagedialog.textFieldCustom textField_hoTen;
    // End of variables declaration//GEN-END:variables
}
