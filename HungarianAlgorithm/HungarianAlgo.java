/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class ZeroCellComparator implements Comparator<Map.Entry<Integer,ArrayList<Integer>>> {
    @Override
    public int compare(Map.Entry<Integer,ArrayList<Integer>> entry1, Map.Entry<Integer,ArrayList<Integer>> entry2){
        return Integer.compare(entry1.getValue().size(), entry2.getValue().size());
    }
}
class Pair{
    int x,y;
    Pair(int i,int j){
        x=i;
        y=j;
    }
    Pair(){}
    @Override
    public boolean equals(Object o){
        Pair p2=(Pair)o;
        if(this.x==p2.x && this.y==p2.y){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (this.x*1000+this.y);
    }
}
class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int[][] timeTaken=new int[n][n];
            int i,j;
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    timeTaken[i][j]=sc.nextInt();
                }
            }
            int minTimeTaken=getMinTime(timeTaken,n);
            System.out.println(minTimeTaken);
            t--;
        }
    }
    private static int getMinTime(int[][] timeTaken1, int n){
        int[][] timeTaken=new int[n][n];
        int i,j,k;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                timeTaken[i][j]=timeTaken1[i][j];
            }
        }
        int min;
        HashMap<Integer,ArrayList<Integer>> zeroCell=new HashMap<Integer,ArrayList<Integer>>();
        HashSet<Integer> jobsAssigned=new HashSet<Integer>();
        ArrayList<Pair> cellsCovered=new ArrayList<Pair>();
        HashSet<Integer> columnsCovered=new HashSet<Integer>();
        //sub min row wise
        for(i=0;i<n;i++){
            min=Integer.MAX_VALUE;
            for(j=0;j<n;j++){
                if(timeTaken[i][j]<min){
                    min=timeTaken[i][j];
                }
            }
            if(min==0){
                continue;
            }
            for(j=0;j<n;j++){
                timeTaken[i][j]-=min;
                if(timeTaken[i][j]==0){
                    Pair p=new Pair(i,j);
                    cellsCovered.add(p);
                    if(zeroCell.containsKey(i)){
                        ArrayList<Integer> colList=zeroCell.get(i);
                        colList.add(i);
                        zeroCell.put(i,colList);
                    }else{
                        ArrayList<Integer> columnList=new ArrayList<Integer>();
                        columnList.add(j);
                        zeroCell.put(i,columnList);
                    }
                }
            }
        }
        //sub min column wise
        for(j=0;j<n;j++){
            min=Integer.MAX_VALUE;
            for(i=0;i<n;i++){
                if(timeTaken[i][j]<min){
                    min=timeTaken[i][j];
                }
            }
            if(min==0){
                continue;
            }
            for(i=0;i<n;i++){
                timeTaken[i][j]-=min;
                if(timeTaken[i][j]==0){
                    Pair p=new Pair(i,j);
                    cellsCovered.add(p);
                    if(zeroCell.containsKey(i)){
                        ArrayList<Integer> colList=zeroCell.get(i);
                        colList.add(i);
                        zeroCell.put(i,colList);
                    }else{
                        ArrayList<Integer> columnList=new ArrayList<Integer>();
                        columnList.add(j);
                        zeroCell.put(i,columnList);
                    }
                }
            }
        }

        HashSet<Integer> rowsCovered=new HashSet<Integer>();

        //count the number of lines required to cover all zeros
        while(true){
            rowsCovered=new HashSet<Integer>();
            columnsCovered=new HashSet<>();
            int numOfLines=getNumOfLines(n,cellsCovered, columnsCovered, rowsCovered);
           if(numOfLines==n){
                break;
            }
            min=Integer.MAX_VALUE;
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(!cellsCovered.contains(new Pair(i,j))){
                        if(timeTaken[i][j]<min){
                            min=timeTaken[i][j];
                        }
                    }
                }
            }
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    if(!rowsCovered.contains(i)){
                        timeTaken[i][j]-=min;
                        if(timeTaken[i][j]==0){
                            cellsCovered.add(new Pair(i,j));
                            if(zeroCell.containsKey(i)){
                                ArrayList<Integer> colList=zeroCell.get(i);
                                colList.add(i);
                                zeroCell.put(i,colList);
                            }else{
                                ArrayList<Integer> columnList=new ArrayList<Integer>();
                                columnList.add(j);
                                zeroCell.put(i,columnList);
                            }
                        }
                    }
                    if(columnsCovered.contains(j)){
                        if(timeTaken[i][j]==0){
                            cellsCovered.remove(new Pair(i,j));
                            if(zeroCell.containsKey(i)){
                                ArrayList<Integer> columns=zeroCell.get(i);
                                columns.remove(new Integer(i));
                                if(columns.size()==0){
                                    zeroCell.remove(i);
                                }else{
                                    zeroCell.put(i,columns);
                                }
                            }else{
                                ArrayList<Integer> columnList=new ArrayList<Integer>();
                                columnList.add(j);
                                zeroCell.put(i,columnList);
                            }
                        }
                        timeTaken[i][j]+=min;
                    }
                }
            }
        }
        int minTimeTaken=0;
        minTimeTaken=getMinTimeUtil(timeTaken1,timeTaken,n,rowsCovered, columnsCovered);
        return minTimeTaken;
    }

    private static int getNumOfLines(int n,ArrayList<Pair> cellsCovered, HashSet<Integer> columnsCovered, HashSet<Integer> rowsCovered) {
        int numOfLines=0;
        boolean[] linePassingThroughRow=new boolean[n];
        boolean[] linePassingThroughCol=new boolean[n];
        int i;
        for(i=0;i<n;i++){
            linePassingThroughCol[i]=false;
            linePassingThroughRow[i]=false;
        }
        HashSet<Integer> rowSeen=new HashSet<>();
        HashSet<Integer> colSeen=new HashSet<>();
        for(i=0;i<cellsCovered.size();i++){
            if(rowSeen.contains(cellsCovered.get(i).x)){
                linePassingThroughRow[cellsCovered.get(i).x]=true;
            }else if(colSeen.contains(cellsCovered.get(i).y)){
                linePassingThroughCol[cellsCovered.get(i).y]=true;
            }else{
                rowSeen.add(cellsCovered.get(i).x);
                colSeen.add(cellsCovered.get(i).y);
            }
        }
        for(i=0;i<cellsCovered.size();i++){
            if(linePassingThroughRow[cellsCovered.get(i).x]==false&&linePassingThroughCol[cellsCovered.get(i).y]==false){
                linePassingThroughRow[cellsCovered.get(i).x]=true;
            }
        }
        for(i=0;i<n;i++){
            if(linePassingThroughCol[i]==true){
                columnsCovered.add(i);
                numOfLines++;
            }
            if(linePassingThroughRow[i]==true){
                rowsCovered.add(i);
                numOfLines++;
            }
        }
        return numOfLines;
    }

    private static int getMinTimeUtil(int[][] timeTaken, int[][] hungarianMatrix,int n,HashSet<Integer> rowsCovered, HashSet<Integer> columnsCovered){
        boolean[] personGotJob=new boolean[n];
        boolean[] jobAssigned=new boolean[n];
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                personGotJob[i]=false;
                jobAssigned[i]=false;
            }
        }
        int time=0;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(hungarianMatrix[i][j]==0) {
                    if (rowsCovered.contains(i) && columnsCovered.contains(j)) {
                        rowsCovered.remove(i);
                    } else {
                        if(personGotJob[i]==false&&jobAssigned[j]==false) {
                            time += timeTaken[i][j];
                            personGotJob[i]=true;
                            jobAssigned[j]=true;
                        }
                        if (rowsCovered.contains(i)) {
                            rowsCovered.remove(i);
                        } else if (columnsCovered.contains(j)) {
                            columnsCovered.remove(j);
                        }
                    }
                }
            }
        }
        return time;
    }
}