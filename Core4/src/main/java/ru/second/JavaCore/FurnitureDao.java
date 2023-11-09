package ru.second.JavaCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO (Data Access Object) для работы с мебелью.
 */
@Repository
public class FurnitureDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Добавляет новую мебель в базу данных.
     * @param furniture мебель для добавления.
     */
    public void addFurniture(Furniture furniture) {
        String sql = "INSERT INTO furniture (name, material, style, price, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, furniture.getName(), furniture.getMaterial(), furniture.getStyle(), furniture.getPrice(), furniture.getQuantity());
    }

    /**
     * Возвращает список всех мебельных предметов из базы данных.
     * @return список мебели.
     */
    public List<Furniture> getAllFurniture() {
        String sql = "SELECT * FROM furniture";
        return jdbcTemplate.query(sql, new FurnitureRowMapper());
    }

    /**
     * Обновляет информацию о мебели по идентификатору.
     * @param id идентификатор мебели для обновления.
     * @param updatedFurniture обновленная информация о мебели.
     */
    public void updateFurniture(Integer id, Furniture updatedFurniture) {
        String sql = "UPDATE furniture SET name=?, material=?, style=?, price=?, quantity=? WHERE id=?";
        jdbcTemplate.update(sql, updatedFurniture.getName(), updatedFurniture.getMaterial(), updatedFurniture.getStyle(),
                updatedFurniture.getPrice(), updatedFurniture.getQuantity(), id);
    }

    /**
     * Удаляет мебель из базы данных по идентификатору.
     * @param id идентификатор мебели для удаления.
     */
    public void deleteFurniture(Integer id) {
        String sql = "DELETE FROM furniture WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Осуществляет поиск мебели по заданному полю и значению.
     * @param field поле для поиска.
     * @param value значение для поиска.
     * @return список мебели, соответствующий критериям поиска.
     */
    public List<Furniture> searchFurniture(String field, String value) {
        String sql = "SELECT * FROM furniture WHERE LOWER(" + field + ") LIKE ?";
        return jdbcTemplate.query(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + value.toLowerCase() + "%");
            return ps;
        }, new FurnitureRowMapper());
    }

    /**
     * Маппер для преобразования результата запроса в объект Furniture.
     */
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