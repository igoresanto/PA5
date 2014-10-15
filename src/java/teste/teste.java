package teste;

import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class teste {
    
    public static void main(String[] args) {
        try {
            Conexao Con = new Conexao();
            PreparedStatement stm = Con.getConnection().prepareStatement("select * from contato");
            ResultSet rs = stm.executeQuery();
            rs.next();
            System.out.println(rs.getString("nome"));
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
