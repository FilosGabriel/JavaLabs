package lab3;

import java.time.LocalTime;

public interface Visitable {
    String getOpeningHours(); //un text precum "Deschis de la x la x", nush sigur daca e ok
    void setOpeningHours(LocalTime opens, LocalTime closes); //
}
