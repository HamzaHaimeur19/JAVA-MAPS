import java.util.*;

public class TreeMapEtudiant {

    public static SortedMap<String, Etudiant> CinTreeMap = new TreeMap<>();

    public static void remplirTree() {
        CinTreeMap.put("CZAZZA", new Etudiant("Jamal", "Salim", 3311, "CZAZZA"));
        CinTreeMap.put("AZAZZA", new Etudiant("Haimeur", "Hamza", 32323, "AZAZZA"));
        CinTreeMap.put("EZAEZE", new Etudiant("Hamid", "Kamal", 4342, "EZAEZE"));
        CinTreeMap.put("YYRTR", new Etudiant("Yassine", "Farouq", 4324221, "YYRTR"));
    }

    public static Etudiant premierEtudiant() {
        String fkey = CinTreeMap.firstKey();
        return CinTreeMap.get(fkey);

    }

    public static Etudiant dernierEtudiant() {
        String lkey = CinTreeMap.lastKey();
        return CinTreeMap.get(lkey);

    }

    public static void EtudiantTriesParCin() {
        for (Map.Entry<String, Etudiant> entry : CinTreeMap.entrySet()) {
            String CIN = entry.getKey();
            Etudiant e = entry.getValue();

            System.out.println("Cin etudiant " + CIN + " etudiant est " + e.getPrenom() + " " + e.getNom());

        }
    }

    public static ArrayList<Etudiant> Etudiants(String cin1, String cin2) {
        if (cin1 != null && cin2 != null && cin1.compareTo(cin2) < 0) {
            return new ArrayList<Etudiant>(CinTreeMap.subMap(cin1, cin2).values());

        } else {
            throw new IllegalArgumentException("verifier les parametres");
        }
    }

    public static SortedMap<String, Etudiant> supOuEgal(String cin) {

        return CinTreeMap.tailMap(cin);

    }

    public static SortedMap<String, Etudiant> inf(String cin) {
        return CinTreeMap.tailMap(cin);

    }

    public static Boolean comparateurU() {
        Comparator comparateur = CinTreeMap.comparator();

        return comparateur == null;
    }


    public static TreeMap<Integer, Etudiant> smap2 = new TreeMap<>();

    public static void alimenterMap2() {
        CinTreeMap.values().forEach(emp -> smap2.put(emp.getCNE(), emp));
        // on alimente le SortedMap par clé de CNE

    }

    public static void afficherMap2() {
        for (Map.Entry<Integer, Etudiant> entry : smap2.entrySet()) {
            Integer CNE = entry.getKey();
            Etudiant e = entry.getValue();

            System.out.println(CNE + " => " + e.getPrenom() + " " + e.getNom());
        }

    }

    public static String trouverCinEtudiant(Etudiant e) {
        for (Map.Entry<String, Etudiant> entry : CinTreeMap.entrySet()) {
            if (entry.getValue().equals(e)) {
                return entry.getKey();
            }
        }
        return null;

    }

    public static void ajouterEtudiant(Etudiant e) {
        smap2.put(e.getCNE(), e);

    }

    public static Etudiant supprimerEtudiant(Integer cne) {
        return smap2.remove(cne);

    }

    public static void joindreMap() {
        SortedMap<Integer, Etudiant> smap3 = new TreeMap<>();

        smap3.putAll(smap2);
    }

    public static void main(String[] args) {
        remplirTree();
        //System.out.println(premierEtudiant());
        //dernierEtudiant();
        //EtudiantTriesParCin();
        //System.out.println(Etudiants("AZAZZA", "EZAEZE"));
        //System.out.println(supOuEgal("EZAEZE"));
        //ajouterEtudiant("feffd", new Etudiant("hamza", "haimeur", 8391, "feffd"));
        afficherMap2();
        System.out.println(comparateurU());
        alimenterMap2();
        afficherMap2();


    }
}
