package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Clothing;
import com.company.repositories.interfaces.IFilterRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilterRepository implements IFilterRepository {
    private final IDB db;

    public FilterRepository(IDB db) {
        this.db = db;
    }


    @Override
    public List<Clothing> getClothesByFilter(ArrayList<String> filters, ArrayList<String> filterName) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM clothes WHERE";
            sql = sql + " " + filters.get(0) + "=" + "?";
            for (int i = 1; i < filters.size(); i++) {
                sql = sql + " " + "and" + " " + filters.get(i) + "=" + "?";
            }
            PreparedStatement st = con.prepareStatement(sql);

            for (int i= 1; i <= filterName.size(); i++) {
                st.setString(i, filterName.get(i-1));
            }

            ResultSet rs = st.executeQuery();
            List<Clothing> clothes = new LinkedList<>();
            while(rs.next()) {
                Clothing clothing = new Clothing(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("color"),
                        rs.getInt("amount"));

                clothes.add(clothing);
            }
            return clothes;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }
}
