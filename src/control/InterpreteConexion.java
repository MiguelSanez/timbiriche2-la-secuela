/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import juegotimbiriche.Figura;
import juegotimbiriche.Jugador;
import presentacion.SalaDeEspera;

/**
 *
 * @author Equipo 5
 */
public class InterpreteConexion {

    private static Control control;
    private static InterpreteConexion singleton;
    private static SalaDeEspera sala;

    private InterpreteConexion() {

    }

    public static InterpreteConexion getInterprete() {
        if (singleton == null) {
            singleton = new InterpreteConexion();
        }
        return singleton;
    }

    public static void setControl(Control control) {
        InterpreteConexion.control = control;
    }

    public static void setSala(SalaDeEspera sala) {
        InterpreteConexion.sala = sala;
    }

    public static void interpretar(int accion, Object objeto) {
//        String mando = mensaje.split("@")[0];
//        if (mando.equalsIgnoreCase("JugadorConexion")) {
//            Jugador jugador = new Jugador(mensaje.split("@")[1]);
//            InterpreteConexion.control.conectaJugador(jugador);
//        } else if (mando.equalsIgnoreCase("Jugada")) {
//            String jugada = mensaje.split("@")[1].trim();
//            Figura figura = Figura.toFigura(jugada.split(" ")[0]);
//            ControlTablero.rayar(figura);
//        } else if(mensaje.startsWith("Inicia")){
//            sala.inicia();
//        }
        if(objeto instanceof Jugador){
            switch(accion){
                case 0: 
                    control.conectaJugador((Jugador) objeto);
                    break;
                case 1:
                    
                    break;
                case 2:
                    break;
            }
            control.conectaJugador((Jugador)objeto);
        } else if (objeto instanceof Figura){
            
        }
    }

}
