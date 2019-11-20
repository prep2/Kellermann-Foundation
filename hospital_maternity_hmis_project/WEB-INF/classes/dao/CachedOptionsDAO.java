package dao;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Error;
import model.Vht;
import model.Hmis;
import model.Village;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CachedOptionsDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Date date;

//    public static List<String> Get_Breathing_Options() throws SQLException
//    {
//        Connection con;
//
//        System.out.println("Get_Breathing_Options invoked");
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//            System.out.println("Error in Hmis_list: "+ex.getMessage());
//            ErrorDAO.Error_Add(new model.Error("ChbDAO", "Get_Hmis_List", " Message: " + ex.getMessage(), date));
//            return null;
//        }
//        String url = "jdbc:mysql://localhost:3306/bwindihospital_reduced";
//        con = DriverManager.getConnection(url, "root", "t00r");
//
//
//        PreparedStatement stmt = con.prepareStatement("SELECT * FROM breathing");
//        ResultSet rs = stmt.executeQuery();
//
//
//    }


}
