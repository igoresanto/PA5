package DAO;

import Bean.PacienteBean;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteDAO {
    
    private Conexao Con;

    public PacienteDAO() {
        Con = new Conexao();
    }
    
    public boolean salvarPaciente(PacienteBean paciente){
        String sql = "INSERT INTO PACIENTE (NOME, ENDERECO, CIDADE, UF, TELEFONE, CELULAR, EMAIL) "
                + "VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, paciente.getNome());
            stm.setString(2, paciente.getEndereco());
            stm.setString(3, paciente.getCidade());
            stm.setString(4, paciente.getUf());
            stm.setString(5, paciente.getTelefone());
            stm.setString(6, paciente.getCelular());
            stm.setString(7, paciente.getEmail());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean editarPaciente(PacienteBean paciente){
        String sql = "UPDATE PACIENTE SET NOME = ?, ENDERECO = ?, CIDADE = ?, UF = ?, TELEFONE = ?,"
                + "CELULAR = ?, EMAIL = ? WHERE ID = ?;";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, paciente.getNome());
            stm.setString(2, paciente.getEndereco());
            stm.setString(3, paciente.getCidade());
            stm.setString(4, paciente.getUf());
            stm.setString(5, paciente.getTelefone());
            stm.setString(6, paciente.getCelular());
            stm.setString(7, paciente.getEmail());
            stm.setInt(8, paciente.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean excluirPaciente(PacienteBean paciente){
        String sql = "DELETE FROM PACIENTE WHERE ID = ?;";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setInt(1, paciente.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public List<PacienteBean> listarPaciente(){
        List<PacienteBean> lista = new ArrayList<PacienteBean>();
        try {
            String sql = "SELECT * FROM PACIENTE;";
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                PacienteBean paciente = new PacienteBean();
                paciente.setId(rs.getInt("ID"));
                paciente.setNome(rs.getString("NOME"));
                paciente.setEndereco(rs.getString("ENDERECO"));
                paciente.setCidade(rs.getString("CIDADE"));
                paciente.setUf(rs.getString("UF"));
                paciente.setTelefone(rs.getString("TELEFONE"));
                paciente.setCelular(rs.getString("CELULAR"));
                paciente.setEmail(rs.getString("EMAIL"));
                lista.add(paciente);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
