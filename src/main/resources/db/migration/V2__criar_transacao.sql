CREATE TABLE IF NOT EXISTS transacao (
    id_transacao UUID PRIMARY KEY,
    momento_transacao TIMESTAMP,
    estabelecimento VARCHAR(100),
    valor NUMERIC,
    id_cartao UUID,
    qtd_parcelas NUMERIC,
    UNIQUE(momento_transacao, estabelecimento, valor, id_cartao)
)