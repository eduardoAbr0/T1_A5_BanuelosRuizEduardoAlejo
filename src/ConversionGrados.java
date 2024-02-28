import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

class interfaz extends JFrame implements ActionListener {
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	Conversiones cv = new Conversiones();

	JTextField campoIngreso, campoResultado;
	JComboBox comboPrimerSel, comboSegundaSel;
	int contP;

	public interfaz() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		setTitle("Conversion de Grados");
		setVisible(true);

		JLabel txtConvertir = new JLabel("Convertir: ");
		agregarComponente(txtConvertir, 0, 0, 1, 1);
		campoIngreso = new JTextField("0");
		contP = 0;
		campoIngreso.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {				
				String txt = campoIngreso.getText();
				
				if (e.getKeyChar() == '.') {
					if (contP == 0) {
						contP++;
					} else {
						e.consume();
					}
				} else if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
					e.consume();
				}else if (txt.equals("0") || txt.isEmpty()) {
					contP = 0;
					campoIngreso.setText("");
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				String txt = campoIngreso.getText();
				
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if (txt.isEmpty()) {
					}else if(txt.charAt(txt.length() - 1) == '.') {
						contP = 0;
					}
				}
			}
		});
		campoIngreso.addActionListener(this);
		gbc.ipadx = 50;
		agregarComponente(campoIngreso, 1, 0, 1, 1);

		comboPrimerSel = new JComboBox();
		agregarComponente(comboPrimerSel, 2, 0, 1, 1);
		comboPrimerSel.addActionListener(this);

		JLabel txtA = new JLabel("A: ");
		agregarComponente(txtA, 0, 1, 1, 1);
		comboSegundaSel = new JComboBox();
		comboSegundaSel.addActionListener(this);
		agregarComponente(comboSegundaSel, 1, 1, 1, 1);

		campoResultado = new JTextField();
		campoResultado.setEditable(false);
		comboSegundaSel.addActionListener(this);
		gbc.ipadx = 50;
		agregarComponente(campoResultado, 2, 1, 1, 1);

		comboPrimerSel.addItem("Fahrenheit");
		comboPrimerSel.addItem("Celsius");
		comboPrimerSel.addItem("Kelvin");
		comboPrimerSel.addItem("Rankine");

		comboSegundaSel.addItem("Fahrenheit");
		comboSegundaSel.addItem("Celsius");
		comboSegundaSel.addItem("Kelvin");
		comboSegundaSel.addItem("Rankine");

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

	@Override
	public void actionPerformed(ActionEvent e) {
		double gradosIngresados = Double.parseDouble(campoIngreso.getText());

		switch (comboPrimerSel.getSelectedIndex()) {
		case 0:
			switch (comboSegundaSel.getSelectedIndex()) {
			case 0:
				campoResultado.setText(String.valueOf(gradosIngresados));
				break;
			case 1:
				campoResultado.setText(cv.fahrenheitC(gradosIngresados));
				break;
			case 2:
				campoResultado.setText(cv.fahrenheitK(gradosIngresados));
				break;
			case 3:
				campoResultado.setText(cv.fahrenheitR(gradosIngresados));
			default:
				break;
			}
			break;
		case 1:
			switch (comboSegundaSel.getSelectedIndex()) {
			case 0:
				campoResultado.setText(cv.centigradosF(gradosIngresados));
				break;
			case 1:
				campoResultado.setText(String.valueOf(gradosIngresados));
				break;
			case 2:
				campoResultado.setText(cv.centigradosK(gradosIngresados));
				break;
			case 3:
				campoResultado.setText(cv.centigradosR(gradosIngresados));
				break;

			default:
				break;
			}
			break;
		case 2:
			switch (comboSegundaSel.getSelectedIndex()) {
			case 0:
				campoResultado.setText(cv.kelvinF(gradosIngresados));
				break;
			case 1:
				campoResultado.setText(cv.kelvinC(gradosIngresados));
				break;
			case 2:
				campoResultado.setText(String.valueOf(gradosIngresados));
				break;
			case 3:
				campoResultado.setText(cv.kelvinR(gradosIngresados));
				break;

			default:
				break;
			}
			break;
		case 3:
			switch (comboSegundaSel.getSelectedIndex()) {
			case 0:
				campoResultado.setText(cv.rankineF(gradosIngresados));
				break;
			case 1:
				campoResultado.setText(cv.rankineC(gradosIngresados));
				break;
			case 2:
				campoResultado.setText(cv.rankineK(gradosIngresados));
				break;
			case 3:
				campoResultado.setText(String.valueOf(gradosIngresados));
				break;

			default:
				break;
			}
			break;

		default:
			break;
		}

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