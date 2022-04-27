package th.ac.kmutnb.kmutnb_bank.model;

import org.json.JSONArray;

public class DataModel {
    private String id;
    private String name;
    private String account_number;
    private String phone;
    private String password;
    private float money;
    private JSONArray history;

    public DataModel(String id, String name, String account_number, String phone, String password, float money, JSONArray history) {
        this.id = id;
        this.name = name;
        this.account_number = account_number;
        this.phone = phone;
        this.password = password;
        this.money = money;
        this.history = history;
    }

    public DataModel() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public JSONArray getHistory() {
        return history;
    }

    public void setHistory(JSONArray history) {
        this.history = history;
    }
}
