package com.raven.form;

import com.raven.component.chart.piechart.ModelPieChart;
import com.raven.component.chart.piechart.PieChart;
import static com.raven.main.Main.fram;
import com.raven.model.dao.ChiTietSachDAO;
import com.raven.model.dao.HoiVienDAO;
import com.raven.model.dao.SachDAO;
import com.raven.model.dao.TheMuonDAO;
import com.raven.model.modelcomponent.ModelStudent;
import com.raven.model.modeldata.ChiTietSach;
import com.raven.model.modeldata.HoiVien;
import com.raven.model.modeldata.Sach;
import com.raven.swing.notification.Notification;
import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;
import com.raven.swing.tableBook.DialogPieChartSach;
import com.raven.swing.tableBook.EventActionBook;
import com.raven.swing.tableBook.ModelBook;
import com.raven.swing.tablequanly.cell.CellAction;
import com.raven.swing.tablequanly.cell.CellActionBook;
import com.raven.swing.tablequanly.cell.CellFirst;
import com.raven.swing.tablequanly.cell.DialogBookHistoryChart;
import com.raven.swing.tablequanly.cell.DialogSach;
import com.raven.swing.tablequanly.modeltable.ModelStaff;
import com.raven.swing.tablequanly.modeltable.ModelStaffBook;
import com.raven.swing.tablequanly.swing.TableHeaderCustom;
import com.raven.table.model.TableRowData;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unchecked")
public class Form_TK_Book extends javax.swing.JPanel {

    private boolean sapXepGiam = true;
    private int viTriStart = 0;
    private KieuSapXep kieuiSapXep = KieuSapXep.GIATIEN;
    public ArrayList<Sach> listSach = SachDAO.getInstance().selectAll();

    enum KieuSapXep {
        LUOTMUON, GIATIEN, NGAYNHAP
    }

    public Form_TK_Book() {
        this.listSach = listSach;
        initComponents();
        initCustomCode();
    }

