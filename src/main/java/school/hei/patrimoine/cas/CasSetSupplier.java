package school.hei.patrimoine.cas;

import static school.hei.patrimoine.modele.Argent.ariary;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import school.hei.patrimoine.cas.example.pro3.TianaCas;
import school.hei.patrimoine.modele.Personne;

public class CasSetSupplier implements Supplier<CasSet> {
  @Override
  public CasSet get() {

      var tiana = new Personne("Tiana");
      var tianaCas = new TianaCas(
            LocalDate.of(2025, 4, 8),
            LocalDate.of(2026, 3, 31),
            Map.of(tiana, 1.0)
    );

    return new CasSet(Set.of(tianaCas), ariary(172_780_822));

  }
}
