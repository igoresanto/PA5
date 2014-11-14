/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.MedicoBean;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IGOR
 */
public class MedicoDAOTest {

    public MedicoDAOTest() {
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
     * Test of salvarMedico method, of class MedicoDAO.
     */
    @Test
    public void testSalvarPaciente() {
        MedicoBean p = new MedicoBean();
        MedicoDAO pdao = new MedicoDAO();
        p.setId(3);
        p.setNome("Astro");
        p.setEndereco("Rua dos Astrologos");
        p.setCidade("UFO");
        p.setUf("MG");
        p.setTelefone("3133443344");
        p.setCelular("3186863344");
        p.setEmail("astroboy@uai.com.br");
        Assert.assertTrue(pdao.salvarMedico(p));
    }

    @Test
    public void testlistarPaciente() {
        MedicoDAO pdao = new MedicoDAO();
        Assert.assertTrue(!pdao.listarMedico().isEmpty());
    }

    @Test
    public void testeditarPaciente() {
        MedicoDAO pdao = new MedicoDAO();
        List<MedicoBean> listapaciente = pdao.listarMedico();
        Assert.assertTrue(pdao.editarMedico(listapaciente.get(listapaciente.size() - 1)));
    }

    @Test
    public void testexcluirPaciente() {
        MedicoDAO pdao = new MedicoDAO();
        List<MedicoBean> listapaciente = pdao.listarMedico();
        Assert.assertTrue(pdao.excluirMedico(listapaciente.get(listapaciente.size() - 1)));
    }

}
