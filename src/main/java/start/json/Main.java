package start.json;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		JsonService jsonService = new JsonService();

		/* Transformar Arquivo_Json em Objeto_Java: */
		Conta conta1 = jsonService.objeto(new File("conta.json"), Conta.class);
		System.out.println("- Objeto Conta: \n" + conta1);
		
		/* Transformar Arranjo_Json em Objeto_Java: */
		Conta[] contas = jsonService.objeto(new File("conjuntoContas.json"), Conta[].class);
		System.out.println("\n- toString de contas: " + contas);
		System.out.println("\n- Arranjo de contas: " + Arrays.toString(contas));
		
		/* Transformar String_Json em Objeto_Java: */
		String stringJson = "\n"
				+ "{\n" 
				+ "	\"numero\": 10000111,\n" 
				+ "	\"correntista\": {\n" 
				+ "		\"nome\": \"João\"\n"
				+ "	},\n" 
				+ "	\"saldo\": 2000.00\n" 
				+ "}";
		
		Conta conta2 = jsonService.objeto(stringJson, Conta.class);
		System.out.println("\n- Imprimir a String Json: " + stringJson);
		System.out.println("\n- Objeto Conta: " + conta2);		
		
		/* Transformar Objeto_Java em Arquivo_Json: */
		/* Obs: Dar F5 após o run para visualizar os arquivos */
		Conta novaConta = new Conta(222, new Correntista("Camila"), -300D);
		jsonService.jsonNaoFormatado(new File("novaContaNaoFormatada.json"), novaConta);
		jsonService.jsonFormatado(new File("novaContaFormatada.json"), novaConta);
		
		
		/* Transformar Objeto_Java em Arranjo_Json: */
		Conta[] novasContas = new Conta[] {
			    new Conta(222, new Correntista("Ana"), 1000D),
			    new Conta(222, new Correntista("Bia"), 2000D),
			    new Conta(222, new Correntista("Carol"), 3000D)
			};

	    jsonService.jsonFormatado(new File("novoConjuntoContas.json"), novasContas);
	}

}
