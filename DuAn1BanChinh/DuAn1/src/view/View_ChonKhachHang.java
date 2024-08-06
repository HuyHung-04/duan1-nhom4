/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Model_KhachHang;
import service.Service_KhachHang;

public class View_ChonKhachHang extends javax.swing.JFrame {

    private JFrame parentFrame;
    private View_BanHang view_BanHang = new View_BanHang();
    private Service_KhachHang skh = new Service_KhachHang();
    private int i = -1;
    private DefaultTableModel dtm = new DefaultTableModel();

    public View_ChonKhachHang(JFrame frame) {
            initComponents();
            this.parentFrame = parentFrame;
            fillTable(skh.getAll());
    }

   
    void fillTable(ArrayList<Model_KhachHang> list) {
        dtm = (DefaultTableModel) tblKhachHangChon.getModel();
        dtm.setRowCount(0);
        for (Model_KhachHang kh : list) {
            dtm.addRow(kh.toDaTaRow());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHangChon = new javax.swing.JTable();

        tblKhachHangChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHangChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangChonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHangChon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangChonMouseClicked
//        int i = tblKhachHangChon.getSelectedRow();
//        if(i != -1){
//            String ma = dtm.getValueAt(i, 0).toString();
//            String ten = dtm.getValueAt(i, 1).toString();
//             if (parentFrame instanceof JFrame) {
//                    for (Component component : ((JFrame) parentFrame).getContentPane().getComponents()) {
//                        if (component instanceof View_BanHang) {
//                            View_BanHang viewBanHang = (View_BanHang) component;
//                            viewBanHang.setCustomerData(ma,ten);
//                            break;
//                        }
//                    }
//                }
//            this.dispose();
//        }
    }//GEN-LAST:event_tblKhachHangChonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               JFrame frame = new JFrame();
            View_BanHang viewBanHang = new View_BanHang();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());
            frame.add(viewBanHang, BorderLayout.CENTER);
            frame.setVisible(true);

            View_ChonKhachHang viewChonKhachHang = new View_ChonKhachHang(frame);
            viewChonKhachHang.setVisible(true);
            viewChonKhachHang.setLocationRelativeTo(frame);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKhachHangChon;
    // End of variables declaration//GEN-END:variables
}
