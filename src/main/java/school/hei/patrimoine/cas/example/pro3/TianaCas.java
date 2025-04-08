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

public class TianaCas extends Cas {

    public TianaCas(LocalDate ajd, LocalDate finSimulation, Map<Personne, Double> possesseurs) {
        super(ajd, finSimulation, possesseurs);
    }

    @Override
    protected Devise devise() {
        return MGA;
    }

    @Override
    protected String nom() {
        return "Cas Tiana Entrepreneur";
    }

    @Override
    protected void init() {}

    @Override
    protected void suivi() {}

    @Override
    public Set<Possession> possessions() {

        var compte = new Compte(
                "Compte unique",
                LocalDate.of(2025, 4, 8),
                ariary(60_000_000)
        );


        var terrain = new Materiel(
                "Terrain bâti",
                LocalDate.of(2025, 4, 8),
                LocalDate.of(2025, 4, 8),
                ariary(100_000_000),
                0.10
        );


        new FluxArgent(
                "Dépenses familiales",
                compte,
                LocalDate.of(2025, 4, 26),
                LocalDate.of(2026, 3, 26),
                26,
                ariary(-4_000_000)
        );


        new FluxArgent(
                "Investissement projet",
                compte,
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 12, 1),
                1,
                ariary(-5_000_000)
        );


        var compteProjet = new Compte(
                "Compte projet",
                LocalDate.of(2025, 5, 1),
                ariary(0)
        );

        new FluxArgent(
                "Revenu projet 10%",
                compteProjet,
                LocalDate.of(2025, 5, 1),
                ariary(7_000_000)
        );

        new FluxArgent(
                "Revenu projet 90%",
                compteProjet,
                LocalDate.of(2026, 1, 31),
                ariary(63_000_000)
        );


        var dette = new Dette(
                "Prêt bancaire",
                LocalDate.of(2025, 7, 27),
                ariary(-20_000_000)
        );

        new FluxArgent(
                "Décaissement prêt",
                compte,
                LocalDate.of(2025, 7, 27),
                ariary(20_000_000)
        );

        for (int i = 0; i < 12; i++) {
            var date = LocalDate.of(2025, 8, 27).plusMonths(i);
            new FluxArgent(
                    "Remboursement prêt - échéance " + (i+1),
                    dette,
                    date,
                    ariary(2_000_000));
        }

        return Set.of(compte, terrain, compteProjet, dette);
    }
}
