public class Vertige {
    public String nom;
    int path=0;
    public Vertige(String nom){
        this.nom = nom;


    }
    public Vertige(Vertige v){
        this.nom = v.nom;
        this.path = v.path;
    }
}
