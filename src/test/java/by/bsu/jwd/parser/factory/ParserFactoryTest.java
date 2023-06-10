package by.bsu.jwd.parser.factory;

import by.bsu.jwd.exceptions.ParserException;
import by.bsu.jwd.parser.AbstractDeviceParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserFactoryTest {
    @Test(dataProvider = "createDeviceParserData", dataProviderClass = ParserFactoryTestData.class)
    public void testCreateDeviceParser_String_Parser(String type, ParserFactory factory, Class expected) throws ParserException {

        AbstractDeviceParser actual = factory.createDeviceParser(type);

        Assert.assertEquals(actual.getClass(), expected);
    }
}
