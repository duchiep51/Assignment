/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.daos;

import hieptd.Conn.MyConnection;
import hieptd.dtos.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiep
 */
public class RegistrationDAO implements Serializable {
    Connection conn;
    ResultSet rs;
    PreparedStatement preStm;
    
    private void closeConnection() throws Exception {
        if(preStm != null)
            preStm.close();
        if(rs != null)
            rs.close();
        if(conn != null)
            conn.close();
    }
    
    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "select Role from Login where Username = ? and Password = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next())
                role = rs.getString("Role");
        } 
        finally {
            closeConnection();
        }
        return role;
    }

    public List<RegistrationDTO> findByLikeName(String search) throws Exception {
        List<RegistrationDTO> result;
        String username, fullname, role;
        RegistrationDTO dto = null;
        try{
            String sql = "select Username, Fullname, Role from Login where Fullname like ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                dto = new RegistrationDTO(username, fullname, role);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean insert(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into Login(Username, Password, Fullname, Role) values(?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    } 
}
