package school.hei.patrimoine.cas.example.pro3;

import static school.hei.patrimoine.modele.Argent.ariary;
import static school.hei.patrimoine.modele.Devise.MGA;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import school.hei.patrimoine.cas.Cas;
import school.hei.patrimoine.modele.Devise;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.*;

public class BakoCas extends Cas {

    public BakoCas(LocalDate ajd, LocalDate finSimulation, Map<Personne, Double> possesseurs) {
        super(ajd, finSimulation, possesseurs);
    }

    @Override
    protected Devise devise() {
        return MGA;
    }

    @Override
    protected String nom() {
        return "Cas Bako Salariée";
    }

    @Override
    protected void init() {}

    @Override
    protected void suivi() {}

    @Override
    public Set<Possession> possessions() {

        var bni = new Compte(
                "BNI (salaire)",
                LocalDate.of(2025, 4, 8),
                ariary(2_000_000)
        );

        var bmoi = new Compte(
                "BMOI (épargne)",
                LocalDate.of(2025, 4, 8),
                ariary(625_000)
        );

        var coffre = new Compte(
                "Coffre maison",
                LocalDate.of(2025, 4, 8),
                ariary(1_750_000)
        );


        new FluxArgent("Salaire mensuel",
                bni,
                LocalDate.of(2025, 4, 2),
                LocalDate.of(2025, 12, 2),
                2,
                ariary(2_125_000)
        );


        new TransfertArgent(
                "Virement épargne automatique",
                bni,
                bmoi,
                LocalDate.of(2025, 4, 3),
                LocalDate.of(2025, 12, 3),
                3,
                ariary(200_000)
        );



        new FluxArgent("Colocation",
                bni,
                LocalDate.of(2025, 4, 26),
                LocalDate.of(2025, 12, 26),
                26, ariary(-600_000)
        );


        new FluxArgent("Vie quotidienne",
                bni,
                LocalDate.of(2025, 4, 1),
                LocalDate.of(2025, 12, 1),
                1,
                ariary(-700_000)
        );


        var ordinateur = new Materiel(
                "PC portable",
                LocalDate.of(2025, 4, 8),
                LocalDate.of(2025, 4, 8),
                ariary(3_000_000),
                -0.12
        );

        return Set.of(bni, bmoi, coffre, ordinateur);
    }
}
