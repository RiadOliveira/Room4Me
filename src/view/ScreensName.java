package view;

public enum ScreensName {
    Login("Login"), SignUp("SignUp"),
    Search("Search"), Announce("Announce"),
    Address("Address"),Aspects("Aspects"),
    ConcludeApartment("ConcludeApartment");

    private String ScreensName;

    ScreensName(final String ScreensName) {
        this.ScreensName = ScreensName;
    }

    @Override
    public String toString() {
        return ScreensName;
    }

}
