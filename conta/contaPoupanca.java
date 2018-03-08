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

	public void setRendimentoMes(double valorRenMes) {
		this.rendimentoMes = valorRenMes;
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

	public void setTaxaAnual(double renAnual) {
		this.taxaAnual = renAnual;
	}

	public contaPoupanca(int agencia, int numero) {
		super(agencia, numero, 3);
		niver = LocalDate.now();
		this.rendimentoMes = 0;
		this.taxaRendimento = 0;
		this.taxaAnual = 0;
	}
	
	public String rendimento(double taxaMes, int mesAtual){
		setRendimentoMes((getSaldo() / 100) * taxaMes);
		double rendimentos = getSaldo() + ((getSaldo() / 100) * taxaMes);
		setSaldo(rendimentos);
		setTaxaRendimento(taxaMes);
		if(mesAtual != 1){
			double taxaAnual = getTaxaAnual() + taxaMes;
			setTaxaAnual(taxaAnual);
		} else {
			setTaxaAnual(taxaMes);
		}
		return "Seu novo saldo é: "+getSaldo()+" Reais";
	}
	
	public String toString(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Conta Poupança: \n"
				+ "Agência: "+getAgencia()+"\n"
			    + "Número: "+getNumero()+"\n"
			    + "Saldo: "+getSaldo()+" Reais\n"
			    + "Aniversário da Conta: "+dtf.format(niver)+"\n"
			    + "Rendimentos Ultimo Mês: "+getRendimentoMes()+" Reais\n"
			    + "Taxa Ultimo Rendimento: "+getTaxaRendimento()+"%\n"
			    + "Taxa Anual Acumulada: "+getTaxaAnual()+"%";
	}
	

}
