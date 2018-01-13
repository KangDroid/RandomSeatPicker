import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class FirstMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	static int a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FirstMain frame = new FirstMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstMain() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstmainclass = new JLabel("FirstMainClass");
		lblFirstmainclass.setBounds(6, 6, 107, 16);
		contentPane.add(lblFirstmainclass);
		
		JLabel lblNewLabel = new JLabel("Number of Seats");
		lblNewLabel.setBounds(71, 123, 107, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(250, 118, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(327, 285, 117, 29);
		btnContinue.addActionListener(new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
			if (textField.getText().length() != 0) {
				a = Integer.parseInt(textField.getText());
		    	dispose(); //close this one
			Main frame = new Main();
			frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog((Component)e.getSource(),
                            "You haven't entered number of students, aborting.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
				}
		    }
		});
		contentPane.add(btnContinue);
	}
}
