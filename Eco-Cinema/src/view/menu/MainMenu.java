package view.menu;

public class MainMenu {

    public static final int OP_VENDAINGRESSOS = 1;
    public static final int OP_CADASTROS = 2;
    public static final int OP_RELATORIOS = 3;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Menu Ingressos\n"
                + "2- Menu Cadastros\n"
                + "3- Menu Relatórios\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }
}
