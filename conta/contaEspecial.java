package conta;

public class contaEspecial extends conta {
	
	private double limiteCheque;
	
	public contaEspecial(int agencia, int numero) {
		super(agencia, numero, 2);
		this.limiteCheque = 100;		
	}
	
	public contaEspecial(int agencia, int numero, double limite){
		super(agencia, numero, 2);
		this.limiteCheque = limite;
	}
	
	public double getLimite(){
		return this.limiteCheque;
	}
	
	public String sacar(double valor){
		String retorno;
		if(valor <= (saldo + limiteCheque) && valor > 0){
			if(valor > saldo){
				valor -= this.saldo;
				this.saldo = 0;
				this.limiteCheque -= valor;
			} else {
				this.saldo -= valor;
			}
			retorno = "Seu novo saldo é: "+saldo+" Reais\n"
					+ "Limite do Cheque Epecial: "+limiteCheque+" Reais";
		} else {
			retorno = "Não há limite disponível.";
		}
		return retorno;
	}
	
	

}
