import javax.swing.ImageIcon;
public class Card{
	int id=0;
	boolean status=false,status2=false;
	ImageIcon i;
	public void setIcon(ImageIcon i){
		this.i=i;
	}
	public ImageIcon getIcon(){
		return i;
	}
	public void setId(int i){
		this.id=i;
	}
	public int getId(){
		return id;
	}
	public boolean getStatus(){
		return status;
	}
	public boolean getStatus2(){
		return status2;
	}
	public void setStatus(){
		status2=true;
	}
	public void turn(){
		status=!status;
	}
	public boolean isEqual(Card c){
		if(this.id==c.id)
			return true;
		return false;
	}
}