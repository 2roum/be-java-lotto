package kr.codesquad.LottoService;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private final int countOfMatch;
    private final int winningMoney;


    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }
        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int prize(int countOfMatchLotto) {
        return (countOfMatchLotto * winningMoney);
    }
    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

}

