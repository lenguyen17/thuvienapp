package com.raven.main;

import com.raven.component.logincomps.login.Login;
import com.raven.component.panelitems.Header;
import com.raven.component.panelitems.Menu;
import com.raven.dialog.DialogSettings;
import com.raven.dialog.Message;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.FORM_QLTM;
import com.raven.form.Form1_backup_2;
import com.raven.form.Form_HoiVien;
import com.raven.form.Form_HoiVien_backup;
import com.raven.form.Form_Home_old;
import com.raven.form.Form_QuanLySach;
import com.raven.form.Form_TK_Book;
import com.raven.form.Form_TaoTheMuon;
import com.raven.form.MainForm;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.modeldata.NhanVien;
import com.raven.model.modeldata.Sach;
import com.raven.swing.customswing.menu.MenuAnimation;
import com.raven.swing.customswing.menu.MenuItem;
import com.raven.swing.customswing.menu.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.notification.Notification;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    public ArrayList<Sach> listSach = new ArrayList<Sach>();
    private int maxSach;
    private int soNgay;
    private NhanVien nv;

    @SuppressWarnings("unchecked")

    public ArrayList<Sach> getListSach() {
        return listSach;
    }

    public Main(NhanVien nv, int maxSach, int soNgay) {
        this.nv = nv;
        this.maxSach = maxSach;
        this.soNgay = soNgay;
        initGetData();
        initComponents();
        init();
        initGetData();
    }

    public void initGetData() {
        listSach = SachDAO.getInstance().selectAll();
//       listSach.forEach((n)->System.out.println(n.toString()));
    }

    private void init() {
        ImageIcon itcLogo = new ImageIcon(getClass().getResource("/com/raven/icon/itc_logo.jpg"));
        setIconImage(itcLogo.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        UIManager.put("OptionPane.warningSound", null);
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header(nv.getHoTen(), nv.getChucVu());
        main = new MainForm();
        main.showForm(new Form_Home_old());
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
//                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                switch (menuIndex) {
                    case 0:
                        SwingWorker<Integer, Void> worker0 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                main.showForm(new Form_Home_old());
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker0.execute();
                        break;
                    case 1:
                        SwingWorker<Integer, Void> worker1 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                main.showForm(new Form_TaoTheMuon(getListSach(), getJFrame(), maxSach, nv.getIdNhanVien(), soNgay));
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker1.execute();
                        break;

                    case 2:
                        SwingWorker<Integer, Void> worker2 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                Form1_backup_2 form1 = new Form1_backup_2(getJFrame());
                                main.showForm(form1);
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker2.execute();
                        break;
                    case 3:
                        SwingWorker<Integer, Void> worker3 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                Form_QuanLySach fQLS = new Form_QuanLySach(getListSach(), getJFrame());
                                main.showForm(fQLS);
                                fQLS.getCMDButton().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        hideMenu();
                                    }
                                });
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker3.execute();
                        break;
                    case 4:
                        SwingWorker<Integer, Void> worker4 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                main.showForm(new Form_HoiVien(HoiVienDAO.getInstance().selectAll(), getJFrame()));
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker4.execute();
                        break;
                    case 5:
                        SwingWorker<Integer, Void> worker5 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                main.showForm(new FORM_QLTM(getJFrame()));
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker5.execute();
                        break;
                    case 6:
                        switch (subMenuIndex) {
                            case 0:
                                SwingWorker<Integer, Void> worker70 = new SwingWorker<Integer, Void>() {
                                    @Override
                                    protected Integer doInBackground() throws Exception {
                                        main.showForm(new Form_TK_Book());
                                        Thread.sleep(50);
                                        return 12;
                                    }
                                };
                                worker70.execute();
                                break;
                            case 1:
                                SwingWorker<Integer, Void> worker71 = new SwingWorker<Integer, Void>() {
                                    @Override
                                    protected Integer doInBackground() throws Exception {
//                                        main.showForm(new Form_TK_HoiVien());
                                        Thread.sleep(50);
                                        return 12;
                                    }
                                };
                                worker71.execute();
                                break;
                            case 2:
                                SwingWorker<Integer, Void> worker72 = new SwingWorker<Integer, Void>() {
                                    @Override
                                    protected Integer doInBackground() throws Exception {
//                                        main.showForm(new Form_TK_TheMuon());
                                        Thread.sleep(50);
                                        return 12;
                                    }
                                };
                                worker72.execute();
                                break;
                        }
                        break;
                    case 7:
                        SwingWorker<Integer, Void> worker6 = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                DialogSettings dia = new DialogSettings(getJFrame(), true, maxSach, soNgay);
                                dia.showSettings();
                                if (dia.isOk()) {
                                    loadSetting();
                                    Notification notiST = new Notification(getJFrame(), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Lưu cài đặt thành công.");
                                    notiST.showNotification();
                                } else {
                                    if (!dia.isCancel()) {
                                        Notification notiST = new Notification(getJFrame(), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Lưu cài đặt thất bại");
                                        notiST.showNotification();
                                    }
                                }
                                Thread.sleep(50);
                                return 12;
                            }
                        };
                        worker6.execute();
                        break;
                    case 8:
                        Message mess = new Message(fram, true);
                        mess.showMessage("Bạn có muốn đăng xuất ?");
                        if (mess.isOk()) {
                            dispose();
                            Login login = new Login();
                            login.setVisible(true);
                        }
                        break;
                    case 9:
                        Message mess1 = new Message(fram, true);
                        mess1.showMessage("Bạn có muốn thoát chương trình ?");
                        if (mess1.isOk()) {
                            setDefaultCloseOperation(EXIT_ON_CLOSE);
                            dispose();
                        }
                        break;
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%, wrap");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });

        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
//        DataFetcherThread dataFetcherThread = new DataFetcherThread();
//        dataFetcherThread.start();
    }

    public void loadSetting() {
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
        try {
            maxSach = Integer.parseInt(maxSachDuocMuon);
            soNgay = Integer.parseInt(soLuongNgayMuon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1555, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void hideMenu() {
        if (menu.isShowMenu()) {
            menu.hideallMenu();
            menu.setEnableMenu(true);
        }
        if (menu.isShowMenu()) {
            if (!animator.isRunning()) {
                animator.start();
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                Properties prop = new Properties();
//                try {
//                    FileReader reader = new FileReader("config.txt");
//                    prop.load(reader);
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                String maxSachDuocMuon = prop.getProperty("maxSachDuocMuon");
//                String soLuongNgayMuon = prop.getProperty("soLuongNgayMuon");
//                int maxSach = 3;
//                int soNgay = 14;
//                try {
//                    maxSach = Integer.parseInt(maxSachDuocMuon);
//                    soNgay = Integer.parseInt(soLuongNgayMuon);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                fram = new Main(new NhanVien(),maxSach, soNgay);
//                fram.setVisible(true);
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }

    public static JFrame fram;

    public JFrame getJFrame() {
        return fram;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables

}
