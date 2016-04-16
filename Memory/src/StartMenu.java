import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class StartMenu{
	private JLabel lblNewLabel;
	public void setPlayer(String s){
		lblNewLabel.setText(lblNewLabel.getText()+s);
	}
	public StartMenu(){
		JFrame f=new JFrame();
		f.setTitle("Memory");
		JButton b1 = new JButton("START GAME");
		JButton btnNewButton = new JButton("EXIT GAME");
		JLabel lblAlpha = new JLabel("Alpha 0.1");
		lblNewLabel = new JLabel("Player= ");
		
		b1.setBounds(110, 157, 225, 67);
		b1.setFont(new Font("Helvetica",Font.BOLD,20));
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				new Game1();
				f.dispose();
			}
		});
		
		btnNewButton.setBounds(148, 235, 153, 49);
		btnNewButton.setFont(new Font("Helvetica",Font.BOLD,20));
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int c=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION)
					f.dispose();
			}
		});
		
		lblAlpha.setBounds(381, 11, 53, 14);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(360, 397, 74, 14);
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(b1, BorderLayout.CENTER);
		f.getContentPane().add(lblAlpha);
		f.getContentPane().add(btnNewButton);
		f.getContentPane().add(lblNewLabel);
		
		f.setResizable(false);
		f.setVisible(true);
		f.setSize(450,450);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int c=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Memory",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION)
					f.dispose();
			}
		});
	}
}