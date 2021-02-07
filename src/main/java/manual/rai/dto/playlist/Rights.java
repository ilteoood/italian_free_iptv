package manual.rai.dto.playlist;

public class Rights {
    private Geoprotection geoprotection;
    private Offline offline;

    public Geoprotection getGeoprotection() {
        return geoprotection;
    }

    public void setGeoprotection(Geoprotection geoprotection) {
        this.geoprotection = geoprotection;
    }

    public Offline getOffline() {
        return offline;
    }

    public void setOffline(Offline offline) {
        this.offline = offline;
    }

    @Override
    public String toString() {
        return
                "Rights{" +
                        "geoprotection = '" + geoprotection + '\'' +
                        ",offline = '" + offline + '\'' +
                        "}";
    }
}
