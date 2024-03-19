package fr.vengelis.oflbot.configurations;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import org.slf4j.LoggerFactory;

public enum Configuration {

    TOKEN("bot.token"),
    GUILD("bot.guild"),

    WELCOME_CHANNEL("channels.welcome"),
    LOG_CHANNEL("channels.logs"),
    ;
    static {
        CommentedFileConfig fileConfig = CommentedFileConfig.builder("configuration.toml")
                .defaultResource("/configuration.toml")
                .autosave()
                .build();

        fileConfig.load();

        for (Configuration configuration : Configuration.values()) {
            String path = configuration.getPath();
            Object value = fileConfig.get(path);
            if (value == null) {
                LoggerFactory.getLogger(Configuration.class).error("ERROR WHILE LOADING CONFIGURATION: Key " + path + " not exists !");
                continue;
            }
            configuration.setValue(value.toString());
        }
    }

    private final String path;
    private String value;

    Configuration(String path) {
        this.path = path;
        this.value = "";
    }

    public String getValue() {
        return value;
    }

    public boolean getBooleanValue() {
        if (!this.value.equals("true") && !this.value.equals("false")) {
            throw new IllegalArgumentException(this.getPath() + " is not a boolean");
        }
        return this.value.equals("true");
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPath() {
        return path;
    }

}