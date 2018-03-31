/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.UsuarioDAL;
import DTO.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joylson
 */
public class UsuarioBLL {
   private UsuarioDAL _UsuarioDAL;

    public UsuarioBLL() {
       try {
           _UsuarioDAL = new UsuarioDAL();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public ArrayList<Usuario> GetAll(){
       try {
           ArrayList<Usuario> usuarios = _UsuarioDAL.GetAll();
           if(usuarios == null)
               throw new IOException("Nenhum usuario encontrado");
           return usuarios;
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    
    public Usuario Get(int id){
       try {
           Usuario usuario = _UsuarioDAL.Get(id);
           if(usuario == null)
               throw new IOException("Usuario não encontrado");
           return usuario;
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
   
    public void Insert(Usuario usuario){
       try {
           _UsuarioDAL.Insert(usuario);
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void Update(Usuario usuario){
       try {
           _UsuarioDAL.Update(usuario);
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void Delete(int id){
       try {
           _UsuarioDAL.Delete(id);
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioBLL.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
