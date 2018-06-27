
package Infraestrutura;

import Dominio.Features.Cuidador.Cuidador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dominio.Features.Cuidador.ICuidadorRepository;

public class CuidadorPostgresRepository implements ICuidadorRepository{
    private final String SQL_INSERT = "INSERT INTO TBCuidador (nome_cuidador, rg_cuidador, telefone_cuidador, cpf_cuidador, login_cuidador, senha_cuidador) VALUES (?,?,?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBCuidador SET nome_cuidador = ?, rg_cuidador = ?, telefone_cuidador = ?, cpf_cuidador = ?, login_cuidador = ?, senha_cuidador = ? WHERE id_cuidador = ?;";
    private final String SQL_DELETE = "DELETE FROM TBCuidador WHERE id_cuidador = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBCuidador;";
    private final String SQL_GET = "SELECT * FROM TBCuidador WHERE id_cuidador = ?;";
    private final String SQL_VERIFY_FK = "SELECT id_turma FROM TBTurma WHERE cuidador_Id = ?;";

    @Override
    public Cuidador adicionar(Cuidador cuidador) throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, cuidador);

        cuidador.setId(PostgresDAO.add(statement));
        return cuidador;
    }

    @Override
    public Cuidador atualizar(Cuidador cuidador) throws SQLException, Exception {
        if (cuidador.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, cuidador);
        statement.setInt(7, cuidador.getId());

        if (PostgresDAO.update(statement)) {
            return pegar(cuidador.getId());
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
    public List<Cuidador> pegarTodos() throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL);
        ResultSet rs = PostgresDAO.get(statement);
        List<Cuidador> lista = new ArrayList();
        while (rs.next()) {
            lista.add(make(rs));
        }
        return lista;
    }

    @Override
    public Cuidador pegar(int id) throws SQLException, Exception {
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

    private PreparedStatement prepareStatement(PreparedStatement statement, Cuidador cuidador) throws SQLException {
        statement.setString(1, cuidador.getNome());
        statement.setString(2,cuidador.getRG());
        statement.setString(3, cuidador.getTelefone());
        statement.setString(4, cuidador.getCPF());
        statement.setString(5, cuidador.getLogin());
        statement.setString(6, cuidador.getSenha());
        return statement;
    }

    private Cuidador make(ResultSet rs) throws SQLException {
        Cuidador cuidador = new Cuidador();
        cuidador.setId(rs.getInt("id_cuidador"));
        cuidador.setNome(rs.getString("nome_cuidador"));
        cuidador.setRG(rs.getString("rg_cuidador"));
        cuidador.setTelefone(rs.getString("telefone_cuidador"));
        cuidador.setCPF(rs.getString("cpf_cuidador"));
        cuidador.setSenha(rs.getString("senha_cuidador"));
        cuidador.setLogin(rs.getString("login_cuidador"));
        return cuidador;
    }
}
