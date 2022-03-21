package capitulo07.gestionVentaCoches;

public class Main {


    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     *
     */
    private static void menuPrincipal() {

        int opcionElegida;
        do {
            System.out.println("\n\t\t\tGESTION DE VENTAS DE COCHES");

            System.out.println("\n\t1.- Gestion de fabricantes.");
            System.out.println("\t2.- Gestion de clientes.");
            System.out.println("\t3.- Gestion de coches.");
            System.out.println("\t4.- Gestion de ventas.");
            System.out.println("\t5.- Gestion de concesionario.");
            System.out.println("\t0.- Salir");
            System.out.println("\n\tElija una opcion: ");

            opcionElegida = Utils.getIntConsola(0, 5);

            switch (opcionElegida) {
                case 0:
                    System.out.println("\n!Que tenga un feliz dia!");
                    break;
                case 1:
                    GestionFabricante.menuGestion();
                    break;
                case 2:
                    GestionCliente.menuGestion();
                    break;
                case 3:
                    GestionCoche.menuGestion();
                    break;
                case 4:
                    GestionVenta.menuGestion();
                    break;
                case 5:
                    GestionConcesionario.menuGestion();
                    break;
            }
        } while (opcionElegida != 0);
    }

}
