CREATE TABLE IF NOT EXISTS eventos_outbox (
    id SERIAL PRIMARY KEY,
    destino VARCHAR(300),
    payload varchar,
    momento timestamp
)