package manual.rai.dto.playlist;

public class Dfp {
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return
                "Dfp{" +
                        "label = '" + label + '\'' +
                        "}";
    }
}
