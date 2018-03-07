package conta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class contaPoupanca extends conta{
	
	LocalDate niver;
	private double rendimentoMes;
	private double taxaRendimento;
	private double taxaAnual;

	public double getRendimentoMes() {
		return rendimentoMes;
	}

	public void setRendimentoMes(double rendimentoMes) {
		this.rendimentoMes = rendimentoMes;
	}

	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public double getTaxaAnual() {
		return taxaAnual;
	}

	public void setTaxaAnual(double taxaAnual) {
		this.taxaAnual = taxaAnual;
	}

	public contaPoupanca(int agencia, int numero) {
		super(agencia, numero, 3);
		niver = LocalDate.now();
		this.rendimentoMes = 0;
		this.taxaRendimento = 0;
		this.taxaAnual = 0;
	}
	
	public String rendimento(double taxaMes, int mesAtual){
		double rendimentos = getSaldo() + ((getSaldo() / taxaMes) * 100);
		setSaldo(rendimentos);
		setRendimentoMes((getSaldo()/taxaMes)*100);
		setTaxaRendimento(taxaMes);
		if(mesAtual != 1){
			double taxaAnual = getTaxaAnual() + taxaMes;
			setTaxaAnual(taxaAnual);
		} else {
			setTaxaAnual(taxaMes);
		}
		return "Seu novo saldo �: "+getSaldo()+" Reais";
	}
	
	public String toString(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Conta Poupan�a: \n"
				+ "Ag�ncia: "+getAgencia()+"\n"
			    + "N�mero: "+getNumero()+"\n"
			    + "Saldo: "+getSaldo()+" Reais\n"
			    + "Anivers�rio da Conta: "+dtf.format(niver)+"\n"
			    + "Rendimentos Ultimo M�s: "+getRendimentoMes()+" Reais\n"
			    + "Taxa Ultimo Rendimento: "+getTaxaRendimento()+"%\n"
			    + "Taxa Anual Acumulada: "+getTaxaAnual()+"%";
	}
	

}
