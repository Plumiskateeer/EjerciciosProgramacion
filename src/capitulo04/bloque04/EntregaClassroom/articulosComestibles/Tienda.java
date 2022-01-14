package capitulo04.bloque04.EntregaClassroom.articulosComestibles;

import javax.swing.*;
import java.util.ArrayList;

public class Tienda {
    private final ArrayList<Producto> articulos;
    private final ArrayList<Cliente> clientes;

    public Tienda() {
        articulos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        for (int i = 0; i < 2; i++) {
            JOptionPane.showConfirmDialog(null, "Producto numero " + (i + 1), "TIENDA", JOptionPane.OK_CANCEL_OPTION);
            tienda.anadirArticulo();
            tienda.anadirCliente();
        }
        System.out.println(tienda);
    }

    public void anadirCliente() {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del cliente: ");
        Cliente cl = new Cliente(nombre, clientes.size() + 1);
        clientes.add(cl);
    }

    public void anadirArticulo() {
        Producto pr;
        String tipo = JOptionPane.showInputDialog("¿El producto es perecedero? (si o no)");
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el codigo del producto: "));
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio del producto: "));
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto: ");
        if (tipo.equals("si")) {
            String fecha = JOptionPane.showInputDialog("Introduce la fecha en la que el producto caduca: ");
            pr = new Perecedero(codigo, precio, nombre, articulos.size() + 1, fecha); // aqui me dicen que es perecedero
        }else pr = new Producto(codigo, precio, nombre, articulos.size() + 1);

        articulos.add(pr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("------CLIENTES-------\n");
        for (Cliente c : clientes) {
            sb.append(c.toString());
        }
        sb.append("------PRODUCTOS------\n");
        for (Producto p : articulos) {
            sb.append(p.toString());
        }

        return sb.toString();
    }
}
