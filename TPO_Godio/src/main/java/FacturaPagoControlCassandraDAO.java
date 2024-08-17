import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

public class FacturaPagoControlCassandraDAO {
    private final CqlSession session;

    public FacturaPagoControlCassandraDAO() {
        // Create a Cassandra session
        this.session = CqlSession.builder().build();
    }

    public void insertUser(String id, String name, String address) {
        String query = "INSERT INTO usuarios (id, nombre, direccion) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = session.prepare(query);

        session.execute(preparedStatement.bind(id, name, address));
    }

    public Row getUserById(String id) {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        PreparedStatement preparedStatement = session.prepare(query);

        return session.execute(preparedStatement.bind(id)).one();
    }

    public void updateUser(String id, String newName) {
        String query = "UPDATE usuarios SET nombre = ? WHERE id = ?";
        PreparedStatement preparedStatement = session.prepare(query);

        session.execute(preparedStatement.bind(newName, id));
    }

    public void deleteUser(String id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement preparedStatement = session.prepare(query);

        session.execute(preparedStatement.bind(id));
    }

    // Other methods as needed

}
