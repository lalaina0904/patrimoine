package school.hei.patrimoine.cas;

import static school.hei.patrimoine.modele.Argent.ariary;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import school.hei.patrimoine.cas.example.pro3.BakoCas;
import school.hei.patrimoine.modele.Personne;

public class CasSetSupplier implements Supplier<CasSet> {
  @Override
  public CasSet get() {

    var bako = new Personne("Bako");
    var bakoCas = new BakoCas(
            LocalDate.of(2025, 4, 8),
            LocalDate.of(2025, 12, 31),
            Map.of(bako, 1.0)
    );

    return new CasSet(Set.of(bakoCas), ariary(13_111_657));


  }
}
