package Aplicacao;

import Dominio.TipoUsuario;
import Dominio.Usuario;
import Infraestrutura.Login.IConfiguracoesLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T0KS1CK
 */
public class LoginService {

    IConfiguracoesLogin config;

    public LoginService(IConfiguracoesLogin config) {
        this.config = config;
    }

    public Usuario verificarUsuario(String login, String senha) {
        Usuario user = null;
        try {
            if (config.VerificarLoginGerente(login, senha))
            {
                user = new Usuario();
                user.setNome(config.getNome_da_pessoa_logada());
                user.setTipoUsuario(TipoUsuario.GERENTE);
            }
            else if (config.VerificarLoginCuidador(login, senha))
            {
                user = new Usuario();
                user.setNome(config.getNome_da_pessoa_logada());
                user.setTipoUsuario(TipoUsuario.CUIDADOR);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public boolean modificarSenhaGerente(String login, String senha, String novaSenha){
        return config.modificarSenhaGerente(login, senha, novaSenha);
    }
}
