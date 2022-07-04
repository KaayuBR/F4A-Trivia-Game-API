package F4A.triviagame.rest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "usuario")
public class UserModel {

	@Id
	public Integer codigo;
	
	@Column(nullable = false, length = 50)
	public String identificadorUnico;
	
	@Column(length = 500)
	public String discordname;
	
	@Column(length = 500)
	public String username;
	
	@Column(length = 500)
	public int pontuacao;

	
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getIdentificadorUnico() {
		return identificadorUnico;
	}

	public void setIdentificadorUnico(String identificadorUnico) {
		this.identificadorUnico = identificadorUnico;
	}

	public String getDiscordname() {
		return discordname;
	}

	public void setDiscordname(String discordname) {
		this.discordname = discordname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
