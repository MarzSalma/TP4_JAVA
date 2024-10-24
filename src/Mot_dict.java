public class Mot_dict {
    private String Mot;
    private String Definition;

    String getMot(){
        return Mot;
    }
    String getDefinition(){
        return Definition;
    }
    void setDefinition(String def ){
        this.Definition = def;
    }
    void setMot(String m){
        this.Mot = m;
    }
    boolean synonyme(Mot_dict dict){
        if (this.Definition.equals(dict.Definition)){
            return true;
        }else
        { return false;
        }
    }
    public Mot_dict(String m, String def){
        this.Mot=m;
        this.Definition=def;
    }
    public static void main(String args[]){
        Mot_dict m1=new Mot_dict("apple","marque");
        Mot_dict m2=new Mot_dict("francais", "langue");
        Mot_dict m3=new Mot_dict("redmi","marque");
        Dictionnaire d=new Dictionnaire(5,"reverso");

        d.Ajouter_Mot(m1);
        d.Ajouter_Mot(m2);
        d.Ajouter_Mot(m3);
        d.Liter_dictionnair();
        System.out.println(m1.synonyme(m3));
        System.out.println(m1.synonyme(m2));
        d.Trier();
        d.supprimer_mot(m2);
        d.Liter_dictionnair();
    }
}

