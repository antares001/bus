package net.scnetwork.bus;

import net.scnetwork.bus.config.Global;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.*;

public class ConfigBus {
    private static final String FILENAME = "roseources://config/global.yaml";
    private static Iterable<Object> instance;

    private ConfigBus(){}

    static {
        if (instance != null)
            throw new Error();
        File file = new File(FILENAME);

        try(InputStream inputStream = new FileInputStream(file)) {
            Yaml yaml = new Yaml(new SafeConstructor());
            instance = yaml.loadAll(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Global getConfig(){
        return new Global();
    }
}
