package lottosecond.domain.lotto;

import lottosecond.domain.Winner;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.WinningCondition;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    public static final int EACH_LOTTO_PRICE = 1000;

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public WinnerBoard checkWinnerLotto(WinningCondition winningCondition) {
        List<Winner> winners = lottoList.stream()
                .map(lotto -> {
                    int matchCount = lotto.matchNumberCount(winningCondition.getLotto());
                    boolean matchBonusBall = lotto.hasLottoNumber(winningCondition.getBonusBall());
                    return Winner.calculateWinner(matchCount, matchBonusBall);
                })
                .filter(winner -> winner != Winner.NONE)
                .sorted(Comparator.comparingLong(Winner::getPrice))
                .collect(Collectors.toList());

        return new WinnerBoard(winners);
    }

    public int totalLottoBuyMoney() {
        return lottoList.size() * EACH_LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
