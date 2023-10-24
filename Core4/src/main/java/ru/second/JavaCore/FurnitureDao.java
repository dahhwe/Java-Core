package ru.second.JavaCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FurnitureDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addFurniture(Furniture furniture) {
        String sql = "INSERT INTO furniture (name, material, style, price, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, furniture.getName(), furniture.getMaterial(), furniture.getStyle(), furniture.getPrice(), furniture.getQuantity());
    }

    public List<Furniture> getAllFurniture() {
        String sql = "SELECT * FROM furniture";
        return jdbcTemplate.query(sql, new FurnitureRowMapper());
    }

    public void updateFurniture(Integer id, Furniture updatedFurniture) {
        String sql = "UPDATE furniture SET name=?, material=?, style=?, price=?, quantity=? WHERE id=?";
        jdbcTemplate.update(sql, updatedFurniture.getName(), updatedFurniture.getMaterial(), updatedFurniture.getStyle(),
                updatedFurniture.getPrice(), updatedFurniture.getQuantity(), id);
    }

    public void deleteFurniture(Integer id) {
        String sql = "DELETE FROM furniture WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<Furniture> searchFurniture(String field, String value) {
        String sql = "SELECT * FROM furniture WHERE LOWER(" + field + ") LIKE ?";
        return jdbcTemplate.query(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + value.toLowerCase() + "%");
            return ps;
        }, new FurnitureRowMapper());
    }

    private static class FurnitureRowMapper implements RowMapper<Furniture> {

        @Override
        public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
            Furniture furniture = new Furniture();
            furniture.setId(rs.getInt("id"));
            furniture.setName(rs.getString("name"));
            furniture.setMaterial(rs.getString("material"));
            furniture.setStyle(rs.getString("style"));
            furniture.setPrice(rs.getDouble("price"));
            furniture.setQuantity(rs.getInt("quantity"));
            return furniture;
        }
    }
}
