package data;

import data.MysqlConnect;

public class Main {
    public static void main(String[] args) throws Exception {
        MysqlConnect dao = new MysqlConnect();
        dao.readDataBase();
    }

}