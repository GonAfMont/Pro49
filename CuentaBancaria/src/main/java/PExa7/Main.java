package PExa7;
 
import PExa7.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {
			
			CuentaBancaria Cb = new CuentaBancaria("Pepe Pérez","12345678A",1234,5678,90,1234567890, 1234.54);
			
			Scanner sc = new Scanner(System.in);
			
			 boolean console = true;
	            while (console) {
	                System.out.println("Elija la opción deseada.:\n");
	                System.out.println("1. Mostrar el número completo de cuenta bancaria (CCC - Código Cuenta Cliente)");
	                System.out.println("2. Mostrar el nombre del titular de la cuenta.");
	                System.out.println("3. Mostrar el código de la entidad bancaria.");
	                System.out.println("4. Mostrar el código de la sucursal.");
	                System.out.println("5. Mostrar el número de cuenta.");
	                System.out.println("6. Mostrar los dígitos de control de la cuenta.");
	                System.out.println("7. Depositar dinero.");
	                System.out.println("8. Retirar dinero.");
	                System.out.println("9. Consultar el saldo actual.");
	                System.out.println("10. Cerrar la aplicación.");
	                
			        int n = sc.nextInt();
			        sc.nextLine();    
						switch (n) {
						case 1: System.out.println("CCC completo " + Cb.getCCC()); break;
						case 2: System.out.println("Nombre del titular: " + Cb.getNombre()); break;
						case 3: System.out.println("Código de la Entidad Bancaria: " + Cb.getnEntidad()); break;
						case 4: System.out.println("Código de la Sucursal: " + Cb.getnSucursal()); break;
						case 5: System.out.println("Número de Cuenta: " + Cb.getcCuenta()); break;
						case 6: System.out.println("Dígitos de Control: " + Cb.getdControl()); break;
						case 7: System.out.println("Depositar: " + Cb.depSaldo()); break;
						case 8: System.out.println("Retirar: " + Cb.retSaldo()); break;
						case 9: System.out.println("Saldo: " + Cb.getSaldo()); break;
						case 10:System.out.println("Fin del programa"); console = false;
						}
	            }
			
		}catch (IllegalArgumentException | InputMismatchException Ime) {
			System.out.println("Introduce un número válido.\n");
			main(args);
		}
	}
}
	