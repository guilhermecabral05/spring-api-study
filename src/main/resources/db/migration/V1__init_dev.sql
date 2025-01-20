CREATE EXTENSION IF NOT EXISTS "pgcrypto";
-- Migration: Criação da tabela `suppliers`
CREATE TABLE suppliers (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL
);

-- Migration: Criação da tabela `products` associada aos `suppliers`
CREATE TABLE products (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    supplier_id UUID,
    CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES suppliers (id) ON DELETE CASCADE
);
