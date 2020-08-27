package by.tms.util;

import by.tms.service_1.*;
import java.util.HashMap;
import java.util.Map;


// for service_1
public class TypeUtil {
    public static final Map<String, Operation> OPERATION = new HashMap<>();

    static {
        OPERATION.put("sum", new SumOperation());
        OPERATION.put("sub", new SubOperation());
        OPERATION.put("mul", new MulOperation());
        OPERATION.put("div", new DivOperation());
    }
}
