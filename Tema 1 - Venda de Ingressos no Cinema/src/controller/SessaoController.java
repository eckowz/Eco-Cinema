package controller;

import view.JanelaCrudSessao;
import view.PainelFormularioSessao;
import view.SessaoTableModel;
import view.PainelTabelaSessao;
import view.PrintUtil;
import dao.SessaoDao;
import dao.SessaoDaoBd;
import java.util.Date;
import model.Filme;
import model.Sala;
import model.Sessao;
import util.DateUtil;

/**
 *
 * @author gserafini
 */
public class SessaoController {

    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;
    private int linhaSelecionada = -1;

    private JanelaCrudSessao janela;

    public SessaoController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudSessao janela) {
        this.janela = janela;
    }

    public void inserirSessao() {
        PainelFormularioSessao painelForm = this.janela.getPainelFormulario();

        painelForm.zerarCampos();

        painelForm.getLabelPainelFormulario().setText("Cadastrar Sessao");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Cadastrar");
        painelForm.habilitaEdicaoFormSessao(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainelSessao(JanelaCrudSessao.PAINELFORM);
    }

    public void editarSessao() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        PainelFormularioSessao painelForm = this.janela.getPainelFormulario();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessoes().getModel();

        linhaSelecionada = painelTabela.getTabelaSessoes().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Sessao ses = tableModel.getSessao(linhaSelecionada);
        painelForm.carregarDados(DateUtil.dateHourToString(ses.getHorario()),
                ses.getFilme().getNomeFilme(), Integer.toString(ses.getSala().getCodSala()),
                Integer.toString(ses.getAssentosDisponiveis()));

        painelForm.getLabelPainelFormulario().setText("Editar Sessao");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        painelForm.habilitaEdicaoFormSessao(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainelSessao(JanelaCrudSessao.PAINELFORM);
    }

    public void visualizarSessao() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        PainelFormularioSessao form = this.janela.getPainelFormulario();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessoes().getModel();

        linhaSelecionada = painelTabela.getTabelaSessoes().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Sessao ses = tableModel.getSessao(linhaSelecionada);
        form.carregarDados(DateUtil.dateHourToString(ses.getHorario()),
                ses.getFilme().getNomeFilme(), Integer.toString(ses.getSala().getCodSala()),
                Integer.toString(ses.getAssentosDisponiveis()));
        form.getLabelPainelFormulario().setText("Visualizar Sessao");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        form.habilitaEdicaoFormSessao(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainelSessao(JanelaCrudSessao.PAINELFORM);
    }

    public void removerSessao() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessoes().getModel();
        linhaSelecionada = painelTabela.getTabelaSessoes().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Sessao ses = tableModel.getSessao(linhaSelecionada);
        SessaoDao dao = new SessaoDaoBd();
        dao.deletar(ses);
        PrintUtil.printMessageSucesso(janela, "Remoção realizada com sucesso!");

        this.atualizaTabela();
    }

    public void salvarSessao(Date horario, Filme filme, Sala sala, int qtdAssentos) {
        PainelFormularioSessao painelForm = this.janela.getPainelFormulario();
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessoes().getModel();
        if (telaAtual == FORMCADASTRO) {
            Sessao sessao = new Sessao(horario, filme, sala, qtdAssentos);
            SessaoDao dao = new SessaoDaoBd();
            dao.inserir(sessao);
            PrintUtil.printMessageSucesso(janela, "Cadastro realizado com sucesso!");
            painelForm.zerarCampos();
        } else {
            linhaSelecionada = painelTabela.getTabelaSessoes().getSelectedRow();
            int idSessao = tableModel.getSessao(linhaSelecionada).getIdSessao();
            Sessao sessao = new Sessao(idSessao, horario, filme, sala, qtdAssentos);
            SessaoDao dao = new SessaoDaoBd();
            dao.atualizar(sessao);
            PrintUtil.printMessageSucesso(janela, "Edição realizada com sucesso!");

        }

    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainelSessao(JanelaCrudSessao.PAINELTABELA);
    }

    public void atualizaTabela() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessoes().getModel();

        SessaoDao dao = new SessaoDaoBd();
        tableModel.setSessoes(dao.listar());

        painelTabela.getTabelaSessoes().updateUI();
    }
}
