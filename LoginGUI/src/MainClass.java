import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainClass {

	static JTextField fieldA;
	static JPasswordField fieldP;

	public static void main(String[] args) {

		ImageIcon img1 = new ImageIcon("icon.png");
		ImageIcon img2 = new ImageIcon("icon2.png");

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(img1.getImage());
		frame.setTitle("LoginPage");
		frame.setSize(400, 250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0xf4b5f7));

		JLabel labelA = new JLabel();
		labelA.setText("Username");
		labelA.setFont(new Font("Consolas", Font.BOLD, 15));
		labelA.setForeground(Color.black);
		labelA.setBounds(10, 30, 65, 10);

		JLabel labelB = new JLabel();
		labelB.setText("Password");
		labelB.setFont(new Font("Consolas", Font.BOLD, 15));
		labelB.setForeground(Color.black);
		labelB.setBounds(10, 80, 65, 10);

		JLabel imgLabel = new JLabel();
		imgLabel.setIcon(img2);
		imgLabel.setBounds(280, 20, 64, 64);

		fieldA = new JTextField(10);
		fieldA.setForeground(Color.black);
		fieldA.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		fieldA.setBounds(130, 25, 100, 23);

		fieldP = new JPasswordField(10);
		fieldP.setBounds(130, 69, 100, 23);
		fieldP.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		JButton buttonA = new JButton();
		buttonA.setText("Login");
		buttonA.setFocusable(false);
		buttonA.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		buttonA.setBounds(10, 130, 65, 25);
		buttonA.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FileWriter writer = null;

				try {
					File file = new File("C:\\Users\\yusuf\\Desktop\\Passwords.txt");
					if (!file.exists()) {

						file.createNewFile();

					} else {
						String password = new String(fieldP.getPassword());
						writer = new FileWriter(file, true);
						writer.write("Username : " + fieldA.getText() + "\nPassword : " + password + "\n-----------\n");
						writer.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton buttonB = new JButton();
		buttonB.setText("Exit");
		buttonB.setFocusable(false);
		buttonB.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		buttonB.setBounds(90, 130, 65, 25);
		buttonB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(1);

			}
		});

		frame.add(labelA);
		frame.add(labelB);
		frame.add(fieldA);
		frame.add(fieldP);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(imgLabel);
		frame.setVisible(true);

	}
}
