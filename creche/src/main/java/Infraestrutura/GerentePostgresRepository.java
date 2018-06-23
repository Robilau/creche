package Infraestrutura;

import Dominio.Features.Gerente.IGerentePostgresRepository;
import Dominio.Features.Gerente.Gerente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerentePostgresRepository implements IGerentePostgresRepository{
    private final String SQL_INSERT = "INSERT INTO TBGerente (nome_gerente, rg_gerente, cpf_gerente, endereco_gerente, telefone_gerente) VALUES (?,?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBGerente SET nome_gerente = ?, rg_gerente = ?, cpf_gerente = ?, endereco_gerente = ?, telefone_gerente = ? WHERE id_gerente = ?;";
    private final String SQL_DELETE = "DELETE FROM TBGerente WHERE id_gerente = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBGerente;";
    private final String SQL_GET = "SELECT * FROM TBGerente WHERE id_gerente = ?;";
    private final String SQL_VERIFY_FK = "SELECT id_crianca FROM TBCrianca WHERE gerente_id = ?";
    
    @Override
    public Gerente adicionar(Gerente gerente) throws SQLException{
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, gerente);

        gerente.setId(PostgresDAO.add(statement));
        return gerente;
    }

    @Override
    public Gerente atualizar(Gerente gerente) throws SQLException, Exception {
        if (gerente.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, gerente);
        statement.setInt(6, gerente.getId());

        if (PostgresDAO.update(statement)) {
            return pegar(gerente.getId());
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
    public List<Gerente> pegarTodos() throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL);
        ResultSet rs = PostgresDAO.get(statement);
        List<Gerente> lista = new ArrayList();
        while (rs.next()) {
            lista.add(make(rs));
        }
        return lista;
    }

    @Override
    public Gerente pegar(int id) throws SQLException, Exception {
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

    private PreparedStatement prepareStatement(PreparedStatement statement, Gerente gerente) throws SQLException {
        statement.setString(1, gerente.getNome());
        statement.setString(2, gerente.getRG());
        statement.setString(3, gerente.getCPF());
        statement.setString(4, gerente.getTelefone());
        return statement;
    }

    private Gerente make(ResultSet rs) throws SQLException {
        Gerente gerente = new Gerente();
        gerente.setId(rs.getInt("id_gerente"));
        gerente.setNome(rs.getString("nome_gerente"));
        gerente.setRG(rs.getString("rg_gerente"));
        gerente.setCPF(rs.getString("cpf_gerente"));
        gerente.setTelefone(rs.getString("telefone_gerente"));
        gerente.setLogin(rs.getString("login_gerente"));
        gerente.setSenha(rs.getString("senha_gerente"));
        return gerente;
    }
}
