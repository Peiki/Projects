import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TextArea{
	private JTextArea textArea = new JTextArea();
	public void setText(String s){
		textArea.setText(s);
		//TODOs
	}
	public TextArea(int x,int y){
		JFrame f=new JFrame();
		JScrollPane scroll=new JScrollPane();
		JButton btnNewButton = new JButton("Save");
		JFileChooser fc=new JFileChooser();
		
		fc.setCurrentDirectory(null);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Save");
		
		textArea.setBounds(0, 0, 226, 247);
		textArea.setEditable(false);
		
		scroll.setBounds(0, 0, 226, 274);
		
		btnNewButton.setBounds(61, 285, 95, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=fc.showOpenDialog(btnNewButton);
				if(i==JFileChooser.APPROVE_OPTION){
					File fi=fc.getSelectedFile();
					if(!fi.exists())
						JOptionPane.showMessageDialog(null, "File doesn't exist!","Error",JOptionPane.ERROR_MESSAGE);
					else{
						try {
							FileWriter fw = new FileWriter(fi);
							fw.write(textArea.getText());
							fw.close();
							JOptionPane.showMessageDialog(null, "File Saved");
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "File doesn't exist!","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setSize(232, 357);
		f.setLocation(x+555, y);
		f.setTitle("Passwords:");
		f.getContentPane().setLayout(null);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				int c=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire?","Exit",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		
		f.getContentPane().add(scroll);
		f.getContentPane().add(textArea);
		f.getContentPane().add(btnNewButton);
		scroll.getViewport().setView(textArea);
	}
}