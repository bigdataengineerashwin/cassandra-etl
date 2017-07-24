package cassandraConnection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Created by Aman on 7/19/2017.
 */
public class CassConnect {
    public static void main(String[] args) {
        String query = "SELECT * FROM vehicle_tracker.location";

        Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
        Session session = cluster.connect();

        ResultSet resultSet = session.execute(query);

        for(Row row : resultSet){
            System.out.print(row.getString("vehicle_id"));
            System.out.print("\t");
            System.out.print(row.getTimestamp("time"));
            System.out.print("\t");
            System.out.print(row.getDouble("latitude"));
            System.out.print("\t");
            System.out.println(row.getDouble("longitude"));

        }

        System.out.println("Vehicle Tracker");
    }
}
