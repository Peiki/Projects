public class App{
	public static void main(String args[]){
		boolean t=true;
		NameMenu nm=new NameMenu();
		StartMenu sm;;
		while(nm.getState()){
			if(t){
				System.out.println("Inserting name...");
				t=false;
			}
		}
		if(!nm.getExit()){	
			System.out.println("Playing...");
			sm=new StartMenu();
			sm.setMusic(true);
			String s=nm.getName();
			sm.setPlayer(s);
		}
	}
}