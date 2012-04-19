package com.victor.drools.party;

import java.util.Date;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 22:54
 */
public class PartyRole {
    private final long partyId;
    private final long roleId;
    private Date startTime;
    private Date stopTime;

    public PartyRole(long partyId, long roleId) {
        this.partyId = partyId;
        this.roleId = roleId;
    }

    public PartyRole setup(Date startTime, Date stopTime) {
        this.startTime = startTime;
        this.stopTime = stopTime;

        return this;
    }

    public long getPartyId() {
        return partyId;
    }

    public long getRoleId() {
        return roleId;
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
}
