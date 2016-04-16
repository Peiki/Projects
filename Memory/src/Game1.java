import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class Game1{
	private boolean pause=false;
	private long t;
	private int e=0;
	private int[] z=new int[2];
	String n[]={"img/blue.png","img/red.png","img/green.png"};
	private int con=0;
	private JFrame f;
	private JButton button_0;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private ImageIcon ix;
	private ImageIcon ix2;
	private ImageIcon ix3;
	private ImageIcon[] cx={ new ImageIcon( n[ 0 ] ),new ImageIcon( n[ 1 ] ), new ImageIcon( n[ 2 ] ) };
	public Game1(){
		f=new JFrame();
		JButton btnNewButton = new JButton("Pause");
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_3 = new JLabel("");
		button_0 = new JButton("");
		button_1 = new JButton("");
		button_2 = new JButton("");
		button_3 = new JButton("");
		button_4 = new JButton("");
		button_5 = new JButton("");
		ImageIcon i=new ImageIcon("img/x2v.png");
		ImageIcon i2=new ImageIcon("img/x3v.png");
		ImageIcon i3=new ImageIcon("img/x4v.png");
		ImageIcon cc=new ImageIcon("img/cb.png");
		
		ix=new ImageIcon("img/x2.png");
		ix2=new ImageIcon("img/x3.png");
		ix3=new ImageIcon("img/x4.png");
		
		Card[] c=new Card[6];

		btnNewButton.setBounds(645, 11, 89, 23);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(!pause){
					PauseMenu();
					pause=true;
				}
			}
		});
		
		lblNewLabel_1.setBounds(10, 31, 40, 40);
		lblNewLabel_1.setIcon(i);
		
		lblNewLabel_2.setBounds(47, 21, 50, 50);
		lblNewLabel_2.setIcon(i2);
		
		lblNewLabel_3.setBounds(96, 11, 60, 60);
		lblNewLabel_3.setIcon(i3);
		
		
		button_0.setBounds(20, 82, 182, 244);
		button_0.setIcon(cc);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c[0].getStatus()){
					z[con]=0;
					con++;
					button_0.setIcon(c[0].getIcon());
					c[0].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]]))
						System.out.println("GG");
				}
			}
		});
		
		button_1.setBounds(275, 82, 182, 244);
		button_1.setIcon(cc);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c[1].getStatus()){
					z[con]=1;
					con++;
					button_1.setIcon(c[1].getIcon());
					c[1].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]]))
						System.out.println("GG");
				}
			}
		});

		button_2.setBounds(538, 82, 182, 244);
		button_2.setIcon(cc);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c[2].getStatus()){
					z[con]=2;
					con++;
					button_2.setIcon(c[2].getIcon());
					c[2].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]]))
						System.out.println("GG");
				}
			}
		});
		
		button_3.setBounds(20, 367, 182, 244);
		button_3.setIcon(cc);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c[3].getStatus()){
					z[con]=3;
					con++;
					button_3.setIcon(c[3].getIcon());
					c[3].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]]))
						System.out.println("GG");
				}
			}
		});
		
		button_4.setBounds(275, 367, 182, 244);
		button_4.setIcon(cc);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c[4].getStatus()){
					z[con]=4;
					con++;
					button_4.setIcon(c[4].getIcon());
					c[4].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]]))
						System.out.println("GG");
				}
			}
		});
		
		button_5.setBounds(538, 367, 182, 244);
		button_5.setIcon(cc);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!c[5].getStatus()){
					z[con]=5;
					con++;
					button_5.setIcon(c[5].getIcon());
					c[5].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]]))
						System.out.println("GG");
				}
			}
		});
		
		f.setTitle("Level 1");
		f.setVisible(true);
		f.setSize(750, 650);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int c=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION){
					f.dispose();
					t=System.currentTimeMillis()-t;
					System.out.println(t);
				}
			}
		});
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(btnNewButton);
		f.getContentPane().add(lblNewLabel_1);
		f.getContentPane().add(lblNewLabel_2);
		f.getContentPane().add(lblNewLabel_3);
		f.getContentPane().add(button_0);
		f.getContentPane().add(button_1);
		f.getContentPane().add(button_2);
		f.getContentPane().add(button_3);
		f.getContentPane().add(button_4);
		f.getContentPane().add(button_5);
		SetCards(c);
		t=System.currentTimeMillis();
	}
	public void PauseMenu(){
		t=t-System.currentTimeMillis();
		BlockGame(true);
		JFrame f2=new JFrame();
		AddError();
		f2.setSize(225,120);
		f2.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f2.setResizable(false);
		f2.setLocationRelativeTo(null);
		f2.getContentPane().setLayout(null);
		
		JLabel lblGamePaused = new JLabel("GAME PAUSED");
		lblGamePaused.setBounds(10, 11, 199, 20);
		lblGamePaused.setFont(new Font("Helvetica",Font.BOLD,20));
		lblGamePaused.setHorizontalAlignment(SwingConstants.CENTER);
		
		f2.getContentPane().add(lblGamePaused);
		
		JButton btnResume = new JButton("Resume");
		btnResume.setBounds(65, 42, 89, 23);
		f2.getContentPane().add(btnResume);
		
		btnResume.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				f2.dispose();
				pause=false;
				BlockGame(false);
				t=t+System.currentTimeMillis();
			}
		});
	}
	public void BlockGame(boolean t){
			button_0.setEnabled(!t);
			button_1.setEnabled(!t);
			button_2.setEnabled(!t);
			button_3.setEnabled(!t);
			button_4.setEnabled(!t);
			button_5.setEnabled(!t);
	}
	public void AddError(){
		if(e==0)
			lblNewLabel_1.setIcon(ix);
		else if(e==1)
			lblNewLabel_2.setIcon(ix2);
		else{
			lblNewLabel_3.setIcon(ix3);
			JOptionPane.showMessageDialog(null, "HAI PERSO");
			f.dispose();
			new StartMenu();
		}
		e++;
	}
	public void SetCards(Card[] c){
		int i=0,x;
		while(i<c.length){
			x=(int) (Math.random()*3+1);
			if(!control(x,c,i)){
				c[i]=new Card();
				c[i].setId(x);
				c[i].setIcon(cx[x-1]);
				i++;
			}
		}
	}
	public boolean control(int x,Card[] c,int i){
		int l=0;
		for(int j=0;j<i;j++)
			if(c[j].getId()==x)
				l++;
		if(l>=2)
			return true;
		return false;
	}
}