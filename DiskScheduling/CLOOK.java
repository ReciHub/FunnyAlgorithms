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

public class CLOOK implements Global {
    int headPosition = r.nextInt((int) (totalTracks / 2));
    int totalHeadMovement = 0;
    boolean over = false;
    String direction = "";
    boolean dontIncludeSeek = false;
    static CLOOK clook;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nCLOOK Disk Scheduling");
        clook = new CLOOK();
        clook.direction = "right";

        Thread.currentThread().sleep(500);
        System.out.println("Total number of tracks on the disk are: " + totalTracks);
        System.out.println("Current Header Position is: " + clook.headPosition);
        System.out.println("Total number of Disk requests =  " + n);
        System.out.println("CLOOK direction: '" + clook.direction.toUpperCase() + "'\n");
        Output output = new Output(clook);
        output.setName("Output Thread");
        ForLoop forloop = new ForLoop(clook);
        forloop.setName("ForLoop Thread");
        forloop.start();
        output.start();
    }

    public int[] findNextTrackOnPath() {
        int arr[] = new int[2];
        if (served.size() == 0) {
            arr[0] = -1;
            arr[1] = notServed.firstElement();
            clook.dontIncludeSeek = true;
            return arr;
        }
        int new_track = clook.headPosition;
        int minimum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < served.size(); i++) {
            if (Math.abs(served.get(i) - clook.headPosition) < minimum) {
                minimum = Math.abs(served.get(i) - clook.headPosition);
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
            int my_move = trackNumbers.get(i) - clook.headPosition;
            if (my_move < 0) {
                if (clook.direction.equals("right"))
                    notServed.add(trackNumbers.get(i));
                else
                    served.add(trackNumbers.get(i));
            }
            if (my_move > 0) {
                if (clook.direction.equals("right"))
                    served.add(trackNumbers.get(i));
                else
                    notServed.add(trackNumbers.get(i));
            }
        }
        int arr[] = findNextTrackOnPath();
        System.out.println("Will be served in this CLOOK: " + served);
        System.out.println("Will not served in this CLOOK: " + notServed);
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
    CLOOK clook;

    public ForLoop(CLOOK clook) {
        this.clook = clook;
    }

    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                Thread.currentThread().sleep(1000);
                trackNo = r.nextInt(totalTracks);
                if (trackNo == clook.headPosition || trackNumbers.contains(trackNo))
                    i--;
                else
                    trackNumbers.add(trackNo);
            }
            clook.over = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Output extends Thread implements Global {
    String headTraversal = "";
    CLOOK clook;

    public Output(CLOOK clook) {
        this.clook = clook;
        this.headTraversal = this.clook.headPosition + " ";
    }

    public void run() {
        try {
            int seekTime = 0;
            while (!clook.over) {
                Thread.currentThread().sleep(2500);
                while (trackNumbers.size() != 0) {
                    int moveToTrack = clook.getNextToServe();
                    System.out.println("Header movement: " + clook.headPosition + " -> " + moveToTrack);
                    headTraversal += "-> " + moveToTrack + " ";
                    seekTime = (Math.abs(clook.headPosition - moveToTrack));
                    System.out.printf(headTraversal + "");
                    if (!clook.dontIncludeSeek) {
                        clook.totalHeadMovement += seekTime;
                        System.out.println("\t\tSeek Time needed: " + seekTime);
                    }
                    System.out.println();
                    clook.headPosition = moveToTrack;
                    if (!clook.dontIncludeSeek) {
                        clook.dontIncludeSeek = false;
                        Thread.currentThread().sleep(seekTime * 80);
                    }
                }
            }
            System.out.println("\n" + headTraversal);
            System.out.println("Total head movement to serve all requests: " + clook.totalHeadMovement);
            System.out.printf("Time required to serve all requests: %.2f",
                    (double) (clook.totalHeadMovement * unitSeek));
            System.out.println(" millisecs");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
