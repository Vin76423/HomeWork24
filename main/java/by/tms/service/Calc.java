package by.tms.service;

public enum Calc {
    SUM{
        @Override
        public double run(double a, double b) { return a + b; }
    },

    SUB{
        @Override
        public double run(double a, double b) { return a - b; }
    },

    MUL{
        @Override
        public double run(double a, double b) { return a * b; }
    },

    DIV{
        @Override
        public double run(double a, double b) throws ArithmeticException {
            if (b == 0) throw new ArithmeticException();
            return a / b;
        }
    };

    public abstract double run(double a, double b) throws ArithmeticException;
}
