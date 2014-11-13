package Controller;

import Bean.PacienteBean;
import DAO.PacienteDAO;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class PacienteController implements Serializable{
    
    private PacienteBean medicoB;
    private DataModel listaPacientes;

    public PacienteController() {
        medicoB = new PacienteBean();
    }

    public PacienteBean getPacienteB() {
        return medicoB;
    }

    public void setPacienteB(PacienteBean medicoB) {
        this.medicoB = medicoB;
    }

    public DataModel getListaPacientes() {
        PacienteDAO cD = new PacienteDAO();
        listaPacientes = new ListDataModel(cD.listarPaciente());
        return listaPacientes;
    }

    public void setListaPacientes(DataModel listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    public void novoPaciente(){
        medicoB = new PacienteBean();
    }  
    
    public void selecionarPaciente(){
        medicoB = (PacienteBean) listaPacientes.getRowData();
    }
    
    public String salvarPaciente(){
        PacienteDAO cD = new PacienteDAO();
        if (cD.salvarPaciente(medicoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CADASTRADO COM SUCESSO", ""));
            return "listarpacientes";
        }
        
        return "erro";
    }    
    
    public String editarPaciente(){
        PacienteDAO cD = new PacienteDAO();
        if (cD.editarPaciente(medicoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO COM SUCESSO", ""));
            return "listarpacientes";
        }
        
        return "erro";
    }
    
    public String excluirPaciente(){
        PacienteDAO cD = new PacienteDAO();
        if (cD.excluirPaciente(medicoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXCLUÍDO COM SUCESSO", ""));
            return "listarpacientes";
        }
        
        return "erro";
    }
    
    
    
}
