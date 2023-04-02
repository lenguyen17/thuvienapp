package com.raven.swing.tablequanly.cell;

import com.raven.dialog.*;
import static com.raven.main.Main.fram;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.TheMuon;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.notification.Notification;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class DialogTraSach extends javax.swing.JDialog {

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
    private TheMuon tm;
    public boolean ok = false;
    private final Animator animator;
    private boolean show = true;
    private String idTheMuon;
    private String[] keyIDCTS;
    private boolean chuaTraHet = false;

    public DialogTraSach(java.awt.Frame parent, boolean modal, String idTheMuon, String tenHoiVien) {
        super(parent, modal);
        this.idTheMuon = idTheMuon;
        initComponents();
        textField_NgayTra.setBackground(new Color(0, 0, 0, 0));
        pnSach.setLayout(new GridLayout(0, 1));
        Panel_ChildTraSach_null subPN = new Panel_ChildTraSach_null();
        pnSach.add(subPN);
        lbID.setText(idTheMuon);
        lbHoten.setText(tenHoiVien);
        jSeparator4.setForeground(new Color(0, 0, 0, 0));
        sc.setVerticalScrollBar(new ScrollBarCustom());
        sc.setBackground(new Color(0,0,0,0));
        sc.getViewport().setBackground(new Color(0,0,0,0));
        sc.getViewport().setOpaque(false);
        //Click ra ngoài = đóng
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {
                closeMenu();
            }
        });

        tm = TheMuonDAO.getInstance().selectByID(idTheMuon);
        int soLuong = tm.getListCTS().size();
        LinkedHashMap<String, String> hmTinhTrang = TheMuonDAO.getInstance().getTinhTrangByTheMuon(idTheMuon);
        Set<String> keySet = hmTinhTrang.keySet();
        keyIDCTS = keySet.toArray(new String[keySet.size()]);
        if (soLuong != 0) {
            pnSach.remove(subPN);
            for (int i = 0; i < soLuong; i++) {
                pnSach.add(new Panel_ChildTraSach(i + 1, soLuong, tm.getListCTS().get(i), hmTinhTrang.get(tm.getListCTS().get(i).getIdChiTietSach())));
            }
            if (soLuong < 3) {
                for (int i = soLuong; i < 3; i++) {
                    pnSach.add(new Panel_ChildTraSach_Empty());
                }
            }
        }
        cmdDateChooser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cmdDateChooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dateChooser1.showPopup();
            }
        });
        cmdTrahet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Component[] components = pnSach.getComponents();
                for(Component com: components){
                    if(com instanceof Panel_ChildTraSach){
                        Panel_ChildTraSach child = (Panel_ChildTraSach) com;
                        child.setTraSach();
                    }
                }
            }
        });

        cmdTraSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    traSach();
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Dữ liệu đã được cập nhật.");
                    noti.showNotification();
                } catch (Exception e) {
                    Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Trả sách thất bại, vui lòng kiểm tra lại.");
                    noti.showNotification();
                }
                closeMenu();
            }
        });

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

    public void showTraSach() {
        animator.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        cmdTraSach = new com.raven.swing.customswing.buttomcustom.Button();
        lbMessage1 = new javax.swing.JLabel();
        lbMessage9 = new javax.swing.JLabel();
        lbMessage10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbMessage4 = new javax.swing.JLabel();
        textField_NgayTra = new com.raven.swing.messagedialog.textFieldCustom();
        cmdDateChooser = new com.raven.swing.customswing.imageswing.ImageAvatar();
        lbID = new javax.swing.JLabel();
        lbHoten = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbMessage2 = new javax.swing.JLabel();
        lbMessage6 = new javax.swing.JLabel();
        lbMessage5 = new javax.swing.JLabel();
        lbMessage = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        sc = new javax.swing.JScrollPane();
        pnSach = new javax.swing.JPanel();
        cmdHuy = new com.raven.swing.customswing.buttomcustom.Button();
        cmdTrahet = new com.raven.swing.customswing.buttomcustom.Button();

        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.setTextRefernce(textField_NgayTra);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        cmdTraSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 161, 38)));
        cmdTraSach.setForeground(new java.awt.Color(66, 66, 66));
        cmdTraSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Plane_20px.png"))); // NOI18N
        cmdTraSach.setText("Trả sách");
        cmdTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTraSachActionPerformed(evt);
            }
        });

        lbMessage1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbMessage1.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage1.setText("TRẢ SÁCH");

        lbMessage9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage9.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/prison_20px.png"))); // NOI18N
        lbMessage9.setText("ID thẻ mượn: ");

        lbMessage10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage10.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/test_account_20px.png"))); // NOI18N
        lbMessage10.setText("Hội viên:");
        lbMessage10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbMessage10.setIconTextGap(8);

        jSeparator3.setBackground(new java.awt.Color(75, 134, 253));
        jSeparator3.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator3.setOpaque(true);

        lbMessage4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage4.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage4.setText("Ngày trả:");

        textField_NgayTra.setBackground(new java.awt.Color(255, 255, 255));
        textField_NgayTra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        textField_NgayTra.setForeground(new java.awt.Color(82, 82, 82));
        textField_NgayTra.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        textField_NgayTra.setLabelText("");
        textField_NgayTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NgayTraActionPerformed(evt);
            }
        });

        cmdDateChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/calendar_plus_50px.png"))); // NOI18N

        lbID.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbID.setForeground(new java.awt.Color(82, 82, 82));
        lbID.setText("id");

        lbHoten.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        lbHoten.setForeground(new java.awt.Color(82, 82, 82));
        lbHoten.setText("họ tên");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 134, 253), 1, true));

        lbMessage2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbMessage2.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage2.setText("STT");

        lbMessage6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbMessage6.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage6.setText("Giá tiền");

        lbMessage5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbMessage5.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage5.setText("Tình trạng");

        lbMessage.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Tên sách");

        jSeparator4.setBackground(new java.awt.Color(75, 134, 253));
        jSeparator4.setForeground(new java.awt.Color(75, 134, 253));
        jSeparator4.setOpaque(true);

        sc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sc.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setOpaque(false);

        pnSach.setOpaque(false);

        javax.swing.GroupLayout pnSachLayout = new javax.swing.GroupLayout(pnSach);
        pnSach.setLayout(pnSachLayout);
        pnSachLayout.setHorizontalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
        );
        pnSachLayout.setVerticalGroup(
            pnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        sc.setViewportView(pnSach);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessage5, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMessage2)
                    .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMessage6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 38, Short.MAX_VALUE)
                    .addComponent(sc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        cmdHuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        cmdHuy.setForeground(new java.awt.Color(66, 66, 66));
        cmdHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cancel_22px.png"))); // NOI18N
        cmdHuy.setText("Hủy bỏ");
        cmdHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHuyActionPerformed(evt);
            }
        });

        cmdTrahet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 161, 38)));
        cmdTrahet.setForeground(new java.awt.Color(66, 66, 66));
        cmdTrahet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png"))); // NOI18N
        cmdTrahet.setText("Trả hết");
        cmdTrahet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTrahetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbMessage9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMessage10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessage4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cmdTrahet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cmdTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lbMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmdDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMessage4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMessage9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbMessage10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdTrahet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(284, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdTrahetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTrahetActionPerformed
        
    }//GEN-LAST:event_cmdTrahetActionPerformed

    private void cmdHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHuyActionPerformed
        closeMenu();
    }//GEN-LAST:event_cmdHuyActionPerformed

    private void textField_NgayTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NgayTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NgayTraActionPerformed

    private void cmdTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTraSachActionPerformed

        //        closeMenu();
    }//GEN-LAST:event_cmdTraSachActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdDateChooser;
    private com.raven.swing.customswing.buttomcustom.Button cmdHuy;
    private com.raven.swing.customswing.buttomcustom.Button cmdTraSach;
    private com.raven.swing.customswing.buttomcustom.Button cmdTrahet;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbHoten;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbMessage10;
    private javax.swing.JLabel lbMessage2;
    private javax.swing.JLabel lbMessage4;
    private javax.swing.JLabel lbMessage5;
    private javax.swing.JLabel lbMessage6;
    private javax.swing.JLabel lbMessage9;
    private javax.swing.JPanel pnSach;
    private javax.swing.JScrollPane sc;
    private com.raven.swing.messagedialog.textFieldCustom textField_NgayTra;
    // End of variables declaration//GEN-END:variables

    public void traSach() throws ParseException {
        Component[] components = pnSach.getComponents();
        int i = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar ngayTra = Calendar.getInstance();
        ngayTra.setTime(sdf.parse(textField_NgayTra.getText()));
        for (Component com : components) {
            if (com instanceof Panel_ChildTraSach) {
                Panel_ChildTraSach item = (Panel_ChildTraSach) com;
                String tinhTrang = "";
                if (item.getSelectedTinhTrang() != null) {
                    tinhTrang = item.getSelectedTinhTrang();
                    if (!tinhTrang.equalsIgnoreCase("Đã trả") && !tinhTrang.equalsIgnoreCase("Hoàn tiền")) {
                        this.chuaTraHet = true;
                    }
                    if (tinhTrang.equalsIgnoreCase("Trễ hẹn")) {
                        return;
                    } else if (tinhTrang.equalsIgnoreCase("Đang mượn")) {
                        if (i < keyIDCTS.length) {
                            TheMuonDAO.getInstance().traTungQuyen(idTheMuon, keyIDCTS[i], tinhTrang, null);
                            ChiTietSachDAO.getInstance().updateTrangThai(keyIDCTS[i], getTinhTrangCTS(tinhTrang));
                            i++;
                        }
                    } else {
                        if (i < keyIDCTS.length) {
                            TheMuonDAO.getInstance().traTungQuyen(idTheMuon, keyIDCTS[i], tinhTrang, ngayTra);
                            System.out.println(idTheMuon + keyIDCTS[i].toString() + tinhTrang + sdf.format(ngayTra.getTime()));
                            ChiTietSachDAO.getInstance().updateTrangThai(keyIDCTS[i], getTinhTrangCTS(tinhTrang));
                            i++;
                        }
                    }
                }
            }
        }
        if (chuaTraHet == false) {
            setOk(true);
        }
    }

    public String getTinhTrangCTS(String tinhTrang) {
        if (tinhTrang.equalsIgnoreCase("Đang mượn")) {
            return "Được mượn";
        } else if (tinhTrang.equalsIgnoreCase("Đã trả")) {
            return "Sẵn sàng";
        } else if (tinhTrang.equalsIgnoreCase("Hoàn tiền")) {
            return "Mất";
        } else {
            return "Được mượn";
        }
    }
}
