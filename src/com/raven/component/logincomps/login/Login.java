package com.raven.component.logincomps.login;

import com.raven.main.Main;
import static com.raven.main.Main.fram;
import com.raven.model.dao.NhanVienDAO;
import com.raven.model.modeldata.NhanVien;
import com.raven.swing.notification.Notification;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        tf_pass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    action();
                }
            }
        });
        ImageIcon itcLogo = new ImageIcon(getClass().getResource("/com/raven/icon/itc_logo.jpg"));
        setIconImage(itcLogo.getImage());
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.component.logincomps.login.Background();
        jPanel2 = new javax.swing.JPanel();
        tf_id = new com.raven.component.logincomps.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        tf_pass = new com.raven.component.logincomps.swing.PasswordFieldLogin();
        button1 = new com.raven.component.logincomps.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thư viên ITC ");
        setResizable(false);

        background1.setBlur(jPanel2);

        jPanel2.setOpaque(false);

        tf_id.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        tf_id.setHint("Tài khoản");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ĐĂNG NHẬP");

        tf_pass.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        tf_pass.setHint("Mật khẩu");

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Đăng nhập");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        background1.add(jPanel2);
        jPanel2.setBounds(330, 100, 270, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        action();
    }//GEN-LAST:event_button1ActionPerformed
    public void action() {
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                String id = tf_id.getText();
                char[] passChars = tf_pass.getPassword();
                String pass = new String(passChars);
                NhanVien nv = NhanVienDAO.getInstance().login(id, pass);
                if (nv != null) {
                    dispose();
                    Properties prop = new Properties();
                    try {
                        FileReader reader = new FileReader("config.txt");
                        prop.load(reader);
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String maxSachDuocMuon = prop.getProperty("maxSachDuocMuon");
                    String soLuongNgayMuon = prop.getProperty("soLuongNgayMuon");
                    int maxSach = 3;
                    int soNgay = 14;
                    try {
                        maxSach = Integer.parseInt(maxSachDuocMuon);
                        soNgay = Integer.parseInt(soLuongNgayMuon);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fram = new Main(nv, maxSach, soNgay);
                    fram.setVisible(true);
                    Notification noti = new Notification(fram, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Xin chào  " + nv.getChucVu() + " " + nv.getHoTen() + " !");
                    noti.showNotification();
                } else {
                    showLoginFasle();
                }
                Thread.sleep(100);
                return 12;
            }
        };
        worker.execute();

    }

    public void showLoginFasle() {
        Notification noti = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Sai tên tài khoản hoặc mật khẩu!");
        noti.showNotification();
    }
    public static JFrame loginFram;

    public static JFrame getLoginFram() {
        return loginFram;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.logincomps.login.Background background1;
    private com.raven.component.logincomps.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private com.raven.component.logincomps.swing.TextField tf_id;
    private com.raven.component.logincomps.swing.PasswordFieldLogin tf_pass;
    // End of variables declaration//GEN-END:variables

}
