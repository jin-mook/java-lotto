package lottosecond.domain.lotto;

import java.util.List;

@FunctionalInterface
public interface CustomShuffle {

    List<LottoNumber> makeShuffle();
}
