package controller;

import view.JanelaCrudSala;
import view.PainelFormularioSala;
import view.SalaTableModel;
import view.PainelTabelaSala;
import view.PrintUtil;
import dao.SalaDao;
import dao.SalaDaoBd;
import model.Sala;

/**
 *
 * @author gserafini
 */
public class SalaController {

    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;
    private int linhaSelecionada = -1;

    private JanelaCrudSala janela;

    public SalaController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudSala janela) {
        this.janela = janela;
    }

    public void inserirSala() {
        PainelFormularioSala painelForm = this.janela.getPainelFormulario();

        painelForm.zerarCampos();

        painelForm.getLabelPainelFormulario().setText("Cadastrar Sala");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Cadastrar");
        painelForm.habilitaEdicaoFormSala(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainelSala(JanelaCrudSala.PAINELFORM);
    }

    public void editarSala() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        PainelFormularioSala painelForm = this.janela.getPainelFormulario();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSalas().getModel();

        linhaSelecionada = painelTabela.getTabelaSalas().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Sala sal = tableModel.getSala(linhaSelecionada);
        painelForm.carregarDados(Integer.toString(sal.getCodSala()), Integer.toString(sal.getQuantidadeAssentos()));

        painelForm.getLabelPainelFormulario().setText("Editar Sala");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        painelForm.habilitaEdicaoFormSala(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainelSala(JanelaCrudSala.PAINELFORM);
    }

    public void visualizarSala() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        PainelFormularioSala form = this.janela.getPainelFormulario();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSalas().getModel();

        linhaSelecionada = painelTabela.getTabelaSalas().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Sala sal = tableModel.getSala(linhaSelecionada);
        form.carregarDados(Integer.toString(sal.getCodSala()), Integer.toString(sal.getQuantidadeAssentos()));

        form.getLabelPainelFormulario().setText("Visualizar Sala");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        form.habilitaEdicaoFormSala(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainelSala(JanelaCrudSala.PAINELFORM);
    }

    public void removerSala() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSalas().getModel();
        linhaSelecionada = painelTabela.getTabelaSalas().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Sala sal = tableModel.getSala(linhaSelecionada);
        SalaDao dao = new SalaDaoBd();
        dao.deletar(sal);
        PrintUtil.printMessageSucesso(janela, "Remoção realizada com sucesso!");

        this.atualizaTabela();
    }

    public void salvarSala(int codSala, int qtdAssentos) {
        PainelFormularioSala painelForm = this.janela.getPainelFormulario();
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSalas().getModel();
        if (telaAtual == FORMCADASTRO) {
            Sala sala = new Sala(codSala, qtdAssentos);
            SalaDao dao = new SalaDaoBd();
            dao.inserir(sala);
            PrintUtil.printMessageSucesso(janela, "Cadastro realizado com sucesso!");
            painelForm.zerarCampos();
        } else {
            linhaSelecionada = painelTabela.getTabelaSalas().getSelectedRow();
            int idSala = tableModel.getSala(linhaSelecionada).getIdSala();
            Sala sala = new Sala(idSala, codSala, qtdAssentos);
            SalaDao dao = new SalaDaoBd();
            dao.atualizar(sala);
            PrintUtil.printMessageSucesso(janela, "Edição realizada com sucesso!");

        }

    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainelSala(JanelaCrudSala.PAINELTABELA);
    }

    public void atualizaTabela() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSalas().getModel();

        SalaDao dao = new SalaDaoBd();
        tableModel.setSalas(dao.listar());

        painelTabela.getTabelaSalas().updateUI();
    }
}
