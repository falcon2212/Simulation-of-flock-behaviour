import flockbase.Bird;
import flockbase.Flock;
import flockbase.Bird2017028;
import flockbase.Flock2017028;
import flockbase.Bird2017016;
import flockbase.Flock2017016;
// import flockbase.Bird511;
// import flockbase.Flock2017016;

// import sample.*;

//sample main (which will be replaced by an interactive front-end. 
// You can use the following to test your code. 
// We will assume we have a 1000x1000 2D space in which the birds fly

public class TestFlock {
	public static void main(String[] args) {
		Flock f = new Flock2017028(); // where Flock2017028 is a concrete derived class of Flock

		// add a bunch of birds

		// repeat the above for the different derived classes of bird
		Bird b1 = new Bird2017028("leader"); // where Bird2017028 is a derived concrete class of Bird
		b1.setPos(100,100);
		f.addBird(b1);
		
		for(int i=0;i<5;i++){
			Bird b = new Bird2017028();
			b.setPos(i*100,  10);
			f.addBird(b);
		}
		// f.split(2);
		Bird2017016 eric = new Bird2017016("eric");
		eric.setPos(500,500);
		f.addBird(eric);
		
		FlockDisplay disp = new SwingDisplay();
		//FlockDisplay disp = new TextDisplay();
		
		App app = new App(disp);
		disp.setApp(app);
		app.init(f);
		
		app.setLeader(b1);
		app.setTarget(800,300);
	
		
		// try {
		// 	Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		
		// app.setLeader(b2);
		// app.setTarget(400, 200);
		
		// try {
		// 	Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		
		
		// Flock f2 = f.split(2);
		// Bird f2lead = f2.getLeader();
		// f2lead.setTarget(10, 20);
		
		// try {
		// 	Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		
		// f2.joinFlock(f);
		// f.getLeader().setTarget(100, 900);
	
		
	}
}
