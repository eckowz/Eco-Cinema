
package view.menu;

/**
 *
 * @author gserafini
 */
public class CadastroMenu {
    public static final int OP_CADASTROFILME = 1;
    public static final int OP_CADASTROSALA = 2;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Filmes\n"
                + "2- Cadastrar Salas\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }    
}
