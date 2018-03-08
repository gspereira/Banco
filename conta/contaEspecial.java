package conta;

public class contaEspecial extends conta {
	
	private double limiteCheque;
	
	public contaEspecial(int agencia, int numero) {
		super(agencia, numero, 2);
		this.limiteCheque = 100;		
	}
	
	public contaEspecial(int agencia, int numero, double limite){
		super(agencia, numero, 2);
		try{
			this.limiteCheque = limite;
		}
		catch(Exception e){
			System.out.println("Valor invalido");
		}
	}
	
	public double getLimite(){
		return this.limiteCheque;
	}
	
	public String sacar(double valor){
		String retorno;
		if(valor <= (saldo + limiteCheque) && valor > 0){
			try{
				if(valor > saldo){
					valor -= this.saldo;
					this.saldo = 0;
					this.limiteCheque -= valor;
				} else {
					this.saldo -= valor;
				}
			}
			catch(Exception e){
				System.out.println("Valores invalidos");
			}
			retorno = "Seu novo saldo �: "+saldo+" Reais\n"
					+ "Limite do Cheque Epecial: "+limiteCheque+" Reais";
		} else {
			retorno = "N�o h� limite dispon�vel.";
		}
		return retorno;
	}
	
	

}
