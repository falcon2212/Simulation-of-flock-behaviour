package flockbase;

import flockbase.Bird;
import java.util.ArrayList;

public class Flock2017016 extends flockbase.Flock {
    // keep track of the birds in the flock
    private ArrayList<Bird> birds; 
    // keep track of all birds in feild to avoid collision
    private ArrayList<Bird> allbirds;
    Bird leader = null;

    public Flock2017016() {
        super();
        birds = new ArrayList<Bird>();
        allbirds = new ArrayList<Bird>();
    }

    // add a bird to flock
    public void addBird(Bird b) { 
        birds.add(b);
        allbirds.add(b);
        b.setFlock(this);
        // set target to leader
        if(leader != null) {
            b.setTarget(leader.getPos().getX(),leader.getPos().getY());
        }  
    }

    public void setLeader(Bird L) {
        int target_pos_X = 0;
        int target_pos_Y = 0;
        
        if (leader != null) {
            target_pos_X = leader.getTarget().getX();
            target_pos_Y = leader.getTarget().getY();
            // iterate over the flock and set the leader
            leader.retireLead();
            // the target pos of each bird is set to the new leaders position
            for (Bird i : leader.getFlock().getBirds()) {
                // i.setTarget(L.getPos().getX(),L.getPos().getY());
            }
        }

        leader = L;
        // keep the target of earlier leader as the new leaders target
        leader.setTarget(target_pos_X,target_pos_Y);
        leader.becomeLeader();
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    public Bird getLeader() {
        return leader;
    }


    public flockbase.Flock split(int pos) {
        // split at the position given and set the new leader as the bird in the position given.
        // make the bird go to the target of earlier leader 
        // make the remaining after pos follow the second leader 
        Flock newf = new Flock2017016();
        boolean contain_leader = false;
        
        for (int i = 0; i < pos; i++) {
            System.out.println("bird " + birds.get(i).getName());

            if(birds.get(i).getName() == leader.getName()) {
                contain_leader = true;
                newf.setLeader(birds.get(i));
            }
            newf.addBird(birds.get(i));

        }
        

        for (int i = 0; i < pos; i++) {            
            birds.remove(0);
        }

        // contains leader
        if(contain_leader == true) {
            // System.out.println("error her");
            setLeader(birds.get(0));
        }

        // new flock doesnt contain leader
        else {
            newf.setLeader((newf.getBirds()).get(0));
        }

        return newf;
    }

    public void joinFlock(flockbase.Flock f) {
        // join the flock and make the second leader follow the first
        // the remaining birds in the flock should follow the leader of the first

        for(int i = 0; i < getBirds().size(); i++) {
            getBirds().get(i).retireLead();
            f.addBird(getBirds().get(i));
            
        }

    }


}
