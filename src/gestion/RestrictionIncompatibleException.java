package gestion;

import java.util.ArrayList;
import java.util.List;

// Exception personnalisée
public class RestrictionIncompatibleException extends Exception {
    public RestrictionIncompatibleException(String message) {
        super(message);
    }
}