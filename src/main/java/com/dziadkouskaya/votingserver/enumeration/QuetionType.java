package com.dziadkouskaya.votingserver.enumeration;

public enum QuetionType implements BaseEnum<QuetionType> {
    CHECKBOX(1),
    RADIO(2);

    private final int code;

    QuetionType(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public static class Converter extends EnumConverter<QuetionType> {

        public Converter() {
            super(QuetionType.class);
        }
    }
}
