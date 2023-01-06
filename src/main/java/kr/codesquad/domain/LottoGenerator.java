package kr.codesquad.domain;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> lottoGenerate(int count);
}
