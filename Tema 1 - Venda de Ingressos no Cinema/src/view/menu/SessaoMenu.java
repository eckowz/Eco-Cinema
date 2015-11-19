package view.menu;

public class SessaoMenu {

    public static final int OP_NOVO = 1;
    public static final int OP_REMOVER = 2;
    public static final int OP_LISTAR = 3;
    public static final int OP_EDITAR = 4;
    public static final int OP_CONSULTARFILME = 5;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar sessão\n"
                + "2- Remover sessão\n"
                + "3- Listar sessões\n"
                + "4- Editar sessão\n"
                //+ "5- Consultar sessão por filme\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
}
