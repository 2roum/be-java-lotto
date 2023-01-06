package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;
import kr.codesquad.view.IO;

import java.util.ArrayList;
import java.util.List;

public final class ManualLottoGenerator {
    public List<Lotto> generateLottos(int count) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottos.add(generateManual());
        }
        return manualLottos;
    }

    public static Lotto generateManual(){
        return Lotto.ofComma(IO.inputManualNumber());
    }
}
