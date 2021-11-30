package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juegotimbiriche.Figura;
import juegotimbiriche.Juego;
import juegotimbiriche.Jugador;
import juegotimbiriche.TipoFigura;
import presentacion.juegoTimbiriche;
import socket.Cliente;

/**
 *
 * @author Equipo 5
 */
public class ControlTablero implements MouseListener {

    private JPanel panel;
    private Juego partida;
    private Control control = Control.getControl();
    private static JLabel[] puntuaciones;
    private static juegoTimbiriche juego;
    private Cliente cliente;

    public ControlTablero() {
        cliente=Cliente.getCliente();
    }

    public ControlTablero(JPanel panel, Juego partida, JLabel[] puntuaciones, juegoTimbiriche juego) {
        this.panel = panel;
        this.partida = partida;
        this.puntuaciones = puntuaciones;
        this.juego = juego;
        this.cliente=Cliente.getCliente();
    }

    public void acomodar(Figura[][] figuras, boolean add) {
        int i=0;
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (add) {
                    figuras[x][y] = new Figura();
                    figuras[x][y].addMouseListener(this);
                    figuras[x][y].setHash(i);
                    i++;
                } else {
                    figuras[x][y].setJugador(null);
                    figuras[x][y].setUso(false);
                }
                if (x % 2 == 0) {
                    if (y % 2 == 0) {
                        figuras[x][y].setTipo(TipoFigura.VERTICE);
                        figuras[x][y].setBounds(17 + (25 * (y / 2)), 12 + (25 * (x / 2)), 7, 7);
                        figuras[x][y].setBackground(Color.black);
                        figuras[x][y].removeMouseListener(this);
                    } else {
                        figuras[x][y].setTipo(TipoFigura.LINEA);
                        figuras[x][y].setBounds(24 + (25 * (y / 2)), 12 + (25 * (x / 2)), 18, 7);
                        figuras[x][y].setBackground(Color.WHITE);
                    }
                } else {
                    if (y % 2 == 0) {
                        figuras[x][y].setTipo(TipoFigura.LINEA);
                        figuras[x][y].setBounds(17 + (25 * (y / 2)), 19 + (25 * (x / 2)), 7, 18);
                        figuras[x][y].setBackground(Color.WHITE);
                    } else {
                        figuras[x][y].setTipo(TipoFigura.CUADRO);
                        figuras[x][y].setBounds(24 + (25 * (y / 2)), 19 + (25 * (x / 2)), 18, 18);
                        figuras[x][y].setBackground(Color.WHITE);
                        figuras[x][y].removeMouseListener(this);
                    }
                }
                if (add) {
                    control.agregarBotones(figuras[x][y], panel);
                }
            }
        }
        partida.getTablero().setFiguras(figuras);
    }

    private void checar(Jugador jugador, Figura[][] figuras) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (figuras[x][y].getTipo().equals(TipoFigura.CUADRO) && !figuras[x][y].getUso()) {
                    try {
                        if (figuras[x - 1][y].getUso() && figuras[x + 1][y].getUso() && figuras[x][y - 1].getUso() && figuras[x][y + 1].getUso()) {
                            figuras[x][y].setJugador(jugador);
                            figuras[x][y].setUso(true);
                            figuras[x][y].setOpaque(true);
                            figuras[x][y].setBackground(new Color(jugador.getColor()[0], jugador.getColor()[1], jugador.getColor()[2]));
                            
                            jugador.sumarPuntaje();
                            ControlTablero.puntuaciones[0].setText("" + partida.getJugadores().get(0).getPuntaje());
                            ControlTablero.puntuaciones[1].setText("" + partida.getJugadores().get(1).getPuntaje());
                            ControlTablero.puntuaciones[2].setText("" + partida.getJugadores().get(2).getPuntaje());
                            ControlTablero.puntuaciones[3].setText("" + partida.getJugadores().get(3).getPuntaje());
                            panel.repaint();
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }

                }
            }
        }
        Control.cambiaTurno();
    }

    private static boolean paraGanar(Figura[][] figuras) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (figuras[x][y].getTipo().equals(TipoFigura.CUADRO) && !figuras[x][y].getUso()) {
                    return false;
                }
            }
        }
        return true;
    }
    public void rayar(Figura figura){
        boolean encontrado = false;
        System.out.println(figura.hashCode()+" despues de enviar");
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (partida.getTablero().getFiguras()[x][y].equals(figura)) {
                    figura=partida.getTablero().getFiguras()[x][y];
                    System.out.println("si quiera llego? "+figura.hashCode());
                    for (int i = 0; i < partida.getNumJugadores(); i++) {
                        if (partida.getJugadores().get(i).getTurno()) {
                            figura.setUso(true);
                            figura.setJugador(partida.getJugadores().get(i));
                            figura.setBackground(new Color(partida.getJugadores().get(i).getColor()[0],
                                    partida.getJugadores().get(i).getColor()[1],
                                    partida.getJugadores().get(i).getColor()[2]));
                            
                            figura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                            checar(partida.getJugadores().get(i), partida.getTablero().getFiguras());
                            if (paraGanar(partida.getTablero().getFiguras())) {
                                control.finalizarPartida(partida);
                            }
                            break;
                            
                        }
                    }
                    encontrado = true;
                }
            }
            if (encontrado) {
                break;
            }
        }
        
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        Figura figura = (Figura) me.getSource();
        boolean encontrado = false;
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (partida.getTablero().getFiguras()[x][y] == figura) {
                    for (int i = 0; i < partida.getNumJugadores(); i++) {
                        if (partida.getJugadores().get(i).getTurno()) {
//                            figura.removeMouseListener(this);
//                            figura.setUso(true);
//                            figura.setJugador(Juego.getJugadores()[i]);
//                            System.out.println(figura.hashCode()+" antes de enviar");
//                            cliente.sendJugada(figura.toString()+" "+i);
//                            break;
                            figura.setBackground(new Color(partida.getJugadores().get(i).getColor()[0],
                                    partida.getJugadores().get(i).getColor()[1],
                                    partida.getJugadores().get(i).getColor()[2]));
                            figura.setUso(true);
                            figura.setJugador(partida.getJugadores().get(i));
                            figura.removeMouseListener(this);
                            figura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                            partida.getJugadores().get(i).setTurno(false);
                            checar(partida.getJugadores().get(i), partida.getTablero().getFiguras());
                            if (paraGanar(partida.getTablero().getFiguras())) {
                                control.finalizarPartida(partida, juego);
                            }
                            break;
                            
                        }
                    }
                    encontrado = true;
                }
            }
            if (encontrado) {
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
