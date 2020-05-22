package lotto.ui;

import lotto.domain.rank.Rank;
import lotto.domain.rank.Ranks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PrizeOutputView {
    private Ranks ranks;

    public PrizeOutputView(Ranks ranks) {
        this.ranks = ranks;
    }

    protected String getIndividualStatistics(Rank rank) {
        return rank.getMatchNumber() +
                "개 일치 (" +
                rank.getPrice() +
                "원)- " +
                ranks.getCount(rank) +
                "개";
    }

    public String getTotalStatistics() {
        return Arrays.stream(Rank.values())
                .filter(Rank::canGetPrize)
                .map(this::getIndividualStatistics)
                .reduce("", (previousStatistics, statistics) -> previousStatistics + statistics + "\n");
    }

    public String getTotalRateOfReturn(long boughtMoney) {
        BigDecimal totalValue = BigDecimal.valueOf(ranks.calculateTotalPrize());
        BigDecimal boughtValue = BigDecimal.valueOf(boughtMoney);
        return "총 수익률은 " +
                totalValue.divide(boughtValue, 2, RoundingMode.HALF_UP) +
                "입니다.";
    }

    public void printPrizeStatistics(long boughtMoneyValue) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(this.getTotalStatistics());
        System.out.println(this.getTotalRateOfReturn(boughtMoneyValue));
    }
}
