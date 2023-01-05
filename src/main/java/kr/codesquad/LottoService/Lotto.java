package kr.codesquad.LottoService;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또에는 6개의 숫자가 필요합니다.");
        }

        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto ofComma(String value) {
        String[] values = value.split(",");
        return new Lotto(
                Arrays.stream(values)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    private int increment(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public String toString() {
        return lotto.stream().sorted().collect(Collectors.toList()).toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
