package ua.devclub.drools.party;

import java.util.Date;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 22:54
 */
public class PartyDef {
    private final long partyId;
    private Date startTime;
    private Date stopTime;
    private String publicCode;

    public PartyDef(long partyId) {
        this.partyId = partyId;
    }

    public PartyDef setup(Date startTime, Date stopTime, String publicCode) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.publicCode = publicCode;

        return this;
    }

    public long getPartyId() {
        return partyId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getPublicCode() {
        return publicCode;
    }

    public void setPublicCode(String publicCode) {
        this.publicCode = publicCode;
    }
}
