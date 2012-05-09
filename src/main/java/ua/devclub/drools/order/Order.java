package ua.devclub.drools.order;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 22:58
 */
public class Order {
    private final long id;
    private final Date time;
    private String inParty;
    private String outParty;
    private String inRole;
    private String outRole;
    private Long inPartyId;
    private Long outPartyId;
    private Long inRoleId;
    private Long outRoleId;
    private final List<OrderItem> items = new LinkedList<OrderItem>();

    public Order(long id, Date time) {
        this.id = id;
        this.time = time;
    }

    public Order setup(String inParty, String outParty, String inRole, String outRole) {
        this.inParty = inParty;
        this.outParty = outParty;
        this.inRole = inRole;
        this.outRole = outRole;

        return this;
    }

    public Order append(String productCode, int quantity) {
        OrderItem item = new OrderItem(this.id, productCode);
        
        item.setQuantity(quantity);
        
        items.add(item);

        return this;
    }

    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getInParty() {
        return inParty;
    }

    public void setInParty(String inParty) {
        this.inParty = inParty;
    }

    public String getOutParty() {
        return outParty;
    }

    public void setOutParty(String outParty) {
        this.outParty = outParty;
    }

    public String getInRole() {
        return inRole;
    }

    public void setInRole(String inRole) {
        this.inRole = inRole;
    }

    public String getOutRole() {
        return outRole;
    }

    public void setOutRole(String outRole) {
        this.outRole = outRole;
    }

    public Long getInPartyId() {
        return inPartyId;
    }

    public void setInPartyId(Long inPartyId) {
        this.inPartyId = inPartyId;
    }

    public Long getOutPartyId() {
        return outPartyId;
    }

    public void setOutPartyId(Long outPartyId) {
        this.outPartyId = outPartyId;
    }

    public Long getInRoleId() {
        return inRoleId;
    }

    public void setInRoleId(Long inRoleId) {
        this.inRoleId = inRoleId;
    }

    public Long getOutRoleId() {
        return outRoleId;
    }

    public void setOutRoleId(Long outRoleId) {
        this.outRoleId = outRoleId;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
