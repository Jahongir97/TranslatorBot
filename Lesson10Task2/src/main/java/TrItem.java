import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrItem {


    private List<ExItem> ex;


    private String pos;


    private List<MeanItem> mean;


    private List<SynItem> syn;


    private String text;

    public void setEx(List<ExItem> ex) {
        this.ex = ex;
    }

    public List<ExItem> getEx() {
        return ex;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getPos() {
        return pos;
    }

    public void setMean(List<MeanItem> mean) {
        this.mean = mean;
    }

    public List<MeanItem> getMean() {
        return mean;
    }

    public void setSyn(List<SynItem> syn) {
        this.syn = syn;
    }

    public List<SynItem> getSyn() {
        return syn;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return
                "TrItem{" +
                        "ex = '" + ex + '\'' +
                        ",pos = '" + pos + '\'' +
                        ",mean = '" + mean + '\'' +
                        ",syn = '" + syn + '\'' +
                        ",text = '" + text + '\'' +
                        "}";
    }
}
