package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;

import java.util.List;

public interface LottoGenerate {
    List<Lotto> generate(int cnt);

}
