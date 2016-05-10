import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
public class Gui{
	TextArea ta;
	JFrame f=new JFrame();
	boolean t=false;
	public Gui(){
		JTextField tf= new JTextField("5");
		JTextField tf_1= new JTextField("2");
		JTextField tf_2= new JTextField("1");
		JTextField tf_3=new JTextField("1");
		JButton b = new JButton("Generate");
		JLabel lblc = new JLabel("Lettere= ");
		JLabel lbll = new JLabel("Cifre= ");
		JLabel lblcs = new JLabel("Caratteri Speciali= ");
		JProgressBar progressBar = new JProgressBar();
		JLabel lbln = new JLabel("N\u00B0 Passwords= ");
		JLabel lblm = new JLabel("Maiuscole? ");
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		
		lblc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblc.setBounds(10, 67, 142, 14);
		
		lbll.setHorizontalAlignment(SwingConstants.RIGHT);
		lbll.setBounds(10, 92, 142, 14);
		
		lblcs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblcs.setBounds(10, 117, 144, 14);
		
		lbln.setHorizontalAlignment(SwingConstants.RIGHT);
		lbln.setBounds(195, 67, 173, 14);
		
		lblm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblm.setBounds(195, 92, 173, 14);
		
		tf.setBounds(154, 64, 31, 20);
		tf.setColumns(10);
		
		tf_1.setBounds(154, 89, 31, 20);
		tf_1.setColumns(10);
		
		tf_2.setBounds(154, 114, 31, 20);
		tf_2.setColumns(10);
		
		tf_3.setText("1");
		tf_3.setBounds(369, 64, 31, 20);
		
		progressBar.setBounds(10, 304, 519, 14);
		progressBar.setStringPainted(true);
		
		chckbxNewCheckBox.setBounds(369, 88, 31, 23);
		chckbxNewCheckBox.setSelected(true);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(Integer.parseInt(tf.getText())+Integer.parseInt(tf_1.getText())+Integer.parseInt(tf_2.getText())>=8 && Integer.parseInt(tf_3.getText())>0){
						progressBar.setValue(100);
						String s=generate();
						if(t==false){
							ta=new TextArea(f.getX(),f.getY());
							t=true;
						}
						else{
							ta.setText("Ciao");
							//TODOs
						}
					}
					else if(Integer.parseInt(tf_3.getText())<=0)
						JOptionPane.showMessageDialog(null, "Inserire almeno una password","Error",JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Utilizzare almeno 8 caratteri","Error",JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		b.setBounds(218, 256, 104, 37);
		
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setSize(545, 357);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setTitle("Password Generator by [Peikiz]");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int c=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Exit",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		
		f.getContentPane().add(b);
		f.getContentPane().add(lblc);
		f.getContentPane().add(lbll);
		f.getContentPane().add(lblcs);
		f.getContentPane().add(lbln);
		f.getContentPane().add(tf);
		f.getContentPane().add(tf_1);
		f.getContentPane().add(tf_2);
		f.getContentPane().add(tf_3);
		f.getContentPane().add(progressBar);
		f.getContentPane().add(lblm);
		f.getContentPane().add(chckbxNewCheckBox);
	}
	public String generate(){
		return "";
		//TODOs
	}
}