import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExItem {

    @SerializedName("text")
    private String text;

    @SerializedName("tr")
    private List<TrItem> tr;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTr(List<TrItem> tr) {
        this.tr = tr;
    }

    public List<TrItem> getTr() {
        return tr;
    }

    @Override
    public String toString() {
        return
                "ExItem{" +
                        "text = '" + text + '\'' +
                        ",tr = '" + tr + '\'' +
                        "}";
    }
}
