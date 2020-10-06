import java.util.*;
import java.io.*;

interface Global {
	Random r = new Random();
	final static int totalTracks = r.nextInt(200) + 1;
	final static int n = r.nextInt(15) + 5;
	final static double unitSeek = 0.1;
	static Vector<Integer> copyTrackNumbers = new Vector<Integer>();
	static Vector<Integer> trackNumbers = new Vector<Integer>();
}

public class SSTF implements Global {
	int headPosition = r.nextInt((int) (totalTracks / 2));
	int totalHeadMovement = 0;
	boolean over = false;
	static SSTF sstf;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("\nSSTF(Shortest Seek Time First) Disk Scheduling");
		sstf = new SSTF();
		Thread.currentThread().sleep(500);
		System.out.println("Total number of tracks on the disk are: " + totalTracks);
		System.out.println("Current Header Position is: " + sstf.headPosition);
		System.out.println("Total number of Disk requests =  " + n);
		Output output = new Output(sstf);
		output.setName("Output Thread");
		ForLoop forloop = new ForLoop(sstf);
		forloop.setName("ForLoop Thread");
		forloop.start();
		output.start();
	}

	public int calculateMinimumSeekTime() {
		int minimum = Integer.MAX_VALUE;
		int new_track = sstf.headPosition;
		int index = 0;
		for (int i = 0; i < trackNumbers.size(); i++) {
			if (Math.abs(sstf.headPosition - trackNumbers.get(i)) < minimum) {
				minimum = Math.abs(sstf.headPosition - trackNumbers.get(i));
				new_track = trackNumbers.get(i);
				index = i;
			}
		}
		trackNumbers.remove(index);
		return new_track;
	}
}

class ForLoop extends Thread implements Global {
	static int t = 0;
	SSTF sstf;

	public ForLoop(SSTF sstf) {
		this.sstf = sstf;
	}

	public void run() {
		try {
			for (int i = 0; i < n; i++) {
				Thread.currentThread().sleep(1000);
				t = r.nextInt(totalTracks);
				trackNumbers.add(t);
				copyTrackNumbers.add(t);
			}
			sstf.over = true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Output extends Thread implements Global {
	String headTraversal = "";
	SSTF sstf;

	public Output(SSTF sstf) {
		this.sstf = sstf;
		this.headTraversal = this.sstf.headPosition + " ";
	}

	public void run() {
		try {
			while (!sstf.over) {
				Thread.currentThread().sleep(2500);
				while (trackNumbers.size() != 0) {
					System.out.println("Track Queue: " + trackNumbers);
					int moveToTrack = sstf.calculateMinimumSeekTime();
					System.out.println("Header movement: " + sstf.headPosition + " -> " + moveToTrack);
					sstf.totalHeadMovement += Math.abs(sstf.headPosition - moveToTrack);
					headTraversal += "->" + moveToTrack + " ";
					int seekTime = (Math.abs(sstf.headPosition - moveToTrack));
					System.out.println(headTraversal + "\tSeek Time needed: " + seekTime + "\n");
					sstf.headPosition = moveToTrack;
					Thread.currentThread().sleep(seekTime * 80);
				}
			}
			System.out.println("Total head movement to serve all requests: " + sstf.totalHeadMovement);
			System.out.printf("Time required to serve all requests: %.2f",
					(double) (sstf.totalHeadMovement * unitSeek));
			System.out.println(" millisecs");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
