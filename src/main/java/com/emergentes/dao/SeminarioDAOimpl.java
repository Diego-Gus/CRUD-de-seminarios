package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAOimpl extends ConexionBD implements SeminarioDAO{

    @Override
    public void insert(Seminario seminario) throws Exception {
        try{
            this.conectar();
            String sql = "INSERT INTO seminarios (titulo, expositor, fecha, hora, cupo) VALUES(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setString(2,seminario.getExpositor());
            ps.setString(3, seminario.getFecha());
            ps.setString(4, seminario.getHora());
            ps.setInt(5, seminario.getCupo());
            ps.executeUpdate();
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        try{
            this.conectar();
            String sql = "UPDATE seminarios SET titulo = ?, expositor = ?, fecha = ?, hora = ?, cupo = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setString(2,seminario.getExpositor());
            ps.setString(3, seminario.getFecha());
            ps.setString(4, seminario.getHora());
            ps.setInt(5, seminario.getCupo());
            ps.setInt(6, seminario.getId());
            ps.executeUpdate();
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            String sql = "DELETE FROM seminarios WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario semi = new Seminario();
        try{
            this.conectar();
            String sql = "SELECT * FROM seminarios WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                semi.setId(rs.getInt("id"));
                semi.setTitulo(rs.getString("titulo"));
                semi.setExpositor(rs.getString("expositor"));
                semi.setFecha(rs.getString("fecha"));
                semi.setHora(rs.getString("hora"));
                semi.setCupo(rs.getInt("cupo"));
            }            
        }
        catch (Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
        return semi;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List<Seminario> lista = null;
        try{
            this.conectar();
            String sql = "SELECT * FROM seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seminario>();
            while(rs.next()){
                Seminario se = new Seminario();
                se.setId(rs.getInt("id"));
                se.setTitulo(rs.getString("titulo"));
                se.setExpositor(rs.getString("expositor"));
                se.setFecha(rs.getString("fecha"));
                se.setHora(rs.getString("hora"));
                se.setCupo(rs.getInt("cupo"));
                
                lista.add(se);
            }
        }catch (Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}
