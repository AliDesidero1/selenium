import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class C57_Log4j_UseProperties {
    // Loggerlari import ederken dikkat edelim , hata alabiliriz ..

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C57_Log4j_UseProperties.class);
        logger.trace("bu bir trace mesajidir");
        logger.debug("bu bir debug mesajidir");
        logger.info("bu bir info mesajidir");
        logger.warn("bu bir warn mesajidir");
        logger.error("bu bir error mesajidir");
        logger.fatal("bu bir fatal mesajidir");

    }
}
