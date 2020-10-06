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

public class SCAN implements Global {
    int headPosition = r.nextInt((int) (totalTracks / 2));
    int totalHeadMovement = 0;
    boolean over = false;
    String direction = "";
    static SCAN scan;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nSCAN Disk Scheduling");
        scan = new SCAN();
        int lol = r.nextInt(2);
        if (lol == 0)
            scan.direction = "left";
        else
            scan.direction = "right";

        Thread.currentThread().sleep(500);
        System.out.println("Total number of tracks on the disk are: " + totalTracks);
        System.out.println("Current Header Position is: " + scan.headPosition);
        System.out.println("Total number of Disk requests =  " + n + "\n");
        Output output = new Output(scan);
        output.setName("Output Thread");
        ForLoop forloop = new ForLoop(scan);
        forloop.setName("ForLoop Thread");
        forloop.start();
        output.start();
    }

    public int[] findNextTrackOnPath() {
        int arr[] = new int[2];
        if (served.size() == 0) {
            if (scan.direction.equals("left")) {
                scan.direction = "right";
                arr[0] = -1;
                arr[1] = 0;
                return arr;
            } else if (scan.direction.equals("right")) {
                scan.direction = "left";
                arr[0] = -1;
                arr[1] = totalTracks;
                return arr;
            }
        }
        int new_track = scan.headPosition;
        int minimum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < served.size(); i++) {
            if (Math.abs(served.get(i) - scan.headPosition) < minimum) {
                minimum = Math.abs(served.get(i) - scan.headPosition);
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
        System.out.printf("Track Queue: " + trackNumbers);
        System.out.println("\t\tSCAN direction: '" + scan.direction.toUpperCase() + "'");
        for (int i = 0; i < trackNumbers.size(); i++) {
            int my_move = trackNumbers.get(i) - scan.headPosition;
            if (my_move < 0) {
                if (scan.direction.equals("right"))
                    notServed.add(trackNumbers.get(i));
                else if (scan.direction.equals("left"))
                    served.add(trackNumbers.get(i));
            }
            if (my_move > 0) {
                if (scan.direction.equals("right"))
                    served.add(trackNumbers.get(i));
                else if (scan.direction.equals("left"))
                    notServed.add(trackNumbers.get(i));
            }
        }
        int arr[] = findNextTrackOnPath();
        System.out.println("Will be served in this SCAN: " + served);
        System.out.println("Will not served in this SCAN: " + notServed);
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
    SCAN scan;

    public ForLoop(SCAN scan) {
        this.scan = scan;
    }

    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                Thread.currentThread().sleep(1000);
                trackNo = r.nextInt(totalTracks);
                if (trackNo == scan.headPosition || trackNumbers.contains(trackNo))
                    i--;
                else
                    trackNumbers.add(trackNo);
            }
            scan.over = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Output extends Thread implements Global {
    String headTraversal = "";
    SCAN scan;

    public Output(SCAN scan) {
        this.scan = scan;
        this.headTraversal = this.scan.headPosition + " ";
    }

    public void run() {
        try {
            while (!scan.over) {
                Thread.currentThread().sleep(2500);
                while (trackNumbers.size() != 0) {
                    int moveToTrack = scan.getNextToServe();
                    System.out.println("Header movement: " + scan.headPosition + " -> " + moveToTrack);
                    scan.totalHeadMovement += Math.abs(scan.headPosition - moveToTrack);
                    headTraversal += "->" + moveToTrack + " ";
                    int seekTime = (Math.abs(scan.headPosition - moveToTrack));
                    System.out.println(headTraversal + "\t\tSeek Time needed: " + seekTime + "\n");
                    scan.headPosition = moveToTrack;
                    Thread.currentThread().sleep(seekTime * 75);
                }
            }
            System.out.println("Total head movement to serve all requests: " + scan.totalHeadMovement);
            System.out.printf("Time required to serve all requests: %.2f",
                    (double) (scan.totalHeadMovement * unitSeek));
            System.out.println(" millisecs");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
