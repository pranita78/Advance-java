package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.CollegeBean;

public class CollegeModel {

    public static Integer nextPk() throws Exception {
        int pk = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM st_college");
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            pk = rs.getInt(1) + 1;
        }
        return pk;
    }

    public static void add(CollegeBean bean) throws Exception {
        int pk = nextPk();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement(
            "INSERT INTO st_college (id, name, address, state, city, phoneNo) VALUES (?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, pk);
        pstmt.setString(2, bean.getName());
        pstmt.setString(3, bean.getAddress());
        pstmt.setString(4, bean.getState());
        pstmt.setString(5, bean.getCity());
        pstmt.setString(6, bean.getPhoneNo());

        int i = pstmt.executeUpdate();
        System.out.println("College Added = " + i);
    }

    public static void update(CollegeBean bean) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement(
            "UPDATE st_college SET name = ?, address = ?, state = ?, city = ?, phoneNo = ? WHERE id = ?");
        pstmt.setString(1, bean.getName());
        pstmt.setString(2, bean.getAddress());
        pstmt.setString(3, bean.getState());
        pstmt.setString(4, bean.getCity());
        pstmt.setString(5, bean.getPhoneNo());
        pstmt.setInt(6, (int) bean.getId());

        int i = pstmt.executeUpdate();
        System.out.println("College Updated = " + i);
    }

    public static void delete(int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM st_college WHERE id = ?");
        pstmt.setInt(1, id);
        int i = pstmt.executeUpdate();
        System.out.println("College Deleted = " + i);
    }

    public CollegeBean findByPk(int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "root");
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM st_college WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        CollegeBean bean = null;
        if (rs.next()) {
            bean = new CollegeBean();
            bean.setId(rs.getInt(1));
            bean.setName(rs.getString(2));
            bean.setAddress(rs.getString(3));
            bean.setState(rs.getString(4));
            bean.setCity(rs.getString(5));
            bean.setPhoneNo(rs.getString(6));
        }
        return bean;
    }

    public List<CollegeBean> search(CollegeBean bean, int pageNo, int pageSize) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

        StringBuffer sql = new StringBuffer("SELECT * FROM st_college WHERE 1=1");

        if (bean != null) {
            if (bean.getId() > 0) {
                sql.append(" AND id = " + bean.getId());
            }
            if (bean.getName() != null && bean.getName().length() > 0) {
                sql.append(" AND name LIKE '" + bean.getName() + "%'");
            }
        }

        if (pageSize > 0) {
            pageNo = (pageNo - 1) * pageSize;
            sql.append(" LIMIT " + pageNo + ", " + pageSize);
        }

        System.out.println("SQL => " + sql);

        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        List<CollegeBean> list = new ArrayList<>();

        while (rs.next()) {
            bean = new CollegeBean();
            bean.setId(rs.getInt(1));
            bean.setName(rs.getString(2));
            bean.setAddress(rs.getString(3));
            bean.setState(rs.getString(4));
            bean.setCity(rs.getString(5));
            bean.setPhoneNo(rs.getString(6));
            list.add(bean);
        }

        return list;
    }
}