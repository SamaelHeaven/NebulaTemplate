package org.example.app;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.samaelheaven.nebula.database.Broker;
import org.samaelheaven.nebula.database.Database;
import org.samaelheaven.nebula.database.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public final class TestBroker extends Broker implements ResultSetHandler<TestModel> {
    public TestBroker(@Nullable Database database) {
        super(database);
    }

    @Override
    public @NotNull TestModel handle(@NotNull ResultSet resultSet) throws SQLException {
        var id = resultSet.getInt("test.id");
        var test = resultSet.getString("test.test");
        return new TestModel(id, test);
    }

    public Collection<TestModel> findAll() {
        return selectCollection(this, """
                    SELECT id "test.id", test "test.test"
                    FROM test
                """);
    }
}