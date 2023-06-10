package by.bsu.jwd.parser;

import by.bsu.jwd.entity.Device;
import by.bsu.jwd.exceptions.ParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Set;

public class DOMDeviceParserTest {
    @Test(dataProvider = "buildSetDevicesData", dataProviderClass = DeviceParserTestData.class)
    public void testBuildSetDevices_InputStream_devices(Set<Device> expected, InputStream stream) throws ParserException {

        AbstractDeviceParser parser = new DOMDeviceParser();
        parser.buildSetDevices(stream);
        Set<Device> actual = parser.devices;

        Assert.assertEquals(actual, expected);
    }
}
