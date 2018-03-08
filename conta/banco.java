package conta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class banco {
	
	//Scanner
	public static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<conta> contas = new ArrayList<conta>();
	
	public static int intCheck(){
		try{
			return sc.nextInt();
		} catch (InputMismatchException e){
			sc.next();
			System.out.println("Digite um número válido!");
			return 0;
		}
	}
	
	public static double doubleCheck(){
		try{
			return sc.nextDouble();
		} catch (InputMismatchException e){
			sc.next();
			System.out.println("Digite um número válido!");
			return 0;
		}
	}
	
	public static int procurarConta(int numConta){
		int ret = 0;
		if(contas.isEmpty()){
			ret = -1;
		}
		int check;
		for(int i = 1; i < contas.size(); i++){
			check = contas.get(i).getNumero();
			if(check == numConta){
				ret = i;
			}
		}
		return ret;
	}
	
	public static String listar(int pos){
		String tipo = null;
		if(contas.get(pos).getTipo() == 1){
			tipo = "Conta Corrente";
		}
		else if (contas.get(pos).getTipo() == 2){
			tipo = "Conta Especial";
		}
		else if(contas.get(pos).getTipo() == 3){
			tipo = "Conta Poupança";
		}
		return contas.get(pos).getAgencia()+"\t\t   "+contas.get(pos).getNumero()+"\t\t"+tipo;
	}

	public static void main(String[] args) {
		//Pega data local
		Date data =  new Date();
		Locale local = new Locale("pt","BR");
		DateFormat dataLocal = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
		LocalDate localDate = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int mesLocal = localDate.getMonthValue();
		
		int escolha = 0;
		
		System.out.println("Bem vindo, hoje é dia: "+dataLocal.format(data));
		System.out.print("Insira o número da agência: ");
		int agencia = intCheck();
		while(agencia == 0){
			System.out.print("Insira o número da agência: ");
			agencia = intCheck();
		}
		
		while(escolha != 4){
			System.out.println("Você deseja?");
			System.out.println("(1)- Criar uma conta\n"
							 + "(2)- Pesquisar uma conta\n"
							 + "(3)- Listar contas existentes");
			escolha = intCheck();
			while(escolha == 0){
				escolha = intCheck();
			}
			if(escolha == 1){
				System.out.println("Qual o tipo de conta?\n"
								 + "(1)- Conta Corrente\n"
								 + "(2)- Conta Especial\n"
								 + "(3)- Conta Poupança");
				escolha = intCheck();
				while(escolha == 0){
					escolha = intCheck();
				}
				int numConta =0;
				switch(escolha){
				
					case 1:
						System.out.print("Digite o número da conta: ");
						numConta = intCheck();
						while(numConta == 0){
							numConta = intCheck();
						}
						contaCorrente contaCC = new contaCorrente(agencia,numConta);
						contas.add(contaCC);
						System.out.println("##########################################");
						System.out.println("Conta n° "+numConta+" Criada com sucesso.");
						System.out.println("##########################################");
						escolha = 0;
						break;
						
					case 2:
						System.out.print("Digite o número da conta: ");
						numConta = intCheck();
						while(numConta == 0){
							numConta = intCheck();
						}
						System.out.println("Será utilizada o limite padrão (100 R$)?\n"
									     + "(1)- Sim\n"
									     + "(2)- Não");
						escolha = intCheck();
						while(escolha == 0){
							escolha = intCheck();
						}
						if(escolha == 2){
							System.out.print("Informe o limite do cheque especial: ");
							double limite = doubleCheck();
							while(limite == 0){
								limite = doubleCheck();
							}
							contaEspecial contaEsp = new contaEspecial(agencia,numConta,limite);
							contas.add(contaEsp);
							System.out.println("##########################################");
							System.out.println("Conta n° "+numConta+" Criada com sucesso.");
							System.out.println("##########################################");
							escolha = 0;
							break;
						}
						else{
							contaEspecial contaEsp = new contaEspecial(agencia,numConta);
							contas.add(contaEsp);
							System.out.println("##########################################");
							System.out.println("Conta n° "+numConta+" Criada com sucesso.");
							System.out.println("##########################################");
							escolha = 0;
							break;
						}
						
					case 3:
						System.out.print("Digite o número da conta: ");
						numConta = intCheck();
						while(numConta == 0){
							numConta = intCheck();
						}
						contaPoupanca contaPoup = new contaPoupanca(agencia,numConta);
						contas.add(contaPoup);
						System.out.println("##########################################");
						System.out.println("Conta n° "+numConta+" Criada com sucesso.");
						System.out.println("##########################################");
						escolha = 0;
						break;
				}
			}
			else if(escolha == 2){
				escolha = 0;
				System.out.print("Digite o número da conta a ser localizada: ");
				 int numConta = intCheck();
				 while(numConta == 0){
						numConta = intCheck();		
				 }
				 int check = procurarConta(numConta);
				 if(check == -1){
					 System.out.println("Conta Inexistente");
				 } else {
	 				System.out.println("##########################################");
 					System.out.println("Conta "+numConta+" Localizada");
 					System.out.println("##########################################");
					 switch(contas.get(check).getTipo()){
					 
					 	case 1:
					 		while(escolha != 4){
						 		contaCorrente receiveCC = (contaCorrente) contas.get(check);
					 			System.out.println("Você deseja?\n"
					 							 + "(1)- Fazer um depósito\n"
					 							 + "(2)- Fazer um saque\n"
					 							 + "(3)- Ver Informações da conta\n"
					 							 + "(4)- Sair");
					 			escolha = intCheck();
					 			while(escolha == 0 || escolha > 4){
					 				escolha = intCheck();
					 			}
					 			double valor;
					 			switch(escolha){
					 				case 1:
					 					System.out.println("Digite o valor a ser depositado: ");
					 					valor = doubleCheck();
					 					while(valor <= 0){
					 						valor = doubleCheck();
					 					}
										System.out.println("##########################################");
					 					System.out.println(receiveCC.depositar(valor));
										System.out.println("##########################################");
										escolha = 0;
										valor = 0;
										break;
										
					 				case 2:
					 					System.out.println("Digite o valor a ser sacado: ");
					 					valor = doubleCheck();
					 					while(valor <= 0){
					 						valor = doubleCheck();
					 					}
					 					System.out.println("##########################################");
					 					System.out.println(receiveCC.sacar(valor));
										System.out.println("##########################################");
										escolha = 0;
										valor = 0;
										break;
										
					 				case 3:
					 					System.out.println("##########################################");
					 					System.out.println(receiveCC.toString());
					 					System.out.println("##########################################");
					 					break;
					 					
					 				case 4:
					 					escolha = 4;
					 					check = 0;
					 					break;
					 			}
					 		}
					 		
					 	case 2:
					 		while(escolha != 4){
						 		contaEspecial receiveEsp = (contaEspecial) contas.get(check);
					 			System.out.println("Você deseja?\n"
			 							 + "(1)- Fazer um depósito\n"
			 							 + "(2)- Fazer um saque\n"
			 							 + "(3)- Ver Informações da conta\n"
			 							 + "(4)- Sair");
					 			escolha = intCheck();
					 			while(escolha == 0 || escolha > 4){
					 				escolha = intCheck();
					 			}
					 			double valor;
					 			switch(escolha){
					 				case 1:
					 					System.out.println("Digite o valor a ser depositado: ");
					 					valor = doubleCheck();
					 					while(valor <= 0){
					 						valor = doubleCheck();
					 					}
										System.out.println("##########################################");
					 					System.out.println(receiveEsp.depositar(valor));
										System.out.println("##########################################");
										escolha = 0;
										valor = 0;
										break;
										
					 				case 2:
					 					System.out.println("Digite o valor a ser sacado: ");
					 					valor = doubleCheck();
					 					while(valor <= 0){
					 						valor = doubleCheck();
					 					}
					 					System.out.println("##########################################");
					 					System.out.println(receiveEsp.sacar(valor));
										System.out.println("##########################################");
										escolha = 0;
										valor = 0;
										break;
										
					 				case 3:
					 					System.out.println("##########################################");
					 					System.out.println(receiveEsp.toString());
					 					System.out.println("##########################################");
					 					break;
					 					
					 				case 4:
					 					check = 0;
					 					break;
					 			}
					 		}
					 	case 3: 
					 		while(escolha != 5){
					 			contaPoupanca receivePoup = (contaPoupanca) contas.get(check);
					 			System.out.println("Você deseja?\n"
			 							 + "(1)- Fazer um depósito\n"
			 							 + "(2)- Fazer um saque\n"
			 							 + "(3)- Fazer rendimento\n"
			 							 + "(4)- Ver Informações da conta\n"
			 							 + "(5)- Sair");
					 			escolha = intCheck();
					 			while(escolha == 0 || escolha > 5){
					 				escolha = intCheck();
					 			}
					 			double valor;
					 			switch(escolha){
					 				case 1:
					 					System.out.println("Digite o valor a ser depositado: ");
					 					valor = doubleCheck();
					 					while(valor <= 0){
					 						valor = doubleCheck();
					 					}
										System.out.println("##########################################");
					 					System.out.println(receivePoup.depositar(valor));
										System.out.println("##########################################");
										escolha = 0;
										valor = 0;
										break;
										
					 				case 2:
					 					System.out.println("Digite o valor a ser sacado: ");
					 					valor = doubleCheck();
					 					while(valor <= 0){
					 						valor = doubleCheck();
					 					}
					 					System.out.println("##########################################");
					 					System.out.println(receivePoup.sacar(valor));
										System.out.println("##########################################");
										escolha = 0;
										valor = 0;
										break;
										
					 				case 3: 
					 					System.out.println("Digite a taxa no mês: ");
					 					double valorTaxa = doubleCheck();
					 					while(valorTaxa <= 0){
					 						valorTaxa = doubleCheck();
					 					}
					 					if(mesLocal == 1){
					 						System.out.println("O Mês atual é Janeiro, a taxa acumulada de rendimentos será zerada.");
					 					}
					 					System.out.println("##########################################");
					 					System.out.println(receivePoup.rendimento(valorTaxa,mesLocal));
					 					System.out.println("##########################################");
					 					break;
					 					
					 				case 4:
					 					System.out.println("##########################################");
					 					System.out.println(receivePoup.toString());
					 					System.out.println("##########################################");
					 					break;
					 					
					 				case 5:
					 					escolha = 0;
					 					check = 0;
					 					break;
					 			}
					 		}	 	
					 }
				 }
				 
			}
			else if(escolha == 3){
				System.out.println("Gerando Lista de Contas Existentes: ");
				System.out.println("##########################################");
				System.out.println("Agencia \t Número \t Tipo ");
				for(int i=0 ; i< contas.size(); i++){
					System.out.println(listar(i));
				}
				System.out.println("##########################################");
			}
			else if(escolha == 4){
				break;
			}
		}

	}

}
