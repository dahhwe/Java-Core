-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS furniture (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    material VARCHAR(255),
    style VARCHAR(255),
    price DECIMAL,
    quantity INT
    );

-- Insert sample data
INSERT INTO furniture (name, material, style, price, quantity)
VALUES
    ('Table', 'wood', 'Modern', 10000, 1),
    ('Chair', 'wood', 'Classic', 5000, 4),
    ('Sofa', 'leather', 'Modern', 15000, 2),
    ('Bed', 'wood', 'Rustic', 12000, 1),
    ('Wardrobe', 'wood', 'Victorian', 25000, 1),
    ('Coffee Table', 'glass', 'Contemporary', 6000, 1),
    ('Bookshelf', 'wood', 'Modern', 7000, 2),
    ('Nightstand', 'wood', 'Classic', 3500, 2);
