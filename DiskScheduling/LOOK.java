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

public class LOOK implements Global {
    int headPosition = r.nextInt((int) (totalTracks / 2));
    int totalHeadMovement = 0;
    boolean over = false;
    String direction = "";
    static LOOK look;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nLOOK Disk Scheduling");
        look = new LOOK();
        int lol = r.nextInt(2);
        if (lol == 0)
            look.direction = "left";
        else
            look.direction = "right";

        Thread.currentThread().sleep(500);
        System.out.println("Total number of tracks on the disk are: " + totalTracks);
        System.out.println("Current Header Position is: " + look.headPosition);
        System.out.println("Total number of Disk requests =  " + n + "\n");
        Output output = new Output(look);
        output.setName("Output Thread");
        ForLoop forloop = new ForLoop(look);
        forloop.setName("ForLoop Thread");
        forloop.start();
        output.start();
    }

    public int[] findNextTrackOnPath() {
        int arr[] = new int[2];
        if (served.size() == 0) {
            if (look.direction.equals("left")) {
                look.direction = "right";
                arr[0] = -1;
                arr[1] = headPosition;
                return arr;
            } else if (look.direction.equals("right")) {
                look.direction = "left";
                arr[0] = -1;
                arr[1] = headPosition;
                return arr;
            }
        }
        int new_track = look.headPosition;
        int minimum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < served.size(); i++) {
            if (Math.abs(served.get(i) - look.headPosition) < minimum) {
                minimum = Math.abs(served.get(i) - look.headPosition);
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
        for (int i = 0; i < trackNumbers.size(); i++) {
            int my_move = trackNumbers.get(i) - look.headPosition;
            if (my_move < 0) {
                if (look.direction.equals("right"))
                    notServed.add(trackNumbers.get(i));
                else if (look.direction.equals("left"))
                    served.add(trackNumbers.get(i));
            }
            if (my_move > 0) {
                if (look.direction.equals("right"))
                    served.add(trackNumbers.get(i));
                else if (look.direction.equals("left"))
                    notServed.add(trackNumbers.get(i));
            }
        }
        int arr[] = findNextTrackOnPath();

        System.out.println("Track Queue: " + trackNumbers);
        System.out.println("LOOK direction: '" + look.direction.toUpperCase() + "'");
        System.out.println("Will be served in this LOOK: " + served);
        System.out.println("Will not served in this LOOK: " + notServed);
        if (arr[0] != -1) {
            served.remove(arr[0]);
        }
        if (trackNumbers.contains(arr[1])) {
            index = trackNumbers.indexOf(arr[1]);
            trackNumbers.remove(index);
        }
        return arr[1];
    }
}

class ForLoop extends Thread implements Global {
    static int trackNo = 0;
    LOOK look;

    public ForLoop(LOOK look) {
        this.look = look;
    }

    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                Thread.currentThread().sleep(1000);
                trackNo = r.nextInt(totalTracks);
                if (trackNo == look.headPosition || trackNumbers.contains(trackNo))
                    i--;
                else
                    trackNumbers.add(trackNo);
            }
            look.over = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Output extends Thread implements Global {
    String headTraversal = "";
    LOOK look;

    public Output(LOOK look) {
        this.look = look;
        this.headTraversal = this.look.headPosition + " ";
    }

    public void run() {
        try {
            while (!look.over) {
                Thread.currentThread().sleep(2500);
                while (trackNumbers.size() != 0) {
                    int moveToTrack = look.getNextToServe();
                    if (look.headPosition != moveToTrack) {
                        System.out.println("Header movement: " + look.headPosition + " -> " + moveToTrack);
                        look.totalHeadMovement += Math.abs(look.headPosition - moveToTrack);
                        headTraversal += "->" + moveToTrack + " ";
                        int seekTime = (Math.abs(look.headPosition - moveToTrack));
                        System.out.println(headTraversal + "\t\tSeek Time needed: " + seekTime + "\n");
                        look.headPosition = moveToTrack;
                        Thread.currentThread().sleep(seekTime * 75);
                    }
                }
            }
            System.out.println("Total head movement to serve all requests: " + look.totalHeadMovement);
            System.out.printf("Time required to serve all requests: %.2f",
                    (double) (look.totalHeadMovement * unitSeek));
            System.out.println(" millisecs");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
