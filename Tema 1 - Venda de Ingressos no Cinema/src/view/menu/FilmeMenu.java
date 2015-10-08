package view.menu;

public class FilmeMenu {
    public static final int OP_CADASTRAR = 1;
    public static final int OP_REMOVER = 2;
    public static final int OP_LISTAR = 3;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Filmes\n"
                + "2- Remover Filmes\n"
                + "3- Listar Filmes\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }    
}
