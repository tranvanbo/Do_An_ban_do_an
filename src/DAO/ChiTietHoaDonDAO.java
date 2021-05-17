//main
package DAO;

import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietHoaDonDAO {

    ConnectDB connection = new ConnectDB();

    public ChiTietHoaDonDAO() {

    }

    public ArrayList docCTHD() throws SQLException, Exception { //cần ghi lại khi qua class khác
        connection = new ConnectDB();
        ArrayList<ChiTietHoaDonDTO> chitiethd = new ArrayList<>();
        try {
            String qry = "SELECT * FROM chitiethoadon";
            ResultSet result = connection.excuteQuery(qry);
            if (result != null) {
                while (result.next()) {
                    ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                    cthd.setIDHoaDon(result.getString("IDHoaDon"));
                    cthd.setIDMonAn(result.getString("IDMonAn"));
                    cthd.setSoLuong(result.getInt("SoLuong"));
                    cthd.setDonGia(result.getFloat("DonGia"));
                    cthd.setThanhTien(result.getFloat("ThanhTien"));
                    chitiethd.add(cthd);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu bảng chi tiết hoá đơn");
        }
        return chitiethd;
    }

    public void them(ChiTietHoaDonDTO chitiethd) { //cần ghi lại khi qua class khác
        try {
            String qry = "INSERT INTO chitiethoadon values (";
            qry = qry + "'" + chitiethd.getIDHoaDon()+ "'";
            qry = qry + "," + "'" + chitiethd.getIDMonAn()+ "'";
            qry = qry + "," + "'" + chitiethd.getSoLuong()+ "'";
            qry = qry + "," + "'" + chitiethd.getDonGia() + "'";
            qry = qry + "," + "'" + chitiethd.getThanhTien()+ "'";
            qry = qry + ")";
            connection.getStatement();
            connection.ExecuteUpdate(qry);
            System.out.println(qry);
            connection.closeConnect();
        } catch (Exception ex) {
        }
    }

//    public void xoa(String IDHoaDon) { //cần ghi lại khi qua class khác
//        IDHoaDon = " ";
//        try {
//            String qry = "DELETE FROM chitiethoadon WHERE IDHoaDon='" + IDHoaDon + "'";
//            connection.getStatement();
//            connection.ExecuteUpdate(qry);
//            System.out.println(qry);
//            connection.closeConnect();
//        } catch (Exception ex) {
//
//        }
//    }
//
////    public void xoa(ChiTietHoaDonDTO chitiethd) {
////        try {
////            String qry = "Update chitiethoadon Set ";
////            qry = qry + "TrangThai=" + "'" + chitiethd.getTrangThai() + "'";
////            qry = qry + " " + "where IDMonAn='" + chitiethd.getIDHoaDon()+ "'";
////            connection.getStatement();
////            connection.ExecuteUpdate(qry);
//////            System.out.println(qry);
////            connection.closeConnect();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public void sua(ChiTietHoaDonDTO chitiethd) { //cần ghi lại khi qua class khác
//        try {
//            String qry = "Update chitiethoadon Set ";
//            qry = qry + "IDHoaDon=" + "'" + chitiethd.getIDHoaDon()+ "',";
//            qry = qry + ",IDMonAn=" + "'" + chitiethd.getIDMonAn()+ "'";
//            qry = qry + ",SoLuong=" + "'" + chitiethd.getSoLuong()+ "'";
//            qry = qry + ",DonGia=" + "'" + chitiethd.getDonGia() + "'";
//            qry = qry + ",ThanhTien=" + "'" + chitiethd.getThanhTien()+ "'";
//            qry = qry+" "+" WHERE IDHoaDon=' "+chitiethd.getIDHoaDon()+"'";
//            connection.getStatement();
//            connection.ExecuteUpdate(qry);
//            //System.out.println(qry);
//            connection.closeConnect();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

}




