import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<Vertige> vtgs = new Vector<>();
        Vector<Bridge> bdgs = new Vector<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("Donner le nombre de vertiges : ");
        int n = scn.nextInt();
        Vertige v;
        String nm;
        for(int i = 0 ; i<n;i++){
            System.out.println("donner le nom du vertige num "+(i+1)+" : ");
            nm = scn.next();
            v = new Vertige(nm);
            vtgs.add(v);
        }
        System.out.println("donner le nombres de ponts : ");
        int ponts = scn.nextInt();
         Vertige v1 = new Vertige("vide");
         v = new Vertige("vide");
         Bridge b;
        String nm2, nm3 = "";
        for(int i = 0; i<ponts;i++){
            System.out.println("pont "+(i+1)+" : ");
            System.out.println("donner le nom du premiere vertige reliée : ");
            nm2 = "";
            nm3 = "";
            nm2 = scn.next();
            for(int j = 0 ;j<n;j++){
                if (vtgs.elementAt(j).nom.equals(nm2)){
                    v =  new Vertige(vtgs.elementAt(j));
                    vtgs.elementAt(j).path++;

                }
            }
            System.out.println("donner le nom du deuxieme vertige reliée : ");
            do{
                nm3 = scn.next();
            }while(nm3.equals(nm2));
            for(int j = 0 ;j<n;j++){
                if (vtgs.elementAt(j).nom.equals(nm3)){
                    v1 = new Vertige(vtgs.elementAt(j));
                    vtgs.elementAt(j).path++;
                }
            }
                b = new Bridge(v,v1);
            bdgs.add(b);
        }




    /*for(int i = 0 ; i<n; i++){
        System.out.println(vtgs.elementAt(i).nom+ " : " +vtgs.elementAt(i).path);
        }*/
        boolean works = true;

            for(int j = 0 ; j<n; j++){
                if(vtgs.elementAt(1).path!=vtgs.elementAt(j).path)works=false;
                  }
                  if(!works){
                      int t[][] = new int[2][n];
                      for(int i = 0 ; i<n; i++){
                        t[0][i] = vtgs.elementAt(i).path;
                        t[1][i]=0;
                      }
                      for(int i = 0 ; i<n; i++){
                          for(int j = 0 ; j<n; j++){
                              if(t[0][i]==t[0][j])t[1][i]++;
                          }
                      }
                      int k = dup.supprimer_dup(t[1],n);

                      for(int i = 0; i<k;i++){
                        if(t[1][i]==2)works=true;
                      }

                  }
                  if(works){
                      System.out.println("Chemin Trouvé");
                  }else{
                      System.out.println("Chemin Non Trouvé");
                      System.out.println("voulez vous ajouter ou supprimer un pont? A/S");
                      String choix = scn.next();
                  if(choix.equals("A") || choix.equals("a")){
                      ponts++;
                      System.out.println("pont "+(ponts)+" : ");
                      System.out.println("donner le nom du premiere vertige reliée : ");
                      nm2 = "";
                      nm3 = "";
                      nm2 = scn.next();
                      for(int j = 0 ;j<n;j++){
                          if (vtgs.elementAt(j).nom.equals(nm2)){
                              v =  new Vertige(vtgs.elementAt(j));
                              vtgs.elementAt(j).path++;

                          }
                      }
                      System.out.println("donner le nom du deuxieme vertige reliée : ");
                      do{
                          nm3 = scn.next();
                      }while(nm3.equals(nm2));
                      for(int j = 0 ;j<n;j++){
                          if (vtgs.elementAt(j).nom.equals(nm3)){
                              v1 = new Vertige(vtgs.elementAt(j));
                              vtgs.elementAt(j).path++;
                          }
                      }
                      b = new Bridge(v,v1);
                      bdgs.add(b);
                  }else if(choix.equals("s") || choix.equals("S")){
                      System.out.println("donner les vertiges qui se relient par le pont : ");
                      String p1 = scn.next();
                      String p2 = scn.next();
                      for(int m = 0;m<ponts;m++){
                          if(bdgs.elementAt(m).v1.nom.equals(p1) && bdgs.elementAt(m).v2.nom.equals(p2)){
                              bdgs.remove(m);break;
                          }
                      }
                      for(int q = 0; q<n;q++){
                          if(vtgs.elementAt(q).nom.equals(p1) || vtgs.elementAt(q).nom.equals(p2))vtgs.elementAt(q).path--;
                      }
                      ponts--;
                  }
                      works = true;

                      for(int j = 0 ; j<n; j++){
                          if(vtgs.elementAt(1).path!=vtgs.elementAt(j).path)works=false;
                      }
                      if(!works){
                          int t[][] = new int[2][n];
                          for(int i = 0 ; i<n; i++){
                              t[0][i] = vtgs.elementAt(i).path;
                              t[1][i]=0;
                          }
                          for(int i = 0 ; i<n; i++){
                              for(int j = 0 ; j<n; j++){
                                  if(t[0][i]==t[0][j])t[1][i]++;
                              }
                          }
                          int k = dup.supprimer_dup(t[1],n);

                          for(int i = 0; i<k;i++){
                              if(t[1][i]==2)works=true;
                          }

                      }
                      if(works){
                          System.out.println("Chemin Trouvé!!!");
                      }else{
                          System.out.println("Chemin Non Trouvé!");                      }
                        }


    }
}
