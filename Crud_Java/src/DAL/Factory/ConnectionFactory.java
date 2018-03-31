/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Factory;

import java.sql.*;

/**
 *
 * @author Joylson
 */
public class ConnectionFactory {
    
    private final String HOST = "jdbc:mysql://localhost/crud_java?autoReconnect=true&useSSL=false";
    private final String USER = "root";
    private final String PASS = "";
    private Connection _Conn;
    private PreparedStatement _Pstmt;

    public ConnectionFactory() throws ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");  
    }
    
    public void insertCommand(String command) throws SQLException{
        _Conn = DriverManager.getConnection(HOST,USER,PASS);
        _Pstmt = _Conn.prepareStatement(command);
    }  
    
    public void insertParameter(int position, Object parameter) throws SQLException{
        _Pstmt.setObject(position, parameter);
    }
    public void execulte() throws SQLException{
        _Pstmt.execute();
    }
    
    public ResultSet execulteResult() throws SQLException{
        return _Pstmt.executeQuery();
    }
    
    public void close() throws SQLException{
        if(!(_Conn.isClosed())){
            _Pstmt.close();
            _Conn.close();
        }
    }
}
