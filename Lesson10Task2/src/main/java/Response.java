import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {

    @SerializedName("head")
    private Head head;

    @SerializedName("def")
    private List<DefItem> def;

    public void setHead(Head head) {
        this.head = head;
    }

    public Head getHead() {
        return head;
    }

    public void setDef(List<DefItem> def) {
        this.def = def;
    }

    public List<DefItem> getDef() {
        return def;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "head = '" + head + '\'' +
                        ",def = '" + def + '\'' +
                        "}";
    }
}
