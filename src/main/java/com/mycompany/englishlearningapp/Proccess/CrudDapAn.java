/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.englishlearningapp.Proccess;
import com.mycompany.englishlearningapp.Database.Connect;
import com.mycompany.englishlearningapp.Model.Dapan;
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
public class CrudDapAn {
    private Connection conn;
    
    public CrudDapAn(){
        try {
            conn = Connect.getConnection();
        } catch (Exception e) {
        }
    }
    
    public List<Dapan> getAllDapAnbyMaCauHoi(int id){
        List<Dapan> dapans = new ArrayList<>();
        String sql = "select * from DapAn where maCauHoi = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dapan da = new Dapan();
                da.setMaDapAn(rs.getInt("id"));
                da.setDapAn(rs.getString("dapAn"));
                da.setIs_correct(rs.getBoolean("is_correct"));
                da.setMaCauHoi(rs.getInt("maCauHoi"));
                dapans.add(da);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return dapans;
    }
    
    public List<Dapan> getAllDapAn(){
        List<Dapan> dapans = new ArrayList<>();
        String sql = "select * from DapAn";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dapan da = new Dapan();
                da.setMaDapAn(rs.getInt("id"));
                da.setDapAn(rs.getString("dapAn"));
                da.setIs_correct(rs.getBoolean("is_correct"));
                da.setMaCauHoi(rs.getInt("maCauHoi"));
                dapans.add(da);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return dapans;
    }
    
    public String getDapAnDung(String cauHoi){
        String sql = "select dapAn from DapAn "
                + "join CauHoi on DapAn.maCauHoi = CauHoi.id "
                + "where cauHoi = ? and DapAn.is_correct = 'True'";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cauHoi);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String answer = rs.getString("dapAn");
                return answer;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        CrudDapAn cd = new CrudDapAn();
        String cauHoi = "“apple” nghĩa là gì?";
        String a = cd.getDapAnDung(cauHoi);
        System.out.println(a);
        }
}
