package br.com.crescer.aula3;

/**
 * @author carloshenrique
 */
public class ExemploTestDao {

    public static void main(String[] args) {
        final TestDao testDao = new TestDaoImpl();
        testDao.drop();
        testDao.create();
        testDao.insert();
    }
}
