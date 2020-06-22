import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JDialog {
	private PassValue Value = new PassValue();
	private boolean sendData;
	private JLabel image;
	private JComboBox nbrJoueurs, modeDeJeu;

	public Menu(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(816, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();

	}

	public PassValue passe() {
		this.sendData = false;
		this.setVisible(true);
		return this.Value;
	}

	private void initComponent() {
		image = new JLabel(new ImageIcon("Accueil2.png"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(image);

		JPanel panJoueurs = new JPanel();
		panJoueurs.setBackground(Color.white);
		panJoueurs.setPreferredSize(new Dimension(450, 100));
		panJoueurs.setBorder(BorderFactory.createTitledBorder("Nombre de Joueurs"));
		nbrJoueurs = new JComboBox();
		nbrJoueurs.addItem("1");
		nbrJoueurs.addItem("2");
		nbrJoueurs.addItem("3");
		nbrJoueurs.addItem("4");
		panJoueurs.add(nbrJoueurs);

		JPanel panMode = new JPanel();
		panMode.setBackground(Color.white);
		panMode.setPreferredSize(new Dimension(450, 100));
		panMode.setBorder(BorderFactory.createTitledBorder("Mode de Jeu"));
		modeDeJeu = new JComboBox();
		modeDeJeu.addItem("Classique");
		modeDeJeu.addItem("Dynastie");
		modeDeJeu.addItem("Empire du milieu");
		modeDeJeu.addItem("Harmonie");
		modeDeJeu.addItem("Le Grand Duel");
		panMode.add(modeDeJeu);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panIcon);
		content.add(panJoueurs);
		content.add(panMode);

		JPanel control = new JPanel();
		JButton LaunchButton = new JButton("OK");

		LaunchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((Integer.parseInt((String) nbrJoueurs.getSelectedItem()) > 2)
						&& (String) modeDeJeu.getSelectedItem() == "Le Grand Duel") {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "Ce mode de jeu n'est disponible que pour 2 joueurs! ", "Attention",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Value = new PassValue(new String[] { (String) nbrJoueurs.getSelectedItem(),
							(String) modeDeJeu.getSelectedItem() });
					setVisible(false);
				}
			}

		});
		control.add(LaunchButton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}
}