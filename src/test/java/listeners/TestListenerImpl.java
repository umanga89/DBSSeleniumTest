package listeners;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.BaseUtil;
import utilities.PropertiesUtil;

public class TestListenerImpl implements ITestListener {
    @Override
    public void onStart(ITestContext context){
        try
        {
            //Getting home directory
            BaseUtil.base_directory = System.getProperty("user.dir");

            //Setting log4j2.xml property file path
            System.setProperty("log4j.configurationFile", BaseUtil.base_directory+"/log4j2.xml");

            BaseUtil.logger = LogManager.getLogger(TestListenerImpl.class.getName());

            BaseUtil.logger.info("Loading properties file: "+BaseUtil.base_directory + "/src/test/java/config/config.properties");

            //Loading configuration.properties file
            BaseUtil.configProperties = PropertiesUtil.loadProperties(BaseUtil.base_directory +"/src/test/java/config/config.properties");

        }
        catch(Exception e)
        {

        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
        //BaseUtil.driver.quit();
    }
}
