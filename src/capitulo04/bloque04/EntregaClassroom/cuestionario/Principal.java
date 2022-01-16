package capitulo04.bloque04.EntregaClassroom.cuestionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final int NUM_PREGUNTAS = 5;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        List<Pregunta> preguntas = new ArrayList<>();

        int opc;
        do {
            System.out.println("------- TEST 5 PREGUNTAS -------\n" +
                               "0 : Finalizar programa\n" +
                               "1 : Introducir las preguntas\n" +
                               "2 : Realizar TEST\n" +
                               "Introduce la accion deseada: ");

            opc = sc.nextInt();
            switch (opc) {
                case 0: System.out.print("-----FIN DEL PROGRAMA-----"); break;
                case 1: inicializarPreguntas(preguntas); break;
                case 2: realizarTest(preguntas); break;
            }
        }while(opc!=0);
    }

    public static void inicializarPreguntas(List<Pregunta> preguntas){
        Scanner sc = new Scanner(System.in);
        preguntas.clear();
        for (int i = 0; i < NUM_PREGUNTAS; i++){
            if(i < 3){ // 3 de respuesta unica
                System.out.println("Introduce el enunciado de la pregunta (PREGUNTA UNICA): ");
                String enunciado = sc.nextLine();
                System.out.println("Introduce la respuesta a esa pregunta:");
                String respuesta = sc.nextLine();
                preguntas.add(new OpcionUnica(enunciado,respuesta));
                System.out.println();
            }else{
                System.out.println();
                System.out.println("Introduce el enunciado de la pregunta (PREGUNTA CON OPCIONES): ");
                String enunciado = sc.nextLine();
                System.out.println("Introduce la opcion a): ");
                String a = sc.nextLine();
                System.out.println("Introduce la opcion b): ");
                String b = sc.nextLine();
                System.out.println("Introduce la opcion c): ");
                String c = sc.nextLine();
                System.out.println("Introduce la opcion d): ");
                String d = sc.nextLine();
                System.out.println("Introduce la opcion correcta (a,b,c ó d):");
                char respuesta = sc.nextLine().charAt(0);
                String []opciones = {a,b,c,d};
                preguntas.add(new VoF(enunciado, opciones, respuesta));
            }
        }
    }
    public static void realizarTest(List<Pregunta> preguntas){
        Scanner sc = new Scanner(System.in);

        System.out.println("-----TEST DE 5 PREGUNTAS-----");
        for(Pregunta p : preguntas){
            if(p instanceof OpcionUnica){
                System.out.println("PREGUNTA: " + p.getEnunciado());
                System.out.println("\nRESPUESTA: ");
                if(p.comprobarRespuesta(sc.nextLine()))
                    System.out.println("\nFELICIDADES, respuesta correcta\n");
                else {
                    System.out.println("\nHas fallado, respuesta incorrecta");
                    System.out.println(p+"\n");
                }
            }else{
                VoF pregunta = (VoF) p;
                System.out.println("\n---OPCIONES---");
                System.out.println("PREGUNTA: " + p.getEnunciado());
                int cont = 0;
                for(String s : pregunta.getOpciones()){
                    switch(cont){
                        case 0: System.out.print("Opcion a): "); break;
                        case 1: System.out.print("Opcion b): "); break;
                        case 2: System.out.print("Opcion c): "); break;
                        case 3: System.out.print("Opcion d): "); break;
                    }
                    System.out.println(s);
                    cont++;
                }
                System.out.println("\nRESPUESTA: ");
                if(p.comprobarRespuesta(sc.nextLine()))
                    System.out.println("\nFELICIDADES, respuesta correcta\n");
                else {
                    System.out.println("\nHas fallado, respuesta incorrecta");
                    System.out.println(p+"\n");
                }
            }
        }

        System.out.println("\n-----EL TEST HA FINALIZADO-----\n\n");
    }

}
