package app.ru.itmo;

import java.lang.Exception;

@SuppressWarnings("serial")
public class CatalogLoadException extends Exception {
    public CatalogLoadException(String errorMessage) {
        super(errorMessage);
    }
}
