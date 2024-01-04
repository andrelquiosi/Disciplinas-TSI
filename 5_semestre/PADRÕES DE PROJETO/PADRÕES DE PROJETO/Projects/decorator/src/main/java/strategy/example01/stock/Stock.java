package strategy.example01.stock;

import java.io.IOException;
import java.util.List;

public interface Stock<T> {
void load() throws IOException;
List<T> getAll();
}
