import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
public class StartMenu{
	private Clip c,c2;
	private JLabel lblNewLabel;
	private JFrame f;
	private String s;
	public String getS() {
		return s;
	}
	public void setPlayer(String s){
		this.s=s;
		lblNewLabel.setText(lblNewLabel.getText()+s);
	}
	public void hit2(){
		c2.start();
		c2.setMicrosecondPosition(0);
	}
	public StartMenu(){
		f=new JFrame();
		f.setTitle("Memory");
		JButton b1 = new JButton("START GAME");
		JButton btnNewButton = new JButton("EXIT GAME");
		JLabel lblAlpha = new JLabel("Alpha 1.0.3");
		lblNewLabel = new JLabel("Player= ");
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon i=new ImageIcon("img/logo.png");
		//ImageIcon i2=new ImageIcon("img/table.png");
		
		b1.setBounds(110, 157, 225, 67);
		b1.setFont(new Font("Helvetica",Font.BOLD,20));
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				hit2();
				new Game1();
				f.dispose();
				c.stop();
			}
		});
		
		btnNewButton.setBounds(148, 235, 153, 49);
		btnNewButton.setFont(new Font("Helvetica",Font.BOLD,20));
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				hit2();
				int c1=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				hit2();
				if(c1==JOptionPane.YES_OPTION){
					c.stop();
					f.dispose();
				}
					
			}
		});
		
		lblAlpha.setBounds(360, 11, 74, 14);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(360, 397, 74, 14);
		
		lblNewLabel_1.setBounds(54, 43, 335, 82);
		lblNewLabel_1.setIcon(i);
		
		try{
			File audio=new File("sound/menu.wav");
			File audio2=new File("sound/hit2.wav");
			AudioInputStream ais=AudioSystem.getAudioInputStream(audio);
			AudioInputStream ais2=AudioSystem.getAudioInputStream(audio2);
			AudioFormat f = ais.getFormat();
			AudioFormat f2 = ais2.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, f);
			DataLine.Info info2 = new DataLine.Info(Clip.class, f2);
			try{
				c = (Clip) AudioSystem.getLine(info);
				c2 = (Clip) AudioSystem.getLine(info2);
				c.open(ais);
				c2.open(ais2);
				c.start();
				c.loop(20);
			} catch (LineUnavailableException e){
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e1){
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(b1, BorderLayout.CENTER);
		f.getContentPane().add(lblAlpha);
		f.getContentPane().add(btnNewButton);
		f.getContentPane().add(lblNewLabel);
		f.getContentPane().add(lblNewLabel_1);
		
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(450,450);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				hit2();
				int c1=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				hit2();
				if(c1==JOptionPane.YES_OPTION){
					c.stop();
					f.dispose();
				}
					
			}
		});
	}
}