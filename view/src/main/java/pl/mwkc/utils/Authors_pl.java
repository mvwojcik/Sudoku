package pl.mwkc.utils;

import java.util.ListResourceBundle;

public class Authors_pl extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"title", "Autorzy"},
                {"authors", "Mateusz Wojcik i Kacper Ciecinski"}
        };
    }
}
