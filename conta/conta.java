package conta;

public class conta {
	private int agencia;
	private int numero;
	private int tipo;
	protected double saldo;
	
	public conta(int agencia, int numero, int tipo){
		try{
			this.agencia = agencia;
			this.numero = numero;
			this.tipo = tipo;
			saldo = 0.0;
		}
		catch(Exception e){
			System.out.println("Valores invalidos");
		}
	}
	
	public String depositar(double valor){
		try{
			saldo = saldo + valor;
			return "Seu novo saldo �: "+saldo+" Reais";
		}
		catch(Exception e){
			return "Valor invalido";
		}
	}
	
	public String sacar(double valor){
		try{
			if(saldo >= valor){
				saldo = saldo - valor;
				return "Seu novo saldo �: "+saldo+" Reais";
			} else {
				return "Saldo Insuficiente";
			}
		}
		catch(Exception e){
			return "Valor invalido";
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
		return "Ag�ncia: "+agencia+"\n"
			+ "N�mero: "+numero+"\n"
			+ "Saldo: "+saldo+" Reais";	
	}
	
	public String toString(contaCorrente contaCC){
		return "Conta corrente: \t"
				+ "Ag�ncia: "+contaCC.getAgencia()+"\n"
			    + "N�mero: "+contaCC.getNumero()+"\n"
			    + "Saldo: "+contaCC.getSaldo()+" Reais";
	}
	
	public String toString(contaEspecial contaEsp){
		return "Conta corrente: \t"
				+ "Ag�ncia: "+contaEsp.getAgencia()+"\n"
			    + "N�mero: "+contaEsp.getNumero()+"\n"
			    + "Limite: "+contaEsp.getSaldo()+" Reais\n"
			    + "Saldo: "+(contaEsp.getSaldo() + contaEsp.getLimite())+" Reais";
	}
}

