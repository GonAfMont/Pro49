package PExa7;

import java.util.*;

public class CuentaBancaria {
	protected String nombre;
	protected String Dni;
	protected Integer nEntidad;
	protected Integer nSucursal;
	protected Integer dControl;
	protected Integer cCuenta;
	protected Double Saldo;

	public CuentaBancaria(String nombre, String Dni, Integer nEntidad, Integer nSucursal, Integer dControl, Integer cCuenta, Double Saldo) {
		this.nombre = nombre;
		if (Dni.matches("\\d{8}[A-Za-z]")) {
			this.Dni = Dni;
		}
		else {
			throw new IllegalArgumentException("DniDeEjemplo: 12345678A\nAsegúrate de que el Dni sea correcto");
		}
		if (nEntidad.toString().matches("\\d{4}")) {
			this.nEntidad = nEntidad;
		}
		else {
			throw new IllegalArgumentException("NúmeroDeEntidadDeEjemplo: 1234\nAsegúrate de que el Número de entidad sea correcto");
		}
		if (nSucursal.toString().matches("\\d{4}")) {
		this.nSucursal = nSucursal;	
		}
		else {
			throw new IllegalArgumentException("NúmeroDeSucursalDeEjemplo: 5678\nAsegúrate de que el Número de sucursal sea correcto");
		}
		if (dControl.toString().matches("\\d{2}")) {
		this.dControl = dControl;
		}
		else {
			throw new IllegalArgumentException("DígitosDeControlDeEjemplo: 90\nAsegúrate de que los dígitos de control sean correctos");
		}
		if (cCuenta.toString().matches("\\d{10}")) {
			this.cCuenta = cCuenta;
			}
		else {
			throw new IllegalArgumentException("CódigoDeCuentaDeEjemplo: 1234567890\nAsegúrate de que el código de cuenta sea correcto");
		}
		if (Saldo.toString().matches("\\d{1,}.?\\d{1,2}?")) {
			this.Saldo = Saldo;
			}
		else {
			throw new IllegalArgumentException("SaldoDeEjemplo: 245'13\nAsegúrate de que el saldo sea correcto");
		}
		
	}
	
	double Din = 0;
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return Dni;
	}
	
	public Integer getnEntidad() {
		return nEntidad;
	}
	
	public Integer getnSucursal() {
		return nSucursal;
	}
	
	public Integer getdControl() {
		return dControl;
	}
	
	public Integer getcCuenta() {
		return cCuenta;
	}
	
	public Double getSaldo() {
		return Saldo;
	}
	
	public String getCCC() {
		return String.format("%04d-%04d-%02d-%010d", nEntidad, nSucursal, dControl, cCuenta);
	}
	
	public Double depSaldo() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Introduce cuantía a depositar: ");
	        Din = sc.nextDouble();
	        if (Din <= 0) {
	            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva");
	        }
	        return this.Saldo += Din;
	}

	public Double retSaldo() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Introduce cuantía a retirar: ");
	        Din = sc.nextDouble();
	        if (Din <= 0) {
	            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva");
	        }
	        if (this.Saldo - Din < 0) {
	            throw new IllegalArgumentException("No se puede retirar más de lo que hay en el saldo");
	        }
	        return this.Saldo -= Din;
	}
	
	
	/*
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nDni: " + Dni + "\nNúmero de Entidad: " + nEntidad + "\nNúmero de Sucursal:" + nSucursal + "\nDígitos de Control:"+ dControl + "\nCódigo de Cuenta:" + cCuenta + "\nCCC:" + nEntidad + "-" + nSucursal + "-" + dControl + "-" + cCuenta;
	}
	*/
	
}
 
