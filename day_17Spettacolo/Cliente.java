package day_17Spettacolo;

import java.util.Objects;

public class Cliente {
	private String nome;
	private String telefono;

	public Cliente(String nome, String telefono) {
		this.nome = nome;
		this.telefono = telefono;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cliente cliente = (Cliente) o;
		return Objects.equals(nome, cliente.nome) && Objects.equals(telefono, cliente.telefono);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, telefono);
	}

	@Override
	public String toString() {
		return "Cliente{" + "nome='" + nome + '\'' + ", telefono='" + telefono + '\'' + '}';
	}
}
