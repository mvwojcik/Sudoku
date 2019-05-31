package pl.mwkc.utils;

import java.util.ListResourceBundle;

public class Authors_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"title", "Authors"},
                {"authors", "Mateusz Wojcik and Kacper Ciecinski"}
        };
    }
}
