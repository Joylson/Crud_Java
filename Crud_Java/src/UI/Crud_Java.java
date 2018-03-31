/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.UsuarioBLL;
import DTO.Usuario;
import java.util.Scanner;

/**
 *
 * @author Joylson
 */
public class Crud_Java {

    private static UsuarioBLL _UsuarioBLL;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        _UsuarioBLL = new UsuarioBLL();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Dados do banco");
            _UsuarioBLL.GetAll().forEach((usuario) -> {
                System.out.println("Id: " + usuario.getId() +" Nome: " + usuario.getNome() + " Senha: " + usuario.getSenha() + " Email: " + usuario.getEmail());
            });
            System.out.println("Digite um teclado \n G - Pesquisar usuario por ID \n I - Inserir usuario \n U - Alterar usuario \n D - Deletar usuario por ID");
            String Tecla = sc.nextLine();
            switch(Tecla){
                case "G": 
                    System.out.println("Digite o ID para pesquisar");
                    int id = Integer.parseInt(sc.nextLine());
                    Usuario usuario = _UsuarioBLL.Get(id);  
                    System.out.println("Id: " + usuario.getId() +" Nome: " + usuario.getNome() + " Senha: " + usuario.getSenha() + " Email: " + usuario.getEmail());
                    break;
                case "I":
                    System.out.println("Coloque os dados do usuario");
                    Usuario usuarioI = new Usuario();
                    System.out.println("Nome: ");
                    usuarioI.setNome(sc.nextLine());
                    System.out.println("Senha: ");                 
                    usuarioI.setSenha(sc.nextLine());
                    System.out.println("Email: ");
                    usuarioI.setEmail(sc.nextLine());
                    _UsuarioBLL.Insert(usuarioI);
                    break;
                case "U":
                    System.out.println("Coloque os dados do usuario");
                    Usuario usuarioU = new Usuario();
                    System.out.println("Id: ");
                    usuarioU.setId(Integer.parseInt(sc.nextLine()));
                    System.out.println("Nome: ");
                    usuarioU.setNome(sc.nextLine());
                    System.out.println("Senha: ");                 
                    usuarioU.setSenha(sc.nextLine());
                    System.out.println("Email: ");
                    usuarioU.setEmail(sc.nextLine());
                    _UsuarioBLL.Update(usuarioU);
                    break;
                case "D":                    
                    System.out.println("ID usuario a ser deletado");
                    _UsuarioBLL.Delete(Integer.parseInt(sc.nextLine()));
                    break;
            }
            System.out.println("Digite S para sair");
            String sair = sc.nextLine();
            if(sair.equals("S"))
                break;
        }
    }
    
}
