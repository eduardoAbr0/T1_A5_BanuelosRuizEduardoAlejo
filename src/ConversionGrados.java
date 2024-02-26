import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.*;

class interfaz extends JFrame {
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JTextField campoIngreso, campoResultado;
	JComboBox comboPrimerSel, comboSegundaSel;

	public interfaz() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setLocationRelativeTo(null);
		setTitle("Conversion");
		setVisible(true);
		
		JLabel txtConvertir = new JLabel("Convertir: ");
		agregarComponente(txtConvertir, 0, 0, 1, 1);
		campoIngreso = new JTextField("           ");
		agregarComponente(campoIngreso, 1, 0, 1, 1);
		comboPrimerSel = new JComboBox();
		comboPrimerSel.addItem("Fahrenheit");
		comboPrimerSel.addItem("Celsius");
		comboPrimerSel.addItem("Kelvin");
		comboPrimerSel.addItem("Rankine");
		agregarComponente(comboPrimerSel, 2, 0, 1, 1);
		
		JLabel txtA = new JLabel("A: ");
		agregarComponente(txtA, 0, 1, 1, 1);
		comboSegundaSel = new JComboBox();
		comboSegundaSel.addItem("Fahrenheit");
		comboSegundaSel.addItem("Celsius");
		comboSegundaSel.addItem("Kelvin");
		comboSegundaSel.addItem("Rankine");
		agregarComponente(comboSegundaSel, 1, 1, 1, 1);
		campoResultado = new JTextField("           ");
		agregarComponente(campoResultado, 2, 1, 1, 1);
		
		pack();
		
	}

	public void agregarComponente(JComponent c, int x, int y, int anchura, int altura) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = anchura;
		gbc.gridheight = altura;
		gbl.setConstraints(c, gbc);

		add(c);
	}

}

public class ConversionGrados {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new interfaz();
			}
		});

	}

}