
import java.util.*;
import java.io.*;

interface Global {
	Random r = new Random();
	final static int totalTracks = r.nextInt(200) + 1;
	final static int n = r.nextInt(30);
	static Vector<Integer> copyTrackNumbers = new Vector<Integer>();
	static Vector<Integer> trackNumbers = new Vector<Integer>();
}

public class FCFS implements Global {
	int headPosition = r.nextInt((int) (totalTracks / 2));
	int totalHeadMovement = 0;
	boolean over = false;

	public static void main(String[] args) throws InterruptedException {
		FCFS fcfs = new FCFS();
		System.out.println("\nFCFS(First Come First Serve) Disk Scheduling");
		Thread.currentThread().sleep(500);
		System.out.println("Total number of tracks on the disk are: " + fcfs.totalTracks + "\n");
		System.out.println("Current Header Position is: " + fcfs.headPosition + "\n");
		System.out.println("Total number of Disk requests = " + n);
		Output output = new Output(fcfs);
		output.setName("Output Thread");
		ForLoop forloop = new ForLoop(fcfs);
		forloop.setName("ForLoop Thread");
		forloop.start();
		output.start();
	}
}

class ForLoop extends Thread implements Global {
	static int trackNo = 0;
	FCFS fcfs;

	public ForLoop(FCFS fcfs) {
		this.fcfs = fcfs;
	}

	public void run() {
		try {
			for (int i = 0; i < n; i++) {
				Thread.currentThread().sleep(1000);
				trackNo = r.nextInt(totalTracks);
				trackNumbers.add(trackNo);
				copyTrackNumbers.add(trackNo);
			}
			fcfs.over = true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class Output extends Thread implements Global {
	String headTraversal = "";
	FCFS fcfs;

	public Output(FCFS fcfs) {
		this.fcfs = fcfs;
		this.headTraversal = this.fcfs.headPosition + " ";
	}

	public void run() {
		try {
			while (!fcfs.over) {
				Thread.currentThread().sleep(1500);
				while (trackNumbers.size() != 0) {
					int moveToTrack = trackNumbers.remove(0);
					System.out.println("Header movement: " + fcfs.headPosition + " -> " + moveToTrack);
					fcfs.totalHeadMovement += Math.abs(fcfs.headPosition - moveToTrack);
					headTraversal += "->" + moveToTrack + " ";
					int seekTime = (Math.abs(fcfs.headPosition - moveToTrack));
					System.out.println(headTraversal + "\tSeek Time needed: " + seekTime + "\n");
					fcfs.headPosition = moveToTrack;
					Thread.currentThread().sleep(seekTime * 90);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
