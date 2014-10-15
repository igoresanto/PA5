package DAO;

import Bean.MedicoBean;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicoDAO {
    
    private Conexao Con;

    public MedicoDAO() {
        Con = new Conexao();
    }
    
    public boolean salvarMedico(MedicoBean medico){
        String sql = "INSERT INTO MEDICO (CRM, NOME, ENDERECO, CIDADE, UF, TELEFONE, CELULAR, EMAIL) "
                + "VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, medico.getCrm());
            stm.setString(2, medico.getNome());
            stm.setString(3, medico.getEndereco());
            stm.setString(4, medico.getCidade());
            stm.setString(5, medico.getUf());
            stm.setString(6, medico.getTelefone());
            stm.setString(7, medico.getCelular());
            stm.setString(8, medico.getEmail());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean editarMedico(MedicoBean medico){
        String sql = "UPDATE MEDICO SET CRM = ?, NOME = ?, ENDERECO = ?, CIDADE = ?, UF = ?, TELEFONE = ?,"
                + "CELULAR = ?, EMAIL = ? WHERE ID = ?;";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, medico.getCrm());
            stm.setString(2, medico.getNome());
            stm.setString(3, medico.getEndereco());
            stm.setString(4, medico.getCidade());
            stm.setString(5, medico.getUf());
            stm.setString(6, medico.getTelefone());
            stm.setString(7, medico.getCelular());
            stm.setString(8, medico.getEmail());
            stm.setInt(9, medico.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public boolean excluirMedico(MedicoBean medico){
        String sql = "DELETE FROM MEDICO WHERE ID = ?;";
        try {
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setInt(1, medico.getId());
            stm.execute();
            Con.getConnection().commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    public List<MedicoBean> listarMedico(){
        List<MedicoBean> lista = new ArrayList<MedicoBean>();
        try {
            String sql = "SELECT * FROM MEDICO;";
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                MedicoBean medico = new MedicoBean();
                medico.setId(rs.getInt("ID"));
                medico.setCrm(rs.getString("CRM"));
                medico.setNome(rs.getString("NOME"));
                medico.setEndereco(rs.getString("ENDERECO"));
                medico.setCidade(rs.getString("CIDADE"));
                medico.setUf(rs.getString("UF"));
                medico.setTelefone(rs.getString("TELEFONE"));
                medico.setCelular(rs.getString("CELULAR"));
                medico.setEmail(rs.getString("EMAIL"));
                lista.add(medico);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