    private void initCustomCode() {
        table1.fixTable(jScrollPane1);
        table1.getTableHeader().setDefaultRenderer(new TableHeaderCustom());

        cmdLuotMuon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                kieuiSapXep = KieuSapXep.LUOTMUON;
                sapXepGiam = !sapXepGiam;
                cmdGiaTien.setIcon(null);
                cmdNgayNhap.setIcon(null);
                viTriStart = 0;
                lbTrang.setText("Trang 1");
                cmdLuotMuon.setHorizontalAlignment((int) LEFT_ALIGNMENT);
                cmdGiaTien.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                cmdNgayNhap.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                if (sapXepGiam) {
                    cmdLuotMuon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxepgiam_16px.png")));
                } else {
                    cmdLuotMuon.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxeptang_16px.png")));
                }
                sapXep();
                clearTable();
                startWorkerShowSach(viTriStart);
                revalidate();
                repaint();
            }
        });
        cmdGiaTien.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                kieuiSapXep = KieuSapXep.GIATIEN;
                sapXepGiam = !sapXepGiam;
                cmdLuotMuon.setIcon(null);
                cmdNgayNhap.setIcon(null);
                viTriStart = 0;
                lbTrang.setText("Trang 1");
                cmdGiaTien.setHorizontalAlignment((int) LEFT_ALIGNMENT);
                cmdLuotMuon.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                cmdNgayNhap.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                if (sapXepGiam) {
                    cmdGiaTien.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxepgiam_16px.png")));
                } else {
                    cmdGiaTien.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxeptang_16px.png")));
                }
                sapXep();
                clearTable();
                startWorkerShowSach(viTriStart);
                revalidate();
                repaint();
            }
        });

        cmdNgayNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                kieuiSapXep = KieuSapXep.NGAYNHAP;
                sapXepGiam = !sapXepGiam;
                cmdLuotMuon.setIcon(null);
                cmdGiaTien.setIcon(null);
                viTriStart = 0;
                lbTrang.setText("Trang 1");
                cmdNgayNhap.setHorizontalAlignment((int) LEFT_ALIGNMENT);
                cmdLuotMuon.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                cmdGiaTien.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                if (sapXepGiam) {
                    cmdNgayNhap.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxepgiam_16px.png")));
                } else {
                    cmdNgayNhap.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/sapxeptang_16px.png")));
                }
                sapXep();
                clearTable();
                startWorkerShowSach(viTriStart);
                revalidate();
                repaint();
            }
        });

        //Combobox Loai Sach     
        comboBox_loaiSach.addItem("Loại sách");
        for (String tl : ChiTietSachDAO.getInstance().getAllTheLoai()) {
            comboBox_loaiSach.addItem(tl);
        }

        textField_Search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_Search.getText().equals("Nhập mã,tên,tác giả...")) {
                    textField_Search.setText("");
                    textField_Search.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_Search.getText().isEmpty()) {
                    textField_Search.setForeground(Color.GRAY);
                    textField_Search.setText("Nhập mã,tên,tác giả...");
                }
            }
        });
        textField_Search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    thucHienTim();
                }
            }
        });

        cmdSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cmdSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                thucHienTim();
            }
        });

        //PAGE
        cmdNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((viTriStart + 12) < listSach.size()) {
                    viTriStart += 12;
                    clearTable();
                    int pageNum = viTriStart / 12;
                    lbTrang.setText("Trang " + ++pageNum);
                    startWorkerShowSach(viTriStart);
                } else {
                    Notification noti = new Notification(fram, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Không còn thông tin để hiển thị thêm.");
                    noti.showNotification();
                    return;
                }
                revalidate();
                repaint();
            }
        });
        cmdPrevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viTriStart -= 12;
                if (viTriStart < 0) {
                    viTriStart = 0;
                    return;
                } else {
                    int pageNum = viTriStart / 12;
                    lbTrang.setText("Trang " + ++pageNum);
                    clearTable();
                    startWorkerShowSach(viTriStart);
                }
            }
        });
        cmdTheLoai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogPieChartSach diaPie = new DialogPieChartSach(fram, true);
                diaPie.showSach();

            }
        });

        if (listSach.size() == 0) {
            listSach = SachDAO.getInstance().selectAll();
        }
        startWorkerShowSach(viTriStart);
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    private void startWorkerShowSach(int viTri) {
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                EventActionBook event = new EventActionBook() {
                    @Override
                    public void showHistory(ModelBook book) {
                        SwingWorker<Integer, Void> workerShowHistory = new SwingWorker<Integer, Void>() {
                            @Override
                            protected Integer doInBackground() throws Exception {
                                DialogBookHistoryChart diaHis = new DialogBookHistoryChart(fram, true);
                                diaHis.showHistory(book.getIdSach());
                                Thread.sleep(100);
                                return 12;
                            }
                        };
                        workerShowHistory.execute();
                    }

                    @Override
                    public void view(ModelBook book) {
                        if (book != null) {
                            SwingWorker<Integer, Void> workerView = new SwingWorker<Integer, Void>() {
                                @Override
                                protected Integer doInBackground() throws Exception {
                                    ChiTietSach cts = ChiTietSachDAO.getInstance().castCTS(book.getIdSach());
                                    System.out.println(cts.toString());
                                    for (String s123 : cts.getTacGia()) {
                                        System.out.println(s123);
                                    }
                                    DialogSach dia = new DialogSach(fram, false, cts);
                                    dia.showSach();
                                    Thread.sleep(100);
                                    return 12;
                                }
                            };
                            workerView.execute();
                        }
                    }
                };
                DefaultTableModel mod = (DefaultTableModel) table1.getModel();
                ImageIcon iconDF = new ImageIcon(getClass().getResource("/com/raven/icon/icon_book_50px.png"));
                for (int i = viTri; i < listSach.size() && i < (12 + viTri); i++) {
                    Sach s = listSach.get(i);
                    int luotMuon = SachDAO.getInstance().getLuotMuon(s.getIdSach());
                    ChiTietSach cts = ChiTietSachDAO.getInstance().castCTS(s.getIdSach());
                    if (cts == null) {
                        continue;
                    }
                    String giaTien = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"))
                            .format(cts.getGiaTien());
                    String ngayNhap = sdf.format(cts.getNgayNhap().getTime());
                    ImageIcon icon = iconDF;
                    try {
                        icon = new ImageIcon(getClass().getResource("/com/raven/icon/book_images/" + s.getIdSach() + ".jpg"));
                    } catch (Exception e) {

                    }
                    mod.addRow(new ModelBook(icon, s.getIdSach(), s.getTenSach(), cts.getStringTacGia(), cts.getStringTheLoai(), luotMuon, giaTien, ngayNhap).toRowTable(event));
                }
                Thread.sleep(50);
                return 12;
            }
        };
        worker.execute();
    }

    //Sắp xếp lại list sách
    public void sapXep() {
        listSach.sort(new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                if (kieuiSapXep == KieuSapXep.LUOTMUON) {
                    if (sapXepGiam) {
                        return SachDAO.getInstance().getLuotMuon(s2.getIdSach()) - SachDAO.getInstance().getLuotMuon(s1.getIdSach());
                    } else {
                        return SachDAO.getInstance().getLuotMuon(s1.getIdSach()) - SachDAO.getInstance().getLuotMuon(s2.getIdSach());
                    }
                } else if (kieuiSapXep == KieuSapXep.GIATIEN) {
                    if (sapXepGiam) {
                        return ChiTietSachDAO.getInstance().castCTS(s2.getIdSach()).getGiaTien() > ChiTietSachDAO.getInstance().castCTS(s1.getIdSach()).getGiaTien() ? 1 : -1;
                    } else {
                        return ChiTietSachDAO.getInstance().castCTS(s1.getIdSach()).getGiaTien() > ChiTietSachDAO.getInstance().castCTS(s2.getIdSach()).getGiaTien() ? 1 : -1;
                    }
                } else {
                    if (sapXepGiam) {
                        return ChiTietSachDAO.getInstance().castCTS(s2.getIdSach()).getNgayNhap().compareTo(ChiTietSachDAO.getInstance().castCTS(s1.getIdSach()).getNgayNhap()) > 0 ? 1 : -1;
                    } else {
                        return ChiTietSachDAO.getInstance().castCTS(s1.getIdSach()).getNgayNhap().compareTo(ChiTietSachDAO.getInstance().castCTS(s2.getIdSach()).getNgayNhap()) > 0 ? 1 : -1;
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField_Search = new javax.swing.JTextField();
        comboBox_loaiSach = new com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion();
        cmdLoc = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdTatCa = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        cmdSearch = new com.raven.swing.customswing.imageswing.ImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        cmdLuotMuon = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdGiaTien = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdNgayNhap = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        lbTrang = new javax.swing.JLabel();
        cmdPrevPage = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        cmdNextPage = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.tableBook.TableBook();
        checkTenSach = new javax.swing.JCheckBox();
        checkTacGia = new javax.swing.JCheckBox();
        cmdTheLoai = new com.raven.swing.customswing.buttomcustom.ButtonCustom();
        jLabel3 = new javax.swing.JLabel();

        setOpaque(false);

        textField_Search.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        textField_Search.setForeground(new java.awt.Color(153, 153, 153));
        textField_Search.setText("Nhập mã,tên,tác giả...");
        textField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_SearchActionPerformed(evt);
            }
        });

        cmdLoc.setText("Lọc");
        cmdLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocActionPerformed(evt);
            }
        });

        cmdTatCa.setBackground(new java.awt.Color(69, 72, 191));
        cmdTatCa.setText("Tất cả");
        cmdTatCa.setColorHover(new java.awt.Color(112, 119, 225));
        cmdTatCa.setColorPressed(new java.awt.Color(17, 28, 150));
        cmdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTatCaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ SÁCH");

        cmdSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search_50px.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/sapxep_20px.png"))); // NOI18N
        jLabel2.setText("Sắp xếp:");

        cmdLuotMuon.setBackground(new java.awt.Color(242, 242, 242));
        cmdLuotMuon.setForeground(new java.awt.Color(0, 0, 0));
        cmdLuotMuon.setText("Lượt mượn");
        cmdLuotMuon.setColorHover(new java.awt.Color(255, 255, 255));
        cmdLuotMuon.setColorPressed(new java.awt.Color(232, 232, 232));
        cmdLuotMuon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cmdLuotMuon.setIconTextGap(8);
        cmdLuotMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLuotMuonActionPerformed(evt);
            }
        });

        cmdGiaTien.setBackground(new java.awt.Color(242, 242, 242));
        cmdGiaTien.setForeground(new java.awt.Color(0, 0, 0));
        cmdGiaTien.setText("Giá tiền");
        cmdGiaTien.setColorHover(new java.awt.Color(255, 255, 255));
        cmdGiaTien.setColorPressed(new java.awt.Color(232, 232, 232));
        cmdGiaTien.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cmdGiaTien.setIconTextGap(8);
        cmdGiaTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGiaTienActionPerformed(evt);
            }
        });

        cmdNgayNhap.setBackground(new java.awt.Color(242, 242, 242));
        cmdNgayNhap.setForeground(new java.awt.Color(0, 0, 0));
        cmdNgayNhap.setText("Ngày nhập");
        cmdNgayNhap.setColorHover(new java.awt.Color(255, 255, 255));
        cmdNgayNhap.setColorPressed(new java.awt.Color(232, 232, 232));
        cmdNgayNhap.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cmdNgayNhap.setIconTextGap(8);
        cmdNgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNgayNhapActionPerformed(evt);
            }
        });

        lbTrang.setBackground(new java.awt.Color(255, 255, 255));
        lbTrang.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        lbTrang.setForeground(new java.awt.Color(255, 255, 255));
        lbTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/cube_25px.png"))); // NOI18N
        lbTrang.setText("Trang 1");

        cmdPrevPage.setText("Trước");
        cmdPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrevPageActionPerformed(evt);
            }
        });

        cmdNextPage.setText("Sau");
        cmdNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextPageActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Tác giả", "Lượt mượn", "Giá tiền", "Ngày nhập", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(150);
            table1.getColumnModel().getColumn(1).setMinWidth(200);
            table1.getColumnModel().getColumn(2).setPreferredWidth(200);
            table1.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        checkTenSach.setSelected(true);
        checkTenSach.setText("Tên sách");
        checkTenSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/unchecked_checkbox_25px.png"))); // NOI18N
        checkTenSach.setRolloverEnabled(false);
        checkTenSach.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_checkbox_25px.png"))); // NOI18N

        checkTacGia.setSelected(true);
        checkTacGia.setText("Tác giả");
        checkTacGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/unchecked_checkbox_25px.png"))); // NOI18N
        checkTacGia.setRolloverEnabled(false);
        checkTacGia.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/checked_checkbox_25px.png"))); // NOI18N

        cmdTheLoai.setBackground(new java.awt.Color(242, 242, 242));
        cmdTheLoai.setForeground(new java.awt.Color(0, 0, 0));
        cmdTheLoai.setText("Thể loại");
        cmdTheLoai.setColorHover(new java.awt.Color(255, 255, 255));
        cmdTheLoai.setColorPressed(new java.awt.Color(232, 232, 232));
        cmdTheLoai.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cmdTheLoai.setIconTextGap(8);
        cmdTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTheLoaiActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/piechart_20px.png"))); // NOI18N
        jLabel3.setText("Biểu đồ:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboBox_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkTenSach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkTacGia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdLuotMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_loaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdLuotMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void thucHienTim() {
        if (textField_Search.getText() != null && !textField_Search.getText().equals("Nhập mã,tên,tác giả...")) {
            listSach = SachDAO.getInstance().selectByCondition(textField_Search.getText(), comboBox_loaiSach.getSelectedItem().toString(),
                    checkTenSach.isSelected(), checkTacGia.isSelected());
        } else {
            if (comboBox_loaiSach.getSelectedIndex() != 0) {
                listSach = SachDAO.getInstance().selectByCondition("", comboBox_loaiSach.getSelectedItem().toString(),
                        false, false);
            }
        }
        clearTable();
        viTriStart = 0;
        startWorkerShowSach(viTriStart);
    }
    private void textField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_SearchActionPerformed

    private void cmdLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocActionPerformed
        thucHienTim();
        checkTacGia.setSelected(true);
        checkTenSach.setSelected(true);
        comboBox_loaiSach.setSelectedIndex(0);
        revalidate();
        repaint();
    }//GEN-LAST:event_cmdLocActionPerformed

    private void cmdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTatCaActionPerformed
        listSach = SachDAO.getInstance().selectAll();
        clearTable();
        viTriStart = 0;
        comboBox_loaiSach.setSelectedIndex(0);
        lbTrang.setText("Trang 1");
        startWorkerShowSach(viTriStart);
        revalidate();
        repaint();
    }//GEN-LAST:event_cmdTatCaActionPerformed

    private void cmdLuotMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLuotMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdLuotMuonActionPerformed

    private void cmdGiaTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGiaTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdGiaTienActionPerformed

    private void cmdNgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNgayNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdNgayNhapActionPerformed

    private void cmdPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrevPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdPrevPageActionPerformed

    private void cmdNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextPageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdNextPageActionPerformed

    private void cmdTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdTheLoaiActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#8EC5FC"), getWidth(), getHeight(), Color.decode("#E0C3FC"));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkTacGia;
    private javax.swing.JCheckBox checkTenSach;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdGiaTien;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLoc;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdLuotMuon;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdNextPage;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdNgayNhap;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdPrevPage;
    private com.raven.swing.customswing.imageswing.ImageAvatar cmdSearch;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdTatCa;
    private com.raven.swing.customswing.buttomcustom.ButtonCustom cmdTheLoai;
    private com.raven.swing.customswing.comboboxcustom.ComboBoxSuggestion comboBox_loaiSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrang;
    private com.raven.swing.tableBook.TableBook table1;
    private javax.swing.JTextField textField_Search;
    // End of variables declaration//GEN-END:variables
}
