package conta;

public class conta {
	private int agencia;
	private int numero;
	private int tipo;
	protected double saldo;
	
	public conta(int agencia, int numero, int tipo){
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
		saldo = 0.0;
	}
	
	public String depositar(double valor){
		saldo = saldo + valor;
		return "Seu novo saldo é: "+saldo+" Reais";
	}
	
	public String sacar(double valor){
		if(saldo >= valor){
			saldo = saldo - valor;
			return "Seu novo saldo é: "+saldo+" Reais";
		} else {
			return "Saldo Insuficiente";
		}
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public int getAgencia(){
		return this.agencia;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void setSaldo(double valor){
		saldo = valor;
	}
	
	public String toString(){
		return "Agência: "+agencia+"\n"
			+ "Número: "+numero+"\n"
			+ "Saldo: "+saldo+" Reais";	
	}
	
	public String toString(contaCorrente contaCC){
		return "Conta corrente: \t"
				+ "Agência: "+contaCC.getAgencia()+"\n"
			    + "Número: "+contaCC.getNumero()+"\n"
			    + "Saldo: "+contaCC.getSaldo()+" Reais";
	}
	
	public String toString(contaEspecial contaEsp){
		return "Conta corrente: \t"
				+ "Agência: "+contaEsp.getAgencia()+"\n"
			    + "Número: "+contaEsp.getNumero()+"\n"
			    + "Limite: "+contaEsp.getSaldo()+" Reais\n"
			    + "Saldo: "+(contaEsp.getSaldo() + contaEsp.getLimite())+" Reais";
	}
}

