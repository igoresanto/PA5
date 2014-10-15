package Controller;

import Bean.MedicoBean;
import DAO.MedicoDAO;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class MedicoController implements Serializable{
    
    private MedicoBean medicoB;
    private DataModel listaMedicos;

    public MedicoController() {
        medicoB = new MedicoBean();
    }

    public MedicoBean getMedicoB() {
        return medicoB;
    }

    public void setMedicoB(MedicoBean medicoB) {
        this.medicoB = medicoB;
    }

    public DataModel getListaMedicos() {
        MedicoDAO cD = new MedicoDAO();
        listaMedicos = new ListDataModel(cD.listarMedico());
        return listaMedicos;
    }

    public void setListaMedicos(DataModel listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
    
    public void novoMedico(){
        medicoB = new MedicoBean();
    }  
    
    public void selecionarMedico(){
        medicoB = (MedicoBean) listaMedicos.getRowData();
    }
    
    public String salvarMedico(){
        MedicoDAO cD = new MedicoDAO();
        if (cD.salvarMedico(medicoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CADASTRADO COM SUCESSO", ""));
            return "listarmedicos";
        }
        
        return "erro";
    }    
    
    public String editarMedico(){
        MedicoDAO cD = new MedicoDAO();
        if (cD.editarMedico(medicoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO COM SUCESSO", ""));
            return "listarmedicos";
        }
        
        return "erro";
    }
    
    public String excluirMedico(){
        MedicoDAO cD = new MedicoDAO();
        if (cD.excluirMedico(medicoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXCLUÍDO COM SUCESSO", ""));
            return "listarmedicos";
        }
        
        return "erro";
    }
    
    
    
}
