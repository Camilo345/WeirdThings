/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Bolaños Aldana
 */
public class Administrador {
    
    int idAdmin;
    String usuarioAdmin;
    String contraseñaAdmin;
    String nombreAd1;
    String nombreAd2;
    String apellidoAd1;
    String apellidoAd2;

    public Administrador() {
    }

    public Administrador(int idAdmin, String usuarioAdmin, String contraseñaAdmin, String nombreAd1, String apellidoAd1) {
        this.idAdmin = idAdmin;
        this.usuarioAdmin = usuarioAdmin;
        this.contraseñaAdmin = contraseñaAdmin;
        this.nombreAd1 = nombreAd1;
        this.apellidoAd1 = apellidoAd1;
    }

    public Administrador(int idAdmin, String usuarioAdmin, String contraseñaAdmin, String nombreAd1, String nombreAd2, String apellidoAd1, String apellidoAd2) {
        this.idAdmin = idAdmin;
        this.usuarioAdmin = usuarioAdmin;
        this.contraseñaAdmin = contraseñaAdmin;
        this.nombreAd1 = nombreAd1;
        this.nombreAd2 = nombreAd2;
        this.apellidoAd1 = apellidoAd1;
        this.apellidoAd2 = apellidoAd2;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContraseñaAdmin() {
        return contraseñaAdmin;
    }

    public void setContraseñaAdmin(String contraseñaAdmin) {
        this.contraseñaAdmin = contraseñaAdmin;
    }

    public String getNombreAd1() {
        return nombreAd1;
    }

    public void setNombreAd1(String nombreAd1) {
        this.nombreAd1 = nombreAd1;
    }

    public String getNombreAd2() {
        return nombreAd2;
    }

    public void setNombreAd2(String nombreAd2) {
        this.nombreAd2 = nombreAd2;
    }

    public String getApellidoAd1() {
        return apellidoAd1;
    }

    public void setApellidoAd1(String apellidoAd1) {
        this.apellidoAd1 = apellidoAd1;
    }

    public String getApellidoAd2() {
        return apellidoAd2;
    }

    public void setApellidoAd2(String apellidoAd2) {
        this.apellidoAd2 = apellidoAd2;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idAdmin=" + idAdmin + ", usuarioAdmin=" + usuarioAdmin + ", contrase\u00f1aAdmin=" + contraseñaAdmin + ", nombreAd1=" + nombreAd1 + ", nombreAd2=" + nombreAd2 + ", apellidoAd1=" + apellidoAd1 + ", apellidoAd2=" + apellidoAd2 + '}';
    }


    public LinkedList<Administrador> buscarAdministradores(String sql) {
       
        ResultSet rs = null;
        LinkedList<Administrador> lc = new LinkedList<>();
        BaseDatos objcone = new BaseDatos();
    int idAdmin;
    String usuarioAdmin="";
    String contraseñaAdmin="";
    String nombreAd1="";
    String nombreAd2="";
    String apellidoAd1="";
    String apellidoAd2="";
        if (objcone.crearConexion()) {
            try {
                Statement sentencia = objcone.getConexion().createStatement();
                rs = sentencia.executeQuery(sql);
                while (rs.next()) {
                    idAdmin = rs.getInt("idAdmin");
                    usuarioAdmin = rs.getString("usuarioAdmin");
                    contraseñaAdmin = rs.getString("contraseñaAdmin");
                     nombreAd1 = rs.getString("nombreAd1");
                    try {
                        nombreAd2 = rs.getString("nombreAd2");
                    } catch (NullPointerException n) { }
                    if(nombreAd2==null){
                        nombreAd2 = "";
                    }
                    
                    apellidoAd1 = rs.getString("apellidoAd1");
                     try {
                        apellidoAd2 = rs.getString("apellido2");
                    } catch (NullPointerException n) { }
                    if(apellidoAd2==null){
                        apellidoAd2 = "";
                    }
                 
                    lc.add(new Administrador(idAdmin,usuarioAdmin,contraseñaAdmin, nombreAd1, nombreAd2, apellidoAd1, apellidoAd2));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
        return lc;
        
    }
    
            public boolean insert(String sql) {
        BaseDatos objCon = new BaseDatos();

        if (objCon.crearConexion()) {
            try {
                Statement sentencia = objCon.getConexion().createStatement();
                sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
            public HashMap<Integer, String> ejecutarSQLSelect(String sql) {

        ResultSet rs;
        int idAdmi;
        String usuarioA;

        BaseDatos objU = new BaseDatos();
        HashMap<Integer, String> us = new HashMap<>();
        try {
            if (objU.crearConexion()) {
                Statement sentencia = objU.getConexion().createStatement();
                rs = sentencia.executeQuery(sql);
                while (rs.next()) {
                    idAdmi = rs.getInt("idAdmin");
                    usuarioA = rs.getNString("usuarioAdmin");
                    us.put(idAdmi, usuarioA);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return us;
    }
     public HashMap<Integer, String> ejecutarSQLSelectC(String sql) {

        ResultSet rs;
        int idAdmi;
        String pass;

        BaseDatos objCnt = new BaseDatos();
        HashMap<Integer, String> ct = new HashMap<>();
        try {
            if (objCnt.crearConexion()) {
                Statement sentencia = objCnt.getConexion().createStatement();
                rs = sentencia.executeQuery(sql);
                while (rs.next()) {
                    idAdmi = rs.getInt("idAdmin");
                    pass = rs.getNString("contraseñaAdmin");
                    ct.put(idAdmi, pass);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return ct;

    }
     public ResultSet obtenerA(String sql) {
        BaseDatos objCnt = new BaseDatos();
        ResultSet rs = null;
        try {
            if (objCnt.crearConexion()) {
                Statement sentencia = objCnt.getConexion().createStatement();
                rs = sentencia.executeQuery(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return rs;
    }

    public void InsertarAdministrador(String sql) {
      ResultSet rs = null;
         BaseDatos objcone = new BaseDatos();
          if (objcone.crearConexion()) {
            try {
                Statement sentencia = objcone.getConexion().createStatement();
                rs = sentencia.executeQuery(sql);
               
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
    }
    }
}
