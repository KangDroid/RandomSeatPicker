import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.ArrayUtils;

public class Main extends JFrame {

	static int numberSeats [];
	static int pickedSeats [] = {};
	static int numseats [];
	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel label;
	final String html1 = "<html><body style='width: ";
    final String html2 = "px'>";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		int [] numberSeats = IntStream.range(1, FirstMain.a + 1).toArray();
		numseats = numberSeats;
		// Initialize random
		Random random = new Random();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRandomseatpicker = new JLabel("RandomSeatPicker");
		lblRandomseatpicker.setBounds(6, 6, 132, 16);
		contentPane.add(lblRandomseatpicker);
		
		lblNewLabel = new JLabel(html1 + "300" + html2 + Arrays.toString(numseats));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(246, 158, 622, 99);
		contentPane.add(lblNewLabel);
		
		label = new JLabel(html1 + "300" + html2 + Arrays.toString(pickedSeats));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(246, 54, 622, 42);
		contentPane.add(label);
		
		//button section
		JButton btnPick = new JButton("Pick!");
		btnPick.setBounds(64, 118, 117, 29);
		btnPick.addActionListener(new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
		    	if (numseats.length !=0) {
					// Pick Random
					int pickRandom = numseats[random.nextInt(numseats.length)];
					// Remove picked seat from arrays
			        int indexNum = getArrayIndex(numseats,pickRandom);
			        numseats = ArrayUtils.remove(numseats, indexNum);
			        // Add picked seat array to picked seats array.
			        pickedSeats = ArrayUtils.add(pickedSeats, pickRandom);
			        // Update remain(unpicked) && picked seats to arrays 
			       lblNewLabel.setText(html1 + "300" + html2 + Arrays.toString(numseats));
			       label.setText(html1 + "300" + html2 + Arrays.toString(pickedSeats));
		    	} else {
					JOptionPane.showMessageDialog((Component)e.getSource(),
                            "You already picked all students!.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
		    	}
		    }
		});
		contentPane.add(btnPick);
		
		JLabel lblPicked = new JLabel("Picked!");
		lblPicked.setBounds(531, 28, 50, 16);
		contentPane.add(lblPicked);
		
		JLabel lblRemaining = new JLabel("Remaining");
		lblRemaining.setBounds(531, 130, 72, 16);
		contentPane.add(lblRemaining);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(64, 147, 117, 29);
		btnReset.addActionListener(new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
		    	reset();
		    }
		});
		contentPane.add(btnReset);
		
	}
		public void reset() {
			int [] numberSeats = IntStream.range(1, FirstMain.a + 1).toArray();
			numseats = numberSeats;
			pickedSeats = new int[] {};
			lblNewLabel.setText(html1 + "300" + html2 + Arrays.toString(numseats));
		    label.setText(html1 + "300" + html2 + Arrays.toString(pickedSeats));
		}
		 public static int getArrayIndex(int[] arr,int value) {

		        int k=0;
		        for(int i=0;i<arr.length;i++){

		            if(arr[i]==value){
		                k=i;
		                break;
		            }
		        }
		    return k;
		}
}
