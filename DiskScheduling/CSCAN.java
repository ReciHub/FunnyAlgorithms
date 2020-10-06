import java.util.*;
import java.io.*;

interface Global {
    Random r = new Random();
    int random = r.nextInt(200);
    final static int totalTracks = (random) - (random % 10);
    final static int n = r.nextInt(15) + 5;
    final static double unitSeek = 0.1;
    static Vector<Integer> copyTrackNumbers = new Vector<Integer>();
    static Vector<Integer> trackNumbers = new Vector<Integer>();
    static Vector<Integer> served = new Vector<Integer>();
    static Vector<Integer> notServed = new Vector<Integer>();
}

public class CSCAN implements Global {
    int headPosition = r.nextInt((int) (totalTracks / 2));
    int totalHeadMovement = 0;
    boolean over = false;
    String direction = "";
    boolean dontIncludeSeek = false;
    static CSCAN cscan;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nCSCAN Disk Scheduling");
        cscan = new CSCAN();
        cscan.direction = "right";

        Thread.currentThread().sleep(500);
        System.out.println("Total number of tracks on the disk are: " + totalTracks);
        System.out.println("Current Header Position is: " + cscan.headPosition);
        System.out.println("Total number of Disk requests =  " + n);
        System.out.println("CSCAN direction: '" + cscan.direction.toUpperCase() + "'\n");
        Output output = new Output(cscan);
        output.setName("Output Thread");
        ForLoop forloop = new ForLoop(cscan);
        forloop.setName("ForLoop Thread");
        forloop.start();
        output.start();
    }

    public int[] findNextTrackOnPath() {
        int arr[] = new int[2];
        if (headPosition == totalTracks) {
            arr[0] = -1;
            arr[1] = 0;
            cscan.dontIncludeSeek = true;
            return arr;
        }
        if (served.size() == 0) {
            arr[0] = -1;
            arr[1] = totalTracks;
            return arr;
        }
        int new_track = cscan.headPosition;
        int minimum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < served.size(); i++) {
            if (Math.abs(served.get(i) - cscan.headPosition) < minimum) {
                minimum = Math.abs(served.get(i) - cscan.headPosition);
                new_track = served.get(i);
                index = i;
            }
        }
        arr[0] = index;
        arr[1] = new_track;
        return arr;
    }

    public int getNextToServe() {
        int index = 0;
        served.clear();
        notServed.clear();
        System.out.println("\nTrack Queue: " + trackNumbers);
        for (int i = 0; i < trackNumbers.size(); i++) {
            int my_move = trackNumbers.get(i) - cscan.headPosition;
            if (my_move < 0) {
                if (cscan.direction.equals("right"))
                    notServed.add(trackNumbers.get(i));
                else
                    served.add(trackNumbers.get(i));
            }
            if (my_move > 0) {
                if (cscan.direction.equals("right"))
                    served.add(trackNumbers.get(i));
                else
                    notServed.add(trackNumbers.get(i));
            }
        }
        int arr[] = findNextTrackOnPath();
        System.out.println("Will be served in this CSCAN: " + served);
        System.out.println("Will not served in this CSCAN: " + notServed);
        if (arr[0] != -1)
            served.remove(arr[0]);
        if (trackNumbers.contains(arr[1])) {
            index = trackNumbers.indexOf(arr[1]);
            trackNumbers.remove(index);
        }
        return arr[1];
    }
}

class ForLoop extends Thread implements Global {
    static int trackNo = 0;
    CSCAN cscan;

    public ForLoop(CSCAN cscan) {
        this.cscan = cscan;
    }

    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                Thread.currentThread().sleep(1000);
                trackNo = r.nextInt(totalTracks);
                if (trackNo == cscan.headPosition || trackNumbers.contains(trackNo))
                    i--;
                else
                    trackNumbers.add(trackNo);
            }
            cscan.over = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Output extends Thread implements Global {
    String headTraversal = "";
    CSCAN cscan;

    public Output(CSCAN cscan) {
        this.cscan = cscan;
        this.headTraversal = this.cscan.headPosition + " ";
    }

    public void run() {
        try {
            int seekTime = 0;
            while (!cscan.over) {
                Thread.currentThread().sleep(2500);
                while (trackNumbers.size() != 0) {
                    int moveToTrack = cscan.getNextToServe();
                    System.out.println("Header movement: " + cscan.headPosition + " -> " + moveToTrack);
                    headTraversal += "-> " + moveToTrack + " ";
                    seekTime = (Math.abs(cscan.headPosition - moveToTrack));
                    System.out.printf(headTraversal + "");
                    if (!cscan.dontIncludeSeek) {
                        cscan.totalHeadMovement += seekTime;
                        System.out.println("\t\tSeek Time needed: " + seekTime);
                    }
                    System.out.println();
                    cscan.headPosition = moveToTrack;
                    if (!cscan.dontIncludeSeek) {
                        cscan.dontIncludeSeek = false;
                        Thread.currentThread().sleep(seekTime * 75);
                    }
                }
            }
			headTraversal += "-> " + totalTracks+" "; 
            seekTime = Math.abs(cscan.headPosition - totalTracks);
            cscan.totalHeadMovement += seekTime;
			System.out.println("\n" + headTraversal + "\t\tSeek Time needed: " + seekTime + "\n\n");
			headTraversal+= "-> 0";
            System.out.println(headTraversal+"\n");
            System.out.println("Total head movement to serve all requests: " + cscan.totalHeadMovement);
            System.out.printf("Time required to serve all requests: %.2f",
                    (double) (cscan.totalHeadMovement * unitSeek));
            System.out.println(" millisecs");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
