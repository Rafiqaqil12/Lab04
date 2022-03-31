import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ServerTextFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnglish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerTextFrame frame = new ServerTextFrame();
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
	public ServerTextFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnglish = new JTextField();
		txtEnglish.setBounds(172, 65, 341, 77);
		contentPane.add(txtEnglish);
		txtEnglish.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Text Translation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(252, 29, 219, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnMalay = new JButton("Bahasa Malaysia");
		btnMalay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String english = txtEnglish.getText();
				String choice = btnMalay.getActionCommand();
				try {
					Translator trans = new Translator(english,choice);
					dispose();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMalay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMalay.setBounds(89, 170, 157, 35);
		contentPane.add(btnMalay);
		
		JButton btnArabic = new JButton("Arabic");
		btnArabic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String english = txtEnglish.getText();
				String choice = btnArabic.getActionCommand();
				try {
					Translator trans = new Translator(english,choice);
					dispose();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnArabic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArabic.setBounds(289, 170, 136, 35);
		contentPane.add(btnArabic);
		
		JButton btnKorean = new JButton("Korean");
		btnKorean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String english = txtEnglish.getText();
				String choice = btnKorean.getActionCommand();
				try {
					Translator trans = new Translator(english,choice);
					dispose();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnKorean.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKorean.setBounds(464, 170, 136, 35);
		contentPane.add(btnKorean);
		
		JLabel lblNewLabel_1 = new JLabel("Translation");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(143, 257, 103, 26);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(136, 293, 379, 45);
		contentPane.add(textArea);
	}

	public void updateServerStatus(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void updateRequestStatus(String string) {
		// TODO Auto-generated method stub
		
	}
}
