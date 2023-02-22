package com.company.repositories;

import com.company.repositories.interfaces.ICartRepository;
import com.company.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepository implements ICartRepository {
    private final IDB db;

    public CartRepository(IDB db) {
        this.db = db;
    }


    @Override
    public boolean buyClothes(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM clothes WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            int amount = 0;
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                amount = rs.getInt("amount");
            }
            if (amount <= 0) {
                return false;
            }

            sql = "UPDATE clothes SET amount=? WHERE id=?";
            st = con.prepareStatement(sql);

            st.setInt(1,amount-1);
            st.setInt(2,id);

            st.execute();
            return true;
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
        return false;
    }
}
