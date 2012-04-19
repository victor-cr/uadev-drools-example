package com.victor.drools.party;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 22:54
 */
public class Role {
    private final long id;
    private String publicCode;

    public Role(long id) {
        this.id = id;
    }

    public Role setup(String publicCode) {
        this.publicCode = publicCode;

        return this;
    }
    
    public long getId() {
        return id;
    }

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String publicCode) {
        this.publicCode = publicCode;
    }
}
