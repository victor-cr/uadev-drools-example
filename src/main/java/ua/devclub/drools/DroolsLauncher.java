package ua.devclub.drools;

import ua.devclub.drools.order.Order;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.CommandFactory;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 22:33
 */
public class DroolsLauncher {
    private static final Logger LOG = LoggerFactory.getLogger(DroolsLauncher.class);
    private static final GeneralDao DAO = new GeneralDao();

    public static void main(String[] args) throws Exception {
        KnowledgeBuilderConfiguration conf = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(conf);

        Resource drl = ResourceFactory.newClassPathResource("/ua/devclub/drools/orderPrefetch.drl", DroolsLauncher.class);
        kBuilder.add( drl, ResourceType.DRL );
//        Resource drl = ResourceFactory.newClassPathResource("/com/victor/drools/order.drl", DroolsLauncher.class);
//        kBuilder.add( drl, ResourceType.DRL );
/*
        Resource dsl = ResourceFactory.newClassPathResource("/com/victor/drools/orderDsl.dsl", DroolsLauncher.class);
        kBuilder.add( dsl, ResourceType.DSL );
        Resource dslr = ResourceFactory.newClassPathResource("/com/victor/drools/orderDsl.dslr", DroolsLauncher.class);
        kBuilder.add( dslr, ResourceType.DSLR );
*/

        KnowledgeBase kBase = kBuilder.newKnowledgeBase();

        StatelessKnowledgeSession session = kBase.newStatelessKnowledgeSession();

        session.setGlobal("dao", DAO);
        session.setGlobal("log", LOG);

        List<Order> orders = Arrays.asList(
                new Order(1, DAO.toDate(2012, 4, 19)).setup("Victor", "Eldorado", "B", "S").append("computer", 1).append("mouse", 1),
                new Order(2, DAO.toDate(2012, 4, 19)).setup("Victor", "Techno Center Mayak", "B", "R").append("mouse", 1),
                new Order(3, DAO.toDate(2012, 4, 19)).setup("Victor", "Eldorado", "S", "B").append("computer", 1).append("mouse", 1),
                new Order(4, DAO.toDate(2012, 4, 19)).setup("Eldorado", "Victor", "S", "B").append("mouse", -1),
                new Order(5, DAO.toDate(2012, 4, 19)).setup("Victor", "Comfy", "B", "S").append("coffee machine", 1),
                new Order(6, DAO.toDate(2012, 4, 19)).setup("Victor", "Victor", "B", "B").append("mouse", 1),
                new Order(7, DAO.toDate(2012, 4, 19)).setup("Noone", "Victor", "B", "B").append("mouse", 1)
        );

        session.execute(CommandFactory.newInsertElements(orders));
    }
}
