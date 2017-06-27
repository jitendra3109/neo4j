package org.intermine.neo4j.cypher;

import org.intermine.pathquery.OrderElement;
import org.intermine.pathquery.PathConstraint;
import org.intermine.pathquery.PathQuery;

import java.util.*;

/**
 * Stores various helper methods.
 *
 * @author Yash Sharma
 */
public class Helper {

    public static void printConstraints(PathQuery pathQuery){
        for (PathConstraint pathConstraint : pathQuery.getConstraints().keySet()){
            System.out.println("Path : " + pathConstraint.getPath());
            System.out.println("Operator : " + pathConstraint.getOp());
            System.out.println("Value : " + PathConstraint.getValue(pathConstraint));
            System.out.println("Values : " + PathConstraint.getValues(pathConstraint));
            System.out.println("Extra value : " + PathConstraint.getExtraValue(pathConstraint));
        }
    }

    public static String quoted(String string){
        return "'" + string + "'";
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Get all tokens from a path
     *
     * @param path A path which contains many tokens separated by dots
     * @return List of all tokens of the path
     */
    public static List<String> getTokensFromPath(String path){
        StringTokenizer st = new StringTokenizer(path, ".");
        List<String> strings = new ArrayList<>();
        while(st.hasMoreTokens()){
            strings.add(st.nextToken());
        }
        return strings;
    }

    /**
     * Extracts all paths from the path query object
     *
     * @param pathQuery the path query object
     * @return A set containing all the paths in the path query
     */
    public static Set<String> getAllPaths(PathQuery pathQuery){
        Set<String> paths = new HashSet<>();

        // Get paths from views
        paths.addAll(pathQuery.getView());

        // Get paths from constraints
        Set<PathConstraint> pathConstraints = pathQuery.getConstraints().keySet();
        for (PathConstraint pathConstraint : pathConstraints){
            paths.add(pathConstraint.getPath());
        }

        // Get paths from sort order
        List<OrderElement> orderElements = pathQuery.getOrderBy();
        for (OrderElement orderElement : orderElements){
            paths.add(orderElement.getOrderPath());
        }

        return paths;
    }

}
