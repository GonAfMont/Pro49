package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import PExa7.*;

public class Test_CuentaBancaria {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria("Pepe Pérez", "12345678A", 1234, 5678, 90, 1234567890, 1234.54);
    }

    @Test
    public void testCreacionCuentaValida() {
        assertEquals("Pepe Pérez", cuenta.getNombre());
        assertEquals("12345678A", cuenta.getDni());
        assertEquals(1234, cuenta.getnEntidad());
        assertEquals(5678, cuenta.getnSucursal());
        assertEquals(90, cuenta.getdControl());
        assertEquals(1234567890, cuenta.getcCuenta());
        assertEquals(1234.54, cuenta.getSaldo());
    }

    @Test
    public void testCreacionCuentaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria("Pepe Pérez", "12345678", 1234, 5678, 90, 1234567890, 1234.54);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria("Pepe Pérez", "12345678A", 123, 5678, 90, 1234567890, 1234.54);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria("Pepe Pérez", "12345678A", 1234, 567, 90, 1234567890, 1234.54);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria("Pepe Pérez", "12345678A", 1234, 5678, 9, 1234567890, 1234.54);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria("Pepe Pérez", "12345678A", 1234, 5678, 90, 123456789, 1234.54);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new CuentaBancaria("Pepe Pérez", "12345678A", 1234, 5678, 90, 1234567890, -1234.54);
        });
    }

    @Test
    public void testDepSaldo() {
        String input = "100";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        cuenta.depSaldo();
        System.setIn(System.in);
        System.setOut(System.out);
        assertEquals(1334.54, cuenta.getSaldo());
    }

    @Test
    public void testRetSaldo() {
    	String input = "100";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        cuenta.retSaldo();
        System.setIn(System.in);
        System.setOut(System.out);
        assertEquals(1134.54, cuenta.getSaldo());
    }



    @Test
    public void testGetters() {
        assertEquals("Pepe Pérez", cuenta.getNombre());
        assertEquals("12345678A", cuenta.getDni());
        assertEquals(1234, cuenta.getnEntidad());
        assertEquals(5678, cuenta.getnSucursal());
        assertEquals(90, cuenta.getdControl());
        assertEquals(1234567890, cuenta.getcCuenta());
        assertEquals(1234.54, cuenta.getSaldo());
    }

    @Test
    public void testGetCCC() {
        String ccc = cuenta.getCCC();
        assertEquals("1234-5678-90-1234567890", ccc);
    }
}
