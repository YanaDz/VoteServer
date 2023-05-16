package com.dziadkouskaya.votingserver.enumeration;

public enum QuestionType implements BaseEnum<QuestionType> {
    CHECKBOX(1),
    RADIO(2);

    private final int code;

    QuestionType(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public static class Converter extends EnumConverter<QuestionType> {

        public Converter() {
            super(QuestionType.class);
        }
    }
}
