package Mail;

import java.awt.EventQueue;

import javax.swing.JFrame;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailGonder {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailGonder window = new MailGonder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MailGonder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 263, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMailGonder = new JButton("Mail Gönder");
		btnMailGonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				  String gonderen = "ugur.selam0@gmail.com";
				  String sifre = "imwt jrtk fwlz udxb";
				  String alici = "ugur.selam0@gmail.com";
				
			      // SMTP sunucusu ayarları
			      Properties properties = new Properties();
			      properties.put("mail.smtp.auth", "true");
			      properties.put("mail.smtp.starttls.enable", "true");
			      properties.put("mail.smtp.host", "smtp.gmail.com");
			      properties.put("mail.smtp.port", "587");

			      // Oturum oluşturma
			      Session session = Session.getInstance(properties, new Authenticator() {
			          @Override
			          protected PasswordAuthentication getPasswordAuthentication() {
			              return new PasswordAuthentication(gonderen, sifre);
			          }
			      });
			      
			        try {
			            // Mesaj oluşturma
			            Message message = new MimeMessage(session);
			            message.setFrom(new InternetAddress(gonderen));// Gönderen
			            message.setRecipient(Message.RecipientType.TO, // Alıcı
			                    new InternetAddress(alici));
			            message.setSubject("Java ile Mail Gönderme"); // Konu
			            message.setText("Test mail");// İçerik

			            // Mesajı gönder
			            Transport.send(message);
			            System.out.println("Mail başarıyla gönderildi!");
			        } catch (Exception error) {
			        	error.printStackTrace();
			        }
				
			}
		});
		btnMailGonder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMailGonder.setBounds(53, 42, 144, 32);
		frame.getContentPane().add(btnMailGonder);
	}
}
