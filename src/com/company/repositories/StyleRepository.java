package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Clothing;
import com.company.entities.Style;
import com.company.repositories.interfaces.IStyleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StyleRepository implements IStyleRepository {
    public final IDB db;

    public StyleRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<Clothing> getClothesByStyle(String styleName) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM clothes WHERE styleName=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, styleName);

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

    @Override
    public Style getAllStyles() {
        return null;
    }
}
