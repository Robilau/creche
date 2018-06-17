/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaPostgresRepository;
import Dominio.Features.RPC.Rpc;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author T0KS1CK
 */
public class CriancaPostgresRepository implements ICriancaPostgresRepository {

    private final String SQL_INSERT = "INSERT INTO TBCrianca (nome_crianca, rg_crianca, dataNascimento_crianca, rpc_id) VALUES (?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBCrianca SET nome_crianca = ?, rg_crianca = ?, dataNascimento_crianca = ?, rpc_id = ? WHERE id_crianca = ?;";
    private final String SQL_DELETE = "DELETE FROM TBCrianca WHERE id_crianca = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBCrianca c, TBRpc r WHERE c.rpc_id = r.id_rpc";
    private final String SQL_GET = "SELECT * FROM TBCrianca c, TBRpc r WHERE c.rpc_id = r.id_rpc AND c.id_crianca = ?";

    @Override
    public Crianca adicionar(Crianca crianca) throws SQLException{
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, crianca);

        crianca.setId(PostgresDAO.add(statement));
        return crianca;
    }

    @Override
    public Crianca atualizar(Crianca crianca) throws SQLException, Exception {
        if (crianca.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, crianca);
        statement.setInt(5, crianca.getId());

        if (PostgresDAO.update(statement)) {
            return pegar(crianca.getId());
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
    public List<Crianca> pegarTodas() throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL);
        ResultSet rs = PostgresDAO.get(statement);
        List<Crianca> lista = new ArrayList();
        while (rs.next()) {
            lista.add(make(rs));
        }
        return lista;
    }

    @Override
    public Crianca pegar(int id) throws SQLException, Exception {
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

    private PreparedStatement prepareStatement(PreparedStatement statement, Crianca crianca) throws SQLException {
        java.util.Date d = crianca.getDataNascimento();
        statement.setString(1, crianca.getNome());
        statement.setString(2, crianca.getRG());
        statement.setDate(3, new Date(d.getYear(), d.getMonth(), d.getDate()));
        statement.setInt(4, crianca.getResponsavelPelaCrianca().getId());
        return statement;
    }

    private Crianca make(ResultSet rs) throws SQLException {
        Crianca c = new Crianca();
        Rpc rpc = new Rpc();
        c.setId(rs.getInt("id_crianca"));
        c.setNome(rs.getString("nome_crianca"));
        c.setRG(rs.getString("rg_crianca"));
        c.setDataNascimento(rs.getDate("dataNascimento_crianca"));
        rpc.setId(rs.getInt("rpc_id"));
        rpc.setNome(rs.getString("nome_rpc"));
        rpc.setRG(rs.getString("rg_rpc"));
        rpc.setCPF(rs.getString("cpf_rpc"));
        rpc.setEndereco(rs.getString("endereco_rpc"));
        rpc.setTelefone(rs.getString("telefone_rpc"));
        c.setResponsavelPelaCrianca(rpc);
        return c;
    }
}
