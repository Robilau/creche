/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Features.RPC.IRpcPostgresRepository;
import Dominio.Features.RPC.Rpc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class RpcPostgresRepository implements IRpcPostgresRepository {
    private final String SQL_INSERT = "INSERT INTO TBRpc (nome_rpc, rg_rpc, cpf_rpc, endereco_rpc, telefone_rpc) VALUES (?,?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBRpc SET nome_rpc = ?, rg_rpc = ?, cpf_rpc = ?, endereco_rpc = ?, telefone_rpc = ? WHERE id_rpc = ?;";
    private final String SQL_DELETE = "DELETE FROM TBRpc WHERE id_rpc = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBRpc;";
    private final String SQL_GET = "SELECT * FROM TBRpc WHERE id_rpc = ?;";
    private final String SQL_VERIFY_FK = "SELECT id_crianca FROM TBCrianca WHERE rpc_id = ?";
    
    @Override
    public Rpc adicionar(Rpc rpc) throws SQLException{
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, rpc);

        rpc.setId(PostgresDAO.add(statement));
        return rpc;
    }

    @Override
    public Rpc atualizar(Rpc rpc) throws SQLException, Exception {
        if (rpc.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, rpc);
        statement.setInt(6, rpc.getId());

        if (PostgresDAO.update(statement)) {
            return pegar(rpc.getId());
        }
        return null;
    }

    @Override
    public boolean deletar(int id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_DELETE);
        statement.setInt(1, id);
        return PostgresDAO.delete(statement);
    }
    
    @Override
    public boolean ExisteForeignKey(int id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_VERIFY_FK);
        statement.setInt(1, id);
        ResultSet rs = PostgresDAO.get(statement);
        if (rs.next()) return true;
        return false;
    }

    @Override
    public List<Rpc> pegarTodos() throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL);
        ResultSet rs = PostgresDAO.get(statement);
        List<Rpc> lista = new ArrayList();
        while (rs.next()) {
            lista.add(make(rs));
        }
        return lista;
    }

    @Override
    public Rpc pegar(int id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GET);
        statement.setInt(1, id);
        ResultSet rs = PostgresDAO.get(statement);
        if (rs.next()) {
            return make(rs);
        }
        return null;
    }

    private PreparedStatement prepareStatement(PreparedStatement statement, Rpc rpc) throws SQLException {
        statement.setString(1, rpc.getNome());
        statement.setString(2, rpc.getRG());
        statement.setString(3, rpc.getCPF());
        statement.setString(4, rpc.getEndereco());
        statement.setString(5, rpc.getTelefone());
        return statement;
    }

    private Rpc make(ResultSet rs) throws SQLException {
        Rpc rpc = new Rpc();
        rpc.setId(rs.getInt("id_rpc"));
        rpc.setNome(rs.getString("nome_rpc"));
        rpc.setRG(rs.getString("rg_rpc"));
        rpc.setCPF(rs.getString("cpf_rpc"));
        rpc.setEndereco(rs.getString("endereco_rpc"));
        rpc.setTelefone(rs.getString("telefone_rpc"));
        return rpc;
    }

    
}
