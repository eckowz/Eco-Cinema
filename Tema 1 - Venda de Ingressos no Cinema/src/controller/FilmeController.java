package controller;

import view.JanelaCrudFilme;
import view.PainelFormularioFilme;
import view.FilmeTableModel;
import view.PainelTabelaFilme;
import view.PrintUtil;
import dao.FilmeDao;
import dao.FilmeDaoBd;
import model.Filme;

/**
 *
 * @author gserafini
 */
public class FilmeController {

    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;
    private int linhaSelecionada = -1;

    private JanelaCrudFilme janela;

    public FilmeController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudFilme janela) {
        this.janela = janela;
    }

    public void inserirFilme() {
        PainelFormularioFilme painelForm = this.janela.getPainelFormulario();

        painelForm.zerarCampos();

        painelForm.getLabelPainelFormulario().setText("Cadastrar Filme");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Cadastrar");
        painelForm.habilitaEdicaoFormFilme(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainelFilme(JanelaCrudFilme.PAINELFORM);
    }

    public void editarFilme() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        PainelFormularioFilme painelForm = this.janela.getPainelFormulario();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilmes().getModel();

        linhaSelecionada = painelTabela.getTabelaFilmes().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Filme film = tableModel.getFilme(linhaSelecionada);
        painelForm.carregarDados(film.getNomeFilme(),film.getGeneroFilme(), film.getSinopseFilme());

        painelForm.getLabelPainelFormulario().setText("Editar Filme");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        painelForm.habilitaEdicaoFormFilme(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainelFilme(JanelaCrudFilme.PAINELFORM);
    }

    public void visualizarFilme() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        PainelFormularioFilme form = this.janela.getPainelFormulario();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilmes().getModel();

        linhaSelecionada = painelTabela.getTabelaFilmes().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Filme film = tableModel.getFilme(linhaSelecionada);
        form.carregarDados(film.getNomeFilme(), film.getGeneroFilme(), film.getSinopseFilme());

        form.getLabelPainelFormulario().setText("Visualizar Filme");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        form.habilitaEdicaoFormFilme(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainelFilme(JanelaCrudFilme.PAINELFORM);
    }

    public void removerFilme() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilmes().getModel();
        linhaSelecionada = painelTabela.getTabelaFilmes().getSelectedRow();
        if (linhaSelecionada < 0) {
            PrintUtil.printMessageError(janela, "Não há nenhum elemento selecionado na tabela");
            return;
        }
        Filme film = tableModel.getFilme(linhaSelecionada);
        FilmeDao dao = new FilmeDaoBd();
        dao.deletar(film);
        PrintUtil.printMessageSucesso(janela, "Remoção realizada com sucesso!");

        this.atualizaTabela();
    }

    public void salvarFilme(String titulo, String genero, String sinopse) {
        PainelFormularioFilme painelForm = this.janela.getPainelFormulario();
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilmes().getModel();
        if (telaAtual == FORMCADASTRO) {
            Filme filme = new Filme(titulo, genero, sinopse);
            FilmeDao dao = new FilmeDaoBd();
            dao.inserir(filme);
            PrintUtil.printMessageSucesso(janela, "Cadastro realizado com sucesso!");
            painelForm.zerarCampos();
        } else {
            linhaSelecionada = painelTabela.getTabelaFilmes().getSelectedRow();
            int idFilme = tableModel.getFilme(linhaSelecionada).getIdFilme();
            Filme filme = new Filme(idFilme, titulo, genero, sinopse);
            FilmeDao dao = new FilmeDaoBd();
            dao.atualizar(filme);
            PrintUtil.printMessageSucesso(janela, "Edição realizada com sucesso!");

        }

    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainelFilme(JanelaCrudFilme.PAINELTABELA);
    }

    public void atualizaTabela() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilmes().getModel();

        FilmeDao dao = new FilmeDaoBd();
        tableModel.setFilmes(dao.listar());

        painelTabela.getTabelaFilmes().updateUI();
    }
}
