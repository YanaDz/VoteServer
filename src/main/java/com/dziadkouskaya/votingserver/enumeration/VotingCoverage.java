package com.dziadkouskaya.votingserver.enumeration;

public enum VotingCoverage implements BaseEnum<VotingCoverage> {
    FULL_HOUSE(0),
    HOUSE(1),
    ENTRANCE(2);

    private final int code;

    VotingCoverage(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public static class Converter extends EnumConverter<VotingCoverage> {

        public Converter() {
            super(VotingCoverage.class);
        }
    }
}
