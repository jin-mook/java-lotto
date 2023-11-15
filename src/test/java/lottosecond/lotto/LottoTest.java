package lottosecond.lotto;

import lottosecond.domain.lotto.Lotto;
import lottosecond.testutil.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("입력 받은 당첨번호를 통해 몇 개의 번호가 일치하는지 알려줍니다.")
    void getLottoScore() {
        // given
        Lotto winnerNumbers = new Lotto(TestUtil.makeLottoNumberSet(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(TestUtil.makeLottoNumberSet(1, 2, 3, 7, 8, 9));
        // when
        int lottoScore = lotto.getLottoScore(winnerNumbers);
        // then
        assertThat(lottoScore).isEqualTo(3);
    }

    @Test
    @DisplayName("번호의 개수가 6개가 아니면 에러를 발생시킵니다.")
    void notSixNumber() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Lotto(TestUtil.makeLottoNumberSet(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 반드시 6개여야 합니다.");
    }
}