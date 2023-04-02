package com.raven.swing.customswing.imageswing;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
import com.raven.dialog.Message;
import com.raven.swing.messagedialog.MessageDialogCustom;
import com.raven.swing.notification.Notification;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author DELL
 */
public class ImageSearchDialog extends javax.swing.JDialog {

    private final JFrame fram;
    private Animator animator;
    private boolean show;
    public boolean ok=false;
    public Image imageOnly;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Image getImageOnly() {
        return imageOnly;
    }

    public void setImageOnly(Image imageOnly) {
        this.imageOnly = imageOnly;
    }  

    public ImageSearchDialog(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.swing.messagedialog.BackgroundDialog();
        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        pnSearch = new javax.swing.JPanel();
        cmdCancel = new com.raven.swing.customswing.buttomcustom.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setModal(true);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setUndecorated(true);

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/questionMark.png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(245, 71, 71));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Chọn ảnh bạn muốn lưu về");

        pnSearch.setLayout(new java.awt.GridLayout(1, 0));

        cmdCancel.setBackground(new java.awt.Color(245, 71, 71));
        cmdCancel.setText("Đóng");
        cmdCancel.setColorHover(new java.awt.Color(245, 71, 71));
        cmdCancel.setColorPressed(new java.awt.Color(234, 63, 63));
        cmdCancel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        setOk(false);
        closeMessage();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void init() {
        setBackground(Color.CYAN);
        pnSearch.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {

//                closeMessage();
            }
        });

        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                setOpacity(f);
            }

            @Override
            public void end() {
                if (show == false) {
                    dispose();
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);

    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }

    public void showSearching(String tenSach, String idSach) throws MalformedURLException, IOException {
        Border lineGreen = BorderFactory.createLineBorder(Color.GREEN);
        lbTitle.setText(tenSach);
        setLocationRelativeTo(fram);
        startAnimator(true);
        pnSearch.setLayout(new GridLayout(2, 1));
        // Your API key
        String apiKey = "AIzaSyDGeTTCGYgdh01u1C2y0q1oIajLS1XHGzs";

        // The search query
        String query = tenSach.trim().replaceAll(" ", "+");

        // Send the request
        URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + apiKey + "&cx=d56facc9dd1e240ee&q=" + query + "&searchType=image");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Get the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse the response
        Map<String, Object> jsonMap = (Map<String, Object>) JSONValue.parse(response.toString());
        JSONObject jsonResponse = new JSONObject(jsonMap);
        JSONArray items = (JSONArray) jsonResponse.get("items");

        for (int i = 0; i < items.size(); i++) {
            JSONObject item = (JSONObject) items.get(i);
            JSONObject item_child = (JSONObject) item.get("image");
            String thumbnailLink = null;
            thumbnailLink = (String) item_child.get("thumbnailLink");
            if (thumbnailLink != null) {
                URL imageUrl = new URL(thumbnailLink);
                BufferedImage image = ImageIO.read(imageUrl);
                Image defulatImage = image.getScaledInstance(180, 215, Image.SCALE_SMOOTH);
                Image resizedImage = image.getScaledInstance(120, 200, Image.SCALE_SMOOTH);

                ImageIcon imageIcon = new ImageIcon(resizedImage);

//                imageIcons.add(imageIcon);
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setSize(120, 200);
                imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                imageLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        Message mess = new Message(fram, true);
                        mess.showMessage("Bạn có chắc chắn chọn ảnh này ?");
                        if (mess.isOk()) {
                            setOk(true);
                            setImageOnly(defulatImage);
//                            Xử lý lưu trong From nên không cần xử lý lưu trong Search
//                            File destinationDirectory = new File("src/com/raven/icon/book_images");
//                            if (!destinationDirectory.exists()) {
//                                destinationDirectory.mkdirs();
//                            }
//                            File destinationFile = new File(destinationDirectory, idSach + ".jpg");
//                            Image resizedImagefinal = image.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
//                            Gọi lưu file trong form1 sau
//                            BufferedImage resizedBufferedImage = new BufferedImage(170, 192, BufferedImage.TYPE_INT_ARGB);
//                            resizedBufferedImage.getGraphics().drawImage(resizedImagefinal, 0, 0, null);
//                            try {
////                                ImageIO.write(resizedBufferedImage, "jpg", destinationFile);
//                                messageType = MessageType.OK;
//                                System.out.println("Thành côngxx");
//                            } catch (Exception em) {
//                                em.printStackTrace();
//                            }
                            System.out.println("da click ok");
                            closeMessage();
                        } else {
                            System.out.println("cancel check");
                        }
                    }
                });
//                imageLabel.addFocusListener(new FocusAdapter(){
//                    @Override
//                    public void focusLost(FocusEvent e) {
//                        imageLabel.setBorder(null);
//                    }                    
//                });
                pnSearch.add(imageLabel);
            }
        }

        setVisible(true);
    }

    public void closeMessage() {
        startAnimator(false);
    }


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.messagedialog.BackgroundDialog background1;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdCancel;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnSearch;
    // End of variables declaration//GEN-END:variables
}
