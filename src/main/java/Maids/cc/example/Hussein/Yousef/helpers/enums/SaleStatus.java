package Maids.cc.example.Hussein.Yousef.helpers.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SaleStatus {
    SOLD("sold"),
    ON_SALE("on_sale"),
    PENDING("pending");
    @JsonValue
    private final String displayName;

    SaleStatus(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
    @JsonCreator
    public static SaleStatus forName(String name) {
        for (SaleStatus element : values()) {
            if (element.displayName.toLowerCase().equals(name.toLowerCase())) {
                return element;
            }
        }
        return SaleStatus.PENDING;
    }
}
