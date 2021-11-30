/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotimbiriche;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo 5
 */
public class Juego {
    
    /**
     * Atributos de la clase Juego.
     */
    private int numJugadores;
    private List<Jugador> jugadores= new ArrayList<>();
    private String status;
    private Tablero tablero;
    private int turnoActual=0;

    /***
     * Constructor por defecto.
     */
    public Juego() {
    }

    public Juego(Tablero tablero){
        this.tablero=tablero;
    }
    
    public Juego(List<Jugador> jugadores, String status) {
        this.jugadores = jugadores;
        this.status = status;
    }

    
    public Juego(int numJugadores, List<Jugador> jugadores, int puntajes, String status, Tablero tablero) {
        this.numJugadores = numJugadores;
        this.jugadores = jugadores;
        this.status = status;
        this.tablero = tablero;
    }
    
    /**
     * Gets y sets de la clase Juego.
     * @return 
     */
    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugador(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int nuevoTurno(){
        turnoActual++;
        return turnoActual;
    }

    public int getTurnoActual() {
        return turnoActual;
    }
    
    @Override
    public String toString() {
        return "Juego{" + "jugador=" + jugadores + ", status=" + status + '}';
    }
    
}
