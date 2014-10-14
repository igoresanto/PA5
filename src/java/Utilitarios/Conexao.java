package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private final String driver = "org.gjt.mm.mysql.Driver";
    private final String url = "jdbc:mysql://localhost:3306/agenda";
    private final String usuario = "root";
    private final String senha = "";
    private Connection Con;

    public Conexao() {    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public Connection getConnection(){
        if(Con == null){
            try {
                Con = DriverManager.getConnection(url, usuario, senha);
                Con.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return Con;
    }
    
    public void desconecta(){
        try {
            Con.close();
            Con = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
