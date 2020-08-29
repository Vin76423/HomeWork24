package by.tms.entity;

public class UsersOperation {
    public static int counter = 1;

    private int operationId = counter++;
    private String num1;
    private String num2;
    private String type;
    private String result;

    public UsersOperation(String num1, String num2, String type, String result) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.result = result;
    }

    public UsersOperation() {
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UsersOperation{" +
                "operationId=" + operationId +
                ", num1='" + num1 + '\'' +
                ", num2='" + num2 + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
