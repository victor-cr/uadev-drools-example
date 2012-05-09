package ua.devclub.drools;

import ua.devclub.drools.order.ProductDef;
import ua.devclub.drools.party.PartyDef;
import ua.devclub.drools.party.PartyRole;
import ua.devclub.drools.party.Role;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 23:29
 */
public class GeneralDao {
    private List<PartyDef> partyDefs = new ArrayList<PartyDef>(3);
    private List<ProductDef> productDefs = new ArrayList<ProductDef>(3);
    private Map<String, PartyRole> partyRoles = new HashMap<String, PartyRole>();
    private Map<String, Role> roles = new HashMap<String, Role>();

    public GeneralDao() {
        partyDefs.add(new PartyDef(100).setup(toDate(1983, 5, 28), toDate(2012, 12 , 31), "Victor"));
        partyDefs.add(new PartyDef(200).setup(toDate(2000, 1, 1), toDate(2012, 12 , 31), "Eldorado"));
        partyDefs.add(new PartyDef(300).setup(toDate(1999, 1, 1), toDate(2012, 12 , 31), "Techno Center Mayak"));

        productDefs.add(new ProductDef(10).setup(toDate(2010, 1, 1), toDate(2012, 12 , 31), "mouse"));
        productDefs.add(new ProductDef(20).setup(toDate(2012, 1, 1), toDate(2012, 12 , 31), "computer"));
        productDefs.add(new ProductDef(30).setup(toDate(2012, 4, 19), toDate(2012, 12 , 31), "cool stuff"));

        partyRoles.put("B", new PartyRole(100, 1000).setup(toDate(2000, 1, 1), toDate(2012, 12 , 31)));
        partyRoles.put("S", new PartyRole(200, 2000).setup(toDate(2000, 1, 1), toDate(2012, 12 , 31)));
        partyRoles.put("R", new PartyRole(300, 3000).setup(toDate(2000, 1, 1), toDate(2012, 12, 31)));

        roles.put("B", new Role(1000).setup("B"));
        roles.put("S", new Role(2000).setup("S"));
        roles.put("R", new Role(3000).setup("R"));
    }

    public PartyDef findPartyBy(Date date, String partyCode) {
        for (PartyDef def : partyDefs) {
            if (def.getPublicCode().equals(partyCode) && !def.getStartTime().after(date) && def.getStopTime().after(date)) {
                return def;
            }
        }

        return null;
    }

    public PartyRole findRoleBy(Date date, long partyId, String roleCode) {
        PartyRole partyRole = partyRoles.get(roleCode);

        if (partyRole.getPartyId() == partyId && !partyRole.getStartTime().after(date) && partyRole.getStopTime().after(date)) {
            return partyRole;
        }

        return null;
    }
    
    public Role findRoleBy(String roleCode) {
        return roles.get(roleCode);
    }

    public ProductDef findProductBy(Date date, String productCode) {
        for (ProductDef def : productDefs) {
            if (def.getPublicCode().equals(productCode) && !def.getStartTime().after(date) && def.getStopTime().after(date)) {
                return def;
            }
        }

        return null;
    }

    public Date toDate(int y, int m, int d) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(y, m - 1, d);

        return calendar.getTime();
    }
}
