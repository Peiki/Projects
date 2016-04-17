import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Window.Type;
import javax.swing.JLabel;
public class NameMenu{
	private boolean state=true;
	private JButton btnNewButton;
	private JButton button_5;
	private JButton button_6;
	private JFrame f;
	public boolean getState(){
		return state;
	}
	private boolean exit=false;
	public boolean getExit(){
		return exit;
	}
	public String getName(){
		return btnNewButton.getText()+button_5.getText()+button_6.getText();
	}
	public NameMenu(){
		f=new JFrame();
		f.setType(Type.UTILITY);
		f.setTitle("Memory");
		JButton button = new JButton("^");
		JButton button_1 = new JButton("^");
		JButton button_2 = new JButton("^");
		JButton btnV = new JButton("v");
		JButton button_3 = new JButton("v");
		JButton button_4 = new JButton("v");
		JButton btnFatto = new JButton("FATTO");
		btnNewButton = new JButton("A");
		button_5 = new JButton("A");
		button_6 = new JButton("A");
		f.setVisible(true);
		f.setSize(318,193);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setResizable(false);
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(button);
		f.getContentPane().add(button_1);
		f.getContentPane().add(button_2);
		f.getContentPane().add(btnV);
		f.getContentPane().add(button_3);
		f.getContentPane().add(button_4);
		f.getContentPane().add(btnFatto);
		f.getContentPane().add(btnNewButton);
		f.getContentPane().add(button_5);
		f.getContentPane().add(button_6);
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int c=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION){
					exit=true;
					state=false;
					f.dispose();
				}
			}
		});
		
		button.setBounds(44, 39, 50, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=btnNewButton.getText();
				char c=s.charAt(0);
				if(c=='Z')
					btnNewButton.setText("A");
				else{
					c=(char)((int)(c)+1);
					btnNewButton.setText(Character.toString(c));
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=button_5.getText();
				char c=s.charAt(0);
				if(c=='Z')
					button_5.setText("A");
				else{
					c=(char)((int)(c)+1);
					button_5.setText(Character.toString(c));
				}
			}
		});
		button_1.setBounds(133, 39, 50, 23);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=button_6.getText();
				char c=s.charAt(0);
				if(c=='Z')
					button_6.setText("A");
				else{
					c=(char)((int)(c)+1);
					button_6.setText(Character.toString(c));
				}
			}
		});
		button_2.setBounds(226, 39, 50, 23);
		
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=btnNewButton.getText();
				char c=s.charAt(0);
				if(c=='A')
					btnNewButton.setText("Z");
				else{
					c=(char)((int)(c)-1);
					btnNewButton.setText(Character.toString(c));
				}
			}
		});
		btnV.setBounds(44, 86, 50, 23);
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=button_5.getText();
				char c=s.charAt(0);
				if(c=='A')
					button_5.setText("Z");
				else{
					c=(char)((int)(c)-1);
					button_5.setText(Character.toString(c));
				}
			}
		});
		button_3.setBounds(133, 86, 50, 23);
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=button_6.getText();
				char c=s.charAt(0);
				if(c=='A')
					button_6.setText("Z");
				else{
					c=(char)((int)(c)-1);
					button_6.setText(Character.toString(c));
				}
			}
		});
		button_4.setBounds(226, 86, 50, 23);
		
		btnFatto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
				f.dispose();
			}
		});
		btnFatto.setBounds(116, 135, 89, 23);	
		
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(44, 62, 50, 23);
		
		button_5.setEnabled(false);
		button_5.setBounds(133, 62, 50, 23);
		
		button_6.setEnabled(false);
		button_6.setBounds(226, 62, 50, 23);
		
		JLabel lblInserisciLeTue = new JLabel("Inserisci le tue iniziali");
		lblInserisciLeTue.setBounds(95, 11, 127, 14);
		f.getContentPane().add(lblInserisciLeTue);
	}
}