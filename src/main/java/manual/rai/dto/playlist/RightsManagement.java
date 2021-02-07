package manual.rai.dto.playlist;

public class RightsManagement {
    private Rights rights;

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    @Override
    public String toString() {
        return
                "RightsManagement{" +
                        "rights = '" + rights + '\'' +
                        "}";
    }
}
