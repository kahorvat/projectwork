package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@IncludeTags("nobrowser")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value="html:reports/out.html")
public class TestRunner {

}

