package by.bsu.jwd.parser.factory;

import by.bsu.jwd.exceptions.ParserException;
import by.bsu.jwd.parser.DOMDeviceParser;
import org.testng.annotations.DataProvider;

public class ParserFactoryTestData {
    @DataProvider(name = "createDeviceParserData")
    public static Object[] createDeviceParserData() throws ParserException {

        String dom = "dom";
        ParserFactory factory = ParserFactory.getInstance();

        return new Object[][]{
            {
                    dom, factory, DOMDeviceParser.class
            },
        };
    }
}
