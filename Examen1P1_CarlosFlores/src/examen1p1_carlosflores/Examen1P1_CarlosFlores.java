package examen1p1_carlosflores;

import java.util.Random;
import java.util.Scanner;

public class Examen1P1_CarlosFlores {

    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--- M E N U ---");
        System.out.println("1-Fight or Flight");
        System.out.println("2-Tri Fuerza");
        System.out.println("3-Salir");
        int opcion = leer.nextInt();
        while(opcion > 0 && opcion < 3){
                
            switch(opcion){
                    
                case 1 ->{
                    int ammo = 25;
                    int zomv_hp = 25;
                    int resp = 's';
                    int perm = 1;
                    System.out.println("Ingrese Maestria");
                    System.out.println("""
                                        1.Principiante (0% de hit extra)
                                        2.Intermedio (5% de hit extra)
                                        3.Experto (15% de hit extra)""");
                    int mast = leer.nextInt();
                    int zomv_pos = new Random().nextInt((30 - 15) + 1) + 15;
                    System.out.println("El zombie se encuentra a: " + zomv_pos + " metros!!!");
                    System.out.println();
                    while(resp == 's' || resp == 'S'){
                        System.out.println("El jugador cuenta con: " + ammo + " balas!!!");
                        System.out.println();
                        int prob = new Random().nextInt((100 - 1) + 1) + 1;
                        if(mast == 1){
                            if(prob <= 65){
                                perm = 1;
                            }else{
                                perm = 2;
                            }//Condicionamiento de maestria 1
                        }else if(mast == 2){
                            if(prob <= 70){
                                perm = 1;
                            }else{
                                perm = 2;
                            }//Condicionamiento de maestria 2
                        }else if (mast == 3){
                            if(prob <= 80){
                                perm = 1;
                            }else{
                                perm = 2;
                            }//Condicionamiento de maestria 3
                        }//Condicionamiento de maestria
                        if(perm == 1){
                            int probdamg = new Random().nextInt((7 - 1) + 1) + 1;
                            zomv_hp = zomv_hp - probdamg;
                            ammo--;
                            if(zomv_hp < 1){
                                zomv_hp = 0;
                            }//validacion de la vida del zombie
                            System.out.println("Hit!!! El tiro ha reducido el HP del zombie por un total de: " + probdamg);
                            System.out.println();
                            System.out.println("Vida restante del zombie: " + zomv_hp);
                            System.out.println();
                            System.out.println("El zombie se encuentra a " + zomv_pos + " metros");
                            
                        }else if(perm == 2){
                            int zomv_mov = new Random().nextInt((5 - 3) + 1) + 3;
                            zomv_pos = zomv_pos - zomv_mov;
                            if(zomv_pos < 1){
                                zomv_pos = 0;
                            }//fin de validacion de posicion de zombie
                            System.out.println("Ha fallado!!! El zombie se encuentra a " + zomv_pos + " metros");
                            ammo--;
                        }//Estos ifs y else conceden permiso a las operaciones 
                        
                        if(zomv_pos > 0 && ammo > 0 && zomv_hp > 0){
                            System.out.println();
                            System.out.println("¿Listo para la siguiente ronda?[S/N]");
                            resp = leer.next().charAt(0);
                            System.out.println();
                            System.out.println();
                        }else if(zomv_pos <= 0){
                            System.out.println();
                            System.out.println();
                            System.out.println("GAME OVER!!!, la distacia se redujo a 0!");
                            resp = 'n';
                        }else if(ammo <= 0){
                            System.out.println();
                            System.out.println();
                            System.out.println("GAME OVER!!!; te quedaste sin municion!");
                            resp = 'n';
                        }else if(zomv_hp <= 0){
                            System.out.println();
                            System.out.println();
                            System.out.println("YOU WIN!!!, has logrado vencer al zombie!!!");
                            resp = 'n';
                        }//fin de ifs y elses pra el final de el juego
                        
                    }//while con respuesta
                    
                }//fin case1
                    
                case 2 ->{
                    
                    trifuerza();
                    
                }//fin case2
                    
            }//fin switch
            
            System.out.println();
            System.out.println();
            System.out.println("--- M E N U ---");
            System.out.println("1-Fight or Flight");
            System.out.println("2-Tri Fuerza");
            System.out.println("3-Salir");
            opcion = leer.nextInt(); 
            
        }//fin while
        
    }//fin main
    
    public static void trifuerza(){
        System.out.print("Ingrese un tamaño: ");
        int n = leer.nextInt();
        int ctrl = n/2;
        
        if((n > 20) && ((n/2 % 2 < 0) || (n/2 % 2 > 0)) && (n % 2 == 0)){
            
            for (int lineas = 0; lineas <= n/2-1; lineas++) {

                for (int esp = n - lineas; esp > 0; esp--) {
                    System.out.print(" ");
                }//fin de for para imprimir espacios depiramide superior

                System.out.print("*");
                for (int filas = lineas;filas > 0;filas--) {
                    System.out.print("**");
                }//fin de for para imprimir asteriscos de piramide superior
                System.out.println();

            }//fin de for para piramide superior

            for(int lineas = 0; lineas <= n/2-1; lineas++){

                for (int esp = ctrl - lineas; esp > 0; esp--){
                    System.out.print(" ");
                }//fin de for para imprimir espacios de piramide inferior izquierda

                System.out.print("*");
                for(int filas = lineas;filas > 0;filas--){
                    System.out.print("**");
                }//fin de for para imprimir asteriscos de piramide inferior izquierda

                for(int esp = ctrl - lineas; esp > 0; esp--){
                    if(esp > 1){
                        System.out.print("  ");
                    }else{
                        System.out.print(" ");
                    }//fin de if y else para imprimir espacios de piramide inferior derecha
                }//fin de for para imprimir espacios de piramide inferior derecha

                System.out.print("*");
                for(int filas = lineas;filas > 0;filas--){
                    System.out.print("**");
                }//fin de for para imprimir asteriscos de piramide inferior derecha
                System.out.println();

            }//fin de for para piramides inferiores
            
        }else{
            System.out.println();
            System.out.println("El tamaño tiene que ser un numero par mayor que 20 y que cuando \n"
                    + "lo dividamos entre 2 de un numero impar.");
        }//fin de if de validacion
        
    }//fin metodo trifuerza
    
}//fin class
