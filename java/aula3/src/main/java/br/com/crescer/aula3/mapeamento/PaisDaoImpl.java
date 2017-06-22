/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.mapeamento;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pessoa.Pessoa;

/**
 *
 * @author tais.silva
 */
public class PaisDaoImpl implements PaisDao { 
    
    private static final String INSERT_Pais = "INSERT INTO PESSOA (ID, NOME) VALUES (?,?)";
    private static final String UPDATE_Pais = "UPDATE PESSOA SET NOME = ? WHERE ID = ?";
    private static final String DELETE_Pais = "DELETE FROM PESSOA WHERE ID = ?";
    private static final String LOAD_Pais = "SELECT * FROM PESSOA WHERE ID = ?";

    @Override
    public void insert(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_Pais)) {

            preparedStatement.setLong(1, pais.getId());
            preparedStatement.setString(2, pais.getNome());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_Pais)) {
            preparedStatement.setString(1, pais.getNome());
            preparedStatement.setLong(2, pais.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_Pais)) {
            preparedStatement.setLong(1, pais.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Pais loadBy(Long id) {
        final Pais pais = new Pais();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_Pais)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    pais.setId(resultSet.getLong("ID"));
                    pais.setNome(resultSet.getString("NOME"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pais;
    }
}
