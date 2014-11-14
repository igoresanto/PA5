/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package teste;
import Bean.PacienteBean;
import DAO.PacienteDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
*
* @author root
*/
public class TestePaciente {
public TestePaciente() {
}
@BeforeClass
public static void setUpClass() {
}
@AfterClass
public static void tearDownClass() {
}
@Before
public void setUp() {
}
@After
public void tearDown() {
}
/**
* Test of main method, of class teste.
*/
@Test
public void testSalvarPaciente() {
PacienteBean p = new PacienteBean();
PacienteDAO pdao = new PacienteDAO();
p.setId(3);
p.setNome("Astro");
p.setEndereco("Rua dos Astrologos");
p.setCidade("UFO");
p.setUf("MG");
p.setTelefone("3133443344");
p.setCelular("3186863344");
p.setEmail("astroboy@uai.com.br");
Assert.assertTrue(pdao.salvarPaciente(p));
}
@Test
public void testlistarPaciente() {
PacienteDAO pdao = new PacienteDAO();
Assert.assertTrue(!pdao.listarPaciente().isEmpty());
}

@Test
public void testeditarPaciente() {
PacienteDAO pdao = new PacienteDAO();
List<PacienteBean> listapaciente=pdao.listarPaciente();
Assert.assertTrue(pdao.editarPaciente(listapaciente.get(listapaciente.size()-1)));
}

@Test
public void testexcluirPaciente() {
PacienteDAO pdao = new PacienteDAO();
List<PacienteBean> listapaciente=pdao.listarPaciente();
Assert.assertTrue(pdao.excluirPaciente(listapaciente.get(listapaciente.size()-1)));
}

}