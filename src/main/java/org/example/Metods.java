package org.example;

public enum Metods {
    CRM_DEAL_GET("crm.deal.get"),
    CRM_ITEM_UPDATE("crm.item.update");

    private final String method;

    Metods(String method) {
        this.method = method;

    }
    public String getMethod() {
        return method;
    }
}
