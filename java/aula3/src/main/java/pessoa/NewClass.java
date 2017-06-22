package pessoa;

/**
 * @author carloshenrique
 */
public class NewClass {
    
    public static void main(String[] args) {
        final PessoaDao pessoaDao = new PessoaDaoImpl();
        
        final Pessoa pessoa = new Pessoa();
        
        pessoa.setId(1l);
        pessoa.setNome("Carlos");
        
        pessoaDao.delete(pessoa);
        
        
    }
    
}
