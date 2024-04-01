import java.util.Scanner;

public class Temperaturas {

	public static void pularLinha() {
		System.out.println(" ");
	}

	public static void BoasVindas() {
		System.out.println(" ");
		System.out.println("                 -=[ Conversor de Temperaturas ]=-                 ");
		System.out.println("           __________________________________________________    ");
		System.out.println("    ____.-\"\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\":\"-. ");
		System.out.println("   (___:====\'===\'===\'===\'===\'===\'===\'=A \'   \'   \'   \'   \'   \'   )");
		System.out.println("       `\'-._92____94____96____8__|_100____2_____4_____6_____8.-` ");
		System.out.println(" ");
	}

	public static void opcoesEscalas() {
		System.out.println("1) Celsius");
		System.out.println("2) Fahrenheit");
		System.out.println("3) Kelvin");
	}

	public static void escalasIguais() {
		System.out.println("A escala para conversão é igual à escala inicial.");
		System.out.println("Escolha escalas diferentes para uma conversão efetiva.");
	}

	public static void opcaoInvalida() {
		System.out.println("Opção inválida. Forneça o número correspondente a uma das opções acima.");
	}

	public static void Resultado(double temperatura, int escala) {
		if (escala == 1) {
			pularLinha();
			System.out.printf("A temperatura é %.2f°C %n", temperatura);
		}
		else if (escala == 2) {
			pularLinha();
			System.out.printf("A temperatura é %.2f°F %n", temperatura);
		}
		else if (escala == 3) {
			pularLinha();
			System.out.printf("A temperatura é %.2fK %n", temperatura);
		}
	}

	public static double CelsiusFahrenheit(double tc) {
		return tc * (9./5.) + 32.;
	}

	public static double CelsiusKelvin(double tc) {
		return tc + 273.;
	}

	public static double FahrenheitCelsius(double tf) {
		return (tf - 32.) * (5./9.);
	}

	public static double FahrenheitKelvin(double tf) {
		return (tf - 32.) * (5./9.) + 273.;
	}

	public static double KelvinCelsius(double tk) {
		return tk - 273.;
	}

	public static double KelvinFahrenheit(double tk) {
		return (tk - 273.) * (9./5.) + 32.;
	}

	public static void main(String[] args) {
		double temperaturaentrada;
		int escalaentrada, escalasaida;
		Scanner ler = new Scanner(System.in);

		BoasVindas();

		char continuar = 's';
		while (continuar == 's') {

			pularLinha();
			System.out.print("Qual o valor da temperatura? (sem unidade de medida) ");
			temperaturaentrada = ler.nextDouble();

			pularLinha();
			System.out.println("Qual a escala da temperatura?");
			opcoesEscalas();
			escalaentrada = ler.nextInt();

			pularLinha();
			System.out.println("Para qual escala a temperatura será convertida?");
			opcoesEscalas();
			escalasaida = ler.nextInt();

			if (escalaentrada == 1) {
				if (escalasaida == 1) {
					escalasIguais();
				}
				else if (escalasaida == 2) {
					Resultado(CelsiusFahrenheit(temperaturaentrada),escalasaida);
				}
				else if (escalasaida == 3) {
					Resultado(CelsiusKelvin(temperaturaentrada),escalasaida);
				}
				else {
					opcaoInvalida();
				}
			}
			else if (escalaentrada == 2) {
				if (escalasaida == 1) {
					Resultado(FahrenheitCelsius(temperaturaentrada),escalasaida);
				}
				else if (escalasaida == 2) {
					escalasIguais();
				}
				else if (escalasaida == 3) {
					Resultado(FahrenheitKelvin(temperaturaentrada),escalasaida);
				}
				else {
					opcaoInvalida();
				}
			}
			else if (escalaentrada == 3) {
				if (escalasaida == 1) {
					Resultado(KelvinCelsius(temperaturaentrada),escalasaida);
				}
				else if (escalasaida == 2) {
					Resultado(KelvinFahrenheit(temperaturaentrada),escalasaida);
				}
				else if (escalasaida == 3) {
					escalasIguais();
				}
				else {
					opcaoInvalida();
				}
			}
			pularLinha();
			System.out.println("Gostaria de fazer uma nova conversão?");
			System.out.print("(s) sim; (n) não: ");
			continuar = ler.next().charAt(0);
		}
	}
}
