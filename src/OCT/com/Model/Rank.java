package OCT.com.Model;

public enum Rank {
    POOR("Kém"), WEARK("YẾU"), AVERAGE("TRUNG BÌNH"), GOOB("Khá"), VERYGOOD("GIỎI"), EXCELLENT("XUẤT SẮC");


    private final String rank;

    Rank(String rank) {
        this.rank = rank;
    }

    public String getValueRank() {
        return rank;
    }
}
