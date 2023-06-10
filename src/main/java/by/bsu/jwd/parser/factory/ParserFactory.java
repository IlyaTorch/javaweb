package by.bsu.jwd.parser.factory;

import by.bsu.jwd.parser.AbstractDeviceParser;
import by.bsu.jwd.parser.DOMDeviceParser;
import by.bsu.jwd.exceptions.ParserException;

public class ParserFactory {
    private static final ParserFactory INSTANCE = new ParserFactory();

    private enum TypeParser {
        DOM
    }

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return INSTANCE;
    }

    public AbstractDeviceParser createDeviceParser(String typeParser) throws ParserException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        if (type == TypeParser.DOM) {
            return new DOMDeviceParser();
        }
        throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
    }
}
