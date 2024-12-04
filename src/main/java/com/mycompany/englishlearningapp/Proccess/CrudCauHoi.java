/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.englishlearningapp.Proccess;
import com.mycompany.englishlearningapp.Database.Connect;
import com.mycompany.englishlearningapp.Model.Cauhoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class CrudCauHoi {
    private Connection conn;
    public CrudCauHoi(){
        try{
            conn = (Connection) Connect.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Cauhoi> getAllCauHoi(){
        List<Cauhoi> cauHoiList = new ArrayList<>();
        String sql = "select * from CauHoi";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cauhoi cauHoi = new Cauhoi();
                cauHoi.setMaCauHoi(rs.getInt("id"));
                cauHoi.setCauHoi(rs.getString("cauHoi"));
                cauHoiList.add(cauHoi);
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
        return cauHoiList;
    }
    
    public static void main(String[] args) {
        try{
            CrudCauHoi newCrudCauHoi = new CrudCauHoi();
            List<Cauhoi> newList = newCrudCauHoi.getAllCauHoi();
            for(Cauhoi x : newList){
                System.out.println(x);
            }
        }
        catch(Exception e){
            
        }
        
    }
}
