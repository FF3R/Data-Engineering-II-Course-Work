import redis.clients.jedis.Jedis;

public class ProductosEnCarritoRedisDAO {
    private final Jedis jedis;

    public ProductosEnCarritoRedisDAO() {
        // Establish a connection to Redis
        this.jedis = new Jedis("localhost", 6379);
    }

    public void set(String key, String value) {
        jedis.set(key, value);
    }

    public String get(String key) {
        return jedis.get(key);
    }

    public void delete(String key) {
        jedis.del(key);
    }
}
