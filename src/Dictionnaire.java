public class Dictionnaire {
    private int nb_mots ;
    Mot_dict Dict [] ;
    private String Nom ;

    public Dictionnaire(int n, String nom){
        this.nb_mots = 0;
        this.Nom = nom;
        Dict = new Mot_dict[n];
    }
    public Dictionnaire(int n){
        this.nb_mots= 0;
        Dict = new Mot_dict[n];
    }
    public Dictionnaire(String nom){
        this.Nom = nom;
    }
    void Ajouter_Mot(Mot_dict mot){
        if (nb_mots<Dict.length){
            Dict[nb_mots]=mot;
            nb_mots++;
            Trier();
        }
        else {
            System.out.println("tu as depasser le limite");
        }
    }
    void Trier(){
        for(int i=1; i<this.nb_mots; i++){
            Mot_dict ch=Dict[i];
            int j=i-1;
            while(j>=0 && Dict[j]!=null &&  Dict[j].getMot().compareTo(ch.getMot())>0){
                Dict[j+1]=Dict[j];
                j--;
            }
            Dict[j+1]=ch;
        }
    }
    void supprimer_mot(Mot_dict mot) {
        boolean test = false;
        int i=0;
        while (test == false && i<nb_mots-1 ) {
            if (Dict[i]!= null && Dict[i].getMot().compareTo(mot.getMot())==0) {
                test = true;
            }
            else {
                i++;
            }
        }
        if (test == true) {
            for (int j=i; j<nb_mots-1;j++) {
                Dict[j]=Dict[j+1];
            }
            Dict[nb_mots - 1] = null;
            nb_mots--;
        }
        else {
            System.out.println("Dict est Trier");
        }
    }
    public String Recherche_dicho(String m){
        int x = 0;
        int y = nb_mots -1;
        while(x <= y){
            int milieu = x + (y - x)/2;
            Mot_dict mot=Dict[milieu];
            int compar = mot.getMot().compareTo(m);
            if(compar == 0){
                return mot.getDefinition();
            } else if (compar > 0) {
                y = milieu-1;
            }
            else{
                x = milieu+1;
            }
        }
        return "Mot non trouvé";
    }
    void Liter_dictionnair(){
        for(int i = 0; i<nb_mots; i++){
            if(Dict[i]!=null) {
                Mot_dict mot = Dict[i];
                System.out.println(mot.getMot() + "|" + mot.getDefinition());
            }
        }
    }
    int Nombre_synonyme(Mot_dict m){
        int nb =0;
        for(int i = 0; i<nb_mots; i++){
            if(m.synonyme(Dict[i])){
                nb++;
            }
        }
        return nb;
    }
}
