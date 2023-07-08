package tarea_13;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;


public class JuegasCartas extends JFrame {
	
	private JPanel contentPane;
    private List <Integer> NumerosCartas = new ArrayList<>();
    private List <JLabel> labelsJugadores = new ArrayList<>();
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegasCartas frame = new JuegasCartas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JuegasCartas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bnLanzar = new JButton("LANZAR");
		bnLanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LanzarCartas();
			}
		});
		bnLanzar.setBounds(160, 211, 106, 39);
		contentPane.add(bnLanzar);

		JLabel lbJugador1 = new JLabel("Jugador 1");
		lbJugador1.setBounds(41, 177, 92, 14);
		contentPane.add(lbJugador1);
		labelsJugadores.add(lbJugador1);

		JLabel lbJugador2 = new JLabel("Jugador 2");
		lbJugador2.setBounds(184, 177, 92, 14);
		contentPane.add(lbJugador2);
		labelsJugadores.add(lbJugador2);

		JLabel lbJugador3 = new JLabel("Jugador 3");
		lbJugador3.setBounds(332, 177, 92, 14);
		contentPane.add(lbJugador3);
		labelsJugadores.add(lbJugador3);
		
		JLabel lbInstrucciones = DefaultComponentFactory.getInstance().createLabel("Aprieta boton y el que tenga mas numeros 5 GANA");
		lbInstrucciones.setBounds(84, 61, 326, 89);
		contentPane.add(lbInstrucciones);

		NumerosCartas.add(1);
		NumerosCartas.add(2);
		NumerosCartas.add(3);
		NumerosCartas.add(4);
		NumerosCartas.add(5);
		NumerosCartas.add(6);
		NumerosCartas.add(7);
		NumerosCartas.add(1);
		NumerosCartas.add(2);
		NumerosCartas.add(3);
		NumerosCartas.add(4);
		NumerosCartas.add(5);
		NumerosCartas.add(7);
		NumerosCartas.add(1);
		NumerosCartas.add(2);
		NumerosCartas.add(3);
		NumerosCartas.add(4);
		NumerosCartas.add(5);
		NumerosCartas.add(6);
		NumerosCartas.add(7);
		NumerosCartas.add(8);
	}

	private void LanzarCartas() {
	    Random random = new Random();
	    int NumCinco = 0;
	    int ganador = -1;

	    for (int i = 0; i < labelsJugadores.size(); i++) {
	        JLabel labelRepartir = labelsJugadores.get(i);
	        StringBuilder sieteVeces = new StringBuilder();
	        int conteoNumCinco = 0;
	        for (int j = 0; j < 7; j++) {
	            int numeroAleatorio = NumerosCartas.get(random.nextInt(NumerosCartas.size()));
	            sieteVeces.append(numeroAleatorio).append(" ");

	         if (numeroAleatorio == 5) {
	             conteoNumCinco++;
	            }
	        }
	        labelRepartir.setText(sieteVeces.toString().trim());
	        if (conteoNumCinco > NumCinco) {
	        	NumCinco = conteoNumCinco;
	            ganador = i;
	        }
	    }
	    if (ganador != -1) {
	        JOptionPane.showMessageDialog(this, "¡El jugador " + (ganador + 1) + " ganó");
	    }
	}
}

