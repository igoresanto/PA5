package Controller;

import Bean.ContatoBean;
import DAO.ContatoDAO;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ContatoController implements Serializable{
    
    private ContatoBean contatoB;
    private DataModel listaContatos;

    public ContatoController() {
        contatoB = new ContatoBean();
    }

    public ContatoBean getContatoB() {
        return contatoB;
    }

    public void setContatoB(ContatoBean contatoB) {
        this.contatoB = contatoB;
    }

    public DataModel getListaContatos() {
        ContatoDAO cD = new ContatoDAO();
        listaContatos = new ListDataModel(cD.listarContato());
        return listaContatos;
    }

    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    
    public void novoContato(){
        contatoB = new ContatoBean();
    }  
    
    public void selecionarContato(){
        contatoB = (ContatoBean) listaContatos.getRowData();
    }
    
    public String salvarContato(){
        ContatoDAO cD = new ContatoDAO();
        if (cD.salvarContato(contatoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CADASTRADO COM SUCESSO", ""));
            return "listarcontatos";
        }
        
        return "erro";
    }    
    
    public String editarContato(){
        ContatoDAO cD = new ContatoDAO();
        if (cD.editarContato(contatoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO COM SUCESSO", ""));
            return "listarcontatos";
        }
        
        return "erro";
    }
    
    public String excluirContato(){
        ContatoDAO cD = new ContatoDAO();
        if (cD.excluirContato(contatoB)) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXCLUÍDO COM SUCESSO", ""));
            return "listarcontatos";
        }
        
        return "erro";
    }
    
    
    
}
