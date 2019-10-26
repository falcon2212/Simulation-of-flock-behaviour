package flockbase;
import java.util.ArrayList;
public class Flock2017028 extends Flock{
	public Flock2017028()
	{
		birds = new ArrayList<Bird>();
	}
	public void addBird(Bird b)
	{
		birds.add(b);
		b.setFlock(this);
	}

	// Make this Bird the leader of the flock
	public void setLeader(Bird leader)
	{
		
		this.leader = leader;
		leader.becomeLeader();
		leaderind = birds.indexOf(leader);
	}

	// get current list of birds in the flock
	public ArrayList<Bird> getBirds()
	{
		return birds;	
	}

	// return the current leader
	public Bird getLeader()
	{
		return leader;
	}
	
	// split with the bird at pos as the leader of new flock
	// Returns the new flock formed
	public Flock split(int pos)

	{

		//pos has to be greater than 0
		if(pos<=1) return null;
		ArrayList<Bird> flock1 = new ArrayList<Bird>(birds.subList(0,pos));
		ArrayList<Bird> flock2 = new ArrayList<Bird>(birds.subList(pos,birds.size()));
		
		/*
			if current leader is in the first flock,then the leader for the new flock is the bird at pos
		*/
		if(flock1.contains(getLeader()))
		{
			for(Bird b:flock2)
				getBirds().remove(b);
			Bird nextLeader = flock2.get(0);
			Flock retFlock = new Flock2017028();
			for(Bird b:flock2)
				retFlock.addBird(b);
			retFlock.setLeader(nextLeader);
			nextLeader.setTarget(200,800);
			return retFlock;
		}
		else
		{
			for(Bird b:flock2)
				getBirds().remove(b);
			setLeader(getBirds().get(pos-1));
			Bird nextLeader = getLeader();
			Flock retFlock = new Flock2017028();
			for(Bird b:flock2)
			{
				retFlock.addBird(b);
			}
			retFlock.setLeader(nextLeader);
			nextLeader.setTarget(200,800);
			return retFlock;
							
		}

	}

	// merges current flock with flock f - should join at end of f
	public void joinFlock(Flock f)
	{
		// getLeader().retireLead();
		// Bird tail = f.getBirds().get(f.getBirds().size()-1);
		Bird tail = f.getLeader();
		for(Bird bird:birds)
		{
			f.addBird(bird);
		}

		getLeader().retireLead();
		getLeader().setTarget(tail.getPos().getX(),tail.getPos().getY());
	} 

	private ArrayList<Bird> birds;
	private Bird leader;
	private int leaderind;
}