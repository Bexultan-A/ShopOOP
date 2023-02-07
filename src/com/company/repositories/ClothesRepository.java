package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.ClothesShop;
import com.company.entities.Clothing;
import com.company.repositories.interfaces.IClothesRepository;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClothesRepository implements IClothesRepository {
    private final IDB db;

    public ClothesRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createClothing(Clothing clothing) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO clothes(shopName,seasonName,styleName,genderName,ageName,typeName,name,price,color,amount) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, clothing.getShopName());
            st.setString(2, clothing.getSeasonName());
            st.setString(3, clothing.getStyleName());
            st.setString(4, clothing.getGender());
            st.setString(5, clothing.getAgeName());
            st.setString(6, clothing.getTypeName());
            st.setString(7, clothing.getName());
            st.setDouble(8, clothing.getPrice());
            st.setString(9, clothing.getColor());
            st.setInt(10, clothing.getAmount());

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

    @Override
    public List<Clothing> getAllClothes() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,color,amount FROM clothes";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Clothing> clothes = new LinkedList<>();
            while (rs.next()) {
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
    public Clothing getClothingByID(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,color,amount FROM clothes WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);


            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Clothing clothing = new Clothing(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("color"),
                        rs.getInt("amount"));
                return clothing;
            }
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
    public Clothing getClothingByName(String name) {
        return null;
    }
}
