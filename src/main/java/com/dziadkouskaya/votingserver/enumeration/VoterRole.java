package com.dziadkouskaya.votingserver.enumeration;

public enum VoterRole implements BaseEnum<VoterRole> {
    INDIVIDUAL_OWNER(0),
    LEGAL_ENTITY_OWNER(1),
    RESIDENT(2),
    RENTER(3);

    private int code;

    VoterRole(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public static class Converter extends EnumConverter<VoterRole> {

        public Converter() {
            super(VoterRole.class);
        }
    }

}
