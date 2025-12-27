
// sa citesc un mesaj din config file sau in arg
package com.myapp.config;

public class AppConfig {

    private String mode;

    private String usersFile;
    private String warehouseFile;
    private String itemsFile;
    private String transactionsFile;

    private String shoppingListFile;
    private String shoppingListItemFile;

    private String categoryFile;

    public String getMode() {
        return mode;
    }

    public String getUsersFile() {
        return usersFile;
    }

    public String getWarehouseFile() {
        return warehouseFile;
    }

    public String getItemsFile() {
        return itemsFile;
    }

    public String getTransactionsFile() {
        return transactionsFile;
    }

    public String getShoppingListFile() {
        return shoppingListFile;
    }

    public String getShoppingListItemFile() {
        return shoppingListItemFile;
    }

    public String getCategoryFile() {
        return categoryFile;
    }
}

