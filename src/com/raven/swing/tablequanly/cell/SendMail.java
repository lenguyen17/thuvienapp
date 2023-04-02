package com.raven.swing.tablequanly.cell;

import com.raven.dialog.*;
import com.raven.mail.EmailSender;
import static com.raven.main.Main.fram;
import com.raven.model.dao.SachDAO;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.notification.Notification;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class SendMail extends javax.swing.JDialog {

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public boolean ok = false;
    private final Animator animator;
    private boolean show = true;

    public SendMail(java.awt.Frame parent, boolean modal, String email, ArrayList<ChiTietSach> listTenSach, Calendar ngayHenTra) {
        super(parent, modal);
        initComponents();
        tf_email.setText(email);
        tf_TieuDe.setText("Thư viện ITC");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String noiDung = "Thư viện trường Cao đẳng CNTT TPHCM thông báo:\n"
                + "Thời gian mượn sách :\n";
        for (int i = 0; i < listTenSach.size(); i++) {
            noiDung += "- " + SachDAO.getInstance().selectByID(listTenSach.get(i).getIdSach()).getTenSach() + "\n";
        }
        noiDung += " đã ngày hẹn trả ";
        if (ngayHenTra != null) {
            noiDung += sdf.format(ngayHenTra.getTime());
        }
        noiDung += "\nVui lòng liên hệ thư viện để gia hạn thời gian mượn hoặc trả sách,\n"
                + "Xin cảm ơn.\n";
        lbNoiDung.setText(noiDung);
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

    public void showMessage() {
        animator.start();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        button2 = new com.raven.swing.customswing.buttomcustom.Button();
        button1 = new com.raven.swing.customswing.buttomcustom.Button();
        imageAvartaSquare1 = new com.raven.swing.customswing.imageswing.ImageAvartaSquare();
        jLabel1 = new javax.swing.JLabel();
        lbMessage1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbNoiDung = new javax.swing.JTextArea();
        lbMessage2 = new javax.swing.JLabel();
        tf_TieuDe = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 134, 253)));

        lbMessage.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage.setText("Gửi đến:");

        button2.setForeground(new java.awt.Color(66, 66, 66));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/ok_22px.png"))); // NOI18N
        button2.setText("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button1.setForeground(new java.awt.Color(66, 66, 66));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cancel_22px.png"))); // NOI18N
        button1.setText("Cancel");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        imageAvartaSquare1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Gmail Logo_60px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(82, 82, 82));
        jLabel1.setText("Gửi mail");

        lbMessage1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage1.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage1.setText("Nội dung:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNoiDung.setBackground(new java.awt.Color(255, 255, 255));
        lbNoiDung.setColumns(20);
        lbNoiDung.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbNoiDung.setForeground(new java.awt.Color(82, 82, 82));
        lbNoiDung.setRows(5);
        lbNoiDung.setText("Thư viện trường Cao đẳng CNTT TPHCM thông báo:\nThời gian mượn sách ABC đã quá hạn (ngày hẹn trả)\nXin vui lòng liên hệ thư viện để gia hạn thời gian mượn hoặc trả sách,\nXin cảm ơn.\n");
        lbNoiDung.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jScrollPane1.setViewportView(lbNoiDung);

        lbMessage2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbMessage2.setForeground(new java.awt.Color(82, 82, 82));
        lbMessage2.setText("Tiêu đề:");

        tf_TieuDe.setBackground(new java.awt.Color(255, 255, 255));
        tf_TieuDe.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        tf_TieuDe.setForeground(new java.awt.Color(82, 82, 82));
        tf_TieuDe.setText("Tiêu đề");
        tf_TieuDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_email.setBackground(new java.awt.Color(255, 255, 255));
        tf_email.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        tf_email.setForeground(new java.awt.Color(82, 82, 82));
        tf_email.setText("email");
        tf_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvartaSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMessage2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(tf_TieuDe)
                    .addComponent(tf_email, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageAvartaSquare1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                EmailSender email = new EmailSender();
                try {
                    email.sendEmail(tf_email.getText().trim(), tf_TieuDe.getText().trim(), lbNoiDung.getText().trim());
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Gửi mail thành công.");
                    noti.showNotification();
                } catch (MessagingException ex) {
                    Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
                    Notification noti = new Notification(fram, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Gửi mail thất bại!");
                }
                Thread.sleep(50);
                return 12;
            }
        };
        worker.execute();
        setOk(true);
        closeMenu();
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        closeMenu();
    }//GEN-LAST:event_button1ActionPerformed

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.customswing.buttomcustom.Button button1;
    private com.raven.swing.customswing.buttomcustom.Button button2;
    private com.raven.swing.customswing.imageswing.ImageAvartaSquare imageAvartaSquare1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbMessage2;
    private javax.swing.JTextArea lbNoiDung;
    private javax.swing.JTextField tf_TieuDe;
    private javax.swing.JTextField tf_email;
    // End of variables declaration//GEN-END:variables
}
