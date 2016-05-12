import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class Game1{
	private boolean pause=false,m;
	private long t;
	private int e=0;
	private int[] z=new int[2];
	String n[]={"img/blue.png","img/red.png","img/green.png"};
	private int con=0,con2=0,win=0;
	private JFrame f;
	private JFrame f2;
	private JButton button[]=new JButton[6];
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private ImageIcon ix;
	private ImageIcon ix2;
	private ImageIcon ix3;
	private ImageIcon cc;
	private ImageIcon[] cx={ new ImageIcon( n[ 0 ] ),new ImageIcon( n[ 1 ] ), new ImageIcon( n[ 2 ] ) };
	private Card[] c;
	private Clip c2,c3,c4;
	private String s;
	void hit2(){
		c4.start();
		c4.setMicrosecondPosition(0);
	}
	void setName(String s){
		this.s=s;
	}
	void setMusic(boolean m){
		this.m=m;
		System.out.print(m);
	}
	public Game1(){
		f=new JFrame();
		JButton btnNewButton = new JButton("Pause");
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_3 = new JLabel("");
		ImageIcon i=new ImageIcon("img/x2v.png");
		ImageIcon i2=new ImageIcon("img/x3v.png");
		ImageIcon i3=new ImageIcon("img/x4v.png");
		cc=new ImageIcon("img/cb.png");
		
		ix=new ImageIcon("img/x2.png");
		ix2=new ImageIcon("img/x3.png");
		ix3=new ImageIcon("img/x4.png");
		
		c=new Card[6];

		btnNewButton.setBounds(645, 11, 89, 23);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(!pause){
					PauseMenu();
					pause=true;
					c2.stop();
					c2.close();
				}
			}
		});
		
		lblNewLabel_1.setBounds(10, 31, 40, 40);
		lblNewLabel_1.setIcon(i);
		
		lblNewLabel_2.setBounds(47, 21, 50, 50);
		lblNewLabel_2.setIcon(i2);
		
		lblNewLabel_3.setBounds(96, 11, 60, 60);
		lblNewLabel_3.setIcon(i3);
		
		for(int h=0;h<button.length;h++){
			button[h]=new JButton();
			button[h].setIcon(cc);
			//button[h].addActionListener(this);
		}
		
		button[0].setBounds(20, 82, 182, 244);
		button[1].setBounds(275, 82, 182, 244);
		button[2].setBounds(538, 82, 182, 244);
		button[3].setBounds(20, 367, 182, 244);
		button[4].setBounds(275, 367, 182, 244);
		button[5].setBounds(544, 367, 182, 244);
		
		/*class Listener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		}*/
		
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit2();
				if(!c[0].getStatus()){
					if(con2==1){
						button[z[0]].setIcon(cc);
						button[z[1]].setIcon(cc);
						con2--;
					}
					button[0].setIcon(c[0].getIcon());
					z[con]=0;
					con++;
					c[0].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]])){
						button[z[0]].setEnabled(false);
						button[z[1]].setEnabled(false);
						c[z[0]].setStatus();
						c[z[1]].setStatus();
						win++;
					}
					else{
						con2++;
						AddError();
					}
				}
				if(win==3){
					JOptionPane.showMessageDialog(null, "HAI VINTO!");
					t=System.currentTimeMillis()-t;
					f.dispose();
					new HighlightsMenu(t,s);
					c2.stop();
					c2.close();
				}
			}
		});
		
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit2();
				if(!c[1].getStatus()){
					if(con2==1){
						button[z[0]].setIcon(cc);
						button[z[1]].setIcon(cc);
						con2--;
					}
					button[1].setIcon(c[1].getIcon());
					z[con]=1;
					con++;
					c[1].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]])){
						button[z[0]].setEnabled(false);
						button[z[1]].setEnabled(false);
						c[z[0]].setStatus();
						c[z[1]].setStatus();
						win++;
					}
					else{
						con2++;
						AddError();
					}
				}
				if(win==3){
					JOptionPane.showMessageDialog(null, "HAI VINTO!");
					t=System.currentTimeMillis()-t;
					System.out.println(t);
					f.dispose();
					new HighlightsMenu(t,s);
					c2.stop();
					c2.close();
				}
			}
		});

		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit2();
				if(!c[2].getStatus()){
					if(con2==1){
						button[z[0]].setIcon(cc);
						button[z[1]].setIcon(cc);
						con2--;
					}
					button[2].setIcon(c[2].getIcon());
					z[con]=2;
					con++;
					c[2].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]])){
						button[z[0]].setEnabled(false);
						button[z[1]].setEnabled(false);
						c[z[0]].setStatus();
						c[z[1]].setStatus();
						win++;
					}
					else{
						con2++;
						AddError();
					}
				}
				if(win==3){
					JOptionPane.showMessageDialog(null, "HAI VINTO!");
					t=System.currentTimeMillis()-t;
					System.out.println(t);
					f.dispose();
					new HighlightsMenu(t,s);
					c2.stop();
					c2.close();
				}
			}
		});
		
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit2();
				if(!c[3].getStatus()){
					if(con2==1){
						button[z[0]].setIcon(cc);
						button[z[1]].setIcon(cc);
						con2--;
					}
					button[3].setIcon(c[3].getIcon());
					z[con]=3;
					con++;
					c[3].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]])){
						button[z[0]].setEnabled(false);
						button[z[1]].setEnabled(false);
						c[z[0]].setStatus();
						c[z[1]].setStatus();
						win++;
					}
					else{
						con2++;
						AddError();
					}
				}
				if(win==3){
					JOptionPane.showMessageDialog(null, "HAI VINTO!");
					t=System.currentTimeMillis()-t;
					System.out.println(t);
					f.dispose();
					new HighlightsMenu(t,s);
					c2.stop();
					c2.close();
				}
			}
		});
		
		button[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit2();
				if(!c[4].getStatus()){
					if(con2==1){
						button[z[0]].setIcon(cc);
						button[z[1]].setIcon(cc);
						con2--;
					}
					button[4].setIcon(c[4].getIcon());
					z[con]=4;
					con++;
					c[4].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]])){
						button[z[0]].setEnabled(false);
						button[z[1]].setEnabled(false);
						c[z[0]].setStatus();
						c[z[1]].setStatus();
						win++;
					}
					else{
						con2++;
						AddError();
					}
				}
				if(win==3){
					JOptionPane.showMessageDialog(null, "HAI VINTO!");
					t=System.currentTimeMillis()-t;
					System.out.println(t);
					f.dispose();
					new HighlightsMenu(t,s);
					c2.stop();
					c2.close();
				}
			}
		});
		
		button[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hit2();
				if(!c[5].getStatus()){
					if(con2==1){
						button[z[0]].setIcon(cc);
						button[z[1]].setIcon(cc);
						con2--;
					}
					button[5].setIcon(c[5].getIcon());
					z[con]=5;
					con++;
					c[5].turn();
				}
				if(con==2){
					con=0;
					c[z[0]].turn();
					c[z[1]].turn();
					if(c[z[0]].isEqual(c[z[1]])){
						button[z[0]].setEnabled(false);
						button[z[1]].setEnabled(false);
						c[z[0]].setStatus();
						c[z[1]].setStatus();
						win++;
					}
					else{
						con2++;
						AddError();
					}
				}
				if(win==3){
					JOptionPane.showMessageDialog(null, "HAI VINTO!");
					t=System.currentTimeMillis()-t;
					System.out.println(t);
					f.dispose();
					new HighlightsMenu(t,s);
					c2.stop();
					c2.close();
				}
					
			}
		});
		
		try{
			File audio=new File("sound/game.wav");
			File audio2=new File("sound/lose.wav");
			File audio3=new File("sound/flip.wav");
			AudioInputStream ais=AudioSystem.getAudioInputStream(audio);
			AudioInputStream ais2=AudioSystem.getAudioInputStream(audio2);
			AudioInputStream ais3=AudioSystem.getAudioInputStream(audio3);
			AudioFormat f = ais.getFormat();
			AudioFormat f2= ais2.getFormat();
			AudioFormat f3= ais3.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, f);
			DataLine.Info info2 = new DataLine.Info(Clip.class, f2);
			DataLine.Info info3 = new DataLine.Info(Clip.class, f3);
			try{
				c2 = (Clip) AudioSystem.getLine(info);
				c2.open(ais);
				if(m){
					c2.start();
					c2.loop(20);
				}
				c3 = (Clip) AudioSystem.getLine(info2);
				c3.open(ais2);
				c4 = (Clip) AudioSystem.getLine(info3);
				c4.open(ais3);
			} catch (LineUnavailableException e){
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e1){
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
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
					c2.stop();
					c2.close();
				}
			}
		});
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(btnNewButton);
		f.getContentPane().add(lblNewLabel_1);
		f.getContentPane().add(lblNewLabel_2);
		f.getContentPane().add(lblNewLabel_3);
		for(int h=0;h<button.length;h++)
			f.getContentPane().add(button[h]);
		SetCards(c);
		t=System.currentTimeMillis();
	}
	public void PauseMenu(){
		t=t-System.currentTimeMillis();
		BlockGame(true);
		f2=new JFrame();
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
				c2.start();
			}
		});
	}
	public void BlockGame(boolean t){
		for(int h=0;h<button.length;h++)
			if(!c[h].getStatus2())
				button[h].setEnabled(!t);
	}
	public void AddError(){
		if(e==0)
			lblNewLabel_1.setIcon(ix);
		else if(e==1)
			lblNewLabel_2.setIcon(ix2);
		else{
			lblNewLabel_3.setIcon(ix3);
			c2.stop();
			c2.close();
			c3.start();
			JOptionPane.showMessageDialog(null, "HAI PERSO");
			f.dispose();
			StartMenu sm=new StartMenu();
			sm.setPlayer(s);
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