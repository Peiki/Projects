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
	private Clip c;
	private JLabel lblNewLabel;
	private JFrame f;
	public void setPlayer(String s){
		lblNewLabel.setText(lblNewLabel.getText()+s);
	}
	public StartMenu(){
		f=new JFrame();
		f.setTitle("Memory");
		JButton b1 = new JButton("START GAME");
		JButton btnNewButton = new JButton("EXIT GAME");
		JLabel lblAlpha = new JLabel("Alpha 1.0.1");
		lblNewLabel = new JLabel("Player= ");
		
		b1.setBounds(110, 157, 225, 67);
		b1.setFont(new Font("Helvetica",Font.BOLD,20));
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
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
				int c1=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				if(c1==JOptionPane.YES_OPTION){
					c.stop();
					f.dispose();
				}
					
			}
		});
		
		lblAlpha.setBounds(360, 11, 74, 14);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(360, 397, 74, 14);
		
		try{
			File audio=new File("sound/menu.wav");
			AudioInputStream ais=AudioSystem.getAudioInputStream(audio);
			AudioFormat f = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, f);
			try{
				c = (Clip) AudioSystem.getLine(info);
				c.open(ais);
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
		f.getContentPane().setBackground(Color.GREEN);
		
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(450,450);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int c1=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				if(c1==JOptionPane.YES_OPTION){
					c.stop();
					f.dispose();
				}
					
			}
		});
	}
}