package com.dziadkouskaya.votingserver.enumeration;

public enum PollItemType implements BaseEnum<PollItemType> {
    CHECKBOX(1),
    RADIO(2);

    private final int code;

    PollItemType(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public static class Converter extends EnumConverter<PollItemType> {

        public Converter() {
            super(PollItemType.class);
        }
    }
}
