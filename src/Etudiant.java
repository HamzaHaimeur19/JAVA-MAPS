import java.util.Comparator;
import java.util.Objects;
import java.lang.Comparable;

public class Etudiant implements Comparable<Etudiant>, Cloneable {
    private String nom;
    private String prenom;
    private int CNE;
    private String CIN;

    public Etudiant(String nom, String prenom, int CNE, String CIN) {
        this.nom = nom;
        this.prenom = prenom;
        this.CNE = CNE;
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public int getCNE() {
        return CNE;
    }

    public String getCIN() {
        return CIN;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCNE(int CNE) {
        this.CNE = CNE;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etudiant etudiant)) return false;
        return CNE == etudiant.CNE && nom.equals(etudiant.nom) && prenom.equals(etudiant.prenom) && CIN.equals(etudiant.CIN);
    }

    @Override
    public int hashCode() {
        return getCIN().hashCode(); // on a utilisé hasCode() car c'est un String (et car le CIN est unique)
    }


    @Override
    public int compareTo(Etudiant e) {
        return this.CIN.compareTo(e.CIN);
    }

    public static Comparator<Etudiant> cmpCNE = Comparator.comparing(Etudiant::getCNE);


    @Override
    public Etudiant clone() {
        try {
            return (Etudiant) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Erreur de clonage");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", CNE=" + CNE +
                ", CIN='" + CIN + '\'' +
                '}';
    }
}
