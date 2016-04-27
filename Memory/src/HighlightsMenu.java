import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
public class HighlightsMenu{
	public HighlightsMenu(long t){
		JFrame f=new JFrame();
		JButton btnTornaAlMenu = new JButton("Torna al Menu");
		JLabel lbl = new JLabel("HAI STABILITO UN NUOVO RECORD!");
		JLabel lbl2 = new JLabel("Classifica:"); 
		JTextArea textArea = new JTextArea();
		
		try {
			FileWriter fw=new FileWriter("Highlights.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			//bw.write((int)t);
			bw.write("ciao");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fr=new FileReader("Highlights.txt");
			BufferedReader br=new BufferedReader(fr);
			String s="";
			while(true){
				s=br.readLine();
				if(s==null)
					break;
				textArea.setText(textArea.getText()+s);
			}
			fr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lbl.setBounds(10, 11, 324, 14);
		lbl.setFont(new Font("Helvetica",Font.BOLD,16));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVisible(control());
		
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(10, 36, 324, 14);
		
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new StartMenu();
			}
		});
		btnTornaAlMenu.setBounds(220, 388, 114, 23);
		
		textArea.setBounds(31, 72, 282, 288);
		textArea.setEditable(false);
		
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(350,450);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		f.getContentPane().add(lbl);
		f.getContentPane().add(lbl2);
		f.getContentPane().add(btnTornaAlMenu);
		f.getContentPane().add(textArea);
		
		
	}
	public boolean control(){
		return true;
	}
}