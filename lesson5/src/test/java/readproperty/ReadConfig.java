package readproperty;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ReadConfig {


    static Config readProperties() {
        return ConfigFactory.load("application.conf");
    }

    String URL = readProperties().getString("url");
    String URL_LIKE = readProperties().getString("urlLike");
    String LOGIN = readProperties().getString("usersParams.admin.login");
    String PASSWORD = readProperties().getString("usersParams.admin.password");
    String COOKIE = readProperties().getString("usersParams.admin.configuration.cookie");


}
