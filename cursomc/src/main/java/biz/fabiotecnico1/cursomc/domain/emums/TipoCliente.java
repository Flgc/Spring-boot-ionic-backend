package biz.fabiotecnico1.cursomc.domain.emums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	//Constructor using field
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//Getters
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod){ //Operação que recebe um código (Inteiro) e retorna o objeto tipoCliente

		if (cod == null) {		
			return null;		//para proteção de objeto nulo
		}
		
		for (TipoCliente x : TipoCliente.values()) { //Percorre todos valores possíveis do objetos x do tipoCliente
			
			if (cod.equals(x.getCod())) {
				return x;						//Se encontrar cod igual ao percorrido objeto x
			}
		}
		
		//Exceção
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
