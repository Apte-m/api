package data;

public enum DataInput {
    CHECK_EMAIL("Please enter a valid email address"),
    CHECK_GIT_HUB ("WebdriverIO is fully open source and can be found on GitHub");
    String value;


    DataInput(String email ) {
        this.value = email;


    }



    public String getValue() {
        return value;
    }


}
