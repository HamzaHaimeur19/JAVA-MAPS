import java.security.Key;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEtudiant {

    public static Map<String, Etudiant> MapEtu = new HashMap<>();

    public static void alimenterListe() {
        MapEtu.put("ZAZAZAD", new Etudiant("dnsd", "dsdsd", 323, "ZAZAZAD"));
        MapEtu.put("dfdlfksfs", new Etudiant("rre", "vvcv", 54545, "dfdlfksfs"));
        MapEtu.put("KLEKRER", new Etudiant("YYYTR", "JHJHJ", 65465, "KLEKRER"));

    }

    public static boolean chercherEtudiant(Etudiant e) {
        return MapEtu.containsValue(e);

    }

    public static boolean CINExiste(String cin) {
        return MapEtu.containsKey(cin);

    }

    public static void AfficherMap() {
        //Set<Map.Entry<String, Etudiant>> entries = MapEtu.entrySet();

        for (Map.Entry<String, Etudiant> entry : MapEtu.entrySet()) {
            String CIN = entry.getKey();
            Etudiant e = entry.getValue();

            System.out.println(CIN + " => " + e.getNom() + " " + e.getPrenom() + " " + e.getCNE());
        }

    }

    public static void AfficherEtudiant() {
        Collection<Etudiant> ce = MapEtu.values();

        for (Etudiant e : ce) {
            System.out.println(e.getCNE() + " " + e.getNom() + " " + e.getPrenom());
        }


    }


    public static void afficherCIN() {
        Set<String> setCIN = MapEtu.keySet();

        setCIN.forEach(System.out::println);
    }

    public static Etudiant etudiantAssocie(String cin) {
        for (Map.Entry<String, Etudiant> entry : MapEtu.entrySet()) {
            if (entry.getKey().equals(cin)) {
                return entry.getValue();
            }
        }
        return null;

    }

    public static String cinAssocieEtudiant(Etudiant e) {
        for (Map.Entry<String, Etudiant> entry : MapEtu.entrySet()) {
            if (entry.getValue().equals(e)) {
                return entry.getKey();
            }
        }
        return null;

    }

    public static void ajouterEtudiant(String cin, Etudiant e) {
        MapEtu.put(cin, e);
    }

    public static Etudiant supprimerEtudiant(String cin) {
        return MapEtu.remove(cin);


    }

    public static void joindreMaps() {
        Map<String, Etudiant> nMasp = new HashMap<>();

        nMasp.putAll(MapEtu);
    }


    public static void main(String[] args) {
        alimenterListe();
        AfficherMap();
        afficherCIN();
        AfficherEtudiant();
        System.out.println(etudiantAssocie("dfdlfksfs"));
        //etudiantAssocie("dfdlfksfs");
        supprimerEtudiant("dfdlfksfs");
        AfficherMap();


    }

}
