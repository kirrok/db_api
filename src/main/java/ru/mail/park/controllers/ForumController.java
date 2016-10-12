package ru.mail.park.controllers;

import org.springframework.web.bind.annotation.*;
import ru.mail.park.Result;
import ru.mail.park.repositories.ForumDAO;


/**
 * Created by kirrok on 12.10.16.
 */
@RestController
public class ForumController extends DatabaseController {


    ForumDAO forumDAO = new ForumDAO();
    @RequestMapping(path = BASE_URL + "/forum/create", method = RequestMethod.POST)
    public Result createForum(@RequestBody CreateRequest body) {

        Result result = forumDAO.addForum(body.getName(),body.getShort_name(),body.getUser());
        return result;
    }


    private static final class CreateRequest {
        private String name;
        private String short_name;
        private String user;

        public CreateRequest() {
        }

        public String getName() {
            return name;
        }

        public String getShort_name() {
            return short_name;
        }

        public String getUser() {
            return user;
        }

        public CreateRequest(String name, String short_name, String user) {
            this.name = name;
            this.short_name = short_name;
            this.user = user;
        }
    }

}
