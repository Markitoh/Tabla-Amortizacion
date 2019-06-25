import java.text.NumberFormat;
import java.util.Scanner;

public class TablaAmortizacion {

	public static void main(String[] args) {
		Scanner entradaEscaner = new Scanner (System.in);
		double capitalInicial;
		int periodo;
		double TasaInteres;
	do
	{
		System.out.println("*****Solo Valores positivos***** \n");
		System.out.println("Introducir Datos Para Generar Tabla de Amortizacion \n");
		System.out.println("Introducir Capital Inicial: ");
		 capitalInicial  = entradaEscaner.nextDouble();
		System.out.println("Introducir Periodo de tiempo ");
		 periodo = entradaEscaner.nextInt();
		System.out.println("Introducir Tasa de Interes");
		 TasaInteres = entradaEscaner.nextDouble();
	}
	while(capitalInicial<=0||periodo<=0||TasaInteres<=0);

		
		
		
		System.out.println("                                                        TABLA DE AMORTIZACION \n \n");
		
		double renta = (capitalInicial * TasaInteres/100 )/ (1 - (Math.pow(TasaInteres/100 + 1, -periodo)));
		double interes = capitalInicial * (TasaInteres/100);
		double amortizacion = renta - interes;

		
		//Aqui empieza el Diseño de la Tabla
		
		int Periodo = 15; 
		int Renta = 20;  
		int Interes = 30;
		int Amortizacion = 30; 
		int Saldo =30; 
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String pattern = "%" + Periodo + "s%" + Renta + "s%" + Interes + "s%" + Amortizacion + "s%" + Saldo + "s \n";
		System.out.printf(pattern, "PERIODO", "RENTA", "INTERES", "AMORTIZACION", "SALDO \n"); 
		
		
		
		//Aqui Empieza el ciclo for
		double acumuladorInteres = 0;
		double acumuladorRenta = 0;
		double acumuladorAmortizacion = 0;
		
		int x;
		
		System.out.printf(pattern, 0, nf.format(0.0), nf.format(0.0), nf.format(0.0), nf.format(capitalInicial)); 
		for (x = 1; x <= periodo; x++) { 
			
			interes = capitalInicial * (TasaInteres/100);
			amortizacion = renta - interes; 
			capitalInicial = capitalInicial - amortizacion;
			
			acumuladorRenta += renta;
			acumuladorInteres += interes;
			acumuladorAmortizacion += amortizacion;
			
			System.out.printf(pattern, x, nf.format(renta), nf.format(interes), nf.format(amortizacion), nf.format(capitalInicial)); 
			
			System.out.println("\n");
		}
			System.out.printf(pattern,-1, nf.format(acumuladorRenta), nf.format(acumuladorInteres), nf.format(acumuladorAmortizacion), nf.format(0));
	
	} 
}
