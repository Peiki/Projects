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
					if(Integer.parseInt(tf.getText())<0 || Integer.parseInt(tf_1.getText())<0 || Integer.parseInt(tf_2.getText())<0) throw new IllegalArgumentException();
					if(Integer.parseInt(tf.getText())+Integer.parseInt(tf_1.getText())+Integer.parseInt(tf_2.getText())>=8 && Integer.parseInt(tf_3.getText())>0){
						progressBar.setValue(100);
						int x[]=new int[4];
						x[0]=Integer.parseInt(tf_3.getText());
						x[1]=Integer.parseInt(tf.getText());
						x[2]=Integer.parseInt(tf_1.getText());
						x[3]=Integer.parseInt(tf_2.getText());
						String s=generate(x);
						if(t==false){
							ta=new TextArea(f.getX(),f.getY());
							ta.setText(s);
							t=true;
						}
						else{
							ta.setText(s);
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
				catch(IllegalArgumentException e2){
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
	public String generate(int x[]){
		String s="";
		int r,y[]=new int[4];
		while(x[0]!=0){
			copy(x,y);
			while(!control(y)){
				r=(int)(Math.random()*3+1);
				if(y[r]!=0){
					y[r]--;
					if(r==1)
						s+=addLetter();
					else if(r==2)
						s+=addDigit();
					else
						s+=addSC();
				}
			}
			s+="\r\n";
			x[0]--;
		}
		return s;
	}
	public boolean control(int x[]){
		for(int i=1;i<x.length;i++)
			if(x[i]!=0)
				return false;
		return true;
	}
	public void copy(int x[],int y[]){
		for(int i=0;i<x.length;i++)
			y[i]=x[i];
	}
	public char addLetter(){
		return 'A';
	}
	public char addDigit(){
		return (char)((int)(Math.random()*(58-48)+48));
	}
	public char addSC(){
		int x=(int)(Math.random()*4+1),min,max;
		if(x==1){
			min=33;
			max=47;
		}
		else if(x==2){
			min=58;
			max=64;
		}
		else if(x==3){
			min=91;
			max=96;
		}
		else{
			min=123;
			max=126;
		}
		return (char)((int)(Math.random()*(max+1-min)+min));
	}
}