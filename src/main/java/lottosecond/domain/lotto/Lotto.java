package lottosecond.domain.lotto;

import lottosecond.domain.BonusBall;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 반드시 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbersInteger) {
        this(lottoNumbersInteger.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public int getLottoScore(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }

    public int matchNumberCount(Lotto winLotto) {
        return (int) winLotto.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public int matchBonusBallNumberCount(BonusBall bonusBall) {
        if (lottoNumbers.contains(bonusBall.getNumber())) {
            return 1;
        }
        return 0;
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }


}
