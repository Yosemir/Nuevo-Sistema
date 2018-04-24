/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
    public class Conexion {

    public static Connection cnx;

    public static Connection conectar(){
        if (cnx!=null){ // si esta abierta la conexión
            return cnx;
        }
        try {
            String url = "jdbc:sqlserver://192.168.8.155;databaseName=BDHospitalVG";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String user = "sa";
            String pwd = "vallegrande2017";
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Error en la conexión " + e.getMessage());
        }
        return cnx;
    }
}


