/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DAL.Factory.ConnectionFactory;
import DTO.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joylson
 */
public class UsuarioDAL {
    private ConnectionFactory _Conn;

    public UsuarioDAL() throws ClassNotFoundException {
        _Conn = new ConnectionFactory();
    }    
    
    public ArrayList<Usuario> GetAll() throws SQLException{
        _Conn.insertCommand("SELECT * FROM Usuario");
        ResultSet rs = _Conn.execulteResult();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        while(rs.next()){
            usuarios.add( new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }       
        _Conn.close();
        return usuarios;
    } 
    
    public Usuario Get(int id) throws SQLException{
        _Conn.insertCommand("SELECT * FROM Usuario WHERE Id = ?");
        _Conn.insertParameter(1, id);
        Usuario usuario = null;
        ResultSet rs = _Conn.execulteResult();
        if(rs.next())
            usuario =  new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        _Conn.close();
        return usuario;
    }
    
    public void Insert(Usuario usuario) throws SQLException{  
        _Conn.insertCommand("INSERT INTO Usuario(Nome, Senha, Email) VALUES(?,?,?)");
        _Conn.insertParameter(1, usuario.getNome());
        _Conn.insertParameter(2, usuario.getSenha());
        _Conn.insertParameter(3, usuario.getEmail());
        _Conn.execulte();
        _Conn.close();
    } 
    
    public void Update(Usuario usuario) throws SQLException{
        _Conn.insertCommand("UPDATE Usuario SET Nome = ?, Senha = ?, Email = ? WHERE Id = ?");
        _Conn.insertParameter(1, usuario.getNome());
        _Conn.insertParameter(2, usuario.getSenha());
        _Conn.insertParameter(3, usuario.getEmail());
        _Conn.insertParameter(4, usuario.getId());        
        _Conn.execulte();
        _Conn.close();
    }
    
    public void Delete(int id) throws SQLException{
        _Conn.insertCommand("DELETE FROM Usuario WHERE Id = ?");
        _Conn.insertParameter(1, id); 
        _Conn.execulte();
        _Conn.close();
    }
    
}
