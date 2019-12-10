package data;

public enum TestData {

    TEST_01("https://the-internet.herokuapp.com/",
            "Hellow",
            "User_01"),

    TEST_02("https://UATthe-internet.jaja.com/",
                    "Hellow2",
                    "User_02");

    private final String url;
    private final String input;
    private final String user;


    TestData(String url, String input, String user) {
        this.url = url;
        this.input = input;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public String getInput() {
        return input;
    }

    public String getUser() {
        return user;
    }

}

