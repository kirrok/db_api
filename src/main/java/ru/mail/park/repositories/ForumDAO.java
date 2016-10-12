package ru.mail.park.repositories;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.mail.park.ResponseStatus;
import ru.mail.park.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by kirrok on 12.10.16.
 */
@Component
public class ForumDAO extends BaseDAO{

    private String id;
    private String name;
    private String shortName;
    private String user;

    private final Gson myGson = new Gson();


    public Result addForum(String name, String shortName, String user) {


        final String SQL = "insert into forum (name, short_name, user) values (?, ?, ?)";
        long id = 0;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement(SQL, new String[]{"id"});
                            ps.setString(1, name);
                            ps.setString(2, shortName);
                            ps.setString(3, user);
                            return ps;
                        }
                    },
                    keyHolder);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new Result(ResponseStatus.CODE_UNKNOWN_ERROR, ResponseStatus.MESSAGE_UNKNOWN_ERROR);
        }
            id = keyHolder.getKey().longValue();

        JsonObject request = new JsonObject();

        request.addProperty("ID", id);
        request.addProperty("name", name);
        request.addProperty("short_name", shortName);
        request.addProperty("user", user);


        return new Result(ResponseStatus.CODE_OK, request);
    }
}
