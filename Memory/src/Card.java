import javax.swing.ImageIcon;
public class Card{
	int id=0;
	boolean status=false;
	ImageIcon i;
	public void setIcon(ImageIcon i){
		this.i=i;
	}
	public ImageIcon getIcon(){
		return i;
	}
	public void setId(int i){
		this.id=i;
		System.out.println(id);
	}
	public int getId(){
		return id;
	}
	public boolean getStatus(){
		return status;
	}
	public void turn(){
		status=!status;
	}
}